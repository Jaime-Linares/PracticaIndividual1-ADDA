package ejemplos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public class Ejemplo1 {

	// FUNCIONAL
	public static Map<Punto2D.Cuadrante, Double> funcional(List<Punto2D> ls) {
		/* 
		  Se hace una operacion para los puntos de un mismo cuadrante.
		  La operación es sumar las componentes X. 
		  El reducing(elemento neutro, lo que quieres coger, la operación)
		 */
		return ls.stream()
				.collect(Collectors.groupingBy(Punto2D::getCuadrante,
				Collectors.reducing(0., x -> x.x(), (a, b) -> a + b)));
	}
	/*
	 Secuencia: 
	 	- valor inicial: ls[0]
	 	- Predicado: ls[i] -> i<ls.size
	 	- Funcion siguiente: ls[i] -> ls[i+1]
	 Acumulador:
	 	- valor incial: {}
	 	- función acumulacion: (b,e) -> b.containsKey(e.cuadrante)?
	 									b.put(e.cuadrante , b.get(cuadrante) + e.x):
	 									b.put(e.cuadrante, e.x)
	 */
	
	// ITERATIVO
	public static Map<Punto2D.Cuadrante, Double> iterativo(List<Punto2D> ls) {
		Map<Punto2D.Cuadrante, Double> res = new HashMap<>();
		Integer i = 0;
		while(i < ls.size()) {
			Punto2D p = ls.get(i);
			Cuadrante c = p.getCuadrante();
			if(res.containsKey(c)) {
				res.put(c, res.get(c) + p.x());
			} else {
				res.put(c, p.x());
			}
			i++;
		}
		return res;
	}
	
	// RECURSIVO FINAL
	public static Map<Punto2D.Cuadrante, Double> recursivo(List<Punto2D> ls) {
		Map<Punto2D.Cuadrante, Double> res = new HashMap<>();
		Integer i = 0;
		return recursivo(i, res, ls);
	}
	
	private static Map<Cuadrante, Double> recursivo(Integer i, Map<Cuadrante, Double> b, List<Punto2D> ls) {
		if(i<ls.size()) {
			Punto2D p = ls.get(i);
			Cuadrante c = p.getCuadrante();
			if(b.containsKey(c)) {
				b.put(c, b.get(c)+p.x());
			} else {
				b.put(c, p.x());
			}
			recursivo(i+1, b, ls);
		}
		return b;
	}
	

}
