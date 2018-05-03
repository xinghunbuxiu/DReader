package com.duokan.reader.ui.bookshelf;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.ui.general.gs;
import org.apache.http.HttpStatus;

public class he extends gs {
    /* renamed from: a */
    private final FrameLayout f6341a;
    /* renamed from: b */
    private final View f6342b;
    /* renamed from: c */
    private final View f6343c;
    /* renamed from: d */
    private Runnable f6344d;
    /* renamed from: e */
    private boolean f6345e = false;
    /* renamed from: f */
    private boolean f6346f = false;
    /* renamed from: g */
    private boolean f6347g = true;

    public he(IFeature mFeature) {
        super(mFeature);
        View hhVar = new hh(this, getContext());
        setContentView(hhVar);
        LayoutInflater.from(getContext()).inflate(C0245g.bookshelf__menu_down_view, hhVar, true);
        this.f6343c = findViewById(C0244f.bookshelf__menu_down_view__content);
        this.f6341a = (FrameLayout) findViewById(C0244f.bookshelf__menu_down_view__menu);
        this.f6342b = findViewById(C0244f.bookshelf__menu_down_view__dark_bg);
        hhVar.setOnClickListener(new hf(this));
    }

    /* renamed from: a */
    public void m9490a(View view) {
        this.f6341a.addView(view);
    }

    /* renamed from: a */
    public View m9488a() {
        return this.f6341a;
    }

    /* renamed from: b */
    public View m9493b() {
        return this.f6342b;
    }

    /* renamed from: a */
    public void m9491a(Runnable runnable) {
        this.f6344d = runnable;
    }

    /* renamed from: c */
    public Runnable m9495c() {
        return this.f6344d;
    }

    /* renamed from: a */
    public void m9492a(boolean z) {
        this.f6345e = z;
    }

    /* renamed from: d */
    public int m9496d() {
        return this.f6343c.getPaddingTop();
    }

    /* renamed from: a */
    public void m9489a(int i) {
        this.f6343c.setPadding(this.f6343c.getPaddingLeft(), i, this.f6343c.getPaddingRight(), this.f6343c.getPaddingBottom());
    }

    protected boolean onBack() {
        if (getPopupCount() > 0) {
            return getTopPopup().requestDetach();
        }
        if (!mo1721e()) {
            return true;
        }
        this.f6346f = true;
        AnimUtils.startTranslateAnimation(m9488a(), 0.0f, 0.0f, 0.0f, -1.0f, HttpStatus.SC_OK, true, new hg(this));
        AnimUtils.startAlphaAnimation(m9493b(), 1.0f, 0.0f, (int) HttpStatus.SC_OK, true, null);
        return true;
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.f6344d != null) {
            this.f6344d.run();
        }
    }

    /* renamed from: e */
    private boolean mo1721e() {
        if (!this.f6345e || this.f6346f) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public void m9494b(boolean z) {
        this.f6347g = z;
    }
}
