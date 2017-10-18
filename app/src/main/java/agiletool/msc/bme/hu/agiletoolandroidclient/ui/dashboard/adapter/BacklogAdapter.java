package agiletool.msc.bme.hu.agiletoolandroidclient.ui.dashboard.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import agiletool.msc.bme.hu.agiletoolandroidclient.R;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.BacklogItem;
import butterknife.Bind;
import butterknife.ButterKnife;

public class BacklogAdapter extends RecyclerView.Adapter<BacklogAdapter.BacklogViewHolder> {

    private List<BacklogItem> backlogItemList;
    private List<String> sprintIds;

    public BacklogAdapter(List<BacklogItem> backlogItemList, List<String> sprintIds) {
        this.backlogItemList = backlogItemList;
        this.sprintIds = sprintIds;
    }

    @Override
    public BacklogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_backlog, parent, false);
        return new BacklogViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(BacklogViewHolder holder, int position) {
        BacklogItem backlogItem = backlogItemList.get(position);

        holder.name.setText(backlogItem.getTitle());
        //holder.type.setText(getBacklogType(backlogItem.getType()));

        if (getBacklogSprintStatus(backlogItem.getId())) {
            holder.sprintStatus.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return backlogItemList.size();
    }

    private boolean getBacklogSprintStatus(String backlogId) {
        return sprintIds != null && sprintIds.contains(backlogId);
    }

    private String getBacklogType(String backlogItemType) {
        String resolvedType;
        switch (backlogItemType) {
            case "BUG":
                resolvedType = "Bug";
                break;
            case "TASK":
                resolvedType = "Task";
                break;
            case "USER_STORY":
                resolvedType = "User";
                break;
            default:
                resolvedType = "";
        }

        return resolvedType;
    }

    public static class BacklogViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.backlog_list_item_type)
        TextView type;

        @Bind(R.id.backlog_list_item_name)
        TextView name;

        @Bind(R.id.backlog_list_item_sprint_status)
        TextView sprintStatus;

        public BacklogViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
