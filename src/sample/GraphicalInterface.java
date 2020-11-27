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
        headLbl.setLayoutX(230);
        headLbl.setLayoutY(20);
        headLbl.setId("headLbl");

        Button createClubBtn = new Button("Create Club");
        createClubBtn.setLayoutX(800);
        createClubBtn.setLayoutY(170);
        createClubBtn.setId("createClubBtn");

        Button closeBtn = new Button("[X]");
        closeBtn.setLayoutX(880);
        closeBtn.setLayoutY(30);
        closeBtn.setId("closeBtn");

        TextField clubNameTxt = new TextField();
        clubNameTxt.setPromptText("Club Name");
        clubNameTxt.setLayoutX(50);
        clubNameTxt.setLayoutY(170);

        TextField clubLocationTxt = new TextField();
        clubLocationTxt.setPromptText("Club Location");
        clubLocationTxt.setLayoutX(300);
        clubLocationTxt.setLayoutY(170);

        TextField homeGroundTxt = new TextField();
        homeGroundTxt.setPromptText("Home Ground");
        homeGroundTxt.setLayoutX(550);
        homeGroundTxt.setLayoutY(170);

        Label createHead = new Label("Create new Club");
        createHead.setLayoutX(50);
        createHead.setLayoutY(130);
        createHead.setId("createHead");

        Label addMatchHead = new Label("Add a Match");
        addMatchHead.setLayoutX(50);
        addMatchHead.setLayoutY(280);
        addMatchHead.setId("createHead");

        Label divOne = new Label();
        divOne.setPrefHeight(120);
        divOne.setPrefWidth(950);
        divOne.setLayoutY(110);
        divOne.setLayoutX(30);
        divOne.setId("divOne");

        Label divTwo = new Label();
        divTwo.setPrefHeight(450);
        divTwo.setPrefWidth(950);
        divTwo.setLayoutY(260);
        divTwo.setLayoutX(30);
        divTwo.setId("divOne");

        TextField dayTxt = new TextField();
        dayTxt.setLayoutX(50);
        dayTxt.setLayoutY(320);
        dayTxt.setPrefWidth(60);
        dayTxt.setPrefHeight(50);
        dayTxt.setPromptText("dd");
        dayTxt.setId("date");

        TextField monthTxt = new TextField();
        monthTxt.setLayoutX(150);
        monthTxt.setLayoutY(320);
        monthTxt.setPrefWidth(60);
        monthTxt.setPrefHeight(50);
        monthTxt.setPromptText("mm");
        monthTxt.setId("date");


        TextField yearTxt = new TextField();
        yearTxt.setLayoutX(250);
        yearTxt.setLayoutY(320);
        yearTxt.setPrefWidth(80);
        yearTxt.setPrefHeight(50);
        yearTxt.setPromptText("yyyy");
        yearTxt.setId("date");

        Label h1 = new Label("-");
        h1.setLayoutX(120);
        h1.setLayoutY(310);
        h1.setId("hyphen");

        Label h2 = new Label("-");
        h2.setLayoutX(220);
        h2.setLayoutY(310);
        h2.setId("hyphen");

        TextField team1Txt = new TextField();
        team1Txt.setLayoutX(50);
        team1Txt.setLayoutY(400);
        team1Txt.setPrefWidth(150);
        team1Txt.setPrefHeight(50);
        team1Txt.setPromptText("Team Name 1");
        team1Txt.setId("teamTxt");

        TextField team2Txt = new TextField();
        team2Txt.setLayoutX(250);
        team2Txt.setLayoutY(400);
        team2Txt.setPrefWidth(150);
        team2Txt.setPrefHeight(50);
        team2Txt.setPromptText("Team Name 2");
        team2Txt.setId("teamTxt");


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
                Alert alert = new Alert(Alert.AlertType.NONE,"Club Created Successfully", ButtonType.OK);
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
//            output.setText("Testing");
        });


        guiPane.getChildren().addAll(divOne,divTwo,createClubBtn,clubNameTxt,clubLocationTxt,homeGroundTxt,closeBtn,headLbl,createHead,addMatchHead,dayTxt,monthTxt,yearTxt,h1,h2,team1Txt,team2Txt);
        guiScene = new Scene(guiPane,1000,500);
        guiScene.getStylesheets().add(GraphicalInterface.class.getResource("stylesheet.css").toExternalForm());

        guiPane.setId("test");

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
