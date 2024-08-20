package com.evidencia.limcasoft.Interface;

import com.evidencia.limcasoft.Model.ClientModel;
import org.springframework.data.repository.CrudRepository;

//Interfaz que hereda los métodos de CrudRepository
public interface ClientInterface extends CrudRepository<ClientModel, Integer> {

}