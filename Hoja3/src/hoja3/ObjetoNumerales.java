/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja3;

/**
 *
 * @author Daniela
 */
public class ObjetoNumerales implements Comparable {
   
    private int numero;
    
    public ObjetoNumerales(int valor){
        numero = valor;
    }
    
    public int compareTo(Object num){
        
        int resultado=0;
        int numanterior = ((ObjetoNumerales)num).getNumero(); //obtiene el numero anterior a comparar
        
        if(numero>numanterior){ //compara numero actual con anterior
            resultado = 1;
        }
        
        if(numero==numanterior){ //compara si el numero actual es igual al anterior
            resultado = 2;
        }
        
        else{
            resultado = 0;
        }
        
        return resultado;
    }
    
    public int getNumero(){
        return numero;
    }
}
