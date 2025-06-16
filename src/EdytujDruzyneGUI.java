import javax.swing.*;

public class EdytujDruzyneGUI extends Frame{
    private JTextField textField1;
    private JButton zmieńButton;
    private JList list1;
    private DefaultListModel<Pilkarz> listModel;
    private JButton dodajButton;
    private JButton usunButton;
    private JButton wrocButton;
    private JPanel panel;
    EdytujDruzyneController controller;
    int druzynaid;

    public EdytujDruzyneGUI(Uzytkownik uzytkownik, int druzynaid){
        super("Edytuj Druzynę!", 300, 500);
        this.controller = new EdytujDruzyneController(this,uzytkownik,druzynaid);
        listModel = new DefaultListModel<Pilkarz>();
        this.list1.setModel(listModel);
        this.druzynaid = druzynaid;
        controller.OdswiezListePilkarzy();

        zmieńButton.addActionListener(e -> controller.ZmienNazwe());
        dodajButton.addActionListener(e -> controller.DodajPilkarza());
        wrocButton.addActionListener(e -> controller.Wroc());
        usunButton.addActionListener(e -> controller.UsunPilkarza());

        this.setContentPane(panel);
        this.setVisible(true);

    }

    public String getNazwa(){
        return this.textField1.getText();
    }

    public JList getList(){
        return this.list1;
    }

    public DefaultListModel<Pilkarz> getListModel(){
        return this.listModel;
    }
}
