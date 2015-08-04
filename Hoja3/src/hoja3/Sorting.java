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
                    for (int w = 0; w<50; w++){
                        System.out.print(((ObjetoNumerales)Cadena[w]).getNumero() + " ");
                    }
                    System.out.println();
		try{
                    
                    Actual = ((ObjetoNumerales)Cadena[x]).getNumero();
			Sig = ((ObjetoNumerales)Cadena[x+1]).getNumero();
			if(Cadena[x].compareTo(Cadena[x+1])>0){
				Cadena[x+1] = new ObjetoNumerales(Actual);
				if (x==0){
					Cadena[x] = new ObjetoNumerales(Sig);
				}
				else{
					Ant = ((ObjetoNumerales)Cadena[x-1]).getNumero();
					if (Cadena[x+1].compareTo(Cadena[x-1])>0){ //Cadena[x+1] es Temp; Cadena[x-1] es Temp2
						Cadena[x] = new ObjetoNumerales(Sig);
						Cadena[x+1] = new ObjetoNumerales(Actual);
					
					}
                                        
                                        //if (Ant>Sig){
					if (Cadena[x-1].compareTo(Cadena[x])>0){ //Cadena[x] es ahora nuestro nuevo siguiente
						int y = x;
						//while (Ant>Sig){
                                                while (Cadena[y-1].compareTo(Cadena[y])>0){
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
                        else if (Cadena[x+1].compareTo(Cadena[x])>0){
				Cadena[x] = new ObjetoNumerales(Actual);
				Cadena[x+1] = new ObjetoNumerales(Sig);
			}
                }
                    
                   
		catch (Exception e){
                    for (int w = 0; w<50; w++){
                        System.out.print(((ObjetoNumerales)Cadena[w]).getNumero() + " ");
                    }

			System.out.println("e");
		}

		

	}
        
    }
    
    public void quickSort(Comparable[] list){
        
    }
    
    public void radixSort(Comparable[] list){
        
    }
}
