package connection.rxconnection.connection;

import android.content.Context;

import java.lang.reflect.ParameterizedType;

import connection.rxconnection.model.BaseResponse;
import lombok.Getter;
import okhttp3.Headers;
import okhttp3.MediaType;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by AndreHF on 4/12/2017.
 */

public class HttpRequest<REQUEST, RESPONSE extends BaseResponse> implements HandleErrorConnection,Observable.OnSubscribe<BaseResponse<RESPONSE>> {
    private REQUEST request;
    private OKHttpConnection<REQUEST, RESPONSE> teokHttpConnection;
    @Getter
    private final Context context;
    private MediaType mediaType;
    private Class<RESPONSE> eClass;
    private final String url;
    private final int httpMethod;
    private Subscriber<? super BaseResponse<RESPONSE>> subscriber;

    public HttpRequest<REQUEST, RESPONSE> setHeader(Headers header) {
        this.header = header;
        return this;
    }

    private Headers header;

    public HttpRequest(REQUEST request, Context context, Class<RESPONSE> resultClass, String url,
                       int httpMethod) {
        this.request = request;
        this.context = context;
        this.eClass = resultClass;
        this.url = url;
        this.httpMethod = httpMethod;
        teokHttpConnection = new OKHttpConnection(this);
        this.mediaType = MediaType.parse(org.androidannotations.api.rest.MediaType.
                APPLICATION_JSON
                + "; charset=utf-8");
    }

    public HttpRequest(Context context, Class<RESPONSE> resultClass, String url, int httpMethod) {
        this.context = context;
        this.eClass = resultClass;
        this.url = url;
        this.httpMethod = httpMethod;
        teokHttpConnection = new OKHttpConnection(this);
        this.mediaType = MediaType.parse(org.androidannotations.api.rest.MediaType.APPLICATION_JSON
                + "; charset=utf-8");
    }

    public HttpRequest<REQUEST, RESPONSE> setMediaType(String mediaType) {
        this.mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        return this;
    }




    @Override
    public void call(Subscriber<? super BaseResponse<RESPONSE>> subscriber) {
        this.subscriber = subscriber;
        BaseResponse<RESPONSE> response = null;
        try {
            response = teokHttpConnection.data(request, url, eClass, httpMethod, mediaType, context,header);
        } catch (Exception e) {
            e.printStackTrace();
            response = new BaseResponse<>();
            response.setMsg(e.getMessage());
        }
        subscriber.onNext(response);
    }

    @Override
    public void error(ExceptionHttpRequest exceptionHttpRequest) {
        subscriber.onError(exceptionHttpRequest);
    }

}
