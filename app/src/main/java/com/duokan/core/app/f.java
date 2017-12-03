package com.duokan.core.app;

public class f implements IController {
    final /* synthetic */ ActivatedController a;

    protected f(ActivatedController activatedControllerVar) {
        this.a = activatedControllerVar;
    }

    public boolean isStub() {
        return false;
    }

    public IFeature getContext() {
        return this.a.mContext;
    }

    public IController getParent() {
        return this.a.mParent;
    }

    public boolean requestShowMenu(ActivatedController activatedControllerVar) {
        if (this.a.mParent != null) {
            return this.a.mParent.requestShowMenu(this.a);
        }
        return this.a.doShowMenu();
    }

    public boolean requestHideMenu(ActivatedController activatedControllerVar) {
        if (this.a.mParent != null) {
            return this.a.mParent.requestHideMenu(this.a);
        }
        if (this.a.isMenuShowing()) {
            return this.a.doHideMenu();
        }
        return false;
    }

    public boolean requestDetach(ActivatedController activatedControllerVar) {
        return this.a.onRequestDetach(activatedControllerVar);
    }
}
