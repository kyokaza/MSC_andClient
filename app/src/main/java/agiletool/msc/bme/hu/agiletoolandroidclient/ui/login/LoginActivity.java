package agiletool.msc.bme.hu.agiletoolandroidclient.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.R;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.main.MainActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.http.HTTP;

public class LoginActivity extends AppCompatActivity implements LoginScreen  {
    private final String URL_BASE = "http://balogotthon.ddns.net/api";


    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

//        AgileToolApplication.injector.inject(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        loginPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        loginPresenter.detachScreen();
    }

    @Override
    public void loginSuccess() {
//        Intent intent = new Intent(this, ItemListActivity.class);
//        startActivity(intent);
//        finish();
    }

    /**
     * Finding it with butterknife.
     * */
    @OnClick(R.id.login_button)
    public void loginButtonOnClock(Button button) {
        EditText m_et_user = (EditText)findViewById(R.id.login_username);
        EditText m_et_pass = (EditText)findViewById(R.id.login_password);
        Toast.makeText(this, "XXXXXXXXXX " + m_et_user.getText() + "-" + m_et_pass.getText(), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
//        finish();
    }

    @Override
    public void onBackPressed() {
        //Close the application
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }


}
