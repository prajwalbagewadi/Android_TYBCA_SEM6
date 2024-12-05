package com.prajwal.helloworld;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.graphics.Color;
import android.graphics.Typeface;

public class MainActivity extends AppCompatActivity {
    TextView textview; // The TextView whose font size will change

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textview=findViewById(R.id.textview); // Reference to the TextView
        SeekBar seekbar=findViewById(R.id.seekBar3); // Reference to the SeekBar
        // Set an initial progress value (corresponding to text size)
        seekbar.setProgress(24); // Default font size of 24sp
        // Set an OnSeekBarChangeListener to adjust font size
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                // Set the text size to the current progress value
                if(progress<10){  // Minimum font size to avoid being too small
                    progress=10;  // Adjust the font size dynamically
                }
                textview.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Optional: Perform any action when SeekBar touch starts
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Optional: Perform any action when SeekBar touch stops
            }
        });

        Spinner colorSpinner=findViewById(R.id.colorspinner);
        String[] col={"MAGENTA","GREEN","RED","BLUE"};
        ArrayAdapter<String> colAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,col);
        colAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(colAdapter);
        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int postion, long l) {
                switch(postion){
                    case 0:
                        textview.setTextColor(Color.MAGENTA);
                        break;
                    case 1:
                        textview.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        textview.setTextColor(Color.RED);
                        break;
                    case 3:
                        textview.setTextColor(Color.BLUE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner FontSpinner=findViewById(R.id.fontspinner2);
        String[] font={"DEFAULT","SERIF","SANS_SERIF","MONOSPACE"};
        ArrayAdapter<String> fontAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,font);
        fontAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        FontSpinner.setAdapter(fontAdapter);
        FontSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int postion, long l) {
                switch(postion){
                    case 0:
                        textview.setTypeface(Typeface.DEFAULT);
                        break;
                    case 1:
                        textview.setTypeface(Typeface.SERIF);
                        break;
                    case 2:
                        textview.setTypeface(Typeface.SANS_SERIF);
                        break;
                    case 3:
                        textview.setTypeface(Typeface.MONOSPACE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}