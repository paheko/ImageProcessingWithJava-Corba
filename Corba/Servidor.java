import org.omg.PortableServer.*;
import org.omg.CosNaming.*;


import multiagentes.*;

public class Servidor{
public static void main(String[] args) {
        try {
            // 1. Inicializar ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // 2.1 Obtener POA raiz
            POA raizPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

            // 2.2 Activar el POA manager
            raizPOA.the_POAManager().activate();

            // 3.1 Crear instancia de la implementación (servant)
            ImagenImpl calculadoraServant = new ImagenImpl();

            // 3.2 Registrar en el POA y obtener referencia al objeto (IOR)
            org.omg.CORBA.Object calculadoraCorba = raizPOA.servant_to_reference(calculadoraServant);

            // 4.1 Obtener el initial naming context
            org.omg.CORBA.Object ncCorba = orb.resolve_initial_references("NameService");
            NamingContextExt nc = NamingContextExtHelper.narrow(ncCorba);

            // 4.2 Asociar un nombre (en el primer nivel)
            nc.rebind(nc.to_name("Imagenes"), calculadoraCorba);

            // 5 Quedar a la espera de peticiones
	    System.out.println("Proceso servidor en espera ... ");
            orb.run();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            System.exit(1);

        }
    }
}