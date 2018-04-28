package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.View;
import com.duokan.core.ui.dv;

class zj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Rect[] f11268a;
    /* renamed from: b */
    final /* synthetic */ zi f11269b;

    zj(zi ziVar, Rect[] rectArr) {
        this.f11269b = ziVar;
        this.f11268a = rectArr;
    }

    public void run() {
        for (int i = 1; i < this.f11269b.f11267a.f11246s.getChildCount(); i++) {
            this.f11269b.f11267a.m15203a(this.f11269b.f11267a.f11246s.getChildAt(i), dv.m1932b(this.f11269b.f11267a.getContext(), 40.0f) * i);
        }
        for (int toolCount = this.f11269b.f11267a.f11253z.getToolCount() - 1; toolCount > 0; toolCount--) {
            this.f11269b.f11267a.m15209b((View) this.f11269b.f11267a.f11253z.m10807a(toolCount).getParent(), dv.m1904a(new Rect(), this.f11269b.f11267a.f11253z.m10807a(toolCount), null).left - this.f11268a[toolCount].left);
        }
    }
}
