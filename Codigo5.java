
/*
 * Determinador de numero afortunado.
 * Descripcion: solicita un numero entero al usuario y determina si es
 * "afortunado" segun la siguiente regla: un numero es afortunado si la cantidad
 * de sus digitos pertenecientes al conjunto {3,7,8,9} es mayor que la cantidad
 * de los demas digitos y si son iguales se considera neutral.
 *
 * Cambios realizados
 *
 * 1. se agrego el metodo main.
 * 2. se importo java.util.Scanner y se uso System.in
 * 3. se corrigio la cadena del mensaje de entrada (comillas mal cerradas).
 * 4. 4. se coniverte de string a long
 * 5. se reemplazo el uso de la variable String por un long.
 * 6. se movio la reduccion (numero /= 10) fuera del else para evitar bucles infinitos.
 * 7. se añadio validacion de entrada para evita errores si no es numero.
 * 8. se maneja el caso de negativos (valor absoluto)
 * 9. se añadieron mensajes diferenciando afortunadoy no afortunado.
 */
import java.util.Scanner; // 2. se importa Scanner y se usa System.in

public class Codigo5 {

	// 1. se agrego el motodo main para ejecutar el programa
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); // 2. se importa Scanner y se usa System.in
		System.out.print("Introduzca un número: "); // 3. Se corrigio la cadena del mensaje de entrada

		String entrada = s.nextLine().trim();
		// 7. se añadio validacion de entrada para evita errores si no es numero
		if (entrada.isEmpty() || !entrada.matches("-?\\d+")) {
			System.out.println("Entrada no válida. Debe ser un número entero.");
			s.close();
			return;
		}

		String c = entrada; // 4. se coniverte de string a long
		long numero = Long.parseLong(entrada); // 5. se usa long en vez de String para calculos
		numero = Math.abs(numero); // 8. se maneja el caso de negativos (valor absoluto)

		int afo = 0;
		int noAfo = 0;

		if (numero == 0) { // 8. se maneja el caso de 0
			noAfo = 1;
		}

		while (numero > 0) {
			int digito = (int) (numero % 10);
			if (digito == 3 || digito == 7 || digito == 8 || digito == 9) {
				afo++;
			} else {
				noAfo++;
			}
			numero /= 10;
		} // 6. se movio numero /= 10 fuera del else para evitar bucle infinito

		// 9. se añadem mensajes diferenciando afortunado, no afortunado y neutral
		if (afo > noAfo) {
			System.out.println("El " + c + " es un número afortunado.");
		} else if (afo == noAfo) {

		} else {
			System.out.println("El " + c + " no es un número afortunado.");
		}
		s.close();
	}
}
