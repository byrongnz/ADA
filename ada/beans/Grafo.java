/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T440
 */
public class Grafo {
    List<Nodo> nodos;
    List<Arista> vertices;
    
    public Grafo(List nodos, List vertices){
        this.nodos = new ArrayList<>();
        this.vertices = new ArrayList<>();
        setNodos(nodos);
        setVertices(vertices);
    }

    public List<Nodo> getNodos() {
        return nodos;
    }
    
    public Nodo getNodo(int indice) {
        if(indice > 0 && indice <= nodos.size()){
            return nodos.get(indice);
        }else{
            return null;
        }
    }
    
    public void setNodos(List<Nodo> nodos) {
        this.nodos.addAll(nodos);
    }

    public List<Arista> getVertices() {
        return vertices;
    }
    
    public Arista getVertice(int indice) {
        if(indice > 0 && indice <= nodos.size()){
            return vertices.get(indice);
        }else{
            return null;
        }
    }

    public void setVertices(List<Arista> vertices) {
        this.vertices.addAll(vertices);
    }
    
}
