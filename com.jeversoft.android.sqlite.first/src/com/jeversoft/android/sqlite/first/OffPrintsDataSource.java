package com.jeversoft.android.sqlite.first;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class OffPrintsDataSource {

  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;

  public OffPrintsDataSource(Context context) {
    dbHelper = new MySQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public OffPrint createOffPrint(String comment) {
    ContentValues values = new ContentValues();
    values.put(MySQLiteHelper.COLUMN_COMMENT, comment);
    long insertId = database.insert(MySQLiteHelper.TABLE_OFFPRINTS, null,
        values);
    Cursor cursor = database.query(MySQLiteHelper.TABLE_OFFPRINTS,
        null, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
        null, null, null);
    cursor.moveToFirst();
    OffPrint newOffPrint = cursorToOffPrint(cursor);
    cursor.close();
    return newOffPrint;
  }

  public void deleteOffPrint(OffPrint offprint) {
    long id = offprint.getId();
    System.out.println("Comment deleted with id: " + id);
    database.delete(MySQLiteHelper.TABLE_OFFPRINTS, MySQLiteHelper.COLUMN_ID
        + " = " + id, null);
  }

  public Cursor getAllOffPrints(String searchCriteria) {
	  Cursor cursor = null;
	  try {
//    List<OffPrint> offprints = new ArrayList<OffPrint>();
		  String strQuery = new String("_raw like '%" + searchCriteria.toLowerCase() + "%';");

    cursor = database.query(MySQLiteHelper.TABLE_OFFPRINTS,
    		new String[] {"_id", "author", "title", "year", "proceedings","copies", "pages"}, strQuery, null, null, null, null);

//    cursor.moveToFirst();
//    while (!cursor.isAfterLast()) {
//      OffPrint offprint = cursorToOffPrint(cursor);
//      offprints.add(offprint);
//      cursor.moveToNext();
//    }
//    // make sure to close the cursor
//    cursor.close();
//    return offprints;
	  }
	  catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
	  finally {
		 return cursor;	 
	  }
  }

  private OffPrint cursorToOffPrint(Cursor cursor) {
	  OffPrint offprint = new OffPrint();
	  offprint.setId(cursor.getLong(0));
	  offprint.setOffPrint(cursor.getString(1));
    return offprint;
  }
} 