/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.algoritmos;

import static ada.algoritmos.Algoritmo.TIPOERDOS;
import ada.beans.Grafo;
import ada.beans.Nodo;
import ada.beans.Arista;
import ada.implementacion.GephiArchivo;
import java.util.ArrayList;

/**
 *
 * @author T440
 */
public class GeograficoSimple extends Algoritmo {
    private final static String GEOGRAFICO = "Geografico";
    
    public GeograficoSimple(int nodosNum, double distancia){
        super();
        for (int i = 0; i < nodosNum; i++) {
            Nodo nodo = new Nodo(i, GEOGRAFICO);
            nodos.add(nodo);            
        }
        System.out.println("----------------  Geografico Simple  --------------------");
        System.out.println("Inicio...");
        algoritmoGeograficoSimple(distancia);
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
        GephiArchivo archivo = new GephiArchivo(TIPOGEOGRAFICO, grafo,1);
        System.out.println("2");
        GephiArchivo archivo1 = new GephiArchivo(TIPOGEOGRAFICO, grafoDFSR,2);
        System.out.println("3");
        GephiArchivo archivo2 = new GephiArchivo(TIPOGEOGRAFICO, grafoDFSI,3);
        System.out.println("4");
        GephiArchivo archivo3 = new GephiArchivo(TIPOGEOGRAFICO, grafoBFS,4);
    }
    
    public void algoritmoGeograficoSimple(double distancia){
        
        for (int i = 0; i < nodos.size(); i++) {
            for (int j = 0; j < nodos.size(); j++) {
                if(i!=j){
//                    System.out.println(distancia >= calculaDistancia(nodos.get(i), nodos.get(j)));
                    if(distancia >= calculaDistancia(nodos.get(i), nodos.get(j))){
                        Arista vertice = new Arista();
                        vertice.setNodoX(String.valueOf(i));
                        vertice.setNodoY(String.valueOf(j));
                        nodos.get(i).addVertice(vertice);
                    }
                }
            }
        }
    }
    
    private double calculaDistancia(Nodo nodoX, Nodo nodoY){
        double distancia = -1;
        distancia = Math.sqrt(Math.pow((nodoY.getCoordenadaX()-nodoX.getCoordenadaX()),2)+
                Math.pow((nodoY.getCoordenadaY()-nodoX.getCoordenadaY()),2));
//        System.out.println("Distancia Calculada: "+distancia);
        return distancia;
    }
}
