package com.project.base.presenter.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import lombok.Setter;

/**
 * Created by faizf on 4/27/2017.
 */
@EBean
public class DialogManager {

    @RootContext
    protected Activity activity;
    @Setter
    private FragmentManager fragmentManager;

    public void errorDialog(String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {

                    }
                });

        final AlertDialog alert = builder.create();
        alert.show();
    }

}
