/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author kimdo
 */
public class ChuDe {
    int CHUDE_ID,SOCAUHOI,TIME,TAIKHOAN_ID;
    String TENCHUDE,LOP_ID;
    public ChuDe(){
        
    }

    public ChuDe(int CHUDE_ID, int SOCAUHOI, int TIME, int TAIKHOAN_ID, String TENCHUDE, String LOP_ID) {
        this.CHUDE_ID = CHUDE_ID;
        this.SOCAUHOI = SOCAUHOI;
        this.TIME = TIME;
        this.TAIKHOAN_ID = TAIKHOAN_ID;
        this.TENCHUDE = TENCHUDE;
        this.LOP_ID = LOP_ID;
    }

    public int getCHUDE_ID() {
        return CHUDE_ID;
    }

    public void setCHUDE_ID(int CHUDE_ID) {
        this.CHUDE_ID = CHUDE_ID;
    }

    public int getSOCAUHOI() {
        return SOCAUHOI;
    }

    public void setSOCAUHOI(int SOCAUHOI) {
        this.SOCAUHOI = SOCAUHOI;
    }

    public int getTIME() {
        return TIME;
    }

    public void setTIME(int TIME) {
        this.TIME = TIME;
    }

    public int getTAIKHOAN_ID() {
        return TAIKHOAN_ID;
    }

    public void setTAIKHOAN_ID(int TAIKHOAN_ID) {
        this.TAIKHOAN_ID = TAIKHOAN_ID;
    }

    public String getTENCHUDE() {
        return TENCHUDE;
    }

    public void setTENCHUDE(String TENCHUDE) {
        this.TENCHUDE = TENCHUDE;
    }

    public String getLOP_ID() {
        return LOP_ID;
    }

    public void setLOP_ID(String LOP_ID) {
        this.LOP_ID = LOP_ID;
    }
    
    
}
