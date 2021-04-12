/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import UI.CRUDUsuario;
import UI.CargarArchivos;
import UI.GenerarImagenes;
import UI.GraficarMemoria;
import UI.InterfazInicial;

/**
 *
 * @author erikssonherlo
 */
public class Main {
public static InterfazInicial interfaz = new InterfazInicial();
public static EstructuraGeneral estructuraGeneral = new EstructuraGeneral();
public static ArchivosEntrada archivosEntrada = new ArchivosEntrada();
public static GeneradorGraphviz graficador = new GeneradorGraphviz();
public static CargarArchivos interfazCargaArchivos = new CargarArchivos();
public static GraficarMemoria interfazGraphviz = new GraficarMemoria();
public static GenerarImagenes interfazImagenes = new GenerarImagenes();
public static CRUDUsuario interfazCRUDUsuarios = new CRUDUsuario();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        interfaz.setVisible(true);
    }
    
}
