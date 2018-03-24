/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.algoritmos;

import ada.beans.Grafo;
import ada.beans.Nodo;
import ada.beans.Arista;
import ada.implementacion.GephiArchivo;
import java.util.ArrayList;

/**
 *
 * @author T440
 * Recibe como parametros el numero de nodos y de aristas
 */
public class ErdosRenyi extends Algoritmo{
    
    public ErdosRenyi(int nodosNum, int aristasNum){
        super();
        for (int i = 0; i < nodosNum; i++) {
            Nodo nodo = new Nodo(i);
            nodos.add(nodo);
        }
        System.out.println("----------------  Erdos-Renyi  --------------------");
        algoritmoErdosRenyi(aristasNum);
        Grafo grafo= new Grafo(nodos,new ArrayList());

        Grafo grafoDFSR = new Grafo(new ArrayList(), new ArrayList());
        grafoDFSR.setNodos(nodos);
        grafoDFSR.setVertices(grafo.getVertices());
        
        Grafo grafoDFSI = new Grafo(new ArrayList(), new ArrayList());
        grafoDFSI.setVertices(grafo.getVertices());
        grafoDFSI.setNodos(nodos);
        
        Grafo grafoBFS = new Grafo(new ArrayList(), new ArrayList());
        grafoBFS.setVertices(grafo.getVertices());
        grafoBFS.setNodos(nodos);
        
        DFS dfsr = new DFS(grafoDFSR,1);
        DFS dfsi = new DFS(grafoDFSI,2);
        BFS bfs = new BFS(grafoBFS);
        
        System.out.println("1");
        GephiArchivo archivo = new GephiArchivo(TIPOERDOS, grafo,1);
        System.out.println("2");
        GephiArchivo archivo1 = new GephiArchivo(TIPOERDOS, grafoDFSR,2);
        System.out.println("3");
        GephiArchivo archivo2 = new GephiArchivo(TIPOERDOS, grafoDFSI,3);
        System.out.println("4");
        GephiArchivo archivo3 = new GephiArchivo(TIPOERDOS, grafoBFS,4);
    }
    
    public void algoritmoErdosRenyi(int numeroAristas){
        
                
        for (int j = 0; j < numeroAristas; j++) { 
            Arista vertice = new Arista();
            int nodoX = generaNumero(nodos.size());
            int nodoY = generaNumero(nodos.size());
            
            if(nodos.get(nodoX).getVertices().isEmpty()){

                while(nodoY==nodoX){
                    nodoY=generaNumero(nodos.size());
                }

                vertice.setNodoX(String.valueOf(nodoX));
                vertice.setNodoY(String.valueOf(nodoY));
                nodos.get(nodoX).addVertice(vertice);
                //grafo.getNodo(nodoX).setVertice(vertice);
                //break;
            }else if(!nodos.get(nodoX).getVertices().isEmpty()){
                boolean existeNodo = false;

                while(!existeNodo){
                    buscaIgualdad:
                    for (int i = 0; i < nodos.get(nodoX).getVertices().size(); i++) {
                        if(nodos.get(nodoX).getVertice(i).getNodoY().equals(String.valueOf(nodoY))){
                            existeNodo = true;
                            break buscaIgualdad;
                        }
                    }

                    if(existeNodo){
                        nodoY = generaNumero(nodos.size());
                    }else{
                        vertice.setNodoX(String.valueOf(nodoX));
                        vertice.setNodoY(String.valueOf(nodoY));
                        nodos.get(nodoX).addVertice(vertice);
                    }
                }
            }   
        }
    }
    
}
