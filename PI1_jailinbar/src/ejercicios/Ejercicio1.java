package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio1 {

	// FUNCIONAL
	public static Map<Integer, List<String>> fFuncional(Integer varA, String varB, 
			Integer varC, String varD, Integer varE) {
			UnaryOperator<EnteroCadena> nx = elem -> {
			return EnteroCadena.of(elem.a()+2, elem.a()%3==0?
								elem.s()+elem.a().toString():
								elem.s().substring(elem.a()%elem.s().length()));
			};
			return Stream.iterate(EnteroCadena.of(varA,varB), elem -> elem.a() < varC, nx)
			.map(elem -> elem.s()+varD)
			.filter(nom -> nom.length() < varE)
			.collect(Collectors.groupingBy(String::length));
			}
	
	
	// ITERATIVA
	public static Map<Integer, List<String>> fIterativo(Integer varA, String varB, 
			Integer varC, String varD, Integer varE) {
		Map<Integer, List<String>> ac = new HashMap<>();
		EnteroCadena e = EnteroCadena.of(varA, varB);
		while(e.a() < varC) {
			String valor = e.s() + varD;       
			Integer clave = valor.length();    
			if(clave < varE) {
				if(ac.containsKey(clave)) {
					ac.get(clave).add(valor);
				} else {
					List<String> ls = new ArrayList<>();
					ls.add(valor);
					ac.put(clave, ls);
				}
			}
			e = EnteroCadena.of(e.a()+2, e.a()%3==0?       
							e.s()+e.a().toString():
							e.s().substring(e.a()%e.s().length()));
		}
		return ac;
	}
	
	
	// RECURSIVA FINAL
	public static Map<Integer, List<String>> fRecursivoFinal(Integer varA, String varB, 
			Integer varC, String varD, Integer varE) {
		Map<Integer, List<String>> ac = new HashMap<>();
		EnteroCadena e = EnteroCadena.of(varA, varB);
		return fRecursivoFinal(e, ac, varA, varB, varC, varD, varE);
	}

	private static Map<Integer, List<String>> fRecursivoFinal(EnteroCadena e, 
			Map<Integer, List<String>> ac, Integer varA, String varB, Integer varC, 
			String varD, Integer varE) {
		if(e.a() < varC) {
			String valor = e.s() + varD;       
			Integer clave = valor.length();    
			if(clave < varE) {
				if(ac.containsKey(clave)) {
					ac.get(clave).add(valor);
				} else {
					List<String> ls = new ArrayList<>();
					ls.add(valor);
					ac.put(clave, ls);
				}
			}
			fRecursivoFinal(EnteroCadena.of(e.a()+2, e.a()%3==0?
									e.s()+e.a().toString():
									e.s().substring(e.a()%e.s().length())),
			ac, varA, varB, varC, varD, varE);			
		}
		return ac;		
	}
		
	
}
