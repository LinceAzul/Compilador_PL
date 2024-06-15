    /* ------ Definición de una clase que guarda el tipo y el valor ------ 
     * UTILIDAD: Como una tupla -> (tipo, valor)
    */

public class EntradaTabla {

    private String tipo;
    private Object valor;

    public EntradaTabla(String tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}