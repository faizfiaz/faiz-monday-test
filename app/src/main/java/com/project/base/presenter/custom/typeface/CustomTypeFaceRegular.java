package com.project.base.presenter.custom.typeface;

import android.content.Context;


public class CustomTypeFaceRegular extends BaseCustomTypeFace {
    public CustomTypeFaceRegular(Context context) {
        super(context);
        typeface = readFont.regular();
    }
}
