package com.evidencia.limcasoft.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//POJO que representa o modela los datos de la entidad
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El nombre sólo debe contener letras")
    private String name;
    @Pattern(regexp = "^[a-zA-Z]+ [a-zA-Z]+$", message = "El apellido no es válido.")//
    private String lastName;
    @Pattern(regexp = "^[\\w]+([\\.\\+\\w]+)?@([\\w-]+\\.)+[a-zzA-Z]{2,}$", message = "El correo no es válido.")//subadressing +work
    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "La dirección no es válida.")
    private String address;
    @Pattern(regexp = "[0-9]+$", message = "Debe contener sólo números.")
    private String number;
    @Pattern(regexp = "^[a-zA-Z]{2,3}$", message = "Tipo de documento inválido.")
    private String docType;
    @Pattern(regexp = "[0-9]+$", message = "Debe contener sólo números.")
    private String document;
}
