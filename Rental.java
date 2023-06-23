package project;
import java.util.Scanner;

public class Rental {
    
    String merk[]= {"Mitsubishi Pajero","Honda Brio","Mitsubishi Xpander","Toyota Fortuner", "Jeep Rubicon", "Honda HRV"};
    String status[] = {"Ya","Tidak","Tidak","Ya","Ya","Ya"};

    class Queue {
        int[] element;
        int front;
        int rear;
        int maxQueue;
        
        public Queue(int max){
            front = 0;
            rear = -1;
            element = new int[max];
            maxQueue = max - 1;
        }

        public boolean isEmpty() {
            boolean flag;
            if(rear == -1 && front == 0) {
                flag = true;
            } else {
                flag = false;
            }
            return flag;
        }
        
        public boolean isFull() {
            boolean flag;
            if(rear == maxQueue) {
                flag = true;
            } else {
                flag = false;
            }
            return flag;
        }
        
        public void enqueue(int data) {
            if(isFull()) {
                System.out.println("Antrian sedang penuh");
            } else {
                rear += 1;
                element[rear] = data;
            }
        }
        
        public void printQueue() {
            if(!isEmpty()){
                System.out.println("Menampilkan Antrian ");
                for(int i = rear; i > -1; i--) {
                    System.out.println("Berhasil mendapatkan antrian ke="+ element[i]);
                }                    
            } else {
                System.out.println("Antrian masih kosong");
            }
        }
}
        
public void menu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Selamat datang.");
    int pilih = 0;
    while(pilih != 6) {
        System.out.println("Menu:");
        System.out.println("1. Buat Antrian");
        System.out.println("2. Tampilkan daftar mobil");
        System.out.println("3. Cari mobil");
        System.out.println("4. Sewa mobil");
        System.out.println("5. Kembalikan mobil");
        System.out.println("6. Keluar");
        System.out.print("Pilih menu (1-6): ");
        pilih = scanner.nextInt();
       
        switch(pilih) {
            case 1:
                System.out.println("Masukkan nomor antrian :");
                int input = scanner.nextInt();
                Queue antri1 = new Queue(3);
                antri1.enqueue(input);
                antri1.printQueue();
                break;
            case 2:
                tampilkanMobil();
                break;
            case 3:
                cariMobil();
                break;
            case 4:
                sewa();
                break;
            case 5:
                kembali();
                break;
            case 6:
                System.out.println("Terima kasih! Program selesai.");
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                break;
        }
        System.out.println();
    }
}

public void tampilkanMobil() {
    System.out.println("Daftar Mobil:");
    for (int i = 0; i < merk.length; i++) {
        System.out.println((i + 1) + ". " + merk[i]);
    }
}

public void sewa() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Masukkan nomor mobil yang ingin disewa:");
    int input = scanner.nextInt();
    
    if (input >= 1 && input <= merk.length) {
        String terpilih = merk[input - 1];
        if (status[input - 1].equals("Ya")) {
            status[input - 1] = "Tidak";
            System.out.println("Mobil dengan merk " + terpilih + " berhasil disewa.");
        } else {
            System.out.println("Mobil dengan merk " + terpilih + " Tidak tersedia.");
        }
    } else {
        System.out.println("Nomor mobil tidak valid.");
    }
}

public void kembali() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Masukkan nomor mobil yang ingin dikembalikan:");
    int input = scanner.nextInt();
    
    if (input >= 1 && input <= merk.length) {
        String terpilih = merk[input - 1];
        if (status[input - 1].equals("Tidak")) {
            status[input - 1] = "Ya";
            System.out.println("Mobil dengan merk " + terpilih + " berhasil dikembalikan.");
        } else {
            System.out.println("Mobil dengan merk " + terpilih + " tidak dalam kondisi disewa.");
        }
    } else {
        System.out.println("Nomor mobil tidak valid.");
    }
}

public void cariMobil() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Masukkan merk mobil yang ingin dicari:");
    String input = scanner.nextLine();
    
    boolean ditemukan = false;
    for (int i = 0; i < merk.length; i++) {
        if (merk[i].equalsIgnoreCase(input)) {
            if (status[i]== "Ya") {
                System.out.println("Mobil ditemukan pada indeks ke-" + i + " "+ "[Tersedia]");
                ditemukan = true;
                break;
            }else{
                System.out.println("Mobil ditemukan pada indeks ke-" + i + " "+ "[Disewa]");
                ditemukan = true;
                break;
            }
        }
    }
    if (!ditemukan) {
        System.out.println("Mobil tidak ditemukan.");
    }
}
    public static void main(String[] args) {
        Rental rentalMobil = new Rental();
        rentalMobil.menu();
    }
}