package com.duokan.reader.common;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.duokan.reader.common.b */
public abstract class C0543b {
    /* renamed from: a */
    public static boolean m2423a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null) {
            return str2.equals(str);
        }
        return str.equals(str2);
    }

    /* renamed from: a */
    public static boolean m2422a(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > '') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static SpannableStringBuilder m2417a(int i, int i2, Object... objArr) {
        List arrayList = new ArrayList();
        for (Object obj : objArr) {
            arrayList.add(obj.toString());
        }
        return C0543b.m2415a(i, i2, " ", arrayList);
    }

    /* renamed from: a */
    public static SpannableStringBuilder m2419a(int i, Object... objArr) {
        List arrayList = new ArrayList();
        for (Object obj : objArr) {
            arrayList.add(obj.toString());
        }
        return C0543b.m2418a(i, " ", arrayList);
    }

    /* renamed from: a */
    public static SpannableStringBuilder m2416a(int i, int i2, String str, Object... objArr) {
        List arrayList = new ArrayList();
        for (Object obj : objArr) {
            arrayList.add(obj.toString());
        }
        return C0543b.m2415a(i, i2, str, arrayList);
    }

    /* renamed from: a */
    private static SpannableStringBuilder m2415a(int i, int i2, String str, List<String> list) {
        int i3 = 0;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(DkApp.get().getString(i), list.toArray()));
        int i4 = 0;
        while (i3 < list.size()) {
            i4 = spannableStringBuilder.toString().indexOf(str, i4);
            int indexOf = spannableStringBuilder.toString().indexOf(str, i4 + 1);
            spannableStringBuilder.delete(i4, i4 + 1);
            spannableStringBuilder.delete(indexOf - 1, indexOf);
            indexOf--;
            spannableStringBuilder.setSpan(new ForegroundColorSpan(DkApp.get().getResources().getColor(C0241c.general__shared__ff6c00)), i4, indexOf, 17);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(AnimUtils.m1932b(DkApp.get(), (float) i2)), i4, indexOf, 17);
            i4 = indexOf + 1;
            i3++;
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    private static SpannableStringBuilder m2418a(int i, String str, List<String> list) {
        int i2 = 0;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(DkApp.get().getString(i), list.toArray()));
        int i3 = 0;
        while (i2 < list.size()) {
            i3 = spannableStringBuilder.toString().indexOf(str, i3);
            int indexOf = spannableStringBuilder.toString().indexOf(str, i3 + 1);
            spannableStringBuilder.delete(i3, i3 + 1);
            spannableStringBuilder.delete(indexOf - 1, indexOf);
            indexOf--;
            spannableStringBuilder.setSpan(new StyleSpan(1), i3, indexOf, 17);
            i3 = indexOf + 1;
            i2++;
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    public static String m2420a(double d) {
        if (d <= 0.99d) {
            return new DecimalFormat(DkApp.get().getString(C0247i.personal__experience_view__percentage_formatter)).format(d);
        }
        return new DecimalFormat(DkApp.get().getString(C0247i.personal__experience_view__percentage_formatter_precise)).format(d);
    }

    /* renamed from: a */
    public static String m2421a(long j) {
        if (j < 60) {
            return String.format(DkApp.get().getString(C0247i.personal__experience_view__second), new Object[]{Long.valueOf(j)});
        } else if (j < 3600) {
            return String.format(DkApp.get().getString(C0247i.personal__experience_view__minute), new Object[]{Integer.valueOf((int) Math.floor((double) (((float) j) / 60.0f)))});
        } else {
            return String.format(DkApp.get().getString(C0247i.personal__experience_view__hour), new Object[]{Integer.valueOf((int) Math.floor((double) (((float) j) / 3600.0f)))});
        }
    }
}
