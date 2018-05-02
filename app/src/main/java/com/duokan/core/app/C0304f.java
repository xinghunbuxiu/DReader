package com.duokan.core.app;

/* renamed from: com.duokan.core.app.f */
public class C0304f implements ISubControllerParent {
    /* renamed from: a */
    final /* synthetic */ ActivatedController f509a;

    protected C0304f(ActivatedController c0303e) {
        this.f509a = c0303e;
    }

    public boolean isStub() {
        return false;
    }

    public IFeature getContext() {
        return this.f509a.mContext;
    }

    public ISubControllerParent getParent() {
        return this.f509a.mParent;
    }

    public boolean requestShowMenu(ActivatedController c0303e) {
        if (this.f509a.mParent != null) {
            return this.f509a.mParent.requestShowMenu(this.f509a);
        }
        return this.f509a.doShowMenu();
    }

    public boolean requestHideMenu(ActivatedController c0303e) {
        if (this.f509a.mParent != null) {
            return this.f509a.mParent.requestHideMenu(this.f509a);
        }
        if (this.f509a.isMenuShowing()) {
            return this.f509a.doHideMenu();
        }
        return false;
    }

    public boolean requestDetach(ActivatedController controller) {
        return this.f509a.onRequestDetach(controller);
    }
}
