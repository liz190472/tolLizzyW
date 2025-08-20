
   /*
 * Esta clase DAO (Data Access Object) se encarga de las operaciones
 * CRUD (Crear, Leer, Actualizar, Eliminar) para la tabla 'Producto'.
 */
package com.toallaslizzy.dao;

import com.toallaslizzy.conexion.Conexion;
import com.toallaslizzy.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    /**
     * Inserta un nuevo producto en la base de datos.
     * @param producto el objeto Producto a insertar.
     * @return true si la inserción fue exitosa, false de lo contrario.
     */
    public boolean insertar(Producto producto) {
        String sql = "INSERT INTO Producto (Referencia, Gramos, Tamano, Color, PrecioUnitario, CantidadStock, Estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, producto.getReferencia());
            stmt.setDouble(2, producto.getGramos());
            stmt.setString(3, producto.getTamano());
            stmt.setString(4, producto.getColor());
            stmt.setDouble(5, producto.getPrecioUnitario());
            stmt.setInt(6, producto.getCantidadStock());
            stmt.setString(7, producto.getEstado());
            
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error al insertar producto: " + e.getMessage());
            return false;
        }
    }

    /**
     * Lista todos los productos de la base de datos.
     * @return una lista de objetos Producto.
     */
    public List<Producto> listarTodos() {
        List<Producto> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM Producto";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Producto producto = new Producto(
                    rs.getInt("Id"),
                    rs.getString("Referencia"),
                    rs.getDouble("Gramos"),
                    rs.getString("Tamano"),
                    rs.getString("Color"),
                    rs.getDouble("PrecioUnitario"),
                    rs.getInt("CantidadStock"),
                    rs.getString("Estado")
                );
                listaProductos.add(producto);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error al listar productos: " + e.getMessage());
        }
        
        return listaProductos;
    }
    
    /**
     * Actualiza un producto existente en la base de datos.
     * @param producto el objeto Producto con los datos actualizados.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    public boolean actualizar(Producto producto) {
        String sql = "UPDATE Producto SET Referencia=?, Gramos=?, Tamano=?, Color=?, PrecioUnitario=?, CantidadStock=?, Estado=? WHERE Id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, producto.getReferencia());
            stmt.setDouble(2, producto.getGramos());
            stmt.setString(3, producto.getTamano());
            stmt.setString(4, producto.getColor());
            stmt.setDouble(5, producto.getPrecioUnitario());
            stmt.setInt(6, producto.getCantidadStock());
            stmt.setString(7, producto.getEstado());
            stmt.setInt(8, producto.getId());
            
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Elimina un producto de la base de datos por su ID.
     * @param id el ID del producto a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Producto WHERE Id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }
}
