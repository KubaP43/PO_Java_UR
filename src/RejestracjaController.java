import java.sql.ResultSet;
import java.sql.SQLException;

public class RejestracjaController {
    private RejestracjaGUI gui;

    public RejestracjaController(RejestracjaGUI gui){
        this.gui = gui;
    }

    public void Zarejestuj(){
        String login = gui.GetLogin();
        String haslo = gui.GetPassword();

        if(!login.equals("") && !haslo.equals("")){

            if(!CzyIstniejeTakiUzytkownik(login)){
                // Wstawia nowego użytkownika do bazy danych
                String sql = "INSERT INTO klienci(login,haslo) VALUES('" + login + "','" + haslo + "');";
                BazaDanych.Polecenie(sql);

                new LoginGUI();
                new Komunikat("Konto zostało utworzone pomyślnie!");
                gui.dispose();
            }
            else{
                new Komunikat("Konto o tym loginie już istnieje!");
            }
        }
        else{
            new Komunikat("Żadne pole nie może być puste");
        }
    }

    // Sprawdza, czy w bazie istnieje użytkownik o podanym loginie
    public boolean CzyIstniejeTakiUzytkownik(String login){
        String zapytanie = "SELECT * FROM klienci WHERE login='"+login+"';";
        ResultSet rs = BazaDanych.Zapytanie(zapytanie);

        try {
            if(!rs.isBeforeFirst()){
                return false; // Brak użytkownika
            }else{
                return true; // Użytkownik istnieje
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Wroc(){
        new LoginGUI(); // Powrót do okna logowania
        gui.dispose();
    }
}
