package com.duokan.reader.ui.general;

import com.duokan.core.ui.cs;

class it implements cs {
    final /* synthetic */ iu a;
    final /* synthetic */ ir b;

    it(ir irVar, iu iuVar) {
        this.b = irVar;
        this.a = iuVar;
    }

    public void a(int i, int i2, boolean z) {
    }

    public void b(int i, int i2, boolean z) {
        if (!z) {
            return;
        }
        if (this.a.getShowingChildIndex() != i2) {
            this.a.b(i2);
        } else if (this.b.d != null) {
            this.b.d.a(i, i2);
        }
    }
}
