package ejercicios;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.IntTrio;

public class Ejercicio4 {
	
	// RECURSIVO SIN MEMORIA
	public static String fRSM(Integer a, Integer b, Integer c) {
		String res;
		if(a<2 && b<=2 || c<2) {
			res = "(" + a.toString() + "+" + b.toString() + "+" + c.toString() + ")";
		} else if (a<3 || b<3 && c<=3) {
			res = "(" + c.toString() + "-" + b.toString() + "-" + a.toString() + ")";
		} else if(b%a == 0 && (a%2 == 0 || b%3 == 0)) {
			res = "(" + fRSM(a-1, b/a, c-1) + "*" + fRSM(a-2, b/2, c/2) + ")";
		} else {
			res = "(" + fRSM(a/2, b-2, c/2) + "/" + fRSM(a/3, b-1, c/3) + ")";
		}
		return res;	
	}
		
	
	// RECURSIVO CON MEMORIA
	public static String fRCM(Integer a, Integer b, Integer c) {
		Map<IntTrio, String> mp = new HashMap<>();
		return fRCM(a, b, c, mp);
	}
		
	private static String fRCM(Integer a, Integer b, Integer c, Map<IntTrio, String> mp) {
		String res = mp.get(IntTrio.of(a, b, c));
		if (res == null) {
			if(a<2 && b<=2 || c<2) {
				res = "(" + a.toString() + "+" + b.toString() + "+" + c.toString() + ")";
			} else if (a<3 || b<3 && c<=3) {
				res = "(" + c.toString() + "-" + b.toString() + "-" + a.toString() + ")";
			} else if(b%a == 0 && (a%2 == 0 || b%3 == 0)) {
				res = "(" + fRCM(a-1, b/a, c-1, mp) + "*" + fRCM(a-2, b/2, c/2, mp) + ")";
			} else {
				res = "(" + fRCM(a/2, b-2, c/2, mp) + "/" + fRCM(a/3, b-1, c/3, mp) + ")";
			}
			mp.put(IntTrio.of(a, b, c), res);
		}
		return res;
	}


	// ITERATIVO
	public static String fIterativo(Integer a, Integer b, Integer c) {
		String res;
		Map<IntTrio, String> mp = new HashMap<>();
		for(int i=0; i<=a; i++) {
			for(int j=0; j<=b; j++) {
				for(int z=0; z<=c; z++) {
					if(i<2 && j<=2 || z<2) {
						res = "(" + Integer.valueOf(i).toString() + "+" + Integer.valueOf(j).toString() 
								+ "+" + Integer.valueOf(z).toString() + ")";
					} else if (i<3 || j<3 && z<=3) {
						res = "(" + Integer.valueOf(z).toString() + "-" + Integer.valueOf(j).toString() 
								+ "-" + Integer.valueOf(i).toString() + ")";
					} else if(j%i == 0 && (i%2 == 0 || j%3 == 0)) {
						res = "(" + mp.get(IntTrio.of(i-1, j/i, z-1)) + "*" + mp.get(IntTrio.of(i-2, j/2, z/2)) + ")";
					} else {
						res = "(" + mp.get(IntTrio.of(i/2, j-2, z/2)) + "/" + mp.get(IntTrio.of(i/3, j-1, z/3)) + ")";
					}
					mp.put(IntTrio.of(i, j, z), res);					
				}
			}
		}		
		return mp.get(IntTrio.of(a, b, c));
	}
		

}
