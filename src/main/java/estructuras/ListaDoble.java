/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import javax.swing.JOptionPane;
import nodos.NodoArbolAVL;
import nodos.NodoListaDoble;

/**
 *
 * @author erikssonherlo
 */
public class ListaDoble {
     private NodoListaDoble primero;
    private int cantidad;
    
    public ListaDoble() {
        this.primero = null;
        this.cantidad = 0;
    }
    
    public void insertar(NodoArbolAVL nodoCapa) {
        NodoListaDoble nuevo = new NodoListaDoble(nodoCapa);
        if(primero == null) {
            primero = nuevo;
        } else {
            NodoListaDoble aux = primero;
            while(aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
            
        }
        cantidad++;
    }
    
    
    /**
     * Busqueda del Nodo que contenga alguna Capa
     * @param id
     * @return 
     */
    public NodoArbolAVL buscar(String id) {
        if(primero != null) {
            NodoListaDoble aux = primero;
            while(aux != null) {
                if(aux.getNodoCapa().getId().equals(id)) {
                    return aux.getNodoCapa();
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
  
    /**
     * Busqueda de un Nodo en base a su Posicion
     * @param posicion
     * @return 
     */
    public NodoArbolAVL buscar(int posicion) {
        if(posicion > cantidad) {
            throw new IndexOutOfBoundsException("La Posición que desea Buscar, se encuentra fuera de los limites");
        }
        int cont = 0;
        NodoListaDoble aux = primero;
        while(aux != null) {
            if(cont == posicion) {
                return aux.getNodoCapa();
            }
            cont++;
            aux = aux.getSiguiente();
        }
        return null;
    }
    
    public void imprimirLista() {
        if(primero != null) {
            NodoListaDoble aux = primero;
            while(aux != null) {
                System.out.println("nodo: " + aux.getNodoCapa().getId());
                aux = aux.getSiguiente();
            }
        }
    }

    
    public String getDotCode(String padre) {
        String codigo = "";
        NodoListaDoble aux = primero;
        while(aux != null) {
            codigo += "capa" + padre + "o" + aux.getNodoCapa().getId() + " [ label =\"capa: " + aux.getNodoCapa().getId() + "\"];\n";
            aux = aux.getSiguiente();
        }
        aux = primero;
        while(aux != null) {
            if(aux == primero) {
                codigo += "nodo" + padre + "->capa" + padre + "o" + aux.getNodoCapa().getId();
            } else {
                codigo += "->capa" + padre + "o" + aux.getNodoCapa().getId();
            }
            aux = aux.getSiguiente();
        }
        codigo += "\n";
        return codigo;
    }
    
    public String getDotCodeArbol(String padre, ArbolAVL arbolCapas) {
        String codigo = "";
        codigo += "subgraph cluster_1 {\n";
        codigo += arbolCapas.getCodigoNodos(arbolCapas.getRaiz());
        codigo += "color=\"White\";\n";
        codigo += "}\n";
        codigo += "subgraph cluster_2 {\n";
        NodoListaDoble aux = primero;
        while(aux != null) {
            codigo += "capa" + padre + "o" + aux.getNodoCapa().getId() + " [ label =\"capa: " + aux.getNodoCapa().getId() + "\", fillcolor=\"lightblue\", style=\"filled\"];\n";
            aux = aux.getSiguiente();
        }
        aux = primero;
        while(aux != null) {
            if(aux == primero) {
                codigo += "nodoIm" + padre + "->capa" + padre + "o" + aux.getNodoCapa().getId();
            } else {
                codigo += "->capa" + padre + "o" + aux.getNodoCapa().getId();
            }
            aux = aux.getSiguiente();
        }
        codigo += "\n";
        codigo += "}\n";
        
        aux = primero;
        while(aux != null) {
            codigo += "capa" + padre + "o" + aux.getNodoCapa().getId() + "->nodo" + aux.getNodoCapa().getId() + "\n";
            aux = aux.getSiguiente();
        }
        return codigo;
    }

    public NodoListaDoble getPrimero() {
        return primero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setPrimero(NodoListaDoble primero) {
        this.primero = primero;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
