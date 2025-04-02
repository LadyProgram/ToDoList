package com.ladyprogram.todolist.data

class Task (
    var id: Long,
    var title: String,
    var done: Boolean = false
    // Al poner = false coge ese parámetro por defecto
) {


    companion object {
        const val TABLE_NAME = "Task"

        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_DONE = "done"
    }
}