/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import nodos.NodoListaDobleCircular;

/**
 *
 * @author erikssonherlo
 */
public class ListaDobleCircular {
     private NodoListaDobleCircular primero;
    private NodoListaDobleCircular ultimo;
    private int cantidad;
    
    public ListaDobleCircular() {
        this.primero = null;
        this.ultimo = null;
        this.cantidad = 0;
    }
    
    public void insertar(String id, ListaDoble listaCapas) {
        NodoListaDobleCircular nuevoNodo = new NodoListaDobleCircular(id, listaCapas);
        if(primero == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else if(cantidad == 1) {
            if(id.compareTo(primero.getId()) > 0) {
                ultimo = nuevoNodo;
                primero.setSiguiente(ultimo);
                primero.setAnterior(ultimo);
                ultimo.setSiguiente(primero);
                ultimo.setAnterior(primero);
            } else if(id.compareTo(primero.getId()) < 0) {
                primero = nuevoNodo;
                primero.setSiguiente(ultimo);
                primero.setAnterior(ultimo);
                ultimo.setSiguiente(primero);
                ultimo.setAnterior(primero);
            } else {
                throw new RuntimeException("EL_NODO_YA_EXISTE");
            }
        } else {
            NodoListaDobleCircular aux = primero;
            while(true) {
                if(aux.getId().equals(id)) {
                    throw new RuntimeException("NODO_DUPLICADO");
                }
                if((id.compareTo(aux.getId()) > 0 && id.compareTo(aux.getSiguiente().getId()) < 0) || (aux == ultimo)) {
                    if(aux == primero) {
                        primero.setAnterior(nuevoNodo);
                        nuevoNodo.setSiguiente(primero);
                        nuevoNodo.setAnterior(ultimo);
                        ultimo.setSiguiente(nuevoNodo);
                        primero = nuevoNodo;
                        break;
                    } else if(aux == ultimo) {
                        ultimo.setSiguiente(nuevoNodo);
                        nuevoNodo.setAnterior(ultimo);
                        nuevoNodo.setSiguiente(primero);
                        primero.setAnterior(nuevoNodo);
                        ultimo = nuevoNodo;
                        break;
                    } else {
                        nuevoNodo.setSiguiente(aux.getSiguiente());
                        nuevoNodo.setAnterior(aux);
                        aux.getSiguiente().setAnterior(nuevoNodo);
                        aux.setSiguiente(nuevoNodo);
                        break;
                    }
                }
                aux = aux.getSiguiente();
                System.out.println(aux.getSiguiente().getId());
            }
        }
        cantidad++;
    }
    
    public void imprimirLista() {
        if(primero != null) {
            NodoListaDobleCircular aux = primero;
            do {
                System.out.println("Nodo: " + aux.getId());
                aux = aux.getSiguiente();
            }while(aux != primero);
        }
    }
    
    /**
     * Metodo que nos permite obtener un nodo perteneciente a la lista
     * 
     * @param id Identificador del objeto a encontrar
     * @return Nodo que contiene el objeto a identificar
     */
    public NodoListaDobleCircular buscar(String id) {
        if(primero != null) {
            NodoListaDobleCircular aux = primero;
            do {
                if(aux.getId().equals(id)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            } while(aux != primero);
        }
        return null;
    }
    
    public NodoListaDobleCircular buscar(int posicion) {
        int cont = 0;
        if(posicion > cantidad) {
            throw new IndexOutOfBoundsException("La Posicion que solicito, no se encuentra dentro de los Limites");
        }
        int conta = 0;
        NodoListaDobleCircular aux = primero;
        do {
            if(conta == posicion) {
                System.out.println("Nodo encontrado: " + aux.getId());
                return aux;
            }
            cont++;
            aux = aux.getSiguiente();
        } while(aux != primero);
        return null;
    }
    
    /**
     * Genera el código .dot para generar la gráfica de la estructura
     * Permite la generacion de una imagen 
     * @return 
     */
    public String dotCode() {
        String salidaGraphviz = "";
        salidaGraphviz += "digraph listaDoble {\n";
        salidaGraphviz += "node [shape = box]\n";
        salidaGraphviz += "edge [dir = both]\n";
        salidaGraphviz += "e0[ shape = point, width = 0 ];\n";
        salidaGraphviz += "e1[ shape = point, width = 0 ];\n";
        salidaGraphviz += getCodigoNodos();
        salidaGraphviz += "}\n";
        return salidaGraphviz;
    }
    
   
    public String getCodigoNodos() {
        String salidaGraphviz = "";
        if(primero != null) {
            NodoListaDobleCircular aux = primero;
            int c = 1;
            
            do {
                salidaGraphviz += "subgraph cluster_" + c + " {\n";
                salidaGraphviz += "nodo" + aux.getId() + " [ label =\"id: " + aux.getId() + "\", fillcolor=\"lightblue\", style=\"filled\"];\n";
                salidaGraphviz += aux.getListaCapas().getDotCode(aux.getId());
                salidaGraphviz += "}\n";
                c++;
                aux = aux.getSiguiente();
            } while (aux != primero);
            
            
            
            aux = primero;
            salidaGraphviz += "rank = same { ";
            do {
                if(aux == primero) {
                    salidaGraphviz += "nodo" + aux.getId() ;
                } else {
                    salidaGraphviz += "->nodo" + aux.getId();
                }
                if(aux.getSiguiente() == primero) {
                    salidaGraphviz += "->nodo" + aux.getSiguiente().getId();
                }
                
                aux = aux.getSiguiente();
            } while (aux != primero);
            salidaGraphviz += " };\n";
        }
        return salidaGraphviz;
    }

    public NodoListaDobleCircular getPrimero() {
        return primero;
    }

    public NodoListaDobleCircular getUltimo() {
        return ultimo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setPrimero(NodoListaDobleCircular primero) {
        this.primero = primero;
    }

    public void setUltimo(NodoListaDobleCircular ultimo) {
        this.ultimo = ultimo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
