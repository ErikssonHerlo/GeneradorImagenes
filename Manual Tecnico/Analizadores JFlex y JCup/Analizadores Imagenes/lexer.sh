#!/usr/bin/bash
echo "Compilando lexer..."
jflex LexerImagenes.jflex
echo "Lexer compilado!"
echo "Copiando Lexer.java"
cp -i LexerImagenes.java /home/erikssonherlo/NetBeansProjects/GeneradorImagenes/src/main/java/gramatica/imagenes/
echo "Lexer.java copiado!!!"
