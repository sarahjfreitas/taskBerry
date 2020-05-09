package app.project;

import app.user.User;
import app.user.UserDao;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ProjectTranslator {
    public static Project translate(ProjectData from){
        Project project = new Project();
        project.setProjectId(from.projectId);
        project.setName(from.name);

        if(from.active == 1){
            project.activate();
        }
        else{
            project.deactivate();
        }
        project.setCreatedIn(Instant.ofEpochSecond(from.createdIn));
        project.setUpdatedIn(Instant.ofEpochSecond(from.updatedIn));
        project.setDisabledIn(Instant.ofEpochSecond(from.disabledIn));

        project.setCreatedBy(UserDao.find(from.createdBy));
        project.setUpdatedBy(UserDao.find(from.updatedBy));
        project.setDisabledBy(UserDao.find(from.disabledBy));

        return project;
    }

    public static ProjectData translate(Project from){
        ProjectData projectData = new ProjectData();
        projectData.projectId = from.getProjectId();
        projectData.name = from.getName();
        projectData.active = from.isActive() ? 1 : 0;

        projectData.createdIn = from.getCreatedIn().getEpochSecond();
        projectData.createdBy = from.getCreatedBy().getUserId();

        if(from.getUpdatedIn() != null)
            projectData.updatedIn = from.getUpdatedIn().getEpochSecond();
        if(from.getUpdatedBy() != null)
            projectData.updatedBy = from.getUpdatedBy().getUserId();

        if(from.getDisabledIn() != null)
            projectData.disabledIn = from.getDisabledIn().getEpochSecond();
        if(from.getDisabledBy() != null)
            projectData.disabledBy = from.getDisabledBy().getUserId();

        return projectData;
    }

    public static List<Project> translate(List<ProjectData> from){
        List<Project> projects = new ArrayList<Project>();
        from.forEach(f -> projects.add(ProjectTranslator.translate(f)));
        return projects;
    }
}
