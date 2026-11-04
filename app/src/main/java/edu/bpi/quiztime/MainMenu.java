package edu.bpi.quiztime;

import android.os.Bundle;
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

    }
}
