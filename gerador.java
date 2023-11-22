import java.util.Arrays;
import java.util.Random;

public class GeradorNumerosLoteria {

    public static void main(String[] args) {
        int quantidadeNumeros = 6; // Quantidade de números a serem gerados
        int valorMinimo = 1; // Valor mínimo do intervalo
        int valorMaximo = 60; // Valor máximo do intervalo

        int[] numerosLoteria = gerarNumerosLoteria(quantidadeNumeros, valorMinimo, valorMaximo);

        System.out.println("Números da loteria: " + Arrays.toString(numerosLoteria));
    }

    public static int[] gerarNumerosLoteria(int quantidade, int minimo, int maximo) {
        if (quantidade > (maximo - minimo + 1)) {
            throw new IllegalArgumentException("Não é possível gerar mais números do que o intervalo permite.");
        }

        int[] numeros = new int[quantidade];
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            int numero;
            do {
                numero = random.nextInt(maximo - minimo + 1) + minimo;
            } while (contemNumero(numeros, numero));

            numeros[i] = numero;
        }

        return numeros;
    }

    public static boolean contemNumero(int[] array, int numero) {
        for (int i : array) {
            if (i == numero) {
                return true;
            }
        }
        return false;
    }
}