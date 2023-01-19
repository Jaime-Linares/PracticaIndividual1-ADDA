package tests;

import java.util.List;
import java.util.function.Function;

import ejemplos.Ejemplo2;
import us.lsi.common.Files2;
import us.lsi.common.IntPair;

public class TestEjemplo2 {

	public static void main(String[] args) {
		// Lectura de fichero
		String fichero = "ficheros/Ejemplo2DatosEntrada.txt";
		
		Function<String, IntPair> parseIntPair = s -> {
			String[] s2 = s.split(",");
			return IntPair.of(Integer.valueOf(s2[0].trim()), Integer.parseInt(s2[1].trim()));
		};
		
		List<IntPair> pares = Files2.streamFromFile(fichero)
				.map(parseIntPair)
				.toList();
		
		//
		System.out.println("* TEST EJEMPLO2 *");
		Integer i = 0;
		while(i<pares.size()) {
			IntPair par = pares.get(i);
			System.out.println("\n- Dato de entrada: " + par);
			Integer a = par.first();
			Integer b = par.second();
			System.out.println("1) Resultado version RNF: " + Ejemplo2.RNF(a, b));
			System.out.println("2) Resultado version RF: " + Ejemplo2.RF(a, b));
			System.out.println("3) Resultado version Iterativo : " + Ejemplo2.iterativo(a, b));
			System.out.println("4) Resultado version Funcional: " + Ejemplo2.funcional(a, b));
			i++;
		}
	}

}
