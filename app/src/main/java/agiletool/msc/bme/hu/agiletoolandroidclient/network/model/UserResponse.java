package agiletool.msc.bme.hu.agiletoolandroidclient.network.model;

import agiletool.msc.bme.hu.agiletoolandroidclient.model.wrappers.UserWrapper;

public class UserResponse {

    private UserWrapper _embedded;

    public UserWrapper get_embedded() {
        return _embedded;
    }

    public void set_embedded(UserWrapper _embedded) {
        this._embedded = _embedded;
    }
}
