import javax.swing.*;

public class AplikacjaGUI extends Frame{
    private JList list1;
    private DefaultListModel<Druzyna> listModel;
    private JButton dodajButton;
    private JButton edytujButton;
    private JButton usunButton;
    private JPanel panel;
    private AplikacjaController controller;

    public AplikacjaGUI(Uzytkownik uzytkownik){
        super("Aplikacja Zarządzanie Drużyną",500,500);
        listModel = new DefaultListModel<>();
        list1.setModel(listModel);

        this.controller = new AplikacjaController(this,uzytkownik);
        controller.OdswiezListeDruzyn();

        dodajButton.addActionListener(e -> controller.DodajDruzyneObsluga());
        edytujButton.addActionListener(e -> controller.EdytujDruzyne());
        usunButton.addActionListener(e -> controller.UsunDruzyne());

        this.setContentPane(panel);
        this.setVisible(true);
    }

    public DefaultListModel<Druzyna> GetListModel(){
        return this.listModel;
    }

    public JList GetList(){
        return this.list1;
    }
}
