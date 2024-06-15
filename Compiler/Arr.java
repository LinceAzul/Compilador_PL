import java.util.*;

/* Esto es una clase que representa una colección de arrays, guardadas cada una con los siguientes datos:

    1. Tipo
    2. Nombre de la variable
    3. Longitud del array
   
    Quedando de la siguiente manera:

    (* (int, a, 10),  ... *)
            \
        int a[10];
 */

public class Arr {
		private String tipo;
        private String variable;
        private String longitud;
        private List<Object> valores; // (tipo, valor)

        private List<Arr> listaArrays;

        // Constructor del objeto que contendrá a todos los arrays en la lista de arrays
        public Arr(){
            this.tipo = null;
            this.variable = null;
            //this.valores = new ArrayList<>();
            this.longitud = "0";
            listaArrays = new ArrayList();
        }
        
        // Constructor de un objeto array (la idea es que esté dentro de la lista de arrays)
        public Arr(String tipo, String variable, String longitud){
            this.tipo = tipo;
            this.variable = variable;
            this.longitud = longitud;
            this.valores = new ArrayList<>();
            while(this.valores.size() < 10) this.valores.add(null);
        }
        
        // Inserta un array en la lista de todos los arrays.
        public void insertarArray(String tipo, String variable, String longitud){
            listaArrays.add(new Arr(tipo, variable, longitud));
        }
        
        // Inserta un elemento del array en una posición determinada
        public void insertarValor(String variable, String posicion, String valor){
            if(getArray(variable) != null){
                Arr aux = getArray(variable);
                aux.valores.add(Integer.parseInt(posicion), valor);
            }
        }
        
        // Devuelve un objeto, si el array deseado está en la lista de todos los arrays. Sino, devuelve null.
        public Arr getArray(String variable){
            for(Arr a: listaArrays){
                if(a.variable.equals(variable)) return a;
            }
            return null;
        }
        

        
        // Verifica en la lista de arrays del objeto actual, si el array pasado como parametro está o no está.
        public boolean contieneArray(String variable){
            //return getArray(variable).variable.equals(variable);
            for(Arr a: listaArrays){
                if(a.variable.equals(variable)) return true;
            }
            return false;
        }
        
        // Imprime la lista de todos los arrays contenidos en el objeto actual
        public void imprimirListaArrays(){
            System.out.println(listaArrays);
            System.out.print("\nLista de arrays: (*\n ");
            int cnt = 0;
            for(Arr a : listaArrays){
                System.out.print("Array número "+cnt+ " -> ");
                a.imprimirActual();
                ++cnt;
            }
            System.out.println(" *)");
        }
        
        // Imprime el objeto array actual
        public void imprimirActual(){
            System.out.println("( "+tipo+" "+variable+"["+longitud+"] )");
            System.out.print("\tValores del array entero: **( ");
            for(int i = 0; i < valores.size(); ++i){
                if(valores.get(i) != null){
                    System.out.print(variable+ "["+i+ "] = "+valores.get(i)+ " ");
                }
            }
            System.out.println(" )**");
        }

        // Imprime el array entero como pide printmat (uno a uno con \n)
        public void printmat(String variable){
            Arr aux = getArray(variable);
            for(Object o : aux.valores){
                if(o != null) System.out.println(o);
            }
        }

        // Getters y setters del objeto array actual

        // Devuelve la longitud de un array de la lista. Si no está el array, devuelve  null
        public String getLongitud(String variable){
            for(Arr a : listaArrays){
                if(a.variable.equals(variable)) return a.longitud;
            }
            return null;
        }

        // Devuelve el valor de un array, situado en una posicion determinada
        public String getValor(String variable, String posicion){
            String res = "";
            if(getArray(variable) != null){
                Arr aux = getArray(variable);
                res = (aux.valores.get(Integer.parseInt(posicion))).toString();
            }
            return res;
        }

        public List<Object> getValores(String variable){
            Arr aux = getArray(variable);
            return aux.valores;
        }

        public String getTipo(String variable){
            for(Arr a : listaArrays){
                if(a.variable.equals(variable)) return a.tipo;
            }
            return null;
        }

        public String getThisLongitud(){
            return this.longitud;
        }
}