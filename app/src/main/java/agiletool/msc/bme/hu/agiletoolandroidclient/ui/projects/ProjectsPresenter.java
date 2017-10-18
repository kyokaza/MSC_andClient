package agiletool.msc.bme.hu.agiletoolandroidclient.ui.projects;


import java.util.List;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.interactor.ProjectInteractor;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.Project;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.User;
import agiletool.msc.bme.hu.agiletoolandroidclient.persistence.SharedPreferencesHelper;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.RxPresenter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static agiletool.msc.bme.hu.agiletoolandroidclient.helper.Constants.PREFERENCES_USERNAME;

public class ProjectsPresenter extends RxPresenter<ProjectsScreen> {

    @Inject
    ProjectInteractor projectInteractor;

    @Inject
    SharedPreferencesHelper sharedPreferencesHelper;

    public ProjectsPresenter() {
        AgileToolApplication.agileToolApplicationComponent.inject(this);
    }

    public void getProjects() {
        String username = sharedPreferencesHelper.getItem(PREFERENCES_USERNAME);
        subscribe(observable(() -> projectInteractor.getUser(username))
                .subscribeOn(Schedulers.io())
                .map(User::getProjects)
                .flatMap(stringList -> Observable.just(projectInteractor.getProjects(stringList)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleProjects, Throwable::printStackTrace));
    }

    private void handleProjects(List<Project> projects) {
        screen.setProjects(projects);
    }
}
