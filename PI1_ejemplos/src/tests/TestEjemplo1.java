package tests;

import java.util.List;
import java.util.function.Function;

import ejemplos.Ejemplo1;
import us.lsi.common.Files2;
import us.lsi.geometria.Punto2D;

public class TestEjemplo1 {
	
	public static void main(String[] args) {
		// Lectura de fichero
		String nombre = "ficheros/Ejemplo1DatosEntrada.txt";
		Function<String, Punto2D> parsea = s -> {
			String [] s2 = s.split(",");
			return Punto2D.of(Double.valueOf(s2[0].trim()), Double.valueOf(s2[1].trim()));
		};
		List<Punto2D> lista = Files2.streamFromFile(nombre)
				.map(parsea)
				.toList();
		//
		System.out.println("* TEST EJEMPLO1 *");
		System.out.println("\n- Datos de entrada: \n" + lista);
		System.out.println("\n1) Resultado notacion funcional: " + Ejemplo1.funcional(lista));
		System.out.println("\n2) Resultado notacion iterativa: " + Ejemplo1.iterativo(lista));
		System.out.println("\n3) Resultado notacion recursivo: " + Ejemplo1.recursivo(lista));
	}

}
