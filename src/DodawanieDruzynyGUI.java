import javax.swing.*;

public class DodawanieDruzynyGUI extends Frame{
    private JTextField textField1;
    private JButton dodajButton;
    private JButton wrocButton;
    private JPanel panel;
    Uzytkownik uzytkownik;
    DodawanieDruzynyController controller;

    public DodawanieDruzynyGUI(Uzytkownik uzytkownik){
        super("Dodawanie Druzyny", 300,300);
        this.uzytkownik = uzytkownik;
        this.controller = new DodawanieDruzynyController(this, uzytkownik);

        dodajButton.addActionListener(e -> controller.DodajDruzyne());
        wrocButton.addActionListener(e -> controller.Wroc());

        this.setContentPane(panel);
        this.setVisible(true);
    }

    public String getNazwa(){
        return this.textField1.getText();
    }
}
