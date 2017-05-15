package org.test.client.item.objects;

import org.test.client.item.Item;

/**
 * Created by Alexey on 16.05.2017.
 */
public class QuadraticBezier extends Item{
    int s_x, s_y, cpx, cpy, e_x, e_y;

    public QuadraticBezier(int s_x, int s_y, int cpx, int cpy, int e_x, int e_y) {
        this.s_x = s_x;
        this.s_y = s_y;
        this.cpx = cpx;
        this.cpy = cpy;
        this.e_x = e_x;
        this.e_y = e_y;
        Integer[] x = {s_x, cpx, e_x}, y = {s_y, cpy, e_y};
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
