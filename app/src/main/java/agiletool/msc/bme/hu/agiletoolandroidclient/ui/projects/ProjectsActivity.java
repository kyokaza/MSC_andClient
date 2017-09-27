package agiletool.msc.bme.hu.agiletoolandroidclient.ui.projects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.R;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.login.LoginPresenter;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.login.LoginScreen;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.main.MainActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProjectsActivity extends AppCompatActivity {
    private final String URL_BASE = "http://balogotthon.ddns.net/api";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projects_activity);

        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @OnClick(R.id.login_button)
    public void loginButton(Button button) {
        EditText m_et_user = (EditText) findViewById(R.id.login_username);
        EditText m_et_pass = (EditText) findViewById(R.id.login_password);
        Toast.makeText(this, "XXXXXXXXXX " + m_et_user.getText() + "-" + m_et_pass.getText(), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}

