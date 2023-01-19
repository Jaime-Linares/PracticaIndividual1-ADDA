package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import us.lsi.common.Files2;
import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public class Ejercicio3 {
	
	// Función para pasar de String a Punto2D
	public static Punto2D parsePunto2D (String s) {
		String[] ss = s.split(",");
		return Punto2D.of(Double.valueOf(ss[0].trim()), Double.valueOf(ss[1].trim()));
	}
	
	
	// ITERATIVO
	public static List<Punto2D> fIterativo(String rutaFicheroA, String rutaFicheroB) {
		List<Punto2D> ac = new ArrayList<>();
		Iterator<String> it1 = Files2.streamFromFile(rutaFicheroA).iterator();
		Iterator<String> it2 = Files2.streamFromFile(rutaFicheroB).iterator();
		Punto2D p1 = parsePunto2D(it1.next());
		Punto2D p2 = parsePunto2D(it2.next());
		while(p1!=null || p2!=null) {
			if(p2==null || (p1!=null && p1.compareTo(p2)<0)) {
				if(p1.getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE) ||
						p1.getCuadrante().equals(Cuadrante.TERCER_CUADRANTE)) {
					ac.add(p1);
				}
				p1 = it1.hasNext()? parsePunto2D(it1.next()):null;
			} else if(p1==null || (p2!=null && p2.compareTo(p1)<0)) {
				if(p2.getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE) ||
						p2.getCuadrante().equals(Cuadrante.TERCER_CUADRANTE)) {
					ac.add(p2);
				}
				p2 = it2.hasNext()? parsePunto2D(it2.next()):null;
			}
		}
		return ac;
	}
	
	
	// RECURSIVO
	public static List<Punto2D> fRecursivo(String rutaFicheroA, String rutaFicheroB) {
		List<Punto2D> ac = new ArrayList<>();
		Iterator<String> it1 = Files2.streamFromFile(rutaFicheroA).iterator();
		Iterator<String> it2 = Files2.streamFromFile(rutaFicheroB).iterator();
		Punto2D p1 = parsePunto2D(it1.next());
		Punto2D p2 = parsePunto2D(it2.next());
		return fRecursivo(ac, it1, it2, p1, p2);
	}
	
	private static List<Punto2D> fRecursivo(List<Punto2D> ac, Iterator<String> it1, 
			Iterator<String> it2, Punto2D p1, Punto2D p2) {
		if(p1!=null || p2!=null) {
			if(p2==null || (p1!=null && p1.compareTo(p2)<0)) {
				if(p1.getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE) ||
						p1.getCuadrante().equals(Cuadrante.TERCER_CUADRANTE)) {
					ac.add(p1);
				}
				p1 = it1.hasNext()? parsePunto2D(it1.next()):null;
				fRecursivo(ac, it1, it2, p1, p2);
			} else if(p1==null || (p2!=null && p2.compareTo(p1)<0)) {
				if(p2.getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE) ||
						p2.getCuadrante().equals(Cuadrante.TERCER_CUADRANTE)) {
					ac.add(p2);
				}
				p2 = it2.hasNext()? parsePunto2D(it2.next()):null;
				fRecursivo(ac, it1, it2, p1, p2);
			}
		}
		return ac;
	}


	// FUNCIONAL
	public static List<Punto2D> fFuncional(String rutaFicheroA, String rutaFicheroB) {
		TuplaEj3 res = Stream.iterate(TuplaEj3.semilla(rutaFicheroA, rutaFicheroB), x -> x.next())
				.filter(x -> x.esCasoBase())
				.findFirst()
				.get();
		return res.ls();
	}
		

}
