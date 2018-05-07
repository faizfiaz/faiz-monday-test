package com.pawoon.test.model.entity;

import lombok.Data;

/**
 * Created by faizf on 07/05/2018.
 */
@Data
public class ModelTodoList {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
