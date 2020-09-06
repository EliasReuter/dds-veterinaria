package domain.controllers;

import com.google.gson.Gson;
import domain.entities.Cliente;
import domain.entities.Profesional;
import domain.repositories.factories.FactoryRepositorio;
import spark.Request;
import spark.Response;

import java.util.List;

public class ClientesRestController {

    public String mostrar(Request request, Response response){
        Cliente cliente = FactoryRepositorio.get(Cliente.class).buscar(new Integer(request.params("id")));
        Gson gson = new Gson();
        String jsonProfesional = gson.toJson(cliente);
        response.type("application/json");
        return jsonProfesional;
    }

    public String mostrarTodos(Request request, Response response) {
        List<Cliente> clientes = FactoryRepositorio.get(Cliente.class).buscarTodos();
        Gson gson = new Gson();
        String jsonProfesionales = gson.toJson(clientes);
        response.type("application/json");
        return jsonProfesionales;
    }

    public String mostrarTodosTest(Request request, Response response) {
        return "jsonProfesionales";
    }

}
