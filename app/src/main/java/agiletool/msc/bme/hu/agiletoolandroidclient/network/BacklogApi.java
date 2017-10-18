package agiletool.msc.bme.hu.agiletoolandroidclient.network;

import agiletool.msc.bme.hu.agiletoolandroidclient.network.model.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BacklogApi {

    @GET("api/user/search/findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase")
    Call<UserResponse> getUsers(@Query("firstName") String firstName, @Query("lastName") String lastName);
}
