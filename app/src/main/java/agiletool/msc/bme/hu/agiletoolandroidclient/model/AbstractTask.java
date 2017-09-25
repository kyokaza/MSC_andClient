package agiletool.msc.bme.hu.agiletoolandroidclient.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractTask extends BacklogItem {

    public AbstractTask() {
    }

//    public AbstractTask(String id, String title, Date createDate, ArrayList<String> keywords, String description, ArrayList<String> assignee, Complexity complexity, ArrayList<String> depending, BacklogStatus status, BacklogItemType type) {
//        super(id, title, createDate, keywords, description, assignee, complexity, depending, status, type);
//    }


    public AbstractTask(String id, String title, Date createDate, ArrayList<String> keywords, String description, ArrayList<String> assignee, Complexity complexity, ArrayList<String> depending, BacklogStatus status, BacklogItemType type, List<CheckList> checkList) {
        super(id, title, createDate, keywords, description, assignee, complexity, depending, status, type, checkList);
    }
}
