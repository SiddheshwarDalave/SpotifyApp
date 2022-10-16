public class Song {
    String title;
    double duration;
//constructor
    public Song(String title,double duration) {
        this.title = title;
        this.duration = duration;
    }
// toString used to represent data in object format
// helps to print class song in a string

    @Override
    public String toString() {
        return "Song{" +
                "songName='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
