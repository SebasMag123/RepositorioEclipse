package ejercicios;
import javax.swing.JProgressBar;
public class ProgresoHilo implements Runnable {
	private JProgressBar barraProgreso;
	
	public ProgresoHilo (JProgressBar barraVentana)
	{
		this.barraProgreso = barraVentana;
	}
@Override
public void run()
{
	while(!HiloRunnable.finalizado)
	{
		barraProgreso.setValue(HiloRunnable.progreso);
		barraProgreso.repaint();
		if(HiloRunnable.finalizado)
		{
			barraProgreso.setValue(100);
			break;
			
		}
	}
}

}
