package Controller.KhachHang;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.CuaHangDAO;
import Model.KhachHang;

@WebServlet("/Backend/KhachHang/updateKhachHang")
public class updateKhachHang extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CuaHangDAO cuaHangDAO;

    public void init() {
        cuaHangDAO = new CuaHangDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maKhachHangStr = request.getParameter("maKhachHang");
        if (maKhachHangStr == null || maKhachHangStr.isEmpty()) {
            response.sendRedirect("listKhachHang.jsp");
            return;
        }
        try {
            int maKhachHang = Integer.parseInt(maKhachHangStr);
            KhachHang khachHang = cuaHangDAO.getKhachHangById(maKhachHang);
            if (khachHang == null) {
                response.sendRedirect("listKhachHang.jsp");
                return;
            }
            request.setAttribute("khachHang", khachHang);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/KhachHang/updateKhachHang.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("listKhachHang.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
            String hoTen = request.getParameter("hoTen");
            String soDienThoai = request.getParameter("soDienThoai");
            String email = request.getParameter("email");
            String diaChi = request.getParameter("diaChi");
            
            String ngayThamGiaStr = request.getParameter("ngayThamGia");
            LocalDate ngayThamGia = null;
            if (ngayThamGiaStr != null && !ngayThamGiaStr.isEmpty()) {
                try {
                    ngayThamGia = LocalDate.parse(ngayThamGiaStr);
                } catch (DateTimeParseException e) {
                    request.setAttribute("error", "Ngày tham gia không hợp lệ!");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/KhachHang/updateKhachHang.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            }

            KhachHang khachHang = new KhachHang(maKhachHang, hoTen, soDienThoai, email, diaChi, ngayThamGia);
            cuaHangDAO.updateKhachHang(khachHang);
            response.sendRedirect("listKhachHang.jsp");
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Dữ liệu nhập vào không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/KhachHang/updateKhachHang.jsp");
            dispatcher.forward(request, response);
        }
    }
}