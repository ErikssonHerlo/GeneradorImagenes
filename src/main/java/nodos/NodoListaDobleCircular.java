/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

import estructuras.ArbolAVL;
import estructuras.ListaDoble;

/**
 *
 * @author erikssonherlo
 */
public class NodoListaDobleCircular {
    private String id;
    private ListaDoble listaCapas;
    private NodoListaDobleCircular siguiente;
    private NodoListaDobleCircular anterior;
    
    public NodoListaDobleCircular(String id) {
        this.id = id;
        this.siguiente = null;
        this.anterior = null;
        this.listaCapas = new ListaDoble();
        
    }
    public NodoListaDobleCircular(String id, ListaDoble listaCapas) {
        this.id = id;
        this.siguiente = null;
        this.anterior = null;
        this.listaCapas = listaCapas;
    }

    public String getId() {
        return id;
    }

    public ListaDoble getListaCapas() {
        return listaCapas;
    }

    public NodoListaDobleCircular getSiguiente() {
        return siguiente;
    }

    public NodoListaDobleCircular getAnterior() {
        return anterior;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setListaCapas(ListaDoble listaCapas) {
        this.listaCapas = listaCapas;
    }

    public void setSiguiente(NodoListaDobleCircular siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoListaDobleCircular anterior) {
        this.anterior = anterior;
    }

   
    
    public String dotCode(ArbolAVL arbolCapas) {
        String salidaGraphviz = "";
        salidaGraphviz += "digraph listaDoble {\n";
        salidaGraphviz += "rankdir=TB\n";
        salidaGraphviz += "node [shape = record]\n";
        salidaGraphviz += listaCapas.getDotCodeArbol(id, arbolCapas);
        salidaGraphviz += "}\n";
        return salidaGraphviz;
    }
}
