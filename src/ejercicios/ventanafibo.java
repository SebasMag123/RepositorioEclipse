package ejercicios;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ventanafibo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumero1;
	private JTextField txtNumero2;
	private JTextField txtNumeroIteraciones;
	private JTextArea txtSerie;
	private JButton btnLimpiarLista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanafibo frame = new ventanafibo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventanafibo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(55, 218, 89, 23);
		contentPane.add(btnSalir);
		
		txtNumero1 = new JTextField();
		txtNumero1.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNumero1.setBounds(80, 46, 106, 20);
		contentPane.add(txtNumero1);
		txtNumero1.setColumns(10);
		
		txtNumero2 = new JTextField();
		txtNumero2.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNumero2.setColumns(10);
		txtNumero2.setBounds(80, 71, 106, 20);
		contentPane.add(txtNumero2);
		
		JLabel lblNumero1 = new JLabel("Numero 1");
		lblNumero1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNumero1.setBounds(10, 49, 89, 14);
		contentPane.add(lblNumero1);
		
		JLabel lblNumero2 = new JLabel("Numero 2");
		lblNumero2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNumero2.setEnabled(false);
		lblNumero2.setBounds(10, 74, 75, 14);
		contentPane.add(lblNumero2);
		
		JButton btnGenerarSerie = new JButton("Generar serie");
		btnGenerarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerarSerie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String varnumero1 = txtNumero1.getText();
				String varnumero2 = txtNumero2.getText();
				String varnumeroiteraciones = txtNumeroIteraciones.getText();
				
				int varnum1 = Integer.parseInt(varnumero1);
				int varnum2 = Integer.parseInt(varnumero2);
				int varnumiteraciones = Integer.parseInt(varnumeroiteraciones);
				int suma =0;
				int i =0;
				String num1=txtNumero1.getText();
				String num2=txtNumero2.getText();
				String cadenaSerie="";
				while (i<varnumiteraciones) {
		            suma=varnum1+varnum2;
		            varnum1=varnum2;
		            varnum2=suma;
		            i++;
		            cadenaSerie =cadenaSerie+"\n"+suma;
		            System.out.println(suma);
		        }
				txtNumero1.setText("");
				txtNumero2.setText("");
				txtNumeroIteraciones.setText("");
				txtSerie.setText(num1+"\n"+num2+cadenaSerie);
				
			}
		});
		btnGenerarSerie.setBounds(10, 143, 176, 23);
		contentPane.add(btnGenerarSerie);
		
		txtNumeroIteraciones = new JTextField();
		txtNumeroIteraciones.setBounds(129, 96, 56, 20);
		contentPane.add(txtNumeroIteraciones);
		txtNumeroIteraciones.setColumns(10);
		
		JLabel lblNumeroIteraciones = new JLabel("Numero iteraciones");
		lblNumeroIteraciones.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNumeroIteraciones.setEnabled(false);
		lblNumeroIteraciones.setBounds(10, 99, 134, 14);
		contentPane.add(lblNumeroIteraciones);
		
		txtSerie = new JTextArea();
		txtSerie.setBounds(225, 50, 134, 191);
		contentPane.add(txtSerie);
		
		btnLimpiarLista = new JButton("Limpiar lista");
		btnLimpiarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSerie.setText(null);
			}
		});
		btnLimpiarLista.setBounds(10, 184, 176, 23);
		contentPane.add(btnLimpiarLista);
	}
}
