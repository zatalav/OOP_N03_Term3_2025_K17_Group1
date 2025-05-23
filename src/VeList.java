package src;

import java.util.ArrayList;

public class VeList {
    private ArrayList<Ve> danhSachVe = new ArrayList<>();

    public void themVe(Ve ve) {
        danhSachVe.add(ve);
    }

    public void xoaVeTheoMa(String maVe) {
        danhSachVe.removeIf(ve -> ve.getMaVe().equals(maVe));
    }

    public void inDanhSachVe() {
        for (Ve ve : danhSachVe) {
            System.out.println(ve);
        }
    }

    public Ve timVeTheoMa(String maVe) {
        for (Ve ve : danhSachVe) {
            if (ve.getMaVe().equals(maVe)) {
                return ve;
            }
        }
        return null;
    }

    public ArrayList<Ve> getDanhSachVe() {
        return danhSachVe;
    }
}
