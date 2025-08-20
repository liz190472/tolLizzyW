package com.toallaslizzy.test;

import com.toallaslizzy.dao.UsuarioDAO;
import com.toallaslizzy.model.Usuario;
import java.util.List;

public class TestUsuariojava {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        // 1. INSERTAR
        System.out.println("=== Insertar Usuario ===");
        Usuario u1 = new Usuario("Martha", "martha@test.com", "1986", 2);
        dao.insertar(u1);

        Usuario u2 = new Usuario("Tiburcia", "tiburcia@test.com", "2365", 1);
        dao.insertar(u2);

        // 2. LISTAR
        System.out.println("\n=== Listar Usuarios ===");
        List<Usuario> lista = dao.listar();
        for (Usuario u : lista) {
            System.out.println(u);
        }

        // 3. ACTUALIZAR
        System.out.println("\n=== Actualizar Usuario ===");
        Usuario actualizar = new Usuario("Elizabeth Actualizada", "eli@test.com", "98765", 2);
        dao.actualizar(actualizar);

        // Volvemos a listar para ver el cambio
        lista = dao.listar();
        for (Usuario u : lista) {
            System.out.println(u);
        }

        // 4. ELIMINAR
        System.out.println("\n=== Eliminar Usuario ===");
        dao.eliminar(3);

        // Listar otra vez para ver el resultado final
        lista = dao.listar();
        for (Usuario u : lista) {
            System.out.println(u);
        }
    }
}
