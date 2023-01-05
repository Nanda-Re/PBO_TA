package controller;
import entity.entity_mobil;
import model.model_mobil;
import java.util.ArrayList;

public class controller_mobil {
    public model_mobil objmobil = new model_mobil();
    public ArrayList<entity_mobil> read() {
        return  objmobil.getData_mobil();
    }
    public void create(entity_mobil mobil) {
        objmobil.create(mobil);
    }
    public void delete(int index) {
        objmobil.delete(index);
    }
    public void update(int index, entity_mobil mobil) {
        objmobil.update(index, mobil);
    }
}
