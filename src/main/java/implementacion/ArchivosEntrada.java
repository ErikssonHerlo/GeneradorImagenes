/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import estructuras.ArbolAVL;
import estructuras.ListaDobleCircular;
import gramatica.capas.LexerCapas;
import gramatica.capas.ParserCapas;
import gramatica.imagenes.LexerImagenes;
import gramatica.imagenes.ParserImagenes;
import gramatica.usuarios.LexerUsuarios;
import gramatica.usuarios.ParserUsuarios;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;

/**
 *
 * @author erikssonherlo
 */
public class ArchivosEntrada {
      public void entradaArchivoCapas(File archivoEntrada, ArbolAVL arbolCapas) {
        //Obtenemos el código del archivo .cap
        String codigo = obtenerCadenaArchivo(archivoEntrada);
        StringReader reader = new StringReader(codigo);
        LexerCapas lexer = new LexerCapas(reader);
        
        //LexerCapas lexer = new LexerCapas(reader);
        ParserCapas parser = new ParserCapas(lexer, arbolCapas);
        try {
            parser.parse();
        } catch (Exception e) {
           // System.out.println("Error al analizar el codigo de capas: XD" + e.printStackTrace(System.out));
           e.printStackTrace(System.out);
        }
          //System.out.println(arbolCapas.getRaiz());
        System.out.println(arbolCapas.dotCode());
    }
    
    public void entradaArchivoImagenes(File archivoEntrada, ListaDobleCircular listaImagenes, ArbolAVL arbolCapas) {
        String codigo = obtenerCadenaArchivo(archivoEntrada);
        StringReader reader = new StringReader(codigo);
        LexerImagenes lexer = new LexerImagenes(reader);
        ParserImagenes parser = new ParserImagenes(lexer, listaImagenes, arbolCapas);
        try {
            parser.parse();
            listaImagenes.imprimirLista();
        } catch (Exception e) {
            System.out.println("Error al analizar el codigo de imagenes: " + e.getMessage());
        }
    }
    
    public void entradaArchivoUsuarios(File archivoEntrada, ArbolAVL arbolUsuarios, ListaDobleCircular listaImagenes) {
        String codigo = obtenerCadenaArchivo(archivoEntrada);
        StringReader reader = new StringReader(codigo);
        LexerUsuarios lexer = new LexerUsuarios(reader);
        ParserUsuarios parser = new ParserUsuarios(lexer, arbolUsuarios, listaImagenes);
        try{
            parser.parse();
        } catch(Exception e) {
            System.out.println("Error al analizar el codigo de los usuarios: " + e.getMessage());
        }
    }
    
    private String obtenerCadenaArchivo(File archivo) {
        try {
            FileReader fileReader = new FileReader(archivo);
            
            BufferedReader lectorArchivo = new BufferedReader(fileReader);
            String cadena, codigo = "";
            //Almacenamos el codigo en la variable codigo
            while((cadena = lectorArchivo.readLine()) != null) {
                codigo += cadena + "\n";
            }
            System.out.println(codigo);
            return codigo;
            
        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
            return null;
        }
    }
    
}
