import multiagentes.ImagenesPOA; // Importar la superclase generada a partir del IDL
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import multiagentes.*;

public class ImagenImpl extends ImagenesPOA {
  File imagen;
Image img;
	String aux = "";
	public int[][] R;
	public int[][] G;
	public int[][] B;
	public int color;
	public static BufferedImage negatiimag;
	public BufferedImage negatiimag2;
	public int ancho;
	public int alto;
	int contador=0;
  
  public ImagenImpl(){
    //contador = 0;
	
  }
 
  public void leer(String imagen1)
	{
		System.out.println("esta es la imagen"+imagen1);
		System.out.println("entrando imagen");
		System.out.println(imagen1);
		File file = new File(imagen1);
		System.out.println("entrando file");
		imagen=file;
		try
		{
			System.out.println("entrando try");
			negatiimag = ImageIO.read(imagen);
			ancho = negatiimag.getWidth();
			alto = negatiimag.getHeight();
			descom();
			Gris();
			System.out.println("La imagen se ha guardado en C:\\imagen");
                        
		}
		catch (IOException e)
		{
			System.err.println("Error " + e);
			e.printStackTrace(System.out);
		}
		//return "hecho";
	}
	
	public void BlancoNegro(String imagen1)
	{
		System.out.println("esta es la imagen"+imagen1);
		System.out.println("entrando imagen");
		System.out.println(imagen1);
		File file = new File(imagen1);
		System.out.println("entrando file");
		imagen=file;
		try
		{
			System.out.println("entrando try");
			negatiimag = ImageIO.read(imagen);
			ancho = negatiimag.getWidth();
			alto = negatiimag.getHeight();
			descom();
			Binarizar();
                        
		}
		catch (IOException e)
		{
			System.err.println("Error " + e);
			e.printStackTrace(System.out);
		}
		//return "hecho";
	}
	
	public void AumentarBrillo(String imagen1)
	{
		System.out.println("esta es la imagen"+imagen1);
		System.out.println("entrando imagen");
		System.out.println(imagen1);
		File file = new File(imagen1);
		System.out.println("entrando file");
		imagen=file;
		try
		{
			System.out.println("entrando try");
			negatiimag = ImageIO.read(imagen);
			ancho = negatiimag.getWidth();
			alto = negatiimag.getHeight();
			descom();
			Brillantar();
                        
		}
		catch (IOException e)
		{
			System.err.println("Error " + e);
			e.printStackTrace(System.out);
		}
		//return "hecho";
	}
	
	public void QuitarBrillo(String imagen1)
	{
		System.out.println("esta es la imagen"+imagen1);
		System.out.println("entrando imagen");
		System.out.println(imagen1);
		File file = new File(imagen1);
		System.out.println("entrando file");
		imagen=file;
		try
		{
			System.out.println("entrando try");
			negatiimag = ImageIO.read(imagen);
			ancho = negatiimag.getWidth();
			alto = negatiimag.getHeight();
			descom();
			Desbrillantar();
                        
		}
		catch (IOException e)
		{
			System.err.println("Error " + e);
			e.printStackTrace(System.out);
		}
		//return "hecho";
	}
	
	
	
	public void descom()
	{
		R = new int[ancho][alto];
		G = new int[ancho][alto];
		B = new int[ancho][alto];
		for (int i = 0; i < ancho; i++)
		{
			for (int j = 0; j < alto; j++)
			{
				color = negatiimag.getRGB(i, j);
				R[i][j] = (color & 0xff0000) >> 16;
				G[i][j] = (color & 0x00ff00) >> 8;
				B[i][j] = (color & 0x0000ff);
			}
		}

	}
public void Gris() throws IOException
	{
		negatiimag2 = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
		double verde;
		double rojo;
		double azul;
		for (int i = 0; i < ancho; i++)
		{
			for (int j = 0; j < alto; j++)
			{
				negatiimag2.setRGB(i, j, ((R[i][j] + G[i][j] + B[i][j]) / 3 << 16 | (R[i][j] + G[i][j] + B[i][j]) / 3 << 8 | (R[i][j] + G[i][j] + B[i][j]) / 3));

			}
		}
		File file2 = new File("C:\\imagen\\imagen" + contador + ".jpg");
		ImageIO.write(negatiimag2, "jpeg", file2);
               
	}
	
	public void Binarizar() throws IOException
	{
		negatiimag2 = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
		double verde;
		double rojo;
		double azul;
		for (int i = 0; i < ancho; i++)
		{
			for (int j = 0; j < alto; j++)
			{

				if (((R[i][j] + G[i][j] + B[i][j]) / 3) <= 128)
				{
					R[i][j] = 0;
					G[i][j] = 0;
					B[i][j] = 0;
					negatiimag2.setRGB(i, j, (R[i][j] << 16 | G[i][j] << 8 | B[i][j]));
				}
				else
				{
					R[i][j] = 255;
					G[i][j] = 255;
					B[i][j] = 255;
					negatiimag2.setRGB(i, j, (R[i][j] << 16 | G[i][j] << 8 | B[i][j]));
				}


			}

		}  File file2 = new File("C:\\imagen\\imagen" + contador + ".jpg");
		ImageIO.write(negatiimag2, "jpeg", file2);
               // this.mostrarImagen(file2);
              //  imagen=file2;

	}
	public void Brillantar() throws IOException
	{
		negatiimag2 = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
		double a;
		//a = Double.parseDouble(JOptionPane.showInputDialog("Dame Rango"));
		a = .4;
		for (int i = 0; i < ancho; i++)
		{
			for (int j = 0; j < alto; j++)
			{
				//Aclara o oscureces
				R[i][j] = (int)(255 * Math.pow((R[i][j] / 255.0), a));
				G[i][j] = (int)(255 * Math.pow((G[i][j] / 255.0), a));
				B[i][j] = (int)(255 * Math.pow((B[i][j] / 255.0), a));
				negatiimag2.setRGB(i, j, (R[i][j] << 16 | G[i][j] << 8 | B[i][j]));

			}
		}

		File file2 = new File("C:\\imagen\\imagen" + contador + ".jpg");
		ImageIO.write(negatiimag2, "jpeg", file2);
               // this.mostrarImagen(file2);
             //  imagen=file2;
	}
	 public void Desbrillantar() throws IOException
	{
		negatiimag2 = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
		double a;
		//a = Double.parseDouble(JOptionPane.showInputDialog("Dame Rango"));
		a = 4;
		for (int i = 0; i < ancho; i++)
		{
			for (int j = 0; j < alto; j++)
			{
				//Aclara o oscureces
				R[i][j] = (int)(255 * Math.pow((R[i][j] / 255.0), a));
				G[i][j] = (int)(255 * Math.pow((G[i][j] / 255.0), a));
				B[i][j] = (int)(255 * Math.pow((B[i][j] / 255.0), a));
				negatiimag2.setRGB(i, j, (R[i][j] << 16 | G[i][j] << 8 | B[i][j]));

			}
		}

		File file2 = new File("C:\\imagen\\imagen" + contador + ".jpg");
		ImageIO.write(negatiimag2, "jpeg", file2);
                //this.mostrarImagen(file2);
               // imagen=file2;
	}
}

 

  