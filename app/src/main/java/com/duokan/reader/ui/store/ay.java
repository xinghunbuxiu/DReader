package com.duokan.reader.ui.store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.ak;

class ay extends ak {
    public ay(Context context, String str, String str2, ax axVar, String str3, int i, C0517a c0517a) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(C0245g.store__fiction_purchase1_view, null);
        setExtraContentView(inflate);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(C0244f.store__fiction_purchase_view__name);
        DkLabelView dkLabelView2 = (DkLabelView) inflate.findViewById(C0244f.store__fiction_purchase_view__chapter_price);
        DkLabelView dkLabelView3 = (DkLabelView) findViewById(C0244f.store__fiction_purchase_view__purchase);
        if (i == 2) {
            dkLabelView.setText(String.format(getContext().getString(C0247i.store__fiction_purchase_view__chapter_name), new Object[]{axVar.m15267a(context)}));
            dkLabelView3.setText(C0247i.store__fiction_purchase_view__purchase_chapter);
        } else if (i == 1) {
            dkLabelView.setText(String.format(getContext().getString(C0247i.store__fiction_purchase_view__book_name), new Object[]{str2}));
            dkLabelView3.setText(C0247i.store__fiction_purchase_view__purchase_book);
        }
        dkLabelView2.setText(str3);
        dkLabelView3.setOnClickListener(new az(this, c0517a));
        findViewById(C0244f.store__fiction_purchase_view__chapter_cmread_prompt).setVisibility(0);
        findViewById(C0244f.store__fiction_purchase_view__more).setVisibility(8);
    }
}
