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

public class Kill_proc extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				LinearLayout layout = new LinearLayout(this);
				setContentView(layout);
				layout.setOrientation(LinearLayout.VERTICAL); 
			
		
		ActivityManager am = (ActivityManager)this.getSystemService(ACTIVITY_SERVICE);
		List<ActivityManager.RunningServiceInfo> rs = am.getRunningServices(50);
		 ActivityManager.MemoryInfo mInfo = new ActivityManager.MemoryInfo ();
		
		
		
		
		int pids[]= new int[30]; 
		for (int i=0; i<rs.size(); i++) {
		  ActivityManager.RunningServiceInfo  rsi = rs.get(i);
		  am.killBackgroundProcesses(rsi.service.getPackageName());
		  TextView tv1=new TextView(this);
		  
		  pids[i]=rsi.pid;
		 
		
		  tv1.setText(i+1+")    Process killed successfully");
		 layout.addView(tv1);
		  
		}
		
		
         
        	 
	}
	

}