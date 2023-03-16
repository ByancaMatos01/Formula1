package Controller;

import java.util.concurrent.Semaphore;

public class Formula1 extends Thread {
 static private int num_carro;
 static private int i;
 Semaphore semaforo;
 
 
 public  Formula1(int i, Semaphore semaforo, int num_carro) {
	
	 this.i=i;
	 this.semaforo=semaforo;
	 this.num_carro=num_carro;
	 
	 
}
 public void run() {
		Pista();
	}
	
	public void Pista() {
		for(int car=1;car<=2;car++) {		
			try {
				semaforo.acquire();
				Treino();
			} catch (Exception e) {

			} finally {
				semaforo.release();
			}
		}
	}
	
	public void Treino() {
		int tempoVolta=(int)((Math.random()*3000)+2000);
		int tempoTotal=0;
		
		System.out.println("Carro "+num_carro+" da Escuderia "+i+" entrou na pista");
		
		for(int volta=1; volta<=3; volta++) {
			System.out.println("Carro "+num_carro+" Escuderia "+i+": Volta "+volta);
			try {
				Thread.sleep(tempoVolta);
			} catch (Exception e) {
			
			}
			tempoTotal += tempoVolta;
			System.out.println("Tempo da volta: "+(double)tempoVolta/1000);
			
		}
		System.out.println("Tempo final :"+(double)tempoTotal/1000);
		System.out.println("Carro "+num_carro+" Escuderia "+i+" retornou");
		num_carro++;
	}
 
}
