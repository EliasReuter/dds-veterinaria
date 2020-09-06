package domain.controllers;

import com.google.gson.Gson;
import domain.entities.Profesional;
import domain.repositories.factories.FactoryRepositorio;
import spark.Request;
import spark.Response;

import java.util.List;


public class ProfesionalRestController {

    public String mostrar(Request request, Response response){
        Profesional profesional = FactoryRepositorio.get(Profesional.class).buscar(new Integer(request.params("id")));
        Gson gson = new Gson();
        String jsonProfesional = gson.toJson(profesional);
        response.type("application/json");
        return jsonProfesional;
    }

    public String mostrarTodos(Request request, Response response) {
        List<Profesional> profesionales = FactoryRepositorio.get(Profesional.class).buscarTodos();
        Gson gson = new Gson();
        String jsonProfesionales = gson.toJson(profesionales);
        response.type("application/json");
        return jsonProfesionales;
    }

    public String mostrarTodosTest(Request request, Response response) {
        return "jsonProfesionales";
    }

}
