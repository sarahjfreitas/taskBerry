package app;

import org.sql2o.Sql2o;

public class TaskBerryConnection {
    private static Sql2o connection;

    public static Sql2o get(){
        if(connection == null){
            connection = new Sql2o("jdbc:sqlite:./taskberry.db",null,null);
        }
        return connection;
    }
}