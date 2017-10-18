package agiletool.msc.bme.hu.agiletoolandroidclient.model.wrappers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import agiletool.msc.bme.hu.agiletoolandroidclient.model.User;

public class UserWrapper {

    @SerializedName("user")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
