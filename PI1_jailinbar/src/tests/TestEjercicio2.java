package tests;

import java.util.List;
import java.util.function.Function;

import ejercicios.Ejercicio2;
import us.lsi.common.Files2;

public class TestEjercicio2 {

	public static void main(String[] args) {
		
		// LECTURA DE FICHERO
		String rutaFichero = "ficheros/PI1Ej2DatosEntrada.txt";
		
		Function<String, TuplaTestEj2> parseTuplaEj2 = s -> {
			String[] ss = s.split(",");
			return TuplaTestEj2.of(Integer.valueOf(ss[0].trim()),
					Integer.valueOf(ss[1].trim()), ss[2].trim());
		};
		
		List<TuplaTestEj2> datosFichero = Files2.streamFromFile(rutaFichero)
				.map(parseTuplaEj2)
				.toList();
		
		
		// TEST
		System.out.println("* TEST EJERCICIO 2 *");
		Integer i= 0;
		while(i < datosFichero.size()) {
			TuplaTestEj2 tupla = datosFichero.get(i);
			System.out.println("-----------------------");
			System.out.println(String.format("Test %d (recursivo no final): %s", i+1, Ejercicio2.fRecursivoNoFinal(
					tupla.a(), tupla.b(), tupla.s())));
			System.out.println(String.format("Test %d (recursivo final): %s", i+1, Ejercicio2.fRecursivoFinal(
					tupla.a(), tupla.b(), tupla.s())));
			System.out.println(String.format("Test %d (iterativo): %s", i+1, Ejercicio2.fIterativo(tupla.a(), 
					tupla.b(), tupla.s())));
			System.out.println(String.format("Test %d (funcional): %s", i+1, Ejercicio2.fFuncional(tupla.a(), 
					tupla.b(), tupla.s())));
			System.out.println("-----------------------");
			i++;
		}
	}

}
