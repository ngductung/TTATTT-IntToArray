package Model;

import java.util.Arrays;

public class Model {
	private static double log2_10 = 3.321928095;
	private double p;
	private long a;
	private int w;
	private int m;
	private int t;
	private int[] result;

	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
	}

	public long getA() {
		return a;
	}

	public void setA(long a) {
		this.a = a;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public void setResult() {
		m = (int) Math.ceil(log2_10 * Math.log10(p));
		t = (int) Math.ceil(((double) m) / ((double) w));
		int[] array = new int[t];
		for (int i = t - 1; i >= 0; i--) {
			array[i] = (int) Math.floor(((double) a) / ((double) (Math.pow(2, i * w))));
			a -= (int) array[i] * Math.pow(2, i * w);
		}
		this.result = array;
	}

	public int[] getResult() {
		setResult();
		return result;
	}

	public String getResultString() {
		setResult();
		String out = "";
		for (int i = t - 1; i >= 0; i--) {
			out += result[i] + ", ";
		}
		out = '(' + out.substring(0, out.length()-2) +')';
		return out;
	}

}
