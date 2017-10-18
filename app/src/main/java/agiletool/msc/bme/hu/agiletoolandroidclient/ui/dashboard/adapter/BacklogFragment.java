package agiletool.msc.bme.hu.agiletoolandroidclient.ui.dashboard.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.R;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.BacklogItem;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.Sprint;
import butterknife.Bind;
import butterknife.ButterKnife;

public class BacklogFragment extends Fragment {

    @Bind(R.id.backlog_list)
    RecyclerView backlogRecycler;

    private List<BacklogItem> backlogItemList;
    private Sprint sprint;

    public BacklogFragment() {
    }

    public BacklogFragment(List<BacklogItem> backlogItemList, Sprint sprint) {
        this.backlogItemList = backlogItemList;
        this.sprint = sprint;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_backlog, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        backlogRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        if (sprint != null){
            backlogRecycler.setAdapter(new BacklogAdapter(backlogItemList, sprint.getBacklogItemsInvolved()));
        } else {
            backlogRecycler.setAdapter(new BacklogAdapter(backlogItemList, null));
        }
    }
}
