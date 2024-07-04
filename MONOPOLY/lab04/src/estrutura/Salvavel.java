package estrutura;

import java.io.*;
import java.util.ArrayList;

public interface Salvavel {
    ArrayList<String> texts = new ArrayList<String>();

    default void salvalog() throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter("MONOPOLY"));
        br.write("This is a report on user actions and choices of answers. Be careful with it!\n\n");
        br.write("******************** USER INPUT ********************\n\n");
        for (String text : texts) {
            br.write(STR."\{text}\n\n");
        }
        br.close();
    }

    static void savewritelog(String text){
        texts.add(text);
    }
}
