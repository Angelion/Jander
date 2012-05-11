/*
 * Punto.java
 * 
 * Copyright 2012 atclemente <atclemente@106-19>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

import java.io.*;
public class Punto implements Serializable,Cloneable{
	 private int X;
	 private int Y;
	 
	public Punto ()
	{
		super();	
	} 
	public Punto (int a, int b)
	{
		this();
		this.X=a;
		this.Y=b;	
	}
	 
	public void setX (int a){this.X=a;}
	public void setY (int a){this.Y=a;}
	public int getX (){return this.X;} 
	public int getY (){return this.Y;}
	
	public int almacenaPunto () throws IOException, ClassNotFoundException
	{
		int cantidad=1,i=0;
		Punto a=new Punto ();
		File archivo=new File (".\\puntos.txt");
		if(!archivo.exists())
			{
			archivo.createNewFile();	
			}
		FileInputStream fl=new FileInputStream (".\\puntos.txt");
		ObjectInputStream Ot=new ObjectInputStream (fl);
		String a="Jaaaander";
		for(i=0;i<a.)
		int numObjetos = (int)(archivo.length()/8);
		int j = 0;
		Punto [] array=new Punto [numObjetos+1];
		while (j<numObjetos)
		{
			a=(Punto)Ot.readObject();
			array[j]=a;
			j++;
		}
		while ((a=(Punto)Ot.readObject())!=null)
				{
					array[i]=a;
					i++;
				}
			array[i]=this;	
		
		return i;
	}
	public static void main (String args[]) throws IOException, ClassNotFoundException{
		Punto a=new Punto (2,5);
		a.almacenaPunto();
	}
}

