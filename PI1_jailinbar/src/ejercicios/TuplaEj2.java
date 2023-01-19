package ejercicios;

public record TuplaEj2(Integer ac, Integer a, Integer b, String s) {
	
	public static TuplaEj2 of(Integer ac, Integer a, Integer b, String s) {
		return new TuplaEj2(ac, a, b, s);
	}
	
	public static TuplaEj2 semilla(Integer a, Integer b, String s) {
		return new TuplaEj2(0, a, b, s);
	}
	
	public TuplaEj2 next() {
		TuplaEj2 res;
		if(a%s.length() < b%s.length()) {
			res = of(ac + a+b, a-1, b/2, 
					s.substring(a%s.length(), b%s.length()));
		} else {
			res = of(ac + a*b, a/2, b-1, 
					s.substring(b%s.length(), a%s.length()));
		}
		return res;
	}
	
	public Boolean esCasoBase() {
		return s.length()==0 || (a<2 || b<2);
	}
	
}
