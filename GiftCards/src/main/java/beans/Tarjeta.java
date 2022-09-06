package beans;

/**
 *
 * @author Laura
 */
public class Tarjeta {
    
    private int id_tarjeta;
    private String  nombre;
    private String categoria;
    private double precio;
    private int unidades_disponibles;
    private boolean descuento;
    private String codigo_canjeo;

    public Tarjeta(int id_tarjeta, String nombre, String categoria, double precio, int unidades_disponibles, boolean descuento, String codigo_canjeo) {
        this.id_tarjeta = id_tarjeta;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.unidades_disponibles = unidades_disponibles;
        this.descuento = descuento;
        this.codigo_canjeo = codigo_canjeo;
    }

    public int getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getUnidades_disponibles() {
        return unidades_disponibles;
    }

    public void setUnidades_disponibles(int unidades_disponibles) {
        this.unidades_disponibles = unidades_disponibles;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public String getCodigo_canjeo() {
        return codigo_canjeo;
    }

    public void setCodigo_canjeo(String codigo_canjeo) {
        this.codigo_canjeo = codigo_canjeo;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "id_tarjeta=" + id_tarjeta + ", nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio + ", unidades_disponibles=" + unidades_disponibles + ", descuento=" + descuento + ", codigo_canjeo=" + codigo_canjeo + '}';
    }
}