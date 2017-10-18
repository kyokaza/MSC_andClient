package agiletool.msc.bme.hu.agiletoolandroidclient.ui.backlog;

import java.util.List;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.interactor.BacklogInteractor;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.User;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.wrappers.UserWrapper;
import agiletool.msc.bme.hu.agiletoolandroidclient.network.model.UserResponse;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.RxPresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BacklogPresenter extends RxPresenter<BacklogScreen> {

    @Inject
    BacklogInteractor backlogInteractor;

    public BacklogPresenter() {
        AgileToolApplication.agileToolApplicationComponent.inject(this);
    }

    public void getUsers(String name){
        subscribe(observable(() -> backlogInteractor.getUsers(name))
                .subscribeOn(Schedulers.io())
                .map(UserResponse::get_embedded)
                .map(UserWrapper::getUsers)
       .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::setUsers, Throwable::printStackTrace));
    }

    private void setUsers(List<User> userList){
        userList.size();
    }
}
