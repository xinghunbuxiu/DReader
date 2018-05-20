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
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.C0366o;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.er;
import com.duokan.kernel.DkUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.bookshelf.eb;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0911h;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.ae;
import com.duokan.reader.domain.document.ah;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.epub.C0936c;
import com.duokan.reader.ui.account.ShareEntranceController;
import com.duokan.reader.ui.general.ji;
import com.duokan.reader.ui.general.web.BookHtmlController;
import com.duokan.reader.ui.reading.p054a.C1428i;
import com.duokan.reader.ui.reading.p054a.C1433n;
import com.duokan.reader.ui.reading.p054a.C1436q;
import com.duokan.reader.ui.reading.p054a.C1439t;
import com.duokan.reader.ui.reading.p054a.ac;
import com.duokan.reader.ui.reading.p054a.af;
import com.duokan.reader.ui.reading.p054a.an;
import com.duokan.reader.ui.reading.p054a.aq;
import com.duokan.reader.ui.welcome.C1540p;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

class tf implements ac, af, an, aq, C1428i, C1433n, C1436q, C1439t, adi, za {
    /* renamed from: a */
    final /* synthetic */ sv f10968a;
    /* renamed from: b */
    private boolean f10969b;

    private tf(sv svVar) {
        this.f10968a = svVar;
        this.f10969b = false;
    }

    public void onTouchDown(View view, PointF pointF) {
        this.f10969b = true;
    }

    public void onTouchUp(View view, PointF pointF) {
        this.f10969b = false;
    }

    public void onTouchCancel(View view, PointF pointF) {
        this.f10969b = false;
    }

    /* renamed from: a */
    public void mo2496a(au auVar, Rect rect) {
        new yx(this.f10968a.getContext(), this.f10968a.f9656a.mo1992G(), auVar, this).m15226a(this.f10968a.f9656a.mo2011a(rect));
    }

    /* renamed from: a */
    public void mo2490a(Pair<gx, Integer> pair, Rect rect) {
        gx gxVar = (gx) pair.first;
        ah f = gxVar.getPageDrawable().mo1319f(((Integer) pair.second).intValue());
        Drawable a = gxVar.m14288a(((Integer) pair.second).intValue());
        if (f.mo1414e()) {
            gxVar.m14290a(((Integer) pair.second).intValue(), new ColorDrawable(-16777216));
        }
        this.f10968a.f9665j.m14639a(f, AnimUtils.m1937b(new Rect(rect), (View) pair.first, this.f10968a.f9657b), new tg(this, f, gxVar, pair, a));
        this.f10968a.f9656a.mo2180v().setScreenTimeout(Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public void mo2493a(er erVar, View view, ae aeVar) {
        if (!TextUtils.isEmpty(aeVar.mo1407b())) {
            Uri parse = Uri.parse(aeVar.mo1407b());
            String scheme = parse.getScheme();
            if (TextUtils.equals("text/html", aeVar.mo1406a()) && aeVar.mo1407b().endsWith(".zip")) {
                InputStream bufferedInputStream = new BufferedInputStream(this.f10968a.f9656a.getDocument().mo1217a(aeVar.mo1407b()), 8192);
                File file = new File(ReaderEnv.get().getReadingCacheDirectory(), C0366o.m1034b(aeVar.mo1407b(), "md5") + ".lnktar");
                ActivatedController bookHtmlController = new BookHtmlController(this.f10968a.getContext());
                bookHtmlController.setTransparent(true);
                ((ReaderFeature) this.f10968a.getContext().queryFeature(ReaderFeature.class)).showPopup(bookHtmlController);
                com.duokan.core.sys.ah.m871b(new th(this, file, bufferedInputStream, bookHtmlController));
            } else if ("duokan-reader".equalsIgnoreCase(scheme)) {
                ((ReaderFeature) this.f10968a.getContext().queryFeature(ReaderFeature.class)).navigate(parse.toString(), "reading_" + this.f10968a.f9656a.mo1992G().getId(), true, null);
            } else {
                ji jiVar = new ji(this.f10968a.getContext());
                jiVar.m10872a(aeVar.mo1407b());
                jiVar.show();
            }
        }
        if (aeVar.mo1408c() != null) {
            this.f10968a.f9656a.as();
            this.f10968a.f9656a.mo2024a(aeVar.mo1408c());
        }
    }

    /* renamed from: a */
    public void mo2487a() {
        this.f10968a.requestShowMenu();
    }

    /* renamed from: a */
    public void mo2491a(er erVar, View view, C0798a c0798a, Point point) {
        if (!this.f10968a.m13554a(point)) {
            new C1468s(this.f10968a.getActivity(), this.f10968a.f9656a, this).m14966a(c0798a, view);
        }
    }

    /* renamed from: a */
    public void mo2489a(Pair<gx, Integer> pair) {
        ab e = ((gx) pair.first).getPageDrawable().mo1315e(((Integer) pair.second).intValue());
        this.f10968a.f9656a.aU();
        this.f10968a.m13551a(new tj(this)).mo2262a(AnimUtils.m1936b(new Rect(((gx) pair.first).getPageDrawable().mo1326i(((Integer) pair.second).intValue())), (View) pair.first), e);
    }

    /* renamed from: a */
    public void mo2492a(er erVar, View view, C0798a c0798a, Rect rect) {
        if (!this.f10968a.m13554a(new Point((rect.right - rect.left) / 2, (rect.bottom - rect.top) / 2))) {
            this.f10968a.f9656a.aU();
            new age(this.f10968a.getActivity(), this.f10968a.f9656a, new tk(this)).m13673a(c0798a, new Rect(rect.left, rect.top, rect.right, rect.bottom), (adi) this);
        }
    }

    /* renamed from: a */
    public void mo2499a(String str) {
        ((ClipboardManager) this.f10968a.getContext().getSystemService("clipboard")).setText(str);
        this.f10968a.f9656a.mo2180v().prompt(this.f10968a.getString(C0258j.reading__copytext__success));
    }

    /* renamed from: a */
    public void mo2498a(bb bbVar, String str) {
        if (this.f10968a.f9669n != null) {
            this.f10968a.removeSubController(this.f10968a.f9669n);
            this.f10968a.deactivate(this.f10968a.f9669n);
        }
        this.f10968a.f9669n = new ShareEntranceController(this.f10968a.getContext(), this.f10968a.f9656a.mo1992G(), this.f10968a.f9656a.mo2003T() ? DkUtils.chs2chtText(str) : str, null, new tl(this, bbVar, str));
        this.f10968a.addSubController(this.f10968a.f9669n);
        this.f10968a.activate(this.f10968a.f9669n);
    }

    /* renamed from: a */
    public void mo2494a(C0798a c0798a) {
        if (this.f10968a.f9669n != null) {
            this.f10968a.removeSubController(this.f10968a.f9669n);
            this.f10968a.deactivate(this.f10968a.f9669n);
        }
        this.f10968a.f9669n = new ShareEntranceController(this.f10968a.getContext(), this.f10968a.f9656a.mo1992G(), c0798a, this.f10968a.f9656a.mo2003T(), new tm(this, c0798a));
        this.f10968a.addSubController(this.f10968a.f9669n);
        this.f10968a.activate(this.f10968a.f9669n);
    }

    /* renamed from: b */
    public void mo2500b(C0798a c0798a) {
        this.f10968a.f9656a.mo1992G().m4209b(c0798a);
        this.f10968a.f9656a.aN();
    }

    /* renamed from: c */
    public void mo2501c(C0798a c0798a) {
        boolean z;
        String str = "";
        if (c0798a instanceof ea) {
            str = ((ea) c0798a).m4384m();
        }
        this.f10968a.f9656a.aU();
        C0800c G = this.f10968a.f9656a.mo1992G();
        Context context = this.f10968a.getContext();
        String a = c0798a.m3715a(this.f10968a.f9656a.ae().m12455P());
        if (!G.ak() || G.m4242o() == BookType.SERIAL) {
            z = false;
        } else {
            z = true;
        }
        new C1460k(context, a, str, z, new tn(this, c0798a)).m14530a();
    }

    /* renamed from: d */
    public void mo2502d(C0798a c0798a) {
        if (c0798a instanceof ea) {
            ((ea) c0798a).m4379a(eb.m4386a().m4389b());
            this.f10968a.f9656a.mo1992G().m4216c(c0798a);
            this.f10968a.f9656a.aN();
        }
    }

    /* renamed from: a */
    public ea mo2486a(bb bbVar, String str, String str2) {
        ea eaVar = (ea) C0798a.m3713d(null);
        eaVar.m3721b(this.f10968a.f9656a.mo1992G().aH());
        eaVar.m3719a(str);
        eaVar.m4380e(str2);
        eaVar.m4379a(eb.m4386a().m4389b());
        bb bbVar2 = (bb) this.f10968a.f9656a.getDocument().mo1229c((C0896a) bbVar);
        eaVar.m3718a(bbVar2.mo1198g());
        eaVar.m3722b(bbVar2.mo1199h());
        this.f10968a.f9656a.mo2100b(eaVar);
        return eaVar;
    }

    /* renamed from: a */
    public void mo2497a(av avVar, String str) {
        C0911h h = this.f10968a.f9656a.getDocument().mo1240h();
        String a = h.mo1264a();
        C0901g b = h.mo1267b((C0896a) avVar);
        if (b != null) {
            a = b.mo1202e();
        }
        this.f10968a.showPopup(new zx(this.f10968a.getContext(), this.f10968a.f9656a.mo1992G(), (C0936c) avVar, a, str, this.f10968a.f9656a.mo2003T()), 17, 2);
    }

    /* renamed from: a */
    public void mo2488a(float f) {
        if (this.f10968a.f9656a.mo1990E() == BrightnessMode.MANUAL) {
            ((C1540p) this.f10968a.getContext().queryFeature(C1540p.class)).mo2564a(this.f10968a.getContext(), UserInput.SEEK_READING_BRIGHTNESS_GESTURE);
            this.f10968a.f9656a.mo2016a(this.f10968a.f9656a.mo1991F() + f);
        }
    }

    /* renamed from: a */
    public void mo2495a(C0800c c0800c, au auVar) {
        Bitmap bitmap;
        if (this.f10968a.f9669n != null) {
            this.f10968a.removeSubController(this.f10968a.f9669n);
            this.f10968a.deactivate(this.f10968a.f9669n);
        }
        String d = TextUtils.isEmpty(auVar.mo1396k().mo1405e()) ? auVar.mo1396k().mo1404d() : auVar.mo1396k().mo1404d() + "\n" + auVar.mo1396k().mo1405e();
        try {
            bitmap = (Bitmap) auVar.mo1383a(null).get();
        } catch (Throwable th) {
            bitmap = null;
        }
        if (bitmap != null) {
            this.f10968a.f9669n = new ShareEntranceController(this.f10968a.getContext(), c0800c, d, bitmap, null);
            this.f10968a.addSubController(this.f10968a.f9669n);
            this.f10968a.activate(this.f10968a.f9669n);
        }
    }
}
