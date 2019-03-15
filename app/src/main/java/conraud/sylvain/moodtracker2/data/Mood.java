package conraud.sylvain.moodtracker2.data;

public class Mood {

    private String comment;
    private int mood = 3;

    public Mood(String comment, int mood) {
        this.comment = comment;
        this.mood = mood;
    }

    public String getComment() {
        return comment;
    }

    public int getMood() {
        return mood;
    }


}

