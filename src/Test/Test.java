package Test;

import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.text.View;

import Model.Model;
import View.ViewConvert;

public class Test {
	private static double log2_10 = 3.321928095;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewConvert frame = new ViewConvert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
