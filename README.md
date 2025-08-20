# tolLizzyW

Proyecto Demo – Comercializadora de Toallas Lizzy
Curso ADSO 2025
ficha:2983215

1.Descripción del Proyecto
Este proyecto es una aplicación de consola en Java diseñada para la gestión de usuarios y productos de la comercializadora Toallas Lizzy.
Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre la base de datos toallas_lizzy, demostrando la conexión entre Java y MySQL usando JDBC.

El objetivo principal es mostrar cómo estructurar un proyecto real con buenas prácticas en capas (conexión, DAO, modelo, vista, pruebas).

2.Tecnologías Utilizadas
Lenguaje de Programación: Java
Gestor de Base de Datos: MySQL (con XAMPP/phpMyAdmin)
Conectividad: JDBC (Java Database Connectivity)
Entorno de Desarrollo: Apache NetBeans IDE 25
JDK: 21
Conector MySQL: mysql-connector-j-8.0.32

3.Descargas Necesarias
Antes de ejecutar el proyecto, debia estar instalado:
JDK 21 (Java Development Kit)
Apache NetBeans IDE 25
XAMPP (incluye MySQL y phpMyAdmin)
MySQL Connector/J (Versión 8.0.32)

4.Estructura del Proyecto
El proyecto está organizado en paquetes, cada uno con una función específica:

com.toallaslizzy.conexion
Conexion.java → Clase para establecer la conexión con la base de datos.

com.toallaslizzy.dao
UsuarioDAO.java → DAO para gestionar CRUD de usuarios.
ProductoDAO.java → DAO para gestionar CRUD de productos.

com.toallaslizzy.model
Usuario.java → Clase modelo para representar un usuario.
Producto.java → Clase modelo para representar un producto.

com.toallaslizzy.test
TestUsuario.java → Pruebas de CRUD para la entidad Usuario.
TestProducto.java → Pruebas de CRUD para la entidad Producto.

com.toallaslizzy.vista
MainAPP.java → Clase principal, punto de entrada de la aplicación (control de flujo).

5. Base de Datos(MYSQL) – toallas_lizzy
La base de datos contiene 24 tablas (clientes, pedidos, ventas, proveedores, inventario, etc.), pero en este proyecto demo solo se implementan 2 módulos principales:
Usuario → Para manejar el acceso de usuarios al sistema.
Producto → Para la gestión de productos en inventario.
Ejemolo de las tablas
CREATE TABLE Producto (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Referencia VARCHAR(255) NOT NULL,
    Gramos DOUBLE,
    Tamano VARCHAR(50),
    Color VARCHAR(50),
    PrecioUnitario DOUBLE,
    CantidadStock INT,
    Estado VARCHAR(50)
);
CREATE TABLE Usuario (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Email VARCHAR(255) UNIQUE,
    Telefono VARCHAR(20),
    RolId INT
);

6. Ejecución del Proyecto
6.1 Configurar la BD en MySQL:
Crear la BD toallas_lizzy.
Crear las tablas usuario y producto.
6.2 Configurar la conexión en Conexion.java:
private static final String URL = "jdbc:mysql://localhost:3306/toallas_lizzy";
private static final String USER = "root";
private static final String PASSWORD = "";
6.3 Probar en NetBeans:
Ejecutar TestUsuario.java → pruebas CRUD de usuarios.
Ejecutar TestProducto.java → pruebas CRUD de productos.

Nota Importante
La lógica implementada corresponde únicamente a los módulos Usuario y Producto, aunque la BD incluye más tablas para un futuro desarrollo completo.
