package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;

import com.duokan.b.d;
import com.duokan.reader.domain.document.ad;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.ui.general.DkLabelView;

public class jx extends fu {
    public jx(Context context, gn gnVar, Rect rect, ad adVar) {
        super(context, gnVar, rect, adVar);
        setDrawBorder(false);
        setOnClickListener(new jy(this));
        View dkLabelView = new DkLabelView(context);
        dkLabelView.setGravity(55);
        dkLabelView.setText(adVar.k().d());
        dkLabelView.setTextColor(-1);
        dkLabelView.setTextSize(0, getResources().getDimension(d.general_font__shared__b));
        View dkLabelView2 = new DkLabelView(context);
        dkLabelView2.setGravity(55);
        dkLabelView2.setText(adVar.k().e());
        dkLabelView2.setTextColor(-1);
        dkLabelView2.setTextSize(0, getResources().getDimension(d.general_font__shared__c));
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(dkLabelView, new LayoutParams(-1, -2));
        linearLayout.addView(dkLabelView2, new LayoutParams(-1, -2));
        a(linearLayout, null);
    }

    public fy a(au auVar) {
        return new jz(getContext(), (ad) auVar, getOriginBounds());
    }
}
