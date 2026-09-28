package edu.bpi.quiztime;

public class Quizz {

    private int correctanswer;
    private int imgid;

    public Quizz(int imgid, int correctanswer){
        this.imgid = imgid;
        this.correctanswer = correctanswer;
    }

    public int getImgid() {
        return imgid;
    }

    public int getCorrectanswer() {
        return correctanswer;
    }
}
