package com.duokan.core.app;

public class f implements h {
    final /* synthetic */ e a;

    protected f(e eVar) {
        this.a = eVar;
    }

    public boolean isStub() {
        return false;
    }

    public y getContext() {
        return this.a.mContext;
    }

    public h getParent() {
        return this.a.mParent;
    }

    public boolean requestShowMenu(e eVar) {
        if (this.a.mParent != null) {
            return this.a.mParent.requestShowMenu(this.a);
        }
        return this.a.doShowMenu();
    }

    public boolean requestHideMenu(e eVar) {
        if (this.a.mParent != null) {
            return this.a.mParent.requestHideMenu(this.a);
        }
        if (this.a.isMenuShowing()) {
            return this.a.doHideMenu();
        }
        return false;
    }

    public boolean requestDetach(e eVar) {
        return this.a.onRequestDetach(eVar);
    }
}
