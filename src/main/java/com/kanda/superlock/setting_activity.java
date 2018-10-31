package com.kanda.superlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class setting_activity extends AppCompatActivity {

    EditText newpassword;
    EditText confirmpassword;
    Button setpassword;
    RadioGroup radioGroup; // radio button index changed
    RadioButton radioButton;
    EditText increment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_activity);

        newpassword = findViewById(R.id.newpassword);
        confirmpassword = findViewById(R.id.confirmpassword);
        radioGroup = findViewById(R.id.radiogroup);
        increment = findViewById(R.id.increment);
        setpassword = findViewById(R.id.setpassword);

        // button on click listeners
       // setpassword.setOnClickListener(setPasswordListener);
        setpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                // check string new password and confirm are the same
                Boolean matchPassword = comparePasswords(newpassword.getText().toString(),
                        confirmpassword.getText().toString());
                //
                if (matchPassword) {
                    int selectedId = radioGroup.getCheckedRadioButtonId();

                    // find the radiobutton by returned id
                    radioButton = findViewById(selectedId);


                    // get data and pass it to main activity


                    String data = newpassword.getText().toString()+radioButton.getText().toString()+
                    increment.getText().toString();

                    Intent i = new Intent(setting_activity.this, MainActivity.class);

                    i.putExtra("data", data);

                    startActivity(i);

                }
            }
        });
        //Toast.makeText(this, "debug change 2",
                //Toast.LENGTH_LONG).show();
        }

    // make sure new password and confirm are the same if not toast error
    // if so, use intent to pass info and go to the next activity

    //
    public boolean comparePasswords(String newpassword, String confirmpassword) {
        boolean correct = false;
        if (newpassword.equals(confirmpassword)) {
            correct = true;
        } else {
            Toast.makeText(this, "Password did not match",
                    Toast.LENGTH_LONG).show();
        }

        return correct;
    }

}
