package com.pawoon.test.presenter.custom.typeface;

import android.content.Context;


public class CustomTypeFaceLight extends BaseCustomTypeFace {
    public CustomTypeFaceLight(Context context) {
        super(context);
        typeface = readFont.light();
    }
}
