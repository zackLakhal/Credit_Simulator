package iao.zack.ws;

public class CreditWS {

	public CreditWS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double calculMensualite(double c, int n, double t) {

		double tm = Math.pow(1 + t, (double) 1 / 12) - 1;
		double a = Math.pow(1 + tm, n) * tm * c / (Math.pow(1 + tm, n) - 1);
		return a;

	}

	public double calculCapital(double a, int n, double t) {

		double tm = Math.pow(1 + t, (double) 1 / 12) - 1;
		double c = (a * (Math.pow(1 + tm, n) - 1)) / (Math.pow(1 + tm, n) * tm);
		return c;

	}

	public int calculDuree(double c, double a, double t) {

		double tm = Math.pow(1 + t, (double) 1 / 12) - 1;
		double n = Math.log(a / (a - (tm * c))) / Math.log(1 + tm);
		return (int) Math.round(n);

	}

}
