package domain.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import domain.entities.Cliente;
import domain.entities.Profesional;
import domain.entities.TipoPregunta;
import domain.repositories.factories.FactoryRepositorio;
import spark.Request;
import spark.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println(clientes.getClass().getName());
        Gson gson = new Gson();
        String jsonProfesionales = gson.toJson(clientes);
        response.type("application/json");
        return jsonProfesionales;
    }

    public String mostrarTipoPregunta(Request request, Response response) {
        List<TipoPregunta> tipoPregunta = FactoryRepositorio.get(TipoPregunta.class).buscarTodos();
        System.out.println(tipoPregunta.getClass().getName());
        Gson gson = new Gson();
        //Type listType = new TypeToken<List<Cliente>>() {}.getType();
        //String jsonProfesionales = "[" + clientes.stream().map(x -> gson.toJson(x)).collect(Collectors.joining(",")) + "]";
        //).toJson(clientes, ArrayList.class);
        String jsonProfesionales = gson.toJson(tipoPregunta.get(0));
        response.type("application/json");
        return jsonProfesionales;
    }

    public String mostrarTodosTest(Request request, Response response) {
        return "jsonProfesionales";
    }

}
