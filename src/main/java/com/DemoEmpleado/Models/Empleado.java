package com.DemoEmpleado.Models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "empleado")
@JsonPropertyOrder({"id", "nombres", "apellidos", "estadoCivil", "fechaNacimiento",
        "genero", "salario", "moneda", "email", "direccion"})
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private long id;

    @Column(name = "nombres")
    @JsonProperty("nombres")
    private String nombres;

    @Column(name = "apellidos")
    @JsonProperty("apellidos")
    private String apellidos;

    @Column(name = "estado_civil")
    @JsonProperty("estadoCivil")
    private String estadoCivil;

    @Column(name = "fecha_nacimiento")
    @JsonProperty("fechaNacimiento")
    private Date fechaNacimiento;
    @Column(name = "genero")
    @JsonProperty("genero")
    private String genero;

    @Column(name = "salario")
    @JsonProperty("salario")
    private double salario;

    @Column(name = "moneda")
    @JsonProperty("moneda")
    private String moneda;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "direccion")
    @JsonProperty("direccion")
    private String direccion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
