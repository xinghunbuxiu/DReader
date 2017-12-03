package com.duokan.core.app;

public interface IController {
    IFeature getContext();

    IController getParent();

    boolean isStub();

    boolean requestDetach(ActivatedController activatedControllerVar);

    boolean requestHideMenu(ActivatedController activatedControllerVar);

    boolean requestShowMenu(ActivatedController activatedControllerVar);
}
