/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import nodos.NodoMatriz;

/**
 *
 * @author erikssonherlo
 */
public class MatrizDispersa {
    private int totalNodos;
    private int totalFilas;
    private int totalColumnas;
    private NodoMatriz inicio;

    public MatrizDispersa() {
        inicio = new NodoMatriz(0,0,"nodoInicial");
        this.totalNodos = 0;
        this.totalFilas = 0;
        this.totalColumnas = 0;
    }
    
    public NodoMatriz insertarFila(int fila) {
        NodoMatriz cabeza = inicio.getFilaSiguiente();
        String filaString = "";
        filaString += fila;
        NodoMatriz nuevo = new NodoMatriz(0,fila,filaString);
        if(cabeza == null) {
            inicio.setFilaSiguiente(nuevo);
            nuevo.setFilaAnterior(inicio);
        } else {
            if(cabeza.getY() > fila) {
                nuevo.setFilaSiguiente(cabeza);
                cabeza.setFilaAnterior(nuevo);
                inicio.setFilaSiguiente(nuevo);
                nuevo.setFilaAnterior(inicio);
            } else {
                NodoMatriz aux = cabeza;
                while(aux.getFilaSiguiente() != null) {
                    if(aux.getFilaSiguiente().getY() > fila && aux.getY() < fila) {
                        nuevo.setFilaSiguiente(aux.getFilaSiguiente());
                        aux.getFilaSiguiente().setFilaAnterior(nuevo);
                        nuevo.setFilaAnterior(aux);
                        aux.setFilaSiguiente(nuevo);
                        totalFilas++;
                        return nuevo;
                    }
                    aux = aux.getFilaSiguiente();
                }
                aux.setFilaSiguiente(nuevo);
                nuevo.setFilaAnterior(aux);
            }
        }
        if(fila > totalFilas) {
            totalFilas = fila;
        }
        return nuevo;
    }
    
    public NodoMatriz insertarColumna(int columna) {
        NodoMatriz cabeza = inicio.getColumnaSiguiente();
        String columnaString = "";
        columnaString += columna;
        NodoMatriz nuevo = new NodoMatriz(columna, 0, columnaString);
        if(cabeza == null) {
            inicio.setColumnaSiguiente(nuevo);
            nuevo.setColumnaAnterior(inicio);
        } else {
            if(cabeza.getX() > columna) {
                nuevo.setColumnaSiguiente(cabeza);
                cabeza.setColumnaAnterior(nuevo);
                inicio.setColumnaSiguiente(nuevo);
                nuevo.setColumnaAnterior(inicio);
            } else {
                NodoMatriz aux = cabeza;
                while(aux.getColumnaSiguiente() != null) {
                    if(aux.getColumnaSiguiente().getX() > columna && aux.getX() < columna) {
                        nuevo.setColumnaSiguiente(aux.getColumnaSiguiente());
                        aux.getColumnaSiguiente().setColumnaAnterior(nuevo);
                        nuevo.setColumnaAnterior(aux);
                        aux.setColumnaSiguiente(nuevo);
                        totalColumnas++;
                        return nuevo;
                    }
                    aux = aux.getColumnaSiguiente();
                }
                aux.setColumnaSiguiente(nuevo);
                nuevo.setColumnaAnterior(aux);
            }
        }
        if(columna > totalColumnas) {
            totalColumnas = columna;
        }
        return nuevo;
    }
    
    public void insertar(int columna, int fila, String info) {
        NodoMatriz nuevo = new NodoMatriz(columna, fila, info);
        insertar(nuevo);
    }
    
    public void insertar(NodoMatriz nodo) {
        NodoMatriz nuevo = nodo;
        int fila = nodo.getY();
        int columna = nodo.getX();
        NodoMatriz inicioFila = obtenerFila(fila, true);
        NodoMatriz inicioColumna = obtenerColumna(columna, true);
        
        //Insercion en columna
        NodoMatriz cabeza = inicioColumna.getFilaSiguiente();
        if(cabeza == null) {
            inicioColumna.setFilaSiguiente(nuevo);
            nuevo.setFilaAnterior(inicioColumna);
        } else {
            if(cabeza.getY() > fila) {
                nuevo.setFilaSiguiente(cabeza);
                cabeza.setFilaAnterior(nuevo);
                inicioColumna.setFilaSiguiente(nuevo);
                nuevo.setFilaAnterior(inicioColumna);
            } else {
                NodoMatriz aux = cabeza;
                boolean insertado = false;
                while(aux.getFilaSiguiente() != null) {
                    if(aux.getFilaSiguiente().getY() > fila) {
                        nuevo.setFilaSiguiente(aux.getFilaSiguiente());
                        aux.getFilaSiguiente().setFilaAnterior(nuevo);
                        nuevo.setFilaAnterior(aux);
                        aux.setFilaSiguiente(nuevo);
                        insertado = true;
                        break;
                    }
                    aux = aux.getFilaSiguiente();
                }
                if(!insertado) {
                    aux.setFilaSiguiente(nuevo);
                    nuevo.setFilaAnterior(aux);
                }
            }
        }
        //insercion en fila
        cabeza = inicioFila.getColumnaSiguiente();
        if(cabeza == null) {
            inicioFila.setColumnaSiguiente(nuevo);
            nuevo.setColumnaAnterior(inicioFila);
        } else {
            if(cabeza.getX() > columna) {
                nuevo.setColumnaSiguiente(cabeza);
                cabeza.setColumnaAnterior(nuevo);
                inicioFila.setColumnaSiguiente(nuevo);
                nuevo.setColumnaAnterior(inicioFila);
            } else {
                NodoMatriz aux = cabeza;
                boolean insertado = false;
                while(aux.getColumnaSiguiente() != null) {
                    if(aux.getColumnaSiguiente().getX() > columna) {
                        nuevo.setColumnaSiguiente(aux.getColumnaSiguiente());
                        aux.getColumnaSiguiente().setColumnaAnterior(nuevo);
                        nuevo.setColumnaAnterior(aux);
                        aux.setColumnaSiguiente(nuevo);
                        insertado = true;
                        break;
                    }
                    aux = aux.getColumnaSiguiente();
                }
                if(!insertado) {
                    aux.setColumnaSiguiente(nuevo);
                    nuevo.setColumnaAnterior(aux);
                }
            }
        }
        totalNodos++;
    }
    
    public NodoMatriz busqueda(int columna, int fila) {
        NodoMatriz nodoColumna = obtenerColumna(columna, false);
        if(nodoColumna != null) {
            NodoMatriz aux = nodoColumna;
            while(aux != null) {
                if(aux.getY() == fila) {
                    return aux;
                }
                aux = aux.getFilaSiguiente();
            }
            return null;
        } else {
            return null;
        }
    }
    
    public NodoMatriz obtenerFila(int fila, boolean bandera) {
        NodoMatriz aux = inicio.getFilaSiguiente();
        while(aux != null) {
            if(aux.getY() == fila) {
                return aux;
            }
            aux = aux.getFilaSiguiente();
        }
        if(bandera) {
            return insertarFila(fila);
        }
        return null;
    }
    
    public NodoMatriz obtenerColumna(int columna, boolean bandera) {
        NodoMatriz aux = inicio.getColumnaSiguiente();
        while(aux != null) {
            if(aux.getX() == columna) {
                return aux;
            }
            aux = aux.getColumnaSiguiente();
        }
        if(bandera) {
            return insertarColumna(columna);
        }
        return null;
    }

    public int getTotalNodos() {
        return totalNodos;
    }

    public int getTotalFilas() {
        return totalFilas;
    }

    public int getTotalColumnas() {
        return totalColumnas;
    }
    
    public String dotCode() {
        String codigo = "";
        codigo += "digraph matriz {\n";
        codigo += "node [shape = box]\n";
        codigo += "edge [dir = both]\n";
        codigo += "e0[ shape = point, width = 0 ];\n";
        codigo += "e1[ shape = point, width = 0 ];\n";
        codigo += getCodigoNodos();
        codigo += "}\n";
        return codigo;
    }
    
    private String getCodigoNodos() {
        String codigo = "";
        int cont = 1;
        if(inicio != null) {
            NodoMatriz aux = inicio;
            while(aux != null) {
                NodoMatriz auxF = aux;
                codigo += "subgraph cluster_" + cont + " {\n";
                while(auxF != null) {
                    String coord = auxF.getX() + "o" + auxF.getY();
                    codigo += "nodo" + coord + " [ label =\"" + auxF.getContenido() + "\", width = 1.5, style = filled, group = " + cont + " , fillcolor=\"lightblue\", style=\"filled\"];\n";
                    auxF = auxF.getFilaSiguiente();
                }
                cont++;
                codigo += "color=\"White\";\n";
                codigo += "}\n";
                aux = aux.getColumnaSiguiente();
            }
            
            aux = inicio;
            while(aux != null) {
                NodoMatriz auxF = aux;
                while(auxF != null) {
                    String coord = auxF.getX() + "o" + auxF.getY();

                    if(auxF.getFilaSiguiente() != null) {
                        String coordAuxF = auxF.getFilaSiguiente().getX() + "o" + auxF.getFilaSiguiente().getY();
                        codigo += "nodo" + coord +"->nodo" + coordAuxF + "\n";
                    }
                    
                    auxF = auxF.getColumnaSiguiente();
                }
                auxF = aux;
                codigo += "rank = same { ";
                while(auxF != null) {
                    if(auxF == aux) {
                        codigo += "nodo" + auxF.getX() + "o" + auxF.getY();
                    } else {
                        codigo += "->" + "nodo" + auxF.getX() + "o" + auxF.getY();
                    }
                    
                    auxF = auxF.getColumnaSiguiente();
                }
                codigo += " };\n";
                aux = aux.getFilaSiguiente();
            }
            

        }
        return codigo;
    }
}