package com.example.imtiazaminsajid.flyingbird;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    private TextView scoreTV;
    private Button playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        scoreTV = findViewById(R.id.scoreTV);
        playAgain = findViewById(R.id.playAgainBT);

        Bundle intent = getIntent().getExtras();

        if (intent != null) {
            String gameScore = intent.get("Score").toString();

            scoreTV.setText("Score : "+gameScore);

        }

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(GameOver.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });
    }
}
