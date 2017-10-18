package agiletool.msc.bme.hu.agiletoolandroidclient.interactor;

import java.io.IOException;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.wrappers.DashboardResolving;
import agiletool.msc.bme.hu.agiletoolandroidclient.network.BacklogApi;
import agiletool.msc.bme.hu.agiletoolandroidclient.network.DashboardApi;
import agiletool.msc.bme.hu.agiletoolandroidclient.network.model.UserResponse;
import retrofit2.Call;
import retrofit2.Response;

public class BacklogInteractor {

    @Inject
    BacklogApi backlogApi;

    public BacklogInteractor() {
        AgileToolApplication.agileToolApplicationComponent.inject(this);
    }

    public UserResponse getUsers(String projectId) {
        Call<UserResponse> artistsQueryCall = backlogApi.getUsers(projectId, projectId);
        Response<UserResponse> response;
        try {
            response = artistsQueryCall.execute();

            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
