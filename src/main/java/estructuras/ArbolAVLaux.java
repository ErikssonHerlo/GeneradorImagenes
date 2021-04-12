/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import javax.swing.JOptionPane;
import nodos.NodoArbolAVLAux;
import nodos.NodoArbolAVLAux;
import objetos.Usuario;

/**
 *
 * @author erikssonherlo
 */
public class ArbolAVLaux {
     private NodoArbolAVLAux raiz;
    private boolean existe = false;
    private boolean eliminado = false;

    public ArbolAVLaux() {
        this.raiz = null;
    }

    public void formatear() {
        raiz = null;
    }

  
/**
    private NodoArbolAVLAux insertarAVL(NodoArbolAVLAux nodoActual, NodoArbolAVLAux nuevoNodo) {
        if (nodoActual == null)
        {
            return nuevoNodo;
        }

        if (nuevoNodo.getId().compareTo(nodoActual.getId()) < 0)
        {
            nodoActual.setHijoIzquierdo(insertarAVL(nodoActual.getHijoIzquierdo(), nuevoNodo));
        } else if (nuevoNodo.getId().compareTo(nodoActual.getId()) > 0)
        {
            nodoActual.setHijoDerecho(insertarAVL(nodoActual.getHijoDerecho(), nuevoNodo));
        } else
        {
            existe = true;
            return nodoActual;
        }

        nodoActual.setAltura(1 + alturaMaxima(getAltura(nodoActual.getHijoIzquierdo()), getAltura(nodoActual.getHijoDerecho())));

        int fe = getFactorEquilibrio(nodoActual);

        if (fe > 1 && nuevoNodo.getId().compareTo(nodoActual.getHijoDerecho().getId()) > 0)
        {
            return rotacionIzquierda(nodoActual);
        }

        if (fe < -1 && nuevoNodo.getId().compareTo(nodoActual.getHijoIzquierdo().getId()) < 0)
        {
            return rotacionDerecha(nodoActual);
        }

        if (fe >= 2 && getFactorEquilibrio(nodoActual.getHijoDerecho()) < 0)
        {
            nodoActual.setHijoDerecho(rotacionDerecha(nodoActual.getHijoDerecho()));
            return rotacionIzquierda(nodoActual);
        }

        if (fe <= -2 && getFactorEquilibrio(nodoActual.getHijoIzquierdo()) > 0)
        {
            nodoActual.setHijoIzquierdo(rotacionIzquierda(nodoActual.getHijoIzquierdo()));
            return rotacionDerecha(nodoActual);
        }

        return nodoActual;
    }

    
      public void insertarNodo(NodoArbolAVLAux nuevoNodo, boolean modificar) {
        raiz = insertarAVL(raiz, nuevoNodo);
        if (!modificar)
        {
            if (existe)
            {
                JOptionPane.showMessageDialog(null, "El Usuario ya existe");
                existe = false;
            } else
            {
                JOptionPane.showMessageDialog(null, "El Nuevo Usuario se ha creado exitosamente");
            }
        }
    }
    
    private NodoArbolAVLAux rotacionDerecha(NodoArbolAVLAux nodoActual) {
        NodoArbolAVLAux nuevoRoot = nodoActual.getHijoIzquierdo();
        NodoArbolAVLAux aux = nuevoRoot.getHijoDerecho();

        nuevoRoot.setHijoDerecho(nodoActual);
        nodoActual.setHijoIzquierdo(aux);

        nodoActual.setAltura(alturaMaxima(getAltura(nodoActual.getHijoIzquierdo()), getAltura(nodoActual.getHijoDerecho())) + 1);
        nuevoRoot.setAltura(alturaMaxima(getAltura(nuevoRoot.getHijoIzquierdo()), getAltura(nuevoRoot.getHijoDerecho())) + 1);

        return nuevoRoot;
    }

    private NodoArbolAVLAux rotacionIzquierda(NodoArbolAVLAux nodoActual) {
        NodoArbolAVLAux nuevoRoot = nodoActual.getHijoDerecho();
        NodoArbolAVLAux aux = nuevoRoot.getHijoIzquierdo();

        nuevoRoot.setHijoIzquierdo(nodoActual);
        nodoActual.setHijoDerecho(aux);

        nodoActual.setAltura(alturaMaxima(getAltura(nodoActual.getHijoIzquierdo()), getAltura(nodoActual.getHijoDerecho())) + 1);
        nuevoRoot.setAltura(alturaMaxima(getAltura(nuevoRoot.getHijoIzquierdo()), getAltura(nuevoRoot.getHijoDerecho())) + 1);

        return nuevoRoot;
    }

    public void mostrarArbol() {
        System.out.println("Arbol AVL");
        mostrarNodos(raiz);

    }

    private void mostrarNodos(NodoArbolAVLAux nodo) {

        if (raiz != null)
        {

            if (nodo.getHijoIzquierdo() == null && nodo.getHijoDerecho() == null)
            {
                System.out.println("Nodo: " + nodo.getId());
            }
            if (nodo.getHijoDerecho() != null)
            {
                System.out.println("Nodo: " + nodo.getId() + " Hijo derecho: " + nodo.getHijoDerecho().getId());
                mostrarNodos(nodo.getHijoDerecho());
            }
            if (nodo.getHijoIzquierdo() != null)
            {
                System.out.println("Nodo: " + nodo.getId() + " Hijo Izquierdo: " + nodo.getHijoIzquierdo().getId());
                mostrarNodos(nodo.getHijoIzquierdo());
            }
        } else
        {
            System.out.println("ARBOL VACIO");
        }

    }

    private int alturaMaxima(int a, int b) {
        return (a > b) ? a : b;
    }

    private int getAltura(NodoArbolAVLAux nodoActual) {
        if (nodoActual == null)
        {
            return 0;
        }

        return nodoActual.getAltura();
    }

    private int getFactorEquilibrio(NodoArbolAVLAux nodoActual) {
        if (nodoActual == null)
        {
            return 0;
        }

        return getAltura(nodoActual.getHijoDerecho()) - getAltura(nodoActual.getHijoIzquierdo());
    }

    public NodoArbolAVLAux buscarNodo(String id) {
        return buscarEnArbol(raiz, id);
    }

    private NodoArbolAVLAux buscarEnArbol(NodoArbolAVLAux nodoActual, String id) {
        if (nodoActual == null)
        {
            return null;
        } else if (id.equals(nodoActual.getId()))
        {
            return nodoActual;
        } else if (id.compareTo(nodoActual.getId()) < 0)
        {
            return buscarEnArbol(nodoActual.getHijoIzquierdo(), id);
        } else
        {
            return buscarEnArbol(nodoActual.getHijoDerecho(), id);
        }
    }

    public void eliminarNodo(String id, boolean modificar) {
        raiz = eliminarEnArbol(raiz, id);

        if (!modificar)
        {
            if (eliminado)
            {
                JOptionPane.showMessageDialog(null, "Se ha eliminado usuario exitosamente");
                eliminado = false;
            } else
            {
                JOptionPane.showMessageDialog(null, "El usuario no existee");
            }
        }

    }

    public NodoArbolAVLAux eliminarEnArbol(NodoArbolAVLAux nodoActual, String id) {
        if (nodoActual == null)
        {
            return nodoActual;
        }

        if (id.compareTo(nodoActual.getId()) < 0)
        {
            nodoActual.setHijoIzquierdo(eliminarEnArbol(nodoActual.getHijoIzquierdo(), id));
        } else if (id.compareTo(nodoActual.getId()) > 0)
        {
            nodoActual.setHijoDerecho(eliminarEnArbol(nodoActual.getHijoDerecho(), id));
        } else
        {
            if ((nodoActual.getHijoIzquierdo() == null) || (nodoActual.getHijoDerecho() == null))
            {
                NodoArbolAVLAux aux = null;
                if (nodoActual.getHijoDerecho() == aux)
                {
                    aux = nodoActual.getHijoIzquierdo();
                } else
                {
                    aux = nodoActual.getHijoDerecho();
                }

                if (aux == null)
                {
                    nodoActual = null;
                } else
                {
                    nodoActual = aux;
                }
                eliminado = true;
            } else
            {
                NodoArbolAVLAux aux = getNodoMasGrande(nodoActual.getHijoIzquierdo());

                nodoActual.setId(aux.getId());
                nodoActual.setContenido(aux.getContenido());

                nodoActual.setHijoIzquierdo(eliminarEnArbol(nodoActual.getHijoIzquierdo(), aux.getId()));

            }
        }

        if (nodoActual == null)
        {
            return nodoActual;
        }

        nodoActual.setAltura(alturaMaxima(getAltura(nodoActual.getHijoIzquierdo()), getAltura(nodoActual.getHijoDerecho())) + 1);

        int fe = getFactorEquilibrio(nodoActual);

        if (fe > 1 && getFactorEquilibrio(nodoActual.getHijoDerecho()) >= 0)
        {
            return rotacionIzquierda(nodoActual);
        }

        if (fe < -1 && getFactorEquilibrio(nodoActual.getHijoIzquierdo()) <= 0)
        {
            return rotacionDerecha(nodoActual);
        }

        if (fe > 1 && getFactorEquilibrio(nodoActual.getHijoDerecho()) < 0)
        {
            nodoActual.setHijoDerecho(rotacionDerecha(nodoActual.getHijoDerecho()));
            return rotacionIzquierda(nodoActual);
        }

        if (fe < -1 && getFactorEquilibrio(nodoActual.getHijoIzquierdo()) > 0)
        {
            nodoActual.setHijoIzquierdo(rotacionIzquierda(nodoActual.getHijoIzquierdo()));
            return rotacionDerecha(nodoActual);
        }

        return nodoActual;
    }

    private NodoArbolAVLAux getNodoMasGrande(NodoArbolAVLAux nodo) {
        NodoArbolAVLAux nodoActual = nodo;

        while (nodoActual.getHijoDerecho() != null)
        {
            nodoActual = nodoActual.getHijoDerecho();
        }

        return nodoActual;
    }

    public void modificarUsuario(String nodoSeleccionado, String id) {
        NodoArbolAVLAux nodoSelec = buscarNodo(nodoSeleccionado);
        NodoArbolAVLAux nodoNuevo = buscarNodo(id);

        if (nodoNuevo == null)
        {
            Usuario user = (Usuario) nodoSelec.getContenido();
            user.setId(id);
            NodoArbolAVLAux nodoModificado = new NodoArbolAVLAux(user,id,nodoSelec.getHijoIzquierdo(),nodoSelec.getHijoDerecho());
            eliminarNodo(nodoSelec.getId(),true);
            mostrarArbol();
            insertarNodo(nodoModificado,true);
            mostrarArbol();
            JOptionPane.showMessageDialog(null, "El usuario fue modificado");
        } else
        {
            JOptionPane.showMessageDialog(null, "El id ya existe");
        }
    }*/
}
