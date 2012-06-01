package edu.sxm5750;

/**
 * QAViewActivity.java
 * @author Sudipan Mishra
 * @version 1.0
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/** My second activity. Needed for my player to store answers. */
public class QAViewActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Don't want title in second activity
        requestWindowFeature(Window.FEATURE_NO_TITLE);	
        setContentView(R.layout.tiles);
        
        // Don't want top bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        
        // Back button to back to first activity
        Button next = (Button) findViewById(R.id.back);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        });
        
    }
	
	public void onPause() {
		super.onPause();
	}
	
	public void onResume() {
		super.onPause();
	}
}
