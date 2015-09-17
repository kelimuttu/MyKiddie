package mykiddie.sqlite.helper;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "MyKiddie";
	private static final String TABLE_JADWAL = "jadwal";
	
	SQLiteDatabase db;
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String create_table = "Create table " + TABLE_JADWAL +"(id integer primary key,"+ "jadwal text, waktu text)";
		db.execSQL(create_table);
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists jadwal");
		onCreate(db);
	}
	
	public void insertJadwal (Jadwal jdwl) {
		db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("jadwal",jdwl.get_jadwal());
		cv.put("waktu", jdwl.get_waktu());
		
		db.insert(TABLE_JADWAL, null, cv);
		db.close();
	}
	
	public Jadwal getJdwl(int id){
		db = this.getReadableDatabase();
		
		Cursor cur = db.query(TABLE_JADWAL, 
						new String[] {String.valueOf(id)}, 
						"id = ?", null, null, null, null);
		if(cur != null){
			cur.moveToFirst();
		}
		
		Jadwal jdwl = new Jadwal(cur.getInt(0), 
								cur.getString(1), cur.getString(2));
		return jdwl;
	}
	
	public List<Jadwal> getAllJdwl(){
		List<Jadwal> jdwal = new ArrayList<Jadwal>();
		
		String query = "select * from "+TABLE_JADWAL;
		db = this.getWritableDatabase();
		Cursor cur = db.rawQuery(query, null);
		
		if(cur.moveToFirst()){
			do{
				Jadwal jdwl = new Jadwal(cur.getInt(0), 
									cur.getString(1), cur.getString(2));
				
				jdwal.add(jdwl);
			}while(cur.moveToNext());
		}
		return jdwal;
	}
	
	public void updateJdwl (Jadwal jdwl){
		db = this.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put("jadwal", jdwl.get_jadwal());
		cv.put("waktu", jdwl.get_waktu());
		
		db.update(TABLE_JADWAL, cv, "id = ?", 
				new String[]{String.valueOf(jdwl.get_id())});
	}
	
}
