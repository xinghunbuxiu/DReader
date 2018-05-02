package com.duokan.reader.ui.personal;

import com.duokan.core.ui.j;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.domain.cloud.ew;
import com.duokan.reader.ui.general.be;

import java.util.ArrayList;

class hk implements ew {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ ReadBook b;
    final /* synthetic */ int c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ j e;
    final /* synthetic */ hj f;

    hk(hj hjVar, ArrayList arrayList, ReadBook readBook, int i, ArrayList arrayList2, j jVar) {
        this.f = hjVar;
        this.a = arrayList;
        this.b = readBook;
        this.c = i;
        this.d = arrayList2;
        this.e = jVar;
    }

    public void a() {
    }

    public void b() {
        this.a.add(this.b);
        if (this.c == this.d.size() - 1) {
            if (this.a.size() > 0) {
                this.f.b.a.a(this.a);
            }
            this.e.dismiss();
            be.a(this.f.b.getContext(), String.format(this.f.b.getString(com.duokan.c.j.bookshelf__shared__delete_files_num), new Object[]{Integer.valueOf(this.a.size())}), 1).show();
            this.f.a.run();
        }
    }

    public void a(String str) {
        if (this.c == this.d.size() - 1) {
            if (this.a.size() > 0) {
                this.f.b.a.a(this.a);
            }
            this.e.dismiss();
            be.a(this.f.b.getContext(), String.format(this.f.b.getString(com.duokan.c.j.bookshelf__shared__delete_files_num), new Object[]{Integer.valueOf(this.a.size())}), 1).show();
            this.f.a.run();
        }
    }
}
