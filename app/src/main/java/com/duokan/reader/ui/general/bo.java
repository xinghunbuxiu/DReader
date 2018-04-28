package com.duokan.reader.ui.general;

import com.duokan.core.ui.aj;
import com.duokan.reader.ui.general.DkWebListView.ListState;

public abstract class bo extends aj {
    /* renamed from: a */
    private ListState f5732a = ListState.UNKNOWN;

    /* renamed from: b */
    protected abstract void mo1555b();

    /* renamed from: e */
    protected abstract void mo1557e(int i);

    /* renamed from: l */
    public final ListState m8789l() {
        return this.f5732a;
    }

    /* renamed from: m */
    public final void m8790m() {
        this.f5732a = mo506c() > 0 ? ListState.LOADING_COMPLETE : ListState.ERROR;
        super.mo1691d();
    }

    /* renamed from: a */
    public final void m8785a(boolean z) {
        if (mo506c() > 0) {
            this.f5732a = z ? ListState.MORE_TO_LOAD : ListState.LOADING_COMPLETE;
        } else {
            this.f5732a = ListState.EMPTY;
        }
        super.mo1691d();
    }

    /* renamed from: b */
    private final void mo1755b(boolean z) {
        if (!mo1715g()) {
            if (!z) {
                this.f5732a = ListState.LOADING_UPDATES;
                if (mo1712e()) {
                    return;
                }
            }
            mo1555b();
            this.f5732a = ListState.FIRST_LOADING;
            mo1557e(50);
            super.mo1691d();
        }
    }

    /* renamed from: c */
    private final void mo1556c(int i) {
        this.f5732a = ListState.LOADING_MORE;
        mo1557e(i);
    }

    /* renamed from: g */
    private final boolean mo1715g() {
        return this.f5732a == ListState.FIRST_LOADING || this.f5732a == ListState.LOADING_MORE || this.f5732a == ListState.LOADING_UPDATES;
    }

    /* renamed from: e */
    protected boolean mo1712e() {
        return false;
    }
}
