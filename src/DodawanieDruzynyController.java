import java.sql.ResultSet;
import java.sql.SQLException;

public class DodawanieDruzynyController {
    DodawanieDruzynyGUI gui;
    Uzytkownik uzytkownik;

    public DodawanieDruzynyController(DodawanieDruzynyGUI gui, Uzytkownik uzytkownik){
        this.gui = gui;
        this.uzytkownik = uzytkownik;
    }

    public void DodajDruzyne(){
        String nazwa = gui.getNazwa();

        if(!nazwa.equals("")){
            if (!CzyIstniejeTakaDruzyna(nazwa)) {
                String sql = "INSERT INTO druzyny(wlasciciel_id, nazwa) VALUES(" + uzytkownik.GetId() + ", '" + nazwa + "');";
                BazaDanych.Polecenie(sql);
                new AplikacjaGUI(uzytkownik);
                gui.dispose();
            }
            else{
                new Komunikat("Taka drużyna już istnieje!");
            }
        }
        else{
            new Komunikat("Podaj nazwe");
        }
    }

    public boolean CzyIstniejeTakaDruzyna(String nazwa){
        String zapytanie = "SELECT * FROM druzyny WHERE nazwa='"+nazwa+"';";
        ResultSet rs = BazaDanych.Zapytanie(zapytanie);

        try {
            if(!rs.isBeforeFirst()){
                return false; // Brak druzyny
            }else{
                return true; // druzyna istnieje
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Wroc(){
        new AplikacjaGUI(uzytkownik);
        gui.dispose();
    }
}
