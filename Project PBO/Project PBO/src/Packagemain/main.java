package Packagemain;

import controller.controller_admin;
import controller.controller_mobil;
import entity.entity_admin;
import entity.entity_mobil;

import java.util.Scanner;

class classadmin {
    controller_admin admin = new controller_admin();
    Scanner input = new Scanner(System.in);
    void create(){
            admin.create(new entity_admin("WAHYU","sda", 101));
            admin.create(new entity_admin("NANDA", "sby", 102));
            admin.create(new entity_admin("TEGUH", "grs", 103));
            admin.create(new entity_admin("SATRIA", "dar", 104));
    }

    void read() {
        if (admin.objadmin.getdata_admin().size() > 0) {
            int nomorurut = 0;
            System.out.println("<<<<< DATA ADMIN >>>>>");
            for (int i = 0; i < admin.objadmin.getdata_admin().size(); i++) {
                nomorurut++;
                System.out.println("index ke "+nomorurut);
                System.out.println("Nama = "+ admin.objadmin.getdata_admin().get(i).getNama());
                System.out.println("Password = "+ admin.objadmin.getdata_admin().get(i).getPassword());
                System.out.println("ID = " + admin.objadmin.getdata_admin().get(i).getId());
                System.out.println("=======================");
                System.out.println(" ");
            }
        } else {
            System.out.println("Data tidak ada");
        }
    }
    void update() {
        if(admin.objadmin.getdata_admin().size()>0)
        {
            int nomor;
            read();
            System.out.println("Pilih index admin yang ingin diubah : ");
            nomor = input.nextInt();
            System.out.print("Masukkan nama baru : ");
            String Nama = input.next();
            System.out.print("Masukkan password baru : ");
            String Password = input.next();
            System.out.print("Masukkan id baru : ");
            int id = input.nextInt();
            input.nextLine();

            admin.update(nomor-1, new entity_admin(Nama,Password,id));
            System.out.println("Data Admin pada index tersebut telah diubah");
        } else {
            System.out.println("Data kosong");
        }
    }
    void delete(){
        if(admin.objadmin.getdata_admin().size()>0)
        {
            read();
            int nomor;
            System.out.println("pilih index admin yang ingin dihapus ");
            nomor = input.nextInt();

            admin.delete(nomor-1);
            System.out.println("Data berhasil dihapus ");
        } else {
            System.out.println("Data kosong");
        }
    }

    void login() {
        classmobil mobil = new classmobil();
        mobil.create();
        System.out.println("Input Id : ");
        int id = input.nextInt();
        System.out.println("Input Pass : ");
        String password = input.next();
        boolean cekLogin = false;
        for (int i = 0; i < admin.objadmin.getdata_admin().size(); i++) {
            if (id == admin.objadmin.getdata_admin().get(i).getId() && password.equals(admin.objadmin.getdata_admin().get(i).getPassword()))
            {
                cekLogin = true;
            }
        }
        if (cekLogin) {
            System.out.println("Haloooo USER");
            int pilih;
            do {
                System.out.println();
                System.out.println("<<< USER LOGGED IN >>>");
                System.out.println("1. Update admin");
                System.out.println("2. Hapus admin");
                System.out.println("3. Menu mobil");
                System.out.println("0. Back");
                System.out.println("Pilih: ");
                pilih = input.nextInt();

                switch (pilih) {
                    case 1 -> update();
                    case 2 -> delete();
                    case 3 -> mobil.menumobil();
                }
            } while (pilih != 0);
        }
    }

    void menu() {
        classmobil mobil = new classmobil();
        mobil.create();
        int pilih;
        do {
            System.out.println();
            System.out.println("<<< Menu Admin >>>");
            System.out.println("1. Lihat admin");
            System.out.println("2. LOGIN");
            System.out.println("0. Back");
            System.out.println("Pilih: ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1 -> read();
                case 2 -> login();
            }
        } while (pilih != 0);
    }
}
class classmobil {
    controller_mobil mobil = new controller_mobil();
    Scanner input = new Scanner(System.in);
    void create() {
        mobil.create(new entity_mobil("Brio","LCGC", 120000000));
        mobil.create(new entity_mobil("Aventador", "Hyper Car", 2000000000));
        mobil.create(new entity_mobil("F1", "Track Car", 80000000));
        mobil.create(new entity_mobil("Avanza","MPV", 90000000));
        mobil.create(new entity_mobil("Mazda", "Hatchback", 1000000000));
        mobil.create(new entity_mobil("Koenieseg", "Hyper Car", 200000000));
    }
    void read() {
        if (mobil.objmobil.getData_mobil().size() > 0) {
            int nomorurut = 0;
            System.out.println("<<<<< DATA MOBIL >>>>>");
            for (int i = 0; i < mobil.objmobil.getData_mobil().size(); i++) {
                nomorurut++;
                System.out.println("index ke "+nomorurut);
                System.out.println("Nama mobil = "+mobil.objmobil.getData_mobil().get(i).getNama_mobil());
                System.out.println("Jenis mobil = "+mobil.objmobil.getData_mobil().get(i).getJenis());
                System.out.println("Harga = " +mobil.objmobil.getData_mobil().get(i).getHarga());
                System.out.println("=======================");
                System.out.println(" ");
            }
        } else {
            System.out.println("Data tidak ada");
        }
    }
    void update() {
        if(mobil.objmobil.getData_mobil().size()>0)
        {
            int nomor;
            read();
            System.out.println("Pilih index mobil yang ingin diubah : ");
            nomor = input.nextInt();
            System.out.print("Masukkan nama mobil baru : ");
            String nama_obat = input.next();
            System.out.print("Masukkan jenis mobil baru : ");
            String jenis =  input.nextLine();
            System.out.print("Masukkan harga mobil baru : ");
            int harga = input.nextInt();
            input.nextLine();

            mobil.update(nomor-1, new entity_mobil(nama_obat, jenis, harga));
            System.out.println("Data mobil telah diubah");
        } else {
            System.out.println("Data kosong");
        }
    }
    void delete(){
        if(mobil.objmobil.getData_mobil().size()>0)
        {
            read();
            int nomor;

            System.out.println("pilih index mobil yang ingin dihapus ");
            nomor = input.nextInt();

            mobil.delete(nomor-1);
            System.out.println("Data berhasil dihapus ");
        } else {
            System.out.println("Data kosong");
        }
    }

    void beli() {
//        System.out.println("Input Id : ");
        System.out.println("Nama Mobil ");
        String nama = input.next();
        boolean cekbeli = false;
        for(int i =0; i < mobil.objmobil.getData_mobil().size(); i++){
            if(nama.equals(mobil.objmobil.getData_mobil().get(i).getNama_mobil())){
                cekbeli = true;
            }
        }
        if(cekbeli){
            System.out.println("Mobil berhasil dibeli dengan rincian ");
            for(int i =0; i < mobil.objmobil.getData_mobil().size(); i++){
                if(nama.equals(mobil.objmobil.getData_mobil().get(i).getNama_mobil())){
                    cekbeli = true;
                    System.out.println("NAMA MOBIL : "+mobil.objmobil.getData_mobil().get(i).getNama_mobil());
                    System.out.println("HARGA MOBIL : Rp. "+mobil.objmobil.getData_mobil().get(i).getHarga());
                    System.out.println("JENIS MOBIL : "+mobil.objmobil.getData_mobil().get(i).getJenis());
                }
            }
        }
    }

    void menumobil() {
        int pilih;
        do {
            System.out.println("<<< Edit mobil >>>");
            System.out.println("1. Lihat mobil");
            System.out.println("2. Update mobil");
            System.out.println("3. Hapus mobil");
            System.out.println("4. Beli Mobil ");
            System.out.println("Pilih: ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1 -> read();
                case 2 -> update();
                case 3 -> delete();
                case 4 -> beli();
            }
        } while (pilih != 4);
    }
}
class menu {
    Scanner input = new Scanner(System.in);


    void Pilihmenu() {
        classadmin admin = new classadmin();
        classmobil mobil = new classmobil();
        admin.create();
        mobil.create();

        int pilihan;
        do {
            System.out.println("============");
            System.out.println("1. LOGIN ");
            System.out.println("0. Exit");
            System.out.println("Pilih : ");
            pilihan = input.nextInt();
            input.nextLine();
            System.out.println();

            switch (pilihan) {
                case 1 -> admin.menu();
            }
        } while (pilihan != 0);
    }
}

public class main {
    public static void main(String[] args) {
        menu objmenu = new menu();
        objmenu.Pilihmenu();
    }
}