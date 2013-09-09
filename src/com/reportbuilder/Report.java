package com.reportbuilder;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Report {
	public String name = "";
	public int grade = 0;
	public boolean accessability = false;
	public int word_count = 0;
	public int sentence_count = 0;
	public int sylable_count = 0;
	public String time = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
	String report = "";
	
	public void initialize() {
		report +="<html><body><p>" + time + "</p><br />";
		
	}
	
	@Override
	public void finalize() {
		report += "</body></html>";
	}
	
	public String get_report() {
		return report;
	}
	
	private void add_header(String s) {
		report += "<h1>" + s + "</h1><br />\n";
	}
	
	private void add_paragraph(String s) {
		report += "<p>" + s + "</p><br />\n";
	}
	
	private void add_small_header(String s) {
		report += "</h3>" + s + "</h3><br />\n";
	}
	
	public void add_to_report(String n, double grade, double wc, double sc, double sylc, String content) {
		add_header(n);
		add_small_header("Grade: " + grade);
		add_small_header("Word count: " + wc);
		add_small_header("Sentence count: " + sc);
		add_small_header("Sylable count: " + sylc);
		add_paragraph("Content:<br />" + content);
		
	}
	
	public void add_to_report(String s) {
		add_header("************" + s + "****************");
	}
	
	
	public void set_name(String s) {
		this.name = s;
	}
	
	public void set_grade(int i) {
		this.grade = i;
	}
	
	public void set_accessability(boolean b) {
		this.accessability = b;
	}
	
	public void set_word_count(int i) {
		this.word_count = i;
	}
	
	public void set_sentence_count(int i) {
		this.sentence_count = i;
	}
	
	public void set_sylable_count(int i) {
		this.sylable_count = i;
	}
	
	
	

}
