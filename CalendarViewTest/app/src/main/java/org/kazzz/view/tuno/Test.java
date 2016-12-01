package org.kazzz.view.tuno;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import org.kazzz.R;
import org.kazzz.view.calendar.CalendarSelectionEvent;
import org.kazzz.view.calendar.CalendarView;
import org.kazzz.view.calendar.DateInfo;
import org.kazzz.view.calendar.OnCalendarSelectionListener;

/**
 * Created by 134104 on 2016/11/24.
 */
public class Test extends Activity implements OnCalendarSelectionListener {

    private CalendarView calendarView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maint);

        calendarView =  (CalendarView) findViewById(R.id.Calendar);
        calendarView.addOnCalendarSelectionListener(this);
        Button btnDisp = (Button)findViewById(R.id.button);
        btnDisp.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Sub 画面を起動
                Intent intent = new Intent();
                intent.setClassName("org.kazzz", "org.kazzz.CalendarTest");
                startActivity(intent);
            }
        });
    }

    public void onCalendarSelection(CalendarSelectionEvent event) {
        DateInfo dateInfo = event.getDateInfo();

        //dateInfoから日付情報を取得できます。
        int year = dateInfo.getYear();
        int month = dateInfo.getMonth();
        int day = dateInfo.getDay();

        //Intentに変数入れて渡す
        Intent intent = new Intent();
        intent.setClassName("org.kazzz", "org.kazzz.view.hourensou.TourokuTest");
        intent.putExtra("year",year);
        intent.putExtra("month",month);
        intent.putExtra("day",day);
        startActivity(intent);
    }
}