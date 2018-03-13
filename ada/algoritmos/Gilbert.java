/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.algoritmos;

import ada.beans.Grafo;
import ada.beans.Nodo;
import ada.beans.Vertice;
import ada.implementacion.GephiArchivo;;

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
        Grafo grafo= new Grafo(nodos,null);
        GephiArchivo archivo = new GephiArchivo(TIPOGILBERT, grafo);
    }
    
    private void algoritmoGilbert(){
        for (int j = 0; j < nodos.size(); j++) { 
            for (int i = 0; i < nodos.size(); i++) {
                double probaVertice = generadorAleatorios.nextDouble();
                if(i!=j){
                    if(probaVertice<probabilidad){
                        Vertice vertice = new Vertice();
                        vertice.setNodoX(String.valueOf(j));
                        vertice.setNodoY(String.valueOf(i));
                        nodos.get(j).addVertice(vertice);
                    }   
                }
            }
        }
    }
}
