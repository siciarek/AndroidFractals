package com.siciarek.android.fractals;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.siciarek.android.fractals.common.Utils;
import com.siciarek.android.fractals.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FractalListView extends ListView {

	Activity mainActivity;

	public FractalListView(Context context) throws Exception {
		super(context);
		mainActivity = (Activity) context;
		String jsonInput = Utils.readRawResourseFile(mainActivity, R.raw.fractals);
		
		JSONArray jsonArray = new JSONArray(jsonInput);
		int length = jsonArray.length();
		
		List<String> listContents = new ArrayList<String>(length);

		for (int i = 0; i < length; i++) {
			listContents.add(jsonArray.getString(i));
		}
		
		this.setAdapter(new ArrayAdapter<String>(mainActivity, android.R.layout.simple_list_item_1, listContents));
		
		this.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View arg1,
					int position, long arg3) {

				Intent intent = new Intent(mainActivity, FractalActivity.class);

				FractalActivity.title = parent.getItemAtPosition(position).toString();
				
				mainActivity.startActivity(intent);
				mainActivity.overridePendingTransition(R.anim.slide_in_left,
						R.anim.slide_out_left);

			}
		});
	}
}
