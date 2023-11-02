/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author kimdo
 */
public class Bin {
    int ID,ID_TAIKHOAN,BLOCK,BLOCKTAODE,BLOCKTHI,ID_CHUDE,SOCAUHOI,THOIGIAN;

    public Bin(int ID, int ID_TAIKHOAN, int BLOCK, int BLOCKTAODE, int BLOCKTHI, int ID_CHUDE, int SOCAUHOI, int THOIGIAN) {
        this.ID = ID;
        this.ID_TAIKHOAN = ID_TAIKHOAN;
        this.BLOCK = BLOCK;
        this.BLOCKTAODE = BLOCKTAODE;
        this.BLOCKTHI = BLOCKTHI;
        this.ID_CHUDE = ID_CHUDE;
        this.SOCAUHOI = SOCAUHOI;
        this.THOIGIAN = THOIGIAN;
    }

    public int getBLOCK() {
        return BLOCK;
    }

    public void setBLOCK(int BLOCK) {
        this.BLOCK = BLOCK;
    }

    public int getBLOCKTAODE() {
        return BLOCKTAODE;
    }

    public void setBLOCKTAODE(int BLOCKTAODE) {
        this.BLOCKTAODE = BLOCKTAODE;
    }

    public int getBLOCKTHI() {
        return BLOCKTHI;
    }

    public void setBLOCKTHI(int BLOCKTHI) {
        this.BLOCKTHI = BLOCKTHI;
    }

    public int getID_CHUDE() {
        return ID_CHUDE;
    }

    public void setID_CHUDE(int ID_CHUDE) {
        this.ID_CHUDE = ID_CHUDE;
    }

    public int getSOCAUHOI() {
        return SOCAUHOI;
    }

    public void setSOCAUHOI(int SOCAUHOI) {
        this.SOCAUHOI = SOCAUHOI;
    }

    public int getTHOIGIAN() {
        return THOIGIAN;
    }

    public void setTHOIGIAN(int THOIGIAN) {
        this.THOIGIAN = THOIGIAN;
    }

    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_TAIKHOAN() {
        return ID_TAIKHOAN;
    }

    public void setID_TAIKHOAN(int ID_TAIKHOAN) {
        this.ID_TAIKHOAN = ID_TAIKHOAN;
    }
    
    
}
