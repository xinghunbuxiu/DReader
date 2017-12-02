package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.reader.domain.document.a;
import com.duokan.reader.ui.general.gh;

public class il extends in {
    final /* synthetic */ ij c;
    private final View e;

    public il(ij ijVar, a aVar, a aVar2, View view) {
        this.c = ijVar;
        super(ijVar, aVar);
        this.e = view;
        ijVar.e = ijVar.e + 1;
    }

    public View b() {
        return this.e;
    }

    public gh a(int i) {
        if (i > 0) {
            return this.c.b(b(i - 1));
        }
        return this.c.b(b(i));
    }
}
