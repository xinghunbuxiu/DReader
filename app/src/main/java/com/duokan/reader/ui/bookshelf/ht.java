package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.an;
import java.util.LinkedList;

public class ht implements hu {
    /* renamed from: a */
    private Context f6573a;
    /* renamed from: b */
    private cw f6574b = ((cw) AppContext.getAppContext(this.f6573a).queryFeature(cw.class));
    /* renamed from: c */
    private dc f6575c = new dc(new LinkedList(), this.f6573a);
    /* renamed from: d */
    private String f6576d = "";

    public ht(Context context) {
        this.f6573a = context;
    }

    /* renamed from: a */
    public int mo1716a() {
        return this.f6575c.mo506c();
    }

    /* renamed from: a */
    public void mo1719a(String str) {
        this.f6575c.m9459b(this.f6574b.m9435a(str));
        this.f6576d = str;
    }

    /* renamed from: a */
    public View mo1717a(int i, View view, ViewGroup viewGroup) {
        return this.f6575c.mo508d(i, view, viewGroup);
    }

    /* renamed from: a */
    public void mo1718a(int i, View view) {
        an anVar = (an) this.f6575c.mo509d(i);
        if (anVar instanceof C0800c) {
            ((ReaderFeature) AppContext.getAppContext(this.f6573a).queryFeature(ReaderFeature.class)).openBook((C0800c) anVar);
        }
    }

    /* renamed from: b */
    public boolean mo1720b(int i, View view) {
        new hb(this.f6573a, (an) this.f6575c.mo509d(i)).show();
        return true;
    }
}
