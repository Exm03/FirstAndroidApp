package com.example.firstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.firstapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//    private ActivityMainBinding binding;
    private Button btnConvert;
    private ImageButton btnToActivity;
    private ImageView imageToChange, imageButtonChange;

    private int countClicks = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int orentation = getResources().getConfiguration().orientation;


        //Images
        if (orentation == Configuration.ORIENTATION_LANDSCAPE) {
            imageToChange = findViewById(R.id.imageToChange);
            imageButtonChange = findViewById(R.id.imageButtonChange);

            imageButtonChange.setOnClickListener(v -> {
                countClicks++;
                switch (countClicks) {
                    case 1:
                        imageToChange.setImageResource(R.drawable.chocolate_chip_cookies);
                        break;
                    case 2:
                        imageToChange.setImageResource(R.drawable.cookie_icon);
                        break;
                    case 3:
                        imageToChange.setImageResource(R.drawable.cooockie);
                        countClicks = 0;
                        break;
                }


            });
        }

        //Buttons
        if (orentation == Configuration.ORIENTATION_PORTRAIT) {
            btnConvert = findViewById(R.id.btnConvert);



            btnConvert.setOnClickListener(v -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you want to convert?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ConvertSpeede();
                    }
                });
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Convertation");
                alertDialog.show();

            });

            btnConvert.setOnLongClickListener(v -> {
                btnConvert.setTextColor(Color.RED);
                return true;
            });
        }

        btnToActivity = findViewById(R.id.btnToActivity);

        btnToActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            intent.putExtra("user", "Yan");
            intent.putExtra("age", 25);
            intent.putExtra("isPremium", true);
            intent.putExtra("message", "Hello from MainActivity3");

            startActivity(intent);
        });


//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        binding.btnConvert.setOnClickListener(v ->
//                binding.textResult.setText("clicked"));
        }






    public void ConvertSpeede() {
        EditText user_data = findViewById(R.id.editUserText);
        TextView lable_result = findViewById(R.id.textResult);

        String data  = user_data.getText().toString();

        if (!data.isEmpty()) {
        float number =  Float.parseFloat(data);
        number *= 1.60934f;
        lable_result.setText(String.format("Result: %s", String.valueOf(number)));
        } else {
            btnConvert.setText("Error");
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}