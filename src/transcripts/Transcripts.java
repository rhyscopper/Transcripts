/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transcripts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;  
/**
 *
 * @author Rhys
 */
public class Transcripts extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewTranscripts.fxml"));
        Parent root = loader.load();
        
        TranscriptsController controller = (TranscriptsController)loader.getController();
        
        controller.init(primaryStage);
        
        Scene scene = new Scene(root); 
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
    
}