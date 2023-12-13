package com.example.elearnings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ZakatCalculatorActivity extends AppCompatActivity {

    EditText etGoldWeight, etGoldValue;
    RadioGroup radioGroup;
    RadioButton radioButton; // Fixed typo "Radiobutton" to "RadioButton"
    Button btnCalculate, btnClear;
    TextView totValGold, urufVal, totPayable, totZakat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_calculator);

        ImageView leftIcon = findViewById(R.id.leftIcon);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();
            }
        });

        etGoldWeight = findViewById(R.id.editTextGoldType);
        etGoldValue = findViewById(R.id.editTextValue);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalculate = findViewById(R.id.buttonCalculate);
        btnClear = findViewById(R.id.btnClear);
        totValGold = findViewById(R.id.totValGold);
        urufVal = findViewById(R.id.urufVal);
        totPayable = findViewById(R.id.totPayable);
        totZakat = findViewById(R.id.totZakat);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etGoldWeight.setText("");
                etGoldValue.setText("");
                totValGold.setText("");
                urufVal.setText("");
                totPayable.setText("");
                totZakat.setText("");
            }
        });

    }
    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selected Type of gold: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    public void calculate() {
        try {
            double goldGram = Double.parseDouble(etGoldWeight.getText().toString());
            double valGold = Double.parseDouble(etGoldValue.getText().toString());
            String value = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
            double totValue, totGoldW, totNeedPay, finalTot;

            Log.d("value", value);

            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Please select a type of gold", Toast.LENGTH_SHORT).show();
                return;
            }


            if (value.equalsIgnoreCase("Keep")) {
                totValue = goldGram * valGold;
                totGoldW = goldGram - 85;

                if (totGoldW > 0) {
                    totNeedPay = totGoldW * valGold;
                    finalTot = totNeedPay * 0.025;
                } else {
                    totNeedPay = 0;
                    finalTot = 0;
                }

                // Display all total
                totValGold.setText("Total value of gold: " + totValue);
                urufVal.setText("Value of gold that need zakat: " + totGoldW + "g");
                totPayable.setText("Total gold value that is zakat payable: RM" + totNeedPay);
                totZakat.setText("Total Zakat: RM" + finalTot);
            } else {
                totValue = goldGram * valGold;
                totGoldW = goldGram - 200;

                if (totGoldW > 0) {
                    totNeedPay = totGoldW * valGold;
                    finalTot = totNeedPay * 0.025;
                } else {
                    totNeedPay = 0;
                    finalTot = 0;
                }

                // Display result
                totValGold.setText("Total value of gold: " + totValue);
                urufVal.setText("Value of gold that need Zakat: " + totGoldW + "g");
                totPayable.setText("Total gold value that is zakat payable: RM" + totNeedPay);
                totZakat.setText("Total Zakat: RM" + finalTot);
            }
        } catch (java.lang.NumberFormatException nfe) {
            Toast.makeText(this, "Please input a valid number", Toast.LENGTH_SHORT).show();
        } catch (Exception exp) {
            Toast.makeText(this, "Unknown exception" + exp.getMessage(), Toast.LENGTH_SHORT).show();
            Log.d("Exception", exp.getMessage());
        }
    }
        private void showOptionsDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Choose an Option")
                    .setItems(new CharSequence[]{"Home Page", "About Us Page"}, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent;
                            if (which == 0) {
                                // User chose Home Page
                                intent = new Intent(ZakatCalculatorActivity.this, com.example.elearnings.MainActivity.class);
                            } else {
                                // User chose Calculate Page
                                intent = new Intent(ZakatCalculatorActivity.this, com.example.elearnings.AboutUs.class);
                            }

                            startActivity(intent);
                            finish();
                        }
                    });
            builder.create().show();
        }
    }




