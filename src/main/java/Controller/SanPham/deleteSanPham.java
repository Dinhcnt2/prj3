package Controller.SanPham;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CuaHangDAO;

@WebServlet("/Backend/NhanVien/deleteSanPham")
public class deleteSanPham extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CuaHangDAO cuaHangDAO;

    public void init() {
        cuaHangDAO = new CuaHangDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
            cuaHangDAO.deleteSanPham(maSanPham);
            response.sendRedirect("VVDlistSanPham.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Lỗi: " + e.getMessage());
        }
    }
}