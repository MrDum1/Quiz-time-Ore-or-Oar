package edu.bpi.quiztime;

public class Quizz {

    private int correctanswer;
    private int imgid;
    private int fimgid;

    public Quizz(int cimgid,int fimgid, int correctanswer){
        this.imgid = cimgid;
        this.fimgid = fimgid;
        this.correctanswer = correctanswer;
    }

    public int getImgid() {
        return imgid;
    }

    public int getFimgid() {
        return fimgid;
    }

    public int getCorrectanswer() {
        return correctanswer;
    }
}
