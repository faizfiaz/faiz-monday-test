package com.pawoon.test.presenter.custom.textview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

import com.pawoon.test.presenter.utils.ReadFont;

public class CustomTextViewItalic extends TextView {
    private ReadFont readFont;

    public CustomTextViewItalic(Context context) {
        super(context);
        setFont(context);
    }

    public CustomTextViewItalic(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);

    }

    public CustomTextViewItalic(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomTextViewItalic(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setFont(context);

    }


    protected void setFont(Context context) {
        readFont = new ReadFont(context);
        setTypeface(readFont.italic());
    }


}
