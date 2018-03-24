/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.implementacion;

import ada.beans.Arista;
import ada.beans.Grafo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author T440
 */
public class GephiArchivo {
    private String algoritmo;
    private static final String ERDOSRENYI = "ErdosRenyi";
    private static final String GEOGRAFICO = "Geografico";
    private static final String GILBERT = "Gilbert";
    private static final String BARABASIALBERT = "BarabasiAlbert";
    
    public GephiArchivo(String tipoAlgoritmo, Grafo grafo, int numeroArchivo){
        this.algoritmo = tipoAlgoritmo;
        generaArchivo(grafo, numeroArchivo);
    }
    
    private void generaArchivo(Grafo grafo, int numeroArchivo){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy hh-mm-ss");
        Date fecha = new Date();
        String nombreArchivo = "D:\\ArchivosGephi";
        switch(algoritmo){
            case ERDOSRENYI:
                nombreArchivo = nombreArchivo + "\\ErdosRenyi\\grapho"+algoritmo+sdf.format(fecha).toString()+numeroArchivo+".gv";
                break;
            case GILBERT:
                nombreArchivo = nombreArchivo + "\\Gilbert\\grapho"+algoritmo+sdf.format(fecha).toString()+numeroArchivo+".gv";
                break;
            case GEOGRAFICO:
                nombreArchivo = nombreArchivo + "\\Geografico\\grapho"+algoritmo+sdf.format(fecha).toString()+numeroArchivo+".gv";
                break;
            case BARABASIALBERT:
                nombreArchivo = nombreArchivo + "\\BarabasiAlbert\\grapho"+algoritmo+sdf.format(fecha).toString()+numeroArchivo+".gv";
                break;
        }
        
        String encabezado = "graph "+ algoritmo +"{\n";
        String grafoFin = "}";
        String cuerpoArchivo = "";
        if(grafo.getVertices().isEmpty()){
            cuerpoArchivo = encabezado + generaGrafo(grafo)+grafoFin;
        }else{
            cuerpoArchivo = encabezado + generaGrafoByArista(grafo.getVertices())+grafoFin;
        }
        File archivo = new File(nombreArchivo);
        
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(nombreArchivo);
            bw = new BufferedWriter(fw);
            bw.write(cuerpoArchivo);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null){
                    bw.close();
                }
                if (fw != null){
                    fw.close();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }       
        }
    }
    
    public String generaGrafo(Grafo grafo){
        String linea ="";
        
        if(!grafo.getNodos().isEmpty()){
            for (int i = 0; i < grafo.getNodos().size(); i++) {
                if(!grafo.getNodos().get(i).getVertices().isEmpty()){
                    System.out.println("Nodo: "+grafo.getNodos().get(i).getId()+" "+grafo.getNodos().get(i).getVertices().toString());
                    for (int j = 0; j < grafo.getNodos().get(i).getVertices().size(); j++) {
                        linea= linea + grafo.getNodos().get(i).getVertice(j).getNodoX()+"--"+
                                grafo.getNodos().get(i).getVertice(j).getNodoY()+";"+"\n";
                    }
                }                    
            }
        }else{
            linea = "Los nodos estan vacios";
        }
        System.out.println("FIN...");
//        System.out.println("Linea: "+linea);
        return linea;
    }
    
    public String generaGrafoByArista(List<Arista> aristas){
        String linea ="";
        if(!aristas.isEmpty()){
            for (int i = 0; i < aristas.size(); i++) {                
                System.out.println("Arista: "+aristas.get(i).toString());               
                linea= linea + aristas.get(i).getNodoX()+"--"+
                        aristas.get(i).getNodoY()+";"+"\n";                                                    
            }
        }else{
            linea = "Los nodos estan vacios";
        }
        System.out.println("FIN...");
//        System.out.println("Linea: "+linea);
        return linea;
    }
    
}
