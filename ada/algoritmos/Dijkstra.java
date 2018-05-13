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
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author T440
 */
public class Dijkstra {
    
    public List<Nodo> ejecutaDijkstra(Grafo g){
        List<Nodo> nodosG = g.getNodos();
        
        List<Nodo> caminoCorto = new ArrayList<>();
        Random r = new Random();
        int sN = r.nextInt(nodosG.size());//(int) Math.random()*(nodosG.size())+1;
        int tN = r.nextInt(nodosG.size());//(int) Math.random()*(nodosG.size())+1;
        
        while(true){            
            if(sN == tN){
                tN = (int) Math.random()*(nodosG.size())+1;
            }else{
                break;
            }
        }
        Nodo s = nodosG.get(sN);
        s.setDistacia(0);
        s.setNodoPrevio("-");
        
        Nodo t = nodosG.get(tN);
        
        Cola cola = new Cola();
        cola.add(s);
        System.out.println("S:"+s.getId() + " T"+t.getId());
        while(!cola.isEmpty()){
           
            Nodo n = getNodoMenor(cola);
            cola.remove(n);
            n.setExplorado(true);
            List<Arista> v = n.getVertices();
//            System.out.println("Nodo:"+n.getId()+" Peso:"+n.getDistacia()+" Previo:"+n.getNodoPrevio());
//            System.out.println("No.Vertices:"+n.getVertices().size());
            for (Arista arista : v) {
                String id = arista.getNodoY();
                int pesoA = arista.getPeso();
                int distanciaS = n.getDistacia();
                Nodo next = buscaNodo(id, g); 
                
                if(next.getDistacia() < 0){
                   next.setDistacia(distanciaS + pesoA);
                   next.setNodoPrevio(n.getId());
                   cola.add(next);
                }else if(next.getDistacia() > distanciaS + pesoA){
                   next.setDistacia(distanciaS + pesoA);
                   next.setNodoPrevio(n.getId());
                   cola.add(next);
                }
//                System.out.println("*Nodo:"+next.getId()+" Peso:"+next.getDistacia()+" Previo:"+next.getNodoPrevio());
//                System.out.println("*No.Vertices:"+next.getVertices().size());
            }            
        }
        
        System.out.println("Nodo t:"+t.getId());
        System.out.println("Previo Nodo t:"+t.getNodoPrevio());
        System.out.println("Peso Nodo t:"+t.getDistacia());
        
        if(!t.getNodoPrevio().equals("")){
            caminoCorto.add(t);
            getRutaDijkstra(t, g, caminoCorto);
        }
//        else{
//            getRutaDijkstraOrigen(s, g, caminoCorto);
//        }
        System.out.println("Tam camino corto:"+caminoCorto.size());
        return caminoCorto;
    }
    
    private void getRutaDijkstra(Nodo n, Grafo g, List<Nodo> nodosDijkstra){
        if(!n.getNodoPrevio().equals("-")){
//            System.out.println("Nodo Final:"+n.getId());
//            System.out.println("Nodo Previo:"+n.getNodoPrevio());
            Nodo nP = buscaNodo(n.getNodoPrevio(), g);
            nodosDijkstra.add(nP);
            getRutaDijkstra(nP, g, nodosDijkstra);
        }else{
            System.out.println("Nodo origen: "+n.getId());
        }
    }
    
    private void getRutaDijkstraOrigen(Nodo n, Grafo g, List<Nodo> nodosDijkstra){
        if(n != null){
            Nodo nP = buscaNodoEnPrevio(n.getId(), g);
            nodosDijkstra.add(nP);
            getRutaDijkstraOrigen(nP, g, nodosDijkstra);
        }else{
            System.out.println("Nodo final: ");
        }
    }
    
    private Nodo getNodoMenor(Cola c){
        Nodo n = null;
        c.sort(Comparator.comparing(Nodo::getDistacia));
        for (Object object : c) {
            n = (Nodo) object;
            if(!n.isExplorado()){
                break;
            }
        }
        return n;
    }
    
    private Nodo buscaNodo(String id, Grafo g){
        Nodo nodoEncontrado = null;
        for (Nodo nodo : g.getNodos()) {
            if(nodo.getId().equals(id)){
                nodoEncontrado = nodo;
            }
        }
        return nodoEncontrado;
    }
    
    private Nodo buscaNodoEnPrevio(String id, Grafo g){
        Nodo nodoEncontrado = null;
        for (Nodo nodo : g.getNodos()) {
            if(nodo.getNodoPrevio().equals(id)){
                nodoEncontrado = nodo;
            }
        }
        return nodoEncontrado;
    }
}
