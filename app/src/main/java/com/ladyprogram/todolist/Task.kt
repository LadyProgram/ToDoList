package com.ladyprogram.todolist

class Task (
    val id: Long,
    val title: String,
    val done: Boolean
) {


    companion object {
        const val TABLE_NAME = "Task"

        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_DONE = "done"
    }
}