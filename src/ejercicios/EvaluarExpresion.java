package ejercicios;

import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EvaluarExpresion extends JFrame {

	private JPanel contentPane;
	private JTextField txtExpresion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvaluarExpresion frame = new EvaluarExpresion();
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
	public EvaluarExpresion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Evaluar expresion");
		setBounds(100, 100, 450, 300);
		setSize(300,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblExpresion = new JLabel("Expresion");
		lblExpresion.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblExpresion.setBounds(99, 22, 142, 14);
		contentPane.add(lblExpresion);
		
		txtExpresion = new JTextField();
		txtExpresion.setBounds(96, 47, 96, 28);
		contentPane.add(txtExpresion);
		txtExpresion.setColumns(10);
		
		JButton btnEvaluarExpresion = new JButton("Evaluar expresion");
		btnEvaluarExpresion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stack<String> varPila = new Stack<String>();
				String varExpresion =txtExpresion.getText();
				char varCaracter;
				boolean varError=false;
				
				for (int x=0; x<varExpresion.length(); x++)
				{
					varCaracter=varExpresion.charAt(x);
					if (varCaracter=='(')
					{
						varPila.push("parentesisApertura");
					}
					if(varCaracter==')')
					{
						if(varPila.empty())
						{
							varError=true;
							break;
						}
						else
						{
							varPila.pop();
						}
							
					}
				}
				if(txtExpresion.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Inserte una expresion");
				}
				else if(varPila.empty()&&varError==false)
				{
					JOptionPane.showMessageDialog(null,"La expresion:"+varExpresion+""+"es correcta");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"La expresion:"+varExpresion+""+"es incorrecta");
				}
				
			}
		});
		btnEvaluarExpresion.setFont(new Font("Arial", Font.PLAIN, 11));
		btnEvaluarExpresion.setBounds(86, 86, 119, 52);
		contentPane.add(btnEvaluarExpresion);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		btnSalir.setBounds(99, 182, 89, 23);
		contentPane.add(btnSalir);
	}
}
