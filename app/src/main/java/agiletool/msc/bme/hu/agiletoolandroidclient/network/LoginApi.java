package agiletool.msc.bme.hu.agiletoolandroidclient.network;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginApi {
    @FormUrlEncoded
    @POST("/")
    Call<Void> login(@FieldMap Map<String, String> params);
}
