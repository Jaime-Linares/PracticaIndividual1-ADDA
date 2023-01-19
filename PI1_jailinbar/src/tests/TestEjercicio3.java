package tests;

import java.util.List;

import ejercicios.Ejercicio3;
import us.lsi.geometria.Punto2D;

public class TestEjercicio3 {
	
	// Función para mostrar los test por pantalla
	public static void fTest(List<Punto2D> ls) {
		Integer i = 0;
		while(i < ls.size()) {
			System.out.println(ls.get(i));
			i++;
		}
	}
	
	
	public static void main(String[] args) {
		// FICHEROS
		String rutaFichero1A = "ficheros/PI1Ej3DatosEntrada1A.txt";
		String rutaFichero1B = "ficheros/PI1Ej3DatosEntrada1B.txt";
		String rutaFichero2A = "ficheros/PI1Ej3DatosEntrada2A.txt";
		String rutaFichero2B = "ficheros/PI1Ej3DatosEntrada2B.txt";
		String rutaFichero3A = "ficheros/PI1Ej3DatosEntrada3A.txt";
		String rutaFichero3B = "ficheros/PI1Ej3DatosEntrada3B.txt";
		
		
		// TEST
		System.out.println("* TEST EJERCICIO 3 *");
		//
		System.out.println("-------------------------------");
		System.out.println("- Test 1 (iterativo): ");
		fTest(Ejercicio3.fIterativo(rutaFichero1A, rutaFichero1B));
		System.out.println("\n- Test 2 (iterativo): ");
		fTest(Ejercicio3.fIterativo(rutaFichero2A, rutaFichero2B));
		System.out.println("\n- Test 3 (iterativo): ");
		fTest(Ejercicio3.fIterativo(rutaFichero3A, rutaFichero3B));
		//
		System.out.println("-------------------------------");
		System.out.println("- Test 1 (recursivo): ");
		fTest(Ejercicio3.fRecursivo(rutaFichero1A, rutaFichero1B));
		System.out.println("\n- Test 2 (recursivo): ");
		fTest(Ejercicio3.fRecursivo(rutaFichero2A, rutaFichero2B));
		System.out.println("\n- Test 3 (recursivo): ");
		fTest(Ejercicio3.fRecursivo(rutaFichero3A, rutaFichero3B));
		
		System.out.println("-------------------------------");
		System.out.println("- Test 1 (funcional): ");
		fTest(Ejercicio3.fFuncional(rutaFichero1A, rutaFichero1B));
		System.out.println("\n- Test 2 (funcional): ");
		fTest(Ejercicio3.fFuncional(rutaFichero2A, rutaFichero2B));
		System.out.println("\n- Test 3 (funcional): ");
		fTest(Ejercicio3.fFuncional(rutaFichero3A, rutaFichero3B));
	}

}
