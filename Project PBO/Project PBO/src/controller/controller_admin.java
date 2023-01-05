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
    public void data_admin() {
        String[] nama = {"wahyu", "nanda" , "teguh"};
        String[] password = {"qwe" , "asd" , "zxc"};
        int[] id = {001,002,003};


        for(int i=0; i<objadmin.getdata_admin().size(); i++)
        {
            objadmin.create(new entity_admin(nama[i],password[i],id[i]));
        }
    }
}