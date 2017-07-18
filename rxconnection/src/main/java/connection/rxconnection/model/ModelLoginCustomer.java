package connection.rxconnection.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by AndreHF on 4/17/2017.
 */

@Data
public class ModelLoginCustomer {
    private ModelCustomer customer;
    @SerializedName("free_item")
    private ModelFreeItem freeItem;
    @SerializedName("is_complete")
    private boolean isComplete;
}
