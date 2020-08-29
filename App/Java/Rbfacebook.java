package com.xploreict.simofferbd;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Rbfacebook extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rbfacebook);
    }

    public void first(View view) {
        String number = "*8444*88" + Uri.encode("#");
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(Rbfacebook.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);

    }

    public void secend(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Rbfacebook.this);
        alertDialog.setTitle("40 MB Pack (1 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*8444*04" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Rbfacebook.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
        alertDialog.setNegativeButton(R.string.canc, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();


    }

    public void third(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Rbfacebook.this);
        alertDialog.setTitle("100 MB Pack (1 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*8444*00" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Rbfacebook.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
        alertDialog.setNegativeButton(R.string.canc, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();


    }

    public void four(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Rbfacebook.this);
        alertDialog.setTitle("40 MB Pack (1 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*8444*06" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Rbfacebook.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
        alertDialog.setNegativeButton(R.string.canc, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();


    }

    public void five(View view) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Rbfacebook.this);
        alertDialog.setTitle("40 MB Pack (24 hr)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*8444*00012" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Rbfacebook.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
        alertDialog.setNegativeButton(R.string.canc, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();

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
