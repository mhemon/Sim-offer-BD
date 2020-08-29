package com.xploreict.simofferbd;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialog;
import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialogListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;


public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private static final String TAG = MainActivity.class.getSimpleName();


    String message = "";
    String title = "";
    String message_ussd = "";

    private boolean connected = false;

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                        // Log and toast
                        Log.d(TAG, "firebase token:- " + token);
                        //Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        //for children policy
        //Bundle extras = new Bundle(); extras.putString("max_ad_content_rating", "G"); AdRequest request = new AdRequest.Builder() .addNetworkExtrasBundle(AdMobAdapter.class, extras) .tagForChildDirectedTreatment(true) .build();

        //banner ads initilization
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //full screen ads initilization

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.full_screen));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        checkForPhonePermission();

        //check internet connection

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connected = true;
        } else {
            connected = false;
        }

        if (connected == true) {

        }
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                //  Initialize SharedPreferences
                SharedPreferences getPrefs = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
                boolean isFirstStart = getPrefs.getBoolean("firstStart", true);

                //  If the activity has never started before...
                if (isFirstStart) {

                    //  Launch app intro
                    Intent i = new Intent(MainActivity.this, IntroActivity.class);
                    startActivity(i);
                    //  Make a new preferences editor
                    SharedPreferences.Editor e = getPrefs.edit();

                    //  Edit preference to make it false because we don't want this to run again
                    e.putBoolean("firstStart", false);

                    //  Apply changes
                    e.apply();
                }
            }
        });

        //initilize app intro in user settings

        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean show = getPrefs.getBoolean("example_switch", false);

        if (show == true) {
            Intent i = new Intent(MainActivity.this, IntroActivity.class);
            startActivity(i);
            //  Make a new preferences editor
            SharedPreferences.Editor e = getPrefs.edit();

            //  Edit preference to make it false because we don't want this to run again
            e.putBoolean("firstStart", true);

            //  Apply changes
            e.apply();
        } else {
            //start thread
            t.start();
        }


        SharedPreferences savedata = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor e = savedata.edit();
        e.apply();

        //textView= (TextView) findViewById(R.id.txttitle);
        //msg= (TextView) findViewById(R.id.txtmsg);

        if (getIntent().getExtras() != null) {
            title = getIntent().getExtras().getString("title");
            message = getIntent().getExtras().getString("messages");
            message_ussd = getIntent().getExtras().getString("message_ussd");
            new TTFancyGifDialog.Builder(MainActivity.this)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveBtnText("Copy")
                    .setPositiveBtnBackground("#22b573")
                    .setNegativeBtnText("Cancel")
                    .setNegativeBtnBackground("#c1272d")
                    .setGifResource(R.drawable.gif1)      //pass your gif, png or jpg
                    .isCancellable(false)
                    .OnPositiveClicked(new TTFancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                            ClipData clip = ClipData.newPlainText("label", message_ussd);
                            clipboard.setPrimaryClip(clip);
                            Toasty.success(MainActivity.this, "Success!", Toast.LENGTH_SHORT, true).show();
                            if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                            }
                        }
                    })
                    .OnNegativeClicked(new TTFancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                            if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                            }
                        }
                    }).build();
            if (title == null & message == null & message_ussd == null) {
                title = "";
                message = "";
                message_ussd = "";
            }
        }


        final Button btn1 = (Button) findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, Airtelinfo.class);
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                btn1.startAnimation(animFadein);
                startActivity(a);
            }
        });


        final Button btn2 = (Button) findViewById(R.id.button2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(MainActivity.this, Blinfo.class);
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                btn2.startAnimation(animFadein);
                startActivity(b);
            }
        });

        final Button btn3 = (Button) findViewById(R.id.button3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(MainActivity.this, Gpinfo.class);
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                btn3.startAnimation(animFadein);
                startActivity(c);
            }
        });


        final Button btn4 = (Button) findViewById(R.id.button4);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(MainActivity.this, Robiinfo.class);
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                btn4.startAnimation(animFadein);
                startActivity(d);
            }
        });

        final Button btn5 = (Button) findViewById(R.id.button5);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(MainActivity.this, Teleinfo.class);
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                btn5.startAnimation(animFadein);
                startActivity(e);
            }
        });
    }

    public void freetips(View view) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Intent intent = new Intent(MainActivity.this, FreeTips.class);
            startActivity(intent);
        }

        mInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                Intent intent = new Intent(MainActivity.this, FreeTips.class);
                startActivity(intent);
            }
        });
    }

    public void lovesms(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.xploreict.lovesmsbangla"));
        startActivity(browserIntent);
    }

    public void worldcup(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.xploreict.worldcupcricket"));
        startActivity(browserIntent);
    }

    public void mobiletips(View view) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Intent intent = new Intent(MainActivity.this, RecyclerView.class);
            startActivity(intent);
        }

        mInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                Intent intent = new Intent(MainActivity.this, RecyclerView.class);
                startActivity(intent);
            }
        });
    }

    private void checkForPhonePermission() {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED) {
            // Permission not yet granted. Use requestPermissions().
            //Log.d(TAG, getString(R.string.permission_not_granted));
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        } else {
            // Permission already granted.
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                if (permissions[0].equalsIgnoreCase
                        (android.Manifest.permission.CALL_PHONE)
                        && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    // Permission was granted.
                } else {
                    // Permission denied. Stop the app.
                    //Log.d(TAG, getString(R.string.failure_permission));
                    Toasty.warning(MainActivity.this, getString(R.string.failure_permission), Toast.LENGTH_LONG, true).show();
                    // Disable the call button
                }
            }
        }
    }


    @Override
    public void onBackPressed() {
        final String[] showmessage = {"we will miss you!", "we will give you an update about sim offer in the notification.", "come back soon!", "don't forget to check our mobile tips & tricks", "Wanna know how to run free net?\ncheck our free net tips & tricks.", "Want to fix the mobile yourself?\ncheck our mobile tips & tricks."};
        int random = (int) (Math.random() * 6);
        new TTFancyGifDialog.Builder(MainActivity.this)

                .setTitle("Want to Exit App?")
                .setMessage(showmessage[random])
                .setPositiveBtnText("Exit")
                .setPositiveBtnBackground("#c1272d")
                .setNegativeBtnText("Cancel")
                .setNegativeBtnBackground("#22b573")
                .setGifResource(R.drawable.exit)      //pass your gif, png or jpg
                .isCancellable(true)
                .OnPositiveClicked(new TTFancyGifDialogListener() {
                    @Override
                    public void OnClick() {
                        finishAffinity();
                        System.exit(0);
                    }
                })
                .OnNegativeClicked(new TTFancyGifDialogListener() {
                    @Override
                    public void OnClick() {

                    }
                }).build();
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

        if (id == R.id.action_rate) {
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

        return super.onOptionsItemSelected(item);
    }

}



