/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.algoritmos;

import ada.beans.Nodo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author T440
 */
public abstract class Algoritmo {
    
    public static final String TIPOERDOS = "ErdosRenyi";
    public static final String TIPOGILBERT = "Gilbert";
    public static final String TIPOGEOGRAFICO = "Geografico";
    public static final String TIPOBARABASI = "BarabasiAlbert";
    Random generadorAleatorios;
    List<Nodo> nodos;
    
    public Algoritmo(){
        generadorAleatorios = new Random();
        nodos = new ArrayList<Nodo>();
    }
    public int generaNumero(int numeroMaximo){     
        int numeroInicial = 0;
        int numeroRegreso = numeroInicial+generadorAleatorios.nextInt(numeroMaximo);
        return numeroRegreso;
    }
}
