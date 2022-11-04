package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.ViewConvert;

public class ControllerKey implements KeyListener{

	ViewConvert view;
	
	
	public ControllerKey(ViewConvert view) {
		this.view = view;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			this.view.setOutput();
		} else if (e.getKeyCode() == 27) {
			this.view.format();
		}
//		System.out.println(e.getKeyCode());
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
