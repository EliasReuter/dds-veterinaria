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

        Spark.get("/clientes", clientesRestController::mostrarTodos);

        Spark.get("/tipoPreguntas", clientesRestController::mostrarTipoPregunta);

        Spark.post("/profesionales", profesionalRestController::crear);

        Spark.delete("/profesionales/:id", profesionalRestController::eliminar);

        Spark.put("/profesionales/:id", profesionalRestController::modificar);

        Spark.options("/profesionales/:id", profesionalRestController::existe);

        Spark.get("/profesionales/:id", profesionalRestController::mostrar);

        Spark.get("/profesionales", profesionalRestController::mostrarTodos);


    }
}
