package com.siciarek.android.fractals.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;

public class Utils {
	
	public static String readRawResourseFile(Activity a, int resource) throws IOException {
		String str="";
		StringBuffer buf = new StringBuffer();			
		InputStream is = a.getResources().openRawResource(resource);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		if (is!=null) {							
			while ((str = reader.readLine()) != null) {	
				buf.append(str + "\n" );
			}				
		}
		
		is.close();	

		return buf.toString();
	}
}
