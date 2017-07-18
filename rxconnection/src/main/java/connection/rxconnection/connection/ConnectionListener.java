package connection.rxconnection.connection;

/**
 * Created by AndreHF on 1/27/2017.
 */

public interface ConnectionListener {
    void onSuccessWithData(Object o);
    void onSuccessNull();
    void onError(Object o);
    void onMessageOnly(String message);
    void unAuthorized();
}
