/*
 * Esta clase MainApp es el punto de entrada de la aplicación.
 * Ahora contiene un menú principal que permite al usuario
 * navegar entre las operaciones de Usuario y Producto.
 */
package com.toallaslizzy.vista;

import com.toallaslizzy.dao.ProductoDAO;
import com.toallaslizzy.dao.UsuarioDAO;
import com.toallaslizzy.model.Producto;
import com.toallaslizzy.model.Usuario;
import java.util.List;
import java.util.Scanner;

public class MainAPP {

    public static void main(String[] args) {
        // Inicialización de DAOs y Scanner para ambos módulos
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        Scanner sc = new Scanner(System.in);
        int opcionPrincipal;
        
        do {
            // --- MENÚ PRINCIPAL ---
            System.out.println("\n--- Menú de Gestión ---");
            System.out.println("1. Gestión de Usuarios");
            System.out.println("2. Gestión de Productos");
            System.out.println("0. Salir de la aplicación");
            System.out.print("Elige una opción: ");
            opcionPrincipal = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcionPrincipal) {
                case 1:
                    // --- SUB-MENÚ DE USUARIOS ---
                    int opcionUsuario;
                    do {
                        System.out.println("\n--- Menú Usuario ---");
                        System.out.println("1. Insertar usuario");
                        System.out.println("2. Listar usuarios");
                        System.out.println("3. Actualizar usuario");
                        System.out.println("4. Eliminar usuario");
                        System.out.println("9. Volver al menú principal");
                        System.out.print("Elige una opción: ");
                        opcionUsuario = sc.nextInt();
                        sc.nextLine(); // Limpiar el buffer
                        
                        switch (opcionUsuario) {
                            case 1:
                                System.out.print("Nombre: ");
                                String nombre = sc.nextLine();
                                System.out.print("Email: ");
                                String email = sc.nextLine();
                                System.out.print("Password: ");
                                String pass = sc.nextLine();
                                System.out.print("Id Rol: ");
                                int idRol = sc.nextInt();
                                Usuario nuevoUsuario = new Usuario(0, nombre, email, pass, idRol);
                                if (usuarioDAO.insertar(nuevoUsuario)) {
                                    System.out.println("✅ Usuario insertado correctamente.");
                                } else {
                                    System.out.println("❌ Fallo al insertar el usuario.");
                                }
                                break;
                            case 2:
                                List<Usuario> listaUsuarios = usuarioDAO.listar();
                                if (listaUsuarios.isEmpty()) {
                                    System.out.println("La lista de usuarios está vacía.");
                                } else {
                                    listaUsuarios.forEach(System.out::println);
                                }
                                break;
                            case 3:
                                System.out.print("ID del usuario a actualizar: ");
                                int id = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Nuevo nombre: ");
                                nombre = sc.nextLine();
                                System.out.print("Nuevo email: ");
                                email = sc.nextLine();
                                System.out.print("Nuevo password: ");
                                pass = sc.nextLine();
                                System.out.print("Nuevo Id Rol: ");
                                idRol = sc.nextInt();
                                Usuario usuarioEditado = new Usuario(id, nombre, email, pass, idRol);
                                if (usuarioDAO.actualizar(usuarioEditado)) {
                                    System.out.println("✅ Usuario actualizado correctamente.");
                                } else {
                                    System.out.println("❌ Fallo al actualizar el usuario.");
                                }
                                break;
                            case 4:
                                System.out.print("ID del usuario a eliminar: ");
                                int idDel = sc.nextInt();
                                if (usuarioDAO.eliminar(idDel)) {
                                     System.out.println("✅ Usuario eliminado correctamente.");
                                } else {
                                     System.out.println("❌ Fallo al eliminar el usuario.");
                                }
                                break;
                            case 9:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción inválida. Intenta de nuevo.");
                        }
                    } while (opcionUsuario != 9);
                    break;

                case 2:
                    // --- SUB-MENÚ DE PRODUCTOS ---
                    int opcionProducto;
                    do {
                        System.out.println("\n--- Menú Producto ---");
                        System.out.println("1. Insertar producto");
                        System.out.println("2. Listar productos");
                        System.out.println("3. Actualizar producto");
                        System.out.println("4. Eliminar producto");
                        System.out.println("9. Volver al menú principal");
                        System.out.print("Elige una opción: ");
                        opcionProducto = sc.nextInt();
                        sc.nextLine(); // Limpiar el buffer

                        switch (opcionProducto) {
                            case 1:
                                System.out.print("Referencia: ");
                                String referencia = sc.nextLine();
                                System.out.print("Gramos: ");
                                double gramos = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Tamaño: ");
                                String tamano = sc.nextLine();
                                System.out.print("Color: ");
                                String color = sc.nextLine();
                                System.out.print("Precio Unitario: ");
                                double precioUnitario = sc.nextDouble();
                                System.out.print("Cantidad en Stock: ");
                                int cantidadStock = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Estado: ");
                                String estado = sc.nextLine();
                                Producto nuevoProducto = new Producto(0, referencia, gramos, tamano, color, precioUnitario, cantidadStock, estado);
                                if (productoDAO.insertar(nuevoProducto)) {
                                    System.out.println("✅ Producto insertado correctamente.");
                                } else {
                                    System.out.println("❌ Fallo al insertar el producto.");
                                }
                                break;
                            case 2:
                                List<Producto> listaProductos = productoDAO.listarTodos();
                                if (listaProductos.isEmpty()) {
                                    System.out.println("La lista de productos está vacía.");
                                } else {
                                    listaProductos.forEach(System.out::println);
                                }
                                break;
                            case 3:
                                System.out.print("ID del producto a actualizar: ");
                                int idProducto = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Nuevo precio unitario: ");
                                double nuevoPrecio = sc.nextDouble();
                                System.out.print("Nueva cantidad en stock: ");
                                int nuevaCantidad = sc.nextInt();
                                sc.nextLine();
                                // Se crea un objeto temporal solo para la actualización de estos campos.
                                Producto productoActualizar = new Producto();
                                productoActualizar.setId(idProducto);
                                productoActualizar.setPrecioUnitario(nuevoPrecio);
                                productoActualizar.setCantidadStock(nuevaCantidad);
                                if (productoDAO.actualizar(productoActualizar)) {
                                    System.out.println("✅ Producto actualizado correctamente.");
                                } else {
                                    System.out.println("❌ Fallo al actualizar el producto.");
                                }
                                break;
                            case 4:
                                System.out.print("ID del producto a eliminar: ");
                                int idProductoDel = sc.nextInt();
                                if (productoDAO.eliminar(idProductoDel)) {
                                    System.out.println("✅ Producto eliminado correctamente.");
                                } else {
                                    System.out.println("❌ Fallo al eliminar el producto.");
                                }
                                break;
                            case 9:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción inválida. Intenta de nuevo.");
                        }
                    } while (opcionProducto != 9);
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcionPrincipal != 0);
        
        sc.close();
    }
}
