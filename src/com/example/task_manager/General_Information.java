package com.example.task_manager;
import android.app.Activity;
import android.app.ActivityManager.RunningServiceInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.view.Menu;

import java.util.List;
import  java.util.Locale;
import android.os.StatFs;
import android.os.Environment;
import android.content.BroadcastReceiver;
import android.os.BatteryManager;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import android.app.ActivityManager;
import android.util.Log;



public class General_Information extends Activity {

	@Override
public 	void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		BroadcastReceiver batteryReceiver = new BroadcastReceiver()
		{
			
			 int scale = -1;
	         int level = -1;
			@Override
			public void  onReceive(Context context, Intent intent)
			 {
				
			 level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
	         scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
	         setContentView(R.layout.activity_main);
	                 
	         TextView tv =(TextView) findViewById(R.id.tvDisplay) ;
	 		StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
	 		StatFs statFs_root = new StatFs(Environment.getRootDirectory().getAbsolutePath());
	 		 tv.setText(System.getProperty("os.name") 
	 		          + " version:  " 
	 		      
	 		          + System.getProperty("os.version")
	 		          + "\n System Language: "
	 		+ Locale.getDefault().getDisplayLanguage()
	 		+ "\n External Storage: "
	 		+ (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1048576L
	 		+ "Mb \n Internal Storage: "
	 		+ (statFs_root.getAvailableBlocks() * statFs.getBlockSize()) / 1048576L
	 		+ "Mb \n Battery level is:  "
	 		+level
	 		+"/" 
	 		+scale);
	 		
	 			         	         	         
			 }		
		};
		IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
	    registerReceiver(batteryReceiver, filter);				
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
