/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.aspsolutions.Validator;

import javax.swing.JOptionPane;

/**
 *
 * @author britt
 */
public class Checkeo {   
    
    public int checkNumerosPalabras(){
        
        String response ="";
        int number = 0;
        boolean canContinue = false;
        
        do {
            
            response = JOptionPane.showInputDialog("¿Cuantas palabras desea buscar?");
            
            try {
               
                number = Integer.valueOf(response);
                canContinue = true;
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "Debe proporcionar un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                canContinue = false;
            }
            
        } while (!canContinue);
        
        
        if (number <= 0) {
            number = 1;
        }
        
        return number;
    }
    
    
    public String checkStringPalabras(int number){
        
        String cadena = "";
        boolean canContinue = false;
        
        do {
            
            cadena = JOptionPane.showInputDialog("Por favor ingrese la palabra a buscar #" + number +"");
            
            try {
                
                canContinue = true;
                if (cadena == null || cadena.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar una palabra a buscar", "Error", JOptionPane.ERROR_MESSAGE);
                    canContinue = false;
                }else {
                    for (int i = 0; i < cadena.length(); i++) {
                        char c = cadena.charAt(i);
                        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                            JOptionPane.showMessageDialog(null, "Debe ingresar una palabra a buscar", "Error", JOptionPane.ERROR_MESSAGE);
                            canContinue = false;
                            break;
                        }                                        
                    }
                }
                
                if (canContinue) {
                    cadena  = cadena.toUpperCase();
                }                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "Debe proporcionar una palabra correcta a buscar", "Error", JOptionPane.ERROR_MESSAGE);
                canContinue = false;
            }            
        } while (!canContinue);
        
        
        return cadena;
    } 
    
}
