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


public class Blinternet extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blinternet);
    }

    public void pack(View view) {
        String number = "*5000*500" + Uri.encode("#");
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);

    }

    public void first(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("3 MB Pack (1 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*418" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void secend(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("7 MB Pack (1 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*413" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("12 MB Pack (1 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*420" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("25 MB Pack (1 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*429" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("45 MB Pack (1 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*443" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("60 MB Pack (3 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*402" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void eight(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("100 MB Pack (7 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*422" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void nine(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("120 MB Pack (30 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*423" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void ten(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("160 MB Pack (7 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*401" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void elaben(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("250 MB Pack (10 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*417" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void twelbe(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("300 MB Pack (30 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*403" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void thirteen(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("500 MB Pack (7 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*482" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void fourteen(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("600 MB Pack (30 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*404" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void fifteen(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Blinternet.this);
        alertDialog.setTitle("1 GB Pack (30 d)");
        alertDialog.setMessage(R.string.mbalert);
        alertDialog.setPositiveButton(R.string.bypack, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String number = "*5000*481" + Uri.encode("#");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Blinternet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void sixteen(View view) {
        String number = "*124*50" + Uri.encode("#");
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);

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
