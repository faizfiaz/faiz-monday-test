package connection.rxconnection.model;

import lombok.Data;

/**
 * Created by AndreHF on 1/27/2017.
 */
@Data
public class BaseResponse<E> {
    private String msg;
    private int code;
    private E data;

    public BaseResponse<E> setCode(int code) {
        this.code = code;
        return this;
    }
}
