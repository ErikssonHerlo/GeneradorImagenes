/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import estructuras.ListaDoble;
import estructuras.MatrizDispersa;
import java.awt.Color;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import nodos.NodoMatriz;

/**
 *
 * @author erikssonherlo
 */
public class GeneradorGraphviz {
     public void graficarEstadoMemoria(String dotCode, String nombreArchivo) {
        String archivoGenerado = nombreArchivo + ".dot";
        System.out.println(dotCode);
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(archivoGenerado);
            PrintWriter writer = new PrintWriter(fichero);
            writer.print(dotCode);
            fichero.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo dot: " + e.getMessage());
        } finally {
            try {
                if(null != fichero) {
                    fichero.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar el archivo");
            }
        }
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("dot -Tpng " + archivoGenerado  + " -o " + nombreArchivo + ".png");
            System.out.println("dot -Tpng " + archivoGenerado  + " -o " + nombreArchivo + ".png");
            Thread.sleep(500);
            JOptionPane.showMessageDialog(null, "Imagen Generada en la carpeta del proyecto");
        } catch (Exception e) {
            System.out.println("Error al generar la imagen");
        }
    }
    
    public void graficarImagen(ListaDoble listaCapasGraficar, JPanel panelGraficacion) {
        panelGraficacion.removeAll();
        int x = 0;
        int y = 0;
        for(int i = 0; i < listaCapasGraficar.getCantidad(); i++){
            MatrizDispersa matrizAux = (MatrizDispersa) listaCapasGraficar.buscar(i).getContenido();
            int totalColumnas = matrizAux.getTotalColumnas();
            int totalFilas = matrizAux.getTotalFilas();
            if(totalColumnas > x){
                x = totalColumnas;
            }
            if(totalFilas > y) {
                y = totalFilas;
            }
            
        }
        System.out.println("El total de columnas es: " + x + ". Y el total de filas es: " + y);
        int anchoBoton = panelGraficacion.getWidth() / x;
        int altoBoton = panelGraficacion.getHeight() / y;
        
        for(int capaRecorrida = listaCapasGraficar.getCantidad()-1;  capaRecorrida >= 0; capaRecorrida--) {
            for(int i = 1; i <= x; i++){
                for(int j = 1; j <= y; j++) {
                    MatrizDispersa matrizAux = (MatrizDispersa) listaCapasGraficar.buscar(capaRecorrida).getContenido();
                    NodoMatriz nodo;
                    if((nodo = matrizAux.busqueda(i, j)) != null)
                    {
                        int xPane = anchoBoton*i - anchoBoton;
                        int yPane = altoBoton*j - altoBoton;
                        nodo.getBoton().setBounds(xPane, yPane, anchoBoton, altoBoton);
                        nodo.getBoton().setBackground(Color.decode(nodo.getContenido()));
                        nodo.getBoton().setVisible(true);
                        nodo.getBoton().setEnabled(false);
                        panelGraficacion.add(nodo.getBoton());
                    }
                }
            } 
        }
        
        
        panelGraficacion.repaint();

    }
}
