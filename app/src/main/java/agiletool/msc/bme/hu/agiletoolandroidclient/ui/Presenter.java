package agiletool.msc.bme.hu.agiletoolandroidclient.ui;


public abstract class Presenter<S extends Screen> {
    protected S screen;

    public void attach(S screen) {
        this.screen = screen;
    }

    public void detach() {
        this.screen = null;
    }
}
