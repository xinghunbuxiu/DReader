package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.core.sys.ah;
import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.cloud.a;
import com.duokan.reader.ui.bookshelf.ho;
import com.duokan.reader.ui.general.deprecatedDkTextView;
import com.duokan.reader.ui.general.hn;

import java.util.ArrayList;
import java.util.List;

public class by extends fj {
    static final /* synthetic */ boolean a = (!by.class.desiredAssertionStatus());
    private final Context f;
    private a g = null;
    private Drawable[] h;
    private List i = new ArrayList();
    private List j = new ArrayList();
    private lk k = null;

    public by(Context context, com.duokan.reader.ui.general.expandable.a aVar, ke keVar, ho hoVar, fk fkVar) {
        super(context, aVar, keVar, hoVar, fkVar);
        this.f = context;
    }

    public int a() {
        if (this.g == null) {
            return 0;
        }
        int b = this.g.b();
        return b > 0 ? b + 1 : b;
    }

    public int b() {
        int i = 0;
        if (this.g == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.g.b()) {
            i2 += this.g.a(i).b();
            i++;
        }
        return i2;
    }

    public Object a(int i) {
        return null;
    }

    public int b(int i) {
        if (this.g == null || i == 0) {
            return 0;
        }
        return this.g.a(i - 1).b();
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = null;
        int i2 = 0;
        if (view == null || view.findViewById(g.bookshelf__purchased_book_group_list_item_view__group_name) == null) {
            view = LayoutInflater.from(this.f).inflate(h.bookshelf__purchased_book_group_list_item_view, viewGroup, false);
        }
        int i3 = i;
        for (int i4 = 0; i4 < this.g.b(); i4++) {
            a a = this.g.a(i4);
            int b = a.b();
            if (i3 >= 0 && i3 < b) {
                aVar2 = a.a(i3);
                aVar = a;
                break;
            }
            i3 -= b;
        }
        aVar = null;
        if (a || aVar2 != null) {
            ((TextView) view.findViewById(g.bookshelf__purchased_book_group_list_item_view__group_name)).setText(aVar2.a());
            deprecatedDkTextView com_duokan_reader_ui_general_deprecatedDkTextView = (deprecatedDkTextView) view.findViewById(g.bookshelf__purchased_book_group_list_item_view__book_names);
            StringBuilder stringBuilder = new StringBuilder();
            while (i2 < Math.min(aVar2.d(), 10)) {
                if (i2 > 0) {
                    stringBuilder.append(this.f.getResources().getString(j.bookshelf__shared__short_comma));
                }
                stringBuilder.append(aVar2.b(i2).getTitle());
                i2++;
            }
            com_duokan_reader_ui_general_deprecatedDkTextView.setText(stringBuilder.toString());
            ((TextView) view.findViewById(g.bookshelf__purchased_book_group_list_item_view__total_books)).setText("" + aVar2.d());
            view.findViewById(g.bookshelf__purchased_book_group_list_item_view__cover).setBackgroundDrawable(c(i));
            view.setOnClickListener(new bz(this, aVar.a(), aVar2.a()));
            return view;
        }
        throw new AssertionError();
    }

    public View b(int i, View view, ViewGroup viewGroup) {
        if (i == 0) {
            return null;
        }
        return c(i - 1, view, viewGroup);
    }

    public void a(List list, List list2, List list3, Runnable runnable) {
        ah.future(new ca(this, list, list2, runnable));
    }

    private View c(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f).inflate(h.bookshelf__purchased_category_title_view, viewGroup, false);
        }
        ((TextView) view.findViewById(g.bookshelf__purchased_category_title_view__title)).setText(this.g.a(i).a());
        return view;
    }

    private Drawable c(int i) {
        if (this.h == null) {
            this.h = new Drawable[8];
            int b = UTools.closeAnimation(this.f, 5.0f);
            this.h[0] = new hn((float) b, (float) b, this.f.getResources().getColor(d.general__shared__f6bc7e));
            this.h[1] = new hn((float) b, (float) b, this.f.getResources().getColor(d.general__shared__e49baa));
            this.h[2] = new hn((float) b, (float) b, this.f.getResources().getColor(d.general__shared__98d4db));
            this.h[3] = new hn((float) b, (float) b, this.f.getResources().getColor(d.general__shared__8bb2d2));
            this.h[4] = new hn((float) b, (float) b, this.f.getResources().getColor(d.general__shared__95c5f3));
            this.h[5] = new hn((float) b, (float) b, this.f.getResources().getColor(d.general__shared__c1d8bf));
            this.h[6] = new hn((float) b, (float) b, this.f.getResources().getColor(d.general__shared__c0afd0));
            this.h[7] = new hn((float) b, (float) b, this.f.getResources().getColor(d.general__shared__ffa191));
        }
        return this.h[i % this.h.length];
    }
}
