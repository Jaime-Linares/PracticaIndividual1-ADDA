package tests;

import java.util.List;
import java.util.function.Function;

import ejercicios.Ejercicio1;
import us.lsi.common.Files2;

public class TestEjercicio1 {

	public static void main(String[] args) {
		
		// LECTURA DE FICHERO
		String rutaFichero = "ficheros/PI1Ej1DatosEntrada.txt";
		
		Function<String, TuplaTestEj1> parseTuplaEj1 = s -> {
			String[] ss = s.split(",");
			return TuplaTestEj1.of(Integer.valueOf(ss[0].trim()), ss[1].trim(),
					Integer.valueOf(ss[2].trim()), ss[3].trim(), 
					Integer.valueOf(ss[4].trim()));
		};
		
		List<TuplaTestEj1> tuplas = Files2.streamFromFile(rutaFichero)
				.map(parseTuplaEj1)
				.toList();
		
		
		// TEST
		System.out.println("* TEST EJERCICIO 1 *");
		Integer i = 0;
		while(i<tuplas.size()) {
			System.out.println("-----------------------");
			System.out.println(String.format("Test %d (funcional): %s", i+1, Ejercicio1.fFuncional(tuplas.get(i).a(), tuplas.get(i).b(),
					tuplas.get(i).c(), tuplas.get(i).d(), tuplas.get(i).e())));
			System.out.println(String.format("Test %d (iterativa): %s", i+1, Ejercicio1.fIterativo(tuplas.get(i).a(), tuplas.get(i).b(),
					tuplas.get(i).c(), tuplas.get(i).d(), tuplas.get(i).e())));
			System.out.println(String.format("Test %d (recursiva final): %s", i+1, Ejercicio1.fRecursivoFinal(tuplas.get(i).a(), 
					tuplas.get(i).b(), tuplas.get(i).c(), tuplas.get(i).d(), tuplas.get(i).e())));
			System.out.println("-----------------------");
			i++;
		}
		
	}
	
}
