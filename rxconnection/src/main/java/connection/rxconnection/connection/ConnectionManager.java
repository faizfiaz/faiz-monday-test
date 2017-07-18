package connection.rxconnection.connection;

import android.app.Activity;
import android.app.ProgressDialog;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import lombok.Setter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by AndreHF on 4/12/2017.
 */

@EBean
public class ConnectionManager implements CallBackSubscriber {
    @RootContext
    protected Activity activity;
    @Setter
    private ConnectionListener connectionListener;

    private ProgressDialog progressDialog;

    protected void subscribe(HttpRequest httpRequest) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(activity);
        }
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
        Observable.create(httpRequest)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new BaseServiceResponse(connectionListener).setCallBackSubscriber(this));
    }

    @Override
    public void onServiceFinish() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
