package agiletool.msc.bme.hu.agiletoolandroidclient.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.R;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.wrappers.DashboardResolving;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.backlog.BackLogActivity;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.dashboard.adapter.BacklogScreenAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends AppCompatActivity implements DashboardScreen {

    public static final String PROJECT_ID_KEY = "PROJECT_ID_KEY";

    @Inject
    DashboardPresenter dashboardPresenter;

    @Bind(R.id.dashboard_viewpager)
    ViewPager dashboardViewpager;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ButterKnife.bind(this);
        AgileToolApplication.agileToolApplicationComponent.inject(this);

        final Intent intent = getIntent();

        String projectId = intent.getStringExtra(PROJECT_ID_KEY);

        dashboardPresenter.attach(this);
        dashboardPresenter.getDashboard(projectId);
    }

    @Override
    protected void onPause() {
        super.onPause();

        dashboardPresenter.detach();
    }

    @Override
    public void setDashboard(DashboardResolving dashboardResolving) {
        BacklogScreenAdapter screenAdapter =
                new BacklogScreenAdapter(getSupportFragmentManager(), dashboardResolving);

        dashboardViewpager.setAdapter(screenAdapter);
    }

    @OnClick(R.id.fab)
    public void onCreateNewBacklogItem() {
        Intent intent = new Intent(this, BackLogActivity.class);
        startActivity(intent);
    }
}
