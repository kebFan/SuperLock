package com.kanda.superlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mEdit;
    // show number as a hint
    TextView showhint;
    // the index user chose to increment
    int bucket;
    // the latest password
    String passwordMain;

    int increment;
    int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "enter bug 1",
                Toast.LENGTH_SHORT).show();
        //String password = "";

        //mButton = (Button)findViewById(R.id.button);
        mEdit   = findViewById(R.id.password);
        showhint = findViewById(R.id.lastnumber);
         random  = randomNumberGenerator();
       // Integer temp = random;
        showhint.setText(random + "");

        //aquiredata();
        Intent intent = getIntent();
        String message = intent.getStringExtra("data");

        passwordMain = message.substring(0, 4);

        bucket =  Character.getNumericValue(message.charAt(4));

        increment = Character.getNumericValue(message.charAt(5));


    }



    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_ENTER) {

            String incremented =  PIncrement( passwordMain, bucket , increment);
            // here we compare
            Toast.makeText(this, incremented,
                    Toast.LENGTH_SHORT).show();
            //int passwordToCheck = permition( mEdit.getText().toString(), incremented);
           int passwordToCheck = permition( mEdit.getText().toString(), incremented );
           //Toast.makeText(this, passwordToCheck+"",
                    //Toast.LENGTH_SHORT).show();

                if (passwordToCheck == 0) {
                    Toast.makeText(this, "Wrong Password",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Right password detected.",
                            Toast.LENGTH_SHORT).show();
                }

                return true;
            }

           // else{
                return super.onKeyUp(keyCode, event);
            //}
    }

    /*/ increment password and return.
    public String PIncrement(String password, int bucket, int increment){
        // array start form 0 so decrement the bucket.
        bucket -=1;
        // separet chr
        char[] passArray = password.toCharArray();
        int temp = 0;
        // take out incremeted bucket
        temp = (int)random + increment;
        passArray[bucket] = (char)temp;

        return String.valueOf(passArray);
    }
    / swyew password
    /*/ //increment password and return.
    public String PIncrement(String password, int bucket, int increment){
        // array start form 0 so decrement the bucket.
        bucket -=1;
        String pass = "";
        for(int i = 0; i < password.length(); i++){
            if(i == bucket){
                pass = pass + (random + increment);
            }else{
                pass = pass + password.charAt(i);

            }
        }

        return pass;
    }

    // random number generator for the display
    public int randomNumberGenerator(){

        int rNum = (int)(Math.random() * 5+1 );
        // 5 is the maximum and the 1 is our minimum
        return rNum;
    }

    /*/password pass return 1 faill return 0
    public  int permition(String EnteredPassword, String SavedPassword ){
        int passFail = 0;
        //compare new entered pasword and saved password
        if(EnteredPassword.equals(SavedPassword) ){
            passFail = 1;
        }
        return passFail;

    }*/
    //password pass return 1 faill return 0
    public  int permition(String EnteredPassword, String SavedPassword ){
        int passFail = 0;
        //compare new entered pasword and saved password
        if(EnteredPassword.equals(SavedPassword) ){
            passFail = 1;
        }
        return passFail;


    }


}
