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
    private int[] selectionArray;
    private int[] insertionArray;
    private int[] quickArray;
    private int[] radixArray;
    
    public Sorting(){
    //constructor de la clase Sorting
    //cada arreglo contredra 3000 numeros
    selectionArray= new int[3000];
    insertionArray= new int[3000];
    quickArray= new int[3000];
    radixArray= new int[3000];
    }
    
    public int numerosRandom(){
    //metodo que genera un numero aleatorio entre 1 y 10000
        int numero=(int)(Math.random()*(10000-1+1)+1);
        return numero;
    }
    
    public void setArreglos(int x, int z){
    //setter para tener 4 copias de los numeros aleatorios
        this.selectionArray[x]=z;
        this.insertionArray[x]=z;
        this.quickArray[x]=z;
        this.radixArray[x]=z;
    }
    
    public int getSelectionArray(int x){
        return selectionArray[x];
    }
    
    public int getInsertionArray(int x){
        return insertionArray[x];
    }
    
    public int getQuickArray(int x){
        return quickArray[x];
    }
    
    public int getRadixArray(int x){
        return radixArray[x];
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
