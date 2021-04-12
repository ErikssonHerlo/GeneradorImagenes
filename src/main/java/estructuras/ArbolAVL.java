/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import nodos.NodoArbolAVL;

/**
 *
 * @author erikssonherlo
 */
public class ArbolAVL {
   
    private NodoArbolAVL raiz;
    private int cantidad;
    
    public ArbolAVL() {
        this.raiz = null;
        this.cantidad = 0;
    }


    public void eliminar(String identificador) {
        if(raiz == null) {
            throw new RuntimeException("No se pueden eliminar nodos de un arbol vacio");
        } else {
            System.out.println("Raiz Antes de la Eliminacion: " + raiz.getId());
            raiz = eliminar(identificador, raiz);
            System.out.println("Raiz Despues de la Eliminacion: " + raiz.getId());
            cantidad--;
        }
    }
    
    private NodoArbolAVL eliminar(String identificador, NodoArbolAVL aux) {
        NodoArbolAVL padre = aux;
        System.out.println("Nodo Eliminar: " + aux.getId());
        if(aux.getId().compareTo(identificador) == 0) {
            if(aux.getDerecha() == null && aux.getIzquierdo() == null) {
                padre = null;
            } else if(aux.getDerecha() != null && aux.getIzquierdo() == null) {
                padre = aux.getDerecha();
            } else if(aux.getIzquierdo() != null && aux.getDerecha() == null) {
                padre = aux.getIzquierdo();
            } else {
                NodoArbolAVL nodoRecuperado = getDerechoAbsoluto(aux, aux.getIzquierdo());
                nodoRecuperado.setDerecha(aux.getDerecha());
                nodoRecuperado.setIzquierdo(aux.getIzquierdo());
                padre = nodoRecuperado;
            }
        } else {
            if(aux.getId().compareTo(identificador) > 0) {
                aux.setIzquierdo(eliminar(identificador, aux.getIzquierdo()));
            } else {
                aux.setDerecha(eliminar(identificador, aux.getDerecha()));
            }
        }
        if((factorEquilibrio(aux.getIzquierdo()) - factorEquilibrio(aux.getDerecha())) == 2) {
            if(factorEquilibrio(aux.getIzquierdo().getIzquierdo()) - factorEquilibrio(aux.getIzquierdo().getDerecha()) == -1) {
                padre = rotacionDobleIzquierda(aux);
            } else if(identificador.compareTo(aux.getId()) > 0) {
                padre = rotacionIzquierda(aux);
            } else {
                padre = rotacionDerecha(aux);
            }
        }
        if((factorEquilibrio(aux.getIzquierdo()) - factorEquilibrio(aux.getDerecha())) == -2) {
            if(factorEquilibrio(aux.getDerecha().getIzquierdo()) - factorEquilibrio(aux.getDerecha().getDerecha()) == 1) {
                padre = rotacionDobleDerecha(aux);
            } else if(identificador.compareTo(aux.getDerecha().getId()) > 0) {
                padre = rotacionIzquierda(aux);
            } else {
                padre = rotacionDerecha(aux);
            }                    
        }
        equilibrar(padre);
        return padre;
    }
    
    private NodoArbolAVL getDerechoAbsoluto(NodoArbolAVL nodoPadre, NodoArbolAVL nodo) {
        if(nodo.getDerecha() == null) {
            NodoArbolAVL aux = nodo;
            if(nodo.getIzquierdo() != null) {
                nodoPadre.setDerecha(nodo.getIzquierdo());
            }
            nodoPadre.setDerecha(null);
            return aux;
            
        } else {
            return getDerechoAbsoluto(nodo, nodo.getDerecha());
        }
    }
    
    public void insertar(NodoArbolAVL nodoInsertar) {
        if(raiz == null) {
            raiz = nodoInsertar;
            System.out.println("Se inserto el nodo xd");
        } else {
            raiz = insertarNodo(nodoInsertar, raiz);
        }
        cantidad++;
    }
    
    private NodoArbolAVL insertarNodo(NodoArbolAVL nuevo, NodoArbolAVL aux) {
        NodoArbolAVL padre = aux;
        if(nuevo.getId().compareTo(aux.getId()) < 0) {
            if(aux.getIzquierdo() == null) {
                aux.setIzquierdo(nuevo);
            } else {
                aux.setIzquierdo(insertarNodo(nuevo, aux.getIzquierdo()));
                //Se verifica si es necesario equilibrar el arbol
                if((factorEquilibrio(aux.getIzquierdo()) - factorEquilibrio(aux.getDerecha())) == 2) {
                    if(factorEquilibrio(aux.getIzquierdo().getIzquierdo()) - factorEquilibrio(aux.getIzquierdo().getDerecha()) == -1) {
                        padre = rotacionDobleIzquierda(aux);
                    } else if(nuevo.getId().compareTo(aux.getId()) < 0) {
                        padre = rotacionIzquierda(aux);
                    } else {
                        padre = rotacionDerecha(aux);
                    }
                }
            }
        } else if (nuevo.getId().compareTo(aux.getId()) > 0) {
            if(aux.getDerecha() == null) {
                aux.setDerecha(nuevo);
            } else {
                aux.setDerecha(insertarNodo(nuevo, aux.getDerecha()));
                //Se verifica si es necesario equilibrar el arbol
                if((factorEquilibrio(aux.getIzquierdo()) - factorEquilibrio(aux.getDerecha())) == -2) {
                    if(factorEquilibrio(aux.getDerecha().getIzquierdo()) - factorEquilibrio(aux.getDerecha().getDerecha()) == 1) {
                        padre = rotacionDobleDerecha(aux);
                    } else if(nuevo.getId().compareTo(aux.getDerecha().getId()) < 0) {
                        padre = rotacionIzquierda(aux);
                    } else {
                        padre = rotacionDerecha(aux);
                    }                    
                }
            }
        } else {
            //Los identificadres son iguales y por lo tanto no se pueden añadir
            //(no se pueden añadir elementos con identificador repetido)
            
            throw new RuntimeException("Nodo Repetido");
        }
        equilibrar(aux);
        return padre;
    }
    
    public void equilibrar(NodoArbolAVL aux) {
        if(aux.getIzquierdo() == null && aux.getDerecha() != null) {
            aux.setFactorEquilibrio(aux.getDerecha().getFactorEquilibrio() + 1);
        } else if(aux.getDerecha() == null && aux.getIzquierdo() != null) {
            aux.setFactorEquilibrio(aux.getIzquierdo().getFactorEquilibrio() + 1);
        } else {
            aux.setFactorEquilibrio(Math.max(factorEquilibrio(aux.getIzquierdo()), factorEquilibrio(aux.getDerecha())) + 1);
        }
        System.out.println("Factor equilibrio para " + aux.getId() + ": " + aux.getFactorEquilibrio());
    }
    
    public NodoArbolAVL buscar(String parametro) {
        return buscar(parametro, raiz);
    }
    
    public NodoArbolAVL buscar(String parametro, NodoArbolAVL nodo) {
        if(raiz == null) {
            return null;
        } 
        try {
            if(parametro.compareTo(nodo.getId()) == 0) {
                return nodo;
            } 
            if(parametro.compareTo(nodo.getId()) > 0) {
                return buscar(parametro, nodo.getDerecha());
            }
            if(parametro.compareTo(nodo.getId()) < 0) {
                return buscar(parametro, nodo.getIzquierdo());
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
    
    
    
    private NodoArbolAVL rotacionIzquierda(NodoArbolAVL nodo) {
        NodoArbolAVL aux = nodo.getIzquierdo();
        nodo.setIzquierdo(aux.getDerecha());
        aux.setDerecha(nodo);
        nodo.setFactorEquilibrio(Math.max(factorEquilibrio(nodo.getIzquierdo()), factorEquilibrio(nodo.getDerecha())) + 1);
        aux.setFactorEquilibrio(Math.max(factorEquilibrio(aux.getIzquierdo()), factorEquilibrio(aux.getDerecha())) + 1);
        return aux;
    }
    
    private NodoArbolAVL rotacionDerecha(NodoArbolAVL nodo) {
        NodoArbolAVL aux = nodo.getDerecha();
        nodo.setDerecha(aux.getIzquierdo());
        aux.setIzquierdo(nodo);
        nodo.setFactorEquilibrio(Math.max(factorEquilibrio(nodo.getIzquierdo()), factorEquilibrio(nodo.getDerecha())));
        aux.setFactorEquilibrio(Math.max(factorEquilibrio(aux.getIzquierdo()), factorEquilibrio(aux.getDerecha())));
        return aux;
    }
    
    private NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL nodo) {
        NodoArbolAVL aux;
        nodo.setIzquierdo(rotacionDerecha(nodo.getIzquierdo()));
        aux = rotacionIzquierda(nodo);
        return aux;
    }
    
    private NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL nodo) {
        NodoArbolAVL aux;
        nodo.setDerecha(rotacionIzquierda(nodo.getDerecha()));
        aux = rotacionDerecha(nodo);
        return aux;
    }
    
    private int factorEquilibrio(NodoArbolAVL nodo) {
        if(nodo == null) {
            return -1;
        }
        return nodo.getFactorEquilibrio(); 
    }
    
    private void inOrden(NodoArbolAVL nodo) {
        if(nodo == null) return;
        inOrden(nodo.getIzquierdo());
        System.out.println("Nodo: " + nodo.getId());
        inOrden(nodo.getDerecha());
    }
    
    
    private void preOrden(NodoArbolAVL nodo) {
        if(nodo == null) return;
        System.out.println("Nodo: " + nodo.getId());
        preOrden(nodo.getIzquierdo());
        preOrden(nodo.getDerecha());
    }
    
 
    
    private void postOrden(NodoArbolAVL nodo) {
        if(nodo == null) return;
        postOrden(nodo.getIzquierdo());
        postOrden(nodo.getDerecha());
        System.out.println("Nodo: " + nodo.getId());
    }
    public void inoden() {
        inOrden(raiz);
    }
       public void preOrden() {
        preOrden(raiz);
    }
    public void postOrden() {
        postOrden(raiz);
    }
    
    public void imprimirArbol() {
        imprimirArbol(raiz);
    }
    
    public void imprimirArbol(NodoArbolAVL nodo) {
        if(nodo == null) return;
        System.out.println("NODO: " + nodo.getId());
        if(nodo.getIzquierdo() != null) {
            System.out.println("Izquierda: " + nodo.getIzquierdo().getId());
        } 
        if(nodo.getDerecha() != null) {
            System.out.println("Derecha: " + nodo.getDerecha().getId());
        }
        System.out.println("\n\n");
        imprimirArbol(nodo.getDerecha());
        imprimirArbol(nodo.getIzquierdo());
    }

    
    /**
     * Permite obtener el codigo .dot que sirve para generar una grafica de graphviz
     * @return codigo dot
     */
    public String dotCode() {
        String salidaGraphviz = "";
        salidaGraphviz += "digraph arbol {\n";
        salidaGraphviz += "rankdir=TB\n";
        salidaGraphviz += "node [shape = record]\n";
        salidaGraphviz += getCodigoNodos(raiz);
        salidaGraphviz += "}\n";
        return salidaGraphviz;
    }
    
    /**
     * Metodo que nos sirve para hallar las conexiones que cada nodo debe tener
     * @param nodo Nodo a evaluar
     * @return DotCode con las declaraciones de nodos y conexiones necesarias
     */
    public String getCodigoNodos(NodoArbolAVL nodo) {
        String codigoNodos = "";
        if(raiz != null) {
            if(nodo.getIzquierdo() == null && nodo.getDerecha() == null) {
                codigoNodos += "nodo" + nodo.getId() + " [ label =\"" + nodo.getId() + "\"];\n";
            } else {
                codigoNodos += "nodo" + nodo.getId() + " [ label =\"<C0>|" + nodo.getId() +"|<C1>\"];\n";
            }
            if(nodo.getIzquierdo() != null) {
                codigoNodos += getCodigoNodos(nodo.getIzquierdo()) + "nodo" + nodo.getId() +":C0->nodo" + nodo.getIzquierdo().getId() + "\n";
            }
            if(nodo.getDerecha() != null) {
                codigoNodos += getCodigoNodos(nodo.getDerecha()) + "nodo" + nodo.getId() +":C1->nodo" + nodo.getDerecha().getId() + "\n";
            }
        }
        return codigoNodos;
    }
    
    /**
     * Permite llenar una lista doblemente enlazada en base a los distintos recorridos posibles
     * como lo son
     * INORDEN, PREORDEN Y POSTORDEN
     * @param lista Lista doblemente enlazada, la cual será llenada
     * @param orden Orden en el que se llenara la lita
     * @param limite Cantidad de datos que deberían llenar la lista
     */
    public void llenarListaDoble(ListaDoble lista, String orden, int limite) {
        if(orden.equals("INORDEN")) {
            llenarInorden(raiz, lista, 0, limite);
        } else if(orden.equals("PREORDEN")) {
            llenarPreorden(raiz, lista, 0, limite);
        } else if(orden.equals("POSTORDEN")) {
            llenarPostorden(raiz, lista, 0, limite);
        }
    }
    
    private void llenarInorden(NodoArbolAVL nodo, ListaDoble lista, int actual, int limite) {
        if(nodo == null || actual == limite) return;
        actual = actual+1;
        llenarInorden(nodo.getIzquierdo(), lista, actual, limite);
        lista.insertar(nodo);
        actual = actual + 1;
        llenarInorden(nodo.getDerecha(), lista, actual, limite);
    }
    
    private void llenarPreorden(NodoArbolAVL nodo, ListaDoble lista, int actual, int limite) {
        if(nodo == null || actual == limite) return;
        lista.insertar(nodo);
        actual = actual + 1;
        llenarPreorden(nodo.getIzquierdo(), lista, actual, limite);
        actual = actual + 1;
        llenarPreorden(nodo.getDerecha(), lista, actual, limite);
    }
    
    private void llenarPostorden(NodoArbolAVL nodo, ListaDoble lista, int actual, int limite) {
        if(nodo == null || actual == limite) return;
        actual = actual + 1;
        llenarPreorden(nodo.getIzquierdo(), lista, actual, limite);
        actual = actual + 1;
        llenarPreorden(nodo.getDerecha(), lista, actual, limite);
        lista.insertar(nodo);
    }
    
    public void llenarListaDobleList(ListaDoble listaDoble) {
        if(raiz != null) {
            llenarListaDobleList(listaDoble, raiz);
        }
    }
    
    public void llenarListaDobleList(ListaDoble listaDoble, NodoArbolAVL nodo) {
        if(nodo == null) return;
        llenarListaDobleList(listaDoble, nodo.getIzquierdo());
        listaDoble.insertar(nodo);
        llenarListaDobleList(listaDoble, nodo.getDerecha());
    }

    public NodoArbolAVL getRaiz() {
        return raiz;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setRaiz(NodoArbolAVL raiz) {
        this.raiz = raiz;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
