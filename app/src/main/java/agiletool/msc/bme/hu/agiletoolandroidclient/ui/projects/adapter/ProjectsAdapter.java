package agiletool.msc.bme.hu.agiletoolandroidclient.ui.projects.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import agiletool.msc.bme.hu.agiletoolandroidclient.R;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.Project;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder> {

    private List<Project> projects;

    private OnProjectClickListener onProjectClickListener;

    public ProjectsAdapter(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_project, parent, false);
        return new ProjectViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        Project project = projects.get(position);

        holder.name.setText(project.getName());
        holder.description.setText(project.getDescription());

        holder.itemView.setOnClickListener(v -> {
            if (onProjectClickListener != null) {
                onProjectClickListener.onProjectClick(project.getId());
            }
        });
        holder.edit.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public void setOnProjectClickListener(OnProjectClickListener onProjectClickListener) {
        this.onProjectClickListener = onProjectClickListener;
    }

    static class ProjectViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.list_item_project_name)
        TextView name;

        @Bind(R.id.list_item_project_description)
        TextView description;

        @Bind(R.id.list_item_project_edit)
        View edit;

        public ProjectViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnProjectClickListener {
        void onProjectClick(String projectId);
    }
}
