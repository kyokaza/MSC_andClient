package agiletool.msc.bme.hu.agiletoolandroidclient.network;


import java.util.List;

import agiletool.msc.bme.hu.agiletoolandroidclient.model.Project;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.User;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProjectApi {

    @GET("/api/is-signed-in")
    Call<User> getCurrentUser();

    @POST("/api/project/find")
    Call<List<Project>> getProjects(@Body RequestBody projectIds);
}
