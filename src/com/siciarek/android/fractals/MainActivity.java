package com.siciarek.android.fractals;

import com.siciarek.android.fractals.R;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends BasicActivity {
	FractalListView myListView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		String title = getResources().getString(R.string.app_name) + " "
				+ getResources().getString(R.string.app_version);
		
		setTitle(title);

		try {
			myListView = new FractalListView(this);
			setContentView(myListView);
		} catch (Exception e) {
			Log.e("LIST VIEW", e.getMessage());
		}
	}
}