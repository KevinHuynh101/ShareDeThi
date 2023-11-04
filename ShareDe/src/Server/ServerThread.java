package Server;

import Client.formThongKe;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author kimdo
 */
public class ServerThread implements Runnable {

    private Socket socket;
    private String name;

    public ServerThread(Socket socket, String name) throws IOException {
        this.socket = socket;
        this.name = name;

        new Thread(this).start();
    }

    public static final int loginServer = 1;
    public static final int block = 2;
    public static final int blockAddDe = 3;
    public static final int blockThi = 4;
    public static final int CountDeThi = 5;
    public static final int CountCauHoi = 6;
    public static final int AvgScore = 7;
    public static final int MaxScore = 8;
    public static final int SonguoiLamDe = 9;
    public static final int SoLanDeDcLam = 10;
    public static final int thiTracNghiem = 11;
    public int flag(String str) {
        if (str.equals("1")) {
            return loginServer;
        } else if (str.equals("2")) {
            return block;
        } else if (str.equals("3")) {
            return blockAddDe;
        } else if (str.equals("4")) {
            return blockThi;  
        } else if (str.equals("5")) {
            return CountDeThi;     
        } else if (str.equals("6")) {
            return CountCauHoi;      
        } else if (str.equals("7")) {
            return AvgScore; 
        } else if (str.equals("8")) {
            return MaxScore; 
        } else if (str.equals("9")) {
            return SonguoiLamDe; 
        } else if (str.equals("10")) {
            return SoLanDeDcLam; 
         } else if (str.equals("11")) {
            return thiTracNghiem;     
        } else {
            return -1;
        }
    }
    
    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String receive = dis.readUTF();
            String receiveArray[] = receive.split("///");
            int flag = flag(receiveArray[0]);
//            int i=0;
            switch (flag) {
                case loginServer:
                    if (receiveArray[1].equals("localhost") && receiveArray[2].equals("1433")) {
                        System.out.println("Arrdress: " + receiveArray[1] + "\nPort: " + receiveArray[2]);
                        dos.writeUTF("Connected");
                        String CountTaiKhoan = DbAccess.CountTaiKhoan();
//                        i++;
//                        System.out.println("Số người dùng đang online :" +i+ "/"+CountTaiKhoan);
                        
                    } else {
                        dos.writeUTF("Connected fail");
                    }
                    break;
                case block:
//                    System.out.print(receive);
                    if (DbAccess.DangNhap(receive) == true) {
                        dos.writeUTF("1");
                    } else {
                        dos.writeUTF("0");
                    }
                    break;
                case blockAddDe:
                    if (DbAccess.CheckBlockAdd(receive) == true) {
                        dos.writeUTF("1");
                    } else {
                        dos.writeUTF("0");
                    }
                    break;
                case blockThi:
                    if (DbAccess.CheckBlockThi(receive) == true) {
                        dos.writeUTF("1");
                    } else {
                        dos.writeUTF("0");
                    }
                    break;
                case CountDeThi:
                    String count = DbAccess.CountChuDe();
                    dos.writeUTF(count);
                    break;
                case CountCauHoi:
                    String countCauHoi = DbAccess.CountCauHoi();
                    dos.writeUTF(countCauHoi);
                    break;
                case AvgScore:
                    String AvgScore = DbAccess.AvgScore(receiveArray[1]);
                    dos.writeUTF(AvgScore);
                    break;
                case MaxScore:
                    String TaikhoanMax = DbAccess.TaiKhoanMax(receiveArray[1]);
                    String MaxScore = DbAccess.MaxScore(receiveArray[1]);
                    dos.writeUTF(MaxScore);
                    break;
                case SonguoiLamDe:
                    String CountSoNguoiLamDe = DbAccess.CountSoNguoiLamDe(receiveArray[1]);
                    dos.writeUTF(CountSoNguoiLamDe);
                    break;
                case SoLanDeDcLam:
                    String CountDeDuocLam = DbAccess.CountDeDuocLam(receiveArray[1]);
                    dos.writeUTF(CountDeDuocLam);
                    break;
                case thiTracNghiem:
                    System.out.println("Có Client đang thi trắc nghiệm...");
                    String strCauHoi = DbAccess.getAllCauHoi(receiveArray[1],receiveArray[2]);
//                    System.out.println(strCauHoi);
                    String arrCauHoi[] = strCauHoi.split("///");
                    dos.writeUTF(strCauHoi);
                    //nhan cau tra loi lient
                    String receiveAnswer = dis.readUTF();
//                    System.out.println("Client đã trả lời: " + receiveAnswer);
                    String arrAnswer[] = receiveAnswer.split("///");
                    int cauDung = 0;
                    ArrayList<String> Answer = new ArrayList<>();
                    for (int i = 0; i < arrCauHoi.length; i+=7) {
                        Answer.add(arrCauHoi[7]);
                    }
                    //so sanh cau tra loi
                    for (int i = 0; i < arrAnswer.length; i++) {
                        if (Answer.get(i).equals(arrAnswer[i])) {
                            cauDung++;
                        }
                    }
                    System.out.println("Số câu đúng: " + cauDung);
                    dos.writeUTF(String.valueOf(cauDung));
                break;
                    
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

 
}
