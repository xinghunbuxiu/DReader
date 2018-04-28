package com.duokan.reader.ui.personal;

import com.duokan.core.ui.C0342j;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.domain.cloud.ef;
import com.duokan.reader.ui.general.be;
import java.util.ArrayList;

class hx implements ef {
    /* renamed from: a */
    final /* synthetic */ ArrayList f8677a;
    /* renamed from: b */
    final /* synthetic */ ReadBook f8678b;
    /* renamed from: c */
    final /* synthetic */ int f8679c;
    /* renamed from: d */
    final /* synthetic */ ArrayList f8680d;
    /* renamed from: e */
    final /* synthetic */ C0342j f8681e;
    /* renamed from: f */
    final /* synthetic */ hw f8682f;

    hx(hw hwVar, ArrayList arrayList, ReadBook readBook, int i, ArrayList arrayList2, C0342j c0342j) {
        this.f8682f = hwVar;
        this.f8677a = arrayList;
        this.f8678b = readBook;
        this.f8679c = i;
        this.f8680d = arrayList2;
        this.f8681e = c0342j;
    }

    /* renamed from: a */
    public void mo1921a() {
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f8677a.add(this.f8678b);
        if (this.f8679c == this.f8680d.size() - 1) {
            if (this.f8677a.size() > 0) {
                this.f8682f.f8676b.f8673a.m11978a(this.f8677a);
            }
            this.f8681e.dismiss();
            be.m10287a(this.f8682f.f8676b.getContext(), String.format(this.f8682f.f8676b.getString(C0258j.bookshelf__shared__delete_files_num), new Object[]{Integer.valueOf(this.f8677a.size())}), 1).show();
            this.f8682f.f8675a.run();
        }
    }

    /* renamed from: a */
    public void mo1922a(String str) {
        if (this.f8679c == this.f8680d.size() - 1) {
            if (this.f8677a.size() > 0) {
                this.f8682f.f8676b.f8673a.m11978a(this.f8677a);
            }
            this.f8681e.dismiss();
            be.m10287a(this.f8682f.f8676b.getContext(), String.format(this.f8682f.f8676b.getString(C0258j.bookshelf__shared__delete_files_num), new Object[]{Integer.valueOf(this.f8677a.size())}), 1).show();
            this.f8682f.f8675a.run();
        }
    }
}
