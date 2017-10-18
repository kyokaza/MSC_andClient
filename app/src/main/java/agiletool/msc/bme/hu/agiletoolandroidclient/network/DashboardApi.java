package agiletool.msc.bme.hu.agiletoolandroidclient.network;


import agiletool.msc.bme.hu.agiletoolandroidclient.model.wrappers.DashboardResolving;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DashboardApi {

    @GET("api/project/{id}/dashboard")
    Call<DashboardResolving> getProjectDashboard(@Path("id") String projectId);
}
