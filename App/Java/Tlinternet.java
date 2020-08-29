package com.xploreict.simofferbd;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Tlinternet extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tlinternet);
    }


    public void pack(View view) {
        String number = "*152" + Uri.encode("#");
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);

    }

    public void first(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D35");
        startActivity(it);
    }

    public void secend(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D13");
        startActivity(it);
    }

    public void third(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D14");
        startActivity(it);

    }

    public void four(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D59");
        startActivity(it);

    }

    public void five(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D15");
        startActivity(it);

    }

    public void six(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D16");
        startActivity(it);

    }

    public void seven(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D17");
        startActivity(it);

    }

    public void eight(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D56");
        startActivity(it);

    }

    public void nine(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D18");
        startActivity(it);

    }

    public void ten(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D37");
        startActivity(it);

    }

    public void elaben(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D58");
        startActivity(it);

    }

    public void twelbe(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D19");
        startActivity(it);

    }

    public void thirteen(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D31");
        startActivity(it);

    }

    public void fourteen(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D20");
        startActivity(it);

    }

    public void fifteen(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D51");
        startActivity(it);

    }

    public void sixteen(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D52");
        startActivity(it);

    }

    public void seventeen(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D23");
        startActivity(it);

    }

    public void eighteen(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D53");
        startActivity(it);

    }

    public void nineteen(View view) {
        Uri uri = Uri.parse("smsto:111");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "D24");
        startActivity(it);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_all, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.backtomain) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
