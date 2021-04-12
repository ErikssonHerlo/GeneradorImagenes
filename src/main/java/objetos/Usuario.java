/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import estructuras.ListaDoble;

/**
 *
 * @author erikssonherlo
 */
public class Usuario {
    private String id;
    private ListaDoble listaImagenes;
    
    public Usuario(String id) {
        this.listaImagenes = new ListaDoble();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

  
    public ListaDoble getListaImagenes() {
        return listaImagenes;
    }

    public void setListaImagenes(ListaDoble listaImagenes) {
        this.listaImagenes = listaImagenes;
    }
    
}
