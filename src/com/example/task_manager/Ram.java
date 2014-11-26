package com.example.task_manager;

import java.util.List;

import com.example.task_manager.R.layout;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Ram extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				LinearLayout layout = new LinearLayout(this);
				setContentView(layout);
				layout.setOrientation(LinearLayout.VERTICAL); 
				
		ActivityManager am = (ActivityManager)this.getSystemService(ACTIVITY_SERVICE);	
		 ActivityManager.MemoryInfo mInfo = new ActivityManager.MemoryInfo ();
		am.getMemoryInfo( mInfo );
			
		  TextView tv1=new TextView(this);
		    // AN SOU BGAZEI ERROR DEKSI CLICK STO PROJECT--> ANDROID TOOLS--> CLEAR LINT MARKERS //
		  tv1.setText("Available Memory  "+mInfo.availMem/1048576L+ "Megabytes  \n" +"Total Memory "+ mInfo.totalMem/1048576L +"Megabytes" );
		  layout.addView(tv1);
		     
        	 
	}
	

}