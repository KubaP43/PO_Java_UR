public class Uzytkownik {
    private String login,haslo;
    private int id;

    public Uzytkownik(int id, String login, String haslo){
        this.id = id;
        this.login = login;
        this.haslo = haslo;
    }

    public String GetLogin(){
        return this.login;
    }

    public int GetId(){
        return this.id;
    }

}
