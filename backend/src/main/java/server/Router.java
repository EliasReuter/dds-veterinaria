package server;

import domain.controllers.ProfesionalRestController;
import spark.Spark;

public class Router {

    public static void init() {
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
        ProfesionalRestController profesionalRestController = new ProfesionalRestController();

        Spark.get("/profesionales", profesionalRestController::mostrarTodos);

        Spark.get("/clientes", profesionalRestController::mostrarTodos);

        Spark.get("/profesionalesTest", profesionalRestController::mostrarTodosTest);

        Spark.get("/profesional/:id", profesionalRestController::mostrar);
}
}
