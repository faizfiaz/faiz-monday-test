package com.pawoon.test.presenter.custom.typeface;

import android.content.Context;


public class CustomTypeFaceItalic extends BaseCustomTypeFace {
    public CustomTypeFaceItalic(Context context) {
        super(context);
        typeface = readFont.italic();
    }
}
