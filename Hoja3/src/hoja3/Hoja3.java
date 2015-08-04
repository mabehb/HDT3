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
 * @author Ma. Belen, Alejandro Rivera, Daniela Pocasangre, Juan Diego Benitez
 */
public class Hoja3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //arrays de tipo numerales
        
        ObjetoNumerales[] selectionArray = new ObjetoNumerales[3000];
        ObjetoNumerales[] insertionArray = new ObjetoNumerales[3000];
        ObjetoNumerales[] quickArray = new ObjetoNumerales[3000];
        ObjetoNumerales[] radixArray = new ObjetoNumerales[3000];
        //Para que hagan sus pruebas
        /*ObjetoNumerales[] selectionArray = new ObjetoNumerales[50];
        ObjetoNumerales[] insertionArray = new ObjetoNumerales[50];
        ObjetoNumerales[] quickArray = new ObjetoNumerales[50];
        ObjetoNumerales[] radixArray = new ObjetoNumerales[50];
        */
        // TODO code application logic here
        //Se crea un fichero para guardar 3000 numeros aleatorios
        File numeros= new File("numeros.txt");
        //si ya existia el archivo, debe borrarse su contenido para sobreescribirlo
        numeros.delete();
        Sorting sorting = new Sorting();
        //este ciclo llena el archivo de texto
        for (int x=0; x<3000; x++){
        //Para que hagan sus pruebas
        //for (int x = 0; x<50; x++){
            //intenta editarse el archivo
            try{
                FileWriter editar = new FileWriter(numeros,true);
                //se utiliza el metodo para generar numeros aleatorios de la clase Sorting
                editar.write(sorting.numerosRandom()+"\n");
                editar.close();
            }
            catch (Exception e){
                System.out.println ("Error al escribir");
            }
        }
        //se procede a extraer los numeros del archivo de texto
        try{
            BufferedReader br = new BufferedReader(new FileReader(numeros));
                try { //array de tipo numeral que implementa comparable
                    int z=0;
                    for(String line; (line = br.readLine()) != null; ){
                        selectionArray[z] = new ObjetoNumerales(Integer.parseInt(line));
                        insertionArray[z] = new ObjetoNumerales(Integer.parseInt(line));
                        quickArray[z] = new ObjetoNumerales(Integer.parseInt(line));
                        radixArray[z] = new ObjetoNumerales(Integer.parseInt(line));
                        z++;
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
        /*int contador=0;
        for (int x=0; x<3000;x++){
            //se imprime el elemento en esa posicion para cada lista (deben ser iguales)
            System.out.println(sorting.getSelectionArray(x));
            System.out.println(sorting.getInsertionArray(x));
            System.out.println(sorting.getQuickArray(x));
            System.out.println(sorting.getRadixArray(x));
            contador++;
            //tambien se imprime un contador para verificar que sean 3000 numeros
            System.out.println("fue el elemento #: "+contador);
        }*/
        
        //se llama dos veces a cada metodo, para medir el tiempo que cada sort tarda en ordenar y en recorrer al estar ya ordenado
        /*sorting.selectionSort();
        sorting.selectionSort();
        sorting.insertionSort();
        */
        sorting.insertionSort(insertionArray);
        System.out.println("Final: ");
        //Para que hagan sus pruebas
        //for (int g = 0; g<50; g++){
        for (int g = 0; g<3000; g++){
            System.out.print(insertionArray[g].getNumero() + " ");
        }
        
        /*
        sorting.quickSort();
        sorting.quickSort();
        sorting.radixSort();
        sorting.radixSort();*/
    }
    
}
