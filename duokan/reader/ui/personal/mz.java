package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.core.sys.ah;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.ho;
import com.duokan.reader.ui.general.expandable.a;

import java.util.ArrayList;
import java.util.List;

public class mz extends fj {
    private boolean a = false;
    private boolean f = false;
    private List g = new ArrayList();
    private List h = new ArrayList();

    public /* synthetic */ Object a(int i) {
        return c(i);
    }

    public mz(Context context, a aVar, ke keVar, ho hoVar, fk fkVar) {
        super(context, aVar, keVar, hoVar, fkVar);
    }

    public int a() {
        return b() > 0 ? 1 : 0;
    }

    public int b() {
        return this.h.size();
    }

    public DkCloudStoreBook c(int i) {
        return (DkCloudStoreBook) this.h.get(i);
    }

    public int b(int i) {
        return this.h.size();
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        View a = this.d.a(c(i), view, viewGroup, this.c, c(), i);
        a.setOnClickListener(new na(this, i));
        a.setOnLongClickListener(new nb(this, i));
        return a;
    }

    public View b(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public void a(List list, List list2, List list3, Runnable runnable) {
        ah.future(new nc(this, list, list3, list2, runnable));
    }

    private int c() {
        if (this.f && this.a) {
            return 2;
        }
        if (this.f || this.a) {
            return 1;
        }
        return 0;
    }
}
