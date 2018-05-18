package com.duokan.reader.ui.personal;

import com.duokan.core.sys.UThread;
import com.duokan.core.ui.BaseDialog;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.domain.micloud.bi;
import com.duokan.reader.ui.general.be;
import java.util.List;

class ep implements ej {
    /* renamed from: a */
    final /* synthetic */ BaseDialog f8514a;
    /* renamed from: b */
    final /* synthetic */ eo f8515b;

    ep(eo eoVar, BaseDialog dialog) {
        this.f8515b = eoVar;
        this.f8514a = dialog;
    }

    /* renamed from: a */
    public void mo1902a(List<bi> list, List<C1068i> list2) {
        int size = (list2 == null ? 0 : list2.size()) + (list == null ? 0 : list.size());
        this.f8515b.f8513b.setfilterMiCloudItemInfos(list);
        this.f8515b.f8513b.setSpaceQuota(it.m4692a().m4725b().m8168b());
        this.f8514a.dismiss();
        if (size > 0) {
            be.m10287a(this.f8515b.f8513b.getContext(), String.format(this.f8515b.f8513b.getContext().getString(C0258j.bookshelf__shared__delete_files_num), new Object[]{Integer.valueOf(size)}), 0).show();
            UThread.runOnThread(this.f8515b.f8512a);
            return;
        }
        be.m10287a(this.f8515b.f8513b.getContext(), this.f8515b.f8513b.getContext().getString(C0258j.general__shared__network_error), 0).show();
    }
}
