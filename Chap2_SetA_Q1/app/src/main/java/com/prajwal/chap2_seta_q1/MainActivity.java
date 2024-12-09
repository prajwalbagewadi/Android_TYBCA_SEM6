package com.prajwal.chap2_seta_q1;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    public static final String TAG="ActivityLifeCycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //onCreate: Called when the Activity is first created.
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.d(TAG,"onCreate() called");
        //exit button code
        Button exitbutton=findViewById(R.id.exitbutton);
        exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Exiting App",Toast.LENGTH_SHORT).show();
                finish();
                System.exit(0);
            }
        });
        //Destory button code to execute the onDestory()
        Button Destory=findViewById(R.id.buttonDestory);
        Destory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Destory pressed",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    @Override
    protected void onStart(){
        //onStart: Called when the Activity becomes visible.
        super.onStart();
        Log.d(TAG,"onStart() called");
    }
    @Override
    protected void onResume(){
        //onResume: Called when the Activity starts interacting with the user.
        super.onResume();
        Log.d(TAG,"onResume() called");
    }
    @Override
    protected void onPause(){
        //onPause: Called when the Activity is partially obscured.
        super.onPause();
        Log.d(TAG,"onPause() called");
    }
    @Override
    protected void onStop(){
        //onStop: Called when the Activity is no longer visible.
        //comment onPause method to run onStop can be used interchangeable
        super.onStop();
        Log.d(TAG,"onStop() called");
    }
    @Override
    protected void onDestroy(){
        //onDestroy: Called before the Activity is destroyed.
        super.onDestroy();
        Log.d(TAG,"onDestory() called");
    }
    @Override
    protected void onRestart(){
        //onRestart: Called after the Activity is stopped and then started again
        super.onRestart();
        Log.d(TAG,"onRestart() called");
        Toast.makeText(MainActivity.this,"onRestart active",Toast.LENGTH_SHORT).show();
    }
}
