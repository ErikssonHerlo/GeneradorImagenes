/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 *
 * @author erikssonherlo
 */
public class NodoMatriz {
     private NodoMatriz columnaAnterior;
    private NodoMatriz filaAnterior;
    private NodoMatriz columnaSiguiente;
    private NodoMatriz filaSiguiente;
    private String contenido;
    private JButton boton;
    private int x;
    private int y;
    
    public NodoMatriz(int x, int y, String contenido) {
        this.x = x;
        this.y = y;
        this.contenido = contenido;
        this.columnaAnterior = null;
        this.filaAnterior = null;
        this.columnaSiguiente = null;
        this.filaSiguiente = null;
        this.boton = new JButton();
    }

    public NodoMatriz getColumnaAnterior() {
        return columnaAnterior;
    }

    public NodoMatriz getFilaAnterior() {
        return filaAnterior;
    }

    public NodoMatriz getColumnaSiguiente() {
        return columnaSiguiente;
    }

    public NodoMatriz getFilaSiguiente() {
        return filaSiguiente;
    }

    public String getContenido() {
        return contenido;
    }

    public JButton getBoton() {
        return boton;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setColumnaAnterior(NodoMatriz columnaAnterior) {
        this.columnaAnterior = columnaAnterior;
    }

    public void setFilaAnterior(NodoMatriz filaAnterior) {
        this.filaAnterior = filaAnterior;
    }

    public void setColumnaSiguiente(NodoMatriz columnaSiguiente) {
        this.columnaSiguiente = columnaSiguiente;
    }

    public void setFilaSiguiente(NodoMatriz filaSiguiente) {
        this.filaSiguiente = filaSiguiente;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
