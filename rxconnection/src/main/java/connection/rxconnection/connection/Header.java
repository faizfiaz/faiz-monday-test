package connection.rxconnection.connection;

import android.content.Context;

import connection.rxconnection.model.ModelLoginCustomer;
import connection.rxconnection.session.SessionUser;
import okhttp3.Headers;

/**
 * Created by AndreHF on 4/12/2017.
 */

public class Header {
    protected Headers headers(Context context) {
        Headers.Builder builder = new Headers.Builder();
        ModelLoginCustomer modelLoginCustomer = new SessionUser(context).getUser();
        if (modelLoginCustomer != null) {
            builder.add("customer_code", modelLoginCustomer.getCustomer().getId());
        }
        builder.add("Authorization", "Bearer VANIX8Q0");
        builder.add("X-API-KEY", "1899cfe0b22821wowappsscde43435749f06ab2d");
        builder.add("token", "46937e695f02d3284f0df8a95c4ec68c64637ff8477GQ");
        return builder.build();
    }

}
