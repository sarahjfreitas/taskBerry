package app;

import app.index.IndexController;

public class ControllerFactory {
    private IndexController indexController;

    public IController IndexController(){
        if(indexController == null){
            indexController = new IndexController();
        }
        return indexController;
    }
}