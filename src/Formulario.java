import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Formulario extends JFrame implements ActionListener{
    private final JLabel label4;
    JComboBox<String> combo1,combo2;
    private final JButton boton1;
    private JTextField JTextField1;
   // private JScrollPane JList1;
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    DefaultListModel<String> l1 = new DefaultListModel<>();
    String currencyCode[] = { "MXN", "USD", "BRL", "CLP", "EUR","ARS","BOB","COP","CAD","CNY" };
    String currencyName[]={
            "MXN-Peso Mexicano",
            "USD-Dolar Estadounidense",
            "BRL-Real Brasileño",
            "CLP-Peso Chileno",
            "EUR-Euro",
            "ARS-Peso Argentino",
            "BOB-Peso Boliviano",
            "COP-Peso Colombiano",
            "CAD-Dolar Canadiense",
            "CNY-Yuan Chino",
            "JPY-Yen Japones",
            "PEN-Sol Peruano",
            "UYU-Peso Uruguayo"
    };
    ConsultaMoneda consulta = new ConsultaMoneda();
    ConvertirMoneda convertir = new ConvertirMoneda();
    List<Moneda> listaMonedas = new ArrayList<>();

    double valorfinal;
    String monedaInicial = "";
    String monedaFinal = "";
    Moneda moneda;
    public Formulario(){
        setLayout(null);
        JLabel label1 = new JLabel("Moneda Inicial:");
        label1.setBounds(10,10,100,30);
        add(label1);
        combo1=new JComboBox<String>();
        combo1.setBounds(120,10,160,30);
        for (String s : currencyName) {
            combo1.addItem(String.valueOf(s));
        }
        add(combo1);

        JLabel label2 = new JLabel("Moneda Final:");
        label2.setBounds(290,10,100,30);
        add(label2);
        combo2=new JComboBox<String>();
        combo2.setBounds(390,10,160,30);

        for (String s : currencyName) {
            combo2.addItem(String.valueOf(s));
        }
        add(combo2);
        boton1=new JButton("Calcular");
        boton1.setBounds(220,70,100,30);
        add(boton1);
        boton1.addActionListener(this);

        JLabel label3 = new JLabel("Ingresa valor: ");
        label3.setBounds(10,70,100,30);
        add(label3);
        JTextField1=new JTextField();
        JTextField1.setBounds(120,70,80,30);
        add(JTextField1);

        label4=new JLabel("Resultado: ");
        label4.setBounds(10,100,730,30);
        add(label4);
        JList<String> list = new JList<>(l1);
        //JList1 = new JScrollPane((Component) listaMonedas);
        list.setBounds(10,130,730,300);
        add(list);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {

            String[] monedaInicialLong=((String)combo1.getSelectedItem()).split("-");
            monedaInicial=monedaInicialLong[0];
            String[] monedaFinalLong=((String)combo2.getSelectedItem()).split("-");
            monedaFinal =monedaFinalLong[0];


            double valorAConvertir=Double.valueOf(JTextField1.getText());
            moneda = consulta.buscaMoneda(valorAConvertir,monedaInicial,monedaFinal);
            valorfinal = convertir.convierte(valorAConvertir, moneda.conversion_rate());
            LocalDateTime now = LocalDateTime.now();
            String date1 =dtf.format(now);
            String val1="["+date1+"]"+" El valor "+String.format("%.2f",valorAConvertir)+ "["+ monedaInicialLong[0]+
                    "-"+monedaInicialLong[1]+"]"
                    +" corresponde al valor final de --> : " + String.format("%.4f",valorfinal)
                    +"["+monedaFinalLong[0]+"-"+monedaFinalLong[1]+"]";
            label4.setText(val1);
            listaMonedas.add(moneda);
            l1.add(0,val1);


        }
        }
    }

