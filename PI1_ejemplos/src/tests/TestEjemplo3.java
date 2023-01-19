package tests;

import java.util.List;
import java.util.function.Function;

import ejemplos.Ejemplo3;
import us.lsi.common.Files2;
import us.lsi.common.IntPair;

public class TestEjemplo3 {

	public static void main(String[] args) {
		// Lectura de fichero
		String fichero = "ficheros/Ejemplo3DatosEntrada.txt";
		
		Function<String, IntPair> parse = e -> {
			String[] ee = e.split(",");
			return IntPair.of(Integer.valueOf(ee[0].trim()), 
					Integer.valueOf(ee[1].trim()));
		};
		
		List<IntPair> datos = Files2.streamFromFile(fichero)
				.map(parse)
				.toList();
		
		
		// TEST
		System.out.println("* TEST EJEMPLO 3: *");
		Integer i = 0;
		while(i < datos.size()) {
			IntPair par = datos.get(i);
			System.out.println("\n- Datos de entrada: " + par);
			Integer a = par.first();
			Integer b = par.second();
			System.out.println("1) Resursivo Sin Memoria: " + Ejemplo3.RSM(a, b));
			System.out.println("2) Recursivo Con Memoria: " + Ejemplo3.RCM(a, b));
			System.out.println("3) Iterativo: " + Ejemplo3.iterativo(a, b));
			i++;
		}
	}

}
