package edu.bpi.quiztime;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ScoreActivity extends AppCompatActivity {

    TextView Score;
    Button nextGame;
    ImageButton email;
    ImageView confet;
    MediaPlayer yay;

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.score_activity);

        Score = findViewById(R.id.score);
        nextGame = findViewById(R.id.New);
        email = findViewById(R.id.email);
        confet = findViewById(R.id.confetti);
        yay = MediaPlayer.create(this, R.raw.yay);

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        Score.setText(String.valueOf(score));

        if(score == 6){
            Glide.with(this)
                    .asGif()
                    .load(R.drawable.confettigif)
                    .into(confet);
            yay.start();
        }

        nextGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent game = new Intent(ScoreActivity.this, MainMenu.class);
                game.putExtra("score", score);
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
