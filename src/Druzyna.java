public class Druzyna {
    int id, id_wlasciciela;
    String nazwa;

    public Druzyna(int id, String nazwa){
        this.id = id;
        this.nazwa = nazwa;
    }

    @Override
    public String toString(){
        return this.nazwa;
    }

}
