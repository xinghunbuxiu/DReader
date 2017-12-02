package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.fm;

import java.util.ArrayList;
import java.util.Arrays;

class mj implements fm {
    final /* synthetic */ mh a;

    mj(mh mhVar) {
        this.a = mhVar;
    }

    public void a(DkCloudNoteBookInfo[] dkCloudNoteBookInfoArr, boolean z) {
        if (z) {
            this.a.c = new ArrayList(Arrays.asList(dkCloudNoteBookInfoArr));
            if (this.a.c.size() > 0) {
                this.a.d.a(false);
                return;
            }
            return;
        }
        this.a.c = new ArrayList(Arrays.asList(dkCloudNoteBookInfoArr));
        this.a.d.a(false);
    }

    public void a(String str) {
        this.a.d.m();
    }
}
