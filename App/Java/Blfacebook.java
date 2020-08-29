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


public class Blfacebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blfacebook);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_all, menu);
        return true;
    }

    public void first(View view) {
        String number = "*5000*500" + Uri.encode("#");
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(Blfacebook.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    public void secend(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blfacebook.this);
        alertDialog.setTitle("40 MB Pack (1 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*432" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blfacebook.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blfacebook.this);
        alertDialog.setTitle("100 MB Pack (2 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*430" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blfacebook.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blfacebook.this);
        alertDialog.setTitle("Confirmation");
        alertDialog.setMessage("Are you sure you want to deactive this pack?");
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*538" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blfacebook.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blfacebook.this);
        alertDialog.setTitle("20 MB (FUP) Pack (1 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*414" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blfacebook.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void six(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blfacebook.this);
        alertDialog.setTitle("Viber 20 MB Pack (1 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*435" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blfacebook.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void seven(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blfacebook.this);
        alertDialog.setTitle("Confirmation");
        alertDialog.setMessage("Are you sure you want to deactive this pack?");
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*537" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blfacebook.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
