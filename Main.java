//Entity Class

package CircleGame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;


public class Main extends Applet implements Runnable, KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image, character;
	private Entity player;
	private Graphics second;
	private URL base;

	@Override
	public void init() {
		setSize(800,600);
		setBackground(Color.WHITE);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle("CircleGame Alpha 1.0");
        try {
			base = getDocumentBase();
		} catch (Exception e) {
			// TODO: handle exception
		}
        character = getImage(base, "data/circle.png");
        
	}

	@Override
	public void start() {
		
		player = new Entity();
		
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {

	}

	@Override
	public void destroy() {

	}


	@Override
	public void run() {
		while (true) {
			player.update();
	        repaint();
	        try {
	            Thread.sleep(17);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public void update(Graphics g) {
		if(image==null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}
		
		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(character, player.getCenterX(), player.getCenterY(), this);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed " +e.getKeyCode());
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			System.out.println("Move up");
			player.moveUp();
			break;
		case KeyEvent.VK_S:
			System.out.println("Move down");
			player.moveDown();
			break;
		case KeyEvent.VK_A:
			System.out.println("Move left");
			player.moveLeft();
			break;
		case KeyEvent.VK_D:
			System.out.println("Move right");
			player.moveRight();
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Attack!");
			player.attack();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Released " + e.getKeyCode());
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			System.out.println("Stop move up");
			player.stop();
			break;
		case KeyEvent.VK_S:
			System.out.println("Stop move down");
			player.stop();
			break;
		case KeyEvent.VK_A:
			System.out.println("Stop move left");
			player.stop();
			break;
		case KeyEvent.VK_D:
			System.out.println("Stop move right");
			player.stop();
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Stop Attack!");
			break;
		}
	}
}