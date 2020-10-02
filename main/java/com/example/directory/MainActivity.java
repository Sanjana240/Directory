package com.example.directory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Calendar calendar;
    LinearLayout myl;
    AnimationDrawable ad;
    EditText username;
    EditText password;
    Button login;
    private CheckBox checkbox;
    private EditText edtPassword;
    DatabaseHelper databaseHelper;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myl = findViewById(R.id.mybg);
        ad = (AnimationDrawable) myl.getBackground();
        ad.setEnterFadeDuration(3000);
        ad.setExitFadeDuration(3000);
        ad.start();
        username = findViewById(R.id.username);
        password = findViewById(R.id.psswrd);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered();
            }
        });
       // AddData();

        checkbox = (CheckBox) findViewById(R.id.sp);
        edtPassword = (EditText) findViewById(R.id.psswrd);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (!isChecked) {
                    // show password
                    edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        databaseHelper = new DatabaseHelper(this);
    }

//    public void AddData()
//    {
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                LoginTable logintable = new LoginTable(username.getText().toString(),password.getText().toString());
//
//                boolean insertData = sqLitehHelper.addLoginData(logintable);
//                if(insertData==true)
//                {
//                    Toast.makeText(MainActivity.this,"Data Stored",Toast.LENGTH_SHORT).show();
//
//                }
//                else
//                {
//                    Toast.makeText(MainActivity.this, "Data not Stored", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//    }


//    void checkDataEntered()
//    {
//        if(isEmpty(username))
//        {
//            Toast t = Toast.makeText(this,"you must entered the username",Toast.LENGTH_SHORT);
//            t.show();
//        }
//        if(isEmpty(password))
//        {
//            Toast t = Toast.makeText(this,"you must entered the strong password",Toast.LENGTH_SHORT);
//            t.show();
//
//        }
//    }

    void checkDataEntered() {
        boolean isValid = true;
        if (isEmpty(username)) {
            username.setError("You must enter username to login!");
            isValid = false;
        } else {
            if (!isEmail(username)) {
                username.setError("Enter valid username!");
                isValid = false;

            }
        }
        if (isEmpty(password)) {
            password.setError("You must enter password to login!");
            isValid = false;
        } else {
            if (password.getText().toString().length() < 4) {
                password.setError("Password must be at least 4 chars long!");
                isValid = false;
            }
        }

        if (isValid) {
//            Intent intent = new Intent(this, DashBoardActivity.class);
//
//            Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show();
//            startActivity(intent);
//          String usernameValue = username.getText().toString();
//          String passwordVlue = password.getText().toString();
//            if (usernameValue.equals("") && passwordVlue.equals("")) {
//                Toast.makeText(this, "Wrong credentials!", Toast.LENGTH_SHORT).show();
//            } else {
//                SharedPreferences sp = getSharedPreferences("DIR",MODE_PRIVATE);
//                sp.edit().putString("KEY",""+ usernameValue).commit();
               checkDataBase();


//
//
          }
    }
    boolean isEmpty(EditText text)
    {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmail(EditText text)
    {
        CharSequence email = text.getText().toString();
        return(!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public void performregister(View view) {
        // Intent intent = new Intent(this,Registration.class);
        Intent intent = new Intent(this, Registration.class);

        Toast.makeText(this, "Register success", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }
       public void performforgetpass(View view){
        Intent intent = new Intent(this,ForgetPasswordActivity.class);
        startActivity(intent);

}


    private void checkDataBase() {
        String email = "";
        String pas = "";
        cursor = databaseHelper.getlogin();

        if (cursor.getCount() == 0)
            Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
        else {
            cursor.moveToFirst();
            do {
                email = cursor.getString(11);
                pas = cursor.getString(12);
                if (username.getText().toString().equalsIgnoreCase(email)) {
                    if (password.getText().toString().equalsIgnoreCase(pas)) {
                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, DashBoardActivity.class));

                        SharedPreferences sp = getSharedPreferences("DIR", Context.MODE_PRIVATE);
                        sp.edit().putString("SKEY_email", "" + username.getText().toString()).commit();
                        sp.edit().putString("SKEY_pass", "" + password.getText().toString()).commit();

                    } else {
                        Toast.makeText(this, "User name password wrong!", Toast.LENGTH_LONG).show();
                    }
                }
            } while (cursor.moveToNext());

        }
    }

//public void onClick(View v)
//{
//    SharedPreferences sp = getSharedPreferences("DIR",MODE_PRIVATE);
//    sp.edit().putString("SKEY",""+username.getText().toString()).commit();
//    cursor = sqLitehHelper.getDataFromUser();
//    if(cursor.getCount()==0)
//    {
//        Toast.makeText(getApplicationContext(),"No DATA",Toast.LENGTH_SHORT).show();
//
//    }
//    else
//    {
//        while(cursor.moveToNext())
//        {
//            Toast.makeText(getApplicationContext(),"first name" +cursor.getString(0),Toast.LENGTH_LONG);
//            Toast.makeText(getApplicationContext(),"last name" +cursor.getString(1),Toast.LENGTH_LONG);
//            Toast.makeText(getApplicationContext(),"branch" +cursor.getString(3),Toast.LENGTH_LONG);
//
//        }
//    }
//
//    Intent intent  = new Intent(this,DashBoardActivity.class);
//    startActivity(intent);
//}
//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.male:
//                if (checked)
//                    // Pirates are the best
//                    break;
//            case R.id.female:
//                if (checked)
//                    // Ninjas rule
//                    break;
//        }
//    }

    }

