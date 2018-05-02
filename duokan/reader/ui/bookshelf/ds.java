package com.duokan.reader.ui.bookshelf;

import android.content.Context;

import com.duokan.c.e;
import com.duokan.common.tools;
import com.duokan.reader.domain.bookshelf.an;

import java.util.List;

public class ds {
    public static boolean a(List list, List list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list != null && list2 == null) {
            return false;
        }
        if (list == null && list2 != null) {
            return false;
        }
        if (list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((an) list.get(i)).aF() != ((an) list2.get(i)).aF()) {
                return false;
            }
        }
        return true;
    }

    public static int a(Context context) {
        return a(context, tools.getWidth(context));
    }

    public static int a(Context context, int i) {
        int i2 = 0;
        int a = i.a(context, 15.0f);
        int dimension = ((int) context.getResources().getDimension(e.general__shared__cover_grid_width)) + a;
        int i3 = i - (a * 2);
        int i4 = 0;
        while (i4 < i3) {
            i4 += dimension;
            if (i4 >= i3) {
                break;
            }
            i4 += a;
            i2++;
        }
        if (i2 < 3) {
            return 3;
        }
        return i2;
    }
}
