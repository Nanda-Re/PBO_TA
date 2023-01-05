package model;
import java.util.ArrayList;
import entity.entity_mobil;

public class model_mobil implements model_interface {
    private ArrayList<entity_mobil> data_mobil;
    public model_mobil() {
        data_mobil = new ArrayList<>();
    }
    public ArrayList<entity_mobil> getData_mobil(){
        return data_mobil;
    }
    public void  read()
    {

    }
    public void create(Object x ) {
        data_mobil.add((entity_mobil) x);
    }
    public void update(int index, Object x) {
        data_mobil.set(index, (entity_mobil) x);
    }
    public void delete(int index) {
        data_mobil.remove(index);
    }

}