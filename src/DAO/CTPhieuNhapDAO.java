package DAO;

import DTO.CTPhieuNhap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CTPhieuNhapDAO {

    private static CTPhieuNhapDAO instance;

    public static CTPhieuNhapDAO getInstance() {
        if (instance == null) {
            instance = new CTPhieuNhapDAO();
        }
        return instance;
    }

    private CTPhieuNhapDAO() {
    }

    public ArrayList<CTPhieuNhap> getListCTPhieuNhap() {
        ArrayList<CTPhieuNhap> dsctpn = new ArrayList<>();
        try {
            String sql = "SELECT * FROM chitietphieunhap";
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CTPhieuNhap ctpn = new CTPhieuNhap();
                ctpn.setSoLuong(rs.getInt(1));
                ctpn.setDonGia(rs.getInt(2));
                ctpn.setMaPN(rs.getInt(3));
                ctpn.setMaSP(rs.getInt(4));
                dsctpn.add(ctpn);
            }
        } catch (SQLException ex) {
            return null;
        }
        return dsctpn;
    }

    public ArrayList<CTPhieuNhap> getListCTPhieuNhapTheoMaPN(int maPN) {
        ArrayList<CTPhieuNhap> dsctpn = new ArrayList<>();
        try {
            String sql = "SELECT * FROM chitietphieunhap WHERE MaPN=" + maPN;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CTPhieuNhap ctpn = new CTPhieuNhap();
                ctpn.setSoLuong(rs.getInt(1));
                ctpn.setDonGia(rs.getInt(2));
                ctpn.setMaPN(rs.getInt(3));
                ctpn.setMaSP(rs.getInt(4));
                dsctpn.add(ctpn);
            }
        } catch (SQLException ex) {
            return null;
        }
        return dsctpn;
    }

    public ArrayList<CTPhieuNhap> getListCTPhieuNhapTheoMaSP(int maSP) {
        ArrayList<CTPhieuNhap> dsctpn = new ArrayList<>();
        try {
            String sql = "SELECT * FROM chitietphieunhap WHERE MaSP=" + maSP;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CTPhieuNhap ctpn = new CTPhieuNhap();
                ctpn.setSoLuong(rs.getInt(1));
                ctpn.setDonGia(rs.getInt(2));
                ctpn.setMaPN(rs.getInt(3));
                ctpn.setMaSP(rs.getInt(4));
                dsctpn.add(ctpn);
            }
        } catch (SQLException ex) {
            return null;
        }
        return dsctpn;
    }

    public boolean addCTPhieuNhap(CTPhieuNhap ctpn) {
        boolean result = false;
        try {
            // Phải Update số lượng SP trong kho
            String sqlUpdateSP = "UPDATE sanpham SET SoLuong = SoLuong + ? WHERE MaSP = ?";
            PreparedStatement pre = MyConnect.conn.prepareCall(sqlUpdateSP);
            pre.setInt(1, ctpn.getSoLuong());
            pre.setInt(2, ctpn.getMaSP());
            pre.executeUpdate();

            String sql = "INSERT INTO chitietphieunhap VALUES(?,?,?,?)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, ctpn.getSoLuong());
            prep.setInt(2, ctpn.getDonGia());
            prep.setInt(3, ctpn.getMaPN());
            prep.setInt(4, ctpn.getMaSP());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean deleteCTPhieuNhap(int maPN) {
        boolean result = false;
        try {
            String sql = "DELETE FROM chitietphieunhap WHERE MaPN=" + maPN;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean deleteCTPhieuNhap(int maPN, int maSP) {
        boolean result = false;
        try {
            String sql = "DELETE FROM chitietphieunhap WHERE MaPN=" + maPN + " AND MaSP=" + maSP;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean updateCTPhieuNhap(int maPN, CTPhieuNhap ctpn) {
        boolean result = false;
        try {
            String sql = "UPDATE chitietphieunhap SET MaPN=?, MaSP=?, SoLuong=?, DonGia=? WHERE MaPN=?";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, ctpn.getMaPN());
            prep.setInt(2, ctpn.getMaSP());
            prep.setInt(3, ctpn.getSoLuong());
            prep.setInt(4, ctpn.getDonGia());
            prep.setInt(5, maPN);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
}
