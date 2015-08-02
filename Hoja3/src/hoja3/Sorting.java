/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja3;

/**
 *
 * @author Ma. Belen
 */
public class Sorting {
    //se almacenara una copia de los numeros aleatorios por cada sort a utilizar para ordenar
    private int[] listaSelection;
    private int[] listaInsertion;
    private int[] listaQuick;
    private int[] listaRadix;
    //linea que contendra los numeros del archivo de texto para despues ingresarlos en los arreglos
    private String linea;
    
    public Sorting(){
    //constructor de la clase Sorting
    //cada arreglo contredra 3000 numeros
    listaSelection= new int[3000];
    listaInsertion= new int[3000];
    listaQuick= new int[3000];
    listaRadix= new int[3000];
    }
    
    public int numerosRandom(){
    //metodo que genera un numero aleatorio entre 1 y 10000
        int numero=(int)(Math.random()*(10000-1+1)+1);
        return numero;
    }
    
    public void setString(String linea){
      this.linea = linea;
    }
    
    public void setListaSelection(){
        int z=0;
        for (int x=0; x<linea.length();x++){
            if (linea.charAt(x)!=32){
                listaSelection[z]=x;
                z++;
            }
            else{
                
            }
        }
    }
    
    //este getter es solo para comprobar que el arreglo se haya guardado, HAY QUE BORRARLO en cuanto funcione
    public int getListaSelection(int x){
        return listaSelection[x];
    }
    public void selectionSort(Comparable[] list){
    
    }
    
    public void insertionSort(Comparable[] list){
        
    }
    
    public void quickSort(Comparable[] list){
        
    }
    
    public void radixSort(Comparable[] list){
        
    }
}
