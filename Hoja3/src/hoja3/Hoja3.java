/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja3;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        //si ya existia el archivo, debe borrarse su contenido para sobreescribirlo
        numeros.delete();
        Sorting sorting = new Sorting();
        //este ciclo llena el archivo de texto
        for (int x=0; x<3000; x++){
            //intenta editarse el archivo
            try{
                FileWriter editar = new FileWriter(numeros,true);
                //se utiliza el metodo para generar numeros aleatorios de la clase Sorting
                editar.write(sorting.numerosRandom()+" ");
                editar.close();
            }
            catch (Exception e){
                System.out.println ("Error al escribir");
            }
        }
        //REVISAR LECTURA DE ARCHIVO PARA GUARDAR EN UN ARREGLO
        //se procede a extraer los numeros del archivo de texto
        try{
            BufferedReader br = new BufferedReader(new FileReader(numeros));
                try {
                    for(String line; (line = br.readLine()) != null; ){
                        sorting.setString(line);
                    }
                }
                catch(IOException ex) {
                        Logger.getLogger(Hoja3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        catch(FileNotFoundException ex) {
            Logger.getLogger(Hoja3.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //probando si se guardo el arreglo
        for (int x=0; x<3000;x++){
            System.out.println(sorting.getListaSelection(x));
        }
        
        //se llama dos veces a cada metodo, para medir el tiempo que cada sort tarda en ordenar y en recorrer al estar ya ordenado
        /*sorting.selectionSort();
        sorting.selectionSort();
        sorting.insertionSort();
        sorting.insertionSort();
        sorting.quickSort();
        sorting.quickSort();
        sorting.radixSort();
        sorting.radixSort();*/
    }
    
}
