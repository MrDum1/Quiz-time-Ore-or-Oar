package edu.bpi.quiztime;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView Img;
    LinearLayout Option1,Option2;
    Button Submit;

    List<Quizz> questionList;
    int currentQid = 0;
    int selectedAnswer;

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
                Quizz currentQuestion = questionList.get(currentQid);
                if (selectedAnswer == currentQuestion.getCorrectanswer()){
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
                }

                currentQid++;
                if (currentQid < questionList.size()) {
                    displayQuestion();
                }else {
                    Toast.makeText(MainActivity.this, "Quiz Finished", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    void loadQuestion(){
        questionList = new ArrayList<>();
        questionList.add(new Quizz(R.drawable.oar1crop, 2));
        questionList.add(new Quizz(R.drawable.ore2crop, 1));
        questionList.add(new Quizz(R.drawable.ore1crop, 1));
        questionList.add(new Quizz(R.drawable.oar2crop, 2));
    }

    void displayQuestion(){

        Quizz question = questionList.get(currentQid);
        Img.setImageResource(question.getImgid());
    }
}