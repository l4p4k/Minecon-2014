package com.minecon;

import com.activity_splash.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Maps extends Activity implements OnClickListener {

	public static Object EXTRA_MESSAGE;
	//open map button
	private Button openMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		//setting onClickListener to button
		openMap = (Button) findViewById(R.id.openMap);
		openMap.setOnClickListener(this);
	}
	
	//open maps in an external intent i.e in the Google Maps app
	public void onClick(View v) {
		String url = "https://maps.google.co.uk/maps?ie=UTF-8&q=The+NEC+Birmingham&fb=1&gl=uk&hq=birmingham+nec+arena+map&cid=2813011685764683743&ei=dA4-U4KmHo6whAeg74DgCw&ved=0CM4BEPwSMA8";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	};	
}
