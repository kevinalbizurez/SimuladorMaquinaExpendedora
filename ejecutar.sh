#!/bin/sh
# Compila y ejecuta el proyecto en Linux/macOS/Git Bash
cd "$(dirname "$0")"
mkdir -p bin
javac -encoding UTF-8 -d bin $(find src -name "*.java") && java -Dfile.encoding=UTF-8 -cp bin maquina.PruebaLogica
