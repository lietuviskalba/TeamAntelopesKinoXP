package domain;
/**
 * Created by ADMIN on 18/09/2017.
 */
public class Movie {

    private String title, director, des;
    private int duration;

    public Movie(String title, String director, String des, int duration) {
        this.title = title;
        this.director = director;
        this.des = des;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDirector(){ return director; }

    public void setDirector(String director){
        this.director = director; }

    public int getDuration(){ return duration; }

    public void setDuration(int duration){ this.duration = duration; }


}
