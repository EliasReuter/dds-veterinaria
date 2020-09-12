package domain.controllers;

import com.google.gson.Gson;
import domain.entities.Profesional;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import spark.Request;
import spark.Response;

import java.util.List;


public class ProfesionalRestController {

    public Response crear(Request request, Response response){
        response.type("application/json");
        Profesional profesional = new Gson().fromJson(request.body(), Profesional.class);
        FactoryRepositorio.get(Profesional.class).agregar(profesional);
        return response;
    }

    public String existe(Request request, Response response){
        response.type("application/json");
        String resp = FactoryRepositorio.get(Profesional.class).existe(new Integer(request.params("id"))) ?  "User already exists" : "User doesnt exist";
        return resp;
    }

    public String mostrar(Request request, Response response){
        Profesional profesional = FactoryRepositorio.get(Profesional.class).buscar(new Integer(request.params("id")));
        String jsonProfesional = new Gson().toJson(profesional);
        System.out.println(jsonProfesional);
        response.type("application/json");
        return jsonProfesional;
    }

    public Response modificar(Request request, Response response){
        Profesional profesional = new Gson().fromJson(request.body(), Profesional.class);
        FactoryRepositorio.get(Profesional.class).modificar(profesional);
        response.type("application/json");
        return response;
    }

    public Response eliminar(Request request, Response response){
        Profesional profesional = FactoryRepositorio.get(Profesional.class).buscar(new Integer(request.params("id")));
        FactoryRepositorio.get(Profesional.class).eliminar(profesional);
        response.type("application/json");
        return response;
    }

    public String mostrarTodos(Request request, Response response) {
        List<Profesional> profesionales = FactoryRepositorio.get(Profesional.class).buscarTodos();
        String jsonProfesionales = new Gson().toJson(profesionales);
        response.type("application/json");
        System.out.println(jsonProfesionales);
        return jsonProfesionales;
    }

}
