package com.hci.virtualreceptionist.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBmodel {
	private Context con;
	private static final String DATABASE_NAME = "VirtualReceptionistDB";
	private static final int DBVersion = 1;

	private DatabaseHelper DBhelp;
	private SQLiteDatabase DB;

	public DBmodel(Context c) {
		this.con = c;
		DBhelp = new DatabaseHelper(con);
	}

	public void open() {
		DB = DBhelp.getWritableDatabase();
	}

	public void close() {
		DBhelp.close();
	}
	
	public void insert(String Table,ContentValues data) {
		DB.insert(Table, null, data);
	}
	
	public void update(String Table,ContentValues data,String where) {
		DB.update(Table, data, where, null);
	}
	
	public boolean delete(String Table,String where) {
		return DB.delete(Table, where, null) > 0;
	}
	
	public Cursor retrieve(String Table,String[] columns, String where) {
		return DB.query(Table, columns, where, null, null, null, null);
		
	}


	private static class DatabaseHelper extends SQLiteOpenHelper {

		private static final String TAG = "VirtualReceptionistDB Upgrading...";

		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DBVersion);

		}

		@Override
		public void onCreate(SQLiteDatabase _db) {
			_db.execSQL("CREATE TABLE Employee (EmployeeID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ " Name TEXT NOT NULL,"
					+ " Email TEXT NOT NULL,"
					+ " Designation TEXT NOT NULL, UNIQUE(Name));");

			_db.execSQL("CREATE TABLE Login (Email TEXT PRIMARY KEY,"
					+ " Password TEXT NOT NULL, UNIQUE(Email));");

			_db.execSQL("CREATE TABLE Visitor("
					+ "CNIC INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "ContactNo TEXT NOT NULL," + "UNIQUE(ContactNo));");

			_db.execSQL("CREATE TABLE Documents("
					+ "Filename TEXT PRIMARY KEY," + "File BLOB NOT NULL;");

			_db.execSQL("CREATE TABLE Emp_Documents("
					+ "Docname TEXT NOT NULL,"
					+ "Status TEXT NOT NULL,"
					+ "ReceiverID INTEGER NOT NULL,"
					+ "SenderID INTEGER NOT NULL,"
					+ "FOREIGN KEY(ReceiverID) REFERENCES Employee(EmployeeID)),"
					+ "FOREIGN KEY(SenderID) REFERENCES Employee(EmployeeID)),"
					+ "FOREIGN KEY(Docname) REFERENCES Documents(Filename)),"
					+ "PRIMARY KEY (ReceiverID,SenderID,Docname));");

			_db.execSQL("CREATE TABLE Meetings("
					+ "MeetingTitle TEXT PRIMARY KEY," + "Date TEXT NOT NULL,"
					+ "Agenda TEXT NOT NULL," + "Time TEXT NOT NULL;");

			_db.execSQL("CREATE TABLE Emp_in_Meetings("
					+ "Title TEXT NOT NULL," + "eID TEXT NOT NULL,"
					+ "FOREIGN KEY(eID) REFERENCES Employee(EmployeeID)),"
					+ "FOREIGN KEY(Title) REFERENCES Meetings(MeetingTitle)),"
					+ "PRIMARY KEY (eID,Title));");

			_db.execSQL("CREATE TABLE Appointments(" + "eID INTEGER, "
					+ "vID INTEGER, " + "Subject TEXT, " + "Status TEXT, "
					+ "DateTime TEXT,"
					+ "FOREIGN KEY(eID) REFERENCES Employee(EmployeeID)),"
					+ "FOREIGN KEY(vID) REFERENCES Visitor(CNIC)),"
					+ "PRIMARY KEY (eID,vID));");
		}

		@Override
		public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading application's database from version "
					+ oldVersion + " to " + newVersion
					+ ", which will destroy all old data!");

			// Destroy old database:
			_db.execSQL("DROP TABLE IF EXISTS Employee;");
			_db.execSQL("DROP TABLE IF EXISTS Visitor;");
			_db.execSQL("DROP TABLE IF EXISTS Documents;");
			_db.execSQL("DROP TABLE IF EXISTS Meetings;");
			_db.execSQL("DROP TABLE IF EXISTS Appointments;");
			_db.execSQL("DROP TABLE IF EXISTS Emp_Documents;");
			_db.execSQL("DROP TABLE IF EXISTS Emp_in_Meetings;");

			// Recreate new database:
			onCreate(_db);

		}

	}
}

