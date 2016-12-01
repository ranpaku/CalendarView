package org.kazzz.view.calendar;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by 134113 on 2016/10/31.
 */
public class CalendarSelectedView extends LinearLayout{


    private  CalendarView calendarView;
    private DateInfo dateInfo;

    public CalendarSelectedView(Context context, CalendarView calendarView,DateInfo dateInfo) {
        super(context);
        this.calendarView = calendarView;
        this.dateInfo=dateInfo;
    }


}
