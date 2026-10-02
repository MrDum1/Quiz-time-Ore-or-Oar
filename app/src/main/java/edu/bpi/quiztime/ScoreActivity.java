package edu.bpi.quiztime;

import android.net.Uri;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    TextView Score;
    Button nextGame;
    ImageButton email;

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.score_activity);

        Score = findViewById(R.id.score);
        nextGame = findViewById(R.id.New);
        email = findViewById(R.id.email);

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        Score.setText(String.valueOf(score));

        nextGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent game = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(game);
                Toast.makeText(ScoreActivity.this, "New game loading",Toast.LENGTH_SHORT).show();
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendEmail = new Intent(Intent.ACTION_SENDTO);
                sendEmail.setData(Uri.parse("mailto:"));
                sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"student@example.com"});
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Quiz App Score");
                sendEmail.putExtra(Intent.EXTRA_TEXT, "I scored " + score + " out of 6.");
                startActivity(sendEmail);
            }
        });

    }
}
