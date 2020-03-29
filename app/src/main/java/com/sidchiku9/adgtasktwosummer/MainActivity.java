package com.sidchiku9.adgtasktwosummer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.indicators.BallPulseIndicator;

import java.util.Calendar;

public class MainActivity extends Activity {

    final Context context = this;
    Button button, button2, toast, snackbar,pb;
    private int mYear, mMonth, mDay, i=0;
    private int duration = Toast.LENGTH_SHORT;
    CharSequence text = "Oh Snackbar! You are so true!";
    AVLoadingIndicatorView avl;
    CountDownTimer ct;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.cd);
        button2 = findViewById(R.id.dp);
        snackbar = findViewById(R.id.snack);
        toast = findViewById(R.id.toast);
        pb = findViewById(R.id.pb);
        avl = findViewById(R.id.avl);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom);
                v = getWindow().getDecorView();
                v.setBackgroundResource(android.R.color.transparent);
                dialog.setTitle("Android Custom Dialog Box");

                TextView text = dialog.findViewById(R.id.text);
                text.setText("Android custom dialog example!");

                Button dialogButton = dialog.findViewById(R.id.dialogButtonOK);
                dialogButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        button2.setText(new StringBuilder().append(dayOfMonth).append("/").append(month).append("/").append(year));
                    }
                },mYear,mMonth,mDay);
                dpd.show();
            }
        });

        snackbar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar sb = Snackbar.make(v,"You are addicted to my app",Snackbar.LENGTH_SHORT);
                sb.show();
            }
        });

        toast.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast tst = Toast.makeText(context,text,duration);
                tst.show();
            }
        });

        pb.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer ct = new CountDownTimer(1000,5000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        avl.show();
                    }

                    @Override
                    public void onFinish() {
                        avl.hide();
                    }
                }.start();
            }
        });

    }
}

