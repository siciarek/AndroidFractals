package com.siciarek.android.fractals;

import com.siciarek.android.fractals.R;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;

public class BasicActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.exit:
                this.moveTaskToBack(true);
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    @Override
	public boolean onTouchEvent(MotionEvent event) {

		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:

			break;
		case MotionEvent.ACTION_MOVE:
			
			break;
		case MotionEvent.ACTION_UP:
			
			break;
		case MotionEvent.ACTION_CANCEL:

			break;
		case MotionEvent.ACTION_OUTSIDE:

			break;
		default:
		}

		return true; // processed
	}
}
