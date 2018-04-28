package com.duokan.reader.ui.general;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.duokan.core.ui.TabBarView;

public class ib {
    /* renamed from: a */
    private final TabBarView f7364a;
    /* renamed from: b */
    private final ie f7365b;
    /* renamed from: c */
    private final int[] f7366c;
    /* renamed from: d */
    private ih f7367d;
    /* renamed from: e */
    private int f7368e = -1;

    public ib(TabBarView tabBarView, ie ieVar, int[] iArr) {
        this.f7364a = tabBarView;
        this.f7365b = ieVar;
        this.f7366c = iArr;
        ieVar.setTabListener(new ic(this, tabBarView));
        tabBarView.setSelectionChangeListener(new id(this, ieVar));
    }

    /* renamed from: a */
    public void m10775a(View view, View view2) {
        this.f7364a.m1320a(view);
        this.f7365b.addView(view2, new LayoutParams(-1, -1));
    }

    /* renamed from: a */
    public void m10774a(int i) {
        this.f7365b.m9070b(i);
        m10772a(i, true);
    }

    /* renamed from: a */
    public void m10776a(ih ihVar) {
        this.f7367d = ihVar;
    }

    /* renamed from: a */
    private void m10772a(int i, boolean z) {
        if ((this.f7368e != i || z) && this.f7364a.getTabCount() > 0 && this.f7366c != null) {
            View b;
            if (this.f7368e >= 0) {
                b = this.f7364a.m1321b(this.f7368e);
                if (b instanceof TextView) {
                    ((TextView) b).setTextColor(this.f7366c[0]);
                }
                b.setSelected(false);
            }
            this.f7368e = i;
            b = this.f7364a.m1321b(this.f7368e);
            if (b instanceof TextView) {
                ((TextView) b).setTextColor(this.f7366c[1]);
            }
            b.setSelected(true);
        }
    }
}
