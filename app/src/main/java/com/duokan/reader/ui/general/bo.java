package com.duokan.reader.ui.general;

import com.duokan.core.ui.aj;
import com.duokan.reader.ui.general.DkWebListView.ListState;

public abstract class bo extends aj {
    private ListState a = ListState.UNKNOWN;

    protected abstract void b();

    protected abstract void e(int i);

    public final ListState l() {
        return this.a;
    }

    public final void m() {
        this.a = c() > 0 ? ListState.LOADING_COMPLETE : ListState.ERROR;
        super.d();
    }

    public final void a(boolean z) {
        if (c() > 0) {
            this.a = z ? ListState.MORE_TO_LOAD : ListState.LOADING_COMPLETE;
        } else {
            this.a = ListState.EMPTY;
        }
        super.d();
    }

    private final void b(boolean z) {
        if (!g()) {
            if (!z) {
                this.a = ListState.LOADING_UPDATES;
                if (e()) {
                    return;
                }
            }
            b();
            this.a = ListState.FIRST_LOADING;
            e(50);
            super.d();
        }
    }

    private final void c(int i) {
        this.a = ListState.LOADING_MORE;
        e(i);
    }

    private final boolean g() {
        return this.a == ListState.FIRST_LOADING || this.a == ListState.LOADING_MORE || this.a == ListState.LOADING_UPDATES;
    }

    protected boolean e() {
        return false;
    }
}
