package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.duokan.common.CommonUtils;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.HeaderView;
import java.io.File;

/* renamed from: com.duokan.reader.ui.personal.m */
public class C1405m extends FrameLayout {
    /* renamed from: a */
    private C1404l[] f8919a;

    public C1405m(Context context) {
        super(context);
        ((HeaderView) LayoutInflater.from(context).inflate(C0256h.personal__book_storage_view, this).findViewById(C0255g.personal__book_storage_view__header)).setLeftTitle(C0258j.personal__book_storage_view__book_storage);
    }

    public void setStorages(C1404l[] c1404lArr) {
        this.f8919a = c1404lArr;
        m12238a();
    }

    /* renamed from: a */
    private void m12238a() {
        LinearLayout linearLayout = (LinearLayout) findViewById(C0255g.personal__book_storage_view__content);
        linearLayout.removeAllViews();
        for (C1404l c1404l : this.f8919a) {
            View inflate = LayoutInflater.from(getContext()).inflate(C0256h.personal__storage_item_view, null);
            inflate.findViewById(C0255g.personal__storage_item_view__select).setVisibility(c1404l.f8854e ? 0 : 4);
            DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(C0255g.personal__storage_item_view__lable);
            DkLabelView dkLabelView2 = (DkLabelView) inflate.findViewById(C0255g.personal__storage_item_view__space);
            DkLabelView dkLabelView3 = (DkLabelView) inflate.findViewById(C0255g.personal__storage_item_view__free_space);
            dkLabelView.setText(c1404l.f8850a);
            dkLabelView2.setText(CommonUtils.m599a(c1404l.f8852c));
            dkLabelView3.setText(String.format(getResources().getString(C0258j.personal__storage_item_view__free_space), new Object[]{CommonUtils.m599a(c1404l.f8853d)}));
            inflate.setTag(c1404l);
            linearLayout.addView(inflate);
            inflate.setOnClickListener(new C1406n(this));
            if (c1404l.f8853d < 536870912) {
                dkLabelView3.setTextColor(-65536);
            }
            if (c1404l.f8853d <= 0) {
                inflate.setEnabled(false);
                dkLabelView3.setTextColor(getResources().getColor(C0252d.general__shared__888888));
                dkLabelView.setTextColor(getResources().getColor(C0252d.general__shared__888888));
            }
        }
    }

    /* renamed from: a */
    private void m12239a(C1404l c1404l) {
        for (C1404l c1404l2 : this.f8919a) {
            boolean z;
            if (c1404l2 == c1404l) {
                z = true;
            } else {
                z = false;
            }
            c1404l2.f8854e = z;
        }
        ReaderEnv.get().setSecondaryStorageDirectory(new File(c1404l.f8851b));
        m12238a();
    }
}
