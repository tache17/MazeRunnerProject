import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Leaderboard {

    public static class Entry {
        public final String name;
        public int pos;
        public int time;
    
        Entry(int pos, String name, int time) {
            this.name = name;
            this.pos = pos;
            this.time = time;
        }

        @Override
        public String toString() {
            return pos + " " + name + " " + time;
        }
    }

    private static ArrayList<Entry> entries = new ArrayList<>();


    public static void newEntry(String name, int time) {
        for(int i = 0; i < entries.size(); i++) {
            if(entries.get(i).name.equals(name)) {
                if (entries.get(i).time <= time) {
                    return;
                }

                entries.remove(i);
                break;
            }
        }

        for(int i = 0; i < entries.size(); i++){
            if(entries.get(i).time > time){
                entries.add(i, new Entry(i + 1, name, time));
                break;
            }
        }

        for(int i = 0; i < entries.size(); i++){
            entries.get(i).pos = i + 1;
        }
    }

    private static File getFile() {
        return new File("MazeRunnerProject/leaderboard.txt");
    }

    public static void read() {
        if(entries != null) {
            entries.clear();
        }
        try (Scanner rdr = new Scanner(getFile())) {
            rdr.nextLine();
            while(rdr.hasNext()) {
                Entry e = new Leaderboard.Entry(Integer.parseInt(rdr.next()), rdr.next(), Integer.parseInt(rdr.next()));
                entries.add(e);
            }
            rdr.close();
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    
    public static void write() {
        try (FileWriter wrt = new FileWriter(getFile())) {
            wrt.write("");  // clear file
            for (Entry entry : entries) {
                wrt.append(entry.toString());
                wrt.append("\n");
            }

            wrt.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        Leaderboard.read();
        Leaderboard.newEntry("Vasco", 312);
        Leaderboard.write();
    }


}
