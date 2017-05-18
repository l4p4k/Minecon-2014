package com.minecon;

import com.activity_splash.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		// Thread for splash activity
		Thread logoTimer = new Thread(){
			public void run(){
				//timer for 2 second splash screen
				try{
					sleep(2000);
				}

				catch(Exception e){
					e.printStackTrace();
				}
				finally{
					startActivity(new Intent(getApplicationContext(),Main.class));
					finish();
				}
			}
		};
		logoTimer.start();
	}

}
