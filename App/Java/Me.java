package com.xploreict.simofferbd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;


public class Me extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        TextView textView = (TextView) findViewById(R.id.changetextView14);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "Follow me on <a href='http://www.facebook.com/emon.k.5'>Facebook</a> or in <a href='http://www.twitter.com/MehediH63808730'>Twitter</a>";
        textView.setText(Html.fromHtml(text));

    }

}
