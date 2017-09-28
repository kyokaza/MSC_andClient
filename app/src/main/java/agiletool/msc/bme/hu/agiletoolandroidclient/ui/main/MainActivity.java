package agiletool.msc.bme.hu.agiletoolandroidclient.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import agiletool.msc.bme.hu.agiletoolandroidclient.R;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.projects.ProjectsActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String api = "http://balogotthon.ddns.net/api";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        logme();
        ButterKnife.bind(this);
    }

    @OnClick(R.id.projects_button)
    public void loginButtonOnClock(Button button) {

        Toast.makeText(this, "EMAKAZI ", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this, ProjectsActivity.class);
        startActivity(intent);
//        finish();
    }
}
