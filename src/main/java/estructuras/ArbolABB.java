/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import javax.swing.JOptionPane;
import nodos.NodoArbolABB;

/**
 *
 * @author erikssonherlo
 */
public class ArbolABB {
      private NodoArbolABB raiz;

    public ArbolABB() {
        this.raiz = null;
    }

    public void insertarNodo(NodoArbolABB nuevoNodo) {
        raiz = insertarABB(raiz, nuevoNodo);
    }

    private NodoArbolABB insertarABB(NodoArbolABB nodoActual, NodoArbolABB nuevoNodo) {
        if (nodoActual == null)
        {
            return nuevoNodo;
        }
        //INSERCION DEL NODO IZQUIERDO
        if (nuevoNodo.getId() < nodoActual.getId())
        {
            nodoActual.setHijoIzquierdo(insertarABB(nodoActual.getHijoIzquierdo(), nuevoNodo));
        }
        //INSERCION DEL NODO DERECHO
        else if (nuevoNodo.getId() > nodoActual.getId())
        {
            nodoActual.setHijoDerecho(insertarABB(nodoActual.getHijoDerecho(), nuevoNodo));
        } else
        {
            JOptionPane.showMessageDialog(null, "La capa ya existe");
            return nodoActual;
        }

        return nodoActual;
    }

    public NodoArbolABB buscarNodo(int id) {
        return obtenerNodo(raiz, id);
    }

    private NodoArbolABB obtenerNodo(NodoArbolABB nodoActual, int id) {
        if (nodoActual == null)
        {
            return null;
        } else if (id == nodoActual.getId())
        {
            return nodoActual;
        } else if (id < nodoActual.getId())
        {
            return obtenerNodo(nodoActual.getHijoIzquierdo(), id);
        } else
        {
            return obtenerNodo(nodoActual.getHijoDerecho(), id);
        }

    }

    public void mostrarArbol() {
        System.out.println("ARBOL ABB DE CAPAS");
        obtenerNodos(raiz);
    }

    private void obtenerNodos(NodoArbolABB nodoActual) {

        if (nodoActual != null)
        {

            if (nodoActual.getHijoIzquierdo() != null)
            {
                System.out.print("\nNodo padre: " + nodoActual.getId() + " >>>> Hijo Izquierdo: " + nodoActual.getHijoIzquierdo().getId());
                obtenerNodos(nodoActual.getHijoIzquierdo());
            }

            if (nodoActual.getHijoDerecho() != null)
            {
                System.out.print("\nNodo padre: " + nodoActual.getId() + " >>>> Hijo Derecho: " + nodoActual.getHijoDerecho().getId());
                obtenerNodos(nodoActual.getHijoDerecho());
            }

            if (nodoActual.getHijoIzquierdo() == null && nodoActual.getHijoDerecho() == null)
            {
                System.out.print("\nNodo hoja: " + nodoActual.getId());
            }
        } else
        {
            System.out.println("ARBOL ABB DE CAPAS VACIO");
        }

    }
}
