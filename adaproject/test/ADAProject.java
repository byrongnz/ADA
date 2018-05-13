/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaproject.test;

import ada.algoritmos.BarabasiAlbert;
import ada.algoritmos.ErdosRenyi;
import ada.algoritmos.GeograficoSimple;
import ada.algoritmos.Gilbert;
import java.security.SecureRandom;

/**
 *
 * @author T440
 */
public class ADAProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        
//        ErdosRenyi erdos = new ErdosRenyi(100, 90);
        Gilbert gilbert = new Gilbert(500, .8);
//        GeograficoSimple gs = new GeograficoSimple(1000, .1);
//        BarabasiAlbert ba = new BarabasiAlbert(1000, 7);
    }
    
}
