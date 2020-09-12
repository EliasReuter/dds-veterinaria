package domain.repositories.factories;

import domain.repositories.Repositorio;
import domain.repositories.daos.*;

import java.util.HashMap;

public class FactoryRepositorio {
    private static HashMap<String, Repositorio> repos;

    public FactoryRepositorio() {
        repos = new HashMap<>();
    }

    public static <T> Repositorio<T> get(Class<T> type){
        Repositorio<T> repo;
        if(repos.containsKey(type.getName())){
            System.out.println("YA EXISTE EL REPO");
            repo = repos.get(type.getName());
        }
        else{
            System.out.println("NUEVO REPO");
            DAO<T> dao = new DAOHibernate<>(type);
            repo = new Repositorio<>(dao);
            repos.put(type.toString(), repo);
            System.out.println(type.toString());
        }
        repos.keySet().forEach(x -> System.out.println(x));
        return repo;
    }
}