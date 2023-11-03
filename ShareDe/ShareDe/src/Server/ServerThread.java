package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Pham Minh Hieu
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
    public static final int login = 2;
    public static final int thiTracNghiem = 3;


    public int flag(String str) {
        if (str.equals("1")) {
            return loginServer;
        } else if (str.equals("2")) {
            return login;
        } else if (str.equals("3")) {
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
            switch (flag) {
                case loginServer:
                    if (receiveArray[1].equals("localhost") && receiveArray[2].equals("1433")) {
                        System.out.println("Arrdress: " + receiveArray[1] + "\nPort: " + receiveArray[2]);
                        dos.writeUTF("Connected");
                    } else {
                        dos.writeUTF("Connected fail");
                    }
                    break;
                case login:
                    System.out.print(receive);
                    if (DbAccess.DangNhap(receive) == true) {
                        dos.writeUTF("1");
                    } else {
                        dos.writeUTF("0");
                    }
                    break;
                case thiTracNghiem:
//                    System.out.println("Có Client đang thi trắc nghiệm...");
//                    String strCauHoi = DbAccess.getAllCauHoi();
//                    System.out.println(strCauHoi);
//                    String arrCauHoi[] = strCauHoi.split("///");
//                    //dos.writeUTF(strCauHoi);
//                    //nhan cau tra loi lient
//                    String receiveAnswer = dis.readUTF();
//                    System.out.println("Client đã trả lời: " + receiveAnswer);
//                    String arrAnswer[] = receiveAnswer.split("///");
//                    int cauDung = 0;
//                    ArrayList<String> Answer = new ArrayList<>();
//                    for (int i = 0; i < arrCauHoi.length; i+=7) {
//                        Answer.add(arrCauHoi[7]);
//                    }
//                    //so sanh cau tra loi
//                    for (int i = 0; i < arrAnswer.length; i++) {
//                        if (Answer.get(i).equals(arrAnswer[i])) {
//                            cauDung++;
//                        }
//                    }
//                    System.out.println("Số câu đúng: " + cauDung);
//                    dos.writeUTF(String.valueOf(cauDung));
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
