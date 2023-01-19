package tests;

public record TuplaTestEj1(Integer a, String b, Integer c, String d, Integer e) {

	public static TuplaTestEj1 of(Integer a, String b, Integer c, String d, Integer e) {
		return new TuplaTestEj1(a, b, c, d, e);
	}
		
}
