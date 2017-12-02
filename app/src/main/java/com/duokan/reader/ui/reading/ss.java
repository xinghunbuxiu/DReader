package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;

import com.duokan.c.j;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.e;
import com.duokan.core.sys.o;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.domain.bookshelf.eg;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.ae;
import com.duokan.reader.domain.document.ah;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.ui.account.ShareEntranceController;
import com.duokan.reader.ui.general.jy;
import com.duokan.reader.ui.general.web.StorePageController;
import com.duokan.reader.ui.reading.a.ac;
import com.duokan.reader.ui.reading.a.af;
import com.duokan.reader.ui.reading.a.an;
import com.duokan.reader.ui.reading.a.aq;
import com.duokan.reader.ui.reading.a.i;
import com.duokan.reader.ui.reading.a.n;
import com.duokan.reader.ui.reading.a.q;
import com.duokan.reader.ui.reading.a.t;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import com.duokan.reader.ui.welcome.p;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

class ss implements ac, af, an, aq, i, n, q, t, acv, yn {
    final /* synthetic */ si a;
    private boolean b;

    private ss(si siVar) {
        this.a = siVar;
        this.b = false;
    }

    public void onTouchDown(View view, PointF pointF) {
        this.b = true;
    }

    public void onTouchUp(View view, PointF pointF) {
        this.b = false;
    }

    public void onTouchCancel(View view, PointF pointF) {
        this.b = false;
    }

    public void a(au auVar, Rect rect) {
        new yk(this.a.getContext(), this.a.a.G(), auVar, this).a(this.a.a.a(rect));
    }

    public void a(Pair pair, Rect rect) {
        gs gsVar = (gs) pair.first;
        ah f = gsVar.getPageDrawable().f(((Integer) pair.second).intValue());
        Drawable a = gsVar.a(((Integer) pair.second).intValue());
        if (f.e()) {
            gsVar.a(((Integer) pair.second).intValue(), new ColorDrawable(-16777216));
        }
        this.a.j.a(f, dv.b(new Rect(rect), (View) pair.first, this.a.b), new st(this, f, gsVar, pair, a));
        this.a.a.v().setScreenTimeout(Integer.MAX_VALUE);
    }

    public void a(er erVar, View view, ae aeVar) {
        if (!TextUtils.isEmpty(aeVar.b())) {
            Uri parse = Uri.parse(aeVar.b());
            String scheme = parse.getScheme();
            if (TextUtils.equals("text/html", aeVar.a()) && aeVar.b().endsWith(".zip")) {
                InputStream bufferedInputStream = new BufferedInputStream(this.a.a.getDocument().a(aeVar.b()), 8192);
                File file = new File(ReaderEnv.get().getReadingCacheDirectory(), o.b(aeVar.b(), "md5") + ".lnktar");
                e storePageController = new StorePageController(this.a.getContext());
                storePageController.setTransparent(true);
                ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).showPopup(storePageController);
                com.duokan.core.sys.ah.b(new su(this, file, bufferedInputStream, storePageController));
            } else if ("duokan-reader".equalsIgnoreCase(scheme)) {
                ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).navigate(parse.toString(), "reading_" + this.a.a.G().H(), true, null);
            } else {
                jy jyVar = new jy(this.a.getContext());
                jyVar.a(aeVar.b());
                jyVar.show();
            }
        }
        if (aeVar.c() != null) {
            this.a.a.as();
            this.a.a.a(aeVar.c());
        }
    }

    public void a() {
        this.a.requestShowMenu();
    }

    public void a(er erVar, View view, a aVar, Point point) {
        if (!this.a.a(point)) {
            new s(this.a.getActivity(), this.a.a, this).a(aVar, view);
        }
    }

    public void a(Pair pair) {
        ab e = ((gs) pair.first).getPageDrawable().e(((Integer) pair.second).intValue());
        this.a.a.aU();
        this.a.a(new sw(this)).a(dv.b(new Rect(((gs) pair.first).getPageDrawable().i(((Integer) pair.second).intValue())), (View) pair.first), e);
    }

    public void a(er erVar, View view, a aVar, Rect rect) {
        if (!this.a.a(new Point((rect.right - rect.left) / 2, (rect.bottom - rect.top) / 2))) {
            this.a.a.aU();
            new afe(this.a.getActivity(), this.a.a, new sx(this)).a(aVar, new Rect(rect.left, rect.top, rect.right, rect.bottom), (acv) this);
        }
    }

    public void a(String str) {
        ((ClipboardManager) this.a.getContext().getSystemService("clipboard")).setText(str);
        this.a.a.v().prompt(this.a.getString(j.reading__copytext__success));
    }

    public void a(bb bbVar, String str) {
        if (this.a.n != null) {
            this.a.removeSubController(this.a.n);
            this.a.deactivate(this.a.n);
        }
        this.a.n = new ShareEntranceController(this.a.getContext(), this.a.a.G(), this.a.a.T() ? DkUtils.chs2chtText(str) : str, null, new sy(this, bbVar, str));
        this.a.addSubController(this.a.n);
        this.a.activate(this.a.n);
    }

    public void a(a aVar) {
        if (this.a.n != null) {
            this.a.removeSubController(this.a.n);
            this.a.deactivate(this.a.n);
        }
        this.a.n = new ShareEntranceController(this.a.getContext(), this.a.a.G(), aVar, this.a.a.T(), new sz(this, aVar));
        this.a.addSubController(this.a.n);
        this.a.activate(this.a.n);
    }

    public void b(a aVar) {
        this.a.a.G().b(aVar);
        this.a.a.aN();
    }

    public void c(a aVar) {
        boolean z;
        String str = "";
        if (aVar instanceof ef) {
            str = ((ef) aVar).m();
        }
        this.a.a.aU();
        c G = this.a.a.G();
        Context context = this.a.getContext();
        String a = aVar.a(this.a.a.ae().P());
        if (!G.ai() || G.o() == BookType.SERIAL) {
            z = false;
        } else {
            z = true;
        }
        new k(context, a, str, z, new ta(this, aVar)).a();
    }

    public void d(a aVar) {
        if (aVar instanceof ef) {
            ((ef) aVar).a(eg.a().b());
            this.a.a.G().c(aVar);
            this.a.a.aN();
        }
    }

    public ef a(bb bbVar, String str, String str2) {
        ef efVar = (ef) a.d(null);
        efVar.b(this.a.a.G().aF());
        efVar.a(str);
        efVar.e(str2);
        efVar.a(eg.a().b());
        bb bbVar2 = (bb) this.a.a.getDocument().c((com.duokan.reader.domain.document.a) bbVar);
        efVar.a(bbVar2.g());
        efVar.b(bbVar2.h());
        this.a.a.b(efVar);
        return efVar;
    }

    public void a(av avVar, String str) {
        h h = this.a.a.getDocument().h();
        String a = h.a();
        g b = h.b((com.duokan.reader.domain.document.a) avVar);
        if (b != null) {
            a = b.e();
        }
        this.a.showPopup(new zk(this.a.getContext(), this.a.a.G(), (com.duokan.reader.domain.document.epub.c) avVar, a, str, this.a.a.T()), 17, 2);
    }

    public void a(float f) {
        if (this.a.a.E() == BrightnessMode.MANUAL) {
            ((p) this.a.getContext().queryFeature(p.class)).a(this.a.getContext(), UserInput.SEEK_READING_BRIGHTNESS_GESTURE);
            this.a.a.a(this.a.a.F() + f);
        }
    }

    public void a(c cVar, au auVar) {
        Bitmap bitmap;
        if (this.a.n != null) {
            this.a.removeSubController(this.a.n);
            this.a.deactivate(this.a.n);
        }
        String d = TextUtils.isEmpty(auVar.k().e()) ? auVar.k().d() : auVar.k().d() + "\n" + auVar.k().e();
        try {
            bitmap = (Bitmap) auVar.a(null).get();
        } catch (Throwable th) {
            bitmap = null;
        }
        if (bitmap != null) {
            this.a.n = new ShareEntranceController(this.a.getContext(), cVar, d, bitmap, null);
            this.a.addSubController(this.a.n);
            this.a.activate(this.a.n);
        }
    }
}
