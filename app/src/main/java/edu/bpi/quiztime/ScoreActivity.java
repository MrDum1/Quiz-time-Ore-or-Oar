package edu.bpi.quiztime;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    TextView Score;
    Button nextGame;

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.score_activity);

        Score = findViewById(R.id.score);
        nextGame = findViewById(R.id.New);

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        Score.setText(score);

        nextGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent game = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(game);
            }
        });

    }
}
