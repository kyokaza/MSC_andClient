package agiletool.msc.bme.hu.agiletoolandroidclient.ui.projects;


import java.util.List;

import agiletool.msc.bme.hu.agiletoolandroidclient.model.Project;
import agiletool.msc.bme.hu.agiletoolandroidclient.ui.Screen;

public interface ProjectsScreen extends Screen {

    void setProjects(List<Project> projects);
}
