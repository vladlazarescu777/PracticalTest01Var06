package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {
    CheckBox checkbox_1;
    CheckBox checkbox_2;
    CheckBox checkbox_3;
    private Button playButton;

    int scor = 0;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();


    private class ButtonClickListener implements View.OnClickListener {


        @Override
        public void onClick(View view) {
            ArrayList<String> nrs = new ArrayList<>();
            nrs.add("1");
            nrs.add("2");
            nrs.add("3");
            nrs.add("*");

            EditText editText1 = (EditText)findViewById(R.id.edit_text_1);
            EditText editText2 = (EditText)findViewById(R.id.edit_text_2);
            EditText editText3 = (EditText)findViewById(R.id.edit_text_3);

            switch (view.getId()) {
                case R.id.play_button:
                    Random random = new Random();
                    int number1 = random.nextInt((3 - 0) + 1) + 0; // see explanation below
                    int number2 = random.nextInt((3 - 0) + 1) + 0; // see explanation below
                    int number3 = random.nextInt((3 - 0) + 1) + 0; // see explanation below
                    Toast.makeText(PracticalTest01Var06MainActivity.this, nrs.get(number1) + " " + nrs.get(number2) + " " + nrs.get(number3), Toast.LENGTH_SHORT).show();
                    if (!checkbox_1.isChecked()){
                        editText1.setText(nrs.get(number1), TextView.BufferType.EDITABLE);
                    }
                    if (!checkbox_2.isChecked()){
                        editText2.setText(nrs.get(number2), TextView.BufferType.EDITABLE);
                    }
                    if (!checkbox_3.isChecked()){
                        editText3.setText(nrs.get(number3), TextView.BufferType.EDITABLE);
                    }

                    EditText text1 = (EditText)findViewById(R.id.edit_text_1);
                    String value1 = text1.getText().toString();

                    EditText text2 = (EditText)findViewById(R.id.edit_text_2);
                    String value2 = text2.getText().toString();

                    EditText text3 = (EditText)findViewById(R.id.edit_text_3);
                    String value3 = text3.getText().toString();

                    if( (value1.equals(value2) && value2.equals(value3) && value3.equals(value1)) || (value1.equals(value2) && value3.equals("*")) || (value1.equals(value3) && value2.equals("*")) || (value3.equals(value2) && value1.equals("*"))
                            || (value1.equals("*") && value3.equals("*")) || (value2.equals("*") && value3.equals("*")) || (value1.equals("*") && value2.equals("*")) ) {
                        String value = "Gained";
                        int nr_checks = 0;
                        if (checkbox_1.isChecked())
                            nr_checks++;
                        if (checkbox_2.isChecked())
                            nr_checks++;
                        if (checkbox_3.isChecked())
                            nr_checks++;

                        if (nr_checks == 0) {
                            value = value + "100 points";
                            scor = scor + 100;
                        }

                        if (nr_checks == 1){
                            value = value + "50 points";
                            scor = scor + 50;
                         }

                        if (nr_checks == 2){
                            value = value + "10 points";
                            scor = scor + 10;
                        }

                        Intent myIntent = new Intent(PracticalTest01Var06MainActivity.this, PracticalTest01Var06SecondaryActivity.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        PracticalTest01Var06MainActivity.this.startActivity(myIntent);
                        Toast.makeText(PracticalTest01Var06MainActivity.this, "scor: " + Integer.toString(scor) , Toast.LENGTH_SHORT).show();

                        Intent myIntent2 = new Intent(PracticalTest01Var06MainActivity.this, PracticalTest01Var06SecondaryActivity.class);
                        myIntent.putExtra("key1", scor); //Optional parameters
                        PracticalTest01Var06MainActivity.this.startActivity(myIntent);

                    }
                    break;


            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(buttonClickListener);

        checkbox_1 = (CheckBox)findViewById(R.id.checkbox_1);// Fee Payment Check box
        checkbox_2 = (CheckBox)findViewById(R.id.checkbox_2);// Fee Payment Check box
        checkbox_3 = (CheckBox)findViewById(R.id.checkbox_3);// Fee Payment Check box

//        EditText text1 = (EditText)findViewById(R.id.edit_text_1);
//        String value1 = text1.getText().toString();
//
//        EditText text2 = (EditText)findViewById(R.id.edit_text_2);
//        String value2 = text1.getText().toString();
//
//        EditText text3 = (EditText)findViewById(R.id.edit_text_3);
//        String value3 = text1.getText().toString();
//
//        String value = value1 + value2 + value3;
//
//        Intent myIntent = new Intent(PracticalTest01Var06MainActivity.this, PracticalTest01Var06SecondaryActivity.class);
//        myIntent.putExtra("key", value); //Optional parameters
//        PracticalTest01Var06MainActivity.this.startActivity(myIntent);
    }
}