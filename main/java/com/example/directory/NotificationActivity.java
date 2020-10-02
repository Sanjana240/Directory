package com.example.directory;

import android.content.Intent;
import android.service.quicksettings.Tile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class NotificationActivity extends AppCompatActivity {
    private EditText title;
    private EditText description;
    private EditText summary;
    private EditText domain;
    private EditText startDate;
    private EditText endDate;
    private Button add;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        databaseHelper = DatabaseHelper.getInstance(this);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        summary = findViewById(R.id.summary);
        domain = findViewById(R.id.domain);
        startDate = findViewById(R.id.sdate);
        endDate = findViewById(R.id.edate);
        add = findViewById(R.id.add);
    }

    public void performNotificationadd(View v) {
        if (title.getText().toString().isEmpty()) {
            title.setError("Please Provide value");
        } else if (description.getText().toString().isEmpty()) {
            description.setError("Please Provide value");
        } else if (summary.getText().toString().isEmpty()) {
            summary.setError("Please Provide value");
        } else if (domain.getText().toString().isEmpty()) {
            domain.setError("Please Provide value");
        } else if (startDate.getText().toString().isEmpty()) {
            startDate.setError("Please Provide value");
        } else if (endDate.getText().toString().isEmpty()) {
            endDate.setError("Please Provide value");
        }
        else {
            NotificationTable notificationTable = new NotificationTable(title.getText().toString(), description.getText().toString(), summary.getText().toString()
                    , domain.getText().toString(), startDate.getText().toString(), endDate.getText().toString());

            if (databaseHelper.addUserDataNoti(notificationTable)) {
                Toast.makeText(NotificationActivity.this, "Data Stored!",
                        Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(NotificationActivity.this, "Data not stored! error occur.",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,DashBoardActivity.class);
                startActivity(intent);
            }
        }
    }
}
