package server;

import domain.controllers.ClientesRestController;
import domain.controllers.ProfesionalRestController;
import spark.Spark;

public class Router {

    public static void init() {
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
        ProfesionalRestController profesionalRestController = new ProfesionalRestController();
        ClientesRestController clientesRestController = new ClientesRestController();

        Spark.get("/profesionales", profesionalRestController::mostrarTodos);

        Spark.get("/clientes", clientesRestController::mostrarTodos);
        Spark.get("/tipoPregunta", clientesRestController::mostrarTipoPregunta);

        Spark.get("/profesionalesTest", profesionalRestController::mostrarTodosTest);

        Spark.get("/profesional/:id", profesionalRestController::mostrar);
    }
}
