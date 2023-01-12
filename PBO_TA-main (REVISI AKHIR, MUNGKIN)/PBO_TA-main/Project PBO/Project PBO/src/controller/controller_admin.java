package controller;
import java.util.ArrayList;
import model.model_admin;
import entity.entity_admin;

public class controller_admin {
    public model_admin objadmin = new model_admin();
    public ArrayList<entity_admin> read() {
        return  objadmin.getdata_admin();
    }
    public void create(entity_admin admin) {
        objadmin.create(admin);
    }
    public void delete(int index) {
        objadmin.delete(index);
    }
    public void update(int index, entity_admin admin) {
        objadmin.update(index, admin);
    }

}