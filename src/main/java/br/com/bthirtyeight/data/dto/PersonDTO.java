package br.com.bthirtyeight.data.dto;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.bthirtyeight.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//define a ordem de exibição do Json
//@JsonPropertyOrder({"address","id","first_Name","last_Name","gender"})
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    //@JsonProperty("first_name")//muda o nome de exibição do atributo no arquivo Json(necessário mudar nome no @JsonPropertyOrder)
    private String firstName;

    //@JsonProperty("last_name")
    private String lastName;

    @JsonFormat(pattern = "dd/MM/yyyy")//para formatar uma data para o padrão brasileiro
    private Date birthDay;

    //@JsonIgnore//faz com que o atributo nao seja enviado para o json(otimo para segurança de algum dado)
    private String address;

    @JsonSerialize(using = GenderSerializer.class)//Define a serialização da classe passada como padrão
    private String gender;

    public PersonDTO() {

    }

    public PersonDTO(Long id, String firstName, String address, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.address = address;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}

