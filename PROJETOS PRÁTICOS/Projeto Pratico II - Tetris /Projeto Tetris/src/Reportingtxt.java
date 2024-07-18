import Matrix.Color;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public interface Reportingtxt {
    ArrayList<Color[][]> texts = new ArrayList<>();
    ArrayList<Integer> scores = new ArrayList<Integer>();

    static void reportlog() throws IOException {
        BufferedWriter gametxt = new BufferedWriter(new FileWriter("TETRIS"));
        gametxt.write("This is a report on the game!");
        for(int i =0; i<texts.size();i++) {
            //for(int j=0; j< (texts.get(i)).si)
            //Color[][] text1 = text;
            gametxt.write(STR."\n\nThis current game score is: \{scores.get(i)}\n");
            gametxt.write(Arrays.deepToString((texts.get(i))));

            //gametxt.write(Integer.toString());

        }
        gametxt.close();
    }

    static void gamelog(Color[][] text){
        texts.add(text);
    }

    static void gamescorelog(int score){
        scores.add(score);
    }
}
