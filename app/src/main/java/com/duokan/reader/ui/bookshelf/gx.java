package com.duokan.reader.ui.bookshelf;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.core.app.y;
import com.duokan.core.ui.dv;
import com.duokan.reader.ui.general.hd;

import org.apache.http.HttpStatus;

public class gx extends hd {
    private final FrameLayout a;
    private final View b;
    private final View c;
    private Runnable d;
    private boolean e = false;
    private boolean f = false;
    private boolean g = true;

    public gx(y yVar) {
        super(yVar);
        View haVar = new ha(this, getContext());
        setContentView(haVar);
        LayoutInflater.from(getContext()).inflate(g.bookshelf__menu_down_view, haVar, true);
        this.c = findViewById(f.bookshelf__menu_down_view__content);
        this.a = (FrameLayout) findViewById(f.bookshelf__menu_down_view__menu);
        this.b = findViewById(f.bookshelf__menu_down_view__dark_bg);
        haVar.setOnClickListener(new gy(this));
    }

    public void a(View view) {
        this.a.addView(view);
    }

    public View a() {
        return this.a;
    }

    public View b() {
        return this.b;
    }

    public void a(Runnable runnable) {
        this.d = runnable;
    }

    public Runnable e() {
        return this.d;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public int f() {
        return this.c.getPaddingTop();
    }

    public void a(int i) {
        this.c.setPadding(this.c.getPaddingLeft(), i, this.c.getPaddingRight(), this.c.getPaddingBottom());
    }

    protected boolean onBack() {
        if (getPopupCount() > 0) {
            return getTopPopup().requestDetach();
        }
        if (!c()) {
            return true;
        }
        this.f = true;
        dv.a(a(), 0.0f, 0.0f, 0.0f, -1.0f, HttpStatus.SC_OK, true, new gz(this));
        dv.a(b(), 1.0f, 0.0f, (int) HttpStatus.SC_OK, true, null);
        return true;
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.d != null) {
            this.d.run();
        }
    }

    private boolean c() {
        if (!this.e || this.f) {
            return false;
        }
        return true;
    }

    public void b(boolean z) {
        this.g = z;
    }
}
