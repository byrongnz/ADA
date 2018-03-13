/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaproject.test;

import ada.beans.Grafo;
import ada.beans.Nodo;
import ada.beans.Vertice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T440
 */
public class Test {
    public static void main(String[] args) {
       int nodos = 0;
       int vertices = 0;
       
       System.out.println("Ingrese numero de nodos");
       nodos = 10;
       System.out.println("Ingrese el numero de vertices");
       vertices = 10;
       
        System.out.println(1-((float) 1/4));
//       List<Nodo> nodosCreados = creaObjetos(Nodo.class, nodos);// new ArrayList<Nodo>();
//       List<Vertice> verticesCreados = creaObjetos(Vertice.class, vertices);//new ArrayList<Vertice>();
//       
//       Grafo grafo = new Grafo(nodosCreados, verticesCreados);
    }
    
    public static List creaObjetos(Object objeto, int numero){
        List objetos = new ArrayList();
        boolean nodoB = false;
        boolean verticeB = false;
        
        if(objeto.getClass().equals(Nodo.class)){
            nodoB = true;
        }else if(objeto.getClass().equals(Vertice.class)){
            verticeB = true;
        }
        
            for (int i = 0; i < numero; i++) {
                if(nodoB){
                    Nodo nodo = new Nodo(i);
                    objetos.add(nodo);
                }else if(verticeB){
                    Vertice vertice = new Vertice();
                    objetos.add(vertice);
                }
            }
        
        return objetos;
    }
}
