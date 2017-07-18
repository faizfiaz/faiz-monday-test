package com.project.base.presenter.utils;

import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.EBean;

/**
 * Created by faizf on 2/10/2017.
 */
@EBean
public class UtilsLayout {
    public String getBodyText(TextView textView) {
        return textView.getText().toString();
    }

    public String getText(EditText editText){ return editText.getText().toString(); }
}
