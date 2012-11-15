package com.siciarek.android.fractals;

import com.siciarek.android.fractals.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;


public class FractalActivity extends BasicActivity {
	FractalView fractalView;
	public static String title;
	float start = 0.0f;
	float stop = 0.0f;
	FCanvas canvas;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		fractalView = new FractalView(this);
		canvas = new FCanvas(fractalView);
		setContentView(fractalView);
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		fractalView.fractal = com.siciarek.fractals.FractalFactory.get(title, canvas);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {

		int action = event.getAction();
		
		if (action == MotionEvent.ACTION_MOVE) {

			if (start == 0.0f) {
				start = event.getRawX();
			}

			stop = event.getRawX();

			if (Math.abs(start - stop) > 16 && start < stop) {

				Intent intent = new Intent(this, MainActivity.class);

				startActivity(intent);

				overridePendingTransition(R.anim.slide_out_right,
						R.anim.slide_in_right);

				start = stop = 0.0f;
			}
		}

		if (action == MotionEvent.ACTION_UP) {			
			fractalView.invalidate();
			start = stop = 0.0f;
		}

		return true; // processed
	}
}
