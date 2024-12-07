/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package qlsv.mvquanlysinhvien;

/**
 *
 * @author VUDUYKHUONG
 */
public class MvQuanlySinhVien {

    public static void main(String[] args) {
        StudentDAO stdDAO = new StudentDAO();
        
        // Tao 1 sinh vien moi
        stdDAO.createStudent("Ngô Tất Tố", 99);
        
        // close ket noi
        stdDAO.close();
        System.out.println("Sinh Vien duoc thuc hien thanh cong");
    }
}
