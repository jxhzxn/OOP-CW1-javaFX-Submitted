package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class GraphicalInterface {
    public static void display(){

        ArrayList<Integer> intPasser = new ArrayList<>();

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
        headLbl.setLayoutX(650);
        headLbl.setLayoutY(25);
        headLbl.setId("headLbl");

        Button createClubBtn = new Button("Create Club");
        createClubBtn.setLayoutX(800);
        createClubBtn.setLayoutY(170);
        createClubBtn.setId("createClubBtn");

        Button closeBtn = new Button("[X]");
        closeBtn.setLayoutX(1750);
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

        Label viewMatchHead = new Label("View Matches");
        viewMatchHead.setLayoutX(50);
        viewMatchHead.setLayoutY(500);
        viewMatchHead.setId("createHead");

        Label pointsTableHead = new Label("Points Table");
        pointsTableHead.setLayoutX(1020);
        pointsTableHead.setLayoutY(115);
        pointsTableHead.setId("createHead");

        Label matchesHead = new Label("All Played Matches");
        matchesHead.setLayoutX(420);
        matchesHead.setLayoutY(485);
        matchesHead.setId("createHead");

        Label divOne = new Label();
        divOne.setPrefHeight(120);
        divOne.setPrefWidth(950);
        divOne.setLayoutY(110);
        divOne.setLayoutX(30);
        divOne.setId("divOne");

        Label divTwo = new Label();
        divTwo.setPrefHeight(190);
        divTwo.setPrefWidth(950);
        divTwo.setLayoutY(260);
        divTwo.setLayoutX(30);
        divTwo.setId("divOne");

        Label divThree = new Label();
        divThree.setPrefHeight(330);
        divThree.setPrefWidth(350);
        divThree.setLayoutY(480);
        divThree.setLayoutX(30);
        divThree.setId("divOne");

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
        team1Txt.setLayoutX(385);
        team1Txt.setLayoutY(320);
        team1Txt.setPrefWidth(170);
        team1Txt.setPrefHeight(50);
        team1Txt.setPromptText("Club Name");
        team1Txt.setId("teamTxt");

        TextField team2Txt = new TextField();
        team2Txt.setLayoutX(685);
        team2Txt.setLayoutY(320);
        team2Txt.setPrefWidth(170);
        team2Txt.setPrefHeight(50);
        team2Txt.setPromptText("Club Name");
        team2Txt.setId("teamTxt");

        TextField team1Goals = new TextField();
        team1Goals.setLayoutX(565);
        team1Goals.setLayoutY(320);
        team1Goals.setPrefWidth(75);
        team1Goals.setPrefHeight(50);
        team1Goals.setPromptText("Goal");
        team1Goals.setId("teamTxt");

        Label vs = new Label("vs");
        vs.setLayoutX(650);
        vs.setLayoutY(330);
        vs.setId("vs");

        TextField team2Goals = new TextField();
        team2Goals.setLayoutX(865);
        team2Goals.setLayoutY(320);
        team2Goals.setPrefWidth(75);
        team2Goals.setPrefHeight(50);
        team2Goals.setPromptText("Goal");
        team2Goals.setId("teamTxt");

        Button addMatchBtn = new Button("Add Match");
        addMatchBtn.setLayoutX(800);
        addMatchBtn.setLayoutY(390);
        addMatchBtn.setPrefWidth(140);
        addMatchBtn.setPrefHeight(30);
        addMatchBtn.setId("createClubBtn");

        Button randomMatchBtn = new Button("Add Random Match");
        randomMatchBtn.setLayoutX(550);
        randomMatchBtn.setLayoutY(390);
        randomMatchBtn.setPrefWidth(230);
        randomMatchBtn.setPrefHeight(30);
        randomMatchBtn.setId("createClubBtn");

        Button lastMatchBtn = new Button("Show Last Match");
        lastMatchBtn.setLayoutX(50);
        lastMatchBtn.setLayoutY(390);
        lastMatchBtn.setPrefWidth(200);
        lastMatchBtn.setPrefHeight(30);
        lastMatchBtn.setId("createClubBtn");

        Button lastMatchClearBtn = new Button("Clear");
        lastMatchClearBtn.setLayoutX(270);
        lastMatchClearBtn.setLayoutY(390);
        lastMatchClearBtn.setPrefWidth(80);
        lastMatchClearBtn.setPrefHeight(30);
        lastMatchClearBtn.setId("clearBtn");

        Button showMatchBtn = new Button("Show Matches");
        showMatchBtn.setLayoutX(50);
        showMatchBtn.setLayoutY(610);
        showMatchBtn.setPrefWidth(180);
        showMatchBtn.setPrefHeight(30);
        showMatchBtn.setId("createClubBtn");

        Button clearBtn = new Button("Clear");
        clearBtn.setLayoutX(250);
        clearBtn.setLayoutY(610);
        clearBtn.setPrefWidth(80);
        clearBtn.setPrefHeight(30);
        clearBtn.setId("clearBtn");

        Button showAllMatchBtn = new Button("Show All Matches");
        showAllMatchBtn.setLayoutX(50);
        showAllMatchBtn.setLayoutY(750);
        showAllMatchBtn.setPrefWidth(220);
        showAllMatchBtn.setPrefHeight(30);
        showAllMatchBtn.setId("createClubBtn");



        clubNameTxt.setId("textField");
        clubLocationTxt.setId("textField");
        homeGroundTxt.setId("textField");

        TableView<FootballClub> table = new TableView<>();

        TableColumn<FootballClub,String> nameColumn = new TableColumn<>("Club");
        nameColumn.setMinWidth(130);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("clubName"));

        TableColumn<FootballClub,String> locationColumn = new TableColumn<>("Location");
        locationColumn.setMinWidth(130);
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<FootballClub,String> homeGroundColumn = new TableColumn<>("HomeGround");
        homeGroundColumn.setMinWidth(300);
        homeGroundColumn.setCellValueFactory(new PropertyValueFactory<>("homeGround"));

        TableColumn<FootballClub,String> matchesColumn = new TableColumn<>("Matches");
        matchesColumn.setMinWidth(110);
        matchesColumn.setCellValueFactory(new PropertyValueFactory<>("nofMatches"));

        TableColumn<FootballClub,String> goalScoredColumn = new TableColumn<>("GoalsS.");
        goalScoredColumn.setMinWidth(100);
        goalScoredColumn.setCellValueFactory(new PropertyValueFactory<>("nofGoalsScored"));

        TableColumn<FootballClub,String> goalReceivedColumn = new TableColumn<>("GoalsR.");
        goalReceivedColumn.setMinWidth(100);
        goalReceivedColumn.setCellValueFactory(new PropertyValueFactory<>("nofGoalsReceived"));

        TableColumn<FootballClub,String> winsColumn = new TableColumn<>("Wins");
        winsColumn.setMinWidth(80);
        winsColumn.setCellValueFactory(new PropertyValueFactory<>("nofWins"));

        TableColumn<FootballClub,String> drawsColumn = new TableColumn<>("Draws");
        drawsColumn.setMinWidth(80);
        drawsColumn.setCellValueFactory(new PropertyValueFactory<>("nofDraws"));

        TableColumn<FootballClub,String> defeatsColumn = new TableColumn<>("Defeats");
        defeatsColumn.setMinWidth(110);
        defeatsColumn.setCellValueFactory(new PropertyValueFactory<>("nofDefeats"));

        TableColumn<FootballClub,String> pointsColumn = new TableColumn<>("Points");
        pointsColumn.setMinWidth(90);
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("nofPoints"));

        table.setItems(getData());
        table.getColumns().addAll(nameColumn,matchesColumn,goalScoredColumn,goalReceivedColumn,winsColumn,drawsColumn,defeatsColumn,pointsColumn);
        table.setLayoutX(1000);
        table.setLayoutY(160);
        table.setPrefWidth(820);
        table.setPrefHeight(650);
        table.setId("table");


        nameColumn.setId("tableHead");
        locationColumn.setId("tableHead");
        homeGroundColumn.setId("tableHead");
        matchesColumn.setId("tableHead");
        goalScoredColumn.setId("tableHead");
        goalReceivedColumn.setId("tableHead");
        winsColumn.setId("tableHead");
        drawsColumn.setId("tableHead");
        defeatsColumn.setId("tableHead");
        pointsColumn.setId("tableHead");

        nameColumn.setSortable(false);
        locationColumn.setSortable(false);
        homeGroundColumn.setSortable(false);
        matchesColumn.setSortable(false);
        goalScoredColumn.setSortable(false);
        goalReceivedColumn.setSortable(false);
        winsColumn.setSortable(false);
        drawsColumn.setSortable(false);
        defeatsColumn.setSortable(false);
        pointsColumn.setSortable(false);


        TableView<Match> matchTable = new TableView<>();

        TableColumn<Match,String> dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(140);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("DatePrint"));

        TableColumn<Match,String> team1Column = new TableColumn<>("Team1");
        team1Column.setMinWidth(130);
        team1Column.setCellValueFactory(new PropertyValueFactory<>("team1Name"));

        TableColumn<Match,String> team1ScoreColumn = new TableColumn<>("Goals");
        team1ScoreColumn.setMinWidth(80);
        team1ScoreColumn.setCellValueFactory(new PropertyValueFactory<>("team1Score"));

        TableColumn<Match,String> team2Column = new TableColumn<>("Team2");
        team2Column.setMinWidth(130);
        team2Column.setCellValueFactory(new PropertyValueFactory<>("team2Name"));

        TableColumn<Match,String> team2ScoreColumn = new TableColumn<>("Goals");
        team2ScoreColumn.setMinWidth(80);
        team2ScoreColumn.setCellValueFactory(new PropertyValueFactory<>("team2Score"));

//        matchTable.getColumns().addAll(dateColumn,team1Column,team1ScoreColumn,team2Column,team2ScoreColumn);
        matchTable.setLayoutX(400);
        matchTable.setLayoutY(530);
        matchTable.setPrefWidth(580);
        matchTable.setPrefHeight(280);
        matchTable.setId("table");

        dateColumn.setId("tableHead");
        team1Column.setId("tableHead");
        team1ScoreColumn.setId("tableHead");
        team2Column.setId("tableHead");
        team2ScoreColumn.setId("tableHead");

        TextField dayTxt2 = new TextField();
        dayTxt2.setLayoutX(50);
        dayTxt2.setLayoutY(540);
        dayTxt2.setPrefWidth(60);
        dayTxt2.setPrefHeight(50);
        dayTxt2.setPromptText("dd");
        dayTxt2.setId("date");

        TextField monthTxt2 = new TextField();
        monthTxt2.setLayoutX(150);
        monthTxt2.setLayoutY(540);
        monthTxt2.setPrefWidth(60);
        monthTxt2.setPrefHeight(50);
        monthTxt2.setPromptText("mm");
        monthTxt2.setId("date");


        TextField yearTxt2 = new TextField();
        yearTxt2.setLayoutX(250);
        yearTxt2.setLayoutY(540);
        yearTxt2.setPrefWidth(80);
        yearTxt2.setPrefHeight(50);
        yearTxt2.setPromptText("yyyy");
        yearTxt2.setId("date");

        Label h12 = new Label("-");
        h12.setLayoutX(120);
        h12.setLayoutY(530);
        h12.setId("hyphen");

        Label h22 = new Label("-");
        h22.setLayoutX(220);
        h22.setLayoutY(530);
        h22.setId("hyphen");











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
                finalPlm.saveInstance(finalPlm);
                table.setItems(refresh());
                clubNameTxt.clear();
                clubLocationTxt.clear();
                homeGroundTxt.clear();
            }
        });

        closeBtn.setOnAction(event -> {
            //write here
//            finalPlm.saveInstance(finalPlm);
//            System.exit(1);

            matchesHead.setText("Matches Sorted");
            matchTable.getColumns().clear();
            matchTable.setItems(getMatchesSortedDate());
            matchTable.getColumns().addAll(dateColumn,team1Column,team1ScoreColumn,team2Column,team2ScoreColumn);
        });

        clearBtn.setOnAction(event -> {
            dayTxt2.clear();
            monthTxt2.clear();
            yearTxt2.clear();
        });



        showMatchBtn.setOnAction(event -> {
            matchesHead.setText("Matches");
            showAllMatchBtn.setDisable(false);
            matchTable.getColumns().clear();
            showMatchBtn.setDisable(true);
            if(dayTxt2.getText().length()==0 || monthTxt2.getText().length()==0 || yearTxt2.getText().length()==0){
                errorCheck(dayTxt2,monthTxt2,yearTxt2);
            }else{
                matchTable.setItems(getFilteredMatches(Integer.parseInt(dayTxt2.getText()),Integer.parseInt(monthTxt2.getText()),Integer.parseInt(yearTxt2.getText())));
                matchTable.getColumns().addAll(dateColumn,team1Column,team1ScoreColumn,team2Column,team2ScoreColumn);
            }
        });

        showAllMatchBtn.setOnAction(event -> {
            matchesHead.setText("All Played Matches");
            matchTable.getColumns().clear();
            matchTable.setItems(getMatches());
            matchTable.getColumns().addAll(dateColumn,team1Column,team1ScoreColumn,team2Column,team2ScoreColumn);
            showAllMatchBtn.setDisable(true);
            showMatchBtn.setDisable(false);

        });




        lastMatchBtn.setOnAction(event -> {
//            dayTxt.setText(String.valueOf(finalPlm.getPlayedMatches().get(finalPlm.getPlayedMatches().get(0).getDate().getDay())));
//            monthTxt.setText(String.valueOf(finalPlm.getPlayedMatches().get(finalPlm.getPlayedMatches().get(0).getDate().getMonth())));
//            yearTxt.setText(String.valueOf(finalPlm.getPlayedMatches().get(finalPlm.getPlayedMatches().get(0).getDate().getYear())));
            if(finalPlm.getPlayedMatches().size()==0){
                Alert alert = new Alert(Alert.AlertType.NONE,"No Matches have been Played", ButtonType.OK);
                alert.show();
            }else{
                team1Txt.setText(finalPlm.getPlayedMatches().get(finalPlm.getPlayedMatches().size()-1).getTeam1().getClubName());
//                team1Goals.setText(String.valueOf(finalPlm.getPlayedMatches().get(finalPlm.getPlayedMatches().size()-1).getTeam1().getNofGoalsScored()));
                team2Txt.setText(finalPlm.getPlayedMatches().get(finalPlm.getPlayedMatches().size()-1).getTeam2().getClubName());
//                team2Goals.setText(String.valueOf(finalPlm.getPlayedMatches().get(finalPlm.getPlayedMatches().size()-1).getTeam2().getNofGoalsScored()));
                team1Goals.setText(String.valueOf(finalPlm.getPlayedMatches().get(finalPlm.getPlayedMatches().size()-1).getTeam1Score()));
                team2Goals.setText(String.valueOf(finalPlm.getPlayedMatches().get(finalPlm.getPlayedMatches().size()-1).getTeam2Score()));

            }
//            System.out.println(finalPlm.getPlayedMatches().get(finalPlm.getPlayedMatches().get(0).getDate().getDay()));
        });

        lastMatchClearBtn.setOnAction(event -> {
            team1Txt.clear();
            team1Goals.clear();
            team2Txt.clear();
            team2Goals.clear();
            dayTxt.clear();
            monthTxt.clear();
            yearTxt.clear();

            team1Txt.setId("teamTxt");
            team1Goals.setId("teamTxt");
            team2Txt.setId("teamTxt");
            team2Goals.setId("teamTxt");
            dayTxt.setId("teamTxt");
            monthTxt.setId("teamTxt");
            yearTxt.setId("teamTxt");
        });

        int checkYear = Calendar.getInstance().get(Calendar.YEAR);
        int checkMonth = Calendar.getInstance().get(Calendar.MONTH);
        int checkDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);


        addMatchBtn.setOnAction(event -> {
            if(dayTxt.getText().length()==0 || monthTxt.getText().length()==0 || yearTxt.getText().length()==0 || team1Txt.getText().length()==0 || team1Goals.getText().length()==0 || team2Goals.getText().length()==0 || team2Txt.getText().length()==0){
                errorCheck(dayTxt,monthTxt,yearTxt,team1Txt,team1Goals,team2Txt,team2Goals);
            }else if(team1Txt.getText().equals(team2Txt.getText())){
                Alert alert = new Alert(Alert.AlertType.NONE,"Both Teams Can't be the same", ButtonType.OK);
                alert.show();
                team1Txt.clear();
                team2Txt.clear();
                team1Goals.clear();
                team2Goals.clear();
            }else if(Integer.parseInt(yearTxt.getText())>checkYear || Integer.parseInt(monthTxt.getText())>checkMonth || Integer.parseInt(dayTxt.getText())>checkDay){
                Alert alert = new Alert(Alert.AlertType.NONE,"Date cannot be Future", ButtonType.OK);
                alert.show();
                dayTxt.clear();
                monthTxt.clear();
                yearTxt.clear();
            }else{
                Date date = new Date(Integer.parseInt(dayTxt.getText()),Integer.parseInt(monthTxt.getText()),Integer.parseInt(yearTxt.getText()));
                finalPlm.addMatch(team1Txt.getText(),team2Txt.getText(),Integer.parseInt(team1Goals.getText()),Integer.parseInt(team2Goals.getText()),date);
                finalPlm.saveInstance(finalPlm);
                Alert alert = new Alert(Alert.AlertType.NONE,"Match Added Successfully", ButtonType.OK);
                team1Txt.clear();
                team1Goals.clear();
                team2Txt.clear();
                team2Goals.clear();
                dayTxt.clear();
                monthTxt.clear();
                yearTxt.clear();
                alert.show();
                table.setItems(refresh());
                matchTable.setItems(getMatches());
            }

        });

        randomMatchBtn.setOnAction(event -> {
            int team1Name = ThreadLocalRandom.current().nextInt(0, finalPlm.getClubsArray().size());
            int team2Name = ThreadLocalRandom.current().nextInt(0, finalPlm.getClubsArray().size());
            int team1Score = ThreadLocalRandom.current().nextInt(0, 6);
            int team2Score = ThreadLocalRandom.current().nextInt(0, 6);
            int day = ThreadLocalRandom.current().nextInt(1, 32);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
//            int year = ThreadLocalRandom.current().nextInt(20, 32);

            Date randomDate = new Date(day,month,checkYear);

            while(team1Name==team2Name){
                team2Name = ThreadLocalRandom.current().nextInt(0, finalPlm.getClubsArray().size());
            }

            finalPlm.addMatch(finalPlm.getClubsArray().get(team1Name).getClubName(),finalPlm.getClubsArray().get(team2Name).getClubName(),team1Score,team2Score,randomDate);
            finalPlm.saveInstance(finalPlm);
            Alert alert = new Alert(Alert.AlertType.NONE,"Random Match Added Successfully", ButtonType.OK);
            alert.show();
            table.setItems(refresh());
            matchTable.setItems(getMatches());
        });


        guiPane.getChildren().addAll(
                divOne,divTwo,divThree,createClubBtn,clubNameTxt,clubLocationTxt,homeGroundTxt,closeBtn,headLbl,
                createHead,addMatchHead,dayTxt,monthTxt,yearTxt,h1,h2,team1Txt,team2Txt,team1Goals,vs,team2Goals,
                addMatchBtn,lastMatchBtn,lastMatchClearBtn,table,randomMatchBtn,matchTable,showAllMatchBtn,viewMatchHead,
                dayTxt2,monthTxt2,yearTxt2,h12,h22,pointsTableHead,matchesHead,showMatchBtn,clearBtn
        );
        guiScene = new Scene(guiPane,1850,830);
        guiScene.getStylesheets().add(GraphicalInterface.class.getResource("stylesheet.css").toExternalForm());
        window.initStyle(StageStyle.UNIFIED);
        guiPane.setId("test");
        window.setResizable(false);
        window.setScene(guiScene);
        window.show();
    }


//    public static void errorCheck(TextField clubName, TextField location, TextField homeGround){
//        ArrayList<TextField> texts = new ArrayList<>();
//        texts.add(clubName);
//        texts.add(location);
//        texts.add(homeGround);
//        for(int x=0;x<=texts.size()-1;x++){
//            if(texts.get(x).getText().length()==0){
//                texts.get(x).setId("errorField");
//            }else{
//                texts.get(x).setId("textField");
//            }
//        }
//    }

    public static void errorCheck(TextField... textField){
        ArrayList<TextField> texts = new ArrayList<>();
        for(TextField text: textField){
            texts.add(text);
        }

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


    public static ObservableList<FootballClub> getData(){
        PremierLeagueManager plm = new PremierLeagueManager();
        Path filePath = Paths.get("./plm.ser");
        if(Files.exists(filePath)){
            plm = plm.getInstance();
        }else {
            plm = new PremierLeagueManager();
        }
//        plm = plm.getInstance();
        ObservableList<FootballClub> clubs = FXCollections.observableArrayList();
        plm.sortTable();
        for(FootballClub club: plm.getClubsArray()){
            clubs.add(club);
        }
        return clubs;
    }

    public static ObservableList<FootballClub> refresh(){
        PremierLeagueManager plm = new PremierLeagueManager();
        plm = plm.getInstance();
        plm.sortTable();
        ObservableList<FootballClub> clubs = FXCollections.observableArrayList();
        for(FootballClub club: plm.getClubsArray()){
            clubs.add(club);
        }
        return clubs;
    }

    public static ObservableList<Match> getMatches(){
        PremierLeagueManager plm = new PremierLeagueManager();
        Path filePath = Paths.get("./plm.ser");
        if(Files.exists(filePath)){
            plm = plm.getInstance();
        }else {
            plm = new PremierLeagueManager();
        }

        ObservableList<Match> matches = FXCollections.observableArrayList();
        for(Match match: plm.getPlayedMatches()){
            matches.add(match);
        }
        return matches;
    }

    public static ObservableList<Match> getFilteredMatches(int day, int month, int year){
        PremierLeagueManager plm = new PremierLeagueManager();
        Path filePath = Paths.get("./plm.ser");
        if(Files.exists(filePath)){
            plm = plm.getInstance();
        }else {
            plm = new PremierLeagueManager();
        }

        ObservableList<Match> matches = FXCollections.observableArrayList();

        for(Match match: plm.getFilteredMatches(day,month,year)){
            matches.add(match);
        }
        return matches;
    }

    public static ObservableList<Match> getMatchesSortedDate(){
        PremierLeagueManager plm = new PremierLeagueManager();
        Path filePath = Paths.get("./plm.ser");
        if(Files.exists(filePath)){
            plm = plm.getInstance();
        }else {
            plm = new PremierLeagueManager();
        }

        ObservableList<Match> matches = FXCollections.observableArrayList();
        plm.sortTableDate();
        for(Match match: plm.getPlayedMatches()){
            matches.add(match);
        }
        return matches;
    }
}


