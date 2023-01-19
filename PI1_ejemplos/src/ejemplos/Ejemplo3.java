package ejemplos;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.IntPair;
import us.lsi.common.Map2;

public class Ejemplo3 {
	
	// RECURSIVO SIN MEMORIA
	public static Integer RSM(Integer a, Integer b) {
		Integer res;
		if(a<2 || b<2) {
			res = a*a + b;
		} else {
			res = RSM(a/2, b-1) + RSM(a/3, b-2);
		}
		return res;
	}
		
	
	// RECURSIVO CON MEMORIA
	public static Integer RCM(Integer a, Integer b) {
		Map<IntPair, Integer> mp = Map2.empty();
		return RCM(mp, a, b);
	}

	private static Integer RCM(Map<IntPair, Integer> mp, Integer a, Integer b) {
		Integer res = mp.get(IntPair.of(a, b));
		if(res == null) {
			if(a<2 || b<2) {
				res = a*a + b;
			} else {
				res = RCM(mp, a/2, b-1) + RCM(mp, a/3, b-2);
			}
			mp.put(IntPair.of(a, b), res);
		}
		return res;
	}
	
	
	// ITERATIVO
	public static Integer iterativo(Integer a, Integer b) {
		Map<IntPair, Integer> mp = new HashMap<>();
		Integer res;
		for(int i=0; i<=a; i++) {
			for(int j=0; j<=b; j++) {
				if(i<2 || j<2) {
					res = i*i + j;
				} else {
					res = mp.get(IntPair.of(i/2, j-1)) + mp.get(IntPair.of(i/3, j-2));
				}
				mp.put(IntPair.of(i, j), res);
			}
		}
		res = mp.get(IntPair.of(a, b));
		return 	res;	
	}
		

}
