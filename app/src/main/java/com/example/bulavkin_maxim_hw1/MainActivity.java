package com.example.bulavkin_maxim_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mail, theme, message;
    private Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.send_btn);
        mail = findViewById(R.id.mail_et);
        theme = findViewById(R.id.theme_et);
        message = findViewById(R.id.mess_et);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, mail.getText().toString());
                i.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                Toast.makeText(MainActivity.this, "success.", Toast.LENGTH_SHORT).show();

                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}