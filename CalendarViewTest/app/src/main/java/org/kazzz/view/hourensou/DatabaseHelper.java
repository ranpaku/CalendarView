package org.kazzz.view.hourensou;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;

/**
 * Created by 134113 on 2016/11/09.
 */
    public class DatabaseHelper extends SQLiteOpenHelper {
        private static final String DB_NAME="test_db";
        private static final String TABLE_NAME="test_t3";
        public DatabaseHelper(Context context) {
            super(context, DB_NAME, null, 1);
        }

    @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(
                    "CREATE TABLE "+TABLE_NAME+" ("
                            + "_id integer primary key AUTOINCREMENT,"
                            + "year integer,"
                            + "month integer,"
                            + "day integer,"
                            + "syamei text,"
                            + "hour text,"
                            + "minute text,"
                            + "basyo text,"
                            + "mokuteki text,"
                            + "bikou text"
                            + ")"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
        //insertするメソッド
        public void insert(SQLiteDatabase db,ContentValues values) throws SQLException {
            db.insertOrThrow(TABLE_NAME, null, values);
        }
        //selectするメソッド
        public SQLiteCursor select(SQLiteDatabase db){
            try{
                SQLiteCursor cursor=(SQLiteCursor)db.query(TABLE_NAME,null,null,null,null,null,null);
                //表示
                while (cursor.moveToNext()){
                    System.out.println("id"+cursor.getString(0));
                    System.out.println("year"+cursor.getString(1));
                    System.out.println("month"+cursor.getString(2));
                    System.out.println("day"+cursor.getString(3));
                    System.out.println("syamei"+cursor.getString(4));
                    System.out.println("hour"+cursor.getString(5));
                    System.out.println("minute"+cursor.getString(6));
                    System.out.println("basyo"+cursor.getString(7));
                    System.out.println("mokuteki"+cursor.getString(8));
                    System.out.println("bikou"+cursor.getString(9));
                }
            }catch (Exception e){
            }
            return (SQLiteCursor)db.query(TABLE_NAME,null,null,null,null,null,null);
        }
    public void update(SQLiteDatabase db,ContentValues values){
        //db.update(TABLE_NAME, values,"_year=2016",null);
        db.update(TABLE_NAME,values,"id=1", null);
    }
}
