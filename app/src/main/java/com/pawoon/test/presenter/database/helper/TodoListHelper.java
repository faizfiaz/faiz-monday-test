package com.pawoon.test.presenter.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pawoon.test.model.entity.ModelTodoList;
import com.pawoon.test.presenter.database.table.TodoListTable;

import java.util.ArrayList;

/**
 * Created by faizf on 07/05/2018.
 */

public class TodoListHelper extends SQLiteOpenHelper {

    //db version for next update purpose
    private static final int DATABASE_VERSION = 1;

    //db name
    private static final String DATABASE_NAME = "todo_list_db";

    //default construct
    public TodoListHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //creating tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(TodoListTable.CREATE_TABLE);
    }

    //upgrading db
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //if exist delete!
        db.execSQL("DROP TABLE IF EXISTS " + TodoListTable.TABLE_NAME);

        //create again
        onCreate(db);
    }

    public boolean insertTodoList(ArrayList<ModelTodoList> data) {
        // open db
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        //need looping in this part
        for (ModelTodoList item : data){
            ContentValues values = new ContentValues();
            values.put(TodoListTable.COLUMN_USER_ID, item.getUserId());
            values.put(TodoListTable.COLUMN_ID, item.getId());
            values.put(TodoListTable.COLUMN_TITLE, item.getTitle());
            values.put(TodoListTable.COLUMN_COMPLETE, (item.isCompleted())? 1 : 0);

            //insert per row
            db.insert(TodoListTable.TABLE_NAME, null, values);
        }

        // close db connection
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();

        return true;
    }

    public ArrayList<TodoListTable> getAllTodoList() {
        ArrayList<TodoListTable> arrays = new ArrayList<>();

        //select all query
        String selectQuery = "SELECT  * FROM " + TodoListTable.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping all
        if (cursor.moveToFirst()) {
            do {
                TodoListTable item = new TodoListTable();
                item.setUserId(cursor.getInt(cursor.getColumnIndex(TodoListTable.COLUMN_USER_ID)));
                item.setId(cursor.getInt(cursor.getColumnIndex(TodoListTable.COLUMN_ID)));
                item.setTitle(cursor.getString(cursor.getColumnIndex(TodoListTable.COLUMN_TITLE)));
                item.setCompleted(cursor.getInt(cursor.getColumnIndex(TodoListTable.COLUMN_COMPLETE)));

                arrays.add(item);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return arrays;
    }

    public int getTodoListCount() {
        String countQuery = "SELECT  * FROM " + TodoListTable.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

}
