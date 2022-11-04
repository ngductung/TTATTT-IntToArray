package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.text.View;

import View.ViewConvert;

public class ControllerButton implements ActionListener {
	private ViewConvert view;

	public ControllerButton(ViewConvert viewConvert) {
		this.view = viewConvert;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("format")) {
			this.view.format();
		} else if (command.equalsIgnoreCase("Tính")) {
			this.view.setOutput();
		}
		
	}
	
}
