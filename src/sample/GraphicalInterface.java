package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GraphicalInterface {
    public static void display(){

        Path filePath = Paths.get("./plm.ser");

        PremierLeagueManager plm = new PremierLeagueManager();

        if(Files.exists(filePath)){
            plm = plm.getInstance();
        }else {
            plm = new PremierLeagueManager();
        }

        PremierLeagueManager guiPlm = plm;


        Stage window = new Stage();
        Scene guiScene;
        Pane guiPane = new Pane();
        window.setTitle("Premiere League Manager");

        Button createClubBtn = new Button("Create a Club");
        createClubBtn.setLayoutX(100);
        createClubBtn.setLayoutY(50);

        TextField clubNameTxt = new TextField();
        clubNameTxt.setLayoutX(100);
        clubNameTxt.setLayoutY(200);

        TextField clubLocationTxt = new TextField();
        clubLocationTxt.setLayoutX(100);
        clubLocationTxt.setLayoutY(300);

        TextField homeGroundTxt = new TextField();
        homeGroundTxt.setLayoutX(100);
        homeGroundTxt.setLayoutY(400);


        createClubBtn.setOnAction(event -> {
            guiPlm.displayTable();
        });


        guiPane.getChildren().addAll(createClubBtn,clubNameTxt,clubLocationTxt,homeGroundTxt);
        guiScene = new Scene(guiPane,500,500);

        window.setScene(guiScene);
        window.show();
    }
}
