package View;

import controller.controller_admin;
import entity.entity_admin;

import java.util.Scanner;

public class MainPage {
    controller_admin admin = new controller_admin();
    Scanner input = new Scanner(System.in);

    void create() {
        admin.create(new entity_admin("WAHYU", "sda", 101));
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
                System.out.println("Admin " + nomorurut);
                System.out.println("Nama = " + admin.objadmin.getdata_admin().get(i).getNama());
                System.out.println("ID = " + admin.objadmin.getdata_admin().get(i).getId());
                System.out.println("=======================");
                System.out.println(" ");
            }
        } else {
            System.out.println("Data tidak ada");
        }
    }

    void update() {
        if (admin.objadmin.getdata_admin().size() > 0) {
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

            admin.update(nomor - 1, new entity_admin(Nama, Password, id));
            System.out.println("Data Admin pada index tersebut telah diubah");
        } else {
            System.out.println("Data kosong");
        }
    }

    void delete() {
        if (admin.objadmin.getdata_admin().size() > 0) {
            read();
            int nomor;
            System.out.println("pilih index admin yang ingin dihapus ");
            nomor = input.nextInt();

            admin.delete(nomor - 1);
            System.out.println("Data berhasil dihapus ");
        } else {
            System.out.println("Data kosong");
        }
    }

    void login() {
        MobilPage mobil = new MobilPage();
        mobil.create();
        boolean cekLogin = false;

            System.out.print("Input Id : ");
            int id = input.nextInt();
            System.out.print("Input Pass : ");
            String password = input.next();
            for (int i = 0; i < admin.objadmin.getdata_admin().size(); i++) {
                if (id == admin.objadmin.getdata_admin().get(i).getId() && password.equals(admin.objadmin.getdata_admin().get(i).getPassword())) {
                    cekLogin = true;
                }
            }


        if (cekLogin) {
            System.out.println("Haloooo ADMIN");
            int pilih;
            do {
                System.out.println();
                System.out.println("<<< USER LOGGED IN >>>");
                System.out.println("1. Lihat admin");
                System.out.println("2. Update admin");
                System.out.println("3. Hapus admin");
                System.out.println("4. Pembelian Mobil");
                System.out.println("0. Back");
                System.out.print("Pilih: ");
                pilih = input.nextInt();
                System.out.println();

                switch (pilih) {
                    case 1 -> read();
                    case 2 -> update();
                    case 3 -> delete();
                    case 4 -> mobil.menumobil();
                }
            } while (pilih != 0);
        }
        else {
            System.out.println("Id atau password salah");
            System.out.println();
        }
    }

//    void menu() {
//        classmobil mobil = new classmobil();
//        mobil.create();
//        int pilih;
//        do {
//            System.out.println();
//            System.out.println("<<< Menu Admin >>>");
//            System.out.println("1. LOGIN");
//            System.out.println("0. Back");
//            System.out.println("Pilih: ");
//            pilih = input.nextInt();
//
//            switch (pilih) {
//                case 1 -> login();
//            }
//        } while (pilih != 0);
//    }
}
