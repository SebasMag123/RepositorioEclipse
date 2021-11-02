package ejercicios;

public class HiloRunnable implements Runnable{
	public static boolean finalizado;
	public static int progreso=0;
	public String nombreHilo;
	
	public HiloRunnable (String nombre)
	{
		this.nombreHilo= nombre;
	}
	@Override
	public void run()
	{
		finalizado =false;
		for (int i=1; i<=100;i++)
		{
			progreso=i;
			try {
				Thread.sleep(100);	
			}
			catch (InterruptedException e)
			{
				
			}
			
		}
		finalizado=true;
	}
}
