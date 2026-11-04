package edu.bpi.quiztime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainMenu extends AppCompatActivity {

    TextView pScore;
    Button bStart;

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main_menu);

        pScore = findViewById(R.id.pastscore);
        bStart = findViewById(R.id.start);

        Intent main = getIntent();
        score = main.getIntExtra("score", 0);

        pScore.setText(String.valueOf(score));

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startQuiz = new Intent(MainMenu.this, MainActivity.class);
                startActivity(startQuiz);
            }
        });

    }
}
