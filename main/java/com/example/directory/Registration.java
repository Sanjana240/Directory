package com.example.directory;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Registration extends AppCompatActivity {
    private Button register;
    private TextView textView;
    private EditText firstname;
    private EditText lastname;
    private EditText birthdate;
    private EditText branch;
    private EditText mobileno;
    private RadioButton gender;
    private EditText address;
    private EditText city;
    private EditText pincode;
    private EditText email;
    private EditText password;
    private RadioGroup rbg;
    DatabaseHelper databaseHelper;
    private DatePickerDialog.OnDateSetListener mDataSetListener;
    private ImageView imageView;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        databaseHelper = DatabaseHelper.getInstance(this);
        textView = findViewById(R.id.bd);
        register = findViewById(R.id.regis);
        //get id od all in register
        firstname =  findViewById(R.id.fn);
        lastname = findViewById(R.id.ln);
      //  birthdate = findViewById(R.id.bd);
        branch = findViewById(R.id.brc);
        mobileno = findViewById(R.id.mn);
         rbg = findViewById(R.id.rbg);
        address = findViewById(R.id.addrs);
        city = findViewById(R.id.city);
        pincode = findViewById(R.id.pinc);
        email = findViewById(R.id.email);
        password  = findViewById(R.id.password);

                int selected=rbg.getCheckedRadioButtonId();
             final  RadioButton gender= findViewById(selected);




        textView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(Registration.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDataSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet:mm/dd/yy" + month + "-" + day + "-" + year);
                String date = month + "-" + day + "-" +year;
                textView.setText(date);
            }
        };

    }

    public void performdataregister(View v) {



        int selected=rbg.getCheckedRadioButtonId();
        final  RadioButton gender= findViewById(selected);
        if (firstname.getText().toString().isEmpty()) {
            firstname.setError("Please Provide value");
        } else if (lastname.getText().toString().isEmpty()) {
            lastname.setError("Please Provide value");
        } else if (textView.getText().toString().isEmpty()) {
            textView.setError("Please Provide value");
        } else if (branch.getText().toString().isEmpty()) {
            branch.setError("Please Provide value");
        } else if (mobileno.getText().toString().isEmpty()) {
            mobileno.setError("Please Provide value");
        } else if (address.getText().toString().isEmpty()) {
            address.setError("Please Provide value");
        } else if (city.getText().toString().isEmpty()) {
            city.setError("Please Provide value");
        } else if (pincode.getText().toString().isEmpty()) {
            pincode.setError("Please Provide value");
        } else if (email.getText().toString().isEmpty()) {
            email.setError("Please Provide value");
        } else if (password.getText().toString().isEmpty()) {
            password.setError("Please Provide value");
        } else {
            UserTable userTable = new UserTable(firstname.getText().toString(), lastname.getText().toString(), textView.getText().toString()
                    , branch.getText().toString(), mobileno.getText().toString(),gender.getText().toString(), address.getText().toString(), city.getText().toString(),
                    pincode.getText().toString(), email.getText().toString(), password.getText().toString());

            if (databaseHelper.addUserData(userTable)) {
                Toast.makeText(Registration.this, "Data Stored!",
                        Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(Registration.this, "Data not stored! error occur.",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            }
        }
    }

}
