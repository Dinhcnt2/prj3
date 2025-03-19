package Controller.NhanVien;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CuaHangDAO;
import Model.NhanVien;

@WebServlet("/Backend/NhanVien/addNhanVien")
public class VVDaddNhanVien extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CuaHangDAO cuaHangDAO;

    public void init() {
        cuaHangDAO = new CuaHangDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            // Lấy dữ liệu từ form
            String hoTen = request.getParameter("hoTen");
            String soDienThoai = request.getParameter("soDienThoai");
            String email = request.getParameter("email");
            String chucVu = request.getParameter("chucVu");
            double luong = Double.parseDouble(request.getParameter("luong"));
            String ngayVaoLam = request.getParameter("ngayVaoLam");

            // Tạo đối tượng nhân viên
            NhanVien nhanVien = new NhanVien(0, hoTen, soDienThoai, email, chucVu, luong, ngayVaoLam);

            // Thêm nhân viên vào DB
            cuaHangDAO.addNhanVien(nhanVien);

            // Chuyển hướng về danh sách nhân viên
            response.sendRedirect("VVDlistNhanVien.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Lỗi: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/NhanVien/VVDaddNhanVien.jsp");
        dispatcher.forward(request, response);
    }
}
