package agiletool.msc.bme.hu.agiletoolandroidclient.ui.projects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import agiletool.msc.bme.hu.agiletoolandroidclient.R;
import butterknife.ButterKnife;

public class ProjectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

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


}

