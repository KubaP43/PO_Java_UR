import javax.swing.*;

public class DodajPilkarzaGUI extends Frame{
    private JTextField imieField;
    private JPanel panel;
    private JTextField nazwiskoField;
    private JButton dodajButton;
    private JButton wrocButton;
    DodajPilkarzaController controller;

    public DodajPilkarzaGUI(Uzytkownik uzytkownik, int druzynaid){
        super("Dodawanie Piłkarza", 300,300);
        this.controller = new DodajPilkarzaController(this,uzytkownik,druzynaid);

        this.dodajButton.addActionListener(e -> controller.Dodaj());
        this.wrocButton.addActionListener(e -> controller.Wroc());

        this.setContentPane(panel);
        this.setVisible(true);
    }

    public String getImie(){
        return this.imieField.getText();
    }

    public String getNazwisko(){
        return this.nazwiskoField.getText();
    }
}
