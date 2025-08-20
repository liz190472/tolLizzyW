/*
 * Esta clase sirve para probar las funcionalidades de ProductoDAO
 * (insertar, listar, actualizar, eliminar).
 */
package com.toallaslizzy.test;

import com.toallaslizzy.dao.ProductoDAO;
import com.toallaslizzy.model.Producto;
import java.util.List;

public class TestProductojava {

    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();
        
        // --- PRUEBA 1: INSERTAR UN PRODUCTO 1 ---
        System.out.println("--- Probando inserción de producto ---");
        Producto nuevoProducto = new Producto();
        nuevoProducto.setReferencia("Hotelera");
        nuevoProducto.setGramos(550.00);
        nuevoProducto.setTamano("70x140");
        nuevoProducto.setColor("Blanco");
        nuevoProducto.setPrecioUnitario(75000.00);
        nuevoProducto.setCantidadStock(300);
        nuevoProducto.setEstado("Activo");
        
        boolean insertado = productoDAO.insertar(nuevoProducto);
        if (insertado) {
            System.out.println("✅ Producto insertado correctamente.");
        } else {
            System.out.println("❌ Fallo al insertar el producto.");
        }
         // --- PRUEBA 1: INSERTAR UN PRODUCTO 2 --
         // Producto 2
        Producto nuevoProducto2 = new Producto();
        nuevoProducto2.setReferencia("Infantil");
        nuevoProducto2.setGramos(510);
        nuevoProducto2.setTamano("60x120");
        nuevoProducto2.setColor("Rosado");
        nuevoProducto2.setPrecioUnitario(35000.00);
        nuevoProducto2.setCantidadStock(500);
        nuevoProducto2.setEstado("Activo");
        
        boolean insertado2 = productoDAO.insertar(nuevoProducto2);
        if (insertado2) {
            System.out.println("✅ Producto 2 insertado correctamente.");
        } else {
            System.out.println("❌ Fallo al insertar el producto 2.");
        }
                
        // --- PRUEBA 2: LISTAR TODOS LOS PRODUCTOS ---
        System.out.println("\n--- Listado de todos los productos ---");
        List<Producto> listaProductos = productoDAO.listarTodos();
        for (Producto p : listaProductos) {
            System.out.println(p.toString());
        }
        
        // --- PRUEBA 3: ACTUALIZAR UN PRODUCTO (ej: el que acabamos de insertar) ---
        // Asumimos que el primer producto de la lista es el que acabamos de insertar
        if (!listaProductos.isEmpty()) {
            System.out.println("\n--- Probando actualización de producto ---");
            Producto productoAActualizar = listaProductos.get(0);
            productoAActualizar.setPrecioUnitario(45000.00);
            productoAActualizar.setCantidadStock(150);
            
            boolean actualizado = productoDAO.actualizar(productoAActualizar);
            if (actualizado) {
                System.out.println("✅ Producto actualizado correctamente.");
            } else {
                System.out.println("❌ Fallo al actualizar el producto.");
            }
        }
        
        // --- PRUEBA 4: LISTAR DESPUÉS DE LA ACTUALIZACIÓN ---
        System.out.println("\n--- Listado de productos después de la actualización ---");
        listaProductos = productoDAO.listarTodos();
        for (Producto p : listaProductos) {
            System.out.println(p.toString());
        }

        // --- PRUEBA 5: ELIMINAR UN PRODUCTO ---
        if (!listaProductos.isEmpty()) {
            System.out.println("\n--- Probando eliminación de producto ---");
            Producto productoAEliminar = listaProductos.get(0);
            boolean eliminado = productoDAO.eliminar(productoAEliminar.getId());
            if (eliminado) {
                System.out.println("✅ Producto eliminado correctamente.");
            } else {
                System.out.println("❌ Fallo al eliminar el producto.");
            }
        }
        
        // --- PRUEBA 6: LISTAR DESPUÉS DE LA ELIMINACIÓN ---
        System.out.println("\n--- Listado de productos después de la eliminación ---");
        listaProductos = productoDAO.listarTodos();
        if (listaProductos.isEmpty()) {
            System.out.println("La lista de productos está vacía.");
        } else {
            for (Producto p : listaProductos) {
                System.out.println(p.toString());
            }
        }
    }
}
