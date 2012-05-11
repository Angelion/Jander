/*
 * personaje.java
 * 
 * Clase que simula el comportamiento del personaje del juego
 * 
 * TIPO PERSONAJE
 * Atributos
 * 	nombre--cadena consultable y modificable
	raza----cadena consultable y modificable
	vida----entero consultable y modificable----No podra ser mayor que totalvida
	totalvida-entero consultable y modificable
	nivel-----entero consultable y modificable
	ataque----entero consultable y modificable
	defensa---entero consultable y modificable
	agilidad--enteor consultable y modificable
	dinero----entero consultable y modificable
	experiencia-enteor consultable y modificable
	pocion----entero consultable y modificable

	Procesos
	* 	 personaje (string nombre, int raza) ----Constructor
	* 	 imprimirestado (nada)
	 int getnivel ()
	 int getataque ()	
	 int getdefensa ()
	 int getagilidad ()
	 int getdinero ()
	 int getexperiencia ()
	 int getvida ()
	 int gettotalvida()
	 int getpocion ()
	 String getnombre ()
	 String getraza ()
	 int combo ()
	 int contataq()
	 int contdef()
	 int contagi() 

	      setnivel (int a)
	      setataque (int a)	
	      setdefensa (int a)
	      setagilidad (int a)
	      setdinero (int a)
	      setexperiencia (int a)
	      setvida (int a)
	      settotalvida (int a)
	      setpocion (int a)
	      set combo (int a)
	      set contataq(int a)
	      set contdef(int a)
	      set contagi (int a) 
 * 
 ******************************************************************/


public class personaje {
	
	private String nombre;
	private String raza;
	private int vida;
	private int totalvida;
	private int nivel;
	private int ataque;
	private int defensa;
	private int agilidad;
	private int dinero;
	private int experiencia;
	private int pocion;
	private int combo;
	private int contataq;
	private int contdef;
	private int contagi;
	
	public void imprimirestado()
		{
		System.out.print(nombre+"  Lv"+nivel+ "\tVIDA:");
		for(int i=0;i<vida;i++)
			{
			System.out.print("\3");
			}
		System.out.print("\n");	
		}
	
	/*
	 * Constructor 
	 * */
	
	public personaje (String a, int b)//nombre y tipo de raza	
		{
		nombre=a;
		nivel=1;
		switch(b)
			{
			case 1:
				System.out.print(nombre+"  Lv"+nivel+ "\tVIDA:");
				raza="Elfo";
				ataque=15;
				defensa=10;
				agilidad=20;
				vida=25;
				totalvida=25;
				break;
			case 2:
				System.out.print(nombre+"  Lv"+nivel+ "\tVIDA:");
				raza="Enano";
				ataque=20;
				defensa=20;
				agilidad=5;
				vida=50;
				totalvida=50;
				break;
			case 3:
				raza="Friki";
				ataque=10;
				defensa=10;
				agilidad=15;
				vida=30;
				totalvida=30;
				break;
			case 4:
				raza="ChuckNorris";
				ataque=25;
				defensa=5;
				agilidad=5;
				vida=40;
				totalvida=40;
				break;
			case 5:
				raza="AeroCerdo";
				ataque=15;
				defensa=5;
				agilidad=25;
				vida=35;
				totalvida=35;
				break;
			}
		experiencia=0;
		dinero=100;
		pocion=1;
		combo=0;
		contagi=1;
		contataq=1;
		contdef=1;	
		}
		
	public int getnivel (){return(nivel);}
	public int getataque (){return(ataque);}	
	public int getdefensa (){return(defensa);}
	public int getagilidad (){return(agilidad);}
	public int getdinero (){return(dinero);}
	public int getexperiencia (){return(experiencia);}
	public int getvida (){return(vida);}
	public int gettotalvida(){return(totalvida);}
	public int getpocion (){return(pocion);}
	public String getnombre (){return(nombre);}
	public String getraza (){return(raza);}
	public int getcombo () {return (combo);}
	public int getcontataq (){return(contataq);}
	public int getcontdef(){return(contdef);}
	public int getcontagi(){return(contagi);}

	public void setnivel (int a){nivel=a;}
	public void setataque (int a){ataque=a;}	
	public void setdefensa (int a){defensa=a;}
	public void setagilidad (int a){agilidad=a;}
	public void setdinero (int a){dinero=a;}
	public void setexperiencia (int a){experiencia=a;}
	public void setvida (int a){vida=a;}
	public void settotalvida (int a) {totalvida=a;}
	public void setpocion (int a){pocion=a;}
	public void setcombo(int a){combo=combo+a;}
	public void setcontatq(int a){contataq=contataq + a;}
	public void setcontdef(int a){contdef=contdef + a;}
	public void setcontagi(int a){contagi=contagi + a;}

			
}

