package agiletool.msc.bme.hu.agiletoolandroidclient.network;


import java.io.IOException;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.helper.Constants;
import agiletool.msc.bme.hu.agiletoolandroidclient.persistence.SharedPreferencesHelper;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookiesInterceptor implements Interceptor {

    @Inject
    SharedPreferencesHelper sharedPreferencesHelper;

    public AddCookiesInterceptor() {
        AgileToolApplication.agileToolApplicationComponent.inject(this);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("Cookie", "JSESSIONID=" + sharedPreferencesHelper.getItem(Constants.PREFERENCES_SESSION_ID));

        if (!chain.request().url().equals(NetworkConfig.ENDPOINT_ADDRESS)) {
            builder.addHeader("Content-Type", "application/json");
        }

        return chain.proceed(builder.build());
    }
}
