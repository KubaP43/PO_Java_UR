public class Pilkarz {
    int id;
    String imie,nazwisko;

    public Pilkarz(int id,String imie, String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
    }

    @Override
    public String toString(){
        return this.imie + " " + this.nazwisko;
    }
}
