package org.kazzz.view.calendar;

/**
 * Created by 134105 on 2016/11/10.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.kazzz.R;



public class SubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Button henb = (Button)findViewById(R.id.henbutton);
        Button itib = (Button)findViewById(R.id.itibutton);
        henb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Sub 画面を起動
                Intent intent = new Intent();
                intent.setClassName("org.kazzz", "org.kazzz.view.hourensou.TourokuTest");
                startActivity(intent);
            }
        });
        itib.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Sub 画面を起動
                Intent intent = new Intent();
                intent.setClassName("org.kazzz", "org.kazzz.CalendarTest");
                startActivity(intent);
            }
        });
    }

}
