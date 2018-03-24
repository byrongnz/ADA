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

public class Cola extends ArrayList{
     
    public void encolar(Object objeto){
        if(objeto != null){
            this.add(objeto);
        }  
    }

    public void desencolar(){
        if(this.size() > 0){
            this.remove(0);
        }
    }
    
    public Object frente(){
        Object objetoAux = null;
        if(this.size() > 0){
            objetoAux = this.get(0);
        }
        return objetoAux;  
    }

    public boolean vacia(){
        return this.isEmpty();
    }
}
