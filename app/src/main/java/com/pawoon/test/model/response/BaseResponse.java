package com.pawoon.test.model.response;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by faizf on 2/8/2017.
 */
@Data
public class BaseResponse<DATA, ERROR> implements Serializable {
    private int status;
    private String path;
    private String message;
    private String[] errors;
    private String newAuthToken;
    private ERROR error;
    DATA data;
}
