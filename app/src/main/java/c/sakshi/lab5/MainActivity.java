package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("c.shaksi.lab5", Context.MODE_PRIVATE);
        System.out.println("username: " + sharedPreferences.getString(usernameKey, ""));
        if(!sharedPreferences.getString(usernameKey, "").equals("")) {
            goToActivity2();
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void onButtonClick(View view) {
        // get username and passwrod
        EditText editText1 = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String username = editText1.getText().toString();
        String password = editText2.getText().toString();

        // add username to sharepreferecne
        SharedPreferences sharedPreferences = getSharedPreferences("c.shaksi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", username).apply();

        // Go to next activity
        goToActivity2();
    }

    public void goToActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
