/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.beans;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T440
 */
public class Nodo {
    private String id;
    private List<Arista> vertices; 
    private double coordenadaX;
    private double coordenadaY;
    private final static String GEOGRAFICO = "Geografico";
    private double porcentaje = 1;
    private int grado = 0;
    private boolean existe = false;
    private boolean explorado = false;
    
    private boolean visitado = false;
    private int distacia = -1;
    private String nodoPrevio = "";

    public Nodo(int id){
        setId(String.valueOf(id));
        //this.porcentaje = 100;
        vertices = new ArrayList<Arista>();
    }
    
    public Nodo(int id, String tipo){
        setId(String.valueOf(id));
        vertices = new ArrayList<Arista>();
        
        if(tipo.equals(GEOGRAFICO)){
            SecureRandom random = new SecureRandom();
            coordenadaX = random.nextDouble();//String.valueOf(random.nextDouble());
            coordenadaY = random.nextDouble();//String.valueOf(random.nextDouble());
            System.out.println("Coordenada nodo "+id+" X: "+coordenadaX+" Y:"+coordenadaY);
        }

    }

    public String getNodoPrevio() {
        return nodoPrevio;
    }

    public void setNodoPrevio(String nodoPrevio) {
        this.nodoPrevio = nodoPrevio;
    }

    public int getDistacia() {
        return distacia;
    }

    public void setDistacia(int distacia) {
        this.distacia = distacia;
    }
     
    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Arista getVertice(int id) {
        return vertices.get(id);
    }
    
    public List<Arista> getVertices() {
        return vertices;
    }

    public void setVertice(Arista vertice, int id) {
        //this.vertice = new Arista();
        this.vertices.set(id, vertice);
    }
    
    public void addVertice(Arista vertice) {
        //this.vertice = new Arista();
        this.vertices.add(vertice);
    }
    
    public void setVertices(List<Arista> vertices) {
        //this.vertice = new Arista();
        this.vertices = vertices;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
    public boolean isExplorado() {
        return explorado;
    }

    public void setExplorado(boolean explorado) {
        this.explorado = explorado;
    }
    
    @Override
    public String toString(){
        String string = "";
        for (int i = 0; i < vertices.size(); i++) {                    
            string = string + vertices.get(i).toString();
        }
        return "--Nodo "+getId()+"*"+string;
    }
}
