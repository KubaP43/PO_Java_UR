import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AplikacjaController {
    private AplikacjaGUI gui;
    private Uzytkownik uzytkownik;

    public AplikacjaController(AplikacjaGUI gui, Uzytkownik uzytkownik){
        this.gui = gui;
        this.uzytkownik = uzytkownik;
    }

    public void OdswiezListeDruzyn(){
        DefaultListModel listModel = gui.GetListModel(); // Pobiera model listy z GUI, który reprezentuje widoczne druzyny

        // Zapytanie pobierające wszystkie druzyny przypisane do zalogowanego użytkownika
        String sql = "SELECT * FROM druzyny WHERE wlasciciel_id=" + uzytkownik.GetId();
        ResultSet rs = BazaDanych.Zapytanie(sql); // Wykonanie zapytania do bazy

        try {
            while (rs.next()) {
                Druzyna druzyna = new Druzyna(rs.getInt("id"),rs.getString("Nazwa"));
                listModel.addElement(druzyna); // Dodanie druzyny do listy w GUI
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void DodajDruzyneObsluga(){
        new DodawanieDruzynyGUI(uzytkownik);
        gui.dispose();
    }

    public void UsunDruzyne(){
        Druzyna druzyna = (Druzyna) gui.GetList().getSelectedValue();

        String sql = "DELETE FROM druzyny WHERE id=" + druzyna.id;
        BazaDanych.Polecenie(sql);
        gui.GetListModel().removeElement(druzyna);
        gui.GetList().repaint();
    }

    public void EdytujDruzyne(){
        Druzyna druzyna = (Druzyna) gui.GetList().getSelectedValue();
        new EdytujDruzyneGUI(uzytkownik,druzyna.id);
        gui.dispose();
    }
}
