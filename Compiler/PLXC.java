import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class PLXC {	   
	public static PrintStream out; 
	public static void main(String argv[]) {    
    try {
      Reader in = new InputStreamReader(System.in);	
      out = System.out;
      if (argv.length > 0) {
    	  in = new FileReader(argv[0]);
      }
      if (argv.length >  1) {
    	  out = new PrintStream(new FileOutputStream(argv[1]));
        System.setOut(out); // Redirige la salida estándar al archivo
      }
      parser p = new parser(new Yylex(in));
      Object result = p.parse().value;  
      
      // Cerrar el flujo de salida si se cambió para que los cambios se guarden en el archivo
      if (out != System.out) {
        out.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
