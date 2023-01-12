package View;

import Utility.Date;
import Utility.Rupiah;
import controller.controller_mobil;
import entity.entity_mobil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MobilPage {
    controller_mobil mobil = new controller_mobil();
    Scanner input = new Scanner(System.in);

    void create() {
        mobil.create(new entity_mobil("Brio", "LCGC", 120000000));
        mobil.create(new entity_mobil("Aventador", "Hyper Car", 2000000000));
        mobil.create(new entity_mobil("F1", "Track Car", 80000000));
        mobil.create(new entity_mobil("Avanza", "MPV", 90000000));
        mobil.create(new entity_mobil("Mazda", "Hatchback", 1000000000));
        mobil.create(new entity_mobil("Koenieseg", "Hyper Car", 200000000));
    }

    void read() {
        if (mobil.objmobil.getData_mobil().size() > 0) {
            int nomorurut = 0;
            System.out.println("<<<<< DATA MOBIL >>>>>");
            for (int i = 0; i < mobil.objmobil.getData_mobil().size(); i++) {
                nomorurut++;
                System.out.println("index ke " + nomorurut);
                System.out.println("Nama mobil = " + mobil.objmobil.getData_mobil().get(i).getNama_mobil());
                System.out.println("Jenis mobil = " + mobil.objmobil.getData_mobil().get(i).getJenis());
                System.out.println("Harga = Rp." + Rupiah.format(mobil.objmobil.getData_mobil().get(i).getHarga()));
                System.out.println("=======================");
                System.out.println(" ");
            }
        } else {
            System.out.println("Data tidak ada");
        }
    }

    private void read2() {
        System.out.println("List Mobil yang tersedia");
            System.out.println("===============================");
            for (int i = 0; i < mobil.objmobil.getData_mobil().size(); i++) {
                System.out.println("Nama mobil = " + mobil.objmobil.getData_mobil().get(i).getNama_mobil());
                System.out.println("Jenis mobil = " + mobil.objmobil.getData_mobil().get(i).getJenis());
                System.out.println("Harga = Rp." + Rupiah.format(mobil.objmobil.getData_mobil().get(i).getHarga()));
                System.out.println("===============================");
            }

    }

    void update() {
        try {
            if (mobil.objmobil.getData_mobil().size() > 0) {
                int nomor;
                read();
                System.out.print("Pilih index mobil yang ingin diubah : ");
                nomor = input.nextInt();
                input.nextLine();
                System.out.print("Masukkan nama mobil baru : ");
                String nama_obat = input.nextLine();
                System.out.print("Masukkan jenis mobil baru : ");
                String jenis = input.nextLine();
                System.out.print("Masukkan harga mobil baru : ");
                int harga = input.nextInt();
                input.nextLine();

                mobil.update(nomor - 1, new entity_mobil(nama_obat, jenis, harga));
                System.out.println("Data mobil telah diubah");
            } else {
                System.out.println("Data kosong");
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Index yang anda masukkan salah");
        }
    }

    void delete() {
        try {
            if (mobil.objmobil.getData_mobil().size() > 0) {
                read();
                int nomor;

                System.out.println("pilih index mobil yang ingin dihapus ");
                nomor = input.nextInt();

                mobil.delete(nomor - 1);
                System.out.println("Data berhasil dihapus ");
            } else {
                System.out.println("Data kosong");
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Index yang anda masukkan salah");
        }
    }

    void beli() {
        read2();
        System.out.println();
        System.out.print("Masukkan Nama Mobil ");
        String nama = input.next();
        input.nextLine();
        boolean cekbeli = false;
        char dcs = 'y';
        for (int i = 0; i < mobil.objmobil.getData_mobil().size(); i++) {
            if (nama.equals(mobil.objmobil.getData_mobil().get(i).getNama_mobil())) {
                cekbeli = true;
                System.out.println("Mobil ditemukan");
                System.out.print("Apakah anda ingin membeli mobil ini (y/n) ? :");
                dcs = input.nextLine().charAt(0);
                if (cekbeli && dcs == 'y') {
                    System.out.println("Mobil berhasil dibeli dengan rincian ");
                    for (i = 0; i < mobil.objmobil.getData_mobil().size(); i++) {
                        if (nama.equals(mobil.objmobil.getData_mobil().get(i).getNama_mobil())) {
                            cekbeli = true;
                            System.out.println("=====================================================");
                            System.out.println("NAMA MOBIL        : " + mobil.objmobil.getData_mobil().get(i).getNama_mobil());
                            System.out.println("HARGA MOBIL       : Rp. " + Rupiah.format(mobil.objmobil.getData_mobil().get(i).getHarga()));
                            System.out.println("JENIS MOBIL       : " + mobil.objmobil.getData_mobil().get(i).getJenis());
                            System.out.println("TANGGAL PEMBELIAN : " + Date.now());
                            System.out.println("=====================================================");
                        }
                    }
                } else {
                    System.out.println("Pembelian dibatalkan");
                    System.out.println();
                }
            } else {
                System.out.println("Mobil Tidak Ditemukan");
                System.out.println();
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
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.println();

            switch (pilih) {
                case 1 -> {read();}
                case 2 -> {update();}
                case 3 -> {delete();}
                case 4 -> {beli();}
            }
        } while (pilih != 4);
    }
}
