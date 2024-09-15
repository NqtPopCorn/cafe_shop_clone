package BUS;

import DAO.CTHoaDonDAO;
import DTO.CTHoaDon;
import DTO.HoaDon;

import java.util.ArrayList;

public class CTHoaDonBUS {

    private static CTHoaDonBUS instance;

    public static CTHoaDonBUS getInstance() {
        if (instance == null)
            instance = new CTHoaDonBUS();
        return instance;
    }

    private ArrayList<CTHoaDon> listCTHoaDon;
    private CTHoaDonDAO ctHDDAO;
    private HoaDonBUS hdBUS;

    private CTHoaDonBUS() {
        ctHDDAO = CTHoaDonDAO.getInstance();
        hdBUS = HoaDonBUS.getInstance();
        this.listCTHoaDon = ctHDDAO.getListCTHoaDon();
    }

    public void docListCTHoaDon() {
        this.listCTHoaDon = ctHDDAO.getListCTHoaDon();
    }

    public ArrayList<CTHoaDon> getListCTHoaDon() {
        return listCTHoaDon;
    }

    public ArrayList<CTHoaDon> getListCTHoaDonTheoMaHD(String maHD) {
        int ma = Integer.parseInt(maHD);
        ArrayList<CTHoaDon> dsct = new ArrayList<>();

        for (CTHoaDon cthd : listCTHoaDon) {
            if (cthd.getMaHD() == ma)
                dsct.add(cthd);
        }

        return dsct;
    }

    public void addCTHoaDon(String maSP, String soLuong, String donGia, String thanhTien) {
        int ma = hdBUS.getMaHoaDonMoiNhat();

        donGia = donGia.replace(",", "");
        thanhTien = thanhTien.replace(",", "");

        CTHoaDon cthd = new CTHoaDon();

        cthd.setMaHD(ma);
        cthd.setMaSP(Integer.parseInt(maSP));
        cthd.setDonGia(Integer.parseInt(donGia));
        cthd.setSoLuong(Integer.parseInt(soLuong));

        ctHDDAO.addCTHoaDon(cthd);
    }
}
