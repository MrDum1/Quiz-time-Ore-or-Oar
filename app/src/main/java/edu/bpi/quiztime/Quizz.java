package edu.bpi.quiztime;

public class Quizz {

    private int correctanswer;
    private int imgid;
    private int fimgid;
    private int himgid;

    public Quizz(int cimgid,int fimgid,int himgid, int correctanswer){
        this.imgid = cimgid;
        this.himgid = himgid;
        this.fimgid = fimgid;
        this.correctanswer = correctanswer;
    }

    public int getImgid() {
        return imgid;
    }

    public int getFimgid() {
        return fimgid;
    }

    public int getHimgid() {
        return himgid;
    }

    public int getCorrectanswer() { return correctanswer; }


}
