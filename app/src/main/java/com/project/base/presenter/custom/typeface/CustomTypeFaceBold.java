package com.project.base.presenter.custom.typeface;

import android.content.Context;


public class CustomTypeFaceBold extends BaseCustomTypeFace {
    public CustomTypeFaceBold(Context context) {
        super(context);
        typeface = readFont.bold();
    }
}
