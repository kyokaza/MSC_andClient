package agiletool.msc.bme.hu.agiletoolandroidclient;


import android.app.Application;



import agiletool.msc.bme.hu.agiletoolandroidclient.network.NetworkModule;
import agiletool.msc.bme.hu.agiletoolandroidclient.persistence.DbModule;

public class AgileToolApplication extends Application {

    public static AgileToolApplicationComponent agileToolApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        agileToolApplicationComponent = DaggerAgileToolApplicationComponent.builder()
                .networkModule(new NetworkModule())
                .dbModule(new DbModule(this))
                .build();
    }
}
