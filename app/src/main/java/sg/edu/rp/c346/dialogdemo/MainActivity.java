package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;
    Button btnDemo2;
    TextView tvDemo2;
    Button btnDemo3;
    TextView tvDemo3;
    Button btnExercise3;
    TextView tvExercise3;
    Button btnDemo4;
    TextView tvDemo4;
    Button btnDemo5;
    TextView tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);

        btnDemo2 = findViewById(R.id.buttonDemo2);
        tvDemo2 = findViewById(R.id.textViewDemo2);

        btnDemo3 = findViewById(R.id.buttonDemo3);
        tvDemo3 = findViewById(R.id.textViewDemo3);

        btnExercise3 = findViewById(R.id.buttonExercise3);
        tvExercise3 = findViewById(R.id.textViewExercise3);

        btnDemo4 = findViewById(R.id.buttonDemo4);
        tvDemo4 = findViewById(R.id.textViewDemo4);

        btnDemo5 = findViewById(R.id.buttonDemo5);
        tvDemo5 = findViewById(R.id.textViewDemo5);

        // DEMO 1 - Simple Dialog with 1 Button
        btnDemo1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set the dialog details
                /*
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                // Sets whether this dialog is cancelable with the BACK key.
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
                */

                myBuilder.setTitle("Congratulation");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(true);
                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        // DEMO 2 - Dialog with 2 Buttons "Positive", "Negative"
        btnDemo2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Button below");
                myBuilder.setCancelable(false);

                // Positive Button
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected Positive");
                    }
                });

                // Negative Button
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected Negative");
                    }
                });

                // Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        // DEMO 3 - Dialog with one editTextInput Field
        btnDemo3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Inflate the input.xml file
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can be used in the onClick() method
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        // EXERCISE 3 - Dialog with two editTextInput Field and Sum
        btnExercise3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Inflate the input.xml file
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.exercise3, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can be used in the onClick() method
                final EditText etInput1 = viewDialog.findViewById(R.id.editTextInput1);
                final EditText etInput2 = viewDialog.findViewById(R.id.editTextInput2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Extract the text entered by the user
                        int no1 = Integer.parseInt(etInput1.getText().toString());
                        int no2 = Integer.parseInt(etInput2.getText().toString());
                        int sum = no1 + no2;
                        // Set the text to the TextView
                        tvExercise3.setText("The sum is " + sum);
                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        // DEMO 4 - Dialog with DatePicker
        btnDemo4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog
                // Get Current year, month, date
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, year,month,day);
                myDateDialog.show();
            }
        });

        // DEMO 5 - Dialog with TimePicker
        btnDemo5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Create the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minutes);
                    }
                };

                // Create the TimePicker Dialog
                Calendar now = Calendar.getInstance();
                int Hour = now.get(Calendar.HOUR);
                int Mins = now.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, Hour,Mins,true);
                myTimeDialog.show();
            }
        });
    }
}
