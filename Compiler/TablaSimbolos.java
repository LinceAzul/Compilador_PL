import java.util.HashMap;
import java.util.List;

/* Esto es una clase que representa un tabla que guarda una variable con su tipo y su valor.
   
   Los elementos de "tabla" son los siguientes:
 * 1. La Key: Es la variable (numero, numeroFlotante, letra, Sergio)
 * 2. El Value: es una clase de la variable con su valor (int -> 6, float -> 6.66, char -> 'c', String -> "Calvo")
 * 
 * RESULTADO: numero -> (int, 6), Sergio -> (String, "Calvo")
 */

public class TablaSimbolos {
		
    public static HashMap<String, EntradaTabla> tabla = new HashMap<>(); 
    public static Arr listaArrays = new Arr();
    public static boolean isBoolean;

   // public TablaSimbolos() {
        
   // }
    /*****************************************************************************************/
    /*********************************** GETTERS Y SETTERS ***********************************/
    /*****************************************************************************************/

    // Devuelve la entrada (Tipo, Valor) e.g. (String, "Sergio")
    public static EntradaTabla getEntrada(String variable) {
        return tabla.get(variable);
    }

    // Devuelve el tipo de una variable ("int", "float"...)
    public static String getTipo(String variable) {
        EntradaTabla aux =  tabla.get(variable);
        if(aux != null) return aux.getTipo();
        else return null;
    }

     // Devuelve el tipo de un array ("int", "float"...)
     public static String getTipoArray(String variable){
        return listaArrays.getTipo(variable);
    }

     // Devuelve valor de un array situado en una posicion determinada
     public static String getValorArray(String variable, String posicion){
        return listaArrays.getValor(variable, posicion);
    }


    // Devuelve el valor de una variable
    public static String getValor(String variable){
        EntradaTabla aux =  tabla.get(variable);
        Object valor = aux.getValor();
        if(valor == null) return null;
        else return valor.toString();
    }

    // Busca y devuelve una variable en base a su valor 
    public static String getVariable(String valor){
        String res = null;
        for(String k : tabla.keySet()){
            if(getValor(k) != null && getValor(k).contains(" ")){
                String valorAux = getValor(k);
                //System.out.println("VALORAUX _ "+valorAux);

                int indiceEspacioV = valorAux.indexOf(" ");
                //System.out.println("NUEVO indiceEspacioV = "+indiceEspacioV);

                String variableV = valorAux.substring(0, indiceEspacioV);
                String indiceArrayV = valorAux.substring(indiceEspacioV+1);
                
                int indiceEspacioP = valor.indexOf(" ");
                //System.out.println("NUEVO indiceEspacioP = "+indiceEspacioP);

                String variableP = valor.substring(0, indiceEspacioP);
                String indiceArrayP = valor.substring(indiceEspacioP+1);

                //System.out.println("*"+variableV + "=?" + variableP+"*");
                //System.out.println("*"+indiceArrayV + "=?" + indiceArrayP+"*");
                
                if(variableP.equals(variableV) && indiceArrayP.equals(indiceArrayV)){
                    //System.out.println("*"+variableV + "=?" + variableP+"*");
                    //System.out.println("*"+indiceArrayV + "=?" + indiceArrayP+"*");
                    res = k;
                    //System.out.println("NUEVO RES = "+res);
                } 
            }
            
        }
        return res;
    }

    // Devuelve un objeto Arr, si el array deseado está en la lista de todos los arrays. Sino, devuelve null.
    public static Arr getArray(String variable){
        return listaArrays.getArray(variable);
    }

    // Te deuelve la lista de valores de un array (e.g. tengo n[3] con 3 elementos. La lista de valores contiene n[0]...[n[2])
    public static List<Object> getListaValores(String variable){
        return listaArrays.getValores(variable);
    }

    // Devuelve la longitud de un array de la lista. Si no está el array, devuelve  null
    public static String getLongitudArray(String variable){
        return listaArrays.getLongitud(variable);
    }

    public static String getIsBoolean(){
       return (isBoolean == true) ? "true" : "false";
    }

    public static void setIsBoolean(String valor){
        if(valor.equals("true")){
            isBoolean = true;
        }
        else {
            isBoolean = false;
        }
    }

    /*******************************************************************************************/
    /********************************* Funciones de inserción **********************************/
    /*******************************************************************************************/

    // Inserta una variable (no array)
    public static void insertarVariable(String variable, String tipo, Object valor) {

        tabla.put(variable, new EntradaTabla(tipo, valor));
    }

    // Inserta un array en la lista de todos los arrays.
    public static void insertarArray(String tipo, String variable, String longitud){
        listaArrays.insertarArray(tipo, variable, longitud);
    }

    // Inserta un valor en una posicion del array
    public static void insertarValorArray(String variable, String posicion, String valor){
        //System.out.println("Quiero meter "+valor+" en la variable "+variable+ " en la posicion "+posicion);
        listaArrays.insertarValor(variable, posicion, valor);
    }
    
    /*******************************************************************************************/
    /*********************************** Funciones booleanas ***********************************/
    /*******************************************************************************************/
    // Devuelve true si se contiene la variable pasada como parametro
    public static boolean contieneVariable(String variable){
        return tabla.containsKey(variable);
    }

    // Devuelve true si se contiene el array pasado como parametro
    public static boolean contieneArray(String variable){
        return listaArrays.contieneArray(variable);
    }

    /*******************************************************************************************/
    /******************************** Funciones de impresión ***********************************/
    /*******************************************************************************************/

    // Imprime el array entero como pide printmat (uno a uno con \n)
    public static void printmat(String variable){
        listaArrays.printmat(variable);
    }


    // Imprime la lista de todos los arrays
    public static void imprimirListaArrays(){
        listaArrays.imprimirListaArrays();
    }

    // Imprime la tabla de símbolos (sin arrays)
    public static void printTabla() {
        System.out.println(" ---------------- listado de la tabla de simbolos ----------------");

        for (String nombre : tabla.keySet()) {
            EntradaTabla entrada = tabla.get(nombre);
            System.out.println("# " + String.format("%-20s", entrada.getTipo() + " " + nombre) + "= " + entrada.getValor());
        }

        System.out.println(" -----------------------------------------------------------------");
        //System.out.println(tabla.toString());
    }	
}