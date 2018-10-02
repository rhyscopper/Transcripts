/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transcripts;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Rhys
 */
public class TranscriptsController implements Initializable {

    private Stage stage;   

    @FXML
    private ListView<String> participantsList;
    
    @FXML
    private BorderPane root;
    
    @FXML
    Button loadBtn;
    
    @FXML
    TextArea chatText;
    
    @FXML
    ScrollPane scrollPane;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BorderPane.setMargin(scrollPane, new Insets(0,10,0,10));
       // list view to display all participants 
        final ObservableList<String> participants = FXCollections.observableArrayList();
        participantsList.setItems(participants);
        
        loadBtn.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                FileChooser fch = new FileChooser();
                fch.setInitialDirectory(new File("."));
                File f = fch.showOpenDialog(null);
                if(f != null){
                    String xmlFile = f.getAbsolutePath();
                    Chat chat = ChatParser.parse(xmlFile);
                    participants.clear();
                    participants.add("--- List of Participants ---");
                    List<Participant> listOfParticipants = chat.getParticipants();
                    for(Participant p : listOfParticipants){
                        participants.add(p.getUid()+" ("+p.getName()+")");
                    }
                    List<Paragraph> paragraphs = chat.getParagraphs();
                    for(Paragraph p : paragraphs){
                        String who = p.getWho();
                        List<String> words = p.getWords();
                        String conversation = "";
                        for(String w: words)
                            conversation += w + " ";
                        chatText.appendText(who+": " + conversation + "\n");
                    }
                }
            }
        });
    }
    
        void init(Stage stage) {
        this.stage = stage;
    }
    
}
