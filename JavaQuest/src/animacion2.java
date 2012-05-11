/*animacion.java
 * 
 * 
 * char caracter=177;
 */

import java.util.*;
public class animacion2 {
	
	public static void pintarTerreno (char a[][])
	{
		int i=0,j=0;
		for(j=0;j<10;j++)
			{
			for(i=0;i<40;i++)
				{
				System.out.print(a[i][j]);
				}
			System.out.print("\n");	
			}
	}
	
	public static char[][] actualizarTerreno (char a[][])
	{
		Random rnd=new Random ();
		int i=39,j,num;
		boolean terreno=false;
		for(j=9;j>=0;j--)
				{	
				num=rnd.nextInt(3);	
				if(j==9)
					a[i][j]=177;
				if(j<9)
					{
					switch(num)
						{
						case 0://si desciende el terreno
							if(j==8)
								a[i][j]=' ';
							else
								{
								terreno=true;
								}								
							break;
						case 1://si se mantiene
							a[i][j]=' ';
							break;
						case 2://si se eleva
							if(a[i][j+1]==177 && a[i-1][j+1]==177)
								a[i][j]=177;
							break;
						}	
					}
				if(j<9 && terreno==true)
					{
					a[i][j]=' ';
					terreno=false;	
					}
				}	
		return(a);	
	}
	
	static void esperar ()
	{
		try {
			Thread.sleep(100);
		} catch (InterruptedException ex) {
			// aquí tratamos la excepción como queramos, haciendo nada, sacando por pantalla el error, ...
			}
	}
	
	public static char[][] copiarTerreno (char a[][])
	{
		char [][] array=new char [40][10];//columnas y filas
		int i=0,i2=1,j=0;
		for(i=0,i2=1;i<40 && i2<40;i++,i2++)
			{
			for(j=0;j<10;j++)
				{
					array[i][j]=a[i2][j];
				}
			}	
		return(array);
	}
	
	public static char[][] iniciarTerreno (char a[][])
	{
		Random rnd = new Random ();
		boolean terreno=false;
		char caracter=177;
		int i=0,j=9,num;
		for(i=0;i<40;i++)
			{	
			for(j=9;j>=0;j--)
				{	
				num=rnd.nextInt(3);	
				if(j==9)
					a[i][j]=177;
				if(j<9)
					{
					switch(num)
						{
						case 0://si desciende el terreno
							if(j==8)
								a[i][j]=' ';
							else
								{
								terreno=true;
								}								
							break;
						case 1://si se mantiene
							a[i][j]=' ';
							break;
						case 2://si se eleva
							if(a[i][j+1]==177 && a[i-1][j+1]==177)
								{
								a[i][j]=177;
								}
							break;
						}	
					}
				if(j<9 && terreno==true)
					{
					a[i][j]=' ';
					terreno=false;	
					}
				}
				
			}
		return(a);
	}
		
	static void limpiapantalla ()
	{
		int i;
		for(i=0;i<25;i++)
			{
			System.out.print("\n");	
			}
		}
	
	public static char[][] pintarpersonaje (char a[][])
	{
		int i=19,j=0,aux=0;
		for(j=0;j<10;j++)
			{
				if(a[i][j]==177)
					aux=j;
			}
		a[i][aux-1]=1;	
		return(a);
	}
	
	public static int caida (char a[][])
	{
	int j=0,i=a.length-1;
	boolean encontrado=false;
		for(j=0;encontrado==false && j<10;j++)
			{
				if(a[i][j]==177)
					encontrado=true;
			}
	return(j);	
	}
	
	public static char[][] actualizarpersonaje (char a[][])
	{
		int i,j,i2=0,j2=0,j3=0;
		for(i=0;i<40;i++)
			{
			for(j=0;j<10;j++)
				{
				if(a[i][j]==1)
					{
					i2=i;
					j2=j;	
					}
				}
			}
		if(a[i2+1][j2]==177)//si se encuentra un bloque
			{
			a[i2][j2]=' ';
			a[i2+1][j2-1]=1;
			a=actualizarTerreno(a);
			}
		else
			{	
			if(a[i2+1][j2]==' ' && a[i2+1][j2+1]==177)//si encuentra suelo
				{
				a[i2+1][j2]=1;
				a[i2][j2]=' ';
				a=actualizarTerreno(a);	
				}
			else
				{
				j3=caida(a);//si hay una caida
				j3=j3-2;	
				a[i2+1][j3]=1;
				a[i2][j2]=' ';						
				}
			}		
										
		return(a);
	}
		
	public static void main (String args[]) 
	{
		Scanner teclado=new Scanner (System.in);
		char [][] array=new char [40][10];//columnas y filas
		array=iniciarTerreno(array);
		array=pintarpersonaje(array);
		pintarTerreno(array);
		do{
		array=copiarTerreno(array);
		array=actualizarTerreno(array);
		array=actualizarpersonaje(array);
		pintarTerreno(array);	
		esperar();
		limpiapantalla();	
		}while(true);
	}
}

