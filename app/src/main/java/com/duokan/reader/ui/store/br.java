package com.duokan.reader.ui.store;

import android.content.res.Configuration;
import android.view.View;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.ds;
import com.duokan.reader.ui.surfing.af;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class br extends ActivatedController {
    private final ds a = new bs(this, getContext());
    private final ArrayList b = new ArrayList();
    private final Set c = new HashSet();
    private final int d = UTools.closeAnimation(getContext(), 200.0f);

    public br(IFeature featrue) {
        super(featrue);
        this.a.setOnCurrentPageChangedListener(new bt(this));
        setContentView(this.a);
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    public void a(bl blVar, String str) {
        this.b.add(blVar);
        addSubController(blVar);
        this.a.a(str, blVar.getContentView());
    }

    public void a(int i, boolean z) {
        int max = Math.max(0, Math.min(i, this.b.size() - 1));
        if (this.c.contains(Integer.valueOf(max))) {
            k();
            return;
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            ActivatedController activatedControllerVar = (ActivatedController) this.b.get(i2);
            if (i2 == max) {
                activate(activatedControllerVar);
            } else if (activatedControllerVar.isActive()) {
                deactivate(activatedControllerVar);
            }
        }
        this.a.a(max, z);
    }

    public int c() {
        return this.a.getCurrentPageIndex();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            af afVar = (af) getContext().queryFeature(af.class);
            if (afVar != null) {
                afVar.a(true, "BaseActivity");
            }
        }
        i();
    }

    protected void onActivityConfigurationChanged(Configuration configuration) {
        super.onActivityConfigurationChanged(configuration);
        this.a.a();
    }

    public void d() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            removeSubController((ActivatedController) it.next());
        }
        this.b.clear();
        this.a.d();
        i();
    }

    public View e() {
        return this.a.getStatusView();
    }

    public View f() {
        return this.a.getTabView();
    }

    public void a(int i) {
        int top = f().getTop();
        if (top != i) {
            f().offsetTopAndBottom(i - top);
        } else {
            f().invalidate();
        }
    }

    public int g() {
        return f().getTop();
    }

    public int h() {
        return this.d;
    }

    public void a(List list) {
        for (Integer intValue : list) {
            this.a.b(intValue.intValue());
        }
        this.c.addAll(list);
        if (list.contains(Integer.valueOf(c()))) {
            k();
        } else {
            a(c(), true);
        }
    }

    public void b(List list) {
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            this.a.c(intValue2);
            this.c.remove(Integer.valueOf(intValue2));
        }
        a(c(), true);
    }

    private void k() {
        int i = 0;
        while (i < this.b.size()) {
            if (this.c.contains(Integer.valueOf(i))) {
                i++;
            } else {
                a(i, true);
                return;
            }
        }
    }

    public void i() {
        UTools.addAnimation(this.a, new bu(this));
    }

    public bl j() {
        int c = c();
        if (c < 0) {
            c = 0;
        }
        if (this.b.size() == 0) {
            return null;
        }
        return (bl) this.b.get(c);
    }
}
