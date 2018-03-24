/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.algoritmos;

import ada.beans.Arista;
import ada.beans.Grafo;
import ada.beans.Nodo;
import ada.beans.objetos.Cola;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author T440
 * https://codebreakerscorp.wordpress.com/2010/12/06/algoritmo-de-busqueda-breadth-first-search/
 */
public class BFS {
    List<Arista> aristasBFS;
    
    public BFS(Grafo grafo){
        aristasBFS = new ArrayList<>();
    }
    
    //Arreglar como incrementa dinamicamente el tamaño de la cola de espera
    public void ejecutaBFS(Grafo grafo,Nodo nodo){
        Cola cola = new Cola();
        nodo.setExplorado(true);
        cola.encolar(nodo);
        while(!cola.isEmpty()){
            Nodo nodoAgregado = (Nodo)cola.frente();
            cola.desencolar();
            for (int i = 0; i < nodoAgregado.getVertices().size(); i++) {
                Arista arista = nodoAgregado.getVertices().get(i);
                int idNodoAdyacente = Integer.parseInt(arista.getNodoY());
                if(!grafo.getNodos().get(idNodoAdyacente).isExplorado()){
                    grafo.getNodos().get(idNodoAdyacente).setExplorado(true);
                    cola.add(grafo.getNodos().get(idNodoAdyacente));
                    aristasBFS.add(arista);
                }
            }
        }    
    }

    public List<Arista> getAristasBFS() {
        return aristasBFS;
    }

    public void setAristasBFS(List<Arista> aristasBFS) {
        this.aristasBFS = aristasBFS;
    }
    
}
