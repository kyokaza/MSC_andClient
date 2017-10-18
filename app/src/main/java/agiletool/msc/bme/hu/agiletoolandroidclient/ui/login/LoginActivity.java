package agiletool.msc.bme.hu.agiletoolandroidclient.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.R;
import agiletool.msc.bme.hu.agiletoolandroidclient.helper.Constants;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.Project;
import agiletool.msc.bme.hu.agiletoolandroidclient.persistence.SharedPreferencesHelper;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.projects.ProjectsActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginScreen {

    @Inject
    LoginPresenter loginPresenter;

    @Inject
    SharedPreferencesHelper preferencesHelper;

    @Bind(R.id.login_username)
    EditText userName;

    @Bind(R.id.login_password)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        AgileToolApplication.agileToolApplicationComponent.inject(this);

        loginPresenter.attach(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        loginPresenter.detach();
    }

    @OnClick(R.id.login_button)
    public void loginButtonOnClock() {
        //TODO logiin checkelese

        loginPresenter.login(userName.getText().toString(), password.getText().toString());
    }


    @Override
    public void login(String cookie) {
        String sessionid = cookie.split(";")[0];
        sessionid = sessionid.substring("jsessionid=".length());
        preferencesHelper.saveItem(Constants.PREFERENCES_USERNAME, userName.getText().toString());
        preferencesHelper.saveItem(Constants.PREFERENCES_SESSION_ID, sessionid);

        Intent intent = new Intent(this, ProjectsActivity.class);
        startActivity(intent);
    }
}
