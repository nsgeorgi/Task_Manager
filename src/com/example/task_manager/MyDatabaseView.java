package com.example.task_manager;

	

	import android.app.Activity;
	import android.os.Bundle;
	import android.widget.TextView;

	public class MyDatabaseView extends Activity{

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.my_database_view);
			TextView tv = (TextView ) findViewById(R.id.tvInfo);
			MyDatabase info = new MyDatabase(this);
			info.open();
			String data = info.getData();
			info.close();
			tv.setText(data);
		}
		

	}

	


