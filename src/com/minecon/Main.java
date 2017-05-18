package com.minecon;

import com.activity_splash.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity implements OnClickListener{

	public static Object EXTRA_MESSAGE;
	//buttons
	private Button toPics;
	private Button toInfo;
	private Button toMap;
	private Button toSite;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		//setting listeners to buttons
		toPics = (Button) findViewById(R.id.toPics);
		toPics.setOnClickListener(this);

		toInfo = (Button) findViewById(R.id.toInfo);
		toInfo.setOnClickListener(this);

		toMap = (Button) findViewById(R.id.toMap);
		toMap.setOnClickListener(this);

		toSite = (Button) findViewById(R.id.toSite);
		toSite.setOnClickListener(this);
	}
	//what happens when you click a View item i.e any button
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.toPics){
			startActivity(new Intent(getApplicationContext(),Pictures.class));
		}else if(v.getId() == R.id.toInfo){
			startActivity(new Intent(getApplicationContext(),Information.class));
		}else if(v.getId() == R.id.toMap){
			startActivity(new Intent(getApplicationContext(),Maps.class));
		}else if(v.getId() == R.id.toSite){
			//open website
			String url = "http://mineconiw.com/";
			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
		}
	};	
}

