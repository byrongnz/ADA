/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.algoritmos;

import ada.beans.Arista;
import ada.beans.Grafo;
import ada.beans.Nodo;
import ada.beans.objetos.Pila;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T440
 */
public class DFS {
    List<Arista> aristasDFS;
    
    public DFS(Grafo grafo, int tipo){
        aristasDFS = new ArrayList<>();
        if(tipo==1){
            for (int i = 0; i < grafo.getNodos().size(); i++) {
                if(!grafo.getNodos().get(i).getVertices().isEmpty()){
                    ejecutaDFSRecursivo(grafo, grafo.getNodos().get(i));                
                }
            } 
        }else{
            
        }
    }
    
    public void ejecutaDFSRecursivo(Grafo grafo,Nodo nodo){
        if(!nodo.isExplorado()){
            nodo.setExplorado(true);
            for (int i = 0; i < nodo.getVertices().size(); i++) {
                int idNodo = Integer.parseInt(nodo.getVertice(i).getNodoY());
                try{
                if(!grafo.getNodos().get(idNodo).isExplorado()){
                    aristasDFS.add(nodo.getVertice(i));
                    System.out.println(nodo.getVertice(i));
                    ejecutaDFSRecursivo(grafo, grafo.getNodos().get(idNodo));
                }
                }catch (Exception e){
                    System.out.println("Trono en: " + idNodo);
                    e.printStackTrace(System.out);
                }
            }
        }
    }
    
    public void ejecutaDFSIterativo(Grafo grafo,Nodo nodo){
        Pila cola = new Pila();
        nodo.setExplorado(true);
        cola.push(nodo);
        while(!cola.isEmpty()){
            Nodo nodoAgregado = (Nodo)cola.top();
            cola.pop();
            for (int i = 0; i < nodoAgregado.getVertices().size(); i++) {
                Arista arista = nodoAgregado.getVertices().get(i);
                int idNodoAdyacente = Integer.parseInt(arista.getNodoY());
                if(!grafo.getNodos().get(idNodoAdyacente).isExplorado()){
                    grafo.getNodos().get(idNodoAdyacente).setExplorado(true);
                    cola.add(grafo.getNodos().get(idNodoAdyacente));
                    aristasDFS.add(arista);
                }
            }
        }  
    }

    public List<Arista> getAristasDFS() {
        return aristasDFS;
    }

    public void setAristasDFS(List<Arista> aristasDFS) {
        this.aristasDFS = aristasDFS;
    }
    
}
