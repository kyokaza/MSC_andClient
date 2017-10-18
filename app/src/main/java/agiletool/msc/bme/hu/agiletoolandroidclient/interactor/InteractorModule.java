package agiletool.msc.bme.hu.agiletoolandroidclient.interactor;


import dagger.Module;
import dagger.Provides;
import dagger.producers.ProducerModule;

@Module
public class InteractorModule {

    @Provides
    public LoginInteractor provideLoginInteractor() {
        return new LoginInteractor();
    }

    @Provides
    public ProjectInteractor provideProjectInteractor() {
        return new ProjectInteractor();
    }

    @Provides
    public DashboardInteractor provideDashboardInteractor(){
        return new DashboardInteractor();
    }

    @Provides
    public BacklogInteractor provideBacklogInteractor(){
        return new BacklogInteractor();
    }
}
