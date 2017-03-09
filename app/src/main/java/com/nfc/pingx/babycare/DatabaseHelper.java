package com.nfc.pingx.babycare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

/**
 * Created by chenp_fjnu on 2017/3/5.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String COST_TITLE = "cost_title";
    public static final String BABY_CARE = "baby_care";
    public static final String COST_DATE = "cost_date";
    public static final String COST_MONEY = "cost_money";

    public DatabaseHelper(Context context){
        super(context, BABY_CARE,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists "+ BABY_CARE +"(" +
                        "id integer primary key," +
                        COST_TITLE +" varchar," +
                        COST_DATE + " varchar," +
                        COST_MONEY+ " varchar)");
    }
    public  long insertCost(CostBean costBean){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COST_TITLE, costBean.costTitle);
        cv.put(COST_DATE, costBean.costDate);
        cv.put(COST_MONEY, costBean.costMoney);
        return database.insert(BABY_CARE,null,cv);
    }
    public void deleteAllData(){
        SQLiteDatabase database = getWritableDatabase();
        database.delete(BABY_CARE,null,null);
    }
    public void deleteItem(CostBean costBean){
        SQLiteDatabase database = getWritableDatabase();
        if(costBean.id!=0) {
            database.delete(BABY_CARE, "id = ?", new String[]{Long.toString(costBean.id)});
        }
    }
    public Cursor getAllCostData(){
        SQLiteDatabase database = getWritableDatabase();
        return database.query(BABY_CARE,null, null,null,null,null, COST_DATE +" DESC");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
