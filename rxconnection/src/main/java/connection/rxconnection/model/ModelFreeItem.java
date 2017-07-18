package connection.rxconnection.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by AndreHF on 4/17/2017.
 */

@Data
public class ModelFreeItem {
    private boolean status;
    @SerializedName("voucher_code")
    private String voucherCode;
    @SerializedName("voucher_description")
    private String voucherDescription;
    @SerializedName("qr_code")
    private String qrCode;

}
