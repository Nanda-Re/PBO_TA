package entity;
public class entity_admin extends orang {
    public entity_admin(String nama, String password, int id) {
        super(nama, password, id);
    }
    @Override
    public void setNama(String nama) {
        super.setNama(nama);
    }

    @Override
    public String getNama() {
        return super.getNama();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }
}