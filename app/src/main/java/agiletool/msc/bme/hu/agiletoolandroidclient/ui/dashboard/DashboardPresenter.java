package agiletool.msc.bme.hu.agiletoolandroidclient.ui.dashboard;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.interactor.DashboardInteractor;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.wrappers.DashboardResolving;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.RxPresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DashboardPresenter extends RxPresenter<DashboardScreen> {

    @Inject
    DashboardInteractor dashboardInteractor;

    public DashboardPresenter() {
        AgileToolApplication.agileToolApplicationComponent.inject(this);
    }

    public void getDashboard(String projectId) {
        subscribe(observable(() -> dashboardInteractor.getProjectDashnoard(projectId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setDashboard, Throwable::printStackTrace));
    }

    private void setDashboard(DashboardResolving dashboardResolving) {
        screen.setDashboard(dashboardResolving);
    }
}
