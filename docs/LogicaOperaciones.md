# Parte: Lógica de operaciones de la máquina

Clase principal: `maquina.logica.MaquinaExpendedora`

## Qué hace
| Instrucción | Método | Validaciones |
|---|---|---|
| `MONEDA(v);` | `insertarMoneda(v, linea)` | Solo Q1, Q5, Q10. Acumula el saldo. |
| `SELECCIONAR(c);` | `seleccionar(c, linea)` | Producto inexistente, sin existencias, sin dinero ingresado. |
| `COMPRAR();` | `comprar(linea)` | Sin selección, sin existencias, dinero insuficiente, compra confirmada dos veces. Descuenta 1 unidad y calcula el cambio. |
| `CANCELAR();` | `cancelar(linea)` | Devuelve el saldo y limpia la selección. |
| `MOSTRAR();` | `mostrar(linea)` | Devuelve la tabla del inventario. |

Cada método devuelve un `Resultado` con:
- `getTexto()` → mensajes `[OK] ...` / `[ERROR SEMANTICO] Linea n: ...`
- `getRecorrido()` / `getRecorridoTexto()` → estados recorridos (ej. `E2 -> E3 -> E4 -> E5 -> E0`)
- `getProductoEntregado()`, `getCambio()`, `getDineroDevuelto()`, `getTablaInventario()`

## Cómo se conecta con cada compañero

**Analizador (léxico/sintáctico/semántico):** por cada instrucción válida de operación llamar
```java
Resultado r = maquina.ejecutar("MONEDA", Arrays.asList("5"), numeroLinea);
```
`PRODUCTO` y `CARGAR` devuelven `null` porque los ejecuta la parte de inventario.

**Interfaz Swing:** los botones llaman directo a los métodos con `linea = 0`:
```java
maquina.insertarMoneda(5, 0);   maquina.comprar(0);   maquina.cancelar(0);
maquina.addListener((m, r) -> { /* refrescar saldo, estado, tabla, entregado */ });
```
Getters: `getSaldo()`, `getEstadoActual()`, `getProductoSeleccionado()`, `getUltimoEntregado()`, `getUltimoCambio()`.

**Autómata finito:** la máquina usa la interfaz `maquina.automata.ControlEstados`
(`getEstado()`, `puedeTransitar(Entrada)`, `transitar(Entrada)`, `reiniciar()`).
`AutomataMaquina` es una implementación de referencia; la versión final se pasa en el constructor:
```java
new MaquinaExpendedora(inventario, automataDelCompanero);
```

**Productos, inventario y JSON:** `Producto` e `Inventario` en `maquina.modelo` son versiones mínimas.
La lógica solo necesita `Inventario.buscar(codigo)`, `getProductos()` y en `Producto`:
`getCodigo()`, `getNombre()`, `getPrecio()`, `getCantidad()`, `tieneExistencias()`, `descontarUnidad()`.
Para el JSON del estado: guardar `getSaldo()` y el código seleccionado, y al importar usar
`restaurarOperacion(saldo, codigo)`.

## Prueba
Ejecutar `maquina.PruebaLogica` (reproduce los 3 ejemplos del enunciado + casos extra).
Compatible con Java 8 o superior.
