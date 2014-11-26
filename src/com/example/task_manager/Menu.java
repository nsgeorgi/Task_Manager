package com.example.task_manager;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[]={"General_Information","Service","Ram","Kill_proc"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,classes));
		
		
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String commands=classes[position];
		try{
		Class ourClass=Class.forName("com.example.task_manager."+ commands);
		Intent ourIntent=new Intent(Menu.this,ourClass);
		startActivity(ourIntent);
		}catch(ClassNotFoundException e){
		  e.printStackTrace();
		}
	}

	
	}


