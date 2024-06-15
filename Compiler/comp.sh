#!/bin/bash

# Ejecutar JFlex
echo -e  "\n****** Compilando con JFLEX ******\n"
jflex PLXC.flex
echo -e  "\n\t\t------ Compilación en JFLEX completada ------\n"

# Ejecutar CUP
echo -e  "****** Compilando con CUP ******\n"
cup PLXC.cup
echo -e  "\n\t\t------ Compilación en CUP completada ------\n"

# Compilar los archivos Java resultantes
echo -e  "****** Compilando con JAVA ******\n"
javac *.java
echo -e "\n\t\t------ Compilación en JAVA completada ------"

echo -e "\n\t\t************ Compilación de TODO completada ************\n"

