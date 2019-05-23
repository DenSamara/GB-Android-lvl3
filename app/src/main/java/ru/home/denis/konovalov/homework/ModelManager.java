package ru.home.denis.konovalov.homework;

public class ModelManager {
    private final Model model;

    private static ModelManager modelManager;
    static {
        modelManager = new ModelManager();
    }

    private ModelManager(){
        model = new Model();
    }

    public static ModelManager getInstance(){
        return modelManager;
    }

    public Model getModel() {
        return model;
    }
}
