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
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author T440
 */

public class BarabasiAlbert extends Algoritmo{
    double probabilidadConexion = generadorAleatorios.nextDouble();
    public BarabasiAlbert(int nodosNum, int numeroConexiones){
        super();
        nodos = new ArrayList<>();
//        for (int i = 0; i < nodosNum; i++) {
//            Nodo nodo = new Nodo(i);
//            nodo.setGrado(numeroConexiones);
//            nodos.add(nodo);
//        }
        System.out.println("----------------  Barabasi Albert  --------------------");
        algoritmoBarabasiAlbertFinal(nodosNum, numeroConexiones);

        System.out.println("***"+probabilidadConexion);
        System.out.println("Size nodos: "+nodos.size());
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
        GephiArchivo archivo = new GephiArchivo(TIPOBARABASI, grafo,1);
        System.out.println("2");
        GephiArchivo archivo1 = new GephiArchivo(TIPOBARABASI, grafoDFSR,2);
        System.out.println("3");
        GephiArchivo archivo2 = new GephiArchivo(TIPOBARABASI, grafoDFSI,3);
        System.out.println("4");
        GephiArchivo archivo3 = new GephiArchivo(TIPOBARABASI, grafoBFS,4);
        
    }
    private void algoritmoBarabasiAlbertFinal(int nodosNum, int gradoMaximo){
        for (int i = 0; i < nodosNum; i++) {
            
            if(i == 0){
                Nodo nodo = new Nodo(i);
                nodos.add(nodo);
//                System.out.println("Adding Nodo: "+i);
            }else{
                Nodo nodo = new Nodo(i);
                if(conectaNodosProbables(nodos, nodo, gradoMaximo)){
                    nodos.add(nodo);
                    System.out.println("Adding Nodo: "+i);
                }else{
                    nodos.add(nodo);
                }

            }
            
        }
    }
   
    
    private boolean conectaNodosProbables(List<Nodo> nodosValidos, Nodo nuevoNodo, int gradoMaximo){
        double probabilidad = 0;
        double auxProbabilidad = 0;
        boolean agregarNodo = false;
        for (int i = 0; i<nodosValidos.size(); i++) {
            auxProbabilidad = probabilidadConexion( nodosValidos.get(i), gradoMaximo);
            if(auxProbabilidad > probabilidad){
                probabilidad = auxProbabilidad;
            }        
        }
        for (int i = 0; i < nodosValidos.size(); i++ ) {
            double probable = generadorAleatorios.nextDouble();
            //System.out.println("?"+(probable<probabilidadConexion)+" P:"+probable+" p:"+probabilidadConexion);
            
            boolean probabilidadCon = probabilidadConexion>probable;
//            System.out.println("...");
//            System.out.println("Comparado: "+nodosValidos.get(i).getId()+","+nuevoNodo.getId()+
//                    ": "+probabilidadCon+
//                    " :"+(nodosValidos.get(i).getGrado()<gradoMaximo)+
//                    "; "+(nuevoNodo.getGrado()<gradoMaximo)+
//                    ", "+(probabilidad == nodosValidos.get(i).getPorcentaje()));
            if((nodosValidos.get(i).getId().equals("0")&&nuevoNodo.getId().equals("1"))
                    ||//(probabilidad == nodosValidos.get(i).getPorcentaje())
                    //&&
                    (probabilidadCon)
                    &&(nodosValidos.get(i).getGrado()<gradoMaximo)
                    && (nuevoNodo.getGrado()<gradoMaximo)
                    ){
                Arista vertice = new Arista();
                vertice.setNodoX(nodosValidos.get(i).getId());
                vertice.setNodoY(nuevoNodo.getId());
                reduceGrado(nodosValidos.get(i), gradoMaximo);
                reduceGrado(nuevoNodo, gradoMaximo);
                nodosValidos.get(i).addVertice(vertice);
                agregarNodo = true;
//                System.out.println(agregarNodo);
                //nodos.add(nuevoNodo);
            }
        }
        return agregarNodo;
    }
    
    private void reduceGrado(Nodo nodo, int gradoMaximo){
        
        if(nodo.getGrado()<gradoMaximo){
            int conexiones = nodo.getGrado()+1;
            nodo.setGrado(conexiones);            
            double porcentajeNuevo =1-((float)nodo.getGrado()/gradoMaximo);
//            System.out.println("Porcentaje: "+porcentajeNuevo);
            
            nodo.setPorcentaje(porcentajeNuevo);
//            System.out.println("Nodo "+nodo.getId()+" grado: "+nodo.getGrado()+" porcentaje: "+nodo.getPorcentaje());
        }else{
            System.out.println("El numero de conexiones esta en su limite.");
        }
        
    }

    private double probabilidadConexion(Nodo nodo, int gradoMaximo){
        double conexiones = 0;
        if(nodo.getGrado()>0){
            conexiones = 1 - ((float)nodo.getGrado()/gradoMaximo);
        }else if(nodo.getGrado()==0){
            conexiones=1;            
        }
//        System.out.println("Probabilidad: "+conexiones+" Nodo: "+nodo.getId()+" "+nodo.getPorcentaje()+" "+nodo.getGrado());
        return conexiones;
    }
    
}
