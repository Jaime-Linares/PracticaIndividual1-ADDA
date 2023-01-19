package tests;

import java.util.List;
import java.util.function.Function;

import ejercicios.Ejercicio4;
import us.lsi.common.Files2;
import us.lsi.common.IntTrio;

public class TestEjercicio4 {

	public static void main(String[] args) {
		
		// LECTURA FICHERO
		String rutaFichero = "ficheros/PI1Ej4DatosEntrada.txt";
		
		Function<String, IntTrio> parseTrioEnteros = s -> {
			String[] ss = s.split(",");
			return IntTrio.of(Integer.valueOf(ss[0].trim()),
					Integer.valueOf(ss[1].trim()),
					Integer.valueOf(ss[2].trim()));
		};

		List<IntTrio> triosEnteros = Files2.streamFromFile(rutaFichero)
				.map(parseTrioEnteros)
				.toList();
		
		
		// TEST
		System.out.println("* TEST EJERCICIO 4 *");
		Integer i = 0;
		while(i < triosEnteros.size()) {
			System.out.println("-----------------------");
			System.out.println(String.format("Test %d (Recursivo sin memoria): %s", i+1, Ejercicio4.fRSM(triosEnteros.get(i).first(),
					triosEnteros.get(i).second(), triosEnteros.get(i).third())));
			System.out.println(String.format("Test %d (Recursivo con memoria): %s", i+1, Ejercicio4.fRCM(triosEnteros.get(i).first(),
					triosEnteros.get(i).second(), triosEnteros.get(i).third())));
			System.out.println(String.format("Test %d (Iterativo): %s", i+1, Ejercicio4.fIterativo(triosEnteros.get(i).first(),
					triosEnteros.get(i).second(), triosEnteros.get(i).third())));
			System.out.println("-----------------------");
			i++;
		}
		
	}

}
