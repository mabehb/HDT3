/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja3;

/**
 *
 * @author Ma. Belen, Alejandro Rivera, Daniela Pocasangre, Juan Diego Benitez
 */
public class Sorting {
    //se almacenara una copia de los numeros aleatorios por cada sort a utilizar para ordenar
    
    public int numerosRandom(){
    //metodo que genera un numero aleatorio entre 1 y 10000
        int numero=(int)(Math.random()*(10000-1+1)+1);
        return numero;
    }
    
    public void selectionSort(Comparable[] list){
    
    }
    
    public void insertionSort(Comparable[] Cadena){
        int largoC = Cadena.length;
        int arreglo[] = new int[largoC];
        int Actual, Sig, Ant;
        System.out.println("Largo: " + Cadena.length);
        for (int x = 1; x<Cadena.length; x++){
		try{
                    
                    Actual = ((ObjetoNumerales)Cadena[x]).getNumero();
                    Sig = ((ObjetoNumerales)Cadena[x+1]).getNumero();
                    if(Cadena[x].compareTo(Cadena[x+1])==1){
                            Cadena[x+1] = new ObjetoNumerales(Actual);
                            if (x==0){
                                    Cadena[x] = new ObjetoNumerales(Sig);
                            }
                            else{
                                    Ant = ((ObjetoNumerales)Cadena[x-1]).getNumero();
                                    if (Cadena[x+1].compareTo(Cadena[x-1])==1){ //Cadena[x+1] es Temp; Cadena[x-1] es Temp2
                                            Cadena[x] = new ObjetoNumerales(Sig);
                                            Cadena[x+1] = new ObjetoNumerales(Actual);

                                    }

                                    //if (Ant>Sig){
                                    if (Cadena[x-1].compareTo(Cadena[x])==1){ //Cadena[x] es ahora nuestro nuevo siguiente
                                            int y = x;
                                            //while (Ant>Sig){
                                            while (Cadena[y-1].compareTo(Cadena[y])==1){
                                                    Cadena[y] = new ObjetoNumerales(Ant);
                                                    if(y!=1){
                                                            Ant = ((ObjetoNumerales)Cadena[y-2]).getNumero(); //era 2
                                                    }
                                                    if (y==1){
                                                            if(Ant>Sig){
                                                            //if(Cadena[y].compareTo(Cadena[y-1])>0){ <---Averiguar ant y sig
                                                                    Cadena[y-1] = new ObjetoNumerales(Sig);
                                                            }
                                                            else if (Sig>Ant){
                                                                    Cadena[y] = new ObjetoNumerales(Sig);
                                                            }
                                                            break;

                                                    }
                                            Cadena[y-1] = new ObjetoNumerales(Sig);
                                            y--;
                                            }

                                            }
                                    }

                            }
                    //Este pareciera estar de mas porque funciona si se lo quitamos jaja
                    else if (Cadena[x+1].compareTo(Cadena[x])==1){
                            Cadena[x] = new ObjetoNumerales(Actual);
                            Cadena[x+1] = new ObjetoNumerales(Sig);
                    }
                }
                   
		catch (Exception e){
			System.out.println("e");
		}

		

	}
        
    }
    
    public void quickSort(Comparable[] list){
        
    }
    
    public void radixSort(Comparable[] lista){
        ObjetoNumerales[] digitos = new ObjetoNumerales[lista.length]; //cadena que almacena los digitos
        System.out.println("\nLargo: " + lista.length);

        for(int d=1; d<10000; d = d*10){ //for realizado parao obtener digito en la i-esima posicion
            int counter = 0; //determina si se debe de seguir ordenando o si ya estan ordenados
            while(counter<lista.length){
                for(int x=1; x<lista.length; x++){
                    //se obtiene numero actual y el anterior en array
                    int antnum = ((ObjetoNumerales)lista[x-1]).getNumero();
                    int num = ((ObjetoNumerales)lista[x]).getNumero();

                    //Obtiene digitos segun la posicion que se desea averiguar
                    int digant = (((ObjetoNumerales)lista[x-1]).getNumero()/d) % 10;
                    int digact = (((ObjetoNumerales)lista[x]).getNumero()/d) % 10;
                    //se almacena en un array el digito para poder ser comparable
                    digitos[x-1] = new ObjetoNumerales(digant);
                    digitos[x] = new ObjetoNumerales(digact);

                    if(digitos[x].compareTo(digitos[x-1])>0){ //si el digito actual es mayor al anterior no se cambian posiciones
                        counter++;
                    }
                    
                    else{
                        if(digant==digact){ //si los digitos son iguales no se cambia posicion
                            counter++;
                        }
                        else{ //si el digito actual es menor al anterior se cambian de posicion
                            lista[x-1] = new ObjetoNumerales(num);
                            lista[x] = new ObjetoNumerales(antnum);
                            digitos[x-1] = new ObjetoNumerales(digact);
                            digitos[x] = new ObjetoNumerales(digant);
                        }
                    }
                    
                    if(counter<(lista.length-1) && x==(lista.length-1)){ //si todos los numeros actuales no son mayores a los anteriores se repite el ordenamiento
                        counter = 0;
                    }
                }
            }
        }  
    }
}
