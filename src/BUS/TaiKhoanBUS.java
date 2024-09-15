package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoan;
import CustomFunctions.Dialog;
import DAO.NhanVienDAO;
import DAO.PhanQuyenDAO;

public class TaiKhoanBUS {

    private TaiKhoanDAO taiKhoanDAO;

    private static TaiKhoanBUS instance;

    public static TaiKhoanBUS getInstance() {
        if (instance == null)
            instance = new TaiKhoanBUS();
        return instance;
    }

    private TaiKhoanBUS() {
        taiKhoanDAO = TaiKhoanDAO.getInstance();
    }

    public String getTenDangNhapTheoMa(String ma) {
        int maNV = Integer.parseInt(ma);
        return taiKhoanDAO.getTenDangNhapTheoMa(maNV);
    }

    public String getQuyenTheoMa(String ma) {
        int maTK = Integer.parseInt(ma);
        return taiKhoanDAO.getQuyenTheoMa(maTK);
    }

    public void datLaiMatKhau(String ma, String tenDangNhap) {
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.datLaiMatKhau(maNV, tenDangNhap);
        if (flag) {
            new Dialog("Đặt lại thành công! Mật khẩu mới là: " + tenDangNhap, Dialog.SUCCESS_DIALOG);
        } else {
            new Dialog("Đặt lại thất bại!", Dialog.ERROR_DIALOG);
        }
    }

    public void datLaiQuyen(String ma, String quyen) {
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.datLaiQuyen(maNV, PhanQuyenDAO.getInstance().getMaQuyen(quyen));
        if (flag) {
            new Dialog("Đặt lại thành công!", Dialog.SUCCESS_DIALOG);
        } else {
            new Dialog("Đặt lại thất bại!", Dialog.ERROR_DIALOG);
        }
    }

    public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        return taiKhoanDAO.kiemTraTrungTenDangNhap(tenDangNhap);
    }

    public boolean themTaiKhoan(String ma, String tenDangNhap, String quyen) {
        int maNV = Integer.parseInt(ma);
        if (tenDangNhap.trim().equals("")) {
            new Dialog("Không được để trống Tên đăng nhập!", Dialog.ERROR_DIALOG);
            return false;
        }
        if (kiemTraTrungTenDangNhap(tenDangNhap)) {
            Dialog dlg = new Dialog("Tên đăng nhập bị trùng! Có thể tài khoản bị khoá, thực hiện mở khoá?",
                    Dialog.WARNING_DIALOG);
            if (dlg.getAction() == Dialog.OK_OPTION) {
                moKhoaTaiKhoan(ma);
                return true;
            }
            return false;
        }
        boolean flag = taiKhoanDAO.themTaiKhoan(tenDangNhap, tenDangNhap);
        if (flag) {

            NhanVienDAO.getInstance().updateTaiKhoanNV(maNV, tenDangNhap);
            taiKhoanDAO.themQuyen(taiKhoanDAO.getMaTK(tenDangNhap), PhanQuyenDAO.getInstance().getMaQuyen(quyen));

            new Dialog("Cấp tài khoản thành công! Mật khẩu là " + tenDangNhap, Dialog.SUCCESS_DIALOG);
        } else {
            new Dialog("Cấp tài khoản thất bại! Tài khoản đã tồn tại", Dialog.ERROR_DIALOG);
        }
        return flag;
    }

    public void khoaTaiKhoan(String ma) {
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.khoaTaiKhoan(maNV);
        if (flag) {
            new Dialog("Khoá tài khoản thành công!", Dialog.SUCCESS_DIALOG);
        } else {
            new Dialog("Khoá tài khoản thất bại!", Dialog.ERROR_DIALOG);
        }
    }

    public void moKhoaTaiKhoan(String ma) {
        int maNV = Integer.parseInt(ma);

        boolean flag = taiKhoanDAO.moKhoaTaiKhoan(maNV);
        if (flag) {
            new Dialog("Mở khoá tài khoản thành công!", Dialog.SUCCESS_DIALOG);
        } else {
            new Dialog("Mở khoá tài khoản thất bại!", Dialog.ERROR_DIALOG);
        }
    }

    public boolean doiMatKhau(String matKhauCu, String matKhauMoi, String nhapLaiMatKhau) {
        if (!matKhauMoi.equals(nhapLaiMatKhau)) {
            new Dialog("Mật khẩu mới không khớp!", Dialog.ERROR_DIALOG);
            return false;
        }
        boolean flag = taiKhoanDAO.doiMatKhau(matKhauCu, matKhauMoi);
        if (flag) {
            new Dialog("Đổi thành công!", Dialog.SUCCESS_DIALOG);
        } else {
            new Dialog("Mật khẩu cũ nhập sai!", Dialog.ERROR_DIALOG);
        }
        return flag;
    }

    public int getTrangThai(String maNV) {
        int ma = Integer.parseInt(maNV);
        return taiKhoanDAO.getTrangThai(ma);
    }

}
