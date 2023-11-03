/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author kimdo
 */
public class CauHoi {
    private int BODE_ID,CHUDE_ID;
    private String NOIDUNG, A, B, C, D, DAP_AN;

    public int getBODE_ID() {
        return BODE_ID;
    }

    public void setBODE_ID(int BODE_ID) {
        this.BODE_ID = BODE_ID;
    }

    public int getCHUDE_ID() {
        return CHUDE_ID;
    }

    public void setCHUDE_ID(int CHUDE_ID) {
        this.CHUDE_ID = CHUDE_ID;
    }

    public String getNOIDUNG() {
        return NOIDUNG;
    }

    public void setNOIDUNG(String NOIDUNG) {
        this.NOIDUNG = NOIDUNG;
    }

    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }

    public String getDAP_AN() {
        return DAP_AN;
    }

    public void setDAP_AN(String DAP_AN) {
        this.DAP_AN = DAP_AN;
    }

    public CauHoi(int BODE_ID, int CHUDE_ID, String NOIDUNG, String A, String B, String C, String D, String DAP_AN) {
        this.BODE_ID = BODE_ID;
        this.CHUDE_ID = CHUDE_ID;
        this.NOIDUNG = NOIDUNG;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.DAP_AN = DAP_AN;
    }
    public CauHoi (){
        
    }
}
