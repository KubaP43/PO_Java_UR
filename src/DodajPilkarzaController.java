public class DodajPilkarzaController {
    DodajPilkarzaGUI gui;
    Uzytkownik uzytkownik;
    int druzyna;

    public DodajPilkarzaController(DodajPilkarzaGUI gui, Uzytkownik uzytkownik, int druzyna){
        this.gui = gui;
        this.uzytkownik = uzytkownik;
        this.druzyna = druzyna;
    }

    public void Dodaj(){
        String imie = gui.getImie();
        String nazwisko = gui.getNazwisko();

        if(!imie.equals("") && !nazwisko.equals("")){
            String sql = "INSERT INTO pilkarze(imie,nazwisko,druzynaid) VALUES('" + imie + "','" + nazwisko + "'," + druzyna + ");";
            BazaDanych.Polecenie(sql);
            new AplikacjaGUI(uzytkownik);
            gui.dispose();
        }else{
            new Komunikat("Podaj Wszystkie Dane!");
        }
    }

    public void Wroc(){
        new AplikacjaGUI(uzytkownik);
        gui.dispose();
    }
}
