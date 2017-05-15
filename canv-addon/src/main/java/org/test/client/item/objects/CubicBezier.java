package org.test.client.item.objects;

import org.test.client.item.Item;

/**
 * Created by Alexey on 16.05.2017.
 */
public class CubicBezier extends Item{
    int s_x, s_y, cp1x, cp1y, cp2x, cp2y, e_x, e_y;

    public CubicBezier(int s_x, int s_y, int cp1x, int cp1y, int cp2x, int cp2y, int e_x, int e_y) {
        this.s_x = s_x;
        this.s_y = s_y;
        this.cp1x = cp1x;
        this.cp1y = cp1y;
        this.cp2x = cp2x;
        this.cp2y = cp2y;
        this.e_x = e_x;
        this.e_y = e_y;
        Integer[] x = {s_x, cp1x, cp2x, e_x}, y = {s_y, cp1y, cp2y, e_y};
        Integer[] extr_x = getExtr(x), extr_y = getExtr(y);
        setBorders(extr_x[0], extr_y[0], extr_x[1], extr_y[0]);
    }

    private Integer[] getExtr(Integer[] a){
        Integer[] extr = {a[0], a[0]};
        for (int n: a){
            extr[0] = extr[0] < n ? n : extr[0];
            extr[1] = extr[1] > n ? n : extr[1];
        }
        return extr;
    }
}
