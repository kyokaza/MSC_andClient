package agiletool.msc.bme.hu.agiletoolandroidclient.ui;


import agiletool.msc.bme.hu.agiletoolandroidclient.ui.backlog.BacklogPresenter;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.dashboard.DashboardPresenter;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.login.LoginPresenter;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.projects.ProjectsPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {

    @Provides
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    public ProjectsPresenter provideProjectsPresenter() {
        return new ProjectsPresenter();
    }

    @Provides
    public DashboardPresenter provideDashboardPresenter() {
        return new DashboardPresenter();
    }

    @Provides
    public BacklogPresenter provideBacklogPresenter(){
        return new BacklogPresenter();
    }

}
