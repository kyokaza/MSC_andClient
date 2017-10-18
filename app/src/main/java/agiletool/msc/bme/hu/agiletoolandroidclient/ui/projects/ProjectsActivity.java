package agiletool.msc.bme.hu.agiletoolandroidclient.ui.projects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.R;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.Project;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.dashboard.DashboardActivity;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.projects.adapter.ProjectsAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

import static agiletool.msc.bme.hu.agiletoolandroidclient.ui.dashboard.DashboardActivity.PROJECT_ID_KEY;


public class ProjectsActivity extends AppCompatActivity implements ProjectsScreen {

    @Inject
    ProjectsPresenter projectsPresenter;

    @Bind(R.id.projects_list)
    RecyclerView projectRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        ButterKnife.bind(this);

        AgileToolApplication.agileToolApplicationComponent.inject(this);

        projectsPresenter.attach(this);
        projectsPresenter.getProjects();
    }

    @Override
    protected void onPause() {
        super.onPause();

        projectsPresenter.detach();
    }

    @Override
    public void setProjects(List<Project> projects) {
        ProjectsAdapter projectsAdapter = new ProjectsAdapter(projects);
        projectsAdapter.setOnProjectClickListener(this::navigateToDashboard);

        projectRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        projectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        projectRecyclerView.setAdapter(projectsAdapter);
    }

    private void navigateToDashboard(String projectId) {
        Intent dashboardIntent = new Intent(this, DashboardActivity.class);
        dashboardIntent.putExtra(PROJECT_ID_KEY, projectId);

        startActivity(dashboardIntent);
    }
}
