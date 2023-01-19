package ejercicios;

import java.util.Iterator;
import java.util.List;

import us.lsi.common.Files2;
import us.lsi.common.List2;
import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public record TuplaEj3(List<Punto2D> ls, Iterator<String> it1, Iterator<String> it2,
		Punto2D p1, Punto2D p2) {
	
	public static TuplaEj3 of(List<Punto2D> ls, Iterator<String> it1, Iterator<String> it2,
			Punto2D p1, Punto2D p2) {
		return new TuplaEj3(ls, it1, it2, p1, p2);
	}

	public static TuplaEj3 semilla(String rutaFicheroA, String rutaFocheroB) {
		Iterator<String> it1 = Files2.streamFromFile(rutaFicheroA).iterator();
		Iterator<String> it2 = Files2.streamFromFile(rutaFocheroB).iterator();
		Punto2D p1 = Ejercicio3.parsePunto2D(it1.next());
		Punto2D p2 = Ejercicio3.parsePunto2D(it2.next()); 
		return new TuplaEj3(List2.empty(), it1, it2, p1, p2);
	}
	
	public TuplaEj3 next() {
		Punto2D pt1 = p1;
		Punto2D pt2 = p2;
		if(p2==null || (p1!=null && p1.compareTo(p2)<0)) {
			if(p1.getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE) ||
					p1.getCuadrante().equals(Cuadrante.TERCER_CUADRANTE)) {
				ls.add(p1);
			}
			pt1 = it1.hasNext()? Ejercicio3.parsePunto2D(it1.next()):null;
		} else if(p1==null || (p2!=null && p2.compareTo(p1)<0)) {
			if(p2.getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE) ||
					p2.getCuadrante().equals(Cuadrante.TERCER_CUADRANTE)) {
				ls.add(p2);
			}
			pt2 = it2.hasNext()? Ejercicio3.parsePunto2D(it2.next()):null;
		}
		return of(ls, it1, it2, pt1, pt2);
	}
	
	public Boolean esCasoBase() {
		return p1==null && p2==null;
	}
	
}
