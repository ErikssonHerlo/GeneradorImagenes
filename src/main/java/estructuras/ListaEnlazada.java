/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import javax.swing.JOptionPane;
import nodos.NodoListaEnlazada;

/**
 *
 * @author erikssonherlo
 */
public class ListaEnlazada {
    /**  private NodoListaEnlazada raiz;
    private NodoListaEnlazada fin;

    public ListaSimple() {
        this.raiz = null;
        this.fin = null;
    }

    public void insertarNodo(NodoListaEnlazada nuevoNodo) {

        NodoArbolABB capaArbol = Estructuras.buscarCapa(nuevoNodo.getId());
        if (capaArbol != null)
        {
            nuevoNodo.setContenido(capaArbol.getContenido());
            nuevoNodo.setCapa(capaArbol);
            if (raiz == null)
            {
                raiz = nuevoNodo;
                fin = nuevoNodo;
            } else if (buscarNodo(nuevoNodo.getId()) == null)
            {
                fin.setSiguiente(nuevoNodo);
                fin = nuevoNodo;
            } else
            {
                JOptionPane.showMessageDialog(null, "La capa ya existe");
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "La capa no ha sido creada");
        }

    }

    public NodoListaEnlazada buscarNodo(int id) {
        NodoListaEnlazada aux = raiz;

        while (aux != null)
        {
            if (aux.getId() == id)
            {
                return aux;
            } else
            {
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    public void mostrarDatos() {
        if (raiz != null)
        {
            NodoListaEnlazada aux = raiz;
            while (aux != null)
            {
                System.out.print("Nodo: " + aux.getId());
                System.out.print(" Capa en arbol: " + aux.getCapa().getId());
                if (aux.getSiguiente() != null)
                {
                    System.out.print(" Siguiente: " + aux.getSiguiente().getId());
                }
                System.out.println("\n");

                aux = aux.getSiguiente();
            }
        }else{
            System.out.println("lista vacia");
        }
    }

    public Matriz extraerNodo() {
        if (raiz != null)
        {
            Matriz capa = (Matriz) raiz.getContenido();
            if (raiz == fin)
            {
                raiz = fin = null;
            } else
            {
                raiz = raiz.getSiguiente();
            }
            return capa;
        } else
        {
            //JOptionPane.showMessageDialog(null, "La lista de capas esta vacia");
            return null;
        }
    }

    public Matriz obtenerCapa(int id) {
        if (raiz != null)
        {
            NodoListaEnlazada aux = buscarNodo(id);
            if (aux != null)
            {
                Matriz capa = (Matriz) aux.getContenido();
                return capa;
            } else
            {
                JOptionPane.showMessageDialog(null, "No existe capa");
                return null;
            }
        }
        JOptionPane.showMessageDialog(null, "Imagen no tiene capas");
        return null;
    }
    
    public boolean estaVacia(){
        if(raiz == null && fin == null){
            return true;
        }else{
            return false;
        }
    }
    * 
    */
}
