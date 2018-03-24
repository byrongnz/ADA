/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.beans.objetos;

/**
 *
 * @author T440
 */
import java.util.ArrayList;

public class Pila extends ArrayList{
 
    public void push(Object objeto){
        if(objeto != null){
            this.add(objeto);
        }else{
            System.out.println("Introduzca un dato no nulo");
        }  
    }

    public void pop(){
        if(size() > 0){
            this.remove(this.size()-1);
        }
    }

    public Object top(){
        Object objetoAux = null;
        if(this.size() > 0){
            objetoAux = this.get(this.size()-1);
        }
        return objetoAux;  
    }

    public boolean vacia(){
        return this.isEmpty();
    }
}
