/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toallaslizzy.model;

public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String password;
    private int idrol;

    // Constructor completo (con id)
    public Usuario(int id, String nombre, String email, String password, int idrol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.idrol = idrol;
    }

    // 🔥 Constructor sin id (para inserts donde el id lo genera la BD)
    public Usuario(String nombre, String email, String password, int idrol) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.idrol = idrol;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getIdrol() { return idrol; }
    public void setIdrol(int idrol) { this.idrol = idrol; }
}
