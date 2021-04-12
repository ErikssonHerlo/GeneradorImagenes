/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

/**
 *
 * @author erikssonherlo
 */
public class NodoListaDoble {
        private int id;
    private NodoArbolAVL nodoCapa;
    private NodoListaDoble anterior;
    private NodoListaDoble siguiente;
    
    public NodoListaDoble(NodoArbolAVL nodoCapa){
        this.nodoCapa = nodoCapa;
        this.anterior = null;
        this.siguiente = null;
    }

    public int getId() {
        return id;
    }

    public NodoArbolAVL getNodoCapa() {
        return nodoCapa;
    }

    public NodoListaDoble getAnterior() {
        return anterior;
    }

    public NodoListaDoble getSiguiente() {
        return siguiente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNodoCapa(NodoArbolAVL nodoCapa) {
        this.nodoCapa = nodoCapa;
    }

    public void setAnterior(NodoListaDoble anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(NodoListaDoble siguiente) {
        this.siguiente = siguiente;
    }

   
}
