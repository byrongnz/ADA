/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.beans;



/**
 *
 * @author T440
 */
public class Vertice {
    private String nodoX;
    private String nodoY;

    public String getNodoX() {
        return nodoX;
    }

    public void setNodoX(String nodoX) {
        this.nodoX = nodoX;
    }

    public String getNodoY() {
        return nodoY;
    }

    public void setNodoY(String nodoY) {
        this.nodoY = nodoY;
    }
    
    @Override
    public String toString(){
        return "Nodo X: "+ nodoX+" Nodo Y:"+nodoY;
    }
        
}
