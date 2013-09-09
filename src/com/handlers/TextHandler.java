package com.handlers;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler {


	public TextHandler() {

	}

	/**
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * To get a more exact count on sentences find "." if the
	 * following character is capatalized then it is a 
	 * sentence otherwise it is not
	 * @param text
	 * @return
	 */
	public static int get_sentence_count(String text) {
		//TODO
		String[] sentences = text.split("[.!?]");
		return sentences.length;
	}

	public static int get_word_count(String text) {

		String[] words = text.split(" ");
		return words.length;
	}

	/**
	  Returns string with all non standard characters removed
	 **/
	public static String strip_text(String text) {
		//text = remove_urls(text);
		//return text.replaceAll("[^\\p{L}\\p{Nd}]", " ");
		//return Normalizer.normalize(text, Normalizer.Form.NFD);
		//String t = text.replaceAll("[^a-zA-Z0-9]", " ");
		//String t = text.replaceAll("[^\\x00-\\x7F]", "");
		//String t = text.replaceAll("\\P{InBasic_Latin}", "");
		//String t = text.replaceAll("[^\\u0000-\\uFFFF]", "");
		String t = text.replaceAll("[^\\x00-\\x7f]", "");
		//return "1234567890";
		return t;
	}

	/**
	  Gets the total syllable count from a array of words
	 **/
	public static int get_total_syllable_count(String content) {
		String[] words = content.split(" ");
		int count = 0;
		for (String word : words) {
			count += count_syllables(word);
		}

		return count;
	}
	
	public static int get_total_polysyllable_count(String[] words) {
		int count = 0;
		for(String word : words) {
			if(is_polysyllable(word)) count++;
		}
		return count;
	}
	
	public static boolean is_polysyllable(String word) {
		int count = count_syllables(word);
		if(count == 2) return true;
		else return false;
		
	}

	/**
	  Returns number of syllables in word
	 **/
	public static int count_syllables(String word) {
		int count = 0;
		word = word.toLowerCase();
		word = word.replaceAll("[^a-zA-Z0-9\\s]", "");
		boolean isPrevVowel = false;
		for (int i = 0; i < word.length(); i++) {
			if (word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u")) {
				if (isVowel(word.charAt(i)) && !((word.charAt(i) == 'e') && (i == word.length()-1))) {
					if (isPrevVowel == false) {
						count++;
						isPrevVowel = true;
					}
				} else {
					isPrevVowel = false;
				}
			} else {
				count++;
				break;
			}
		}
		return count;
	}

	/**
	  Function to help syllable count function
	 **/
	public static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return true;
		} else {
			return false;
		}
	}
	/** rewrite this code **NOT WORKING****************
	 * ************************************
	 * @param text
	 * @return
	 * *************************************
	 */
	private static String remove_urls(String text)
    {
        String urlPattern = "((https?|ftp|gopher|telnet|file|Unsure|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        String urlPattern2 = "(www)*[\\s]";
        Pattern p = Pattern.compile(urlPattern,Pattern.CASE_INSENSITIVE);
        Pattern p2 = Pattern.compile(urlPattern2, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        Matcher m2 = p2.matcher(text);
        int i = 0;
        while (m.find()) {
            text=text.replaceAll(m.group(i),"").trim();
            i++;
        }
        
        i =0;
        while (m2.find()) {
        	text=text.replaceAll(m2.group(i), "").trim();
        }
        return text;
    }
}
