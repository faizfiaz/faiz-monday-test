package connection.rxconnection.connection;

import java.lang.reflect.ParameterizedType;

/**
 * Created by AndreHF on 5/18/2017.
 */

public class GetClassGeneric<T> {
    public Class<T> getClassT(){
        return (Class<T>) (((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0].getClass());
    }
}
