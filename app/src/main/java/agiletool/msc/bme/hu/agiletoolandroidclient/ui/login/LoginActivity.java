package agiletool.msc.bme.hu.agiletoolandroidclient.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.R;

public class LoginActivity extends AppCompatActivity implements LoginScreen  {

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        AgileToolApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detachScreen();
    }

    @Override
    public void loginSuccess() {
//        Intent intent = new Intent(this, ItemListActivity.class);
//        startActivity(intent);
//        finish();
    }
}
