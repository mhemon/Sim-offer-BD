package com.xploreict.simofferbd;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class RecyclerView extends AppCompatActivity {

    private AdView AdView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        //find view by id
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(R.id.recyclerview);
        //animation
        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_down_to_up);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //send data to adapter
        String[] messages = getResources().getStringArray(R.array.menu_list);
        Resources res = getResources();
        String[] details = res.getStringArray(R.array.menu_details);
        recyclerView.setAdapter(new RecyclerAdapter(messages, details));

        //item animation
        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();

        //banner ad view
        AdView2 = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        AdView2.loadAd(adRequest);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.AboutMe) {
            Intent intent = new Intent(this, Me.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.update) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName()));
            startActivity(browserIntent);
            return true;
        }

        if (id == R.id.setting) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.rate) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName()));
            startActivity(browserIntent);
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
