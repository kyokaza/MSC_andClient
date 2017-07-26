package agiletool.msc.bme.hu.agiletoolandroidclient.reposirotry;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Singleton
    @Provides
    public Repository provideRepository() {
        return null;
    }
}
