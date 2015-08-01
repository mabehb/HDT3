/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja3;
import java.io.*;
/**
 *
 * @author Ma. Belen
 */
public class Hoja3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Se crea un fichero para guardar 3000 numeros aleatorios
        File numeros= new File("numeros.txt");
        //si ya existia, debe borrarse su contenido para sobreescribirlo
        numeros.delete();
        Sorting sorting = new Sorting();
        //este ciclo llena el archivo de texto
        for (int x=0; x<3000; x++){
            //intenta editarse el archivo
            try{
                FileWriter editar = new FileWriter(numeros,true);
                editar.write(sorting.numerosRandom()+" ");
                editar.close();
            }
            catch (Exception e){
                System.out.println ("Error al escribir");
            }
        }
        /*sorting.selectionSort();
        sorting.insertionSort();
        sorting.quickSort();
        sorting.radixSort();*/
    }
    
}
