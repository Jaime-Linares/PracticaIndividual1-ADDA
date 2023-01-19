package ejercicios;

import java.util.stream.Stream;

public class Ejercicio2 {
	
	// RECURSIVA NO FINAL
	public static Integer fRecursivoNoFinal(Integer a, Integer b, String s) {
		Integer res;
		if(s.length() == 0) {
			res = a*a + b*b;
		} else if(a<2 || b<2) {
			res = s.length() + a + b;
		} else if(a%s.length() < b%s.length()) {
			res = a+b + fRecursivoNoFinal(a-1, b/2, s.substring(a%s.length(), b%s.length()));
		} else {
			res = a*b + fRecursivoNoFinal(a/2, b-1, s.substring(b%s.length(), a%s.length()));
		}
		return res;
	}
		
	
	// RECURSIVA FINAL
	public static Integer fRecursivoFinal(Integer a, Integer b, String s) {
		Integer res = 0;
		return fRecursivoFinal(res, a, b, s);
	}
		
	private static Integer fRecursivoFinal(Integer res, Integer a, Integer b, String s) {
		if(s.length() == 0) {
			res += a*a + b*b;
		} else if(a<2 || b<2) {
			res += s.length() + a + b;
		} else if(a%s.length() < b%s.length()) {
			res = fRecursivoFinal(res + a+b, a-1, b/2, s.substring(a%s.length(), b%s.length()));
		} else {
			res = fRecursivoFinal(res + a*b, a/2, b-1, s.substring(b%s.length(), a%s.length()));
		}
		return res;
	}


	// ITERATIVA
	public static Integer fIterativo(Integer a, Integer b, String s) {
		Integer res = 0;
		while(!((s.length() == 0) || (a<2 || b<2))) {
			if(a%s.length() < b%s.length()) {
				res += a+b;
				s = s.substring(a%s.length(), b%s.length());
				a = a-1;
				b = b/2;
			} else {
				res += a*b;
				s = s.substring(b%s.length(), a%s.length());
				a = a/2;
				b = b-1;
			}
		}
		if(s.length() == 0) {
			res += a*a + b*b;
		} else if(a<2 || b<2) {
			res += s.length() + a+b;
		}
		return res;
	}
	
	
	// FUNCIONAL
	public static Integer fFuncional(Integer a, Integer b, String s) {
		Integer res = 0;
		TuplaEj2 resTupla = Stream.iterate(TuplaEj2.semilla(a, b, s), x -> x.next())
				.filter(x -> x.esCasoBase())
				.findFirst()
				.get();
		if(resTupla.s().length() == 0) {
			res = resTupla.ac() + resTupla.a()*resTupla.a() + resTupla.b()*resTupla.b();
		} else if(resTupla.a()<2 || resTupla.b()<2) {
			res = resTupla.ac() + resTupla.a()+resTupla.b() + resTupla.s().length();
		}
		return res;
	}	
	

}
