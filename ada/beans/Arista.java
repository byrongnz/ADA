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
public class Arista {
    private String nodoX;
    private String nodoY;
    private int peso = 0;
    
    
    public Arista(){
        this.peso = (int) (Math.random()*100)+1;
        //System.out.println("Peso: "+peso);
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

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
