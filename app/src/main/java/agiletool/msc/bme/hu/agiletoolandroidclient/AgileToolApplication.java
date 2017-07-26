package agiletool.msc.bme.hu.agiletoolandroidclient;

import android.app.Application;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.ui.UIModule;

import agiletool.msc.bme.hu.agiletoolandroidclient.reposirotry.Repository;

public class AgileToolApplication extends Application {

    public static AgileToolApplicationComponent injector;
    @Inject
    Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();

//        injector =
//                DaggerMobSoftApplicationComponent.builder().
//                        uIModule(
//                                new UIModule(this)
//                        ).build();
    }

    public void setInjector(AgileToolApplicationComponent injector) {
        AgileToolApplication.injector = injector;
        injector.inject(this);
        repository.open(getApplicationContext());
    }
}
