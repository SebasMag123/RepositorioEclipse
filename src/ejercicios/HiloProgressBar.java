package ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HiloProgressBar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HiloProgressBar frame = new HiloProgressBar();
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
	public HiloProgressBar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(118, 46, 146, 9);
		contentPane.add(progressBar);
		progressBar.setStringPainted(true);
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HiloRunnable objHilo = new HiloRunnable("Hilo");
				Thread varHilo = new Thread(objHilo);
				
				ProgresoHilo objHiloProgreso = new ProgresoHilo(progressBar);
				Thread varHiloProgreso = new Thread(objHiloProgreso);
				
				varHilo.start();
				varHiloProgreso.start();
			}
		});
		btnIniciar.setBounds(58, 111, 89, 23);
		contentPane.add(btnIniciar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(226, 111, 89, 23);
		contentPane.add(btnSalir);
		
	}
}
