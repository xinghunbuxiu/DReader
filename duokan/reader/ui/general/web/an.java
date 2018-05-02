package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import java.util.List;

class an implements as {
    final /* synthetic */ List a;
    final /* synthetic */ List b;
    final /* synthetic */ am c;

    an(am amVar, List list, List list2) {
        this.c = amVar;
        this.a = list;
        this.b = list2;
    }

    public void a() {
        if (this.c.b.a.mHistory.size() > 0 && this.a.size() > 0 && this.a.size() <= this.c.b.a.mHistory.size()) {
            this.c.b.a.mHistory.removeAll(this.a);
        }
        for (String access$3000 : this.b) {
            this.c.b.a.addHistoryToList(access$3000, false);
        }
        if (this.c.b.a.mIsHistoryLoaded) {
            this.c.b.a.writeHistory();
        }
        this.c.b.a.notifyHistoryChanged();
    }
}
