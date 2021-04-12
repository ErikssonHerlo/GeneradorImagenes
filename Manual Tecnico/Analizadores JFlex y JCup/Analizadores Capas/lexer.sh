#!/usr/bin/bash
echo "Compilando lexer..."
jflex LexerCapas.jflex
echo "Lexer compilado!"
echo "Copiando LexerCapas.java"
cp -i LexerCapas.java /home/erikssonherlo/NetBeansProjects/GeneradorImagenes/src/main/java/gramatica/capas/
echo "LexerCapas.java copiado!!!"
