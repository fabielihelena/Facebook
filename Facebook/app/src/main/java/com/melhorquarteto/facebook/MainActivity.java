package com.melhorquarteto.facebook;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btt_log;
    Button registerButton;
    Button signUpButton;
    TextView user_name;
    TextView password;
    TextView Confirm;

    String Password;
    String Name;
    String ConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "fonts/fb-font.ttf");
        TextView myTextView = (TextView) findViewById(R.id.title);
        myTextView.setTypeface(myTypeface);

        user_name = (TextView) findViewById(R.id.user);
        password = (TextView) findViewById(R.id.password);
        registerButton = (Button) findViewById(R.id.register);
        signUpButton = (Button) findViewById(R.id.signup_btt);
        btt_log = (Button) findViewById(R.id.log);

        final Context context = getApplicationContext();

        btt_log.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Password = password.getText().toString();
                Name = user_name.getText().toString();

                if (Name.equals("Batata") && Password.equals("Frita")) {
                    Toast toast = Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Toast toast = Toast.makeText(context, "Try Again", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        signUpButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v){
                registerButton = (Button) findViewById(R.id.register);
                Confirm = (TextView) findViewById(R.id.confirm);
                registerButton.setVisibility(View.VISIBLE);
                btt_log.setVisibility(View.INVISIBLE);
                Confirm.setVisibility(View.VISIBLE);

            }
        });

        registerButton.setOnClickListener(new Button.OnClickListener() {
            @Override

            public void onClick(View v) {
                Password = password.getText().toString();
                ConfirmPass = Confirm.getText().toString();

                if(ConfirmPass.equals(Password)){
                    Toast toast = Toast.makeText(context, "Register Successful!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }
}