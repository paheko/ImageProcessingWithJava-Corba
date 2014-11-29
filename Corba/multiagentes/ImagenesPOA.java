package multiagentes;


/**
* multiagentes/ImagenesPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from imagenes.idl
* jueves 10 de mayo de 2012 23H58' CDT
*/

public abstract class ImagenesPOA extends org.omg.PortableServer.Servant
 implements multiagentes.ImagenesOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("leer", new java.lang.Integer (0));
    _methods.put ("BlancoNegro", new java.lang.Integer (1));
    _methods.put ("AumentarBrillo", new java.lang.Integer (2));
    _methods.put ("QuitarBrillo", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // multiagentes/Imagenes/leer
       {
         String imagen = in.read_string ();
         this.leer (imagen);
         out = $rh.createReply();
         break;
       }

       case 1:  // multiagentes/Imagenes/BlancoNegro
       {
         String imagen = in.read_string ();
         this.BlancoNegro (imagen);
         out = $rh.createReply();
         break;
       }

       case 2:  // multiagentes/Imagenes/AumentarBrillo
       {
         String imagen = in.read_string ();
         this.AumentarBrillo (imagen);
         out = $rh.createReply();
         break;
       }

       case 3:  // multiagentes/Imagenes/QuitarBrillo
       {
         String imagen = in.read_string ();
         this.QuitarBrillo (imagen);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:multiagentes/Imagenes:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Imagenes _this() 
  {
    return ImagenesHelper.narrow(
    super._this_object());
  }

  public Imagenes _this(org.omg.CORBA.ORB orb) 
  {
    return ImagenesHelper.narrow(
    super._this_object(orb));
  }


} // class ImagenesPOA
