import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

import models.User;





interface Warmindo {
    String getDeskripsi();
    void setDeskripsi(String deskripsi);
    void setHarga(int harga);
    void setStok(int stok);
}






class Transaksi {
    private String item;
    private int harga;
    private int jumlah;
    private int pembayaran;
    private int kembalian;

    public Transaksi(String item, int harga, int jumlah, int pembayaran, int kembalian) {
        this.item = item;
        this.harga = harga;
        this.jumlah = jumlah;
        this.pembayaran = pembayaran;
        this.kembalian = kembalian;
    }

    public String getItem() {
        return item;
    }

    public int getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getPembayaran() {
        return pembayaran;
    }

    public int getKembalian() {
        return kembalian;
    }
    
    public void printStruk() {
        System.out.println("Item: " + getItem());
        System.out.println("Harga: Rp" + getHarga());
        System.out.println("Jumlah: " + getJumlah());
        System.out.println("Pembayaran: Rp" + getPembayaran());
        System.out.println("Kembalian: Rp" + getKembalian());
    }
}


class StrukBelanja extends Transaksi {

    public StrukBelanja(String item, int harga, int jumlah, int pembayaran, int kembalian) {
        super(item, harga, jumlah, pembayaran, kembalian);
    }
}














class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    // @Override
    // public void showMenu() {
    // }
}

class RegularUser extends User {
    public RegularUser(String username, String password) {
        super(username, password);
    }

    // @Override
    // public void showMenu() {
    // }
}



















class MieInstan {
    protected String jenis;
    protected int harga;
    protected int stok;
    protected int gram;
    protected String nama;
    protected String deskripsi;

    public MieInstan(String jenis, String nama, int harga, int stok, int gram, String deskripsi) {
        this.jenis = jenis;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.gram = gram;
        this.deskripsi = deskripsi;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getGram() {
        return gram;
    }

    public void setGram(int gram) {
        this.gram = gram;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    // @Override
    // public String toString() {
    //     return "Nama: " + getNama() + ", Harga: " + getHarga() + ", Stok: " + getStok() + ", Gram: " + getGram() + ", Deskripsi: " + getDeskripsi();
    // }
}



















class Minuman implements Warmindo {
    private int id;
    private String nama;
    private int harga;
    private int stok;
    private String deskripsi;

    public Minuman(int id, String nama, int harga, int stok, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.deskripsi = deskripsi;
    }

    // Getter dan setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }
    @Override
    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }
    @Override
    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    @Override
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}
























    public class WarmindoApp {
        private static Scanner scanner = new Scanner(System.in);
        private static ArrayList<Minuman> daftarMinuman = new ArrayList<>();
        private static HashMap<String, User> users = new HashMap<>();
        private static HashMap<String, Admin> admins = new HashMap<>();
        private static User currentUser;
        // private static Connection connection;
    
        public static void main(String[] args) {
            admins.put("admin", new Admin("admin", "admin123"));
    
            System.out.println("\n\033[95m╔════════════════════════════════╗");
            System.out.println("║      WELCOME TO WARMINDO       ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ Press Enter to continue...     ║");
            System.out.println("╚════════════════════════════════╝\033[0m");
            scanner.nextLine(); 
    
            while (true) {
                System.out.println("\n\033[95m╔════════════════════════════════╗");
                System.out.println("║    SELAMAT DATANG DI WARMINDO  ║");
                System.out.println("╠════════════════════════════════╣");
                System.out.println("║ 1. Login                       ║");
                System.out.println("║ 2. Registrasi                  ║");
                System.out.println("║ 0. Keluar                      ║");
                System.out.println("╚════════════════════════════════╝\033[0m");
                System.out.print("PILIH MENU: ");
    
                int pilihan = inputAngka();
    
                if (pilihan == 1) {
                    login();
                } else if (pilihan == 2) {
                    registrasi();
                } else if (pilihan == 0) {
                    System.out.println("\n\033[38;5;214m╔═════════════════════════════════════╗");
                    System.out.println("║       TERIMA KASIH TELAH BELANJA    ║");
                    System.out.println("║          DI WARUNG MIE KAMI         ║");
                    System.out.println("╚═════════════════════════════════════╝\033[0m");
    
                    break;
                } else {
                    System.out.println("Pilihan tidak valid!");
                }
            }
        }
    











private static User currentUser2; // Variabel global untuk menyimpan objek User yang sedang login
        // Variabel global untuk menyimpan username yang sedang login
private static int jumlahinputminum;
    
















private static void login() {
    System.out.print("Username: ");
    String username = scanner.nextLine();
    System.out.print("Password: ");
    String password = scanner.nextLine();

    // cek apakah admin
    if ("admin".equals(username) && "admin123".equals(password)) {
        currentUser2 = new Admin(username, password);
        System.out.println("Admin login successful!");
        menuAdmin();
        return;  // Exit the method after admin login
    }

    try {
        String sql = "SELECT id_user, username, password FROM users WHERE username = ?";
        PreparedStatement statement = DatabaseConnection.getPreparedStatement(sql);
        statement.setString(1, username);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String dbPassword = resultSet.getString("password");
            if (dbPassword.equals(password)) {
                currentUser2 = new RegularUser(username, password); // Simpan objek RegularUser yang login
                System.out.println("Login successful!");
                menuUser();
            } else {
                System.out.println("Password salah!");
            }
        } else {
            System.out.println("Username tidak ditemukan!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error akses database.");
    }
}

private static void registrasi() {
    System.out.print("Masukkan username baru: ");
    String username = scanner.nextLine();
    System.out.print("Masukkan password baru: ");
    String password = scanner.nextLine();

    try (Connection conn = DatabaseConnection.getConnection()) {
        // cek apakah username ada didatabase
        String checkUserQuery = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkUserQuery)) {
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Registrasi gagal: Username sudah digunakan!");
                return;
            }
        }

        String insertUserQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(insertUserQuery)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                currentUser2 = new RegularUser(username, password); // Simpan objek RegularUser yang baru terdaftar
                System.out.println("Registrasi berhasil!");

                // Tambahkan user baru ke dalam HashMap users
                users.put(username, new RegularUser(username, password)); // atau Admin(username, password) jika Anda ingin menambahkan admin
            } else {
                System.out.println("Registrasi gagal!");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Registrasi gagal: " + e.getMessage());
    }
}

        
        








        
    
        private static void menuAdmin() {
            while (true) {
                System.out.println("\n\033[96m╔════════════════════════════════╗");
                System.out.println("║     MENU ADMIN - WARUNG MIE    ║");
                System.out.println("╠════════════════════════════════╣");
                System.out.println("║ 1. Tambah Mie Instan           ║");
                System.out.println("║ 2. Lihat Mie Instan            ║");
                System.out.println("║ 3. Ubah Stok Mie Instan        ║");
                System.out.println("║ 4. Hapus Mie Instan            ║");
                System.out.println("║ 5. Lihat Riwayat Pembelian     ║");
                System.out.println("║ 9. Tambah Minuman              ║");
                System.out.println("║ 10. Lihat Minuman              ║");
                System.out.println("║ 11. Ubah Minuman               ║");
                System.out.println("║ 12. Hapus Minuman              ║");
                System.out.println("║ 0. Logout                      ║");
                System.out.println("╚════════════════════════════════╝\033[0m");
                
                System.out.print("PILIH MENU: ");
        
                int pilihan = inputAngka();
        
                if (pilihan == 1) {
                    tambahMieInstan();
                } else if (pilihan == 2) {
                    lihatSemuaMieInstan();
                } else if (pilihan == 3) {
                    ubahStokMieInstan();
                } else if (pilihan == 4) {
                    hapusMieInstan();
                } else if (pilihan == 5) {
                    lihatRiwayatPembelian();                
                } else if (pilihan == 9) {
                    tambahMinuman();
                } else if (pilihan == 10) {
                    lihatMinuman();
                } else if (pilihan == 11) {
                    ubahMinuman();
                } else if (pilihan == 12) {
                    hapusMinuman();
                } else if (pilihan == 0) {
                    currentUser = null;
                    break;
                } else {
                    System.out.println("Pilihan tidak valid!");
                }
            }
        }        

        


















    
        private static void tambahMieInstan() {
            System.out.println("\n\033[95m╔════════════════════════════════╗");
            System.out.println("║      Pilih Jenis Mie Instan    ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Mie Kuah                    ║");
            System.out.println("║ 2. Mie Goreng                  ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Masukkan pilihan: ");
            
            int pilihan = inputAngka();
    
            String jenis = "";
            switch (pilihan) {
                case 1:
                    jenis = "kuah";
                    break;
                case 2:
                    jenis = "goreng";
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    return;
            }
    
            try {
                System.out.print("Masukkan nama mie instan: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan harga mie instan: ");
                int harga = inputAngka();
                System.out.print("Masukkan stok mie instan: ");
                int stok = inputAngka();
                System.out.print("Masukkan gram mie instan: ");
                int gram = inputAngka();
                System.out.print("Masukkan deskripsi mie instan: ");
                String deskripsi = scanner.nextLine();
    
                MieInstan mieInstan = new MieInstan(jenis, nama, harga, stok, gram, deskripsi);
    
                // Insert into database
                String sql = "INSERT INTO mie_instan (jenis, nama, harga, stok, gram, deskripsi) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = DatabaseConnection.getPreparedStatement(sql);
                statement.setString(1, mieInstan.getJenis());
                statement.setString(2, mieInstan.getNama());
                statement.setInt(3, mieInstan.getHarga());
                statement.setInt(4, mieInstan.getStok());
                statement.setInt(5, mieInstan.getGram());
                statement.setString(6, mieInstan.getDeskripsi());
    
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("MIE INSTAN BERHASIL DITAMBAHKAN KE STOK");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while adding Mie Instan to database.");
            }
        }
































        private static void menuUser() {
            while (true) {
                System.out.println("\n\033[95m╔════════════════════════════════╗");
                System.out.println("║      MENU USER - WARUNG MIE    ║");
                System.out.println("╠════════════════════════════════╣");
                System.out.println("║ 1. Lihat Mie Instan            ║");
                System.out.println("║ 2. Lihat Minuman               ║");
                System.out.println("║ 3. Beli Mie Instan             ║");
                System.out.println("║ 0. Logout                      ║");
                System.out.println("╚════════════════════════════════╝");
                System.out.print("PILIH MENU: ");
                
        
                int pilihan = inputAngka();
        
                if (pilihan == 1) {
                    lihatSemuaMieInstan();
                } else if (pilihan == 2) {
                    lihatMinuman();
                } else if (pilihan == 3) {
                    beliMieInstan();
                } else if (pilihan == 0) {
                    currentUser = null;
                    break;
                } else {
                    System.out.println("Pilihan tidak valid!");
                }
            }
        }
 






















        private static void lihatSemuaMieInstan() {
            try (Connection conn = DatabaseConnection.getConnection();
                 Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM mie_instan";
                ResultSet resultSet = stmt.executeQuery(sql);
        
                System.out.format("╔══════════════════════════════════════════════════════════════════════════════╗%n");
                System.out.format("║ %-15s ║ %-15s ║ %-5s ║ %-4s  ║ %-5s ║ %-16s ║%n", "Jenis", "Nama", "Harga", "Stok", "Gram", "Deskripsi");
                System.out.format("╚══════════════════════════════════════════════════════════════════════════════╝%n");
        
                while (resultSet.next()) {
                    String jenis = resultSet.getString("jenis");
                    String nama = resultSet.getString("nama");
                    int harga = resultSet.getInt("harga");
                    int stok = resultSet.getInt("stok");
                    int gram = resultSet.getInt("gram");
                    String deskripsi = resultSet.getString("deskripsi");
        
                    System.out.format("║ %-15s ║ %-15s ║ %-5d ║ %-4d  ║ %-5d ║ %-15s ║%n", jenis, nama, harga, stok, gram, deskripsi);
                }
                System.out.format("╚══════════════════════════════════════════════════════════════════════════════╝%n");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Gagal mengambil data Mie Instan: " + e.getMessage());
            }
        }
        
        

        private static List<MieInstan> ambilDataMieInstanDariDatabase() throws SQLException {
            List<MieInstan> mieInstanList = new ArrayList<>();
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
        
            try {
                connection = DatabaseConnection.getConnection();
                String sql = "SELECT * FROM mie_instan";
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
        
                while (resultSet.next()) {
                    String jenis = resultSet.getString("jenis");
                    String nama = resultSet.getString("nama");
                    int harga = resultSet.getInt("harga");
                    int gram = resultSet.getInt("gram");
                    int stok = resultSet.getInt("stok");
        
                    MieInstan mieInstan = new MieInstan(jenis, nama, harga, stok, gram, nama);
                    mieInstanList.add(mieInstan);
                }
            } finally {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        
            return mieInstanList;
        }
        




























        private static List<StrukBelanja> ambilRiwayatPembelianDariDatabase() {
            List<StrukBelanja> riwayatPembelian = new ArrayList<>();
            String sql = "SELECT item, harga, jumlah, pembayaran, kembalian, username FROM strukbelanja";
            
            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                
                while (resultSet.next()) {
                    String item = resultSet.getString("item");
                    int harga = resultSet.getInt("harga");
                    int jumlah = resultSet.getInt("jumlah");
                    int pembayaran = resultSet.getInt("pembayaran");
                    int kembalian = resultSet.getInt("kembalian");
                    
                    StrukBelanja strukBelanja = new StrukBelanja(item, harga, jumlah, pembayaran, kembalian);
                    riwayatPembelian.add(strukBelanja);
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Terjadi Kesalahan");
            }
            
            return riwayatPembelian;
        }
        
        
        private static void lihatRiwayatPembelian() {
            List<StrukBelanja> riwayatPembelian = ambilRiwayatPembelianDariDatabase();
            
            if (riwayatPembelian.isEmpty()) {
                System.out.println("Belum ada riwayat pembelian.");
            } else {
                System.out.println("\n\033[95m╔══════════════════════════════════════════╗");
                System.out.println("║             RIWAYAT PEMBELIAN             ║");
                System.out.println("╚═══════════════════════════════════════════╝\033[0m");                
                
                for (StrukBelanja strukBelanja : riwayatPembelian) {
                    System.out.println("Item: " + strukBelanja.getItem());
                    System.out.println("Total Harga: Rp" + strukBelanja.getHarga());
                    System.out.println("Jumlah: " + strukBelanja.getJumlah());
                    System.out.println("Pembayaran: Rp" + strukBelanja.getPembayaran());
                    System.out.println("Kembalian: Rp" + strukBelanja.getKembalian());
                    System.out.println("═══════════════════════════════════");
                }
                
                System.out.println("═══════════════════════════════════════");
            }
        }
        

























        
        private static void beliMieInstan() {
            try {
                // Ambil data mie instan dari database
                List<MieInstan> daftarMie = ambilDataMieInstanDariDatabase();
        
                lihatSemuaMieInstan();
        
                if (daftarMie.isEmpty()) {
                    System.out.println("Data mie instan di Warmindo masih kosong");
                    return;
                }
        
                System.out.print("Masukkan nama mie instan yang ingin dibeli: ");
                String namaMie = scanner.nextLine();
        
                MieInstan mieTerpilih = null;
                for (MieInstan mie : daftarMie) {
                    if (mie.getNama().equalsIgnoreCase(namaMie)) {
                        mieTerpilih = mie;
                        break;
                    }
                }
        
                if (mieTerpilih == null) {
                    System.out.println("Mie instan tidak ditemukan!");
                    return;
                }
        
                System.out.print("Masukkan jumlah stok yang ingin dibeli: ");
                int jumlahinputmie = inputAngka();
        
                if (jumlahinputmie <= 0) {
                    System.out.println("Jumlah stok yang dimasukkan tidak valid!");
                    return;
                }
        
                if (jumlahinputmie > mieTerpilih.getStok()) {
                    System.out.println("Stok tidak mencukupi!");
                    return;
                }
        
                // totalharga setelah dikalikan
                int totalHargaMie = mieTerpilih.getHarga() * jumlahinputmie;
        
                ArrayList<String> items = new ArrayList<>();
                items.add(jumlahinputmie + "x " + mieTerpilih.getNama() + " - Rp" + totalHargaMie);
        
                System.out.println("Ingin menambah minuman? (y/n)");
                String tambahMinuman = scanner.nextLine();
        
                int totalHargaMinuman = 0;
                int jumlahinputminum = 0; // Menyimpan jumlah total minuman yang dibeli
        
                while (tambahMinuman.equalsIgnoreCase("y")) {
                    int minumanHarga = beliMinuman(items);
                    totalHargaMinuman += minumanHarga;
                    System.out.println("Total harga sementara: Rp" + (totalHargaMie + totalHargaMinuman));
                    System.out.println("Ingin menambah minuman lagi? (y/n)");
                    tambahMinuman = scanner.nextLine();
        
                    // Menambah jumlah total minuman yang dibeli
                    if (minumanHarga > 0) {
                        jumlahinputminum += 1; // Asumsi satu kali beli satu item minuman, bisa disesuaikan sesuai kebutuhan
                    }
                }
        
                // total harga (mie instan + minuman)
                int totalHarga = totalHargaMie + totalHargaMinuman;
        
                System.out.println("Total harga: Rp" + totalHarga);
        
                int pembayaran = 0;
                while (pembayaran < totalHarga) {
                    System.out.print("Masukkan jumlah pembayaran: ");
                    pembayaran = inputAngka();
        
                    if (pembayaran < totalHarga) {
                        System.out.println("Pembayaran gagal! Uang yang diberikan kurang.");
                        System.out.println("Total harga: Rp" + totalHarga);
                    }
                }
        
                int kembalian = pembayaran - totalHarga;
                System.out.println("Pembayaran berhasil!");
                System.out.println("Kembalian: Rp" + kembalian);
        
                // Update stok database
                Connection connection = null;
                try {
                    connection = DatabaseConnection.getConnection();
                    String updateSql = "UPDATE mie_instan SET stok = ? WHERE nama = ?";
                    try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                        updateStatement.setInt(1, mieTerpilih.getStok() - jumlahinputmie);
                        updateStatement.setString(2, mieTerpilih.getNama());
                        updateStatement.executeUpdate();
                    }
        
                    // Update local stok
                    mieTerpilih.setStok(mieTerpilih.getStok() - jumlahinputmie);
        
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while updating stock in the database.");
                } finally {
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        
                // Panggilan fungsi dengan argumen yang benar
                cetakStruk(items, totalHarga, pembayaran, kembalian);
                simpanStrukBelanja(items, totalHarga, jumlahinputmie, jumlahinputminum, pembayaran, kembalian);
        
                System.out.println("╔═════════════════════════════════════╗");
                System.out.println("║       TERIMA KASIH TELAH BELANJA    ║");
                System.out.println("║          DI WARUNG MIE KAMI         ║");
                System.out.println("╚═════════════════════════════════════╝");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while buying Mie Instan.");
            }
        }
        
        private static int beliMinuman(ArrayList<String> items) throws SQLException {
            // Ambil data minuman dari database
            List<Minuman> daftarMinuman = ambilDataMinumanDariDatabase();
        
            if (daftarMinuman.isEmpty()) {
                System.out.println("Data minuman di Warmindo masih kosong");
                return 0;
            }
        
            lihatMinuman();
        
            System.out.print("Masukkan nama minuman yang ingin dibeli: ");
            String namaMinuman = scanner.nextLine();
        
            Minuman minumanTerpilih = null;
            for (Minuman minuman : daftarMinuman) {
                if (minuman.getNama().equalsIgnoreCase(namaMinuman)) {
                    minumanTerpilih = minuman;
                    break;
                }
            }
        
            if (minumanTerpilih == null) {
                System.out.println("Minuman tidak ditemukan!");
                return 0;
            }
        
            System.out.print("Masukkan jumlah yang ingin dibeli: ");
            int jumlahinputminum = inputAngka();
        
            if (jumlahinputminum <= 0) {
                System.out.println("Jumlah yang dimasukkan tidak valid!");
                return 0;
            }
        
            if (jumlahinputminum > minumanTerpilih.getStok()) {
                System.out.println("Stok tidak mencukupi!");
                return 0;
            }
        
            // Hitung total harga
            int totalHarga = minumanTerpilih.getHarga() * jumlahinputminum;
        
            // Update stok database
            Connection connection = null;
            try {
                connection = DatabaseConnection.getConnection();
                String updateSql = "UPDATE minuman SET stok = ? WHERE nama = ?";
                try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                    updateStatement.setInt(1, minumanTerpilih.getStok() - jumlahinputminum);
                    updateStatement.setString(2, minumanTerpilih.getNama());
                    updateStatement.executeUpdate();
                }
        
                // Update local stok
                minumanTerpilih.setStok(minumanTerpilih.getStok() - jumlahinputminum);
        
                // Tambahkan item ke list
                items.add(jumlahinputminum + "x " + minumanTerpilih.getNama() + " - Rp" + totalHarga);
        
                // Return total harga
                return totalHarga;
        
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while buying minuman.");
                return 0;
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        

    
        
        // private static int inputAngka() {
        //     try {
        //         return Integer.parseInt(scanner.nextLine());
        //     } catch (NumberFormatException e) {
        //         System.out.println("Masukkan angka yang valid!");
        //         return 0;
        //     }
        // }

        private static void cetakStruk(ArrayList<String> items, int totalHarga, int pembayaran, int kembalian) {
            System.out.println("\033[33m╔═════════════════════════════════════╗");
            System.out.println("║             STRUK PEMBELIAN         ║");
            System.out.println("╚═════════════════════════════════════╝\033[0m");
            for (String item : items) {
                System.out.println(item);
            }
            System.out.println("---------------------------------------");
            System.out.println("Total Harga: Rp" + totalHarga); // Total harga dari semua item
            System.out.println("Pembayaran: Rp" + pembayaran);
            System.out.println("Kembalian: Rp" + kembalian);
            System.out.println("\033[33m╔═════════════════════════════════════╗");
            System.out.println("║       TERIMA KASIH TELAH BELANJA    ║");
            System.out.println("║          DI WARUNG MIE KAMI         ║");
            System.out.println("╚═════════════════════════════════════╝\033[0m");
        }
        
        
        private static void simpanStrukBelanja(ArrayList<String> items, int totalHarga, int jumlahinputmie,int jumlahinputminum, int pembayaran, int kembalian) {
            String insertSql = "INSERT INTO strukbelanja (item, harga, jumlah, pembayaran, kembalian, username) VALUES (?, ?, ?, ?, ?, ?)";
        
            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
        
                insertStatement.setString(1, String.join(", ", items)); // Menyimpan semua item dalam satu kolom untuk kesederhanaan
                insertStatement.setInt(2, totalHarga); // Menggunakan total harga langsung
                insertStatement.setInt(3, jumlahinputmie + jumlahinputminum); // Jumlah stok yang dibeli
                insertStatement.setInt(4, pembayaran); // Pembayaran yang dilakukan oleh pelanggan
                insertStatement.setInt(5, kembalian); // Kembalian yang diberikan kepada pelanggan
                insertStatement.setString(6, currentUser2.getUsername()); // Menyimpan username yang sedang login
                insertStatement.executeUpdate();
        
                System.out.println("Struk pembelian berhasil disimpan ke dalam database.");
        
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error while saving receipt to database.");
            }
        }        
      
        
       
        































    private static void lihatSemuaMie() {
        String sql = "SELECT * FROM mie_instan";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
    
            System.out.println("╔═════════════════════════════════════════════════════════════╗");
            System.out.println("║                      DAFTAR MIE INSTAN                      ║");
            System.out.println("╚═════════════════════════════════════════════════════════════╝");
    
            while (resultSet.next()) {
                String nama = resultSet.getString("nama");
                String jenis = resultSet.getString("jenis");
                int harga = resultSet.getInt("harga");
                int stok = resultSet.getInt("stok");
                int gram = resultSet.getInt("gram");
                String deskripsi = resultSet.getString("deskripsi");
    
                System.out.println("Nama: " + nama);
                System.out.println("Jenis: " + jenis);
                System.out.println("Harga: Rp" + harga);
                System.out.println("Stok: " + stok);
                System.out.println("Gram: " + gram);
                System.out.println("Deskripsi: " + deskripsi);
                System.out.println("════════════════════════════════════════════════════════════");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while fetching Mie Instan data from database.");
        }
    }       
    






































    private static void ubahStokMieInstan() {
        lihatSemuaMie(); 
        
        System.out.print("Masukkan nama mie instan yang ingin diubah: ");
        String namaMie = scanner.nextLine();
        
        boolean ditemukan = ubahStokMieInstan(namaMie);
        
        if (ditemukan) {
            System.out.println("Data mie instan berhasil diubah.");
        } else {
            System.out.println("MIE INSTAN TIDAK DITEMUKAN");
        }
    }
    
    private static boolean ubahStokMieInstan(String namaMie) {
        String sql = "SELECT * FROM mie_instan WHERE nama = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql,
                     ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            
            statement.setString(1, namaMie);
            ResultSet resultSet = statement.executeQuery();
    
            if (resultSet.next()) {
                String jenis = resultSet.getString("jenis");
                int harga = resultSet.getInt("harga");
                int stok = resultSet.getInt("stok");
                int gram = resultSet.getInt("gram");
                String deskripsi = resultSet.getString("deskripsi");
    
                System.out.println("Detail Mie Instan:");
                System.out.println("Nama: " + namaMie);
                System.out.println("Jenis: " + jenis);
                System.out.println("Harga: Rp" + harga);
                System.out.println("Stok: " + stok);
                System.out.println("Gram: " + gram);
                System.out.println("Deskripsi: " + deskripsi);
                System.out.println("════════════════════════════════════════════════════════════");
    
                System.out.print("Masukkan harga baru: ");
                int hargaBaru = inputAngka();
                System.out.print("Masukkan stok baru: ");
                int stokBaru = inputAngka();
                System.out.print("Masukkan gram baru: ");
                int gramBaru = inputAngka();
    
                resultSet.updateInt("harga", hargaBaru);
                resultSet.updateInt("stok", stokBaru);
                resultSet.updateInt("gram", gramBaru);
                resultSet.updateRow();
    
                return true;
            } else {
                return false;
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while updating Mie Instan data.");
            return false;
        }
    }       


























    private static void hapusMieInstan() {
        lihatSemuaMie(); 
    
        System.out.print("MASUKKAN NAMA MIE YANG TELAH HABIS: ");
        String namaMie = scanner.nextLine();
    
        boolean ditemukan = hapusMieDariDatabase(namaMie); // jika data ada, data terhapus ke database
    
        if (ditemukan) {
            System.out.println("╔═════════════════════════════════════════════════════════════╗");
            System.out.println("║                     MIE BERHASIL DIHAPUS                    ║");
            System.out.println("╚═════════════════════════════════════════════════════════════╝");
        } else {
            System.out.println("MIE TIDAK DITEMUKAN");
        }
    }
    
    private static boolean hapusMieDariDatabase(String namaMie) {
        String sql = "DELETE FROM mie_instan WHERE nama = ?";
        try (PreparedStatement statement = DatabaseConnection.getPreparedStatement(sql)) {
            statement.setString(1, namaMie);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while deleting Mie Instan from database.");
            return false;
        }
    }    
    
    



























private static void tambahMinuman() {
    System.out.print("Masukkan nama minuman: ");
    String nama = scanner.nextLine();
    System.out.print("Masukkan harga minuman: ");
    int harga = inputAngka();
    System.out.print("Masukkan stok minuman: ");
    int stok = inputAngka();
    System.out.print("Masukkan deskripsi minuman: ");
    String deskripsi = scanner.nextLine();

    // Tambahkan minuman ke dalam database
    Minuman minumanBaru = tambahMinumanKeDatabase(nama, harga, stok, deskripsi);

    if (minumanBaru != null) {
        // Tambahkan minuman ke dalam daftar lokal
        daftarMinuman.add(minumanBaru);
        System.out.println("MINUMAN BERHASIL DITAMBAHKAN KE STOK");
    } else {
        System.out.println("Gagal menambahkan minuman ke dalam database.");
    }
}

@SuppressWarnings("static-access")
private static Minuman tambahMinumanKeDatabase(String nama, int harga, int stok, String deskripsi) {
    String sql = "INSERT INTO minuman (nama, harga, stok, deskripsi) VALUES (?, ?, ?, ?)";
    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Minuman minumanBaru = null;

    try {
        conn = DatabaseConnection.getConnection();
        statement = conn.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);

        statement.setString(1, nama);
        statement.setInt(2, harga);
        statement.setInt(3, stok);
        statement.setString(4, deskripsi);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            // Dapatkan ID yang di-generate secara otomatis
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                // Buat objek Minuman baru dengan ID yang dihasilkan
                minumanBaru = new Minuman(id, nama, harga, stok, deskripsi);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return minumanBaru;
}























 
private static List<Minuman> ambilSemuaMinumanDariDatabase() {
    List<Minuman> daftarMinuman = new ArrayList<>();
    String sql = "SELECT * FROM minuman";

    try (Connection conn = DatabaseConnection.getConnection();
         Statement statement = conn.createStatement();
         ResultSet resultSet = statement.executeQuery(sql)) {

        System.out.format("╔════╦═════════════════╦═══════╦══════╦═══════════════════════╗%n");
        System.out.format("| %-2s | %-15s | %-5s | %-4s | %-20s |%n", "ID", "Nama", "Harga", "Stok", "Deskripsi");
        System.out.format("╠════╬═════════════════╬═══════╬══════╬═══════════════════════╣%n");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nama = resultSet.getString("nama");
            int harga = resultSet.getInt("harga");
            int stok = resultSet.getInt("stok");
            String deskripsi = resultSet.getString("deskripsi");

            Minuman minuman = new Minuman(id, nama, harga, stok, deskripsi);
            daftarMinuman.add(minuman);

            System.out.format("| %-2d | %-15s | %-5d | %-4d | %-20s |%n", id, nama, harga, stok, deskripsi);
        }
        System.out.format("╚════╩═════════════════╩═══════╩══════╩═══════════════════════╝%n");

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return daftarMinuman;
}




















        private static void lihatMinuman() {
        ambilSemuaMinumanDariDatabase();

                }
    


























        private static void ubahMinuman() {
            List<Minuman> daftarMinuman = ambilSemuaMinumanDariDatabase();
        if (daftarMinuman.isEmpty()) {
            System.out.println("╔═════════════════════════════════════════════════════════════╗");
            System.out.println("║                     DATA MINUMAN KOSONG                     ║");
            System.out.println("╚═════════════════════════════════════════════════════════════╝");
            return;
        }

        System.out.print("Masukkan nama minuman yang ingin diubah: ");
        String namaMinuman = scanner.nextLine();

        Minuman minuman = null;
        for (Minuman m : daftarMinuman) {
            if (m.getNama().equalsIgnoreCase(namaMinuman)) {
                minuman = m;
                break;
            }
        }

        if (minuman == null) {
            System.out.println("Minuman dengan nama \"" + namaMinuman + "\" tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan nama minuman baru (kosongkan jika tidak diubah): ");
        String namaBaru = scanner.nextLine();
        if (!namaBaru.isEmpty()) {
            minuman.setNama(namaBaru);
        }

        System.out.print("Masukkan harga minuman baru (0 jika tidak diubah): ");
        int hargaBaru = inputAngka();
        if (hargaBaru > 0) {
            minuman.setHarga(hargaBaru);
        }

        System.out.print("Masukkan stok minuman baru (0 jika tidak diubah): ");
        int stokBaru = inputAngka();
        if (stokBaru >= 0) {
            minuman.setStok(stokBaru);
        }

        System.out.print("Masukkan deskripsi minuman baru (kosongkan jika tidak diubah): ");
        String deskripsiBaru = scanner.nextLine();
        if (!deskripsiBaru.isEmpty()) {
            minuman.setDeskripsi(deskripsiBaru);
        }

        // Update minuman di database
        ubahMinumanDiDatabase(minuman);

        // Refresh data dari database ke dalam daftarMinuman
        daftarMinuman = (ArrayList<Minuman>) ambilDataMinumanDariDatabase();

        System.out.println("MINUMAN BERHASIL DIUBAH");
    }

    private static void ubahMinumanDiDatabase(Minuman minuman) {
        String sql = "UPDATE minuman SET nama = ?, harga = ?, stok = ?, deskripsi = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, minuman.getNama());
            statement.setInt(2, minuman.getHarga());
            statement.setInt(3, minuman.getStok());
            statement.setString(4, minuman.getDeskripsi());
            statement.setInt(5, minuman.getId()); // Menggunakan ID minuman untuk kriteria WHERE

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Minuman dengan ID " + minuman.getId() + " berhasil diubah di database.");
            } else {
                System.out.println("Gagal mengubah minuman dengan ID " + minuman.getId() + " di database.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






















    private static List<Minuman> ambilDataMinumanDariDatabase() {
        List<Minuman> minumans = new ArrayList<>();
        String sql = "SELECT * FROM minuman";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                int harga = resultSet.getInt("harga");
                int stok = resultSet.getInt("stok");
                String deskripsi = resultSet.getString("deskripsi");

                Minuman minuman = new Minuman(id, nama, harga, stok, deskripsi);
                minumans.add(minuman);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return minumans;
    }
    



















    private static void hapusMinuman() {
        List<Minuman> daftarMinuman = ambilSemuaMinumanDariDatabase();

        if (daftarMinuman.isEmpty()) {
            System.out.println("╔═════════════════════════════════════════════════════════════╗");
            System.out.println("║                     DATA MINUMAN KOSONG                     ║");
            System.out.println("╚═════════════════════════════════════════════════════════════╝");
            return;
        }

        System.out.print("Masukkan nama minuman yang ingin dihapus: ");
        String namaMinuman = scanner.nextLine();
    
        Minuman minuman = null;
        for (Minuman m : daftarMinuman) {
            if (m.getNama().equalsIgnoreCase(namaMinuman)) {
                minuman = m;
                break;
            }
        }
    
        if (minuman == null) {
            System.out.println("Minuman dengan nama \"" + namaMinuman + "\" tidak ditemukan!");
            return;
        }
    
        // Hapus minuman dari database
        hapusMinumanDariDatabase(minuman.getId());
    
        // Hapus minuman dari daftar lokal
        daftarMinuman.remove(minuman);
    
        System.out.println("MINUMAN BERHASIL DIHAPUS");
    }
    
    private static void hapusMinumanDariDatabase(int minumanId) {
        String sql = "DELETE FROM minuman WHERE id = ?";
    
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
    
            statement.setInt(1, minumanId);
    
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Minuman dengan ID " + minumanId + " berhasil dihapus dari database.");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    
    








    private static final int inputAngka() {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                input = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Masukkan angka !!!");
                scanner.nextLine();
                System.out.print("Masukkan kembali: ");
            }
        }

        scanner.nextLine();
        return input;
    }

}