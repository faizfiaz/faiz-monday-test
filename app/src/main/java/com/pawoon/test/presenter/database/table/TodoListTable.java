package com.pawoon.test.presenter.database.table;

import lombok.Data;

/**
 * Created by faizf on 07/05/2018.
 */
@Data
public class TodoListTable {

    public static final String TABLE_NAME = "table_todo_list";

    public static final String COLUMN_USER_ID = "userId";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_COMPLETE = "complete";

    private int userId;
    private int id;
    private String title;
    private int completed;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_USER_ID + " INTEGER,"
                    + COLUMN_ID + " INTEGER,"
                    + COLUMN_TITLE + " TEXT,"
                    + COLUMN_COMPLETE + " INTEGER"
                    + ")";

    public TodoListTable() {

    }

    public TodoListTable(int userId, int id, String title, int completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
}