package app;

import org.sql2o.Sql2o;

public class TaskBerryConnection {
    private static Sql2o sql2o;

    public static Sql2o get(){
        if(sql2o == null){
            sql2o = new Sql2o("jdbc:sqlite:./taskberry.db",null,null);
        }
        return sql2o;
    }
}
