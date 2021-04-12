/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import nodos.NodoListaDobleCircular;
import nodos.NodoListaDobleImagenes;

/**
 *
 * @author erikssonherlo
 */
public class ListaDobleImagenes {
      private NodoListaDobleImagenes primero;
    private int cantidad;
    
    public ListaDobleImagenes() {
        this.primero = null;
        this.cantidad = 0;
    }
    
    public void insertar(NodoListaDobleCircular nodoImagen) {
        try {
            NodoListaDobleImagenes nuevo = new NodoListaDobleImagenes(nodoImagen);
            if(primero == null) {
                primero = nuevo;
            } else { 
                NodoListaDobleImagenes aux = primero;
                System.out.println("El primero de la lista es: " + primero.getNodoImagen().getId());
                while(aux.getSiguiente() != null) {
                    System.out.println("pudo entrar a la condicion");
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(nuevo);
                nuevo.setAnterior(aux);
            }
            cantidad++;
        } catch (Exception e) {
            System.out.println("Error al insertar nodoImagen: " + e.getMessage());
        }
    }
    
    public NodoListaDobleCircular buscar(String identificador) {
        if(primero != null) {
            NodoListaDobleImagenes aux = primero;
            while(aux != null) {
                if(aux.getNodoImagen().getId().equals(identificador)) {
                    return aux.getNodoImagen();
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
    public void imprimirLista() {
        if(primero != null) {
            NodoListaDobleImagenes aux = primero;
            while(aux != null) {
                System.out.println("nodo: " + aux.getNodoImagen().getId());
                aux = aux.getSiguiente();
            }
        }
    }

    public NodoListaDobleImagenes getPrimero() {
        return primero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setPrimero(NodoListaDobleImagenes primero) {
        this.primero = primero;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
