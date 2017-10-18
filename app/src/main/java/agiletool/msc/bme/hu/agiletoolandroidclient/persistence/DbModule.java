package agiletool.msc.bme.hu.agiletoolandroidclient.persistence;


import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    private Application application;

    public DbModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public SharedPreferencesHelper provideSharedPreferencesHelper() {
        return new SharedPreferencesHelper(application);
    }
}
