
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args)   {
        Scanner teclado = new Scanner(System.in);
        List<Moneda> listaMonedas = new ArrayList<>();
        ConsultaMoneda consulta = new ConsultaMoneda();
        ConvertirMoneda convertir = new ConvertirMoneda();
        PintarMenu pintarmenu = new PintarMenu();
        Formulario formulario1=new Formulario();
        formulario1.setBounds(400,400,600,300);
        formulario1.setVisible(true);
        formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        double valorfinal;
        String monedaInicial = "";
        String monedaFinal = "";

/*
        while (true) {

            pintarmenu.menu();
            var opcion = teclado.nextLine();

            if(opcion.equalsIgnoreCase("salir") || opcion.equals("7")){
                break;
            }
            switch (opcion){
                case "1":
                    monedaInicial = "MXN";
                    monedaFinal = "USD";
                    break;
                case "2":
                    monedaInicial = "USD";
                    monedaFinal = "MXN";
                    break;
                case "3": //REAL BRASILEÑO BRL
                    monedaInicial = "BRL";
                    monedaFinal = "USD";
                    break;
                case "4":  //REAL BRASILEÑO BRL
                    monedaInicial = "USD";
                    monedaFinal = "BRL";
                    break;
                case "5": //PESO CHILENO CLP
                    monedaInicial = "CLP";
                    monedaFinal = "USD";
                    break;
                case "6":  //PESO CHILENO CLP
                    monedaInicial = "USD";
                    monedaFinal = "CLP";
                    break;
                default:
                    System.out.println("Valor invalido");
                    break;
            }

            System.out.println("Escriba el valor a convertir");
            try {
                double valorAConvertir = Double.parseDouble(teclado.nextLine());
                Moneda moneda = consulta.buscaMoneda(valorAConvertir,monedaInicial,monedaFinal);
                valorfinal = convertir.convierte(valorAConvertir, moneda.conversion_rate());
                System.out.println("El valor "+String.format("%.2f",valorAConvertir)+ "["+ monedaInicial+"]"
                        +" corresponde al valor final de -->: " + String.format("%.2f",valorfinal)
                        +"["+monedaFinal+"]");
                //System.out.println(moneda);

                listaMonedas.add(moneda);

            } catch (RuntimeException e) {
                System.out.println("Valor invalido: ");
            }
        }*/
        System.out.println(listaMonedas);


    }
}


