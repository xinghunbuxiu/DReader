package com.duokan.reader.ui.personal;

import com.duokan.core.sys.t;
import com.duokan.core.ui.j;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.ui.general.be;

import java.util.List;

class ev implements ep {
    final /* synthetic */ j a;
    final /* synthetic */ eu b;

    ev(eu euVar, j jVar) {
        this.b = euVar;
        this.a = jVar;
    }

    public void a(List list, List list2) {
        int size = (list2 == null ? 0 : list2.size()) + (list == null ? 0 : list.size());
        this.b.b.setfilterMiCloudItemInfos(list);
        this.b.b.setSpaceQuota(iz.a().b().b());
        this.a.dismiss();
        if (size > 0) {
            be.a(this.b.b.getContext(), String.format(this.b.b.getContext().getString(com.duokan.c.j.bookshelf__shared__delete_files_num), new Object[]{Integer.valueOf(size)}), 0).show();
            t.a(this.b.a);
            return;
        }
        be.a(this.b.b.getContext(), this.b.b.getContext().getString(com.duokan.c.j.general__shared__network_error), 0).show();
    }
}
