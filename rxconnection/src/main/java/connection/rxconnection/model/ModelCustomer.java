package connection.rxconnection.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by AndreHF on 4/17/2017.
 */

@Data
public class ModelCustomer {
    private String id;
    private String fid;
    private String fullname;
    private String email;
    private String latitude;
    private String longitude;
    private int point;
    private String image;
    @SerializedName("referral_code")
    private String referralCode;
    @SerializedName("qr_referral_code")
    private String qrReferralCode;
    @SerializedName("qr_code")
    private String qrCode;
}
