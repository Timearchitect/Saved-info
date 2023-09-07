package se.gritacademy.saved_info;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {

            Log.d("Alrik", savedInstanceState.getString("key", "Default if null"));
        }
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.preferance), this.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit();


        EditText et = findViewById(R.id.editTextText);
        et.setText(sharedPref.getString("Key","default") );

        Log.d("output", sharedPref.getString("Key", "default"));

        findViewById(R.id.button).setOnClickListener( (l) -> {
            editor.putString("Key", String.valueOf(et.getText()));
            editor.apply();
            }
        );





    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putString("key","message");
        super.onSaveInstanceState(outState);
    }
/*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("message", "This is my message to be reloaded");
        super.onSaveInstanceState(outState);
    }
*/


}