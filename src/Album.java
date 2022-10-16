import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String title;
    String artist;
    ArrayList<Song> songs;// here Song is class act like object in reference variable
    // this has to be initialized in constructor

    public Album(String songName, String artist) {
        this.title = songName;
        this.artist = artist;
        //now how to declare Song class here as this.Songs=song or different //it is reference variable
        //understand the logic from line 6 to below written code // calling object in constructor
        this.songs=new ArrayList<>();
    }
    public Song findSong(String title){
        for(Song checkSong: songs){// here in for each Song is data type and checkSong variable and songs is arrayList
            if((checkSong.title).equals(title)){
                System.out.println("Song Present");
                return checkSong;
            }
        }
        return null;
    }
    public void AddSong(Song songWithTitleToAdd){//object ch ahe ha
         if(findSong(songWithTitleToAdd.title)==null){
             songs.add(songWithTitleToAdd);
         }else{
             System.out.println("Song is already present");
         }
    }
    public void AddSong(String title, double duration){//add song with this details if user provide
        if(findSong(title)==null){
       // Song s1=new Song(title,duration); // this too correct
            // this.songs.add(s1);
            // in one line correct answer
            this.songs.add(new Song(title,duration));//added object
        }else{
            System.out.println("Song is already present");
        }
    }
    public boolean addToPlayList(int trackNo, LinkedList<Song> playList){ // add song in playlist(Linkedlist type) to this position
        int index=trackNo-1;
        if(index>=0 && index<=songs.size()){
            playList.add(this.songs.get(index));
            return true;
        }
        return false;
    }
    public boolean addToPlayList(String title, LinkedList<Song> playList){ // add song in playlist(Linkedlist type) to this position
        for(Song checkSong: songs){
            if(checkSong.title==title){
                playList.add(checkSong);
                return true;
            }
        }
        return false;
    }
}
