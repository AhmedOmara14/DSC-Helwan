/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc;

import dsc.Databases.Databases;

/**
 *
 * @author Ahmed
 */
public class DSC {

   
    public static void main(String[] args) {
        Databases d=new Databases();
        
        d.connect();
        d.create();
        
        
    }
    
}
