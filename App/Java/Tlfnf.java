package com.xploreict.simofferbd;

import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tlfnf extends AppCompatActivity {

    Button addbtn;
    Button delbtn;
    Button regbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tlfnf);


        regbtn = (Button) findViewById(R.id.regbutton);
        delbtn = (Button) findViewById(R.id.delbutton);
        addbtn = (Button) findViewById(R.id.addbutton);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:363");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                it.putExtra("sms_body", "Reg");
                startActivity(it);
            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText addedit = (EditText) findViewById(R.id.addeditText);
                String a = addedit.getText().toString();
                Uri uri = Uri.parse("smsto:363");
                Intent ita = new Intent(Intent.ACTION_SENDTO, uri);
                ita.putExtra("sms_body", "Add " + a);
                startActivity(ita);
            }
        });

        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText deleteedit = (EditText) findViewById(R.id.deleteeditText);
                String d = deleteedit.getText().toString();
                Uri uri = Uri.parse("smsto:363");
                Intent itd = new Intent(Intent.ACTION_SENDTO, uri);
                itd.putExtra("sms_body", "Del " + d);
                startActivity(itd);
            }
        });

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
