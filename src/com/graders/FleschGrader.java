package com.graders;


public class FleschGrader {

	public static double get_grade(double wc, double sylc, double senc) {
		return (.39*(wc/senc)+11.8*(sylc/wc)-15.59);
	}

	public static double get_reading_ease(double wc, double sylc, double senc) {
		return (206.835-1.015*(wc/senc)-84.6*(sylc/wc));
	}
}
