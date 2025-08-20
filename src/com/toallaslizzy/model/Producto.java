/*
 * Esta clase representa la tabla 'Producto' de la base de datos.
 * Contiene los atributos de la tabla y métodos para acceder a ellos.
 */
package com.toallaslizzy.model;

public class Producto {

    private int Id;
    private String Referencia;
    private double Gramos;
    private String Tamano;
    private String Color;
    private double PrecioUnitario;
    private int CantidadStock;
    private String Estado;

    // Constructor vacío (necesario para algunas operaciones)
    public Producto() {
    }

    // Constructor completo para crear nuevos objetos Producto
    public Producto(int Id, String Referencia, double Gramos, String Tamano, String Color, double PrecioUnitario, int CantidadStock, String Estado) {
        this.Id = Id;
        this.Referencia = Referencia;
        this.Gramos = Gramos;
        this.Tamano = Tamano;
        this.Color = Color;
        this.PrecioUnitario = PrecioUnitario;
        this.CantidadStock = CantidadStock;
        this.Estado = Estado;
    }

    // Getters y Setters para acceder a los atributos
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = Id;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public double getGramos() {
        return Gramos;
    }

    public void setGramos(double Gramos) {
        this.Gramos = Gramos;
    }

    public String getTamano() {
        return Tamano;
    }

    public void setTamano(String Tamano) {
        this.Tamano = Tamano;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public int getCantidadStock() {
        return CantidadStock;
    }

    public void setCantidadStock(int CantidadStock) {
        this.CantidadStock = CantidadStock;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Producto{" +
               "Id=" + Id +
               ", Referencia='" + Referencia + '\'' +
               ", Gramos=" + Gramos +
               ", Tamano='" + Tamano + '\'' +
               ", Color='" + Color + '\'' +
               ", PrecioUnitario=" + PrecioUnitario +
               ", CantidadStock=" + CantidadStock +
               ", Estado='" + Estado + '\'' +
               '}';
    }
}
