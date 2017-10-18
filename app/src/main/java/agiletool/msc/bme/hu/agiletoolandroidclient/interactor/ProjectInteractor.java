package agiletool.msc.bme.hu.agiletoolandroidclient.interactor;


import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.Project;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.User;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.wrappers.ArrayListProjects;
import agiletool.msc.bme.hu.agiletoolandroidclient.network.ProjectApi;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

public class ProjectInteractor {

    @Inject
    ProjectApi projectApi;

    public ProjectInteractor() {
        AgileToolApplication.agileToolApplicationComponent.inject(this);
    }

    public User getUser(String username) {
        Call<User> artistsQueryCall = projectApi.getCurrentUser();
        Response<User> response;
        try {
            response = artistsQueryCall.execute();

            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Project> getProjects(List<String> projectIds) {
        Gson gson = new Gson();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),gson.toJson(projectIds));
        Call<List<Project>> artistsQueryCall = projectApi.getProjects(requestBody);
        Response<List<Project>> response;
        try {
            response = artistsQueryCall.execute();

            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
