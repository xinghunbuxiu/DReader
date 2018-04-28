package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import java.util.List;

class ap implements as {
    /* renamed from: a */
    final /* synthetic */ List f7589a;
    /* renamed from: b */
    final /* synthetic */ List f7590b;
    /* renamed from: c */
    final /* synthetic */ ao f7591c;

    ap(ao aoVar, List list, List list2) {
        this.f7591c = aoVar;
        this.f7589a = list;
        this.f7590b = list2;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (this.f7591c.f7588b.f7582a.mHistory.size() > 0 && this.f7589a.size() > 0 && this.f7589a.size() <= this.f7591c.f7588b.f7582a.mHistory.size()) {
            this.f7591c.f7588b.f7582a.mHistory.removeAll(this.f7589a);
        }
        for (String access$3200 : this.f7590b) {
            this.f7591c.f7588b.f7582a.addHistoryToList(access$3200, false);
        }
        if (this.f7591c.f7588b.f7582a.mIsHistoryLoaded) {
            this.f7591c.f7588b.f7582a.writeHistory();
        }
        this.f7591c.f7588b.f7582a.notifyHistoryChanged();
    }
}
