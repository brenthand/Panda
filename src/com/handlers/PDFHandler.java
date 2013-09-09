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

import java.io.IOException;

import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.exceptions.InvalidPasswordException;

public class PDFHandler {

	public static String get_text(String filename) {

		String text = "";
		PDDocument doc = null;
		try {
			doc = PDDocument.load( filename );

			if(doc.isEncrypted()) {

				try { 
					doc.decrypt("");

				}
				catch(InvalidPasswordException pe) { return null; } 
				catch (CryptographyException e) {return null; }
				catch (IOException e) {return null; }
			}
		}
		catch (IOException e) {return null; }

		try {

			PDFTextStripper ps = new PDFTextStripper(filename);
			text = ps.getText(doc);

		} catch (IOException e) {return null;}


		return text;



	}

}