/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.algoritmos;

import ada.beans.Grafo;
import ada.beans.Nodo;
import ada.beans.Vertice;
import ada.implementacion.GephiArchivo;

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
        Grafo grafo= new Grafo(nodos,null);
        GephiArchivo archivo = new GephiArchivo(TIPOGEOGRAFICO, grafo);
    }
    
    public void algoritmoGeograficoSimple(double distancia){
        
        for (int i = 0; i < nodos.size(); i++) {
            for (int j = 0; j < nodos.size(); j++) {
                if(i!=j){
                    if(distancia >= calculaDistancia(nodos.get(i), nodos.get(j))){
                        Vertice vertice = new Vertice();
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
        //System.out.println("Distancia Calculada: "+distancia);
        return distancia;
    }
}
