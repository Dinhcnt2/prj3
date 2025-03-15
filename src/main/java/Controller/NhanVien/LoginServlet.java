package Controller.NhanVien;

import DAO.CuaHangDAO;
import Model.NhanVien;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String email = request.getParameter("email");
        String soDienThoai = request.getParameter("soDienThoai");

        // Kết nối đến database

        CuaHangDAO dao = new CuaHangDAO();

        // Kiểm tra đăng nhập
        NhanVien nhanVien = dao.dangNhap(email, soDienThoai);

        if (nhanVien != null) {
            // Lưu thông tin nhân viên vào session
            HttpSession session = request.getSession();
            session.setAttribute("nhanVien", nhanVien);

            // Chuyển hướng đến trang quản lý nhân viên
            response.sendRedirect("Backend/Home.jsp");
        } else {
            // Đăng nhập thất bại, chuyển hướng về trang đăng nhập
            request.setAttribute("errorMessage", "Sai email hoặc số điện thoại!");
            request.getRequestDispatcher("Backend/NhanVien/login.jsp").forward(request, response);
        }
    }
}
