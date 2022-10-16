import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("Album1", "AC/AD");
        album.AddSong("Song1", 1.10);
        album.AddSong("Song2", 2.20);
        album.AddSong("Song3", 3.30);
        albums.add(album);

        album = new Album("Album2", "Eminem");
        album.AddSong("Song4", 2.10);
        album.AddSong("Song5", 3.20);
        album.AddSong("Song6", 4.30);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Song1", playList_1);
        albums.get(0).addToPlayList("Song2", playList_1);
        albums.get(1).addToPlayList("Song4", playList_1);
        albums.get(1).addToPlayList("Song5", playList_1);
        play(playList_1);

    }

    public static void play(LinkedList<Song> playList_1) {
        Scanner sc = new Scanner(System.in);
        boolean quite = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList_1.listIterator();
        if (playList_1.size() > 0) {
            System.out.println("Now playing the song" + listIterator.next().toString());
            printMenu();
        } else {
            System.out.println("PlayList is empty");
        }
        while (!quite) {
            int option = sc.nextInt();
            switch (option) {
                case 0://quite
                    System.out.println("Thanks for Listening");
                    quite = true;
                    break;

                case 1:// forward
                        if(!forward){
                            if(listIterator.hasNext()){
                                listIterator.next();
                            }
                            forward=true;
                        }
                        if(listIterator.hasNext()){
                            System.out.println("You are listing"+listIterator.next().toString());
                        }else{
                            System.out.println("You are at Last song");
                            forward=true;
                        }
                    break;

                case 2://prev
                    if(forward==true){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("You are listing"+listIterator.previous().toString());
                    }else{
                        System.out.println("You are at first song");
                        forward=false;
                    }

                    break;

                case 3://Repeat
                    if(forward==true){
                        System.out.println("You are listing"+listIterator.previous().toString());
                        forward=false;
                    }else{
                        System.out.println("You are listing"+listIterator.next().toString());
                        forward=true;
                    }
                    break;

                case 4://print all
                    printAllSong(playList_1);
                    break;

                case 5:// available options
                    printMenu();
                    break;

                case 6: // delete song
                    if(playList_1.size()>0){
                        listIterator.remove();
                    }
                    if(listIterator.hasNext()){
                        System.out.print("Now playing"+listIterator.next().toString());
                    }
                    if(listIterator.hasPrevious()){
                        System.out.print("Now playing"+listIterator.previous().toString());
                    }
                    break;

                default:
                    System.out.println("Wrong input!!!");
                    printMenu();
                    break;

            }

        }
    }

    public static void printMenu() {
        System.out.println("Available options are\n press");
        System.out.println("0 - to Quite\n" +
                "1 - Play Next Song\n" +
                "2 - Play Previous Song\n" +
                "3 - Repeat Song\n" +
                "4 - List of All Songs\n" +
                "5 - Print all available options\n" +
                "6 - Delete current Song\n");
    }
    public static void printAllSong(LinkedList<Song> playList){
        ListIterator<Song>listIterator=playList.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
    }
}