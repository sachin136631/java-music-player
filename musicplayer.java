import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

class Node{
    String data;
    Node next;
    Node prev;
}

public class musicplayer{
    Node head=null;
    Node tail=null;
    Node temp=null;
    Boolean ispaused=false;
    long clipposition=0;
    int size=0;
    public Node create(String data){
        Node newnode=new Node();
        newnode.data=data;
        head=newnode;
        tail=newnode;
        newnode.next=newnode;
        newnode.prev=newnode;
        size++;
        return head;
    }

    public void insert(String data,int location){
        Node newnode=new Node();
        newnode.data=data;
        temp=head;
        if(head==null){
            create(data);
            return;
        }
        else if(location==0){
            newnode.next=head;
            head.prev=newnode;
            newnode.prev=tail;
            tail.next=newnode;
            head=newnode;
            size++;
            return;

        }
        else if(location>=size){
            tail.next=newnode;
            newnode.prev=tail;
            newnode.next=head;
            head.prev=newnode;
            tail=newnode;
            size++;
            return;
        }

        else{
            for(int i=0;i<location-1;i++){
                temp=temp.next;
            }
            newnode.next=temp.next;
            temp.next.prev=newnode;
            temp.next=newnode;
            newnode.prev=temp;
            size++;
            return;
        }
    }

    public void traversal(){
        
        if(head==null){
            System.out.println("linked list not created yet");
            return;
        }
        else{
            temp=head;
            for(int i=0;i<size;i++){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }System.out.println("\n");
        }
    }

    public void player()throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        Scanner sc= new Scanner(System.in);
        Clip clip1,clip2,clip3;
        File file0 = new File("songs/test.wav");
        AudioInputStream audioStream0 = AudioSystem.getAudioInputStream(file0);
        clip1 = AudioSystem.getClip();
        clip2 = AudioSystem.getClip();
        clip3 = AudioSystem.getClip();
        clip1.open(audioStream0);
        clip2.open(audioStream0);
        clip3.open(audioStream0);
        String response="";
        while(!response.equals("q")){
            System.out.println("enter choice");
            System.out.println(" ");
            System.out.println("|  b - Back  |  p - Play  |  n - Next  |  q - Quit  |");
            response=sc.next();
            switch (response) {
                case("p"):
                    clip1.close();
                    clip2.close();
                    clip3.close();
                    temp=head;
                    File file1 = new File(temp.data);
                    AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(file1);
                    clip1 = AudioSystem.getClip();
                    clip1.open(audioStream1);
                    clip1.start();
                    String l="";
                    while(!l.equals("e")){
                        System.out.println(" ");
                        System.out.println("| a-Play | b-Pause | e-Exit |");
                        l=sc.next();
                        switch (l) {
                            case("b"):
                                 if(clip1!=null && clip1.isRunning()){
                                    clipposition=clip1.getMicrosecondPosition();
                                    clip1.stop();
                                    ispaused=true;
                                 }
                                break;
                            case("a"):
                                 if(clip1!=null && ispaused){
                                    clip1.setMicrosecondPosition(clipposition);
                                    clip1.start();
                                    ispaused=false;
                                 }
                                break;
                            case("e"):
                                break;
                            
                            default:
                                 System.out.println("invalid entry");
                                break;
                        }
                    }
                    break;
                case("n"):
                    clip1.close();
                    clip2.close();
                    clip3.close();
                    temp=temp.next;
                    File file2 = new File(temp.data);
                    AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
                    clip2 = AudioSystem.getClip();
                    clip2.open(audioStream2);
                    clip2.start();
                    String z="";
                    while(!z.equals("e")){
                        System.out.println(" ");
                        System.out.println("| a-Play | b-Pause | e-Exit |");
                        z=sc.next();
                        switch (z) {
                            case("b"):
                                 if(clip2!=null && clip2.isRunning()){
                                    clipposition=clip2.getMicrosecondPosition();
                                    clip2.stop();
                                    ispaused=true;
                                 }
                                break;
                            case("a"):
                                 if(clip2!=null && ispaused){
                                    clip2.setMicrosecondPosition(clipposition);
                                    clip2.start();
                                    ispaused=false;
                                 }
                                break;
                            case("e"):
                                break;
                            
                            default:
                                 System.out.println("invalid entry");
                                break;
                        }
                    }
                    break;
                case("b"):
                    clip1.close();
                    clip2.close();
                    clip3.close();
                    temp=temp.prev;
                    File file3 = new File(temp.data);
                    AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
                    clip3 = AudioSystem.getClip();
                    clip3.open(audioStream3);
                    clip3.start();
                    String t="";
                    while(!t.equals("e")){
                        System.out.println(" ");
                        System.out.println("| a-Play | b-Pause | e-Exit |");
                        t=sc.next();
                        switch (t) {
                            case("b"):
                                 if(clip3!=null && clip3.isRunning()){
                                    clipposition=clip3.getMicrosecondPosition();
                                    clip3.stop();
                                    ispaused=true;
                                 }
                                break;
                            case("a"):
                                 if(clip3!=null && ispaused){
                                    clip3.setMicrosecondPosition(clipposition);
                                    clip3.start();
                                    ispaused=false;
                                 }
                                break;
                            case("e"):
                                break;
                            
                            default:
                                 System.out.println("invalid entry");
                                break;
                        }
                    }
                    break;
                case("q"):
                    break;

                default:
                    System.out.println("invalid entry");
                    break;
            }
        }System.out.println("byee!!!!");

    }

    public void delete(int location){
        if(head==null){
            System.out.println("linked list not created yet");
            return;
        }

        else if(location==0){
            if(size==1){
                head=null;
                tail=null;
                size--;
                return;
            }
            else{
                head=head.next;
                head.prev=tail;
                tail.next=head;
                size--;
                return;
            }
        }

        else if(location>=size){
            tail=tail.prev;
            tail.next=head;
            head.prev=tail;
            size--;
            return;
        }

        else{
            temp=head;
            for(int i=0;i<location-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            temp.next.prev=temp;
            size--;
            return;
        }
    }


    public static void main(String str[])throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        musicplayer key=new musicplayer();
        key.insert("songs/Ambarsariya Fukrey Song By Sona Mohapatra  Pulkit Samrat, Priya Anand.wav",0);
        key.insert("songs/Hozier - Work Song (Official Video).wav",1);
        key.insert("songs/Laal Peeli Akhiyaan (Full Video) Shahid Kapoor,Kriti Sanon,Romy  Teri Baaton Mein Aisa Uljha Jiya.wav",2);
        key.player();

    }
}