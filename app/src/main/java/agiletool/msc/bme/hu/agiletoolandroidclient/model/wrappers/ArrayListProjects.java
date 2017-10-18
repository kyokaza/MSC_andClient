package agiletool.msc.bme.hu.agiletoolandroidclient.model.wrappers;


import java.util.List;

public class ArrayListProjects {

    @Override
    public String toString() {
        return super.toString();
    }

    List<String> projects;

    public ArrayListProjects(List<String> projects) {
        this.projects = projects;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}
