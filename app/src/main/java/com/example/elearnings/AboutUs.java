package com.example.elearnings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        ImageView leftIcon = findViewById(R.id.menu);
        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();
            }
        });

        ImageView instagramIcon = findViewById(R.id.instagram_icon);
        instagramIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform Instagram sharing action
                shareOnInstagram();
            }
        });

        ImageView twitterIcon = findViewById(R.id.twitter_icon);
        twitterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform Twitter sharing action
                shareOnTwitter();
            }
        });
    }

    private void showOptionsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose an Option")
                .setItems(new CharSequence[]{"Home Page", "Zakat Calculator Page"}, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent;
                        if (which == 0) {
                            // User chose Home Page
                            intent = new Intent(AboutUs.this, MainActivity.class);
                        } else {
                            // User chose Calculate Page
                            intent = new Intent(AboutUs.this, ZakatCalculatorActivity.class);
                        }

                        startActivity(intent);
                        finish();
                    }
                });

        builder.create().show();
    }

    private void shareOnInstagram() {
        // Add logic to open Instagram
        // Example: Open Instagram website
        Intent instagramIntent = new Intent(Intent.ACTION_VIEW);
        instagramIntent.setData(Uri.parse("https://www.instagram.com/your_instagram_account/"));
        startActivity(instagramIntent);
    }

    private void shareOnTwitter() {
        // Add logic to open Twitter
        // Example: Open Twitter website
        Intent twitterIntent = new Intent(Intent.ACTION_VIEW);
        twitterIntent.setData(Uri.parse("https://twitter.com/your_twitter_account/"));
        startActivity(twitterIntent);
    }
}
