package com.duokan.core.app;

/* renamed from: com.duokan.core.app.h */
public interface ISubControllerParent {
    IFeature getContext();

    ISubControllerParent getParent();

    boolean isStub();

    boolean requestDetach(ActivatedController controller);

    boolean requestHideMenu(ActivatedController controller);

    boolean requestShowMenu(ActivatedController controller);
}
