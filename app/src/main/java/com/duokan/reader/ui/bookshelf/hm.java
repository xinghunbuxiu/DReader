package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.core.app.x;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;

import java.util.LinkedList;

public class hm implements hn {
    private Context a;
    private cr b = ((cr) x.a(this.a).queryFeature(cr.class));
    private cx c = new cx(new LinkedList(), this.a);
    private String d = "";

    public hm(Context context) {
        this.a = context;
    }

    public int a() {
        return this.c.c();
    }

    public void a(String str) {
        this.c.b(this.b.a(str));
        this.d = str;
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        return this.c.d(i, view, viewGroup);
    }

    public void a(int i, View view) {
        an anVar = (an) this.c.d(i);
        if (anVar instanceof c) {
            ((ReaderFeature) x.a(this.a).queryFeature(ReaderFeature.class)).openBook((c) anVar);
        }
    }

    public boolean b(int i, View view) {
        new gu(this.a, (an) this.c.d(i)).show();
        return true;
    }
}
