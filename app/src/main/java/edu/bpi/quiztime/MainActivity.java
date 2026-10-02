package edu.bpi.quiztime;

import android.os.Bundle;

import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView Img;
    Button Option1,Option2;
    Button Submit;

    List<Quizz> questionList;
    int currentQid = 0;
    int selectedAnswer = -1;
    boolean next = true;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Img = findViewById(R.id.Img);
        Option1 = findViewById(R.id.Option1);
        Option2 = findViewById(R.id.Option2);
        Submit = findViewById(R.id.submit);

        loadQuestion();
        displayQuestion();

        Option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer = 1;
            }
        });

        Option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer = 2;
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next) {
                    if(selectedAnswer == -1) {
                        Toast.makeText(MainActivity.this, "Please Pick an option.", Toast.LENGTH_SHORT).show();
                    }else {
                        next = false;
                        Quizz currentQuestion = questionList.get(currentQid);
                        if (selectedAnswer == currentQuestion.getCorrectanswer()) {
                            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                            score++;
                        } else {
                            Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
                        }
                        Img.setImageResource(questionList.get(currentQid).getFimgid());
                        Submit.setText("Next");
                    }
                } else {
                    currentQid++;
                    if (currentQid < questionList.size()) {
                        displayQuestion();
                        next = true;
                        Submit.setText("Submit");
                        selectedAnswer = -1;
                    } else {
                        Toast.makeText(MainActivity.this, "Quiz Finished", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                        intent.putExtra("score", score);
                        startActivity(intent);
                    }
                }
            }
        });


    }

    void loadQuestion(){
        questionList = new ArrayList<>();
        questionList.add(new Quizz(R.drawable.oar1crop,R.drawable.oar1full, 2));
        questionList.add(new Quizz(R.drawable.ore2crop,R.drawable.ore2full, 1));
        questionList.add(new Quizz(R.drawable.ore1crop,R.drawable.ore1full, 1));
        questionList.add(new Quizz(R.drawable.oar2crop,R.drawable.oar2full, 2));
        questionList.add(new Quizz(R.drawable.ore3crop,R.drawable.ore3full, 1));
        questionList.add(new Quizz(R.drawable.oar3crop,R.drawable.oar3full, 2));
    }

    void displayQuestion(){
        Quizz question = questionList.get(currentQid);
        Img.setImageResource(question.getImgid());
    }

}