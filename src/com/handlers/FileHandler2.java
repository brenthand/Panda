package com.handlers;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FileHandler2 {
	private static List<String> list_of_filenames = new ArrayList();
	public static List<String> get_files(File file) {
		
		//System.out.println("In get files");
		
		//Loop through folder. if file then return only one name in list
		if(file.isFile()) {
			list_of_filenames.add(file.getAbsolutePath());
			//System.out.println("Break point file...");
			System.out.println(file.getName());
		}
		else if (file.isDirectory()) {
			System.out.println("Break point folder...");
			list_of_filenames.add(file.getAbsolutePath());
			System.out.println(file.getName());
			File[] listOfFiles = file.listFiles();
			if(listOfFiles!=null) {
				for (int i = 0; i < listOfFiles.length; i++)
					get_files(listOfFiles[i]);
			} 
		}
		
		return list_of_filenames;
	}
	
	
	public static String get_file_extension(String f) {
		String extension = "";

		int i = f.lastIndexOf('.');
		if (i > 0) {
		    extension = f.substring(i+1);
		}
		
		return extension;
	}
	
	public static List<String> listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            //System.out.println(fileEntry.getName());
	        	list_of_filenames.add(fileEntry.getAbsolutePath());
	        }
	    }
	    
	    return list_of_filenames;
	}

}
