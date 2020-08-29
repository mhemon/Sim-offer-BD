package com.xploreict.simofferbd;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.thefinestartist.finestwebview.FinestWebView;

import es.dmoral.toasty.Toasty;


public class Gpinfo extends AppCompatActivity {

    private boolean connected2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpinfo);
        //check internet connection.
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connected2 = true;
        } else {
            connected2 = false;
        }
    }


    public void voice(View view) {
        Intent intent = new Intent(Gpinfo.this, Gpvoice.class);
        startActivity(intent);
    }

    public void facebook(View view) {
        Intent intent = new Intent(Gpinfo.this, Gpfacebook.class);
        startActivity(intent);
    }

    public void internet(View view) {
        Intent intent = new Intent(Gpinfo.this, Gpinternet.class);
        startActivity(intent);
    }

    public void fnf(View view) {
        Intent intent = new Intent(Gpinfo.this, Gpfnf.class);
        startActivity(intent);
    }


    public void emr(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Gpinfo.this);
        // Setting Dialog Title
        alertDialog.setTitle("Are you Sure?");
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*1010*1" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Gpinfo.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }


    public void care(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Gpinfo.this);
        // Setting Dialog Title
        alertDialog.setTitle("Now are going to call 121");
        // Setting Dialog Message
        alertDialog.setMessage("Are you Sure! you want to call customer care");
        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "121";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Gpinfo.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke NO event
                Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }

    public void current(View view) {
        if (connected2 == false) {
            new FinestWebView.Builder(Gpinfo.this)
                    .setCustomAnimations(R.anim.activity_open_enter, R.anim.activity_open_exit, R.anim.activity_close_enter, R.anim.activity_close_exit)
                    .show("file:///android_asset/net_error_gp.html");
            Toasty.error(Gpinfo.this, "No Internet Connection.", Toast.LENGTH_SHORT, true).show();

        } else {
            new FinestWebView.Builder(Gpinfo.this)
                    .setCustomAnimations(R.anim.fragment_open_enter, R.anim.fragment_open_exit, R.anim.fragment_close_enter, R.anim.fragment_close_exit)
                    .show(getString(R.string.gp_check_currentofferurl));
        }
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
