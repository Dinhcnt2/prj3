package Controller.KhachHang;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.CuaHangDAO;
import Model.KhachHang;
@WebServlet("/Backend/KhachHang/deleteKhachHang")
public class deleteKhachHang extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CuaHangDAO cuaHangDAO;

    public void init() {
    	cuaHangDAO = new CuaHangDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
            cuaHangDAO.deleteKhachHang(maKhachHang);
            response.sendRedirect("listKhachHang.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Lỗi: " + e.getMessage());
        }
    }
}