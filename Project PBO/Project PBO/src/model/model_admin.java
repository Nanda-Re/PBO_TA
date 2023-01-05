package model;
import entity.entity_admin;

import java.util.ArrayList;

public class model_admin implements model_interface{
    private ArrayList<entity_admin> data_admin;
    public model_admin () {
        data_admin =new ArrayList<>();
    }
    public ArrayList<entity_admin> getdata_admin() {
        return data_admin;
    }

    @Override
    public void read() {

    }

    public void create(Object x ) {
        data_admin.add((entity_admin) x);
    }

    public void update(int index, Object x) {
        data_admin.set(index, (entity_admin) x);
    }

    public void delete(int index) {
        data_admin.remove(index);
    }
}
