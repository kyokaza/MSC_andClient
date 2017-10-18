package agiletool.msc.bme.hu.agiletoolandroidclient.interactor;

import java.io.IOException;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.wrappers.DashboardResolving;
import agiletool.msc.bme.hu.agiletoolandroidclient.network.DashboardApi;
import retrofit2.Call;
import retrofit2.Response;


public class DashboardInteractor {

    @Inject
    DashboardApi dashboardApi;

    public DashboardInteractor() {
        AgileToolApplication.agileToolApplicationComponent.inject(this);
    }

    public DashboardResolving getProjectDashnoard(String projectId) {
        Call<DashboardResolving> artistsQueryCall = dashboardApi.getProjectDashboard(projectId);
        Response<DashboardResolving> response;
        try {
            response = artistsQueryCall.execute();

            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
