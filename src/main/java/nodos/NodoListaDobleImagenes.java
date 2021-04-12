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
public class NodoListaDobleImagenes {
    private NodoListaDobleCircular nodoImagen;
    private NodoListaDobleImagenes anterior;
    private NodoListaDobleImagenes siguiente;
    
    public NodoListaDobleImagenes(NodoListaDobleCircular nodoImagen) {
        this.nodoImagen = nodoImagen;
        this.anterior = null;
        this.siguiente = null;
    }

    public NodoListaDobleCircular getNodoImagen() {
        return nodoImagen;
    }

    public NodoListaDobleImagenes getAnterior() {
        return anterior;
    }

    public NodoListaDobleImagenes getSiguiente() {
        return siguiente;
    }

    public void setNodoImagen(NodoListaDobleCircular nodoImagen) {
        this.nodoImagen = nodoImagen;
    }

    public void setAnterior(NodoListaDobleImagenes anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(NodoListaDobleImagenes siguiente) {
        this.siguiente = siguiente;
    }

   
}
