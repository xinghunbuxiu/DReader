package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.sys.ag;
import com.duokan.core.ui.er;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.bookshelf.hb;
import com.duokan.reader.domain.cloud.DkCloudRedeemBenefit;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.store.DkStoreItemDetail;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;
import java.util.LinkedList;

public interface su extends hd, C0435s {
    /* renamed from: A */
    int mo1986A();

    /* renamed from: B */
    double mo1987B();

    /* renamed from: C */
    int mo1988C();

    /* renamed from: D */
    float[] mo1989D();

    /* renamed from: E */
    BrightnessMode mo1990E();

    /* renamed from: F */
    float mo1991F();

    /* renamed from: G */
    C0800c mo1992G();

    /* renamed from: J */
    boolean mo1993J();

    /* renamed from: K */
    boolean mo1994K();

    /* renamed from: L */
    int mo1995L();

    /* renamed from: M */
    DocPageLayout mo1996M();

    /* renamed from: N */
    ReadingTheme mo1997N();

    /* renamed from: O */
    int mo1998O();

    /* renamed from: P */
    int mo1999P();

    /* renamed from: Q */
    int mo2000Q();

    /* renamed from: R */
    int mo2001R();

    /* renamed from: S */
    Drawable mo2002S();

    /* renamed from: T */
    boolean mo2003T();

    /* renamed from: U */
    PageAnimationMode mo2004U();

    /* renamed from: V */
    SlideShowEffect mo2005V();

    /* renamed from: W */
    LinkedList<ah> mo2006W();

    /* renamed from: X */
    gs mo2007X();

    /* renamed from: Y */
    int mo2008Y();

    /* renamed from: Z */
    ak mo2009Z();

    /* renamed from: a */
    Rect mo2011a(Rect rect);

    @Deprecated
    /* renamed from: a */
    View mo2014a(Context context);

    /* renamed from: a */
    void mo2016a(float f);

    /* renamed from: a */
    void mo2017a(Canvas canvas, int i, int i2, int i3, int i4, int i5);

    /* renamed from: a */
    void mo2019a(View view);

    /* renamed from: a */
    void mo2020a(BrightnessMode brightnessMode);

    /* renamed from: a */
    void mo2021a(er erVar);

    /* renamed from: a */
    void mo1984a(C0896a c0896a);

    /* renamed from: a */
    void mo2022a(ak akVar, boolean z, ag<as> agVar);

    /* renamed from: a */
    void mo2023a(au auVar, Rect rect);

    /* renamed from: a */
    void mo2024a(av avVar);

    /* renamed from: a */
    void mo2025a(ay ayVar, boolean z);

    /* renamed from: a */
    void mo2027a(C0901g c0901g);

    /* renamed from: a */
    void mo2029a(PageScaleType pageScaleType);

    /* renamed from: a */
    void mo2030a(PageAnimationMode pageAnimationMode);

    /* renamed from: a */
    void mo2031a(ReadingTheme readingTheme);

    /* renamed from: a */
    void mo2032a(SlideShowEffect slideShowEffect);

    /* renamed from: a */
    void mo2033a(to toVar);

    /* renamed from: a */
    void mo2034a(Runnable runnable);

    /* renamed from: a */
    void mo2036a(String str);

    /* renamed from: a */
    void mo2037a(String str, int i);

    /* renamed from: a */
    void mo2038a(RectF[] rectFArr);

    /* renamed from: a */
    void mo2039a(gx[] gxVarArr);

    /* renamed from: a */
    boolean mo2040a(int i, int i2);

    /* renamed from: a */
    Rect[] mo2041a(ea eaVar);

    /* renamed from: a */
    er[] mo2042a(Class<?>... clsArr);

    void aA();

    void aB();

    void aC();

    void aD();

    boolean aE();

    void aF();

    void aG();

    boolean aH();

    boolean aI();

    boolean aJ();

    boolean aK();

    boolean aL();

    void aM();

    void aN();

    void aO();

    void aP();

    void aQ();

    void aR();

    void aS();

    boolean aT();

    void aU();

    void aV();

    boolean aW();

    void aX();

    void aY();

    void aZ();

    as aa();

    Rect ab();

    Rect ac();

    Rect ad();

    ReadingPrefs ae();

    void af();

    boolean ag();

    boolean ah();

    DkCloudRedeemBenefit ai();

    boolean aj();

    boolean ak();

    boolean al();

    boolean am();

    boolean an();

    boolean aq();

    boolean ar();

    void as();

    void at();

    void au();

    void av();

    boolean aw();

    boolean ax();

    gx[] ay();

    void az();

    /* renamed from: b */
    int mo2093b(C0896a c0896a);

    /* renamed from: b */
    hb mo2095b();

    /* renamed from: b */
    void mo2098b(float f);

    /* renamed from: b */
    void mo2100b(ea eaVar);

    /* renamed from: b */
    void mo2102b(to toVar);

    /* renamed from: b */
    void mo2103b(Runnable runnable);

    /* renamed from: b */
    void mo2105b(boolean z);

    /* renamed from: b */
    boolean mo2106b(int i);

    void ba();

    boolean bb();

    float bc();

    int bd();

    void be();

    void bf();

    boolean bg();

    C1455g bh();

    boolean bi();

    void bj();

    Rect bk();

    C1446a bl();

    DkStoreItemDetail bm();

    boolean bn();

    boolean bo();

    void bp();

    /* renamed from: c */
    void mo2126c(float f);

    /* renamed from: c */
    void mo2127c(int i);

    /* renamed from: c */
    void mo2128c(boolean z);

    /* renamed from: d */
    void mo2130d(int i);

    /* renamed from: d */
    void mo2132d(boolean z);

    /* renamed from: d */
    boolean mo2133d();

    /* renamed from: d */
    boolean mo2135d(ak akVar);

    /* renamed from: e */
    gs mo2136e(int i);

    /* renamed from: e */
    gx mo2137e(int i, int i2);

    /* renamed from: e */
    void mo2138e(boolean z);

    /* renamed from: e */
    boolean mo2139e(ak akVar);

    /* renamed from: f */
    void mo2140f(int i);

    /* renamed from: f */
    void mo2141f(long j);

    /* renamed from: f */
    void mo2142f(boolean z);

    /* renamed from: g */
    void mo2143g(int i);

    /* renamed from: g */
    void mo2144g(boolean z);

    /* renamed from: g */
    boolean mo2145g();

    C0903n getDocument();

    /* renamed from: h */
    void mo2154h(boolean z);

    /* renamed from: h */
    boolean mo2155h();

    /* renamed from: i */
    void mo2156i();

    /* renamed from: i */
    void mo2157i(boolean z);

    boolean i_();

    /* renamed from: j */
    void mo2159j(boolean z);

    /* renamed from: j */
    boolean mo2160j();

    /* renamed from: k */
    bb mo2161k();

    /* renamed from: k */
    void mo2162k(boolean z);

    /* renamed from: l */
    boolean mo2163l();

    boolean l_();

    /* renamed from: m */
    boolean mo2165m();

    /* renamed from: n */
    boolean mo2166n();

    /* renamed from: o */
    boolean mo2167o();

    /* renamed from: p */
    void mo2168p();

    /* renamed from: t */
    void mo2178t();

    /* renamed from: u */
    void mo2179u();

    /* renamed from: v */
    ReaderFeature mo2180v();

    /* renamed from: w */
    acd mo2181w();

    /* renamed from: x */
    boolean mo2182x();

    /* renamed from: y */
    int mo2183y();

    /* renamed from: z */
    int mo2184z();
}
