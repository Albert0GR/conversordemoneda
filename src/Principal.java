import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        ConvertirMoneda convertir = new ConvertirMoneda();
        System.out.println("Escriba el valor a convertir");
        try{
            double valorAConvertir = Double.valueOf(teclado.nextLine());
            Moneda moneda = consulta.buscaMoneda(valorAConvertir);
            double valorfinal = convertir.convierte(valorAConvertir, moneda.conversion_rate());
            System.out.println("el valor convertido es:" + valorfinal);
            System.out.println(moneda);


        }catch (RuntimeException e){
            System.out.println("Valor invalido: " + e.getMessage());
        }
    }
}


