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
public class NodoListaEnlazada {
    
    private int id;
    private Object contenido;
    private NodoListaEnlazada siguiente;
    private NodoArbolABB capa;

    public NodoListaEnlazada(int id) {
        this.id = id;
    }

    public NodoListaEnlazada(int id, Object contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public NodoListaEnlazada(Object contenido, NodoListaEnlazada siguiente) {
        this.contenido = contenido;
        this.siguiente = siguiente;
    }

    public Object getContenido() {
        return contenido;
    }

    public NodoListaEnlazada getSiguiente() {
        return siguiente;
    }

    public int getId() {
        return id;
    }

    public NodoArbolABB getCapa() {
        return capa;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public void setSiguiente(NodoListaEnlazada siguiente) {
        this.siguiente = siguiente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapa(NodoArbolABB capa) {
        this.capa = capa;
    }
}
