/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import UI.InterfazInicial;
import estructuras.ArbolAVL;
import estructuras.ListaDoble;
import estructuras.ListaDobleCircular;

/**
 *
 * @author erikssonherlo
 */
public class EstructuraGeneral {
    
    private ArbolAVL arbolCapas ;
    private ListaDobleCircular listaImagenes;
    private ArbolAVL arbolUsuarios;

    public EstructuraGeneral() {
        this.arbolCapas = new ArbolAVL();
        this.listaImagenes = new ListaDobleCircular();
        this.arbolUsuarios = new ArbolAVL();
    }

    public ArbolAVL getArbolCapas() {
        return arbolCapas;
    }

    public ListaDobleCircular getListaImagenes() {
        return listaImagenes;
    }

    public ArbolAVL getArbolUsuarios() {
        return arbolUsuarios;
    }

    public void setArbolCapas(ArbolAVL arbolCapas) {
        this.arbolCapas = arbolCapas;
    }

    public void setListaImagenes(ListaDobleCircular listaImagenes) {
        this.listaImagenes = listaImagenes;
    }

    public void setArbolUsuarios(ArbolAVL arbolUsuarios) {
        this.arbolUsuarios = arbolUsuarios;
    }

   

    
}
