package org.kazzz;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableLayout;
import android.database.sqlite.SQLiteCursor;

//import org.kazzz.view.calendar.R;
import org.kazzz.view.calendar.SubActivity;
import org.kazzz.view.hourensou.DatabaseHelper;

public class CalendarTest extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {


        DatabaseHelper db=new DatabaseHelper(this);
        SQLiteDatabase mydb =db.getWritableDatabase();

        /*ContentValues values=new ContentValues();
        values.put("year","2016");
        values.put("month","11");
        values.put("day","22");
        values.put("syamei","株式会社");
        values.put("hour","12");
        values.put("minute","00");
        values.put("basyo","大阪");
        values.put("mokuteki","面接");
        values.put("bikou","なし");

        db.insert(mydb,values);
        db.select(mydb);*/



        //String day;
        //String kaisya;
        //String basyo;
        //String mokuteki;
        //String jikan;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        View view = getLayoutInflater().inflate(R.layout.sub, null);

        TableLayout layout = (TableLayout) findViewById(R.id.layout);
        try{
            SQLiteCursor cursor=(SQLiteCursor)mydb.query("test_t0",null,null,null,null,null,null);
            //表示
            while (cursor.moveToNext()){

                layout.addView(view);

                TextView text_day = (TextView) view.findViewById(R.id.text1);
                TextView text_kaisya = (TextView) view.findViewById(R.id.text2);
                TextView text_basyo = (TextView) view.findViewById(R.id.text3);
                TextView text_mokuteki = (TextView) view.findViewById(R.id.text4);
                TextView text_jikan = (TextView) view.findViewById(R.id.text5);



                text_day.setText(cursor.getString(3));
                text_kaisya.setText(cursor.getString(4));
                text_basyo.setText(cursor.getString(7));
                text_mokuteki.setText(cursor.getString(8));
                text_jikan.setText(cursor.getString(5)+":"+cursor.getString(6));
                // System.out.println("id"+cursor.getString(0));
                // System.out.println("year"+cursor.getString(1));
                // System.out.println("month"+cursor.getString(2));
                //System.out.println("minute"+cursor.getString(6));
               // System.out.println("bikou"+cursor.getString(9));
            }
        }catch (Exception e){
            System.out.print("Exception");
        }

       /* for (int i = 1; i <= 3; ++i) {


            View view = getLayoutInflater().inflate(R.layout.sub, null);
            layout.addView(view);

            TextView text1 = (TextView) view.findViewById(R.id.text1);
            TextView text2 = (TextView) view.findViewById(R.id.text2);
            TextView text3 = (TextView) view.findViewById(R.id.text3);
            TextView text4 = (TextView) view.findViewById(R.id.text4);
            TextView text5 = (TextView) view.findViewById(R.id.text5);

            day=
            kaisya="株式会社";
            basyo="大阪";
            mokuteki="面接";
            jikan="11～12";

            text1.setText(i+"");
            text2.setText(i+kaisya);
            text3.setText(i+basyo);
            text4.setText(i+mokuteki);
            text5.setText(i+jikan);



        }*/
        view = getLayoutInflater().inflate(R.layout.button, null);
        layout.addView(view);


        Button sendButton = (Button) findViewById(R.id.return_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SubActivity.class);
                startActivity(intent);
            }
        });
    }

}