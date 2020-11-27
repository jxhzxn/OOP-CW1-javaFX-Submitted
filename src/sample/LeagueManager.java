package sample;

public interface LeagueManager {
    public SportsClub createClub(String clubName,String location,String homeground);
    public void deleteClub(String clubName);
    public void displayStats();
    public void displayTable();
    public void addMatch();
//    public void fileSave();
}
