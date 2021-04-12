#!/usr/bin/bash
echo "Compilando parser..."
java -jar /home/erikssonherlo/Descargas/java-cup-bin-11b-20160615/java-cup-11b.jar SyntaxImagenes.cup
echo "Parser compilado!"
echo "Copiando parser.java"
cp -i ParserImagenes.java /home/erikssonherlo/NetBeansProjects/GeneradorImagenes/src/main/java/gramatica/imagenes/
echo "Parser.java copiado!!!"
echo "Copiando sym.java"
cp -i ParserImagenesSym.java /home/erikssonherlo/NetBeansProjects/GeneradorImagenes/src/main/java/gramatica/imagenes/
echo "sym.java copiado!!!"
