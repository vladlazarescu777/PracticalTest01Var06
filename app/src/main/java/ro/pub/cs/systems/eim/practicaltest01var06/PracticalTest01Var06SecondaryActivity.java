package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_practical_test01_var06_secondary);

        Intent intent = getIntent();
        String value = intent.getStringExtra("key"); //if it's a string you stored.

        Toast.makeText(this,  value, Toast.LENGTH_SHORT).show();


//        Intent intent1 = getIntent();
//        String value2 = intent.getIntExtra("key1", 0); //if it's a string you stored.

    }
}