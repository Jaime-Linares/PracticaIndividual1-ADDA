package tests;

public record TuplaTestEj2(Integer a, Integer b, String s) {
	
	public static TuplaTestEj2 of(Integer a, Integer b, String s) {
		return new TuplaTestEj2(a, b, s);
	}

}
