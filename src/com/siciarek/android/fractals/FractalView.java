package com.siciarek.android.fractals;

import com.siciarek.fractals.common.*;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class FractalView extends View {
	Paint paint = new Paint();
	Path path = new Path();
	Fractal fractal;
	Activity fa;
	
	public FractalView(Context context) {
		super(context);
		fa = (Activity) context;
	}
	
	@Override
	public void onDraw(Canvas canvas) {
		fractal.generateNext();
		canvas.drawPath(this.path, this.paint);
	}
}
