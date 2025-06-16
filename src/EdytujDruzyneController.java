import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EdytujDruzyneController {
    EdytujDruzyneGUI gui;
    Uzytkownik uzytkownik;
    int druzynaid;

    public EdytujDruzyneController(EdytujDruzyneGUI gui, Uzytkownik uzytkownik, int druzynaid){
        this.gui = gui;
        this.uzytkownik = uzytkownik;
        this.druzynaid = druzynaid;
    }

    public void ZmienNazwe(){
        String nazwa = gui.getNazwa();
        if(!nazwa.equals("")){
            String sql = "UPDATE druzyny SET nazwa='" + nazwa + "' WHERE id=" + druzynaid;
            BazaDanych.Polecenie(sql);
            new AplikacjaGUI(uzytkownik);
            gui.dispose();
        }
        else{
            new Komunikat("Podaj nazwe!");
        }
    }

    public void DodajPilkarza(){
        new DodajPilkarzaGUI(uzytkownik,druzynaid);
        gui.dispose();
    }

    public void UsunPilkarza(){
        Pilkarz pilkarz = (Pilkarz) gui.getList().getSelectedValue();

        String sql = "DELETE FROM pilkarze WHERE id=" + pilkarz.id;
        BazaDanych.Polecenie(sql);
        gui.getListModel().removeElement(pilkarz);
        gui.getList().repaint();
    }

    public void Wroc(){
        new AplikacjaGUI(uzytkownik);
        gui.dispose();
    }

    public void OdswiezListePilkarzy(){
        DefaultListModel listModel = gui.getListModel(); // Pobiera model listy z GUI, który reprezentuje pilkarzy

        // Zapytanie pobierające wszystkich pilkarzy przypisanych do druzyny
        String sql = "SELECT * FROM pilkarze WHERE druzynaid=" + druzynaid;
        ResultSet rs = BazaDanych.Zapytanie(sql); // Wykonanie zapytania do bazy

        try {
            while (rs.next()) {
                Pilkarz pilkarz = new Pilkarz(rs.getInt("id"),rs.getString("imie"), rs.getString("nazwisko"));
                listModel.addElement(pilkarz); // Dodanie pilkarza do listy w GUI
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
