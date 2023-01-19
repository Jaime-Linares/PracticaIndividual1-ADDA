package ejercicios;

public record EnteroCadena(Integer a, String s) {

	public static EnteroCadena of(Integer a, String s) {
		return new EnteroCadena(a, s);
	}
	
}
