package com.duokan.reader.ui.reading;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.core.ui.be;
import com.duokan.kernel.DkUtils;
import com.duokan.p023b.C0242d;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.document.C1013z;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.bo;

class yv extends bo {
    /* renamed from: a */
    final /* synthetic */ yo f11218a;

    private yv(yo yoVar) {
        this.f11218a = yoVar;
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f11218a.f11208i.size();
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return this.f11218a.f11208i.get(i);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        String chs2chtText;
        if (view == null) {
            view = LayoutInflater.from(this.f11218a.getContext()).inflate(C0245g.reading__search_result_item_view, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(C0244f.reading__search_result_item__snippet);
        C1013z c1013z = (C1013z) this.f11218a.f11208i.get(i);
        String str = c1013z.f5025b;
        str = str.substring(0, c1013z.f5026c) + "<font color=\"#ed6c00\">" + str.substring(c1013z.f5026c, c1013z.f5027d) + "</font>" + str.substring(c1013z.f5027d);
        if (((su) this.f11218a.getContext().queryFeature(su.class)).mo2003T()) {
            chs2chtText = DkUtils.chs2chtText(str);
        } else {
            chs2chtText = str;
        }
        textView.setText(Html.fromHtml(chs2chtText));
        textView.setTextColor(this.f11218a.f11206f);
        return view;
    }

    /* renamed from: b */
    protected void mo1555b() {
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        this.f11218a.m15184b();
        if (!this.f11218a.f11211l) {
            m8785a(this.f11218a.f11210k);
        }
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        if (this.f11218a.f11209j == null) {
            return null;
        }
        View dkLabelView = new DkLabelView(this.f11218a.getContext());
        dkLabelView.setText(this.f11218a.getString(C0247i.reading__search_text_view__nosearch_result));
        dkLabelView.setTextColor(this.f11218a.f11206f);
        dkLabelView.setGravity(17);
        dkLabelView.setTextSize(0, this.f11218a.getResources().getDimension(C0242d.general_font__shared__b));
        dkLabelView.setLayoutParams(new be(-2, -2));
        return dkLabelView;
    }
}
