package com.duokan.reader.ui.store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.reader.common.async.a.a;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.ak;

class ay extends ak {
    public ay(Context context, String str, String str2, ax axVar, String str3, int i, a aVar) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(g.store__fiction_purchase1_view, null);
        setExtraContentView(inflate);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(f.store__fiction_purchase_view__name);
        DkLabelView dkLabelView2 = (DkLabelView) inflate.findViewById(f.store__fiction_purchase_view__chapter_price);
        DkLabelView dkLabelView3 = (DkLabelView) findViewById(f.store__fiction_purchase_view__purchase);
        if (i == 2) {
            dkLabelView.setText(String.format(getContext().getString(i.store__fiction_purchase_view__chapter_name), new Object[]{axVar.a(context)}));
            dkLabelView3.setText(i.store__fiction_purchase_view__purchase_chapter);
        } else if (i == 1) {
            dkLabelView.setText(String.format(getContext().getString(i.store__fiction_purchase_view__book_name), new Object[]{str2}));
            dkLabelView3.setText(i.store__fiction_purchase_view__purchase_book);
        }
        dkLabelView2.setText(str3);
        dkLabelView3.setOnClickListener(new az(this, aVar));
        findViewById(f.store__fiction_purchase_view__chapter_cmread_prompt).setVisibility(0);
        findViewById(f.store__fiction_purchase_view__more).setVisibility(8);
    }
}
