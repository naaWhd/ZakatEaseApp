package com.example.elearnings;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aboutUsButton = findViewById(R.id.AboutUsButton);
        Button btnCalculate = findViewById(R.id.CalculateBttn);

        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle "About Us" button click action
                startActivity(new Intent(MainActivity.this,AboutUs.class));
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle "Zakat Calculator" button click action
                startActivity(new Intent(MainActivity.this, ZakatCalculatorActivity.class));
            }
        });
    }

    // If you want to keep XML-based click handlers, you can remove the corresponding
    // View.OnClickListener implementations above.

    public void onAboutUsButtonClick(View view) {
        // This method is set in the XML as the onClick handler for the "About Us" button
        startActivity(new Intent(this, AboutUs.class));
    }

    public void onCalculatorClick(View view) {
        // This method is set in the XML as the onClick handler for the "Students Page" button
        startActivity(new Intent(this, ZakatCalculatorActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.AboutUsButton) {
            startActivity(new Intent(this, AboutUs.class));
            return true;  // Return true after starting the AboutUs activity
        } else if (item.getItemId() == R.id.CalculateBttn) {
            startActivity(new Intent(this, ZakatCalculatorActivity.class));
            return true;  // Return true after starting the ZakatCalculatorActivity
        }

        return super.onOptionsItemSelected(item);
    }

}