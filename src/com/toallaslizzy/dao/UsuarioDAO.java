/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
/*
 * Esta clase DAO (Data Access Object) se encarga de las operaciones
 * CRUD (Crear, Leer, Actualizar, Eliminar) para la tabla 'Usuario'.
 */
package com.toallaslizzy.dao;

import com.toallaslizzy.conexion.Conexion;
import com.toallaslizzy.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    /**
     * Inserta un nuevo usuario en la base de datos.
     * @param usuario el objeto Usuario a insertar.
     * @return true si la inserción fue exitosa, false de lo contrario.
     */
    public boolean insertar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre, email, password, id_rol) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getPassword());
            ps.setInt(4, usuario.getIdrol());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("❌ Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Lista todos los usuarios de la base de datos.
     * @return una lista de objetos Usuario.
     */
    public List<Usuario> listar() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getInt("id_rol")
                );
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al listar usuarios: " + e.getMessage());
        }
        return listaUsuarios;
    }
    
    /**
     * Actualiza un usuario existente en la base de datos.
     * @param usuario el objeto Usuario con los datos actualizados.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE usuario SET nombre=?, email=?, password=?, id_rol=? WHERE id=?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getPassword());
            ps.setInt(4, usuario.getIdrol());
            ps.setInt(5, usuario.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Elimina un usuario de la base de datos por su ID.
     * @param idUsuario el ID del usuario a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    public boolean eliminar(int idUsuario) {
        String sql = "DELETE FROM usuario WHERE id=?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idUsuario);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }
}
