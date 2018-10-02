
package transcripts;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rhys
 */
public class Paragraph {
    
    private String who;
    private String id;
    private List<String> words;
    
    public Paragraph(String who, String id){
        this.who = who;
        this.id = id;
        words = new ArrayList<String>();
    }
    
    public void addWord(String w){
        words.add(w);
    }

    public String getWho() {
        return who;
    }

    public String getId() {
        return id;
    }

    public List<String> getWords() {
        return words;
    }
}
