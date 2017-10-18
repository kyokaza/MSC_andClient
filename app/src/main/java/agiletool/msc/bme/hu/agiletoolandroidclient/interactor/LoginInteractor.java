package agiletool.msc.bme.hu.agiletoolandroidclient.interactor;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.network.LoginApi;
import retrofit2.Call;
import retrofit2.Response;

public class LoginInteractor {

    @Inject
    LoginApi loginApi;

    public LoginInteractor() {
        AgileToolApplication.agileToolApplicationComponent.inject(this);
    }

    public String login(String username, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        Call<Void> artistsQueryCall = loginApi.login(map);
        Response<Void> response;
        try {
            response = artistsQueryCall.execute();

            return response.headers().get("Set-Cookie");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
