package hoja3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Driver de Sorting.java. Aqui se crean los arreglos con los numeros al azar,
 * y se mandan a llamar todos los tipos de ordenamiento (los diferentes sorts).
 * @see Sorting
 * @see ObjetoNumerales
 * @author Belen Hernandez, Alejandro Rivera, Daniela Pocasangre, Juan Diego Benitez
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
        
        //se llama dos veces a cada metodo, para medir el tiempo que cada sort tarda en ordenar y en recorrer al estar ya ordenado
        /*sorting.selectionSort();
        sorting.selectionSort();
        sorting.insertionSort();
        */
        System.out.println("Random: ");
        for (int g = 0; g<3000; g++){
            System.out.print(quickArray[g].getNumero() + " ");
        }
        
        System.out.println();
        sorting.selectionSort(selectionArray);
        System.out.println("Final Selection: ");
        //for (int g = 0; g<50; g++){
        for (int g = 0; g<3000; g++){
            System.out.print(selectionArray[g].getNumero() + " ");
        }
            
        sorting.insertionSort(insertionArray);
        System.out.println("Final Insertion: ");
        for (int g = 0; g<3000; g++){
            System.out.print(insertionArray[g].getNumero() + " ");
        }
        
        System.out.println();
        sorting.quickSort(quickArray, 0, 2999);
        System.out.println("Final Quick: ");
        for (int g = 0; g<3000; g++){
            System.out.print(quickArray[g].getNumero() + " ");
        }
       
        System.out.println();
        sorting.radixSort(radixArray);
        System.out.println("Final Radix: ");
        for (int g = 0; g<3000; g++){
            System.out.print(radixArray[g].getNumero() + " ");
        }

        /*
        sorting.quickSort();
        sorting.quickSort();
        sorting.radixSort();
        sorting.radixSort();*/
    }
    
}
