package com.siciarek.android.fractals;

import android.graphics.Color;
import android.graphics.Paint.Style;
import com.siciarek.fractals.common.Drawable;

public class FCanvas implements Drawable {
	
	String background = "#FAFAD2";
	String foreground = "#141414";
	FractalView view;

	public FCanvas(FractalView view) {
		this.view = view;
		this.view.invalidate();
		
		this.view.setBackgroundColor(Color.parseColor(background));
		this.view.paint.setColor(Color.parseColor(foreground));
		this.view.paint.setAntiAlias(true);
		this.view.paint.setStrokeWidth(2.0f);
	}

	public void init(String style) {

		if(style.equals("fill")) {
			this.view.paint.setStyle(Style.FILL);
		}
		else
		{
			this.view.paint.setStyle(Style.STROKE);
		}
	}
	
	public void updateTitle(String title) {
		this.view.fa.setTitle(title);
	}
	
	public void finalize() {

	}

	public float getWidth() {
		return this.view.getMeasuredWidth();
	}

	public float getHeight() {
		return this.view.getMeasuredHeight();
	}

	public void moveTo(float x, float y) {
		this.view.path.moveTo(x, y);
	}

	public void lineTo(float x, float y) {
		this.view.path.lineTo(x, y);
	}

	public void close() {
		this.view.path.close();
	}

	public void reset() {
		this.view.path.reset();
	}
	
	public void setPoint(float x, float y) {
		if (x < getWidth() - 1.0f && y < getHeight() - 1.0f) {
			moveTo(x, y);
			lineTo(x + 1, y + 1);
		}
	}
}
