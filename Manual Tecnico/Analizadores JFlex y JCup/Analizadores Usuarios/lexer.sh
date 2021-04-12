#!/usr/bin/bash
echo "Compilando lexer..."
jflex LexerUsuarios.jflex
echo "Lexer compilado!"
echo "Copiando Lexer.java"
cp -i LexerUsuarios.java /home/erikssonherlo/NetBeansProjects/GeneradorImagenes/src/main/java/gramatica/usuarios/
echo "Lexer.java copiado!!!"
