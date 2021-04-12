/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import estructuras.MatrizDispersa;

/**
 *
 * @author erikssonherlo
 */
public class Capa {
        private String id;
    private MatrizDispersa capa;

    public Capa(String id, MatrizDispersa capa) {
        this.id = id;
        this.capa = capa;
    }

    public String getId() {
        return id;
    }

    public MatrizDispersa getCapa() {
        return capa;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCapa(MatrizDispersa capa) {
        this.capa = capa;
    }

  
}
