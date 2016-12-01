package org.kazzz.view.hourensou;

import android.app.Activity;
import android.provider.Settings;
import android.widget.TextView;

import org.kazzz.R;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 134113 on 2016/11/07.
 */
public class TourokuValue{

    private static ArrayList<TourokuValues> array=new ArrayList<TourokuValues>();

    //コンストラクター
    TourokuValue(){    }

    public void add(int year,int month,int day){
        array.add(new TourokuValues(year,month,day));
    }

    private class TourokuValues implements Serializable{

        // private static final long serializableVersionUID=

        //変数
        private int year;
        private int month;
        private int day;

        private String syamei;
        private String basyo;
        private String jikan;
        private String bikou;

        //コンストラクタ
        public TourokuValues(int year, int month, int day){/*
            this.year=year;this.month=month;this.day=day;
            syamei=
            jikan=
            basyo=
            bikou=
            */
        }

        //ゲッター
    public String getSyamei() {
        return syamei;
    }
    public String getJikan() {
        return jikan;
    }
    public String getBasyo() {
        return basyo;
    }
    public String getBikou() {
        return bikou;
    }
}
}