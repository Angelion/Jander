/*
 * prueba.java
	VIDEOJUEGO
	* Inicio
	* 	Preguntar nombre
	* 	leer nombre
	* 	repetir
	* 	mostrar personaje
	* 	mostrar menu opcion y validar
	* 	segun opcion
	* 		caso 1:
	* 			buscar enemigos
	* 		caso 2:
	* 			buscar tesoro
	* 		caso 3:
	* 			mejorar
	* 		caso 4: 
	* 			imprimir estado
	* 	fin segun
	* mientras (queramos seguir)
 
	BUSCAR ENEMIGOS
	* inicio
	* 	preparar nombre--NUEVO MODULO
	* 	luchar-----------NUEVO MODULO
	* 	actualizar estado-NUEVO MODULO
	* 	devolver (experiencia)
	* fin
	* 
	BUSCAR TESORO
	* inicio
	* 	realizar busqueda
	* 	cambiar opcion
	* fin
	
	MEJORAR
	* inicio
	* repetir
	* 	mostrar opciones-NUEVO MODULO
	* 	segun opcion
	* 		caso 1:
	* 			mejorar a
	* 		caso 2:
	* 			mejorar b
	* 		caso 3:
	* 			mejorar c
	* 	fin segun
	* 	preguntar si seguir
	* mientras (queramos seguir) 
	* devolver (dinero)
	* fin pp
	* 		
	
	PREPARAR NOMBRE
	* inicio
	* 	para (letra=0, letra menor que 8, letra ++)
	* 		realizar random
	* 		imprimir vocal o consonante
	* 	fin para
	* fin	
 
	LUCHAR
	* Inicio
	* 	generar enemigo
	* 	mientras(enemigo no muerto o protagonista no muerto)
	* 		Mostrar opcion de lucha--NUEVO MODULO
	* 		Realizar accion del enemigo
	* 	fin mientras
	* devolver experiencia
	* 
	
	OPCION DE LUCHA
	* inicio
	* 	repetir
	* 		escribir("LUCHAR, ESQUIVAR, DEFENDER")
	* 		leer opcion
	* 	mientras (eleccion no valida)
	* 	segun (opcion)
	* 		caso 1: 
	* 			realizar ataque
	* 			validar si se realizó--NUEVO MODULO
	* 		caso 2:
	* 			realizar esquivo
	* 			validar si se realizo
	* 		caso 3:
	* 			realizar resistir
	* 			validar si se realizo
	*	fin segun
	* fin pp
	
	VALIDAR SI REALIZADO
	* inicio
	* 	tirada aleatoria para protagonista
	* 	tirada aleatoria para pc
	* 	comparar cual es mayor
	* 	si gano protagonista
	* 		opcion=1
	* 	sino
	* 		opcion=2
	* devolver opcion
 */

import java.util.*;

public class JavaQuest {
	/*
	 * buscarenemigo
	 * Programa que calcula el enemigo al que se enfrentara el protagonista
	 * 
	 * Entrada: un objeto---> protagonista
	 * Precondicciones:El objeto debe estar inicializado
	 * Salida: nada
	 * Postcondicciones: ninguna
	 * 
	 * cabecera: void buscarenemigos (personaje)
	 * 
	 * */
	static void buscarenemigos (personaje protagonista)//vida, ataque, defensa, agilidad, nivel y nombre
	{
		Random rnd=new Random();
		int nivelenemigo=0,experiencia=0; 
		nivelenemigo=rnd.nextInt(10)*elegirsitio(protagonista);//Revisar el nivel que se manda
		imprimirnombre();
		luchar(protagonista,nivelenemigo); 
		}
		
		/*
	 * buscartesoro
	 * Programa que calcula el tesoro que encontrará el protagonista
	 * 
	 * Entrada: nada
	 * Precondicciones:ninguna
	 * Salida: nada---simplemente actualiza la variable dinero o pocion
	 * Postcondicciones: ninguna
	 * 
	 * cabecera: nada buscartesoro (nada)
	 * 
	 * */
	static void buscartesoro (personaje protagonista)
	{
		Random rnd=new Random();
		int pocion=0, suerte=0, dinero=1,oportunidad=0;
		oportunidad=rnd.nextInt(2);
		pocion=rnd.nextInt(10);
		suerte=rnd.nextInt(10);
		if(oportunidad==0)//si salio pocion
		{
			if((pocion>suerte) && (protagonista.getpocion()<3))
				{
				System.out.println("Felicidades! Encontraste una pocion!");
				protagonista.setpocion(protagonista.getpocion()+1);
				}
			else{
				System.out.println("Vaya!...No encontraste nada...");
				}	
		}
		else{//si salio dinero
			if(pocion>suerte)
				{
				dinero=rnd.nextInt(100)+50;
				System.out.println("Felicidades! Encontraste "+dinero+" de dinero");
				protagonista.setdinero(protagonista.getdinero()+dinero);
				}
			else{
				System.out.println("Vaya!...No encontraste nada...");
				}
			}			
		}
		
	/*
	 * Elegirsitio
	 * Subprograma que simula el lugar donde se buscara a los enemigos
	 * Entrada: un objeto personaje
	 * Precondiccion: el objeto personaje debe estar inicializado
	 * Salida: un entero----El sitio elegido
	 * Postcondiccion: ninguna
	 * 
	 * Cabecera: entero elegirsitio (personaje)
	 * */	
	static int elegirsitio (personaje protagonista)
	{
		Scanner teclado=new Scanner (System.in);
		int opcion=0,i=1;
			do{
				System.out.print("Elige el sitio donde pelearas:");
				switch(protagonista.getnivel())
					{
					case 1: case 2: case 3: case 4:
						System.out.print("\n1)Prado (Niveles 1-5)");
						break;
					case 5: case 6: case 7: case 8:
						System.out.print("\n1)Prado (Niveles 1-5)\n2)Meseta (Niveles 6-10)");
						i++;
						break;
					case 9: case 10: case 11: case 12: 
						System.out.print("\n1)Prado (Niveles 1-5)\n2)Meseta (Niveles 6-10)\n3)Costa (Niveles 10-14");
						i=i+2;
						break;
					}	
				System.out.print("\n\nRESP:");
				opcion=teclado.nextInt();
			}while(opcion<0 || opcion>i);
		
		return(opcion);
	}
	
	
		/*
	 * mejorar
	 * Programa que calcula los puntos para la mejora del protagonista
	 * 
	 * Entrada: un entero---> el dinero
	 * Precondicciones:ninguna
	 * Salida: un entero---->los puntos de la mejora
	 * Postcondicciones: ninguna
	 * 
	 * cabecera: entero mejorar (entero )
	 * 
	 * */
	
	static int mejorar (int a)//dinero	
	{
		int aux;
		aux=a;
		aux=aux*5/10;
		a=aux;
		return(a);
		}
	
	static void mejoraratributo (personaje protagonista, int a, int b)//el protagonista y el atributo a mejorar y el contador de éste
	{
		Scanner teclado=new Scanner (System.in);
		int costo=0, puntos=0;
		String aux;	
			switch(a)
				{
				case 1:	
				costo=calcularmejora(b,protagonista.getataque());
				if(protagonista.getdinero()>=costo)
				{	
					puntos=mejorar(protagonista.getataque());
					protagonista.setdinero(protagonista.getdinero()-costo);
					protagonista.setataque(protagonista.getataque()+puntos);
					System.out.println("Ahora! tu ataque sera de "+protagonista.getataque()+" puntos");
				}
				else
				{	
					System.out.println("No tienes suficiente dinero\nTienes "+protagonista.getdinero()+"\tCuesta:"+costo);	
				}
				break;
				
				case 2:
				costo=calcularmejora(b,protagonista.getdefensa());
				if(protagonista.getdinero()>=costo)
				{
					puntos=mejorar(protagonista.getdefensa());
					protagonista.setdinero(protagonista.getdinero()-costo);
					protagonista.setdefensa(protagonista.getdefensa()+puntos);
					System.out.println("Ahora! tu ataque sera de "+protagonista.getdefensa()+" puntos");	
				}
				else
				{	
					System.out.println("No tienes suficiente dinero\nTienes "+protagonista.getdinero()+"\tCuesta:"+costo);	
				}	
				break;
				
				case 3:
				costo=calcularmejora(b,protagonista.getagilidad());
				if(protagonista.getdinero()>=costo)
				{
					puntos=mejorar(protagonista.getagilidad());
					protagonista.setdinero(protagonista.getdinero()-costo);
					protagonista.setagilidad(protagonista.getagilidad()+puntos);
					System.out.println("Ahora! tu ataque sera de "+protagonista.getagilidad()+" puntos");
				}
				else
				{	
					System.out.println("No tienes suficiente dinero\nTienes "+protagonista.getdinero()+"\tCuesta:"+costo);	
				}
				break;
				}
			
				
			
		System.out.print("Introduce cualquier tecla para seguir:");
		aux=teclado.next();
		}
		/*
	 * pintarenemigo
	 * Programa que pinta el enemigo 
	 * 
	 * Entrada: nada
	 * Precondicciones:ninguna
	 * Salida: nada
	 * Postcondicciones: ninguna
	 * 
	 * cabecera: void pintarenemigo (nada)
	 * 
	 * */	
		
	static void pintarenemigo ()
	{
		Random rnd=new Random ();
		int aux=0, i;
		for(i=0;i<3;i++)
		{
			aux=rnd.nextInt(5)+1;
			if(i==0)
				{
				switch(aux)
					{
					case 1:
							System.out.println("  \\|||/  ");
							System.out.println(" | @   @|");
							System.out.println(" |  || /");
							System.out.println("  \\_=_/");
							break;
					case 2:	
							System.out.println(" (_(_|_)_)  ");
							System.out.println(" / +   -\\");
							System.out.println(" \\  (0) /");
							System.out.println("  \\_ Y_/");
							break;
					case 3:
							System.out.println("  ______  ");
							System.out.println(" / 0   0\\");
							System.out.println(" \\  3  /");
							System.out.println("  \\_W_/");
							break;
					case 4:
							System.out.println("  ______  ");
							System.out.println(" / () ()\\");
							System.out.println(" \\  -  /");
							System.out.println("  \\_()/");
							break;
					case 5:
							System.out.println("  ______  ");
							System.out.println(" / -  __-\\");
							System.out.println(" \\   __)/");
							System.out.println("  \\__?_/");
							System.out.println("  /  /");
							System.out.println(" /  /");
							System.out.println("  \\__\\");
							break;

					}		
				}
				if(i==1)
				{
					switch(aux)
					{
					case 1:
							System.out.println(" | 11 | ");
							System.out.println(" \\ 11  \\");
							System.out.println("  | 11	|");
							System.out.println("  / 11 /");
							System.out.println(" / 11/	");
							System.out.println(" (11 )");
							break;
					case 2:	
							System.out.println(" |      |");
							System.out.println(" ( .) ( .)");
							System.out.println(" |      |");
							System.out.println(" |   o  |");
							break;
					case 3:
							System.out.println(" (  - - )");
							System.out.println(" [_.||._]");
							System.out.println("  \\ __ /");
							System.out.println("  | __ |");
							break;
					case 4:
							System.out.println("   ||");
							System.out.println("   ||");
							System.out.println("   ||");
							System.out.println("   ||");
							break;
					case 5:
							System.out.println(" | # @ #|");
							System.out.println(" | @ # @|");
							System.out.println(" | # @ #|");
							System.out.println(" | @ # @|");
							break;

					}		
				}
				if(i==2)
				{
					switch(aux)
					{
						case 1:
							System.out.println(" | | | |");
							System.out.println(" [ ] [ ]");
							System.out.println(" ( ) ( )");
							System.out.println("(__) (__)");
							break;
						case 2:
							System.out.println("  |___| ");
							System.out.println("   |_|_");
							System.out.println("  // | \\");
							System.out.println("  || O |");
							System.out.println("  \\\\___/");
							break;
						case 3:
							System.out.println(" | | | |");
							System.out.println(" [ ] [ ]");
							System.out.println(" ( ) \\ /");
							System.out.println("(__)  0");
							break;
						case 4:
							System.out.println(" |   |_______");
							System.out.println(" |           \\");
							System.out.println(" |            |");
							System.out.println(" |  |   |__|  |");
							System.out.println(" |__|___|  |__|");
							System.out.println("  V-V V-V   V-V");
							break;
						case 5:
							System.out.println(" 10010110101");
							System.out.println(" 01010 01010");
							System.out.println("  010   101");
							System.out.println("   10   01");
							System.out.println("   01    01");
							System.out.println(" 1001    10001");
							break;				
						}
					}	
		}
	System.out.print("\n");
	}	
	
		/*
	 * imprimir nombre
	 * Programa que imprime el nombre aleatorio del enemigo
	 * 
	 * Entrada: nada
	 * Precondicciones:ninguna
	 * Salida: nada
	 * Postcondicciones: ninguna
	 * 
	 * cabecera: void imprimirnombre (nada)
	 * 
	 * */
	
	static void imprimirnombre	()
	{
		Random rnd=new Random ();
		int i, numero=0, opcion=1;
		System.out.print("Un ");
		for(i=0;i<4;i++)
			{
			if(opcion==1)
			 {
				 numero=rnd.nextInt(5);
				 switch(numero)
				 {
					case 0:
						System.out.print("a");
						break;
					case 1:
						System.out.print("e");
						break;
					case 2:
						System.out.print("i");
						break;
					case 3:
						System.out.print("o");
						break;
					case 4:
						System.out.print("u");
						break;			
				 }
				opcion=0; 
			}	
			if(opcion==0){	
			numero=rnd.nextInt(21);
			switch(numero)
				{
				case 0:
					System.out.print("b");
					break;
				case 1:
					System.out.print("c");
					break;
				case 2:
					System.out.print("d");
					break;
				case 3:
					System.out.print("f");
					break;
				case 4:
					System.out.print("g");
					break;
				case 5:
					System.out.print("h");
					break;
				case 6:
					System.out.print("j");
					break;
				case 7:
					System.out.print("k");
					break;
				case 8:
					System.out.print("l");
					break;
				case 9:
					System.out.print("m");
					break;
				case 10:
					System.out.print("n");
					break;
				case 11:
					System.out.print("p");
					break;
				case 12:
					System.out.print("q");
					break;				
				case 13:
					System.out.print("r");
					break;									
				case 14:
					System.out.print("s");
					break;
				case 15:
					System.out.print("t");
					break;
				case 16:
					System.out.print("v");
					break;
				case 17:
					System.out.print("w");
					break;
				case 18:
					System.out.print("x");
					break;
				case 19:
					System.out.print("y");
					break;
				case 20:
					System.out.print("z");
					break;							
				}
			opcion=1;
			}	
			}
		System.out.println(" aparecio!");	
		}
	
	static int apoyo (int a)//atributo
	{
	Scanner teclado=new Scanner (System.in);
	long tiempoantes,tiempodespues;
	int i=0;
	tiempoantes=System.nanoTime();
	tiempodespues=System.nanoTime();
	while((tiempodespues-tiempoantes)>a*100)
			{
				
			}
	return(i);
	}
	
	/* luchar
	 * 
	 * subprograma que realiza la lucha mientras varias condicciones lo permitan
	 * 
	 * Entrada: objeto personaje y un entero--->el protagonista y el nivel del enemigo
	 * Precondicciones:deben estar inicializados
	 * Salida: nada
	 * Postcondicciones: ninguna
	 * 
	 * cabecera: nada luchar (personaje,entero )
	 */ 
	
	static void luchar (personaje protagonista, int nivelenemigo)
	{
		Random rnd =new Random ();
		int vidaenemigo,aux,dano,experiencia=0;
		aux=rnd.nextInt(10)+1;
		vidaenemigo=aux*protagonista.getnivel()+1;
		pintarenemigo();
		while((vidaenemigo>0) && (protagonista.getvida()>0))
			{
			protagonista.imprimirestado();
			if(vidaenemigo>0)	
				System.out.println("VIDA DEL ENEMIGO:"+vidaenemigo);	
			dano=opciondelucha(protagonista);
			vidaenemigo=vidaenemigo-dano;
			if(vidaenemigo>0)
				{
				dano=accionenemigo(nivelenemigo);
				aux=dano-protagonista.getdefensa();
				if(aux<0 || aux==0 )
					System.out.println("Resististe el ataque del enemigo!");
				else
					{
					System.out.println("El enemigo te hizo "+aux+" puntos de herida");	
					protagonista.setvida(protagonista.getvida()-aux);
					}
				}
			if(dano<0)
				{
				dano=dano*(-1);
				vidaenemigo=vidaenemigo+dano;
				if(vidaenemigo>0)
					{
					dano=accionenemigo(nivelenemigo);
					aux=protagonista.getvida()-dano;
					protagonista.setvida(aux);
					}	
				}
			}
		if(protagonista.getvida()>0)	
			{
			aux=nivelenemigo*2;
			System.out.println("Conseguiste "+aux+" puntos de experiencia!");
			aux=protagonista.getexperiencia()+aux;
			protagonista.setexperiencia(aux);
			}
		protagonista.setdinero(protagonista.getdinero()+aux*nivelenemigo);		
		}
	/*
	 ******************************************************************************
	 *  COMBO
	 * 
	 * Subprograma que realiza el combo del ataque (ataques sucesivos)
	 * 
	 * Entrada: un objeto personaje
	 * Precondiccion: el objeto debe estar relleno
	 * Salida: un entero-----> el numero de golpes
	 * Postcondiccion: ninguna
	 * Cabecera: entero combo (personaje)
	 * *****************************************************************************/
	static int combo (personaje protagonista)
	{
		Calendar calendario=Calendar.getInstance();
		Scanner teclado=new Scanner (System.in);
		long tiempoantes,tiempodespues;
		int i=0;
		String b="";
		System.out.println("Realiza tantos ataques como puedas ahora!");
		tiempoantes=calendario.get(calendario.SECOND);
		do
			{
			calendario=Calendar.getInstance();	
			tiempodespues=calendario.get(calendario.SECOND);//Mas dinamico, mostrando el numero o caracter que debe pulsar
			b=teclado.next();
			i++;	
			}
		while((tiempodespues-tiempoantes)<protagonista.getagilidad()/2);	
		System.out.println("Has conseguido "+i+" golpes!");	
		esperar();
		return(i);		
		}
		
	/*
	 * opcion de lucha
	 * Subprograma que permite elegir que opcion de lucha y si fallo o no
	 * 
	 * entrada: un objeto personaje----> protagonista
	 * precondicciones: debe estar inicializado
	 * Salida: un entero------>el daño al enemigo
	 * Postcondicciones: ninguna
	 * cabecera: entero opciondelucha (personaje)
	 * */
	static int opciondelucha (personaje protagonista)
	{
		Random rnd =new Random ();
		Scanner teclado=new Scanner (System.in);
		int opcion,dano=0,accion,suerte,i=4;
		do{
		if(protagonista.getcombo()>=10)
			{
			System.out.print("\tQue haras?\n1)LUCHAR\t2)ESQUIVAR\n3)DEFENDERME\t4)UTILIZAR POCION\n\t5)COMBO\nRESP:");
			i=5;
			}
		else
			System.out.print("\tQue haras?\n1)LUCHAR\t2)ESQUIVAR\n3)DEFENDERME\t4)UTILIZAR POCION\nRESP:");
		opcion=teclado.nextInt();
		}while(opcion<1 || opcion>i);
		switch(opcion)
			{
			case 1:
				accion=rnd.nextInt(protagonista.getataque());
				if(validaraccion())
					{
					dano=accion;
					System.out.println("Hiciste "+dano+" puntos de herida");
					protagonista.setcombo(protagonista.getcombo()+(dano/10));	
					}
				break;
			case 2:
				accion=rnd.nextInt(protagonista.getagilidad());
				suerte=rnd.nextInt(protagonista.getagilidad());
				if(accion>suerte)
					{
					dano=0;
					System.out.println("Esquivaste el ataque!");
					}
				break;
			case 3:
				accion=rnd.nextInt(10)+protagonista.getdefensa();
				suerte=rnd.nextInt(10)+protagonista.getdefensa();
				if(accion>suerte)
					{
					dano=accion-suerte/10;
					System.out.println("Te defendiste del ataque! Realizaste "+dano+" puntos de herida");	
					}
				else
					{
					dano=suerte-accion;
					System.out.println("No sirvio defenderse! el enemigo recupero "+dano+" puntos de vida");	
					dano=dano*-1;
					}
				break;
			case 4:
				utilizarpocion(protagonista);
				break;	
			case 5:
				accion=rnd.nextInt(protagonista.getataque());
				dano=combo(protagonista)+accion;
				System.out.println("Realizaste "+dano+" puntos de herida!");
				protagonista.setcombo(0);
				
			}
		return(dano);	
		}	
	
	static int accionenemigo (int a)//nivel enemigo, defensa
	{
		Random rnd=new Random ();
		int dano=0;
		dano=rnd.nextInt(5)*a;
		return(dano);
		}
	/*
	 * validaraccion
	 * Subprograma que verifica si la accion ha sido realizada o no
	 * 
	 * Entrada: ninguna
	 * precondiccion: ninguna
	 * Salida: un boolean
	 * postcondiccion: debe valer true o false
	 * cabecera: boolean validaraccion (nada)
	 * */
	static boolean validaraccion ()//devolver si realizado o no
	{
		Random rnd=new Random ();
		boolean opcion=false;
		int suerte, suertepc;
		suerte=rnd.nextInt(20);
		suertepc=rnd.nextInt(10);
		if(suerte>suertepc)
			opcion=true;
		else
			System.out.println("Fallaste!");
		return(opcion);
		}
		
		/*
		 * menu
		 * subprograma que imprime el menu y permite elegir opcion y validarla
		 * entrada: ninguna
		 * precondiccion: ninguna
		 * Salida: un entero
		 * postcondiccion: debe valer entre 1 y 5
		 * cabecera: entero menu (nada)
		 * */
		
	static int menu (int a)
	{
		Scanner teclado=new Scanner (System.in);
		int resp=1;
		switch(a){
			case 0:
				do{
				System.out.print("Que quieres hacer?\n1)BUSCAR ENEMIGOS!\t2)BUSCAR TESOROS\n3)ESTADO\t\t4)USAR POCION\n5)TABERNA\t\t6)SALIR\nRESP:");
				resp=teclado.nextInt();
				}while(resp<1 || resp>6);
				break;
			case 1:
				do{
				System.out.print("Entraste en la taberna\nQue quieres hacer?\n1)MEJORAR\t2)DESCANSAR\n3)JUGAR\t\t4)COMPRAR\n5)SALIR DE LA TABERNA\nRESP:");
				resp=teclado.nextInt();
				}while(resp<1 || resp>5);
				break;
		
		}
	return(resp);	
	}	
	
	/*TABERNA
	 * Subprograma que simula diferentes opciones que realizar dentro de una taberna
	 * 
	 * Entrada: un entero---> la accion a realizarç
	 * Precondiccion: debe valer entre 1 y 5
	 * Salida: ninguna
	 * Postcondiccion: ninguna
	 * cabecera: void taberna (entero)
	 * ***********************************/
	 static void taberna (int a, personaje protagonista)
	 {
		 Random rnd = new Random();
		 Scanner teclado =new Scanner (System.in);
		 int mejora,resp=0;
		 String aux;
		 switch(a)
		 {
			 case 1:
				do{
					System.out.print("Que deseas mejorar?\n1)ATAQUE\t2)DEFENSA\t3)AGILIDAD\n\t4)SALIR\nRESP:");
					mejora=teclado.nextInt();
					}while(mejora<1 || mejora>4);
					switch(mejora)
						{
							case 1:
								mejoraratributo(protagonista,mejora,protagonista.getcontataq());
								break;
							case 2:
								mejoraratributo(protagonista,mejora,protagonista.getcontdef());
								break;
							case 3:
								mejoraratributo(protagonista,mejora,protagonista.getcontagi());
								break;
							case 4:
								System.out.print("Introduce cualquier tecla para seguir:");
								aux=teclado.next();
								break;
							}
				break;
			 case 2:
				descansar(protagonista);
				break;
			 case 3:
				jugar(protagonista);
				break;
			 case 4:
				comprar(protagonista);
				break;
			 }
		 }
		
	/*
	 * Comprar
	 * Subprograma que simula una tienda
	 * Entrada: un objeto personaje---> protagonista
	 * Precondiccion: debe estar cargado
	 * Salida: ninguna
	 * Postcondiccion: ninguna
	 * cabecera: ninguna comprar (personaje)
	 * */	
	 static void comprar (personaje protagonista)
	 {
		 Scanner teclado=new Scanner (System.in);
		 int resp;
		 do{
		 System.out.print("Bienvenido a la increible tienda que solo vende pociones!\nDeseas una pocion?\n1)SI\t2)No...SALIR\nRESP:");
		 resp=teclado.nextInt();
		}while(resp!=1 && resp!=2);
			while(resp==1 && protagonista.getdinero()>=20)
				{
					protagonista.setdinero(protagonista.getdinero()-20);
					protagonista.setpocion(protagonista.getpocion()+1);
					do{
					System.out.print("Compraste una pocion!\nDeseas seguir comprando?\n1)SI\t2)SALIR\nRESP:");
					resp=teclado.nextInt();
					}while(resp!=1 && resp!=2);
				}
			System.out.print("Adios!");	
		 
		 }
		
	/*
	 * JUGAR
	 * Subprograma que simula un juego para ganar dinero
	 * Entrada: un objeto personaje---> protagonista
	 * Precondiccion: debe estar cargado
	 * Salida: ninguna
	 * Postcondiccion: ninguna
	 * cabecera: ninguna jugar (personaje)
	 * */	
	 static void jugar (personaje protagonista)
	 {
		 Scanner teclado=new Scanner(System.in);
		Random rnd=new Random();
		int eleccion=0,i,bolita,apuesta;
		String opcion;
		boolean ganas=false;
		if(protagonista.getdinero()>0){
		do{//REPETIR MIENTRAS QUIERA SEGUIR
			do{
				System.out.print("Bienvenido al juego de los Trileros\nTienes "+protagonista.getdinero()+"\nCuanto desea apostar?\nRESP:");
				apuesta=teclado.nextInt();
			}while(apuesta> protagonista.getdinero() || apuesta<=0);
			protagonista.setdinero(protagonista.getdinero()-apuesta);	
			bolita=rnd.nextInt(3);//GENERAR NUMERO ALEATORIO
			for(i=0;i<3;i++)//PRESENTAR CUBOS
			{
				System.out.println(" _ ");
				System.out.println("|_|");
				System.out.println(" "+(i+1));
			}
			do{//REPETIR MIENTRAS OPCION NO VALIDA
				System.out.print("Donde esta la bolita?\nRESP:");//PREGUNTAR POR OPCION
				eleccion=teclado.nextInt();//LEER OPCION
			}while(eleccion<1 || eleccion>3);//VALIDAR OPCION
			for(i=0;i<3;i++)//PRESENTAR CUBOS
			{
				if(bolita==i)//Si el aleatorio es el cubo "i"
				{
					System.out.println(" _ ");
					System.out.println("|o|");//IMPRIMIMOS LA BOLITA
					System.out.println(" "+(i+1));
				}
				else
				{
					System.out.println(" _ ");
					System.out.println("|_|");
					System.out.println(" "+(i+1));	
				}
			}
		eleccion--;
		if(eleccion==bolita)//SI HE GANADO
			{
			apuesta=apuesta*2;	
			System.out.println("CORRECTO, HAS GANADO!\nHas conseguido "+apuesta+" dinero");
			protagonista.setdinero(protagonista.getdinero()+apuesta);	
			}
		else// si no gano
			{
			System.out.println("LO SENTIMOS, HAS PERDIDO!");	
			}
		System.out.print("Deseas seguir jugando? Si o no\n RESP:");//PREGUNTAR SI SEGUIR
		opcion=teclado.next();//LEER RESPUESTA
		if(opcion.equalsIgnoreCase("SI"))//SI QUIERO SEGUIR
			{
			ganas=true;	//SEGUIR
			}
		else//SINO
			{
			ganas=false;//SALIR
			}
			
		}while(ganas==true && protagonista.getdinero()>0);//MIENTRAS QUIERA SEGUIR	
		if(protagonista.getdinero()==0)
			System.out.println("Sin dinero, no hay juego!");
		}	
	}
		 
		
	/*
	 * Descansar
	 * Subprograma que realiza la accion de descansar y recuperar toda la vida
	 * 
	 * Entrada: un objeto personaje----> el protagonista
	 * Precondicion: el objeto debe estar cargado
	 * Salida: ninguna
	 * Postcondiccion: ninguna
	 * 
	 * cabecera: void descansar (personaje);
	 * */	
	static void descansar (personaje protagonista)
	{
		Random rnd =new Random ();
		Scanner teclado=new Scanner (System.in);
		int costo, resp,suerte,culo;
		costo=rnd.nextInt(100)*protagonista.getnivel();
				do{
				System.out.print("Bienvenido a la Taberna NocheSorpresa, Si deseas descansar, \nla cama cuesta "+costo+" monedas, \ndeseas dormir?\n1)DORMIR\t2)SALIR\nRESP");
				resp=teclado.nextInt();
				}while(resp!=1 && resp!=2);
				if(resp==1 && protagonista.getdinero()>=costo)
					{
					protagonista.setdinero(protagonista.getdinero()-costo);	
					costo=rnd.nextInt(10)*protagonista.getnivel();
					do{
					System.out.print("\nDesea una habitacion con llave? Costara "+costo+" monedas \n1)Con Llave \t2)Me da igual\nRESP:");	
					resp=teclado.nextInt();
					}while(resp!=1 && resp!=2);
					if(resp==1 && protagonista.getdinero()>=costo)
						{
							protagonista.setdinero(protagonista.getdinero()-costo);
							protagonista.setvida(protagonista.gettotalvida());
							System.out.print("Te sientes como nuevo!");
						}
					else
						{
							suerte=rnd.nextInt(protagonista.getagilidad());
							culo=rnd.nextInt(protagonista.getagilidad());
							protagonista.setvida(protagonista.gettotalvida());
							if(suerte<culo)
								{	
								System.out.println("...Por la noche...Sientes algo en tu culo...duro y humedo...\nCierras los ojos...deseando de que acabe pronto");	
								esperar();
								limpiapantalla();
								System.out.println("TE HAN VIOLADO!");
								esperar();
								if(protagonista.getdinero()>5 && protagonista.getvida()>10)
									{
										protagonista.setdinero(protagonista.getdinero()-5);
										protagonista.setvida(protagonista.getvida()-5);
										System.out.println("Pierdes dinero y vida");
									}
								}
								
						}
					}		
				else
					{
						if(costo>protagonista.getdinero())
							System.out.print("Sin dinero?...A la calle");
						else	
							System.out.println("Pues hala...duerme en la calle");
					}	
		}	
		
	/*
	 * FUNCION PARA ESPERAR 
	 * SIN APENAS INTERFAZ
	 * */	
	static void esperar ()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			// aquí tratamos la excepción como queramos, haciendo nada, sacando por pantalla el error, ...
			}
	}	 
		
	/*
	 * UTILIZAR POCION
	 * Subprograma que realiza la accion de utilizar una pocion
	 * 
	 * Entrada: un objeto personaje
	 * Precondiccion: debe estar cargado
	 * Salida: ninguna
	 * Postcondiccion: ninguna
	 * cabecera: nada utilizarpocion (personaje)
	 * */	
	static void utilizarpocion (personaje protagonista)
	{
		if((protagonista.getpocion()>0) && (protagonista.getvida()!=protagonista.gettotalvida()))
		{
			protagonista.setpocion(protagonista.getpocion()-1);
			if((protagonista.getvida()+10)>protagonista.gettotalvida())
				{
				protagonista.setvida(protagonista.gettotalvida());		
				System.out.println("Utilizaste pocion! Recuperas 10 puntos de vida\nAhora, tienes:"+protagonista.getvida()+" puntos de vida");
				}
			else
				{
				System.out.println("Utilizaste pocion! Recuperas 10 puntos de vida\nAhora, tienes:"+protagonista.getvida()+" puntos de vida");	
				protagonista.setvida(protagonista.getvida()+10);	
				}
		}	
		else
		{
			if(protagonista.getpocion()==0)
				System.out.println("No posees ninguna pocion...");
			else
				System.out.println("Tienes la vida al tope...");
			}
		esperar();	
		}
	
	/*
	 * limpiarpantalla
	 * Subprograma que "limpia pantalla" dibujando muchos saltos de linea
	 * 
	 * Entrada: nada
	 * precondiccion: ninguna
	 * Salida: nada
	 * Postcondiccion: ninguna 
	 * Interesante ¿eh?
	 * 
	 * cabecera: nada limpiarpantalla (nada)
	 * */
	
	static void limpiapantalla ()
	{
		int i;
		for(i=0;i<15;i++)
			{
			System.out.print("\n");	
			}
		}		
		/*calcularmejora
		 * Subprograma que calcula el precio del coste de la mejora
		 * 
		 * Entrada: 2 enteros----> el contados de mejora y la mejora en si
		 * Precondiccion: deben estar inicializados
		 * Salida: un entero-----> el costo
		 * Postcondiccion: ninguna
		 * 
		 * cabecera: entero calcularmejora (entero, entero)
		 * 
		 * */
		
	 static int calcularmejora (int a, int b) //contador de mejora, mejora
	 {
		 int total=0;
		 total=b*a*5;
		 return(total);
		 }	
	
	/*
	 * pintar
	 * Subprograma que imprime el titulo del juego
	 * 
	 * Entrada: nada
	 * precondiccion: ninguna
	 * Salida: nada
	 * Postcondiccion: ninguna 
	 * 
	 * cabecera: nada pintar (nada)
	 * */
	static void pintar ()
	{
		System.out.println("    __             _____             _   ");
		System.out.println(" __|  |___ _ _ ___|     |_ _ ___ ___| |_ ");
		System.out.println("|  |  | .'| | | .'|  |  | | | -_|_ -|  _|");
		System.out.println("|_____|__,|\\_/|__,|__  _|___|___|___|_|  ");
		System.out.println("                     |__|                ");                                                                                    
		}	
		
		/*
	 * elegirraza
	 * Subprograma que permite elegir la raza del protagonista
	 * 
	 * Entrada: nada
	 * precondiccion: ninguna
	 * Salida: un entero
	 * Postcondiccion: debe valer entre 1 y 3 
	 * 
	 * cabecera: entero elegirraza (nada)
	 * */
	public static int elegirraza ()
	{
		Scanner teclado=new Scanner (System.in);
		int raza=0,opcion=0;
		while(raza==0)//no haya elegido raza
			{
			do{	
			System.out.print("Que raza seras?\nElige entre 1 y 3 para conocer mas de ellas\n1)ELFO\t2)ENANO\t3)FRIKI\t4)CHUCKNORRIS\t5)AEROCERDO\nRESP:");
			opcion=teclado.nextInt();	
			}while(opcion<1 || opcion>5);
			switch(opcion)
				{
				case 1:
					System.out.println("Los elfos son conocidos por sus peazo de orejas, y por los rapidos que son,\nasi que un buen ataque, poca defensa y gran evasion");
					do{
					System.out.print("Que haces?\n1)Elegir Raza\n2)Cambiar raza\nRESP:");
					opcion=teclado.nextInt();
					}while(opcion<1 || opcion>2);
					if(opcion==1)
						raza=1;
					break;
				case 2:
					System.out.println("Los enanos tienen mu mala leche, ademas de buena cerveza por lo que\nun buen ataque, mucha defensa y poca evasion");
					do{
					System.out.print("Que haces?\n1)Elegir Raza\n2)Cambiar raza\nRESP:");
					opcion=teclado.nextInt();
					}while(opcion<1 || opcion>2);
					if(opcion==1)
						raza=2;
					break;	
				case 3:
					System.out.println("Los frikis son muy escurridizos, pero aun asi muy buena gente\nataque y defensa nivelados con una agilidad un pelin mayor");
					do{
					System.out.print("Que haces?\n1)Elegir Raza\n2)Cambiar raza\nRESP:");
					opcion=teclado.nextInt();
					}while(opcion<1 || opcion>2);
					if(opcion==1)
						raza=3;
					break;	
				case 4:
					System.out.println("Los ChuckNorris desayunan sangre de Jesus caliente, \nson muy duros en el ataque y resistentes, pero apenas defensivos y agiles");
					do{
					System.out.print("Que haces?\n1)Elegir Raza\n2)Cambiar raza\nRESP:");
					opcion=teclado.nextInt();
					}while(opcion<1 || opcion>2);
					if(opcion==1)
						raza=4;
					break;
				case 5:
					System.out.println("Los Aerocerdos poseen la increible habilidad de volar con\nalas de murcielago leproso, poseen un ataque y agilidad buena aunque poca defensa");
					do{
					System.out.print("Que haces?\n1)Elegir Raza\n2)Cambiar raza\nRESP:");
					opcion=teclado.nextInt();
					}while(opcion<1 || opcion>2);
					if(opcion==1)
						raza=5;
					break;		
				}
			}
		return(raza);	
		}

	public static void main (String args[]) {
		Scanner teclado=new Scanner(System.in);
		int opcion=0,ocasion=1,mejora,costo,puntos, contatq=1, contdef=1, contagi=1,aux1=0,raza;
		String nombre, aux;
		pintar();
		System.out.print("Como te llamas?:");
		nombre=teclado.nextLine();
		raza=elegirraza();
		personaje protagonista=new personaje(nombre,raza);
		do{
		limpiapantalla();
		pintar();
		protagonista.imprimirestado();
		opcion=menu(0);
		switch(opcion)
			{
			case 1:
					buscarenemigos(protagonista);
					protagonista.setexperiencia(aux1+protagonista.getexperiencia());
					esperar();
						while(protagonista.getexperiencia()>=10*protagonista.getnivel())
							{
							System.out.println("FELICIDADES!, SUBES DE NIVEL!");
							esperar();
							if(protagonista.getexperiencia()>=10*protagonista.getnivel())
								{
								protagonista.setexperiencia(protagonista.getexperiencia()-(protagonista.getnivel()*10));
								}
							protagonista.setnivel(protagonista.getnivel()+1);	
							protagonista.settotalvida(protagonista.gettotalvida()+5+(protagonista.getnivel()/10));
							protagonista.setvida(protagonista.gettotalvida());
							}	
							if(protagonista.getvida()<=0)
							{
							limpiapantalla();	
							System.out.println("\t\tGAME OVER\n\t"+protagonista.getnombre()+" murio...\n");	
							opcion=6;
							}
					ocasion=1;	
					System.out.print("Introduce cualquier tecla para seguir:");
					aux=teclado.next();
					break;
			case 2:
				if(ocasion==1)
					{
					buscartesoro(protagonista);
					ocasion=0;
					}
				else
					System.out.println("Tranquilo, solo podemos buscar despues de pelear");	
					System.out.print("Introduce cualquier tecla para seguir:");
					aux=teclado.next();
					break;
			case 3:
					
					limpiapantalla();
					System.out.println("Raza:"+protagonista.getraza());
					protagonista.imprimirestado();
					System.out.println("\tATQ:"+protagonista.getataque()+"\tDEF:"+protagonista.getdefensa()+"\tAGI:"+protagonista.getagilidad()+"\tVIDA:"+protagonista.getvida()+"/"+protagonista.gettotalvida());
					System.out.println("\t\t\tDINERO: "+protagonista.getdinero());
					System.out.println("Experiencia: "+protagonista.getexperiencia()+"/"+protagonista.getnivel()*10+"\tNumero de pociones:"+protagonista.getpocion());
					System.out.print("Introduce cualquier tecla para seguir:");
					aux=teclado.next();
					break;	
			case 4:
					utilizarpocion(protagonista);
					break;
			case 5:
							limpiapantalla();
							opcion=menu(1);
							taberna(opcion,protagonista);
								
								System.out.print("Introduce cualquier tecla para seguir:");
								aux=teclado.next();		
				}
		}while(opcion!=6);	
		
	}
}

