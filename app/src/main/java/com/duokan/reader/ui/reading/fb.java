package com.duokan.reader.ui.reading;

import com.duokan.core.ui.cs;

class fb implements cs {
    final /* synthetic */ ColorPickerView a;
    final /* synthetic */ fa b;

    fb(fa faVar, ColorPickerView colorPickerView) {
        this.b = faVar;
        this.a = colorPickerView;
    }

    public void a(int i, int i2, boolean z) {
        if (i2 == 0) {
            this.a.a(this.b.a.ae().B(), this.b.a.ae().C());
        } else {
            this.a.a(this.b.a.ae().E(), this.b.a.ae().F());
        }
    }

    public void b(int i, int i2, boolean z) {
    }
}
