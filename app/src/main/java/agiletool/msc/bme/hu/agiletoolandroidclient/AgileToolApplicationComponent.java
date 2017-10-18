package agiletool.msc.bme.hu.agiletoolandroidclient;


import javax.inject.Singleton;

import agiletool.msc.bme.hu.agiletoolandroidclient.interactor.BacklogInteractor;
import agiletool.msc.bme.hu.agiletoolandroidclient.interactor.DashboardInteractor;
import agiletool.msc.bme.hu.agiletoolandroidclient.interactor.InteractorModule;
import agiletool.msc.bme.hu.agiletoolandroidclient.interactor.LoginInteractor;
import agiletool.msc.bme.hu.agiletoolandroidclient.interactor.ProjectInteractor;
import agiletool.msc.bme.hu.agiletoolandroidclient.network.AddCookiesInterceptor;
import agiletool.msc.bme.hu.agiletoolandroidclient.network.NetworkModule;
import agiletool.msc.bme.hu.agiletoolandroidclient.persistence.DbModule;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.UIModule;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.backlog.BackLogActivity;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.backlog.BacklogPresenter;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.dashboard.DashboardActivity;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.dashboard.DashboardPresenter;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.login.LoginActivity;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.login.LoginPresenter;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.projects.ProjectsActivity;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.projects.ProjectsPresenter;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, InteractorModule.class, UIModule.class, DbModule.class})
public interface AgileToolApplicationComponent {

    void inject(LoginInteractor loginInteractor);

    void inject(LoginPresenter loginPresenter);

    void inject(LoginActivity loginActivity);

    void inject(ProjectInteractor projectInteractor);

    void inject(ProjectsPresenter projectsPresenter);

    void inject(AddCookiesInterceptor addCookiesInterceptor);

    void inject(ProjectsActivity projectsActivity);

    void inject(DashboardInteractor dashboardInteractor);

    void inject(DashboardPresenter dashboardPresenter);

    void inject(DashboardActivity dashboardActivity);

    void inject(BackLogActivity backLogActivity);

    void inject(BacklogPresenter backlogPresenter);

    void inject(BacklogInteractor backlogInteractor);
}
