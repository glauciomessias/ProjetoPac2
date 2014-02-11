package novo;

import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainLoop {

	public static void main(String[] args) throws InterruptedException {
		JogoCanvas canvas = new JogoCanvas();
		canvas.setVisible(true);
		final Jogo jogo = new Jogo();
		
		canvas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == VK_LEFT) jogo.esquerda(); 
				if(e.getKeyCode() == VK_RIGHT) jogo.direita();
			}
		});
		
		while(true) {
			jogo.esperar();
			frame(jogo, canvas);
			Thread.sleep(200);
		}

	}

	private static void frame(Jogo jogo, JogoCanvas canvas) throws InterruptedException {
		System.out.println("\n\n\n\n\n");
		String tela = jogo.getTela();
		System.out.println(tela);
		canvas.atualizaTela(tela.split("\n"));
		System.out.println("\n\n\n\n\n");
	}

}