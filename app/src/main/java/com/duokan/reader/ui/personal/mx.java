package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.eu;
import java.util.ArrayList;
import java.util.Arrays;

class mx implements eu {
    /* renamed from: a */
    final /* synthetic */ mv f8973a;

    mx(mv mvVar) {
        this.f8973a = mvVar;
    }

    /* renamed from: a */
    public void mo1159a(DkCloudNoteBookInfo[] dkCloudNoteBookInfoArr, boolean z) {
        if (z) {
            this.f8973a.f8970c = new ArrayList(Arrays.asList(dkCloudNoteBookInfoArr));
            if (this.f8973a.f8970c.size() > 0) {
                this.f8973a.f8971d.m8785a(false);
                return;
            }
            return;
        }
        this.f8973a.f8970c = new ArrayList(Arrays.asList(dkCloudNoteBookInfoArr));
        this.f8973a.f8971d.m8785a(false);
    }

    /* renamed from: a */
    public void mo1158a(String str) {
        this.f8973a.f8971d.m8790m();
    }
}
