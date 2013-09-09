package com.crawlers;
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


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class Crawler {

	/**
	 * @param 
	 */
	public static List<String, String> crawl(String url)  {
		List urls_and_code = new ArrayList();
		try {
			URL my_url = new URL(url);
			BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream()));
			String tmp = "";
			while(null != (tmp = br.readLine())){
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}