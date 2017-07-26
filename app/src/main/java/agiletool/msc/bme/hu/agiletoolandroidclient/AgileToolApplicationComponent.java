package agiletool.msc.bme.hu.agiletoolandroidclient;

import javax.inject.Singleton;

import agiletool.msc.bme.hu.agiletoolandroidclient.interactor.InteractorModule;
import agiletool.msc.bme.hu.agiletoolandroidclient.reposirotry.RepositoryModule;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.UIModule;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.login.LoginActivity;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.login.LoginPresenter;
import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface AgileToolApplicationComponent {
    //Application inject
    void inject(AgileToolApplication agileToolApplication);

    //Activity injection
    void inject(LoginActivity loginActivity);

    //Presenter injection
    void inject(LoginPresenter loginPresenter);

    //Inter actor injection


}
