package com.jeversoft.android.sqlite.first;

import java.util.List;
import java.util.Random;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;

public class TestDatabaseActivity extends ListActivity {
  public OffPrintsDataSource datasource;


  @Override
  public void onCreate(Bundle savedInstanceState) {
	  try{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    datasource = new OffPrintsDataSource(getApplicationContext());
//    Button btnSearch = (Button) findViewById(R.id.search);
//    btnSearch.setOnClickListener(new Button.OnClickListener() {  
//        public void onClick(View v)
//            {
//      	  try{		  
//      	    datasource = new OffPrintsDataSource(getApplicationContext());
//      	    datasource.open();
//
//      	    //List<OffPrint> values = datasource.getAllOffPrints();
//      	    Cursor values = datasource.getAllOffPrints();
//      	    @SuppressWarnings("deprecation")
//      		SimpleCursorAdapter adapter = new SimpleCursorAdapter(
//      				getApplicationContext(),
//      	    		R.layout.custom_row_view,
//      	    		values,
//      	    		new String[] {"_id","author","title","year","proceedings","copies","pages"},
//      	    		new int[] {R.id.text1,R.id.text2, R.id.text3, R.id.text4, R.id.text5, R.id.text6, R.id.text7}
//
//      	    		);
//
//      	    setListAdapter(adapter);
//      		  }
//      		  catch(Exception e) {
//      			  System.out.println(e.getMessage());
//      		  }
//            }
//         });
    }
	  catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
  }

  // Will be called via the onClick attribute
  // of the buttons in main.xml
  public void onClick(View view) {
    @SuppressWarnings("unchecked")
//    ArrayAdapter<OffPrint> adapter = (ArrayAdapter<OffPrint>) getListAdapter();
    OffPrint offprint = null;
    switch (view.getId()) {
    case R.id.search:
      String[] comments = new String[] { "Cool", "Very nice", "Hate it" };
      int nextInt = new Random().nextInt(3);
      // save the new comment to the database
 //     offprint = datasource.createOffPrint(comments[nextInt]);
 //     adapter.add(offprint);
      break;
    }
//    adapter.notifyDataSetChanged();
  }

  @Override
  protected void onResume() {
	  try {
    datasource.open();
    super.onResume();
	  }
	  catch(NullPointerException e) {
		  System.out.println(e.getMessage());
	  }
  }

  @Override
  protected void onPause() {
    datasource.close();
    super.onPause();
  }

  public void myFancyMethod(View v) {
	  try{		  
    	    //datasource = new OffPrintsDataSource(getApplicationContext());
    	    datasource.open();
    	    EditText editTxt = (EditText) findViewById(R.id.output);
    	    String strSrch = editTxt.getText().toString();
    	    //List<OffPrint> values = datasource.getAllOffPrints();
    	    Cursor values = datasource.getAllOffPrints(strSrch);
    	    @SuppressWarnings("deprecation")
    		SimpleCursorAdapter adapter = new SimpleCursorAdapter(
    				getApplicationContext(),
    	    		R.layout.custom_row_view,
    	    		values,
    	    		new String[] {"_id","author","title","year","proceedings","copies","pages"},
    	    		new int[] {R.id.text1,R.id.text2, R.id.text3, R.id.text4, R.id.text5, R.id.text6, R.id.text7}

    	    		);

    	    // use the SimpleCursorAdapter to show the
    	    // elements in a ListView
//    	    ArrayAdapter<OffPrint> adapter = new ArrayAdapter<OffPrint>(this,
//    	        android.R.layout.simple_list_item_1, values);
    	    setListAdapter(adapter);
    		  }
    		  catch(Exception e) {
    			  System.out.println(e.getMessage());
    		  }
          }
       
  
} 