import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author = Ahmad Fathanah M.Adil
 * 
**/

public class Hangman extends javax.swing.JFrame {
    
    String tebakan;
    String clue;
    int skorSementara;
    int tambahSkor;
    int maxSkor = 500;
    int kesempatan = 6;
    
    char[] bufferObject;
    String[] gameObejct;
    ArrayList<String> guessAnswer;
    int amountOFCorrectInput = 0;
    int time = 0;
    boolean startTime  = false;
    boolean begin = false;
    
    int sejarahCekPoint = 1;
    int filmcekPoint = 1;
    int bendaCekPoint = 1;
    int aktorCekPoint = 1;
    int selectedKategori;
    int selectedLevel;
      
    
    public Hangman() {   
        initComponents();    
        playbtnBENDA.setEnabled(false);
        playbtnAKTOR.setEnabled(false);
        playbtnSEJARAH.setEnabled(false);
        playbtnFILM.setEnabled(false);
        sejarah_lvl1.setEnabled(false);
        sejarah_lvl2.setEnabled(false);
        sejarah_lvl3.setEnabled(false);
        sejarah_lvl4.setEnabled(false);
        sejarah_lvl5.setEnabled(false);
        sejarah_lvl6.setEnabled(false);
        sejarah_lvl7.setEnabled(false);
        sejarah_lvl8.setEnabled(false);
        sejarah_lvl9.setEnabled(false);
        sejarah_lvl10.setEnabled(false);
        film_lvl1.setEnabled(false);
        film_lvl2.setEnabled(false);
        film_lvl3.setEnabled(false);
        film_lvl4.setEnabled(false);
        film_lvl5.setEnabled(false);
        film_lvl6.setEnabled(false);
        film_lvl7.setEnabled(false);
        film_lvl8.setEnabled(false);
        film_lvl9.setEnabled(false);
        film_lvl10.setEnabled(false);
        benda_lvl1.setEnabled(false);
        benda_lvl2.setEnabled(false);
        benda_lvl3.setEnabled(false);
        benda_lvl4.setEnabled(false);
        benda_lvl5.setEnabled(false);
        benda_lvl6.setEnabled(false);
        benda_lvl7.setEnabled(false);
        benda_lvl8.setEnabled(false);
        benda_lvl9.setEnabled(false);
        benda_lvl10.setEnabled(false);
        aktor_lvl1.setEnabled(false);
        aktor_lvl2.setEnabled(false);
        aktor_lvl3.setEnabled(false);
        aktor_lvl4.setEnabled(false);
        aktor_lvl5.setEnabled(false);
        aktor_lvl6.setEnabled(false);
        aktor_lvl7.setEnabled(false);
        aktor_lvl8.setEnabled(false);
        aktor_lvl9.setEnabled(false);
        aktor_lvl10.setEnabled(false);
        nextLevel.setEnabled(false);
        reStartBtn.setEnabled(false);
        
        try{
            cekDatabase();
            getSaveData();
        } catch (IOException e) {}   
        
        cekLevel();      
    }
   
    private void cekDatabase() throws IOException{
        //Create File if File does not exist
        File sejarahFile = new File("Sejarah_Kategori.txt");
        File filmFile = new File("Film_Kategori.txt");
        File bendaFile = new File("Benda_Kategori.txt");
        File aktorFile = new File("Aktor_Kategori.txt");
        
        
            if(!sejarahFile.exists()) {
                sejarahFile.createNewFile();
                BufferedWriter writeToFile = new BufferedWriter(new FileWriter(sejarahFile));
                writeToFile.write("AHMAD FATHANAH_Creator of this program");
                writeToFile.newLine();
                writeToFile.write("INDONESIA_Negara Yang Dijajah Oleh Belanda Dan Jepang");
                writeToFile.newLine();
                writeToFile.write("SOEKARNO_Presiden Pertama negara Indonesia");
                writeToFile.newLine();
                writeToFile.write("17 AGUSTUS 1945_Tanggal Kemerdekaan Negara Republik Indoenesia");
                writeToFile.newLine();                
                writeToFile.write("fatmawati_Orang Yang Menjahit Bendera Indonesia Pertama Kali");
                writeToFile.newLine();
                writeToFile.write("nagasaki_Kota Yang Dibom Amerika Pada Tanggal 6 Agustus 1945");
                writeToFile.newLine();              
                writeToFile.write("Rengasdengklok_Peristiwa Penculikan Terhadap Soekarno Dan Hatta");
                writeToFile.newLine();
                writeToFile.write("Sayuti Melik_Penulis Naskah Proklamsi Kemerdekaan Indonesia");
                writeToFile.newLine();
                writeToFile.write("Sukarni Kartodiwirjo_Orang Yang Memaksa Soekarno Untuk Memproklamasikan Kemerdekaan");
                writeToFile.newLine();
                writeToFile.write("Radjiman Wedyodiningrat_Mantan Ketua BPUPKI");
                writeToFile.newLine();
                writeToFile.flush();
                writeToFile.close();
            }
            
            if(!filmFile.exists()) {
                filmFile.createNewFile();
                BufferedWriter writeToFile = new BufferedWriter(new FileWriter(filmFile));
                writeToFile.write("Cars_Film animasi dari pixar yang dirilis tahun 2006, film ini menceritakan tentang seorang pembalap bernama lightning mcqueen yang tersesat ke radiator springs");
                writeToFile.newLine();
                writeToFile.write("TOY STORY_Film animasi bergenre komedi yang dibuat oleh pixar, rilis pertama kali pada tahun 1995, pemeran utama film ini bernama woody seorang boneka koboy");
                writeToFile.newLine();
                writeToFile.write("JOHN WICK_Film bergenre thriller aksi dengan permain utamanya Keanu Reeves, rilis pertama kali pada tahun 2014");
                writeToFile.newLine();            
                writeToFile.write("Finding Nemo_Film bergenre animasi rilis pada tahun 2003, Film ini berfokus pada 2 ikan yang bernama marlin dan dory yang sedang mencari anak dari marlin");
                writeToFile.newLine();
                writeToFile.write("Ratatouille_Film bergenre animasi rilis pada tahun 2007, Film ini menceritakan tentang seekor tikus bernama remy yang ingin menjadi seorang koki yang hebat di perancis");
                writeToFile.newLine();
                writeToFile.write("Monster University_Film bergenre komedi animasi rilis tahun 2013, Film ini menceritakan tentang sekelompok monster yang mengambil jurusan menakut-nakuti di sebuah universitas");
                writeToFile.newLine();
                writeToFile.write("The Incredibles_Film bergenre animasi yang dirilis tahun 2004, film ini menceritakan tentang keluarga super hero yang melawan syndrome");
                writeToFile.newLine();
                writeToFile.write("Tom and Jerry_Serial animasi dari amerika serikat, film ini menceriakan tentang seekor kucing dan tikus yang selalu bertengkar");
                writeToFile.newLine();
                writeToFile.write("FAST AND FURIOUS_Film bergenre action, serial pertamanya rilis pada tahun 2001 dengan pemeran utama bernama Paul walker");
                writeToFile.newLine();
                writeToFile.write("The Conjuring_Film bergenre horror yang dirilis pada tahun 2013, film ini dibintangi oleh  Vera Farmiga dan Patrick Wilson yang diangkat dari kisah nyata yang dialami oleh Warren. Film ini mengisahkan tentang investigasi paranormal");
                writeToFile.newLine();
                writeToFile.flush();
                writeToFile.close();
            }
            
            if(!bendaFile.exists()) {
                bendaFile.createNewFile();
            }
            
            if(!aktorFile.exists()) {
                aktorFile.createNewFile();
            }
        
    }
    
    private void getSaveData() throws IOException {
        
        File saveFile = new File("SaveData.txt");
        if(!saveFile.exists()) {
            saveFile.createNewFile();
            BufferedWriter writeToFile = new BufferedWriter(new FileWriter(saveFile));
            writeToFile.write("1:1:1:1");
            writeToFile.newLine();
            writeToFile.flush();
            writeToFile.close();
        }
        
        
        BufferedReader readFile = new BufferedReader(new FileReader(saveFile));
        String savedata = readFile.readLine();
        Scanner datascan = new Scanner(savedata);
        datascan.useDelimiter(":");
        
        sejarahCekPoint = datascan.nextInt();
        filmcekPoint = datascan.nextInt();
        bendaCekPoint = datascan.nextInt();
        aktorCekPoint = datascan.nextInt();
        
        readFile.close();
        
        
    }
    
    private void setSavedata() throws IOException {
        
        BufferedWriter writeToFile = new BufferedWriter(new FileWriter("SaveData.txt"));
        
        switch(selectedKategori) {
            case 1:              
                if(selectedLevel == sejarahCekPoint) {
                    if(sejarahCekPoint != 10) {
                        sejarahCekPoint++;
                    }                  
                }             
                break;
            case 2:
                if(selectedLevel == filmcekPoint) {
                    if(filmcekPoint != 10) {
                        filmcekPoint++;
                    }
                }
                break;
            case 3:
                if(selectedLevel == bendaCekPoint) {
                    if(bendaCekPoint != 10) {
                        bendaCekPoint++;
                    }
                }
                break;
            case 4:
                if(selectedLevel == aktorCekPoint) {
                    if(aktorCekPoint != 10) {
                        aktorCekPoint++;
                    }
                }
                break;
            default:
                break;
        }
        
        writeToFile.write("" + sejarahCekPoint + ":" + filmcekPoint + ":" + bendaCekPoint + ":" + aktorCekPoint);
        writeToFile.flush();
        writeToFile.close();
        
    }
    
    private void cekLevel(){
        //SEJARAH
        switch(sejarahCekPoint) {
            case 1:
                sejarah_lvl1.setEnabled(true);
                break;
            case 2:
                sejarah_lvl1.setEnabled(true);
                sejarah_lvl2.setEnabled(true);
                break;
            case 3:
                sejarah_lvl1.setEnabled(true);
                sejarah_lvl2.setEnabled(true);
                sejarah_lvl3.setEnabled(true);
                break;
            case 4:
                sejarah_lvl1.setEnabled(true);
                sejarah_lvl2.setEnabled(true);
                sejarah_lvl3.setEnabled(true);
                sejarah_lvl4.setEnabled(true);
                break;
            case 5:
                sejarah_lvl1.setEnabled(true);
                sejarah_lvl2.setEnabled(true);
                sejarah_lvl3.setEnabled(true);
                sejarah_lvl4.setEnabled(true);
                sejarah_lvl5.setEnabled(true);
                break;
            case 6:
                sejarah_lvl1.setEnabled(true);
                sejarah_lvl2.setEnabled(true);
                sejarah_lvl3.setEnabled(true);
                sejarah_lvl4.setEnabled(true);
                sejarah_lvl5.setEnabled(true);
                sejarah_lvl6.setEnabled(true);
                break;
            case 7:
                sejarah_lvl1.setEnabled(true);
                sejarah_lvl2.setEnabled(true);
                sejarah_lvl3.setEnabled(true);
                sejarah_lvl4.setEnabled(true);
                sejarah_lvl5.setEnabled(true);
                sejarah_lvl6.setEnabled(true);
                sejarah_lvl7.setEnabled(true);
                break;
            case 8:
                sejarah_lvl1.setEnabled(true);
                sejarah_lvl2.setEnabled(true);
                sejarah_lvl3.setEnabled(true);
                sejarah_lvl4.setEnabled(true);
                sejarah_lvl5.setEnabled(true);
                sejarah_lvl6.setEnabled(true);
                sejarah_lvl7.setEnabled(true);
                sejarah_lvl8.setEnabled(true);
                break;
            case 9:
                sejarah_lvl1.setEnabled(true);
                sejarah_lvl2.setEnabled(true);
                sejarah_lvl3.setEnabled(true);
                sejarah_lvl4.setEnabled(true);
                sejarah_lvl5.setEnabled(true);
                sejarah_lvl6.setEnabled(true);
                sejarah_lvl7.setEnabled(true);
                sejarah_lvl8.setEnabled(true);
                sejarah_lvl9.setEnabled(true);
                break;
            case 10:
                sejarah_lvl1.setEnabled(true);
                sejarah_lvl2.setEnabled(true);
                sejarah_lvl3.setEnabled(true);
                sejarah_lvl4.setEnabled(true);
                sejarah_lvl5.setEnabled(true);
                sejarah_lvl6.setEnabled(true);
                sejarah_lvl7.setEnabled(true);
                sejarah_lvl8.setEnabled(true);
                sejarah_lvl9.setEnabled(true);
                sejarah_lvl10.setEnabled(true);
                break;
            default:
                break;
                    
        }
        
        
        //FILM
        switch(filmcekPoint) {
            case 1:
                film_lvl1.setEnabled(true);
                break;
            case 2:
                film_lvl1.setEnabled(true);
                film_lvl2.setEnabled(true);
                break;
            case 3:
                film_lvl1.setEnabled(true);
                film_lvl2.setEnabled(true);
                film_lvl3.setEnabled(true);
                break;
            case 4:
                film_lvl1.setEnabled(true);
                film_lvl2.setEnabled(true);
                film_lvl3.setEnabled(true);
                film_lvl4.setEnabled(true);
                break;
            case 5:
                film_lvl1.setEnabled(true);
                film_lvl2.setEnabled(true);
                film_lvl3.setEnabled(true);
                film_lvl4.setEnabled(true);
                film_lvl5.setEnabled(true);
                break;
            case 6:
                film_lvl1.setEnabled(true);
                film_lvl2.setEnabled(true);
                film_lvl3.setEnabled(true);
                film_lvl4.setEnabled(true);
                film_lvl5.setEnabled(true);
                film_lvl6.setEnabled(true);
                break;
            case 7:
                film_lvl1.setEnabled(true);
                film_lvl2.setEnabled(true);
                film_lvl3.setEnabled(true);
                film_lvl4.setEnabled(true);
                film_lvl5.setEnabled(true);
                film_lvl6.setEnabled(true);
                film_lvl7.setEnabled(true);
                break;
            case 8:
                film_lvl1.setEnabled(true);
                film_lvl2.setEnabled(true);
                film_lvl3.setEnabled(true);
                film_lvl4.setEnabled(true);
                film_lvl5.setEnabled(true);
                film_lvl6.setEnabled(true);
                film_lvl7.setEnabled(true);
                film_lvl8.setEnabled(true);
                break;
            case 9:
                film_lvl1.setEnabled(true);
                film_lvl2.setEnabled(true);
                film_lvl3.setEnabled(true);
                film_lvl4.setEnabled(true);
                film_lvl5.setEnabled(true);
                film_lvl6.setEnabled(true);
                film_lvl7.setEnabled(true);
                film_lvl8.setEnabled(true);
                film_lvl9.setEnabled(true);
                break;
            case 10:
                film_lvl1.setEnabled(true);
                film_lvl2.setEnabled(true);
                film_lvl3.setEnabled(true);
                film_lvl4.setEnabled(true);
                film_lvl5.setEnabled(true);
                film_lvl6.setEnabled(true);
                film_lvl7.setEnabled(true);
                film_lvl8.setEnabled(true);
                film_lvl9.setEnabled(true);
                film_lvl10.setEnabled(true);
                break;
            default:
                break;
                    
        }
        
        //BENDA
        switch(bendaCekPoint) {
            case 1:
                benda_lvl1.setEnabled(true);
                break;
            case 2:
                benda_lvl1.setEnabled(true);
                benda_lvl2.setEnabled(true);
                break;
            case 3:
                benda_lvl1.setEnabled(true);
                benda_lvl2.setEnabled(true);
                benda_lvl3.setEnabled(true);
                break;
            case 4:
                benda_lvl1.setEnabled(true);
                benda_lvl2.setEnabled(true);
                benda_lvl3.setEnabled(true);
                benda_lvl4.setEnabled(true);
                break;
            case 5:
                benda_lvl1.setEnabled(true);
                benda_lvl2.setEnabled(true);
                benda_lvl3.setEnabled(true);
                benda_lvl4.setEnabled(true);
                benda_lvl5.setEnabled(true);
                break;
            case 6:
                benda_lvl1.setEnabled(true);
                benda_lvl2.setEnabled(true);
                benda_lvl3.setEnabled(true);
                benda_lvl4.setEnabled(true);
                benda_lvl5.setEnabled(true);
                benda_lvl6.setEnabled(true);
                break;
            case 7:
                benda_lvl1.setEnabled(true);
                benda_lvl2.setEnabled(true);
                benda_lvl3.setEnabled(true);
                benda_lvl4.setEnabled(true);
                benda_lvl5.setEnabled(true);
                benda_lvl6.setEnabled(true);
                benda_lvl7.setEnabled(true);
                break;
            case 8:
                benda_lvl1.setEnabled(true);
                benda_lvl2.setEnabled(true);
                benda_lvl3.setEnabled(true);
                benda_lvl4.setEnabled(true);
                benda_lvl5.setEnabled(true);
                benda_lvl6.setEnabled(true);
                benda_lvl7.setEnabled(true);
                benda_lvl8.setEnabled(true);
                break;
            case 9:
                benda_lvl1.setEnabled(true);
                benda_lvl2.setEnabled(true);
                benda_lvl3.setEnabled(true);
                benda_lvl4.setEnabled(true);
                benda_lvl5.setEnabled(true);
                benda_lvl6.setEnabled(true);
                benda_lvl7.setEnabled(true);
                benda_lvl8.setEnabled(true);
                benda_lvl9.setEnabled(true);
                break;
            case 10:
                benda_lvl1.setEnabled(true);
                benda_lvl2.setEnabled(true);
                benda_lvl3.setEnabled(true);
                benda_lvl4.setEnabled(true);
                benda_lvl5.setEnabled(true);
                benda_lvl6.setEnabled(true);
                benda_lvl7.setEnabled(true);
                benda_lvl8.setEnabled(true);
                benda_lvl9.setEnabled(true);
                benda_lvl10.setEnabled(true);
                break;
            default:
                break;
                    
        }
        
        //AKTOR
        switch(aktorCekPoint) {
            case 1:
                aktor_lvl1.setEnabled(true);
                break;
            case 2:
                aktor_lvl1.setEnabled(true);
                aktor_lvl2.setEnabled(true);
                break;
            case 3:
                aktor_lvl1.setEnabled(true);
                aktor_lvl2.setEnabled(true);
                aktor_lvl3.setEnabled(true);
                break;
            case 4:
                aktor_lvl1.setEnabled(true);
                aktor_lvl2.setEnabled(true);
                aktor_lvl3.setEnabled(true);
                aktor_lvl4.setEnabled(true);
                break;
            case 5:
                aktor_lvl1.setEnabled(true);
                aktor_lvl2.setEnabled(true);
                aktor_lvl3.setEnabled(true);
                aktor_lvl4.setEnabled(true);
                aktor_lvl5.setEnabled(true);
                break;
            case 6:
                aktor_lvl1.setEnabled(true);
                aktor_lvl2.setEnabled(true);
                aktor_lvl3.setEnabled(true);
                aktor_lvl4.setEnabled(true);
                aktor_lvl5.setEnabled(true);
                aktor_lvl6.setEnabled(true);
                break;
            case 7:
                aktor_lvl1.setEnabled(true);
                aktor_lvl2.setEnabled(true);
                aktor_lvl3.setEnabled(true);
                aktor_lvl4.setEnabled(true);
                aktor_lvl5.setEnabled(true);
                aktor_lvl6.setEnabled(true);
                aktor_lvl7.setEnabled(true);
                break;
            case 8:
                aktor_lvl1.setEnabled(true);
                aktor_lvl2.setEnabled(true);
                aktor_lvl3.setEnabled(true);
                aktor_lvl4.setEnabled(true);
                aktor_lvl5.setEnabled(true);
                aktor_lvl6.setEnabled(true);
                aktor_lvl7.setEnabled(true);
                aktor_lvl8.setEnabled(true);
                break;
            case 9:
                aktor_lvl1.setEnabled(true);
                aktor_lvl2.setEnabled(true);
                aktor_lvl3.setEnabled(true);
                aktor_lvl4.setEnabled(true);
                aktor_lvl5.setEnabled(true);
                aktor_lvl6.setEnabled(true);
                aktor_lvl7.setEnabled(true);
                aktor_lvl8.setEnabled(true);
                aktor_lvl9.setEnabled(true);
                break;
            case 10:
                aktor_lvl1.setEnabled(true);
                aktor_lvl2.setEnabled(true);
                aktor_lvl3.setEnabled(true);
                aktor_lvl4.setEnabled(true);
                aktor_lvl5.setEnabled(true);
                aktor_lvl6.setEnabled(true);
                aktor_lvl7.setEnabled(true);
                aktor_lvl8.setEnabled(true);
                aktor_lvl9.setEnabled(true);
                aktor_lvl10.setEnabled(true);
                break;
            default:
                break;
                    
        }
        
        
    }
    
    private void getHangman(int chance) {
        
        switch(chance) {
            case 6:
                showHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/hangman-base.png")));
                break;
            case 5:
                showHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/hangman-1.png")));
                break;
            case 4:
                showHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/hangman-2.png")));
                break;
            case 3:
                showHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/hangman-3.png")));
                break;
            case 2:
                showHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/hangman-4.png")));
                break;
            case 1:
                showHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/hangman-5.png")));
                break;
            case 0:
                showHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/hangman-6.png")));
                break;
            default:
                break;
        }
        
    }
    
    private  void timerStart() {
        time = 30;
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                
                while (time > 0) {
                    if (startTime == true) {
                        try {                                                                           
                            timeLabel.setText("Sisa Waktu : " + time);  
                            Thread.sleep(1000);
                            time--;  
                                                                               
                            if(time == 0) {
                                startTime = false;
                                timeLabel.setText("Time out, You Failed !!!");  
                                enterbtnGameBegin.setEnabled(false);   
                                reStartBtn.setEnabled(true);
                                nextLevel.setEnabled(false);
                            }
                            
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }                 
                }                       
            }
        });
        
        timer.start();
        
    }
    
    private void getTebakan() throws IOException {
        
        int baris = 0;
        
        switch(selectedKategori) {
            case 1:
                //SEJARAH
                kategoriField.setText("Kategori : Sejarah");
                BufferedReader readFile = new BufferedReader(new FileReader("Sejarah_Kategori.txt"));
                String data = readFile.readLine();
                
                while (data != null) {
                    baris++;
                    
                    if(baris == selectedLevel) {
                        Scanner datascan = new Scanner(data);
                        datascan.useDelimiter("_");
                        tebakan = datascan.next();
                        clue = datascan.next();
                        break;
                    }                  
                    data = readFile.readLine();
                }                  
                break;   
                
            case 2:
                //FILM
                kategoriField.setText("Kategori : Film");
                BufferedReader readFile2 = new BufferedReader(new FileReader("Film_Kategori.txt"));
                String data2 = readFile2.readLine();
                
                while (data2 != null) {
                    baris++;
                    
                    if(baris == selectedLevel) {
                        Scanner datascan = new Scanner(data2);
                        datascan.useDelimiter("_");
                        tebakan = datascan.next();
                        clue = datascan.next();
                        break;
                    }                  
                    data2 = readFile2.readLine();
                }           
                
                break;
            case 3:
                break;
            case 4:
                break;               
            default:
                break;
                    
        }
        
    }
    
    private String printList(ArrayList<String> list) {
        String content = "";
        
        for (int i = 0; i < list.size(); i++) {
            content  += ""+ list.get(i) + " ";
        }
        
        return content;
    }
    
    private void cekInputan() {
        
        int checkpoint = 0;
        
       for(int i = 0; i < gameObejct.length; i++) {
          
           if(gameObejct[i].equalsIgnoreCase(inputField.getText().toString())) {
               String el = inputField.getText().toString();
               String cek = guessAnswer.get(i);
               if(cek.equals("_")) {
                   amountOFCorrectInput--;
                   guessAnswer.set(i, el.toUpperCase());
                   skorSementara += tambahSkor;
               } else {
                   kesempatan--;
                   tambahSkor = tambahSkor - 3;
                   break;
               }
               
           } else {
               checkpoint++;
           } 
       }
       
       if(checkpoint == gameObejct.length) {
           kesempatan--;
           tambahSkor = tambahSkor - 2;
       }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        bodyPanel = new javax.swing.JPanel();
        homeScreen = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        homebtn = new javax.swing.JButton();
        aboutbtn = new javax.swing.JButton();
        playbtn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        homepanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        categoryPanel = new javax.swing.JPanel();
        filmbtn = new javax.swing.JButton();
        sejarahbtn = new javax.swing.JButton();
        namaBendabtn = new javax.swing.JButton();
        aktorbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        aboutPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        SejarahPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sejarah_lvl1 = new javax.swing.JButton();
        sejarah_lvl2 = new javax.swing.JButton();
        sejarah_lvl4 = new javax.swing.JButton();
        sejarah_lvl3 = new javax.swing.JButton();
        sejarah_lvl5 = new javax.swing.JButton();
        sejarah_lvl6 = new javax.swing.JButton();
        sejarah_lvl7 = new javax.swing.JButton();
        sejarah_lvl8 = new javax.swing.JButton();
        sejarah_lvl9 = new javax.swing.JButton();
        sejarah_lvl10 = new javax.swing.JButton();
        sejarahlvl = new javax.swing.JLabel();
        playbtnSEJARAH = new javax.swing.JButton();
        filmPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        film_lvl2 = new javax.swing.JButton();
        film_lvl1 = new javax.swing.JButton();
        film_lvl3 = new javax.swing.JButton();
        film_lvl4 = new javax.swing.JButton();
        film_lvl5 = new javax.swing.JButton();
        film_lvl6 = new javax.swing.JButton();
        film_lvl7 = new javax.swing.JButton();
        film_lvl8 = new javax.swing.JButton();
        film_lvl9 = new javax.swing.JButton();
        film_lvl10 = new javax.swing.JButton();
        FilmLevel = new javax.swing.JLabel();
        playbtnFILM = new javax.swing.JButton();
        bendaPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        benda_lvl1 = new javax.swing.JButton();
        benda_lvl2 = new javax.swing.JButton();
        benda_lvl3 = new javax.swing.JButton();
        benda_lvl4 = new javax.swing.JButton();
        benda_lvl5 = new javax.swing.JButton();
        benda_lvl6 = new javax.swing.JButton();
        benda_lvl8 = new javax.swing.JButton();
        benda_lvl7 = new javax.swing.JButton();
        benda_lvl9 = new javax.swing.JButton();
        benda_lvl10 = new javax.swing.JButton();
        bendaLevel = new javax.swing.JLabel();
        playbtnBENDA = new javax.swing.JButton();
        aktorPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        aktor_lvl1 = new javax.swing.JButton();
        aktor_lvl2 = new javax.swing.JButton();
        aktor_lvl3 = new javax.swing.JButton();
        aktor_lvl5 = new javax.swing.JButton();
        aktor_lvl4 = new javax.swing.JButton();
        aktor_lvl6 = new javax.swing.JButton();
        aktor_lvl7 = new javax.swing.JButton();
        aktor_lvl8 = new javax.swing.JButton();
        aktor_lvl9 = new javax.swing.JButton();
        aktor_lvl10 = new javax.swing.JButton();
        aktorLevel = new javax.swing.JLabel();
        playbtnAKTOR = new javax.swing.JButton();
        gameBeginPanel = new javax.swing.JPanel();
        scoreField = new javax.swing.JTextField();
        chanceField = new javax.swing.JTextField();
        showHangman = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        enterbtnGameBegin = new javax.swing.JButton();
        inputField = new javax.swing.JTextField();
        TebakanField = new javax.swing.JTextField();
        nextLevel = new javax.swing.JButton();
        homebtnGameBegin = new javax.swing.JButton();
        timeLabel = new javax.swing.JLabel();
        levelField = new javax.swing.JTextField();
        kategoriField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        clueArea = new javax.swing.JTextArea();
        sisaLabel = new javax.swing.JLabel();
        reStartBtn = new javax.swing.JButton();
        readyPanel = new javax.swing.JPanel();
        runDown = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        comingSoonPanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        kembalibtnComingSoon = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jRadioButton1.setText("jRadioButton1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman Game");
        setLocation(new java.awt.Point(400, 150));
        setResizable(false);

        bodyPanel.setLayout(new java.awt.CardLayout());

        menuPanel.setBackground(new java.awt.Color(102, 102, 102));

        homebtn.setBackground(new java.awt.Color(101, 39, 44));
        homebtn.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        homebtn.setForeground(new java.awt.Color(255, 255, 255));
        homebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("icon/home.png"))); // NOI18N
        homebtn.setText("Home");
        homebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtnActionPerformed(evt);
            }
        });

        aboutbtn.setBackground(new java.awt.Color(101, 39, 44));
        aboutbtn.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        aboutbtn.setForeground(new java.awt.Color(255, 255, 255));
        aboutbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("icon/about.png"))); // NOI18N
        aboutbtn.setText("About");
        aboutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutbtnActionPerformed(evt);
            }
        });

        playbtn.setBackground(new java.awt.Color(101, 39, 44));
        playbtn.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        playbtn.setForeground(new java.awt.Color(255, 255, 255));
        playbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("icon/playbtn.png"))); // NOI18N
        playbtn.setText("Play");
        playbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbtnActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("WELCOME");

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(homebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(playbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(aboutbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel15)
                .addGap(84, 84, 84)
                .addComponent(homebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(playbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(aboutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 32)); // NOI18N
        jLabel1.setText("Hangman Game");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/hangman-6.png"))); // NOI18N

        javax.swing.GroupLayout homepanelLayout = new javax.swing.GroupLayout(homepanel);
        homepanel.setLayout(homepanelLayout);
        homepanelLayout.setHorizontalGroup(
            homepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepanelLayout.createSequentialGroup()
                .addGroup(homepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(homepanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, homepanelLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel2)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        homepanelLayout.setVerticalGroup(
            homepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        mainPanel.add(homepanel, "card2");

        filmbtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        filmbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("icon/movie.png"))); // NOI18N
        filmbtn.setText("Film");
        filmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmbtnActionPerformed(evt);
            }
        });

        sejarahbtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sejarahbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("icon/sejarah.png"))); // NOI18N
        sejarahbtn.setText("Sejarah");
        sejarahbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sejarahbtnActionPerformed(evt);
            }
        });

        namaBendabtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        namaBendabtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("icon/benda.png"))); // NOI18N
        namaBendabtn.setText("Benda");
        namaBendabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaBendabtnActionPerformed(evt);
            }
        });

        aktorbtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        aktorbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("icon/actor.png"))); // NOI18N
        aktorbtn.setText("Aktor");
        aktorbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktorbtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Silahkan Pilih Kategori Pertanyaan");

        javax.swing.GroupLayout categoryPanelLayout = new javax.swing.GroupLayout(categoryPanel);
        categoryPanel.setLayout(categoryPanelLayout);
        categoryPanelLayout.setHorizontalGroup(
            categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoryPanelLayout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoryPanelLayout.createSequentialGroup()
                        .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(categoryPanelLayout.createSequentialGroup()
                                .addComponent(namaBendabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(aktorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(categoryPanelLayout.createSequentialGroup()
                                .addComponent(sejarahbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
        );
        categoryPanelLayout.setVerticalGroup(
            categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoryPanelLayout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(54, 54, 54)
                .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sejarahbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaBendabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aktorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(183, 183, 183))
        );

        mainPanel.add(categoryPanel, "card3");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Hangman Game");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("by Ahmad Fathanah M.Adil");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("Contact :");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Instagram : AhmadFMA_", "Facebook : Ahmad Fathanah M.Adil", "LinkedIn   : Ahmad Fathanah M.Adil" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout aboutPanelLayout = new javax.swing.GroupLayout(aboutPanel);
        aboutPanel.setLayout(aboutPanelLayout);
        aboutPanelLayout.setHorizontalGroup(
            aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutPanelLayout.createSequentialGroup()
                .addGroup(aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(aboutPanelLayout.createSequentialGroup()
                            .addGap(211, 211, 211)
                            .addComponent(jLabel4))
                        .addGroup(aboutPanelLayout.createSequentialGroup()
                            .addGap(178, 178, 178)
                            .addComponent(jLabel5))
                        .addGroup(aboutPanelLayout.createSequentialGroup()
                            .addGap(128, 128, 128)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        aboutPanelLayout.setVerticalGroup(
            aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutPanelLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(49, 49, 49)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        mainPanel.add(aboutPanel, "card4");

        jLabel6.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        jLabel6.setText("Kategori : Sejarah");

        jLabel7.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel7.setText("Pilih Level");

        sejarah_lvl1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        sejarah_lvl1.setText("1");
        sejarah_lvl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sejarah_lvl1ActionPerformed(evt);
            }
        });

        sejarah_lvl2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        sejarah_lvl2.setText("2");
        sejarah_lvl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sejarah_lvl2ActionPerformed(evt);
            }
        });

        sejarah_lvl4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        sejarah_lvl4.setText("4");
        sejarah_lvl4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sejarah_lvl4ActionPerformed(evt);
            }
        });

        sejarah_lvl3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        sejarah_lvl3.setText("3");
        sejarah_lvl3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sejarah_lvl3ActionPerformed(evt);
            }
        });

        sejarah_lvl5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        sejarah_lvl5.setText("5");
        sejarah_lvl5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sejarah_lvl5ActionPerformed(evt);
            }
        });

        sejarah_lvl6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        sejarah_lvl6.setText("6");
        sejarah_lvl6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sejarah_lvl6ActionPerformed(evt);
            }
        });

        sejarah_lvl7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        sejarah_lvl7.setText("7");
        sejarah_lvl7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sejarah_lvl7ActionPerformed(evt);
            }
        });

        sejarah_lvl8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        sejarah_lvl8.setText("8");
        sejarah_lvl8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sejarah_lvl8ActionPerformed(evt);
            }
        });

        sejarah_lvl9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        sejarah_lvl9.setText("9");
        sejarah_lvl9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sejarah_lvl9ActionPerformed(evt);
            }
        });

        sejarah_lvl10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        sejarah_lvl10.setText("10");
        sejarah_lvl10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sejarah_lvl10ActionPerformed(evt);
            }
        });

        sejarahlvl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sejarahlvl.setText("Level :");

        playbtnSEJARAH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        playbtnSEJARAH.setIcon(new javax.swing.ImageIcon(getClass().getResource("icon/playbtn.png"))); // NOI18N
        playbtnSEJARAH.setText("Play");
        playbtnSEJARAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbtnSEJARAHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SejarahPanelLayout = new javax.swing.GroupLayout(SejarahPanel);
        SejarahPanel.setLayout(SejarahPanelLayout);
        SejarahPanelLayout.setHorizontalGroup(
            SejarahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SejarahPanelLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(SejarahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sejarah_lvl6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sejarah_lvl1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(SejarahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sejarah_lvl2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sejarah_lvl7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(SejarahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sejarah_lvl3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sejarah_lvl8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(SejarahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sejarah_lvl9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sejarah_lvl4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(SejarahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sejarah_lvl5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sejarah_lvl10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(SejarahPanelLayout.createSequentialGroup()
                .addGroup(SejarahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SejarahPanelLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addGroup(SejarahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sejarahlvl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playbtnSEJARAH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(SejarahPanelLayout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SejarahPanelLayout.setVerticalGroup(
            SejarahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SejarahPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel6)
                .addGap(53, 53, 53)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(SejarahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sejarah_lvl1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sejarah_lvl2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sejarah_lvl4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sejarah_lvl3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sejarah_lvl5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SejarahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sejarah_lvl6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sejarah_lvl7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sejarah_lvl8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sejarah_lvl9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sejarah_lvl10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(sejarahlvl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playbtnSEJARAH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        mainPanel.add(SejarahPanel, "card5");

        jLabel9.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        jLabel9.setText("Kategori : Film");

        jLabel10.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel10.setText("Pilih Level");

        film_lvl2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        film_lvl2.setText("2");
        film_lvl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                film_lvl2ActionPerformed(evt);
            }
        });

        film_lvl1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        film_lvl1.setText("1");
        film_lvl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                film_lvl1ActionPerformed(evt);
            }
        });

        film_lvl3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        film_lvl3.setText("3");
        film_lvl3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                film_lvl3ActionPerformed(evt);
            }
        });

        film_lvl4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        film_lvl4.setText("4");
        film_lvl4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                film_lvl4ActionPerformed(evt);
            }
        });

        film_lvl5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        film_lvl5.setText("5");
        film_lvl5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                film_lvl5ActionPerformed(evt);
            }
        });

        film_lvl6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        film_lvl6.setText("6");
        film_lvl6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                film_lvl6ActionPerformed(evt);
            }
        });

        film_lvl7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        film_lvl7.setText("7");
        film_lvl7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                film_lvl7ActionPerformed(evt);
            }
        });

        film_lvl8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        film_lvl8.setText("8");
        film_lvl8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                film_lvl8ActionPerformed(evt);
            }
        });

        film_lvl9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        film_lvl9.setText("9");
        film_lvl9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                film_lvl9ActionPerformed(evt);
            }
        });

        film_lvl10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        film_lvl10.setText("10");
        film_lvl10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                film_lvl10ActionPerformed(evt);
            }
        });

        FilmLevel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        FilmLevel.setText("Level :");

        playbtnFILM.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        playbtnFILM.setIcon(new javax.swing.ImageIcon(getClass().getResource("icon/playbtn.png"))); // NOI18N
        playbtnFILM.setText("Play");
        playbtnFILM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbtnFILMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filmPanelLayout = new javax.swing.GroupLayout(filmPanel);
        filmPanel.setLayout(filmPanelLayout);
        filmPanelLayout.setHorizontalGroup(
            filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filmPanelLayout.createSequentialGroup()
                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filmPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(filmPanelLayout.createSequentialGroup()
                                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(film_lvl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(film_lvl6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(film_lvl2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(film_lvl7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(filmPanelLayout.createSequentialGroup()
                                        .addComponent(film_lvl3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(film_lvl4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(filmPanelLayout.createSequentialGroup()
                                        .addComponent(film_lvl8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(film_lvl9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(FilmLevel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(playbtnFILM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(30, 30, 30)
                        .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(film_lvl5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(film_lvl10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(filmPanelLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel9)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        filmPanelLayout.setVerticalGroup(
            filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filmPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel9)
                .addGap(52, 52, 52)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(film_lvl1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(film_lvl2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(film_lvl3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(film_lvl4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(film_lvl5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(film_lvl6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(film_lvl7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(film_lvl8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(film_lvl9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(film_lvl10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(FilmLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playbtnFILM, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        mainPanel.add(filmPanel, "card6");

        jLabel13.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        jLabel13.setText("Kategori : Nama Benda");

        jLabel14.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel14.setText("Pilih Level");

        benda_lvl1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        benda_lvl1.setText("1");
        benda_lvl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benda_lvl1ActionPerformed(evt);
            }
        });

        benda_lvl2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        benda_lvl2.setText("2");
        benda_lvl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benda_lvl2ActionPerformed(evt);
            }
        });

        benda_lvl3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        benda_lvl3.setText("3");
        benda_lvl3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benda_lvl3ActionPerformed(evt);
            }
        });

        benda_lvl4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        benda_lvl4.setText("4");
        benda_lvl4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benda_lvl4ActionPerformed(evt);
            }
        });

        benda_lvl5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        benda_lvl5.setText("5");
        benda_lvl5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benda_lvl5ActionPerformed(evt);
            }
        });

        benda_lvl6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        benda_lvl6.setText("6");
        benda_lvl6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benda_lvl6ActionPerformed(evt);
            }
        });

        benda_lvl8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        benda_lvl8.setText("8");
        benda_lvl8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benda_lvl8ActionPerformed(evt);
            }
        });

        benda_lvl7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        benda_lvl7.setText("7");
        benda_lvl7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benda_lvl7ActionPerformed(evt);
            }
        });

        benda_lvl9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        benda_lvl9.setText("9");
        benda_lvl9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benda_lvl9ActionPerformed(evt);
            }
        });

        benda_lvl10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        benda_lvl10.setText("10");
        benda_lvl10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benda_lvl10ActionPerformed(evt);
            }
        });

        bendaLevel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bendaLevel.setText("Level :");

        playbtnBENDA.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        playbtnBENDA.setIcon(new javax.swing.ImageIcon(getClass().getResource("icon/playbtn.png"))); // NOI18N
        playbtnBENDA.setText("Play");
        playbtnBENDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbtnBENDAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bendaPanelLayout = new javax.swing.GroupLayout(bendaPanel);
        bendaPanel.setLayout(bendaPanelLayout);
        bendaPanelLayout.setHorizontalGroup(
            bendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bendaPanelLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(bendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addGroup(bendaPanelLayout.createSequentialGroup()
                        .addGroup(bendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(benda_lvl1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(benda_lvl6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(bendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(benda_lvl2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(benda_lvl7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(bendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(benda_lvl3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(benda_lvl8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(bendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(benda_lvl4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(benda_lvl9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(bendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bendaLevel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playbtnBENDA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(34, 34, 34)
                .addGroup(bendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(benda_lvl10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(benda_lvl5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        bendaPanelLayout.setVerticalGroup(
            bendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bendaPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel13)
                .addGap(41, 41, 41)
                .addComponent(jLabel14)
                .addGap(27, 27, 27)
                .addGroup(bendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(benda_lvl1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(benda_lvl2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(benda_lvl3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(benda_lvl4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(benda_lvl5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(bendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(benda_lvl6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(benda_lvl7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(benda_lvl8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(benda_lvl9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(benda_lvl10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(bendaLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playbtnBENDA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        mainPanel.add(bendaPanel, "card7");

        jLabel16.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        jLabel16.setText("Kategori : Aktor");

        jLabel17.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel17.setText("Pilih Level");

        aktor_lvl1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        aktor_lvl1.setText("1");
        aktor_lvl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktor_lvl1ActionPerformed(evt);
            }
        });

        aktor_lvl2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        aktor_lvl2.setText("2");
        aktor_lvl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktor_lvl2ActionPerformed(evt);
            }
        });

        aktor_lvl3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        aktor_lvl3.setText("3");
        aktor_lvl3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktor_lvl3ActionPerformed(evt);
            }
        });

        aktor_lvl5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        aktor_lvl5.setText("5");
        aktor_lvl5.setToolTipText("");
        aktor_lvl5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktor_lvl5ActionPerformed(evt);
            }
        });

        aktor_lvl4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        aktor_lvl4.setText("4");
        aktor_lvl4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktor_lvl4ActionPerformed(evt);
            }
        });

        aktor_lvl6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        aktor_lvl6.setText("6");
        aktor_lvl6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktor_lvl6ActionPerformed(evt);
            }
        });

        aktor_lvl7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        aktor_lvl7.setText("7");
        aktor_lvl7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktor_lvl7ActionPerformed(evt);
            }
        });

        aktor_lvl8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        aktor_lvl8.setText("8");
        aktor_lvl8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktor_lvl8ActionPerformed(evt);
            }
        });

        aktor_lvl9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        aktor_lvl9.setText("9");
        aktor_lvl9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktor_lvl9ActionPerformed(evt);
            }
        });

        aktor_lvl10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        aktor_lvl10.setText("10");
        aktor_lvl10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktor_lvl10ActionPerformed(evt);
            }
        });

        aktorLevel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        aktorLevel.setText("Level :");

        playbtnAKTOR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        playbtnAKTOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("icon/playbtn.png"))); // NOI18N
        playbtnAKTOR.setText("Play");
        playbtnAKTOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbtnAKTORActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aktorPanelLayout = new javax.swing.GroupLayout(aktorPanel);
        aktorPanel.setLayout(aktorPanelLayout);
        aktorPanelLayout.setHorizontalGroup(
            aktorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aktorPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(aktorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aktorLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playbtnAKTOR))
                .addGap(214, 214, 214))
            .addGroup(aktorPanelLayout.createSequentialGroup()
                .addGroup(aktorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aktorPanelLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(aktorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aktor_lvl1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aktor_lvl6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(aktorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aktor_lvl2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aktor_lvl7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(aktorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(aktorPanelLayout.createSequentialGroup()
                                .addComponent(aktor_lvl8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aktor_lvl9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(aktorPanelLayout.createSequentialGroup()
                                .addComponent(aktor_lvl3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(aktor_lvl4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(aktorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(aktor_lvl5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aktor_lvl10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(aktorPanelLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel16)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        aktorPanelLayout.setVerticalGroup(
            aktorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aktorPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel16)
                .addGap(51, 51, 51)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aktorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aktor_lvl1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aktor_lvl2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aktor_lvl3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aktor_lvl5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aktor_lvl4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(aktorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aktor_lvl6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aktor_lvl7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aktor_lvl8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aktor_lvl9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aktor_lvl10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(aktorLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playbtnAKTOR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        mainPanel.add(aktorPanel, "card8");

        javax.swing.GroupLayout homeScreenLayout = new javax.swing.GroupLayout(homeScreen);
        homeScreen.setLayout(homeScreenLayout);
        homeScreenLayout.setHorizontalGroup(
            homeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeScreenLayout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homeScreenLayout.setVerticalGroup(
            homeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bodyPanel.add(homeScreen, "card4");

        scoreField.setEditable(false);
        scoreField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        scoreField.setText("Score :");

        chanceField.setEditable(false);
        chanceField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        chanceField.setText("Kesempatan :");

        showHangman.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/hangman-base.png"))); // NOI18N
        showHangman.setText("jLabel8");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Masukkan Tebakan Huruf");

        enterbtnGameBegin.setText("Enter");
        enterbtnGameBegin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterbtnGameBeginActionPerformed(evt);
            }
        });

        inputField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        inputField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TebakanField.setEditable(false);
        TebakanField.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        TebakanField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        nextLevel.setText("Next Level");
        nextLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextLevelActionPerformed(evt);
            }
        });

        homebtnGameBegin.setText("Home");
        homebtnGameBegin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtnGameBeginActionPerformed(evt);
            }
        });

        timeLabel.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("Sisa Waktu :");

        levelField.setEditable(false);
        levelField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        levelField.setText("Level :");

        kategoriField.setEditable(false);
        kategoriField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        kategoriField.setText("Kategori : ");

        clueArea.setEditable(false);
        clueArea.setColumns(20);
        clueArea.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        clueArea.setRows(3);
        clueArea.setText("Clue :");
        clueArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(clueArea);

        sisaLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sisaLabel.setText("Sisa :");

        reStartBtn.setText("Restart");
        reStartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reStartBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gameBeginPanelLayout = new javax.swing.GroupLayout(gameBeginPanel);
        gameBeginPanel.setLayout(gameBeginPanelLayout);
        gameBeginPanelLayout.setHorizontalGroup(
            gameBeginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameBeginPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameBeginPanelLayout.createSequentialGroup()
                .addGroup(gameBeginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameBeginPanelLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(TebakanField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sisaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameBeginPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(gameBeginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chanceField, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(scoreField)
                            .addComponent(levelField)
                            .addComponent(kategoriField, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(13, 13, 13)
                        .addGroup(gameBeginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameBeginPanelLayout.createSequentialGroup()
                                .addComponent(showHangman, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98))
                            .addGroup(gameBeginPanelLayout.createSequentialGroup()
                                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))
                        .addGroup(gameBeginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(homebtnGameBegin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nextLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reStartBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
                    .addGroup(gameBeginPanelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(enterbtnGameBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        gameBeginPanelLayout.setVerticalGroup(
            gameBeginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameBeginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gameBeginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameBeginPanelLayout.createSequentialGroup()
                        .addComponent(scoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(timeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homebtnGameBegin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gameBeginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameBeginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(gameBeginPanelLayout.createSequentialGroup()
                            .addComponent(chanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(levelField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(kategoriField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(showHangman, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gameBeginPanelLayout.createSequentialGroup()
                        .addComponent(nextLevel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reStartBtn)))
                .addGap(26, 26, 26)
                .addGroup(gameBeginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TebakanField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sisaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(gameBeginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameBeginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(enterbtnGameBegin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        bodyPanel.add(gameBeginPanel, "card3");

        runDown.setFont(new java.awt.Font("Arial", 1, 90)); // NOI18N
        runDown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        runDown.setText("3");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("Permainan Dimulai Dalam");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setText("Waktu Anda Hanya 30 Detik");

        javax.swing.GroupLayout readyPanelLayout = new javax.swing.GroupLayout(readyPanel);
        readyPanel.setLayout(readyPanelLayout);
        readyPanelLayout.setHorizontalGroup(
            readyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(readyPanelLayout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addGroup(readyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, readyPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(202, 202, 202))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, readyPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(212, 212, 212))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, readyPanelLayout.createSequentialGroup()
                        .addComponent(runDown, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(276, 276, 276))))
        );
        readyPanelLayout.setVerticalGroup(
            readyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(readyPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel12)
                .addGap(102, 102, 102)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runDown, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        bodyPanel.add(readyPanel, "card4");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel19.setText("COMING SOON");

        kembalibtnComingSoon.setText("Kembali");
        kembalibtnComingSoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembalibtnComingSoonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout comingSoonPanelLayout = new javax.swing.GroupLayout(comingSoonPanel);
        comingSoonPanel.setLayout(comingSoonPanelLayout);
        comingSoonPanelLayout.setHorizontalGroup(
            comingSoonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comingSoonPanelLayout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
            .addGroup(comingSoonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kembalibtnComingSoon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        comingSoonPanelLayout.setVerticalGroup(
            comingSoonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comingSoonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kembalibtnComingSoon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        bodyPanel.add(comingSoonPanel, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void homebtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(homepanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        playbtnBENDA.setEnabled(false);
        playbtnAKTOR.setEnabled(false);
        playbtnSEJARAH.setEnabled(false);
        playbtnFILM.setEnabled(false);
        sejarahlvl.setText("Level : ");
        FilmLevel.setText("Level : ");
        bendaLevel.setText("Level : ");
        aktorLevel.setText("Level : ");
    }                                       

    private void playbtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(categoryPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        playbtnBENDA.setEnabled(false);
        playbtnAKTOR.setEnabled(false);
        playbtnSEJARAH.setEnabled(false);
        playbtnFILM.setEnabled(false);
        sejarahlvl.setText("Level : ");
        FilmLevel.setText("Level : ");
        bendaLevel.setText("Level : ");
        aktorLevel.setText("Level : ");
    }                                       

    private void aboutbtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(aboutPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        playbtnBENDA.setEnabled(false);
        playbtnAKTOR.setEnabled(false);
        playbtnSEJARAH.setEnabled(false);
        playbtnFILM.setEnabled(false);
        sejarahlvl.setText("Level : ");
        FilmLevel.setText("Level : ");
        bendaLevel.setText("Level : ");
        aktorLevel.setText("Level : ");
    }                                        

    private void sejarahbtnActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
         mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(SejarahPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        selectedKategori = 1;
       
    }                                          

    private void filmbtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(filmPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        selectedKategori = 2;
        
    }                                       

    private void namaBendabtnActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(bendaPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        selectedKategori = 3;
        
    }                                            

    private void aktorbtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(aktorPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        selectedKategori = 4;
    }                                        


    /* KATEGORI PANEL */
    
    //SEJARAH
    private void sejarah_lvl1ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        selectedLevel = 1;
        sejarahlvl.setText("Level : " + selectedLevel);
        playbtnSEJARAH.setEnabled(true);
    }                                            

    private void sejarah_lvl2ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        selectedLevel = 2;
        sejarahlvl.setText("Level : " + selectedLevel);
        playbtnSEJARAH.setEnabled(true);
    }                                            

    private void sejarah_lvl3ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        selectedLevel = 3;
        sejarahlvl.setText("Level : " + selectedLevel);
        playbtnSEJARAH.setEnabled(true);
    }                                            

    private void sejarah_lvl4ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        selectedLevel = 4;
        sejarahlvl.setText("Level : " + selectedLevel);
        playbtnSEJARAH.setEnabled(true);
    }                                            

    private void sejarah_lvl5ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        selectedLevel = 5;
        sejarahlvl.setText("Level : " + selectedLevel);
        playbtnSEJARAH.setEnabled(true);
    }                                            

    private void sejarah_lvl6ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        selectedLevel = 6;
        sejarahlvl.setText("Level : " + selectedLevel);
        playbtnSEJARAH.setEnabled(true);
    }                                            

    private void sejarah_lvl7ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        selectedLevel = 7;
        sejarahlvl.setText("Level : " + selectedLevel);
        playbtnSEJARAH.setEnabled(true);
    }                                            

    private void sejarah_lvl8ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        selectedLevel = 8;
        sejarahlvl.setText("Level : " + selectedLevel);
        playbtnSEJARAH.setEnabled(true);
    }                                            

    private void sejarah_lvl9ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        selectedLevel = 9;
        sejarahlvl.setText("Level : " + selectedLevel);
        playbtnSEJARAH.setEnabled(true);
    }                                            

    private void sejarah_lvl10ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        selectedLevel = 10;
        sejarahlvl.setText("Level : " + selectedLevel);
        playbtnSEJARAH.setEnabled(true);
    }                                             

    private void playbtnSEJARAHActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        try {getTebakan(); } catch (IOException e) {}     
        time = 0;
        startTime = true;
        timeLabel.setText("Sisa Waktu : " + time);
        bufferObject = tebakan.toCharArray();
        gameObejct = new String[bufferObject.length];
        tambahSkor = maxSkor / bufferObject.length;
        guessAnswer = new ArrayList<>();
        
        for(int i = 0; i < gameObejct.length; i++) {
            String a = "" + bufferObject[i];
            gameObejct[i] = a.toUpperCase();
        }
        
        for(int i = 0; i < gameObejct.length; i++) {
            if(!gameObejct[i].equals(" ")) {
                guessAnswer.add("_");
                amountOFCorrectInput++;
            } else {
                guessAnswer.add(" ");
            }
        }
        
        TebakanField.setText(printList(guessAnswer));
        scoreField.setText("Score : 0");
        chanceField.setText("Kesempatan : " + kesempatan);
        levelField.setText("Level : " + selectedLevel);
        clueArea.setText("Clue : " + clue);
        sisaLabel.setText("Sisa : " + amountOFCorrectInput);
        enterbtnGameBegin.setEnabled(true);
        
        
        bodyPanel.removeAll();
        bodyPanel.repaint();
        bodyPanel.revalidate();
        
        bodyPanel.add(readyPanel);
        bodyPanel.repaint();
        bodyPanel.revalidate();
        
        
        Thread startGame  = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 3;
                try {
                   
                    while (i > 0) {
                        runDown.setText(""+i);
                        Thread.sleep(1000);
                        i--;                    
                    }
                    bodyPanel.removeAll();
                    bodyPanel.repaint();
                    bodyPanel.revalidate();

                    timerStart();
                    bodyPanel.add(gameBeginPanel);
                    bodyPanel.repaint();
                    bodyPanel.revalidate();
                                  
                } catch (InterruptedException e) {}
            }
        });
        
        startGame.start();
            
    }                                              

    //FILM
    private void film_lvl1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        selectedLevel = 1;
        FilmLevel.setText("Level : " + selectedLevel);
        playbtnFILM.setEnabled(true);
    }                                         

    private void film_lvl2ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        selectedLevel = 2;
        FilmLevel.setText("Level : " + selectedLevel);
        playbtnFILM.setEnabled(true);
    }                                         

    private void film_lvl3ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        selectedLevel = 3;
        FilmLevel.setText("Level : " + selectedLevel);
        playbtnFILM.setEnabled(true);
    }                                         

    private void film_lvl4ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        selectedLevel = 4;
        FilmLevel.setText("Level : " + selectedLevel);
        playbtnFILM.setEnabled(true);
    }                                         

    private void film_lvl5ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        selectedLevel = 5;
        FilmLevel.setText("Level : " + selectedLevel);
        playbtnFILM.setEnabled(true);
    }                                         

    private void film_lvl6ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        selectedLevel = 6;
        FilmLevel.setText("Level : " + selectedLevel);
        playbtnFILM.setEnabled(true);
    }                                         

    private void film_lvl7ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        selectedLevel = 7;
        FilmLevel.setText("Level : " + selectedLevel);
        playbtnFILM.setEnabled(true);
    }                                         

    private void film_lvl8ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        selectedLevel = 8;
        FilmLevel.setText("Level : " + selectedLevel);
        playbtnFILM.setEnabled(true);
    }                                         

    private void film_lvl9ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        selectedLevel = 9;
        FilmLevel.setText("Level : " + selectedLevel);
        playbtnFILM.setEnabled(true);
    }                                         

    private void film_lvl10ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 10;
        FilmLevel.setText("Level : " + selectedLevel);
        playbtnFILM.setEnabled(true);
    }                                          

    private void playbtnFILMActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        try {getTebakan(); } catch (IOException e) {} 
        time = 0;
        startTime = true;
        timeLabel.setText("Sisa Waktu : " + time);
        bufferObject = tebakan.toCharArray();
        gameObejct = new String[bufferObject.length];
        tambahSkor = maxSkor / bufferObject.length;
        guessAnswer = new ArrayList<>();
        
        for(int i = 0; i < gameObejct.length; i++) {
            String a = "" + bufferObject[i];
            gameObejct[i] = a.toUpperCase();
        }
        
        for(int i = 0; i < gameObejct.length; i++) {
            if(!gameObejct[i].equals(" ")) {
                guessAnswer.add("_");
                amountOFCorrectInput++;
            } else {
                guessAnswer.add(" ");
            }
        }
        
        TebakanField.setText(printList(guessAnswer));
        scoreField.setText("Score : 0");
        chanceField.setText("Kesempatan : " + kesempatan);
        levelField.setText("Level : " + selectedLevel);
        clueArea.setText("Clue : " + clue);
        sisaLabel.setText("Sisa : " + amountOFCorrectInput);
        enterbtnGameBegin.setEnabled(true);
        
        
        bodyPanel.removeAll();
        bodyPanel.repaint();
        bodyPanel.revalidate();
        
        bodyPanel.add(readyPanel);
        bodyPanel.repaint();
        bodyPanel.revalidate();
        
        
        Thread startGame  = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 3;
                try {
                   
                    while (i > 0) {
                        runDown.setText(""+i);
                        Thread.sleep(1000);
                        i--;                    
                    }
                    bodyPanel.removeAll();
                    bodyPanel.repaint();
                    bodyPanel.revalidate();

                    timerStart();
                    bodyPanel.add(gameBeginPanel);
                    bodyPanel.repaint();
                    bodyPanel.revalidate();
                                  
                } catch (InterruptedException e) {}
            }
        });
        
        startGame.start();
    }                                           

    //BENDA
    private void benda_lvl1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 1;
        bendaLevel.setText("Level : " + selectedLevel);
        playbtnBENDA.setEnabled(true);
    }                                          

    private void benda_lvl2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 2;
        bendaLevel.setText("Level : " + selectedLevel);
        playbtnBENDA.setEnabled(true);
    }                                          

    private void benda_lvl3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 3;
        bendaLevel.setText("Level : " + selectedLevel);
        playbtnBENDA.setEnabled(true);
    }                                          

    private void benda_lvl4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 4;
        bendaLevel.setText("Level : " + selectedLevel);
        playbtnBENDA.setEnabled(true);
    }                                          

    private void benda_lvl5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 5;
        bendaLevel.setText("Level : " + selectedLevel);
        playbtnBENDA.setEnabled(true);
    }                                          

    private void benda_lvl6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 6;
        bendaLevel.setText("Level : " + selectedLevel);
        playbtnBENDA.setEnabled(true);
    }                                          

    private void benda_lvl7ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 7;
        bendaLevel.setText("Level : " + selectedLevel);
        playbtnBENDA.setEnabled(true);
    }                                          

    private void benda_lvl8ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 8;
        bendaLevel.setText("Level : " + selectedLevel);
        playbtnBENDA.setEnabled(true);
    }                                          

    private void benda_lvl9ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 9;
        bendaLevel.setText("Level : " + selectedLevel);
        playbtnBENDA.setEnabled(true);
    }                                          

    private void benda_lvl10ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        selectedLevel = 10;
        bendaLevel.setText("Level : " + selectedLevel);
        playbtnBENDA.setEnabled(true);
    }                                           

    private void playbtnBENDAActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        bodyPanel.removeAll();
        bodyPanel.repaint();
        bodyPanel.revalidate();
        
        bodyPanel.add(comingSoonPanel);
        bodyPanel.repaint();
        bodyPanel.revalidate();
        
    }                                            

    //AKTOR
    private void aktor_lvl1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 1;
        aktorLevel.setText("Level : " + selectedLevel);
        playbtnAKTOR.setEnabled(true);
    }                                          

    private void aktor_lvl2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 2;
        aktorLevel.setText("Level : " + selectedLevel);
        playbtnAKTOR.setEnabled(true);
    }                                          

    private void aktor_lvl3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 3;
        aktorLevel.setText("Level : " + selectedLevel);
        playbtnAKTOR.setEnabled(true);
    }                                          

    private void aktor_lvl4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 4;
        aktorLevel.setText("Level : " + selectedLevel);
        playbtnAKTOR.setEnabled(true);
    }                                          

    private void aktor_lvl5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 5;
        aktorLevel.setText("Level : " + selectedLevel);
        playbtnAKTOR.setEnabled(true);
    }                                          

    private void aktor_lvl6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 6;
        aktorLevel.setText("Level : " + selectedLevel);
        playbtnAKTOR.setEnabled(true);
    }                                          

    private void aktor_lvl7ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 7;
        aktorLevel.setText("Level : " + selectedLevel);
        playbtnAKTOR.setEnabled(true);
    }                                          

    private void aktor_lvl8ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 8;
        aktorLevel.setText("Level : " + selectedLevel);
        playbtnAKTOR.setEnabled(true);
    }                                          

    private void aktor_lvl9ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        selectedLevel = 9;
        aktorLevel.setText("Level : " + selectedLevel);
        playbtnAKTOR.setEnabled(true);
    }                                          

    private void aktor_lvl10ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        selectedLevel = 10;
        aktorLevel.setText("Level : " + selectedLevel);
        playbtnAKTOR.setEnabled(true);
    }                                           

    private void playbtnAKTORActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        bodyPanel.removeAll();
        bodyPanel.repaint();
        bodyPanel.revalidate();
        
        bodyPanel.add(comingSoonPanel);
        bodyPanel.repaint();
        bodyPanel.revalidate();
    }                                            
 
    /* Game Begin */
    private void enterbtnGameBeginActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        cekInputan();
        TebakanField.setText(printList(guessAnswer));
        inputField.setText("");
        chanceField.setText("Kesempatan : " + kesempatan);
        scoreField.setText("Score : " + skorSementara);
        sisaLabel.setText("Sisa : " + amountOFCorrectInput);
        getHangman(kesempatan);
        if(kesempatan == 0 || amountOFCorrectInput == 0) {
            if(kesempatan == 0) {
                startTime = false;
                enterbtnGameBegin.setEnabled(false);                
                timeLabel.setText("Anda Gagal !!!");
                reStartBtn.setEnabled(true);
                nextLevel.setEnabled(false);
            } else {
                if(kesempatan == 6) {
                    skorSementara = 500;
                    scoreField.setText("Score : " + skorSementara);
                }
                try { setSavedata(); } catch (IOException e) {}
                startTime = false;
                enterbtnGameBegin.setEnabled(false);               
                timeLabel.setText("Selamat Anda Berhasil !!!");
                if(selectedLevel != 10) {
                    nextLevel.setEnabled(true);
                } else {
                    nextLevel.setEnabled(false);
                }
                reStartBtn.setEnabled(true);
            }
            
        }
    }                                                 

    private void homebtnGameBeginActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        startTime = false;
        time = 0;
        kesempatan = 6;
        getHangman(kesempatan);
        skorSementara = 0;
        inputField.setText("");
        amountOFCorrectInput = 0;
        
        playbtnBENDA.setEnabled(false);
        playbtnAKTOR.setEnabled(false);
        playbtnSEJARAH.setEnabled(false);
        playbtnFILM.setEnabled(false);
        sejarahlvl.setText("Level : ");
        FilmLevel.setText("Level : ");
        bendaLevel.setText("Level : ");
        aktorLevel.setText("Level : ");
        
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(homepanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        bodyPanel.removeAll();
        bodyPanel.repaint();
        bodyPanel.revalidate();
        
        bodyPanel.add(homeScreen);
        bodyPanel.repaint();
        bodyPanel.revalidate();  
        cekLevel();
    }                                                

    private void nextLevelActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        nextLevel.setEnabled(false);
        reStartBtn.setEnabled(false);
        amountOFCorrectInput = 0;
        inputField.setText("");
        selectedLevel++;
        skorSementara = 0;
        kesempatan = 6;
        getHangman(kesempatan);
        cekLevel();
        try {
            getTebakan();
        } catch (IOException e) {}      
        time = 0;
        startTime = true;
        timeLabel.setText("Sisa Waktu : " + time);
        bufferObject = tebakan.toCharArray();
        gameObejct = new String[bufferObject.length];
        tambahSkor = maxSkor / bufferObject.length;
        guessAnswer = new ArrayList<>();
        
        for(int i = 0; i < gameObejct.length; i++) {
            String a = "" + bufferObject[i];
            gameObejct[i] = a.toUpperCase();
        }
        
        for(int i = 0; i < gameObejct.length; i++) {
            if(!gameObejct[i].equals(" ")) {
                guessAnswer.add("_");
                amountOFCorrectInput++;
            } else {
                guessAnswer.add(" ");
            }
        }
        
        TebakanField.setText(printList(guessAnswer));
        scoreField.setText("Score : 0");
        chanceField.setText("Kesempatan : " + kesempatan);
        levelField.setText("Level : " + selectedLevel);
        clueArea.setText("Clue : " + clue);
        sisaLabel.setText("Sisa : " + amountOFCorrectInput);
        enterbtnGameBegin.setEnabled(true);
        
        
        bodyPanel.removeAll();
        bodyPanel.repaint();
        bodyPanel.revalidate();
        
        bodyPanel.add(readyPanel);
        bodyPanel.repaint();
        bodyPanel.revalidate();
        
        
        Thread startGame  = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 3;
                try {
                   
                    while (i > 0) {
                        runDown.setText(""+i);
                        Thread.sleep(1000);
                        i--;                    
                    }
                    bodyPanel.removeAll();
                    bodyPanel.repaint();
                    bodyPanel.revalidate();

                    timerStart();
                    bodyPanel.add(gameBeginPanel);
                    bodyPanel.repaint();
                    bodyPanel.revalidate();
                                  
                } catch (InterruptedException e) {}
            }
        });
        
        startGame.start();
           
    }                                         

    private void reStartBtnActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        nextLevel.setEnabled(false);
        reStartBtn.setEnabled(false);
        amountOFCorrectInput = 0;
        skorSementara = 0;
        kesempatan = 6;
        inputField.setText("");
        getHangman(kesempatan);
        cekLevel();
        try {
            getTebakan();
        } catch (IOException e) {}      
        time = 0;
        startTime = true;
        timeLabel.setText("Sisa Waktu : " + time);
        bufferObject = tebakan.toCharArray();
        gameObejct = new String[bufferObject.length];
        tambahSkor = maxSkor / bufferObject.length;
        guessAnswer = new ArrayList<>();
        
        for(int i = 0; i < gameObejct.length; i++) {
            String a = "" + bufferObject[i];
            gameObejct[i] = a.toUpperCase();
        }
        
        for(int i = 0; i < gameObejct.length; i++) {
            if(!gameObejct[i].equals(" ")) {
                guessAnswer.add("_");
                amountOFCorrectInput++;
            } else {
                guessAnswer.add(" ");
            }
        }
        
        TebakanField.setText(printList(guessAnswer));
        scoreField.setText("Score : 0");
        chanceField.setText("Kesempatan : " + kesempatan);
        levelField.setText("Level : " + selectedLevel);
        clueArea.setText("Clue : " + clue);
        sisaLabel.setText("Sisa : " + amountOFCorrectInput);
        enterbtnGameBegin.setEnabled(true);
        
        
        bodyPanel.removeAll();
        bodyPanel.repaint();
        bodyPanel.revalidate();
        
        bodyPanel.add(readyPanel);
        bodyPanel.repaint();
        bodyPanel.revalidate();
        
        
        Thread startGame  = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 3;
                try {
                   
                    while (i > 0) {
                        runDown.setText(""+i);
                        Thread.sleep(1000);
                        i--;                    
                    }
                    bodyPanel.removeAll();
                    bodyPanel.repaint();
                    bodyPanel.revalidate();

                    timerStart();
                    bodyPanel.add(gameBeginPanel);
                    bodyPanel.repaint();
                    bodyPanel.revalidate();
                                  
                } catch (InterruptedException e) {}
            }
        });
        
        startGame.start();
    }                                          

    private void kembalibtnComingSoonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
        
        selectedKategori = 0;
        selectedLevel = 0;
        
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(categoryPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
               
        bodyPanel.removeAll();
        bodyPanel.repaint();
        bodyPanel.revalidate();
        
        bodyPanel.add(homeScreen);
        bodyPanel.repaint();
        bodyPanel.revalidate();
    }                                                    


    
    /* Main Function */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hangman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel FilmLevel;
    private javax.swing.JPanel SejarahPanel;
    private javax.swing.JTextField TebakanField;
    private javax.swing.JPanel aboutPanel;
    private javax.swing.JButton aboutbtn;
    private javax.swing.JLabel aktorLevel;
    private javax.swing.JPanel aktorPanel;
    private javax.swing.JButton aktor_lvl1;
    private javax.swing.JButton aktor_lvl10;
    private javax.swing.JButton aktor_lvl2;
    private javax.swing.JButton aktor_lvl3;
    private javax.swing.JButton aktor_lvl4;
    private javax.swing.JButton aktor_lvl5;
    private javax.swing.JButton aktor_lvl6;
    private javax.swing.JButton aktor_lvl7;
    private javax.swing.JButton aktor_lvl8;
    private javax.swing.JButton aktor_lvl9;
    private javax.swing.JButton aktorbtn;
    private javax.swing.JLabel bendaLevel;
    private javax.swing.JPanel bendaPanel;
    private javax.swing.JButton benda_lvl1;
    private javax.swing.JButton benda_lvl10;
    private javax.swing.JButton benda_lvl2;
    private javax.swing.JButton benda_lvl3;
    private javax.swing.JButton benda_lvl4;
    private javax.swing.JButton benda_lvl5;
    private javax.swing.JButton benda_lvl6;
    private javax.swing.JButton benda_lvl7;
    private javax.swing.JButton benda_lvl8;
    private javax.swing.JButton benda_lvl9;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JPanel categoryPanel;
    private javax.swing.JTextField chanceField;
    private javax.swing.JTextArea clueArea;
    private javax.swing.JPanel comingSoonPanel;
    private javax.swing.JButton enterbtnGameBegin;
    private javax.swing.JPanel filmPanel;
    private javax.swing.JButton film_lvl1;
    private javax.swing.JButton film_lvl10;
    private javax.swing.JButton film_lvl2;
    private javax.swing.JButton film_lvl3;
    private javax.swing.JButton film_lvl4;
    private javax.swing.JButton film_lvl5;
    private javax.swing.JButton film_lvl6;
    private javax.swing.JButton film_lvl7;
    private javax.swing.JButton film_lvl8;
    private javax.swing.JButton film_lvl9;
    private javax.swing.JButton filmbtn;
    private javax.swing.JPanel gameBeginPanel;
    private javax.swing.JPanel homeScreen;
    private javax.swing.JButton homebtn;
    private javax.swing.JButton homebtnGameBegin;
    private javax.swing.JPanel homepanel;
    private javax.swing.JTextField inputField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kategoriField;
    private javax.swing.JButton kembalibtnComingSoon;
    private javax.swing.JTextField levelField;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton namaBendabtn;
    private javax.swing.JButton nextLevel;
    private javax.swing.JButton playbtn;
    private javax.swing.JButton playbtnAKTOR;
    private javax.swing.JButton playbtnBENDA;
    private javax.swing.JButton playbtnFILM;
    private javax.swing.JButton playbtnSEJARAH;
    private javax.swing.JButton reStartBtn;
    private javax.swing.JPanel readyPanel;
    private javax.swing.JLabel runDown;
    private javax.swing.JTextField scoreField;
    private javax.swing.JButton sejarah_lvl1;
    private javax.swing.JButton sejarah_lvl10;
    private javax.swing.JButton sejarah_lvl2;
    private javax.swing.JButton sejarah_lvl3;
    private javax.swing.JButton sejarah_lvl4;
    private javax.swing.JButton sejarah_lvl5;
    private javax.swing.JButton sejarah_lvl6;
    private javax.swing.JButton sejarah_lvl7;
    private javax.swing.JButton sejarah_lvl8;
    private javax.swing.JButton sejarah_lvl9;
    private javax.swing.JButton sejarahbtn;
    private javax.swing.JLabel sejarahlvl;
    private javax.swing.JLabel showHangman;
    private javax.swing.JLabel sisaLabel;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration                   
}
