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
    
    int mo1986A();

    
    double mo1987B();

    
    int mo1988C();

    
    float[] mo1989D();

    
    BrightnessMode mo1990E();

    
    float mo1991F();

    
    C0800c mo1992G();

    
    boolean mo1993J();

    
    boolean mo1994K();

    
    int mo1995L();

    
    DocPageLayout mo1996M();

    
    ReadingTheme mo1997N();

    
    int mo1998O();

    
    int mo1999P();

    
    int mo2000Q();

    
    int mo2001R();

    
    Drawable mo2002S();

    
    boolean mo2003T();

    
    PageAnimationMode mo2004U();

    
    SlideShowEffect mo2005V();

    
    LinkedList<ah> mo2006W();

    
    gs mo2007X();

    
    int mo2008Y();

    
    ak mo2009Z();

    
    Rect mo2011a(Rect rect);

    @Deprecated
    
    View mo2014a(Context context);

    
    void mo2016a(float f);

    
    void mo2017a(Canvas canvas, int i, int i2, int i3, int i4, int i5);

    
    void mo2019a(View view);

    
    void mo2020a(BrightnessMode brightnessMode);

    
    void mo2021a(er erVar);

    
    void mo1984a(C0896a c0896a);

    
    void mo2022a(ak akVar, boolean z, ag<as> agVar);

    
    void mo2023a(au auVar, Rect rect);

    
    void mo2024a(av avVar);

    
    void mo2025a(ay ayVar, boolean z);

    
    void mo2027a(C0901g c0901g);

    
    void mo2029a(PageScaleType pageScaleType);

    
    void mo2030a(PageAnimationMode pageAnimationMode);

    
    void mo2031a(ReadingTheme readingTheme);

    
    void mo2032a(SlideShowEffect slideShowEffect);

    
    void mo2033a(to toVar);

    
    void mo2034a(Runnable runnable);

    
    void mo2036a(String str);

    
    void mo2037a(String str, int i);

    
    void mo2038a(RectF[] rectFArr);

    
    void mo2039a(gx[] gxVarArr);

    
    boolean mo2040a(int i, int i2);

    
    Rect[] mo2041a(ea eaVar);

    
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

    
    int mo2093b(C0896a c0896a);

    
    hb mo2095b();

    
    void mo2098b(float f);

    
    void mo2100b(ea eaVar);

    
    void mo2102b(to toVar);

    
    void mo2103b(Runnable runnable);

    
    void mo2105b(boolean z);

    
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

    
    void mo2126c(float f);

    
    void mo2127c(int i);

    
    void mo2128c(boolean z);

    
    void mo2130d(int i);

    
    void mo2132d(boolean z);

    
    boolean mo2133d();

    
    boolean mo2135d(ak akVar);

    
    gs mo2136e(int i);

    
    gx mo2137e(int i, int i2);

    
    void mo2138e(boolean z);

    
    boolean mo2139e(ak akVar);

    
    void mo2140f(int i);

    
    void mo2141f(long j);

    
    void mo2142f(boolean z);

    
    void mo2143g(int i);

    
    void mo2144g(boolean z);

    
    boolean mo2145g();

    C0903n getDocument();

    
    void mo2154h(boolean z);

    
    boolean mo2155h();

    
    void mo2156i();

    
    void mo2157i(boolean z);

    boolean i_();

    
    void mo2159j(boolean z);

    
    boolean mo2160j();

    
    bb mo2161k();

    
    void mo2162k(boolean z);

    
    boolean mo2163l();

    boolean l_();

    
    boolean mo2165m();

    
    boolean mo2166n();

    
    boolean mo2167o();

    
    void mo2168p();

    
    void mo2178t();

    
    void mo2179u();

    
    ReaderFeature mo2180v();

    
    acd mo2181w();

    
    boolean mo2182x();

    
    int mo2183y();

    
    int mo2184z();
}
