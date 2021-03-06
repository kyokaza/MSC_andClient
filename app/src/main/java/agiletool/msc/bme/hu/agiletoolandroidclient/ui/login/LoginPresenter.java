package agiletool.msc.bme.hu.agiletoolandroidclient.ui.login;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.ui.Presenter;
import de.greenrobot.event.EventBus;

import static agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication.injector;

public class LoginPresenter extends Presenter<LoginScreen> {
//    @Inject
//    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus eventBus;

    public LoginPresenter() {
    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        eventBus.register(this);
    }

    @Override
    public void detachScreen() {
        eventBus.unregister(this);
        super.detachScreen();
    }

//    public void startLogin(final User user) {
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                userInteractor.startLogin(user);
//            }
//        });
//    }


//    public void onEventMainThread(StartLoginEvent event) {
//        if (event.getThrowable() != null) {
//            event.getThrowable().printStackTrace();
//            if (screen != null) {
//                screen.showMessage("error");
//            }
//            Log.e("Networking", "Error reading favourites", event.getThrowable());
//        } else {
//            if (screen != null) {
//                screen.loginSuccess();
//            }
//        }
//    }

}
