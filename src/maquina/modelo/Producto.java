package maquina.modelo;

/**
 * Producto de la máquina expendedora.
 *
 * NOTA DE INTEGRACIÓN: esta clase es la versión mínima que necesita la parte
 * "Lógica de operaciones". Si el compañero de "Productos, inventario y JSON"
 * entrega su propia clase Producto, basta con que tenga estos métodos:
 *   getCodigo(), getNombre(), getPrecio(), getCantidad(), descontarUnidad()
 */
public class Producto {

    private final String codigo;
    private final String nombre;
    private final int precio;    // en quetzales
    private int cantidad;        // existencias

    public Producto(String codigo, String nombre, int precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo()  { return codigo; }
    public String getNombre()  { return nombre; }
    public int getPrecio()     { return precio; }
    public int getCantidad()   { return cantidad; }

    public boolean tieneExistencias() { return cantidad > 0; }

    /** Descuenta una unidad. Devuelve false si no había existencias. */
    public boolean descontarUnidad() {
        if (cantidad <= 0) return false;
        cantidad--;
        return true;
    }

    /** Usado por CARGAR (parte de inventario). */
    public void agregarUnidades(int unidades) {
        cantidad += unidades;
    }

    @Override
    public String toString() {
        return codigo + " | " + nombre + " | Q" + precio + " | " + cantidad + " u.";
    }
}
