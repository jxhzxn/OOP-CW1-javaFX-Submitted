package sample;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Path filePath = Paths.get("./plm.ser");

        PremierLeagueManager plm = new PremierLeagueManager();

        if(Files.exists(filePath)){
            plm = plm.getInstance();
        }else {
            plm = new PremierLeagueManager();
        }
//            plm.consoleRun();
//            int option = input.nextInt();
//            if(option==0){
//                System.out.println("");
//                System.out.println("Byee...");
//                plm.saveInstance(plm);
//                System.exit(1);
//            }else if(option==1){
//                System.out.println(" ");
//                System.out.println("Create a Football Club  :   1");
//                System.out.println("Create a University Football Club :   2");
//                System.out.println("Create a School Football Club  :   3");
//                System.out.println(" ");
//                System.out.print("Which Club you want to create?    :   ");
//                int choice = input.nextInt();
//                    if(choice==1){
//                        plm.createClub();
//                    }else if(choice==2){
//                        //Create Uni Club
//                    }else if(choice==3){
//                        //Create School Club
//                    }
//            }else if(option==2){
//                Scanner sc = new Scanner(System.in);
//                System.out.println(" ");
//                System.out.print("Enter the Club Name to Delete   :   ");
//                String deleteThis = sc.nextLine();
//                plm.deleteClub(deleteThis);
//            }else if(option==3){
//                plm.displayStats();
//            }else if(option==4){
//                plm.displayTable();
//            }else if(option==5){
//                plm.addMatch();
//            }
//        }
//        if(plm.decide().equals("y")){
//            plm.consoleRun();
//        }else{
//            System.out.println("");
//            System.out.println("Byee...");
//            plm.saveInstance(plm);
//            System.exit(1);
//        }


        plm.consoleRun();

        int option = 9;

        try{
            while(option!=0){
                option = input.nextInt();
                if(option==1){
                    plm.createClub();
                }else if(option==2){
                    Scanner sc = new Scanner(System.in);
                    System.out.println(" ");
                    System.out.print("Enter the Club Name to Delete   :   ");
                    String deleteThis = sc.nextLine();
                    plm.deleteClub(deleteThis);
                }else if(option==4){
                    plm.displayTable();
                }else if(option==5){
                    plm.addMatch();
                }else if(option==3){
                    plm.displayStats();
                }else if(option==0){
                    System.out.println("");
                    System.out.println("Byee...");
                    plm.saveInstance(plm);
                    System.exit(1);
                }
                    if(plm.decide().equals("y")){
                        plm.consoleRun();
                    }else{
                        System.out.println("");
                        System.out.println("Byee...");
                        plm.saveInstance(plm);
                        System.exit(1);
                    }
            }
        }catch (InputMismatchException e){
            System.out.println("Input only Integers");
        }
        System.out.println("");
        System.out.println("Byee...");
        plm.saveInstance(plm);
        System.exit(1);
    }
}
