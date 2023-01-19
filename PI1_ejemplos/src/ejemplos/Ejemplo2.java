package ejemplos;

import java.util.stream.Stream;

public class Ejemplo2 {

	// RECURSIVO NO FINAL
	public static String RNF(Integer a, Integer b) {
		String res;
		if(a<5 || b<5) {
			res = String.format("(%d)", a*b);
		} else {
			res = String.format("%d", a+b) + RNF(a/2, b-2);   // lo concatenamos en este orden para que quede a la drch
		}
		return res;
	}
	
	
	// RECURSIVO FINAL
	public static String RF(Integer a, Integer b) {
		String ba = "";
		return RF(ba, a, b);
	}
	
	private static String RF(String ba, Integer a, Integer b) {
		String res;
		if(a<5 || b<5) {
			res = ba+String.format("(%d)", a*b);
		} else {
			res = RF(ba+String.format("%d", a+b), a/2, b-2);     // lo concatenamos en este orden para que quede a la drch
		}
		return res;
	}
	
	
	// ITERATIVO
	public static String iterativo(Integer a, Integer b) {
		String ba = "";
		while(!(a<5 || b<5)) {
			ba = ba + String.format("%d", a+b);
			a = a/2;
			b = b-2;
		}
		ba = ba + String.format("(%d)", a*b);
		return ba;
	}
	
	/*
	 Secuencia : IntPair(a, b)
	 	-valor inicial: (a, b)
	 	-predicado: e-> !(e.a<5 || e.b<5)
	 	-F siguiente: e -> (e.a/2, e.b-2)
	 	
	 Acumulador: B:String, E:IntPair
	 	-valor inicial: ""
	 	-F acumulador: (ba,e)->ba+(e.a+e.b)
	 	-F retorno: (ba,e) -> ba+ "(" + (e.a*e.b) + ")"
	 */
	
	
	// FUNCIONAL
	private static record TuplaEjemplo2(String ba, Integer a, Integer b) {
		
		public static TuplaEjemplo2 of(String ba, Integer a, Integer b) {
			return new TuplaEjemplo2(ba, a, b);
		}
		
		public static TuplaEjemplo2 first(Integer a, Integer b) {
			return new TuplaEjemplo2("", a, b);
		}
		
		public TuplaEjemplo2 next() {
			return of(ba + String.format("%d", a+b), a/2, b-2);
		}
		
		public Boolean isBaseCase() {
			return a<5 || b<5;
		}
	}
	
	public static String funcional(Integer a, Integer b) {
		TuplaEjemplo2 elementoFinal =Stream.iterate(TuplaEjemplo2.first(a, b), e -> e.next())
				.dropWhile(e -> !e.isBaseCase())
				.findFirst()
				.get();
		// Otra forma: .filter(e -> e.isBaseCase()).findFirst().get();
		return elementoFinal.ba + String.format("(%d)", elementoFinal.a*elementoFinal.b);
	}
		
	
}
