package Controller.SanPham;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CuaHangDAO;
import Model.SanPham;

@WebServlet("/Backend/SanPham/addSanPham")
public class VVDaddSanPham extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CuaHangDAO CuaHangDAO;

    public void init() {
    	CuaHangDAO = new CuaHangDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            // Lấy dữ liệu từ form
            String tenSanPham = request.getParameter("tenSanPham");
            String loaiSanPham = request.getParameter("loaiSanPham");
            String kichCo = request.getParameter("kichCo");
            String mauSac = request.getParameter("mauSac");
            String chatLieu = request.getParameter("chatLieu");
            String hinhAnh = request.getParameter("hinhAnh");
            float gia = Float.parseFloat(request.getParameter("gia"));
            int soLuongTonKho = Integer.parseInt(request.getParameter("soLuongTonKho"));
            int maNhaCungCap = Integer.parseInt(request.getParameter("maNhaCungCap"));

            // Tạo đối tượng SanPham
            SanPham sanPham = new SanPham(0, tenSanPham, loaiSanPham, kichCo, mauSac, chatLieu, hinhAnh, gia, soLuongTonKho, maNhaCungCap);
            
            // Thêm vào DB
            CuaHangDAO.addSanPham(sanPham);

            // Chuyển hướng về danh sách sản phẩm
            response.sendRedirect("VVDlistSanPham.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Lỗi: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/SanPham/VVDaddSanPham.jsp");
        dispatcher.forward(request, response);
    }
}
