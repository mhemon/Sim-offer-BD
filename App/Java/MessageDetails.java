package com.xploreict.simofferbd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import es.dmoral.toasty.Toasty;


public class MessageDetails extends AppCompatActivity {

    TextView tv;
    String title, value;
    RelativeLayout relativeLayout;
    private SharedPreferences preferences;
    private String FONT_SIZE_KEY = "fontsize";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_details);
        tv = (TextView) findViewById(R.id.details);
        relativeLayout = findViewById(R.id.zoomlayout);
        value = getIntent().getStringExtra("mesdtls");
        title = getIntent().getStringExtra("title");
        tv.setText(value);
        preferences = getPreferences(MODE_PRIVATE);
        float fontsize = preferences.getFloat(FONT_SIZE_KEY, 16);
        tv.setTextSize(fontsize);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_txt_size_large) {
            tv.setTextSize(20);
            preferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putFloat(FONT_SIZE_KEY, 20);
            editor.commit();
            Toasty.success(getBaseContext(), "Font size saved successfully!", Toast.LENGTH_SHORT, true).show();
            //Toast.makeText(getBaseContext(),"Font size saved successfully!",Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.action_txt_size_normal) {
            tv.setTextSize(16);
            preferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putFloat(FONT_SIZE_KEY, 16);
            editor.commit();
            Toasty.success(getBaseContext(), "Font size saved successfully!", Toast.LENGTH_SHORT, true).show();
            return true;
        }

        if (id == R.id.action_txt_size_small) {
            tv.setTextSize(14);
            preferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putFloat(FONT_SIZE_KEY, 14);
            editor.commit();
            Toasty.success(getBaseContext(), "Font size saved successfully!", Toast.LENGTH_SHORT, true).show();
            return true;
        }

        if (id == R.id.action_share) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String play = "http://play.google.com/store/apps/details?id=";
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Enjoy This Apps " + play + getPackageName());
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
            startActivity(Intent.createChooser(sharingIntent, "Share using"));
            return true;
        }

        if (id == R.id.action_rate) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName()));
            startActivity(browserIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
