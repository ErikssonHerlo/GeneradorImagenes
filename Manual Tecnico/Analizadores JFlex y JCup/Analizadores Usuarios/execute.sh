#!/usr/bin/bash
echo "Compilando parser..."
java -jar /home/erikssonherlo/Descargas/java-cup-bin-11b-20160615/java-cup-11b.jar SyntaxUsuarios.cup
echo "Parser compilado!"
echo "Copiando parser.java"
cp -i ParserUsuarios.java /home/erikssonherlo/NetBeansProjects/GeneradorImagenes/src/main/java/gramatica/usuarios/
echo "Parser.java copiado!!!"
echo "Copiando sym.java"
cp -i ParserUsuariosSym.java /home/erikssonherlo/NetBeansProjects/GeneradorImagenes/src/main/java/gramatica/usuarios/
echo "sym.java copiado!!!"
