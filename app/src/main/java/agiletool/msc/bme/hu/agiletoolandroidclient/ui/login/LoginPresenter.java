package agiletool.msc.bme.hu.agiletoolandroidclient.ui.login;


import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.interactor.LoginInteractor;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.RxPresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginPresenter extends RxPresenter<LoginScreen> {

    @Inject
    LoginInteractor loginInteractor;

    public LoginPresenter() {
        AgileToolApplication.agileToolApplicationComponent.inject(this);
    }

    public void login(String username, String password) {
        subscribe(observable(() -> loginInteractor.login(username, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::loginHandler, Throwable::printStackTrace));
    }

    private void loginHandler(String sessionId) {
        screen.login(sessionId);
    }
}
