package com.minecon;

import com.activity_splash.R;

import android.os.Bundle;
import android.os.Environment;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class Pictures extends Activity {


	private Gallery gallery;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pictures);
		// Show the Up button in the action bar.
//		setupActionBar();

		gallery = (Gallery) findViewById(R.id.examplegallery);
		gallery.setAdapter(new AddImgAdp(this));

		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position, long id) {
				// Displaying the position when the gallery item in clicked
				Toast.makeText(Pictures.this, "Picture " + position, Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_pictures, menu);
		return true;
	}

	public class AddImgAdp extends BaseAdapter {
		int GalItemBg;
		private Context cont;

		// Adding images.
		private Integer[] Imgid = {
				R.drawable.gallery0, R.drawable.gallery1, R.drawable.gallery2, R.drawable.gallery3, R.drawable.gallery4, R.drawable.gallery5
		};

		public AddImgAdp(Context c) {
			cont = c;
			TypedArray typArray = obtainStyledAttributes(R.styleable.GalleryTheme);
			GalItemBg = typArray.getResourceId(R.styleable.GalleryTheme_android_galleryItemBackground, 0);
			typArray.recycle();
		}

		public int getCount() {
			return Imgid.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imgView = new ImageView(cont);

			imgView.setImageResource(Imgid[position]);
			// Fixing width & height for image to display
			imgView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
			imgView.setScaleType(ImageView.ScaleType.FIT_CENTER);
			imgView.setBackgroundResource(GalItemBg);
			return imgView;
		}
	}
	//Edit reference: http://www.androidpeople.com/android-gallery-example
}
