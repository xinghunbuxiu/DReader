package com.duokan.reader.ui.general;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.app.e;
import com.duokan.core.app.y;

import java.util.ArrayList;
import java.util.List;

public class SpirtMenuController extends e {
    private final dr a;
    private final ViewGroup b;
    private final ViewGroup c;
    private MenuState d;
    private Runnable e;
    private Runnable f;
    private List g;

    enum MenuState {
        TOSHOW,
        SHOW,
        TOHIDE,
        HIDE
    }

    public SpirtMenuController(y yVar) {
        this(yVar, false, true);
    }

    public SpirtMenuController(y yVar, boolean z, boolean z2) {
        super(yVar);
        this.d = MenuState.HIDE;
        this.a = a((e) this, z, z2);
        this.b = this.a.b();
        this.c = this.a.c();
        this.g = new ArrayList();
        setContentView(this.a.a());
    }

    public void a(int i, int i2, Runnable runnable) {
        View a = this.a.a(getString(i), i2, this.a.b().getChildCount() != 0);
        this.b.addView(a, this.g.size(), new LayoutParams(-1, -2));
        a.setOnClickListener(new ih(this, this.g.size(), runnable));
    }

    public void a(int i, Runnable runnable) {
        a(i, 0, runnable);
    }

    protected void onActive(boolean z) {
        requestShowMenu();
    }

    protected boolean onShowMenu() {
        if (MenuState.HIDE != this.d) {
            return super.onShowMenu();
        }
        this.a.b(new id(this), new ie(this));
        return true;
    }

    protected boolean onHideMenu() {
        if (MenuState.SHOW != this.d) {
            return super.onHideMenu();
        }
        this.a.a(new if(this), new ig(this));
        return true;
    }

    protected boolean onCheckMenuShowing() {
        return MenuState.HIDE != this.d;
    }

    protected dr a(e eVar, boolean z, boolean z2) {
        return hz.a(this, z, z2);
    }
}
