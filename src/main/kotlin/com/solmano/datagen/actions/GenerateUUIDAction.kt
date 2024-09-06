package com.solmano.datagen.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.CaretModel
import java.util.*

class GenerateUUIDAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val project = event.project ?: return
        val editor = event.getData(com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR) ?: return

        WriteCommandAction.runWriteCommandAction(project) {
            val caretModel: CaretModel = editor.caretModel
            editor.document.insertString(caretModel.offset, UUID.randomUUID().toString())
        }
    }
}
