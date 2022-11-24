/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author buiti
 */
public class LoginViewModel {
    private String ma;
    private String matKhau;
    private String tenCV;

    public LoginViewModel(String ma, String matKhau, String tenCV) {
        this.ma = ma;
        this.matKhau = matKhau;
        this.tenCV = tenCV;
    }

    public LoginViewModel() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    @Override
    public String toString() {
        return "LoginViewModel{" + "ma=" + ma + ", matKhau=" + matKhau + ", tenCV=" + tenCV + '}';
    }

    
    
}
