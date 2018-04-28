package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.core.sys.ah;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.C0840a;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.hv;
import com.duokan.reader.ui.general.deprecatedDkTextView;
import com.duokan.reader.ui.general.expandable.C1293a;
import com.duokan.reader.ui.general.hc;
import java.util.ArrayList;
import java.util.List;

public class br extends fx {
    /* renamed from: a */
    static final /* synthetic */ boolean f8350a = (!br.class.desiredAssertionStatus());
    /* renamed from: f */
    private final Context f8351f;
    /* renamed from: g */
    private C0840a f8352g = null;
    /* renamed from: h */
    private Drawable[] f8353h;
    /* renamed from: i */
    private List<DkCloudStoreBook> f8354i = new ArrayList();
    /* renamed from: j */
    private List<DkCloudStoreBook> f8355j = new ArrayList();
    /* renamed from: k */
    private ly f8356k = null;

    public br(Context context, C1293a c1293a, ks ksVar, hv hvVar, fy fyVar) {
        super(context, c1293a, ksVar, hvVar, fyVar);
        this.f8351f = context;
    }

    /* renamed from: a */
    public int mo1871a() {
        if (this.f8352g == null) {
            return 0;
        }
        int b = this.f8352g.m5261b();
        return b > 0 ? b + 1 : b;
    }

    /* renamed from: b */
    public int mo1875b() {
        int i = 0;
        if (this.f8352g == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.f8352g.m5261b()) {
            i2 += this.f8352g.m5256a(i).m5261b();
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public Object mo1873a(int i) {
        return null;
    }

    /* renamed from: b */
    public int mo1876b(int i) {
        if (this.f8352g == null || i == 0) {
            return 0;
        }
        return this.f8352g.m5256a(i - 1).m5261b();
    }

    /* renamed from: a */
    public View mo1872a(int i, View view, ViewGroup viewGroup) {
        C0840a c0840a;
        C0840a c0840a2 = null;
        int i2 = 0;
        if (view == null || view.findViewById(C0255g.bookshelf__purchased_book_group_list_item_view__group_name) == null) {
            view = LayoutInflater.from(this.f8351f).inflate(C0256h.bookshelf__purchased_book_group_list_item_view, viewGroup, false);
        }
        int i3 = i;
        for (int i4 = 0; i4 < this.f8352g.m5261b(); i4++) {
            C0840a a = this.f8352g.m5256a(i4);
            int b = a.m5261b();
            if (i3 >= 0 && i3 < b) {
                c0840a2 = a.m5256a(i3);
                c0840a = a;
                break;
            }
            i3 -= b;
        }
        c0840a = null;
        if (f8350a || c0840a2 != null) {
            ((TextView) view.findViewById(C0255g.bookshelf__purchased_book_group_list_item_view__group_name)).setText(c0840a2.m5258a());
            deprecatedDkTextView deprecateddktextview = (deprecatedDkTextView) view.findViewById(C0255g.bookshelf__purchased_book_group_list_item_view__book_names);
            StringBuilder stringBuilder = new StringBuilder();
            while (i2 < Math.min(c0840a2.m5266d(), 10)) {
                if (i2 > 0) {
                    stringBuilder.append(this.f8351f.getResources().getString(C0258j.bookshelf__shared__short_comma));
                }
                stringBuilder.append(c0840a2.m5262b(i2).getTitle());
                i2++;
            }
            deprecateddktextview.setText(stringBuilder.toString());
            ((TextView) view.findViewById(C0255g.bookshelf__purchased_book_group_list_item_view__total_books)).setText("" + c0840a2.m5266d());
            view.findViewById(C0255g.bookshelf__purchased_book_group_list_item_view__cover).setBackgroundDrawable(m11492c(i));
            view.setOnClickListener(new bs(this, c0840a.m5258a(), c0840a2.m5258a()));
            return view;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public View mo1877b(int i, View view, ViewGroup viewGroup) {
        if (i == 0) {
            return null;
        }
        return m11493c(i - 1, view, viewGroup);
    }

    /* renamed from: a */
    public void mo1874a(List<DkCloudStoreBook> list, List<DkCloudStoreBook> list2, List<DkCloudStoreBook> list3, Runnable runnable) {
        ah.m865a(new bt(this, list, list2, runnable));
    }

    /* renamed from: c */
    private View m11493c(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f8351f).inflate(C0256h.bookshelf__purchased_category_title_view, viewGroup, false);
        }
        ((TextView) view.findViewById(C0255g.bookshelf__purchased_category_title_view__title)).setText(this.f8352g.m5256a(i).m5258a());
        return view;
    }

    /* renamed from: c */
    private Drawable m11492c(int i) {
        if (this.f8353h == null) {
            this.f8353h = new Drawable[8];
            int b = dv.m1932b(this.f8351f, 5.0f);
            this.f8353h[0] = new hc((float) b, (float) b, this.f8351f.getResources().getColor(C0252d.general__shared__f6bc7e));
            this.f8353h[1] = new hc((float) b, (float) b, this.f8351f.getResources().getColor(C0252d.general__shared__e49baa));
            this.f8353h[2] = new hc((float) b, (float) b, this.f8351f.getResources().getColor(C0252d.general__shared__98d4db));
            this.f8353h[3] = new hc((float) b, (float) b, this.f8351f.getResources().getColor(C0252d.general__shared__8bb2d2));
            this.f8353h[4] = new hc((float) b, (float) b, this.f8351f.getResources().getColor(C0252d.general__shared__95c5f3));
            this.f8353h[5] = new hc((float) b, (float) b, this.f8351f.getResources().getColor(C0252d.general__shared__c1d8bf));
            this.f8353h[6] = new hc((float) b, (float) b, this.f8351f.getResources().getColor(C0252d.general__shared__c0afd0));
            this.f8353h[7] = new hc((float) b, (float) b, this.f8351f.getResources().getColor(C0252d.general__shared__ffa191));
        }
        return this.f8353h[i % this.f8353h.length];
    }
}
