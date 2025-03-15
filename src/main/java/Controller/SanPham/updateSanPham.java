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

@WebServlet("/Backend/SanPham/updateSanPham")
public class updateSanPham extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CuaHangDAO cuaHangDAO;

    public void init() {
        cuaHangDAO = new CuaHangDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSanPhamStr = request.getParameter("maSanPham");
        if (maSanPhamStr == null || maSanPhamStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Thiếu mã sản phẩm.");
            return;
        }
        
        try {
            int maSanPham = Integer.parseInt(maSanPhamStr);
            SanPham sanPham = cuaHangDAO.getSanPhamById(maSanPham);
            if (sanPham == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy sản phẩm.");
                return;
            }
            request.setAttribute("sanPham", sanPham);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/SanPham/updateSanPham.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Mã sản phẩm không hợp lệ.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            int maSP = Integer.parseInt(request.getParameter("maSanPham"));
            String tenSP = request.getParameter("tenSanPham");
            String loaiSP = request.getParameter("loaiSanPham");
            String kichCo = request.getParameter("kichCo");
            String mauSac = request.getParameter("mauSac");
            String chatLieu = request.getParameter("chatLieu");
            String hinhAnh = request.getParameter("hinhAnh");
            float gia = Float.parseFloat(request.getParameter("gia"));
            int soLuongTonKho = Integer.parseInt(request.getParameter("soLuongTonKho"));
            int maNhaCungCap = Integer.parseInt(request.getParameter("maNhaCungCap"));

            SanPham sanPham = new SanPham(maSP, tenSP, loaiSP, kichCo, mauSac, chatLieu, hinhAnh, gia, soLuongTonKho, maNhaCungCap);
            cuaHangDAO.updateSanPham(sanPham);
            response.sendRedirect("listSanPham.jsp");
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Dữ liệu nhập vào không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/SanPham/updateSanPham.jsp");
            dispatcher.forward(request, response);
        }
    }
}