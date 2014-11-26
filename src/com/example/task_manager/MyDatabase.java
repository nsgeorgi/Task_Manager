

package com.example.task_manager;

	import android.content.ContentValues;
	import android.content.Context;
	import android.database.Cursor;
	import android.database.sqlite.SQLiteDatabase;
	import android.database.sqlite.SQLiteDatabase.CursorFactory;
	import android.database.sqlite.SQLiteOpenHelper;

	public class MyDatabase {
		//���������� static final ��� ��� ������ ��� ����� ���.
		public static final String KEY_ROWID = "_id";
		public static final String KEY_PID = "process_id";
		public static final String KEY_NAME = "process_name";
		public static final String KEY_USAGE = "memory_use";
		//������� �������� ����� ��� ������ ����� ��� ��� ������� ��� ����� ���; 
		private static final String DATABASE_NAME = "processDb";
		private static final String DATABASE_TABLE = "processTable";
		private static final int DATABASE_VERSION = 1;

		private MyDbHelper ourHelper; //���������� helper ��� ��� �������� ��� ������� ��� SQLiteOpenHelper
		private final Context ourContext;//
		private SQLiteDatabase ourDatabase;//����������� ��� SQLiteDatabase

		private static class MyDbHelper extends SQLiteOpenHelper {

			public MyDbHelper(Context context) {
				super(context, DATABASE_NAME, null, DATABASE_VERSION);
				// TODO Auto-generated constructor stub
			}

			@Override
			public void onCreate(SQLiteDatabase db) {
				// TODO Auto-generated method stub//SQl code � ������ ���������� ���
				// ������ ��� �� ����� ������.
				db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + KEY_PID
						+ "TEXT NOT NULL, " + KEY_NAME + " TEXT NOT NULL, "
						+ KEY_USAGE + "TEXT NOT NULL );"

				);
			}

			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
				// TODO Auto-generated method stub
				db.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE);
				onCreate(db);
			}

		}

		public MyDatabase(Context c) {
			ourContext = c;
		}

		public MyDatabase open() {
			ourHelper = new MyDbHelper(ourContext);
			ourDatabase = ourHelper.getWritableDatabase();
			return this;
		}

		public void close() {
			ourHelper.close();
		}
		// ���������� ��� ��� entry ��� ��� ���� ���.
		public long createEntry(String pid, String name, String memory) {
			ContentValues cv = new ContentValues();
			cv.put(KEY_PID, pid);
			cv.put(KEY_USAGE, memory);
			cv.put(KEY_NAME, name);
			return ourDatabase.insert(DATABASE_TABLE, null, cv);
		}

		public String getData() { // ���������� ��� String �� �� ����������� ���
									// ����� ,��������� ��� ��� View.
			// TODO Auto-generated method stub
			String[] columns = new String[] { KEY_PID, KEY_NAME, KEY_USAGE };
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null,
					null, null);
			String result = "";
			int iPID = c.getColumnIndex(KEY_PID); 
			int iName = c.getColumnIndex(KEY_NAME);
			int iUse = c.getColumnIndex(KEY_USAGE);
			// ������������ ���������� �� ��������� ��� ������� c 
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) { 

				result = result + c.getString(iPID) + c.getString(iName)
						+ c.getString(iUse) + "\n";
			}

			return result;
		}
	}



