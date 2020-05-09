package app.project;


import app.TaskBerryConnection;
import org.sql2o.Connection;

import java.util.List;

public class ProjectDao {

    public static void create(ProjectData project) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            conn.createQuery("insert into projects(name, active, createdIn, createdBy) VALUES (:name, :active, :createdIn, :createdBy)")
                    .addParameter("name", project.name)
                    .addParameter("active", project.active)
                    .addParameter("createdIn", project.createdIn)
                    .addParameter("createdBy", project.createdBy)
                    .executeUpdate();
        }
    }

    public static void update(ProjectData project) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            String sql = "update projects set name = :name, active = :active, updatedIn = :updatedIn, updatedBy = :updatedBy";
            sql += ", disabledIn = :disabledIn, disabledBy = :disabledBy";
            sql += " where projectId = :projectId";

            conn.createQuery(sql)
                    .addParameter("name", project.name)
                    .addParameter("active", project.active)
                    .addParameter("updatedIn", project.updatedIn)
                    .addParameter("updatedBy", project.updatedBy)
                    .addParameter("disabledIn", project.disabledIn)
                    .addParameter("disabledBy", project.disabledBy)
                    .addParameter("projectId", project.projectId)
                    .executeUpdate();
        }
    }

    public static List<Project> findAll() {
        try (Connection conn = TaskBerryConnection.get().open()) {
            List<ProjectData> projects = conn.createQuery("select * from projects").executeAndFetch(ProjectData.class);
            return ProjectTranslator.translate(projects);
        }
    }

    public static Project find(int projectId){
        try (Connection conn = TaskBerryConnection.get().open()) {
            ProjectData project = conn.createQuery("select * from projects where projectId = "+projectId).executeAndFetchFirst(ProjectData.class);
            return ProjectTranslator.translate(project);
        }
    }
}
