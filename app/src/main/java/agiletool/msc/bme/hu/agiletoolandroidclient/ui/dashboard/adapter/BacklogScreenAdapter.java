package agiletool.msc.bme.hu.agiletoolandroidclient.ui.dashboard.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import agiletool.msc.bme.hu.agiletoolandroidclient.model.wrappers.DashboardResolving;


public class BacklogScreenAdapter extends FragmentPagerAdapter {

    private DashboardResolving dashboard;

    public BacklogScreenAdapter(FragmentManager fm, DashboardResolving dashboard) {
        super(fm);

        this.dashboard = dashboard;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BacklogFragment(dashboard.getBacklog(), dashboard.getSprint());
            case 1:
                return new BacklogFragment(dashboard.getTodo(), dashboard.getSprint());
            case 2:
                return new BacklogFragment(dashboard.getInProgress(), dashboard.getSprint());
            case 3:
                return new BacklogFragment(dashboard.getDone(), dashboard.getSprint());
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String tabTitle;
        switch (position) {
            case 0:
                tabTitle = "Backlog";
                break;
            case 1:
                tabTitle = "Todo";
                break;
            case 2:
                tabTitle = "In progress";
                break;
            case 3:
                tabTitle = "Done";
                break;
            default:
                tabTitle = "";
        }

        return tabTitle;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
