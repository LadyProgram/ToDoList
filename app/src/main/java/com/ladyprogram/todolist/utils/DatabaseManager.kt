package com.ladyprogram.todolist.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.ladyprogram.todolist.data.Task

class DatabaseManager(context: Context) : SQLiteOpenHelper(context,
    DATABASE_NAME,null,
    DATABASE_VERSION
) {

    companion object {
        const val DATABASE_NAME = "todolist.db"
        const val DATABASE_VERSION = 1

        private const val SQL_CREATE_TABLE_TASK =
            "CREATE TABLE ${Task.TABLE_NAME} (" +
                    "${Task.COLUMN_NAME_ID} INTERGER PRIMARY KEY," +
                    "${Task.COLUMN_NAME_TITLE} TEXT," +
                    "${Task.COLUMN_NAME_DONE} BOOLEAN)"

        private const val SQL_DROP_TABLE_TASK = "DROP TABLE IF EXISTS ${Task.TABLE_NAME}"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_TASK)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onDestroy(db)
        onCreate(db)
    }

    private fun onDestroy(db: SQLiteDatabase) {
        db.execSQL(SQL_DROP_TABLE_TASK)
    }

}