package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.duokan.c.d;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.common.i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.HeaderView;

import java.io.File;

public class m extends FrameLayout {
    private l[] a;

    public m(Context context) {
        super(context);
        ((HeaderView) LayoutInflater.from(context).inflate(h.personal__book_storage_view, this).findViewById(g.personal__book_storage_view__header)).setLeftTitle(j.personal__book_storage_view__book_storage);
    }

    public void setStorages(l[] lVarArr) {
        this.a = lVarArr;
        a();
    }

    private void a() {
        LinearLayout linearLayout = (LinearLayout) findViewById(g.personal__book_storage_view__content);
        linearLayout.removeAllViews();
        for (l lVar : this.a) {
            View inflate = LayoutInflater.from(getContext()).inflate(h.personal__storage_item_view, null);
            inflate.findViewById(g.personal__storage_item_view__select).setVisibility(lVar.e ? 0 : 4);
            DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(g.personal__storage_item_view__lable);
            DkLabelView dkLabelView2 = (DkLabelView) inflate.findViewById(g.personal__storage_item_view__space);
            DkLabelView dkLabelView3 = (DkLabelView) inflate.findViewById(g.personal__storage_item_view__free_space);
            dkLabelView.setText(lVar.a);
            dkLabelView2.setText(i.a(lVar.c));
            dkLabelView3.setText(String.format(getResources().getString(j.personal__storage_item_view__free_space), new Object[]{i.a(lVar.d)}));
            inflate.setTag(lVar);
            linearLayout.addView(inflate);
            inflate.setOnClickListener(new n(this));
            if (lVar.d < 536870912) {
                dkLabelView3.setTextColor(-65536);
            }
            if (lVar.d <= 0) {
                inflate.setEnabled(false);
                dkLabelView3.setTextColor(getResources().getColor(d.general__shared__888888));
                dkLabelView.setTextColor(getResources().getColor(d.general__shared__888888));
            }
        }
    }

    private void a(l lVar) {
        for (l lVar2 : this.a) {
            boolean z;
            if (lVar2 == lVar) {
                z = true;
            } else {
                z = false;
            }
            lVar2.e = z;
        }
        ReaderEnv.get().setSecondaryStorageDirectory(new File(lVar.b));
        a();
    }
}
