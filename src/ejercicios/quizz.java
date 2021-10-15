package ejercicios;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class quizz extends JFrame {
	int PreguntaActual=1;
	JLabel lblPregunta;
	JRadioButton radOpcion1;
	JRadioButton radOpcion2;
	JRadioButton radOpcion3;
	JButton btnAnterior;
	JButton btnSiguiente;
	JButton btnEvaluar;
	JButton btnSalir;
	ButtonGroup radGrupo;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quizz frame = new quizz();
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
	public quizz() {
		

		radGrupo = new ButtonGroup();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		 radOpcion1 = new JRadioButton("New radio button");
		radOpcion1.setBounds(80, 80, 297, 23);
		contentPane.add(radOpcion1);
		
	 radOpcion2 = new JRadioButton("New radio button");
		radOpcion2.setBounds(80, 122, 297, 23);
		contentPane.add(radOpcion2);
		
		 radOpcion3 = new JRadioButton("New radio button");
		radOpcion3.setBounds(80, 165, 297, 23);
		contentPane.add(radOpcion3);
		
		 btnAnterior = new JButton("Anterior");
		 btnAnterior.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		if(e.getSource()==btnAnterior) {
					PreguntaActual--;
				DesplegarPreguntasYRespuestas();
				if(PreguntaActual==1)
				{
					btnAnterior.setEnabled(false);
					btnSiguiente.setEnabled(true);
					
				}
				else
				{
					btnAnterior.setEnabled(true);
					btnSiguiente.setEnabled(true);
				}
				
		 		}
		 	}
		 	
		 });
			btnAnterior.setEnabled(false);
		btnAnterior.setBounds(10, 229, 89, 23);
		contentPane.add(btnAnterior);
		 btnSiguiente = new JButton("Siguiente");
		 btnSiguiente.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		if(e.getSource()==btnSiguiente) {
					PreguntaActual++;
				DesplegarPreguntasYRespuestas();
				if(PreguntaActual==5)
				{
					btnAnterior.setEnabled(true);
					btnSiguiente.setEnabled(false);
					
				}
				else
				{
					btnAnterior.setEnabled(true);
					btnSiguiente.setEnabled(true);
				}
				
		 	}
		 	}
		 });
		btnSiguiente.setBounds(109, 229, 89, 23);
		contentPane.add(btnSiguiente);
		btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DesplegarPreguntasYRespuestas();
				
				JOptionPane.showMessageDialog(null,Revisar());
			}
		});
		btnEvaluar.setBounds(208, 229, 89, 23);
		contentPane.add(btnEvaluar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(307, 229, 89, 23);
		contentPane.add(btnSalir);
		
		lblPregunta = new JLabel("New label");
		lblPregunta.setBounds(37, 59, 354, 14);
		contentPane.add(lblPregunta);
		radGrupo = new ButtonGroup();
		
		radGrupo.add(radOpcion1);
		radGrupo.add(radOpcion2);
		radGrupo.add(radOpcion3);
		DesplegarPreguntasYRespuestas();
	}

	void DesplegarPreguntasYRespuestas()
	{
		if(PreguntaActual==1)
		{
			lblPregunta.setText("Pregunta 1- ¿Cual fue el imperio mas grande la historia?");
			radOpcion1.setText("Imperio Mongol");
			radOpcion2.setText("Imperio Britanico"); //Correcta
			radOpcion3.setText("Imperio Romano");
		}
		if(PreguntaActual==2)
		{
			lblPregunta.setText("Pregunta 2- ¿Cuando empezo la Segunda Guerra Mundial");
			radOpcion1.setText("1945");
			radOpcion2.setText("1939"); //Correcta
			radOpcion3.setText("1928");
		}
		if(PreguntaActual==3)
		{
			lblPregunta.setText("Pregunta 3- ¿Que evento dio fin a la Edad Moderna?");
			radOpcion1.setText("Independencia de Estados Unidos");
			radOpcion2.setText("La muerte de Napoleon Bonaparte");
			radOpcion3.setText("La Revolucion Francesa"); //Correcta
		}
		if(PreguntaActual==4)
		{
			lblPregunta.setText("Pregunta 4- ¿Quien fue el personaje que inicio la Revolucion Mexicana?");
			radOpcion1.setText("Francisco Madero"); //Correcta
			radOpcion2.setText("Emiliano Zapata");
			radOpcion3.setText("Victoriano Huerta");
		}
		if(PreguntaActual==5)
		{
			lblPregunta.setText("Pregunta 5-¿Que suceso dio inicio a la edad media");
			radOpcion1.setText("Invencion de la escritura");
			radOpcion2.setText("Caida del Imperio Romano");//Correcta
			radOpcion3.setText("La guerra de Troya");
		}
		}
	boolean RevisarPreg1() {
		if(PreguntaActual==1)
			return(radOpcion2.isSelected());
		return false;
	}
	boolean RevisarPreg2() {
		if(PreguntaActual==2)
			return(radOpcion2.isSelected());
		return false;
	}
	boolean RevisarPreg3() {
		if(PreguntaActual==3)
				return(radOpcion3.isSelected());
		return false;
	}
	boolean RevisarPreg4() {
		if(PreguntaActual==4)
				return(radOpcion1.isSelected());
		return false;
	}
	boolean RevisarPreg5() {
		if(PreguntaActual==5)
			return(radOpcion2.isSelected());
		return false;
	}
	int Revisar()
	{
		DesplegarPreguntasYRespuestas();
		int Resultado=0;
		if(RevisarPreg1()==true)
			Resultado++;
		if(RevisarPreg2()==true)
			Resultado++;
		if(RevisarPreg3()==true)
			Resultado++;
		if(RevisarPreg4()==true)
			Resultado++;
		if(RevisarPreg5()==true)
			Resultado++;
		return Resultado;
	}
	}
	
	

