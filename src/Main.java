import java.io.File;
import java.util.List;
import java.util.Scanner;

import com.graders.FleschGrader;
import com.handlers.DocHandler;
import com.handlers.FileHandler2;
import com.handlers.HtmlHandler;
import com.handlers.PDFHandler;
import com.handlers.TextHandler;
import com.reportbuilder.Report;


public class Main {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String userInput = "";
		
		//Get file name from user
		//TODO parse command line arguments instead of user input of file name
		//System.out.print("Enter file/folder to test");
		userInput = "test_docs";
		
		//open file/folder 
		File f = new File(userInput);
		
		
		//get list of file(s)
		List<String> list = FileHandler2.listFilesForFolder(f);
		
		//setup report
		Report report = new Report();
		report.initialize();
		
		//For every file in list get the type and print its report
		String type = "";
		String content = "", content1 = "";
		double grade = 0.0;
		double sentence_count = 0, word_count = 0, sylable_count = 0;
		for(String s : list) {
			type = FileHandler2.get_file_extension(s);
			System.out.println(type);
			if(type.equals("pdf")) {
				content = PDFHandler.get_text(s);
				if (content == null)
					continue;
				//System.out.println("Got content...\n" + content);
				content = TextHandler.strip_text(content);
				sentence_count = TextHandler.get_sentence_count(content);
				word_count = TextHandler.get_word_count(content);
				sylable_count = TextHandler.get_total_syllable_count(content);
				grade = Math.round(FleschGrader.get_grade(word_count, sylable_count, sentence_count));
				report.add_to_report(s, grade, word_count, sentence_count, sylable_count, content);
			}
			else if(type.equals("doc")) {
				content = DocHandler.get_text(s);
				if(content == null)
					continue;
				content = TextHandler.strip_text(content);
				sentence_count = TextHandler.get_sentence_count(content);
				word_count = TextHandler.get_word_count(content);
				sylable_count = TextHandler.get_total_syllable_count(content);
				grade = Math.round(FleschGrader.get_grade(word_count, sylable_count, sentence_count));
				report.add_to_report(s, grade, word_count, sentence_count, sylable_count, content);
			}
			/*
			else if (type.equals("html"))  {
				System.out.println("HTML");
				report.add_to_report(HtmlHandler.get_parsed_document());
				
				
			}
			*/
		}
		
		
		//finalize report
		report.finalize();
		
		System.out.println(report.get_report());
		in.close();
		
	}

}
