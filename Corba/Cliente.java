import org.omg.CosNaming.*;
import java.io.File;
import multiagentes.*;  // Importar las clases e interfaces generados a partir del IDL
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Cliente {

    public static void main(String[] args)  {
       try  {	    
	  // 1. Inicializar ORB
	  org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
	  System.out.println("X");
	  // 2.1 Obtener instancia del servidor de nombres (initial naming context)
	  org.omg.CORBA.Object ncCorba = orb.resolve_initial_references("NameService");
	  NamingContextExt nc = NamingContextExtHelper.narrow(ncCorba);
	  System.out.println("Y");
	  // 2.2 Construir el nombre del objeto y obtener ref. desde servidor de nombres
	  org.omg.CORBA.Object calculadoraCorba = nc.resolve(nc.to_name("Imagenes"));
	  System.out.println("X");
	  // 2.4 Convertir el objeto CORBA al tipo Calculadora (narrow) 
	  Imagenes imagenes = ImagenesHelper.narrow(calculadoraCorba);
	  System.out.println("X");
	  // invocamos metodos remotos
	 // File archivo = new File("E:\\eliminar.jpg");
	  String prueba,imagen1="E:\\eliminar.jpg";
	  int opcion;
	   BufferedReader leer;
       leer= new BufferedReader (new InputStreamReader(System.in));
      
	   System.out.println("X");
	   System.out.println("Escoge que opcion deseas hacer para la imagen");
	    System.out.println("1.- Grises \n 2.- Blanco y negro \n 3.- Aumentar Brillo \n 4.- Quitar brillo");
	    opcion=Integer.parseInt(leer.readLine());
		switch (opcion){
			case 1:
				 System.out.println("Escogiste escala de grises");
				 imagenes.leer("E:\\eliminar.jpg");
				 break;
			case 2:
				 System.out.println("Escogiste blanco y negro");
				 imagenes.BlancoNegro("E:\\183390_10150151365491554_523831553_8234584_5379308_n.jpg");
				 break;
			case 3:
				 System.out.println("Escogiste blanco y negro");
				 imagenes.AumentarBrillo("E:\\eliminar.jpg");
				 break;
			case 4:
				 System.out.println("Escogiste blanco y negro");
				 imagenes.QuitarBrillo("E:\\eliminar.jpg");
				 break;
			
		}
	 
	   System.out.println("Xdddddd");
		}
	catch (Exception e) {
	  //System.out.println("Error: cliente" + e.getMessage());
	  e.printStackTrace(System.out);
	  System.exit(1);
       }
	}
	
}