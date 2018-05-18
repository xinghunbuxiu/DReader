package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import com.duokan.common.CommonUtils;
import com.duokan.p024c.C0253e;
import com.duokan.reader.domain.bookshelf.an;
import java.util.List;

public class ea {
    /* renamed from: a */
    public static boolean m9505a(List<an> list, List<an> list2) {
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
            if (((an) list.get(i)).aH() != ((an) list2.get(i)).aH()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static int m9503a(Context context) {
        return m9504a(context, CommonUtils.m606b(context));
    }

    /* renamed from: a */
    public static int m9504a(Context context, int i) {
        int i2 = 0;
        int a = CommonUtils.dip2px(context, 15.0f);
        int dimension = ((int) context.getResources().getDimension(C0253e.general__shared__cover_grid_width)) + a;
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
