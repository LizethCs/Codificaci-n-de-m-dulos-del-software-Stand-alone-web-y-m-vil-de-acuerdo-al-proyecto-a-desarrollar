package com.evidencia.limcasoft.Repository;

import java.util.List;
import com.evidencia.limcasoft.Model.ClientModel;
import com.evidencia.limcasoft.Interface.ClientInterface;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/*Clase que contiene los métodos para trabajar con la base de datos, por ende marcada con la anotación 
 esterotipo de @Repository para marcar la responsabilidad y añadir al contexto de Spring*/
@Repository
@Getter
@Setter
public class ClientRepository {

    private final ClientInterface clientInterface;

    //Definimos que Spring inyecte el valor de su contexto a través de los párametros del Constructor    
    @Autowired
    public ClientRepository(ClientInterface clientInterface) {
        this.clientInterface = clientInterface;
    }

    /**
     * @return lista de objetos de la clase ClientModel
     */
    public List<ClientModel> getAll() {
        return (List<ClientModel>) clientInterface.findAll();
    }

    /**
     * @param id El id del cliente
     * @return la instancia del cliente
     */
    public Optional<ClientModel> getClient(int id) {
        return clientInterface.findById(id);
    }

    /**
     * @param client la instancia del cliente a guardar
     * @return la instancia guardada
     */
    public ClientModel save(ClientModel client) {
        return clientInterface.save(client);
    }

    /**
     * @param client la instancia del cliente a eliminar
     */
    public void delete(ClientModel client) {
        clientInterface.delete(client);
    }
}