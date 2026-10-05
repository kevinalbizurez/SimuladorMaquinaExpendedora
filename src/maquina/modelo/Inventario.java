package maquina.modelo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Inventario de productos.
 *
 * NOTA DE INTEGRACIÓN: versión mínima para poder probar la lógica de
 * operaciones. La parte "Productos, inventario y JSON" es dueña de esta clase
 * (registro con PRODUCTO, CARGAR, duplicados, JSON). La lógica de operaciones
 * solo usa:  buscar(codigo)  y  getProductos().
 */
public class Inventario {

    // LinkedHashMap conserva el orden de registro (útil para MOSTRAR y la GUI)
    private final Map<String, Producto> productos = new LinkedHashMap<>();

    public Producto buscar(String codigo) {
        if (codigo == null) return null;
        return productos.get(codigo.trim().toUpperCase());
    }

    public boolean existe(String codigo) {
        return buscar(codigo) != null;
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos.values());
    }

    /** Registro simple (la validación completa la hace la parte de inventario). */
    public boolean registrar(Producto p) {
        String clave = p.getCodigo().trim().toUpperCase();
        if (productos.containsKey(clave)) return false;
        productos.put(clave, p);
        return true;
    }

    /** Recarga simple (la validación completa la hace la parte de inventario). */
    public boolean cargar(String codigo, int unidades) {
        Producto p = buscar(codigo);
        if (p == null) return false;
        p.agregarUnidades(unidades);
        return true;
    }

    public void limpiar() {
        productos.clear();
    }
}
