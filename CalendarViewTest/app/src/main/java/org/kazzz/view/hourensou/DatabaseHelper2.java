package org.kazzz.view.hourensou;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 134113 on 2016/11/30.
 */
public class DatabaseHelper2 extends DatabaseHelper {
    private static SQLiteDatabase mydb;
    DatabaseHelper2(Context context){
        super(context);
        if(mydb==null) {
            this.mydb = getWritableDatabase();
        }
    }
    public void insert(ContentValues values) throws SQLException{
        super.insert(mydb,values);
    }
    public SQLiteCursor select(){
        return super.select(mydb);
    }
    public void update(ContentValues values){
        super.update(mydb,values);
    }
}
