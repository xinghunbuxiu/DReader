package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.duokan.p023b.C0242d;
import com.duokan.reader.domain.document.ad;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.ui.general.DkLabelView;

public class kh extends fz {
    public kh(Context context, gs gsVar, Rect rect, ad adVar) {
        super(context, gsVar, rect, adVar);
        setDrawBorder(false);
        setOnClickListener(new ki(this));
        View dkLabelView = new DkLabelView(context);
        dkLabelView.setGravity(55);
        dkLabelView.setText(adVar.mo1396k().mo1404d());
        dkLabelView.setTextColor(-1);
        dkLabelView.setTextSize(0, getResources().getDimension(C0242d.general_font__shared__b));
        View dkLabelView2 = new DkLabelView(context);
        dkLabelView2.setGravity(55);
        dkLabelView2.setText(adVar.mo1396k().mo1405e());
        dkLabelView2.setTextColor(-1);
        dkLabelView2.setTextSize(0, getResources().getDimension(C0242d.general_font__shared__c));
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(dkLabelView, new LayoutParams(-1, -2));
        linearLayout.addView(dkLabelView2, new LayoutParams(-1, -2));
        m14166a(linearLayout, null);
    }

    /* renamed from: a */
    public gd mo2403a(au auVar) {
        return new kj(getContext(), (ad) auVar, getOriginBounds());
    }
}
