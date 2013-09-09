package com.handlers;
/************************************************************************************
 *        Copyright 2013 Brent Hand													*
 *																					*
 *      Licensed under the Apache License, Version 2.0 (the "License");				*
 *      you may not use this file except in compliance with the License.			*
 *      You may obtain a copy of the License at										*
 *																					*
 *																					*
 *      		http://www.apache.org/licenses/LICENSE-2.0							*
 *																					*
 *      Unless required by applicable law or agreed to in writing, software			*
 *      distributed under the License is distributed on an "AS IS" BASIS,			*
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.	*
 *      See the License for the specific language governing permissions and			*
 *      limitations under the License.												*
 *																					*
 *																					*
 ************************************************************************************/

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import java.io.File;
import java.io.FileInputStream;



/**
 * @author Brent Hand
 * 
 * 
 */

public class DocHandler {

	public static String get_text(String f) {

		String content = "";
		WordExtractor extractor = null ;
		try {

			File file = new File(f);
			FileInputStream is = new FileInputStream(file.getAbsolutePath());
			HWPFDocument document = new HWPFDocument(is);
			extractor = new WordExtractor(document);
			String [] file_content = extractor.getParagraphText();
			for(int i=0; i<file_content.length; i++){
				if(file_content[i] != null)
					content += file_content[i];
			}
		}
		catch(Exception exep){}
		
		return content;
	}




}
