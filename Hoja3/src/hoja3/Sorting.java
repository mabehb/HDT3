package hoja3;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase principal. En ella se crean los diferentes tipos de sort, que en este
 * caso son Selection, Insertion, Quick y Radix, y se crea el metodo para generar
 * los numeros al azar que en este caso son 3000 numeros de 1 a 10,000.
 * @author Belen Hernandez, Alejandro Rivera, Daniela Pocasangre, Juan Diego Benitez
 */
public class Sorting {
    //se almacenara una copia de los numeros aleatorios por cada sort a utilizar para ordenar
    
    /**
     * Metodo que genera numeros al azar. 
     * @return numero: de tipo int. Es un numero al azar desde 1 a 10,000.
     */
    public int numerosRandom(){
    	//metodo que genera un numero aleatorio entre 1 y 10000
        int numero=(int)(Math.random()*(10000-1+1)+1);
        return numero;
    }
    
    /**
     * Ordenamiento por medio de seleccion. Este tipo de ordenamiento compara el
     * primer numero seleccionado con el menor de todos los numeros del arreglo
     * y los intercambia de lugar. Continua haciendo esto con el siguiente numero
     * y asi sucesivamente hasta ordenar todo el arreglo.
     * @param Lista Este parametro contiene el arreglo a ordenar.
     */
    public void selectionSort(Comparable[] Lista){
        int numActual, numero, numMenor=0, posicion=0;
        System.out.println("\nLargo: " + Lista.length);
        for(int x=0; x<Lista.length; x++){
            numActual = ((ObjetoNumerales)Lista[x]).getNumero(); //numero en posicion x
            numero = numActual;
            posicion = x;
            for(int y=x+1; y<Lista.length; y++){ //para obtener el menor
                int numero2 = ((ObjetoNumerales)Lista[y]).getNumero();   //numero en posicion y
                //numero2 < numero
                if(Lista[x].compareTo(Lista[y])==1){   //si el de prueba es menor al fijo
                    numMenor = numero2;  //el menor es el de la posicion x+1
                    Lista[x] = new ObjetoNumerales(numero2);//el fijo se vuelve el de prueba
                    posicion = y;
                }
            }
            if(posicion != x){  //si la posicion es y
                Lista[x] = new ObjetoNumerales(numMenor);  //en la posicion x se guarda el menor  
                Lista[posicion]= new ObjetoNumerales(numActual); //se intercambian los numeros
            }
        }
    }
    
    /**
     * Ordenamiento por medio de insercion. Este tipo de ordenamiento compara
     * el segundo numero del arreglo con el primero y lo inserta en la posicion
     * deseada (de menor a mayor), luego compara el tercer numero con los otros
     * para saber donde hay que insertarlo y asi sucesivamente.
     * @param Cadena Este parametro contiene el arreglo a ordenar.
     */
    public void insertionSort(Comparable[] Cadena){
        int largoC = Cadena.length;
        int arreglo[] = new int[largoC];
        int Actual, Sig, Ant;
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
    
    /**
     * Ordenamiento por medio de un pivote. Se selecciona un numero al azar y se ordenan los demas numeros 
     * ya sean mayores o menores a este. Luego se selecciona otro pivote y se realiza lo mismo hasta
     * ordenar todo el arreglo.
     * @param list Este parametro contiene el arreglo a ordenar.
     */
    public void quickSort(Comparable[] list, int primero, int ultimo){
        if (list == null || list.length == 0) //si el arreglo no tiene elementos o ya no le quedan, termina el sort
            return;
        
        int indexP= primero+(ultimo-primero)/2; //posicion del objeto central del arreglo
        Comparable p = list[indexP]; //objeto en la posicion central
        
        int i=primero; //i recorrera el arreglo ascendentemente
        int j= ultimo; //j lo recorrera descendentemente
        
        while (i <= j) {//se ordenara hasta posicionar el pivote donde corresponde, en ese momento i>j
            while (p.compareTo(list[i])==1) {//i va de izquierda a derecha, por lo tanto el objeto en i debe ser menor al pivote
		i++;//mientras el objeto en i sea menor al pivote, se continuara recorriendo el arreglo hasta encontrar uno mayor al pivote
            }//al encontrarlo, se sabe que ese objeto debe ser reposicionado
            while (list[j].compareTo(p)==1) {//j recorre de derecha a izquierda, por lo tanto el objeto en j debe ser mayor al pivote
		j--; //mientras el objeto en j sea mayor, se continuara recorriendo el arreglo hasta encontrar uno menor al pivote
            }//al encontrarlo, se sabe que este tambien debe ser reposicionado
            if (i <= j) {//mienras i no haya entrado en el rango de j y j no haya entrado en el rango de i, se hace el intercambio
		ObjetoNumerales temp = (ObjetoNumerales)list[i];
                int numj= ((ObjetoNumerales)list[j]).getNumero();
		list[i] = new ObjetoNumerales (numj);
		list[j] = temp;
		i++;
		j--;
            }//se aumenta i y se disminuye j para saber donde comienza el nuevo arreglo
        }
        if (primero < j)//mientras j sea positivo, quiere decir que aun hay elementos sin ordenar a la izquierda
            quickSort(list, primero, j);//se delimita un "subarreglo" desde el principio hasta la posicion j ya que despues de j los elementos estan ordenados
	if (ultimo > i) //si todo fue ordenado hacia la izquierda, se procede a ordenar hacia la derecha
            quickSort(list, i, ultimo); //se deliminta un subarreglo desde i hasta el final del arreglo (ya que antes de i todo esta ordenado)
    }

    /**
     * Ordenamiento por medio de comparacion de digitos. Este tipo de ordenamiento
     * compara los digitos de la i-esima posicion de cada numero del arreglo 
     * y los ordena de menor a mayor, luego hace lo mismo con el siguiente
     * digito de cada numero y asi sucesivamente.
     * @param lista Este parametro contiene el arreglo a ordenar.
     */
    public void radixSort(Comparable[] lista){
        ObjetoNumerales[] digitos = new ObjetoNumerales[lista.length]; //cadena que almacena los digitos

        for(int d=1; d<10000; d = d*10){ //for realizado para obtener digito en la i-esima posicion
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
