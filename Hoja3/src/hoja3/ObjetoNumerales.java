/**
 * Clase que implementa a la interfaz Comparable. En esta se generan los metodos
 * que comparan numeros y generan objetos de arreglos.
 * @author Belen Hernandez, Alejandro Rivera, Daniela Pocasangre, Juan Diego Benitez
 */
public class ObjetoNumerales implements Comparable {
   
    private int numero;
    
    /**
     * Crea objetos de arreglos. Sirve para generar diferentes arreglos de tipo
     * entero (int).
     * @param valor De tipo entero. Contiene el valor del numero.
     */
    public ObjetoNumerales(int valor){
        numero = valor;
    }
    
    /**
     * Metodo de comparacion de elementos de un arreglo. Compara dos elementos
     * de un arreglo para saber si son mayores, menores o iguales.
     * @param num Es un elemento de un arreglo.
     * @return resultado: Contiene 1 si el numero 1 es mayor al 2, y 0 si no lo es.
     */
    public int compareTo(Object num){
        
        int resultado=0;
        int numanterior = ((ObjetoNumerales)num).getNumero(); //obtiene el numero anterior a comparar
        
        if(numero>numanterior){ //compara numero actual con anterior
            resultado = 1;
        }        
        
        else{
            resultado = 0;
        }
        
        return resultado;
    }
    
    /**
     * Metodo que retorna el numero.
     * @return numero: Es un elemento del arreglo.
     */
    public int getNumero(){
        return numero;
    }
}
