package org.kazzz.view.tuno;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import org.kazzz.R;

public class MI extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maint);

        Button btnDisp = (Button)findViewById(R.id.button);
        btnDisp.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Sub 画面を起動
                Intent intent = new Intent();
                intent.setClassName("org.kazzz", "org.kazzz.view.calendar");
                startActivity(intent);
            }
        });

    }
}
//新規