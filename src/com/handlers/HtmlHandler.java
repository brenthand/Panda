package com.handlers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class HtmlHandler {

	public static String ID = "f29a38e43dece0ac345553dcba7649c6a12292fd";
	public static String Standard = "WCAG2-AA";
	public static String FILE = "file://home/d5tz/javability/Enable/test_docs/test.html";

	private static String ACHECKERURL = "http://achecker.ca/checkacc.php?uri="+ FILE + "&id=" + ID + "&output=rest&guide=" + Standard;


	public void get_id_from_settings() {
		try {
			Scanner in = new Scanner(new FileReader("filename.txt"));
			this.ID = in.next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String get_content(){return null;};

	public static String get_parsed_document() {
		HttpClient httpclient = new DefaultHttpClient();
		String responseBody = "";
		try {
			HttpGet httpget = new HttpGet(ACHECKERURL);

			System.out.println("executing request " + httpget.getURI());

			// Create a response handler
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			responseBody = httpclient.execute(httpget, responseHandler);

			//DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			//DocumentBuilder db;
			System.out.println("********************************************\n About to return response:");
			System.out.println(responseBody);
			return responseBody;
			/*db = dbf.newDocumentBuilder(); 
			org.w3c.dom.Document doc = null;
			doc = db.parse(new InputSource(new ByteArrayInputStream(responseBody.getBytes("utf-8"))));
			NodeList nl = doc.getElementsByTagName("status");
			responseBody = nl.item(0).getTextContent();
			*/
			
		} //catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		/*}*/ catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}// catch (SAXException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		/*}*/ finally {
			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			httpclient.getConnectionManager().shutdown();

		}
		//return responseBody;
	}



}
