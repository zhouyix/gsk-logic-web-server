package com.gsk.server.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

public class WordSpellingInfo {
	private String word;
	private String spelling;
	private String shortspelling;
	private boolean isonlyword;
	private HanyuPinyinOutputFormat t3;  
	private void reloadSpelling() {
		spelling = "";
		shortspelling = "";
		isonlyword = true;
        for (int j = 0; j < word.length(); j++) {
        	try {
        		String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word.charAt(j), t3); 
        		if (pinyinArray != null)  { 
	            	spelling += pinyinArray[0];
	            	shortspelling += pinyinArray[0].charAt(0);
	            } else {
	            	isonlyword = false;
	            	spelling += word.charAt(j);
	            	shortspelling += word.charAt(j);  
	            }  
			} catch (Exception e) {
				continue;
			}  
        }  
	}
	
	
	public WordSpellingInfo(String word) {
		t3 = new HanyuPinyinOutputFormat();
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		this.setWord(word);
		
	}
	
	public WordSpellingInfo() {
		t3 = new HanyuPinyinOutputFormat();
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
	}
	
	public void setWord(String word) {
		this.word = word;
		reloadSpelling();
	}
	
	public String getWord() {
		return word;
	}
	
	public String getSpelling() {
		return spelling;
	}
	
	public String getShortspelling() {
		return shortspelling;
	}
	
	public boolean getIsonlyword() {
		return isonlyword;
	}
}
