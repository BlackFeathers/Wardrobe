package com.example.li.wardrobe;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String CREATE_WARDROBE = "CREATE TABLE WARDROBE("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "First text,"+
            "Second text,"+
            "Price real,"+
            "Color text,"+
            "Brand text,"+
            "Remark text,"+
            "Time text,"+
            "Image Blob)";

    private Context mContext;

    public MyDBHelper(Context context){
        super(context,"wardrobe.db",null,1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_WARDROBE);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
