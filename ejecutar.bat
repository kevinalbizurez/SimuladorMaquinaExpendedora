@echo off
REM Compila y ejecuta el proyecto desde Windows (CMD o terminal de VS Code)
chcp 65001 > nul
cd /d "%~dp0"
if not exist bin mkdir bin
dir /s /b src\*.java > sources.txt
javac -encoding UTF-8 -d bin @sources.txt
if errorlevel 1 (
  del sources.txt
  echo Error de compilacion.
  exit /b 1
)
del sources.txt
java -Dfile.encoding=UTF-8 -cp bin maquina.PruebaLogica
