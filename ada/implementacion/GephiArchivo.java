/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.implementacion;

import ada.beans.Grafo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    
    public GephiArchivo(String tipoAlgoritmo, Grafo grafo){
        this.algoritmo = tipoAlgoritmo;
        generaArchivo(grafo);
    }
    
    private void generaArchivo(Grafo grafo){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy hh-mm-ss");
        Date fecha = new Date();
        String nombreArchivo = "D:\\ArchivosGephi";
        switch(algoritmo){
            case ERDOSRENYI:
                nombreArchivo = nombreArchivo + "\\ErdosRenyi\\grapho"+algoritmo+sdf.format(fecha).toString()+".gv";
                break;
            case GILBERT:
                nombreArchivo = nombreArchivo + "\\Gilbert\\grapho"+algoritmo+sdf.format(fecha).toString()+".gv";
                break;
            case GEOGRAFICO:
                nombreArchivo = nombreArchivo + "\\Geografico\\grapho"+algoritmo+sdf.format(fecha).toString()+".gv";
                break;
            case BARABASIALBERT:
                nombreArchivo = nombreArchivo + "\\BarabasiAlbert\\grapho"+algoritmo+sdf.format(fecha).toString()+".gv";
                break;
        }
        
        String encabezado = "graph "+ algoritmo +"{\n";
        String grafoFin = "}";
        String cuerpoArchivo = encabezado + generaGrafo(grafo)+grafoFin;
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
//                    System.out.println("Nodo: "+grafo.getNodos().get(i).getId()+" "+grafo.getNodos().get(i).getVertices().toString());
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
    
}
