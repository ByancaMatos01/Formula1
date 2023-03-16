package view;

import java.util.concurrent.Semaphore;

import Controller.Formula1;

public class Principal {
static Semaphore semaforo;
static int num_carro=1;
	public static void main(String[] args) {
		semaforo = new Semaphore(5);
		for(int i=1;i<=7;i++) {
			Thread correr = new Formula1(i, semaforo, num_carro);
			correr.start();
		}	

	}

}
