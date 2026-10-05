# Simulador de Máquina Expendedora — Autómatas y Lenguajes Formales

Simulador en Java (Swing) que interpreta archivos `.vm`, controla la compra con un autómata finito
y guarda/recupera la configuración en JSON.

## Estructura

```
src/maquina/
├── modelo/       Productos e inventario            -> Productos, inventario y JSON
├── json/         Importación / exportación JSON    -> Productos, inventario y JSON
├── logica/       Operaciones de la máquina         -> Lógica de operaciones   (listo)
├── automata/     Estados E0–E5 y transiciones      -> Autómata finito
├── analizador/   Léxico, sintáctico y semántico    -> Analizador
├── gui/          Interfaz Java Swing               -> Interfaz gráfica
└── PruebaLogica.java   Prueba de consola de la lógica
ejemplos/         Archivos .vm del enunciado
docs/             Documentación de cada parte
```

`modelo/` y `automata/` ya tienen versiones mínimas para que la lógica compile; sus responsables
pueden reemplazarlas siempre que conserven los métodos descritos en `docs/LogicaOperaciones.md`.

## Flujo de trabajo con Git

1. Clonar: `git clone <url-del-repo>`
2. Crear una rama para tu parte:
   `git checkout -b parte/analizador` (o `parte/gui`, `parte/automata`, `parte/inventario-json`)
3. Trabajar **solo dentro de tu paquete** para evitar conflictos.
4. Subir cambios: `git add .` → `git commit -m "mensaje"` → `git push -u origin parte/<tu-parte>`
5. Abrir un Pull Request hacia `main` en GitHub para que el equipo lo revise.
6. Antes de empezar cada día: `git checkout main && git pull`, luego `git merge main` en tu rama.

## Compilar y ejecutar (Java 8+)

```
javac -encoding UTF-8 -d bin $(find src -name "*.java")
java -cp bin maquina.PruebaLogica
```

En NetBeans/IntelliJ/Eclipse: abrir como proyecto con fuentes existentes y marcar `src` como carpeta de código.

## Partes del proyecto

| Parte | Paquete |
|---|---|
| Productos, inventario y JSON | `modelo`, `json` |
| Lógica de operaciones de la máquina | `logica` |
| Autómata finito | `automata` |
| Interfaz gráfica Java Swing | `gui` |
| Analizador léxico, sintáctico y semántico | `analizador` |
