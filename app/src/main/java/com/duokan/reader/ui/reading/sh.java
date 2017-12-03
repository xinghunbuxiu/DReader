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
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.domain.bookshelf.hh;
import com.duokan.reader.domain.cloud.DkCloudRedeemBenefit;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.store.DkStoreItemDetail;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;
import com.duokan.reader.ui.s;

import java.util.LinkedList;

public interface sh extends gy, s {
    int A();

    double B();

    int C();

    float[] D();

    BrightnessMode E();

    float F();

    c G();

    boolean J();

    boolean K();

    int L();

    DocPageLayout M();

    ReadingTheme N();

    int O();

    int P();

    int Q();

    int R();

    Drawable S();

    boolean T();

    PageAnimationMode U();

    SlideShowEffect V();

    LinkedList W();

    gn X();

    int Y();

    ak Z();

    Rect a(Rect rect);

    @Deprecated
    View a(Context context);

    void a(float f);

    void a(Canvas canvas, int i, int i2, int i3, int i4, int i5);

    void a(View view);

    void a(BrightnessMode brightnessMode);

    void a(er erVar);

    void a(Document_a aVar);

    void a(ak akVar, boolean z, ag agVar);

    void a(au auVar, Rect rect);

    void a(av avVar);

    void a(ay ayVar, boolean z);

    void a(g gVar);

    void a(PageScaleType pageScaleType);

    void a(PageAnimationMode pageAnimationMode);

    void a(ReadingTheme readingTheme);

    void a(SlideShowEffect slideShowEffect);

    void a(tb tbVar);

    void a(Runnable runnable);

    void a(String str);

    void a(String str, int i);

    void a(RectF[] rectFArr);

    void a(gs[] gsVarArr);

    boolean a(int i, int i2);

    Rect[] a(ef efVar);

    er[] a(Class... clsArr);

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

    gs[] ay();

    void az();

    int b(Document_a aVar);

    hh b();

    void b(float f);

    void b(ef efVar);

    void b(tb tbVar);

    void b(Runnable runnable);

    void b(boolean z);

    boolean b(int i);

    void ba();

    boolean bb();

    float bc();

    int bd();

    String be();

    boolean bf();

    g bg();

    boolean bh();

    void bi();

    Rect bj();

    a bk();

    DkStoreItemDetail bl();

    boolean bm();

    boolean bn();

    void c(float f);

    void c(int i);

    void c(Runnable runnable);

    void c(String str);

    void c(boolean z);

    void d(int i);

    void d(boolean z);

    boolean d();

    boolean d(ak akVar);

    gn e(int i);

    gs e(int i, int i2);

    void e(boolean z);

    boolean e(ak akVar);

    void f(int i);

    void f(long j);

    void f(boolean z);

    boolean f();

    void g(int i);

    void g(boolean z);

    boolean g();

    n getDocument();

    void h(boolean z);

    boolean h();

    boolean h_();

    void i();

    void i(boolean z);

    void j(boolean z);

    boolean j();

    bb k();

    void k(boolean z);

    boolean k_();

    boolean l();

    boolean m();

    boolean n();

    boolean o();

    void p();

    void t();

    void u();

    ReaderFeature v();

    abq w();

    boolean x();

    int y();

    int z();
}
