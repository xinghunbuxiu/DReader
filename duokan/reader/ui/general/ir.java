package com.duokan.reader.ui.general;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.duokan.core.ui.TabBarView;

public class ir {
    private final TabBarView a;
    private final iu b;
    private final int[] c;
    private ix d;
    private int e = -1;

    public ir(TabBarView tabBarView, iu iuVar, int[] iArr) {
        this.a = tabBarView;
        this.b = iuVar;
        this.c = iArr;
        iuVar.setTabListener(new is(this, tabBarView));
        tabBarView.setSelectionChangeListener(new it(this, iuVar));
    }

    public void a(View view, View view2) {
        this.a.a(view);
        this.b.addView(view2, new LayoutParams(-1, -1));
    }

    public void a(int i) {
        this.b.b(i);
        a(i, true);
    }

    public void a(ix ixVar) {
        this.d = ixVar;
    }

    private void a(int i, boolean z) {
        if ((this.e != i || z) && this.a.getTabCount() > 0 && this.c != null) {
            View b;
            if (this.e >= 0) {
                b = this.a.b(this.e);
                if (b instanceof TextView) {
                    ((TextView) b).setTextColor(this.c[0]);
                }
                b.setSelected(false);
            }
            this.e = i;
            b = this.a.b(this.e);
            if (b instanceof TextView) {
                ((TextView) b).setTextColor(this.c[1]);
            }
            b.setSelected(true);
        }
    }
}
