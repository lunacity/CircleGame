//Entity Class

package circlegame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Main extends Applet implements Runnable, KeyListener {

	@Override
	public void init() {
		setSize(800,600);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle("CircleGame Alpha 1.0");
	}

	@Override
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {

	}

	@Override
	public void destroy() {

	}

	public static void main(String[] args) {

	}

	@Override
	public void run() {
		while (true) {
			//update();
	        repaint();
	        try {
	            Thread.sleep(17);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed " +e.getKeyCode());
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			System.out.println("Move up");
			break;
		case KeyEvent.VK_S:
			System.out.println("Move down");
			break;
		case KeyEvent.VK_A:
			System.out.println("Move left");
			break;
		case KeyEvent.VK_D:
			System.out.println("Move right");
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Attack!");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Released " + e.getKeyCode());
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			System.out.println("Stop move up");
			break;
		case KeyEvent.VK_S:
			System.out.println("Stop move down");
			break;
		case KeyEvent.VK_A:
			System.out.println("Stop move left");
			break;
		case KeyEvent.VK_D:
			System.out.println("Stop move right");
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Stop Attack!");
			break;
		}
	}
}