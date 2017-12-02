package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.duokan.core.app.e;
import com.duokan.core.app.x;
import com.duokan.core.app.y;
import com.duokan.core.sys.af;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.SystemUiMode;
import com.duokan.reader.ui.general.hd;

abstract class to extends hd implements SystemUiConditioner {
    private Runnable a = null;
    protected final ReaderFeature e = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));
    protected final sh f = ((sh) getContext().queryFeature(sh.class));
    protected final View g;
    protected boolean h = false;

    protected abstract View a();

    protected abstract void a(e eVar);

    protected abstract void b();

    protected abstract boolean l();

    public to(y yVar) {
        super(yVar);
        setContentView(a());
        getContentView().setLayoutParams(new LayoutParams(-1, -1));
        this.g = findViewById(f.reading__reading_menu_bottom_view__night_mode);
        int headerPaddingTop = ((ReaderFeature) x.a(getContext()).queryFeature(ReaderFeature.class)).getTheme().getHeaderPaddingTop();
        View findViewById = findViewById(f.reading__reading_menu_view__top);
        findViewById.setPadding(findViewById.getPaddingLeft(), headerPaddingTop, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        getContentView().setOnClickListener(new tp(this));
        findViewById(f.reading__reading_menu_view__back).setOnClickListener(new tq(this));
        findViewById(f.reading__reading_menu_bottom_view__navigation).setOnClickListener(new ts(this));
        this.g.setOnClickListener(new tu(this));
        findViewById(f.reading__reading_menu_bottom_view__more).setOnClickListener(new tv(this));
    }

    protected void onActive(boolean z) {
        c();
        this.e.updateSystemUi(true);
        super.onActive(z);
    }

    protected void onDeactive() {
        super.onDeactive();
        this.e.updateSystemUi(true);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.e.addSystemUiConditioner(this);
        this.f.aS();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.e.removeSystemUiConditioner(this);
        if (this.a != null) {
            this.a.run();
            this.a = null;
        }
    }

    protected boolean onBack() {
        if (l() || ReaderEnv.get().hasPhysicalBackKey() || this.f.an()) {
            requestDetach();
        } else {
            a(new tw(this));
        }
        return true;
    }

    public void chooseStatusBarStyle(af afVar) {
        if (isActive()) {
            afVar.a(Boolean.valueOf(false));
        }
    }

    public void chooseNavigationBarMode(af afVar) {
        if (isActive()) {
            afVar.a(SystemUiMode.VISIBLE);
        }
    }

    public void chooseNavigationBarColor(af afVar) {
        afVar.a(Integer.valueOf(-16777216));
    }

    protected void a(Runnable runnable) {
        this.a = runnable;
        requestDetach();
    }

    protected void c() {
        this.g.setSelected(this.f.aH());
    }
}
