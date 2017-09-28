package agiletool.msc.bme.hu.agiletoolandroidclient.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import agiletool.msc.bme.hu.agiletoolandroidclient.R;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.main.MainActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
