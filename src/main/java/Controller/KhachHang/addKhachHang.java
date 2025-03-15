package Controller.KhachHang;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.CuaHangDAO;
import Model.KhachHang;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@WebServlet("/Backend/KhachHang/addKhachHang")
public class addKhachHang extends HttpServlet {
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
            String hoTen = request.getParameter("hoTen");
            String soDienThoai = request.getParameter("soDienThoai");
            String email = request.getParameter("email");
            String diaChi = request.getParameter("diaChi");

            // Chuyển đổi chuỗi thành LocalDate
            LocalDate ngayThamGia = null;
            String ngayThamGiaStr = request.getParameter("ngayThamGia");
            if (ngayThamGiaStr != null && !ngayThamGiaStr.isEmpty()) {
                try {
                    ngayThamGia = LocalDate.parse(ngayThamGiaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                } catch (DateTimeParseException e) {
                    e.printStackTrace();
                    response.getWriter().println("Lỗi định dạng ngày: " + ngayThamGiaStr);
                    return;
                }
            }

            KhachHang khachHang = new KhachHang(0, hoTen, soDienThoai, email, diaChi, ngayThamGia);
            cuaHangDAO.addKhachHang(khachHang);

            response.sendRedirect("listKhachHang.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Lỗi: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/KhachHang/addKhachHang.jsp");
        dispatcher.forward(request, response);
    }
}
