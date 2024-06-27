import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame implements ActionListener{
    private JLabel label1,label2,label3,label4;
    JComboBox<String> combo1,combo2;
    private JButton boton1;
    private JTextField JTextField1;
    String s1[] = { "MXN", "USD", "BRL", "CLP", "EUR" };
    ConsultaMoneda consulta = new ConsultaMoneda();
    ConvertirMoneda convertir = new ConvertirMoneda();
    double valorfinal;
    String monedaInicial = "";
    String monedaFinal = "";
    public Formulario(){
        setLayout(null);
        label1=new JLabel("Moneda Inicial:");
        label1.setBounds(10,10,100,30);
        add(label1);
        combo1=new JComboBox<String>();
        combo1.setBounds(120,10,70,30);
        for (String s : s1) {
            combo1.addItem(String.valueOf(s));
        }
        add(combo1);

        label2=new JLabel("Moneda Final:");
        label2.setBounds(200,10,100,30);
        add(label2);
        combo2=new JComboBox<String>();
        combo2.setBounds(300,10,70,30);

        for (String s : s1) {
            combo2.addItem(String.valueOf(s));
        }
        add(combo2);
        boton1=new JButton("Calcular");
        boton1.setBounds(10,130,100,30);
        add(boton1);
        boton1.addActionListener(this);

        label3=new JLabel("Ingresa valor: ");
        label3.setBounds(10,90,100,30);
        add(label3);
        JTextField1=new JTextField();
        JTextField1.setBounds(120,90,100,30);
        add(JTextField1);

        label4=new JLabel("res: ");
        label4.setBounds(10,160,600,30);
        add(label4);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
             monedaInicial=(String)combo1.getSelectedItem();
            monedaFinal=(String)combo2.getSelectedItem();

            double valorAConvertir=Double.valueOf(JTextField1.getText());
            Moneda moneda = consulta.buscaMoneda(valorAConvertir,monedaInicial,monedaFinal);
            valorfinal = convertir.convierte(valorAConvertir, moneda.conversion_rate());
            String val1="El valor "+String.format("%.2f",valorAConvertir)+ "["+ monedaInicial+"]"
                    +" corresponde al valor final de -->: " + String.format("%.2f",valorfinal)
                    +"["+monedaFinal+"]";
            label4.setText(val1);
        }
        }
    }

