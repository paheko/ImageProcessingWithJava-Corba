package multiagentes;

/**
* multiagentes/ImagenesHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from imagenes.idl
* jueves 10 de mayo de 2012 23H58' CDT
*/

public final class ImagenesHolder implements org.omg.CORBA.portable.Streamable
{
  public multiagentes.Imagenes value = null;

  public ImagenesHolder ()
  {
  }

  public ImagenesHolder (multiagentes.Imagenes initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = multiagentes.ImagenesHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    multiagentes.ImagenesHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return multiagentes.ImagenesHelper.type ();
  }

}