package swap.com.testdb.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import swap.com.testdb.model.ContactModel;


public class Dbhelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "TestDb";
    // Labels table name
    private static final String TABLE_LABELS = "UserMaster";

    // Labels Table Columns names of enquiry table
    private static final String KEY_SR_NO = "sr_no";
    private static final String KEY_NAME = "name";
    private static final String KEY_MOBILE = "mobile";



    public Dbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE UserMaster(sr_no INT,name TEXT, mobile TEXT)");

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LABELS);

        // Create tables again
        onCreate(db);
    }

    public void insertVoterInfo(String sr_no, String name, String mobile) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // values.put(KEY_EID, eid);
        values.put(KEY_SR_NO, sr_no);
        values.put(KEY_NAME, name);
        values.put(KEY_MOBILE, mobile);


        db.insert(TABLE_LABELS, null, values);

        Log.d("Inserted data","Successfully ....");
        db.close(); // Closing database connection
    }

    public void deleteVoterInfoThroughVoterID(String sr_no) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_LABELS + "where" + KEY_SR_NO + "=" + sr_no);

    }


    public boolean updateVoterInfo(String sr_no, String name, String mobile) {

        SQLiteDatabase db = this.getWritableDatabase();


        db.execSQL("UPDATE " + TABLE_LABELS + " SET " + KEY_SR_NO + " = " + sr_no + ", " + KEY_NAME + " = " + "'" + name + " ,"
                + KEY_MOBILE + " = " + "'" + mobile );
        return true;
    }



    // insert in enquirystatus table

    public List<ContactModel> getAllContactList() {

        List<ContactModel> voterList = new ArrayList<ContactModel>();
        String selectQuery;

        // Select All Query

        selectQuery = "SELECT * FROM " + TABLE_LABELS ;


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                try {
                    ContactModel contactData = new ContactModel();

                    contactData.setSrNo(cursor.getString(0));
                    contactData.setName(cursor.getString(1));
                    contactData.setMobile(cursor.getString(2));



                    voterList.add(contactData);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return voterList;
    }


}