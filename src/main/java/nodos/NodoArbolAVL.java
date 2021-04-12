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
public class NodoArbolAVL {
     private String id;
    private Object contenido;
    private NodoArbolAVL izquierdo;
    private NodoArbolAVL derecha;
    private int factorEquilibrio;
    
    public NodoArbolAVL(String id) {
        this.id = id;
        this.izquierdo = null;
        this.derecha = null;
    }
    public NodoArbolAVL(String id, Object contenido) {
        this.id = id;
        this.contenido = contenido;
        this.izquierdo = null;
        this.derecha = null;
    }

    public String getId() {
        return id;
    }

    public Object getContenido() {
        return contenido;
    }

    public NodoArbolAVL getIzquierdo() {
        return izquierdo;
    }

    public NodoArbolAVL getDerecha() {
        return derecha;
    }

    public int getFactorEquilibrio() {
        return factorEquilibrio;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public void setIzquierdo(NodoArbolAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecha(NodoArbolAVL derecha) {
        this.derecha = derecha;
    }

    public void setFactorEquilibrio(int factorEquilibrio) {
        this.factorEquilibrio = factorEquilibrio;
    }

}
