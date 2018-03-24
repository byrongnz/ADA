/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.algoritmos;

import ada.beans.Grafo;
import ada.beans.Nodo;
import ada.beans.Arista;
import ada.implementacion.GephiArchivo;import java.util.ArrayList;
;

/**
 *
 * @author T440
 */
public class Gilbert extends Algoritmo{
    
    private static double probabilidad;
    
    public Gilbert(int nodosNum, double probabilidad){
        super();
        this.probabilidad = probabilidad;
        for (int i = 0; i < nodosNum; i++) {
            Nodo nodo = new Nodo(i);
            nodos.add(nodo);
        }
        System.out.println("----------------  Gilbert  --------------------");
        algoritmoGilbert();
        Grafo grafo= new Grafo(nodos, new ArrayList());
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
        GephiArchivo archivo = new GephiArchivo(TIPOGILBERT, grafo,1);
        System.out.println("2");
        GephiArchivo archivo1 = new GephiArchivo(TIPOGILBERT, grafoDFSR,2);
        System.out.println("3");
        GephiArchivo archivo2 = new GephiArchivo(TIPOGILBERT, grafoDFSI,3);
        System.out.println("4");
        GephiArchivo archivo3 = new GephiArchivo(TIPOGILBERT, grafoBFS,4);
        
    }
    
    private void algoritmoGilbert(){
        for (int j = 0; j < nodos.size(); j++) { 
            for (int i = 0; i < nodos.size(); i++) {
                double probaVertice = generadorAleatorios.nextDouble();
                if(i!=j){
                    if(probaVertice<probabilidad){
                        Arista vertice = new Arista();
                        vertice.setNodoX(String.valueOf(j));
                        vertice.setNodoY(String.valueOf(i));
                        nodos.get(j).addVertice(vertice);
                    }   
                }
            }
        }
    }
}
