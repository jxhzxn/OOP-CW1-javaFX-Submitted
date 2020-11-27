package sample;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GraphicalInterface {
    public static void display(){

        Path filePath = Paths.get("./plm.ser");

        PremierLeagueManager plm = new PremierLeagueManager();

        if(Files.exists(filePath)){
            plm = plm.getInstance();
        }else {
            plm = new PremierLeagueManager();
        }

//        PremierLeagueManager guiPlm = guiPlm;


        Stage window = new Stage();
        Scene guiScene;
        Pane guiPane = new Pane();
        window.setTitle("Premiere League Manager");

        Label headLbl = new Label("Premiere League Manager");
        headLbl.setLayoutX(260);
        headLbl.setLayoutY(30);
        headLbl.setId("headLbl");

        Button createClubBtn = new Button("Create Club");
        createClubBtn.setLayoutX(800);
        createClubBtn.setLayoutY(150);
        createClubBtn.setId("createClubBtn");

        Button closeBtn = new Button("[X]");
        closeBtn.setLayoutX(880);
        closeBtn.setLayoutY(30);
        closeBtn.setId("closeBtn");

        TextField clubNameTxt = new TextField();
        clubNameTxt.setPromptText("Club Name");
        clubNameTxt.setLayoutX(50);
        clubNameTxt.setLayoutY(150);

        TextField clubLocationTxt = new TextField();
        clubLocationTxt.setPromptText("Club Location");
        clubLocationTxt.setLayoutX(300);
        clubLocationTxt.setLayoutY(150);

        TextField homeGroundTxt = new TextField();
        homeGroundTxt.setPromptText("Home Ground");
        homeGroundTxt.setLayoutX(550);
        homeGroundTxt.setLayoutY(150);

        clubNameTxt.setId("textField");
        clubLocationTxt.setId("textField");
        homeGroundTxt.setId("textField");

        PremierLeagueManager finalPlm = plm;
        createClubBtn.setOnAction(event -> {
//            PremierLeagueManager testPlm = finalPlm;
            String clubName = clubNameTxt.getText();
            String location = clubLocationTxt.getText();
            String homeGround = homeGroundTxt.getText();
            if(clubName.length()==0 || location.length()==0 || homeGround.length()==0){
                errorCheck(clubNameTxt,clubLocationTxt,homeGroundTxt);
            }else{
                backToNormal(clubNameTxt,clubLocationTxt,homeGroundTxt);
                Alert alert = new Alert(Alert.AlertType.NONE,"Club Created", ButtonType.OK);
                alert.show();
                finalPlm.createClub(clubName,location,homeGround);
                clubNameTxt.clear();
                clubLocationTxt.clear();
                homeGroundTxt.clear();
            }
        });

        closeBtn.setOnAction(event -> {
                finalPlm.saveInstance(finalPlm);
                System.exit(1);
        });


        guiPane.getChildren().addAll(createClubBtn,clubNameTxt,clubLocationTxt,homeGroundTxt,closeBtn,headLbl);
        guiScene = new Scene(guiPane,1000,500);
        guiScene.getStylesheets().add(GraphicalInterface.class.getResource("stylesheet.css").toExternalForm());

        window.setScene(guiScene);
        window.show();
    }


    public static void errorCheck(TextField clubName, TextField location, TextField homeGround){
        ArrayList<TextField> texts = new ArrayList<>();
        texts.add(clubName);
        texts.add(location);
        texts.add(homeGround);
        for(int x=0;x<=texts.size()-1;x++){
            if(texts.get(x).getText().length()==0){
                texts.get(x).setId("errorField");
            }else{
                texts.get(x).setId("textField");
            }
        }
    }

    public static void backToNormal(TextField clubName, TextField location, TextField homeGround){
        ArrayList<TextField> texts = new ArrayList<>();
        texts.add(clubName);
        texts.add(location);
        texts.add(homeGround);
        for(int x=0;x<=texts.size()-1;x++){
            texts.get(x).setId("textField");
        }
    }
}
