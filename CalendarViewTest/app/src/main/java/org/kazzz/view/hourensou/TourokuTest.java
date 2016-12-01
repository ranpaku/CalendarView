package org.kazzz.view.hourensou;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

import org.kazzz.R;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;

/**
 * Created by 134113 on 2016/11/07.
 */
public class TourokuTest extends Activity implements View.OnClickListener{

    //変数 一覧
    private  DatabaseHelper2 db;
    private int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touroku);
        Button t_button = (Button) findViewById(R.id.t_button);
        Button s_button = (Button) findViewById(R.id.s_button);
        Button c_button = (Button) findViewById(R.id.c_button);
        //リスナー登録
        t_button.setOnClickListener(this);
        s_button.setOnClickListener(this);
        c_button.setOnClickListener(this);
        //データベースオープン
        db =new DatabaseHelper2(this);

        //オートコンプリートセット
/*やりかけ
        AutoCompleteTextView inputTextView = (AutoCompleteTextView) findViewById(R.id.syamei);
        Cursor cursor = db.select(mydb);
        CursorAdapter adapter;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            adapter = new SimpleCursorAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    cursor,
                    new String[]{"_id","syamei"},
                    new int[]{android.R.id.text1,android.R.id.text2},0);
            System.out.println("aaa");
        }else{
            adapter = new SimpleCursorAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    cursor,
                    new String[]{"syamei"},
                    new int[]{android.R.id.text1});
        }
        inputTextView.setAdapter(adapter);
*/
        //インテントを前アクティビティから受け取る
        Intent intent = getIntent();
        if(intent != null) {
            year=intent.getIntExtra("year",1999);
            month=intent.getIntExtra("month",01);
            day=intent.getIntExtra("day",01);
        }
        System.out.println("onCreate success");
    }

    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }

    //クリックリスナー
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.t_button:
                touroku();
                break;
            case R.id.s_button:
                sakujo();
                break;
            case R.id.c_button:
                cansel();
                break;
        }
    }

    //キャンセルボタン
    private void cansel() {
        finish();
    }
    //削除ボタン
    private void sakujo() {
    }
    //登録ボタン
    private void touroku() {
        //ContentValues の値を作成
        String syamei=((EditText)findViewById(R.id.syamei)).getText().toString();
        String hour;
        String minute;
        //SDKバージョンで処理振り分け
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            hour= String.valueOf(((TimePicker)findViewById(R.id.jikan)).getHour());
            minute = String.valueOf(((TimePicker)findViewById(R.id.jikan)).getMinute());
        }else{
            hour= String.valueOf(((TimePicker)findViewById(R.id.jikan)).getCurrentHour());
            minute = String.valueOf(((TimePicker)findViewById(R.id.jikan)).getCurrentMinute());
        }
        String basyo=((EditText)findViewById(R.id.basyo)).getText().toString();
        String mokuteki=((EditText)findViewById(R.id.mokuteki)).getText().toString();
        String bikou=((EditText)findViewById(R.id.bikou)).getText().toString();

        //ContentValues に値を設定→データベースに入力
        ContentValues values=new ContentValues();
        values.put("year",year);
        values.put("month",month);
        values.put("day",day);
        values.put("syamei",syamei);
        values.put("hour",hour);
        values.put("minute",minute);
        values.put("basyo",basyo);
        values.put("mokuteki",mokuteki);
        values.put("bikou",bikou);
        try {
            System.out.println("insert start");
            db.insert(values);
            System.out.println("insert success");
        }catch (SQLException e){
            System.out.println("update start");
            db.update(values);
            System.out.println("update success");
        }
        db.select();
        System.out.println("touroku success");
    }

}
