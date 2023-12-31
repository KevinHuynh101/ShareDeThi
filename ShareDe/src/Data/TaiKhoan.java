/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.util.Date;

/**
 *
 * @author kimdo
 */
public class TaiKhoan {
    int TAIKHOAN_ID,BLOCK,BLOCKTAODE,BLOCKTHI;
    String EMAIL,TEN,OTP,MATKHAU;
    boolean GIOITINH,PHANQUYEN;
    Date NGAYSINH,NGAYXACNHAN;

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

    public TaiKhoan(int TAIKHOAN_ID, int BLOCK, int BLOCKTAODE, int BLOCKTHI, String EMAIL, String TEN, String OTP, String MATKHAU, boolean GIOITINH, boolean PHANQUYEN, Date NGAYSINH, Date NGAYXACNHAN) {
        this.TAIKHOAN_ID = TAIKHOAN_ID;
        this.BLOCK = BLOCK;
        this.BLOCKTAODE = BLOCKTAODE;
        this.BLOCKTHI = BLOCKTHI;
        this.EMAIL = EMAIL;
        this.TEN = TEN;
        this.OTP = OTP;
        this.MATKHAU = MATKHAU;
        this.GIOITINH = GIOITINH;
        this.PHANQUYEN = PHANQUYEN;
        this.NGAYSINH = NGAYSINH;
        this.NGAYXACNHAN = NGAYXACNHAN;
    }

    public int getTAIKHOAN_ID() {
        return TAIKHOAN_ID;
    }

    public void setTAIKHOAN_ID(int TAIKHOAN_ID) {
        this.TAIKHOAN_ID = TAIKHOAN_ID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public boolean isGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(boolean GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public boolean isPHANQUYEN() {
        return PHANQUYEN;
    }

    public void setPHANQUYEN(boolean PHANQUYEN) {
        this.PHANQUYEN = PHANQUYEN;
    }

    public Date getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(Date NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    
    

    public Date getNGAYXACNHAN() {
        return NGAYXACNHAN;
    }

    public void setNGAYXACNHAN(Date NGAYXACNHAN) {
        this.NGAYXACNHAN = NGAYXACNHAN;
    }

   public TaiKhoan (){
       
   }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }
   
    
}
