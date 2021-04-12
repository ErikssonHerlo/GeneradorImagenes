#!/usr/bin/bash
echo "Compilando parser..."
java -jar /home/erikssonherlo/Descargas/java-cup-bin-11b-20160615/java-cup-11b.jar SyntaxCapas.cup
echo "Parser compilado!"
echo "Copiando parser.java"
cp -i ParserCapas.java /home/erikssonherlo/NetBeansProjects/GeneradorImagenes/src/main/java/gramatica/capas/
echo "ParserCapas.java copiado!!!"
echo "Copiando sym.java"
cp -i ParserCapasSym.java /home/erikssonherlo/NetBeansProjects/GeneradorImagenes/src/main/java/gramatica/capas/
echo "sym.java copiado!!!"
