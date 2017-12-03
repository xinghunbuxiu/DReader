package com.duokan.reader.ui;

import android.view.View;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.TaskHandler;

public abstract class p extends ActivatedController implements ActivatedController {
    private final i a = new q(this, getContext());

    public p(IFeature featrue) {
        super(featrue);
        setContentView(this.a.getContentView());
        addSubController(this.a);
        activate(this.a);
    }

    public void a(View view) {
        this.a.a(view);
    }

    public int g() {
        return this.a.i();
    }

    public void a(int i) {
        this.a.c(i);
    }

    public void h() {
        this.a.dismissAllPopups();
    }

    public boolean a(ActivatedController activatedControllerVar) {
        activate(this.a);
        return this.a.a(activatedControllerVar);
    }

    public boolean a(ActivatedController activatedControllerVar, Runnable runnable) {
        activate(this.a);
        return this.a.a(activatedControllerVar, runnable);
    }

    public boolean i() {
        return this.a.j();
    }

    public boolean j() {
        return this.a.k();
    }

    public boolean a(Runnable runnable) {
        return this.a.b(runnable);
    }

    public void c_(int i) {
    }

    public void c(int i) {
    }

    public boolean pushPage(ActivatedController activatedControllerVar) {
        activate(this.a);
        return this.a.c(activatedControllerVar);
    }

    public boolean pushPageSmoothly(ActivatedController activatedControllerVar, Runnable runnable) {
        activate(this.a);
        return this.a.c(activatedControllerVar, runnable);
    }

    public boolean b(ActivatedController activatedControllerVar) {
        activate(this.a);
        return this.a.b(activatedControllerVar);
    }

    public boolean b(ActivatedController controller, Runnable runnable) {
        activate(this.a);
        return this.a.b(controller, runnable);
    }

    public boolean showPopupSmoothly(ActivatedController controller, Runnable runnable) {
        if (!showPopup(controller)) {
            return false;
        }
        TaskHandler.PostTask(runnable);
        return true;
    }

    public boolean showPopup(ActivatedController controller) {
        activate(this.a);
        if (this.a.showPopup(controller)) {
            return true;
        }
        return false;
    }

    public boolean showPopup(ActivatedController controller, int i, int i2) {
        activate(this.a);
        if (this.a.showPopup(controller, i, i2)) {
            return true;
        }
        return false;
    }
}
