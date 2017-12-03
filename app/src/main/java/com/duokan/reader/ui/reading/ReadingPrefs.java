package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import com.duokan.core.app.BrightnessMode;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.UmengManager;
import com.duokan.reader.ui.general.ReaderUi;

import miuipub.date.Calendar;

class ReadingPrefs {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final float j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final Context p;
    private final int[] q;

    enum PrefKeys {
        PREFS_VERSION,
        FONT_SIZE,
        TYPESETTING_STYLE,
        SCREEN_BRIGHTNESS_MODE,
        SCREEN_BRIGHTNESS,
        SCREEN_TIMEOUT,
        SCREEN_BRIGHTNESS_MODE_IN_NIGHT,
        SCREEN_BRIGHTNESS_IN_NIGHT,
        NIGHTLY_MODE,
        EYES_SAVING_MODE,
        READING_THEME,
        CUSTOM_LINE_GAP,
        CUSTOM_PARA_SPACING,
        CUSTOM_FIRST_LINE_INDENT,
        CUSTOM_PAGE_OUTER_PADDING_HORZ,
        CUSTOM_PAGE_OUTER_PADDING_VERT,
        CUSTOM_PAGE_INNER_PADDING_HORZ_FACTOR,
        CUSTOM_PAGE_INNER_PADDING_VERT_FACTOR,
        CUSTOM_PAGE_BACKGROUND_COLOR,
        CUSTOM_PAGE_BACKGROUND_ORIGINAL_COLOR,
        CUSTOM_PAGE_BACKGROUND_SATURATION,
        CUSTOM_PAGE_TEXT_COLOR,
        CUSTOM_PAGE_TEXT_ORIGINAL_COLOR,
        CUSTOM_PAGE_TEXT_SATURATION,
        SHOW_SYSTEM_BAR,
        LONG_CLICK_TO_MARK,
        SHOW_TOP_STATUS_BAR,
        SHOW_BOTTOM_STATUS_BAR,
        READING_ORIENTATION,
        TURN_PAGE_BY_VOL_KEYS,
        LEFT_HAND_MODE,
        PAGE_ANIMATION_MODE,
        ANNOTATION_STYLE,
        SLIDE_SHOW_EFFECT,
        CHS_TO_CHT,
        READING_AUDIO_SYNC,
        TTS_SPEED,
        TTS_SPEAKER,
        AUTO_PAGE_DOWN_SPEED,
        CUSTOM_FONT_ZH,
        CUSTOM_FONT_EN,
        DK_CUSTOM_FONT_ZH,
        DK_CUSTOM_FONT_EN
    }

    protected ReadingPrefs(Context context) {
        this.p = context;
        switch (vo.a[ReaderUi.l(this.p).ordinal()]) {
            case 1:
                this.e = 1.0f;
                this.f = 3.0f;
                this.g = 0.0f;
                this.h = 3.0f;
                this.i = 0.0f;
                this.j = 4.0f;
                this.o = 44;
                this.m = 20;
                this.n = 70;
                this.a = 100;
                this.b = 70;
                this.q = new int[]{12, 14, 16, 18, 20, 21, 22, 23, 24, 25, 26, 28, 30, 32, 34, 36, 38};
                break;
            case 2:
                this.e = 1.0f;
                this.f = 3.0f;
                this.g = 0.0f;
                this.h = 3.0f;
                this.i = 0.0f;
                this.j = 4.0f;
                this.o = 54;
                this.m = 30;
                this.n = 80;
                this.a = 110;
                this.b = 74;
                this.q = new int[]{14, 16, 18, 20, 22, 23, 24, 25, 26, 27, 28, 30, 32, 34, 36, 38, 40};
                break;
            case 3:
                this.e = 1.0f;
                this.f = 2.2f;
                this.g = 0.0f;
                this.h = 2.0f;
                this.i = 0.0f;
                this.j = 4.0f;
                this.o = 20;
                this.m = 14;
                this.n = 28;
                this.a = 50;
                this.b = 38;
                this.q = new int[]{10, 12, 14, 16, 18, 19, 20, 21, 22, 23, 24, 26, 28, 30, 32, 34, 36};
                break;
            case 4:
                this.e = 1.0f;
                this.f = 2.2f;
                this.g = 0.0f;
                this.h = 2.0f;
                this.i = 0.0f;
                this.j = 4.0f;
                this.o = 24;
                this.m = 18;
                this.n = 32;
                this.a = 60;
                this.b = 38;
                this.q = new int[]{10, 12, 14, 16, 18, 19, 20, 21, 22, 23, 24, 26, 28, 30, 32, 34, 36};
                break;
            default:
                this.e = 1.0f;
                this.f = 2.2f;
                this.g = 0.0f;
                this.h = 2.0f;
                this.i = 0.0f;
                this.j = 4.0f;
                this.o = 30;
                this.m = 24;
                this.n = 38;
                this.a = 66;
                this.b = 42;
                this.q = new int[]{10, 12, 14, 16, 18, 19, 20, 21, 22, 23, 24, 26, 28, 30, 32, 34, 36};
                break;
        }
        this.d = 1;
        this.c = 1;
        this.k = 0;
        this.l = 20;
        Z();
    }

    public ReadingOrientation a() {
        try {
            return ReadingOrientation.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.READING_ORIENTATION.name(), ReadingOrientation.PORTRAIT.name()));
        } catch (Exception e) {
            e.printStackTrace();
            return ReadingOrientation.PORTRAIT;
        }
    }

    public void a(ReadingOrientation readingOrientation) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.READING_ORIENTATION.name(), readingOrientation.name());
    }

    public int b() {
        return a(this.p, 14.0f);
    }

    public int c() {
        return a(this.p, 24.0f);
    }

    public int d() {
        return a(this.p, (float) this.q[0]);
    }

    public int e() {
        return a(this.p, (float) this.q[this.q.length - 1]);
    }

    public int f() {
        return a(this.p, (float) this.q[4]);
    }

    public int g() {
        return this.k;
    }

    public int h() {
        return this.l;
    }

    public int a(int i) {
        int i2 = i;
        for (int i3 = 0; i3 < this.q.length && i2 <= i; i3++) {
            i2 = a(this.p, (float) this.q[i3]);
        }
        return i2;
    }

    public int b(int i) {
        int i2 = i;
        for (int length = this.q.length - 1; length >= 0 && i2 >= i; length--) {
            i2 = a(this.p, (float) this.q[length]);
        }
        return i2;
    }

    public int i() {
        return Math.max(d(), Math.min(ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.FONT_SIZE.name(), f()), e()));
    }

    public void c(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.FONT_SIZE.name(), Math.max(d(), Math.min(i, e())));
    }

    public TypesettingStyle j() {
        try {
            return TypesettingStyle.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.TYPESETTING_STYLE.name(), TypesettingStyle.NORMAL.name()));
        } catch (Exception e) {
            e.printStackTrace();
            return TypesettingStyle.NORMAL;
        }
    }

    public void a(TypesettingStyle typesettingStyle) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.TYPESETTING_STYLE.name(), typesettingStyle.name());
    }

    public BrightnessMode k() {
        try {
            return BrightnessMode.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS_MODE.name(), BrightnessMode.SYSTEM.name()));
        } catch (Exception e) {
            e.printStackTrace();
            return BrightnessMode.MANUAL;
        }
    }

    public void a(BrightnessMode brightnessMode) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS_MODE.name(), brightnessMode.name());
    }

    public float l() {
        return Math.max(0.02f, Math.min(ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS.name(), 0.6f), 1.0f));
    }

    public void a(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS.name(), Math.max(0.02f, Math.min(f, 1.0f)));
    }

    public int m() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.SCREEN_TIMEOUT.name(), 300000);
    }

    public void d(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.SCREEN_TIMEOUT.name(), i);
    }

    public BrightnessMode n() {
        try {
            return BrightnessMode.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS_MODE_IN_NIGHT.name(), BrightnessMode.SYSTEM.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return BrightnessMode.MANUAL;
        }
    }

    public void b(BrightnessMode brightnessMode) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS_MODE_IN_NIGHT.name(), brightnessMode.name());
    }

    public float o() {
        return Math.max(0.02f, Math.min(ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS_IN_NIGHT.name(), 0.1f), 1.0f));
    }

    public void b(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS_IN_NIGHT.name(), Math.max(0.02f, Math.min(f, 1.0f)));
    }

    public boolean p() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.EYES_SAVING_MODE.name(), false);
    }

    public void a(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.EYES_SAVING_MODE.name(), z);
    }

    public ReadingTheme q() {
        try {
            return ReadingTheme.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.READING_THEME.name(), ReadingTheme.THEME14.name()));
        } catch (Exception e) {
            e.printStackTrace();
            return ReadingTheme.THEME1;
        }
    }

    public boolean a(ReadingTheme readingTheme) {
        switch (vo.b[readingTheme.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    public int b(ReadingTheme readingTheme) {
        switch (vo.b[readingTheme.ordinal()]) {
            case 1:
                return this.p.getResources().getColor(c.reading__shared__theme_color13);
            case 2:
                return this.p.getResources().getColor(c.reading__shared__theme_color14);
            case 3:
                return this.p.getResources().getColor(c.reading__shared__theme_color15);
            case 4:
                return this.p.getResources().getColor(c.reading__shared__theme_color16);
            case 5:
                return this.p.getResources().getColor(c.reading__shared__theme_color17);
            case 7:
                return this.p.getResources().getColor(c.reading__shared__theme_night);
            case 8:
                return this.p.getResources().getColor(c.reading__shared__theme_color2);
            case 9:
                return this.p.getResources().getColor(c.reading__shared__theme_color3);
            case 10:
                return this.p.getResources().getColor(c.reading__shared__theme_color4);
            case 11:
                return this.p.getResources().getColor(c.reading__shared__theme_color5);
            case 12:
                return this.p.getResources().getColor(c.reading__shared__theme_color6);
            case 13:
                return this.p.getResources().getColor(c.reading__shared__theme_color7);
            case 14:
                return this.p.getResources().getColor(c.reading__shared__theme_color8);
            case 15:
                return this.p.getResources().getColor(c.reading__shared__theme_color9);
            case 16:
                return this.p.getResources().getColor(c.reading__shared__theme_color10);
            case 17:
                return this.p.getResources().getColor(c.reading__shared__theme_color11);
            case 18:
                return this.p.getResources().getColor(c.reading__shared__theme_color12);
            case 19:
                return Color.rgb(51, 51, 51);
            case 20:
                return A();
            default:
                return this.p.getResources().getColor(c.reading__shared__theme_color1);
        }
    }

    public Drawable c(ReadingTheme readingTheme) {
        Drawable drawable;
        BitmapDrawable bitmapDrawable;
        switch (vo.b[readingTheme.ordinal()]) {
            case 1:
                bitmapDrawable = (BitmapDrawable) this.p.getResources().getDrawable(e.reading__reading_themes_vine_white);
                break;
            case 2:
                return new vp(this, e.reading__reading_themes_vine_yellow1, e.reading__reading_themes_vine_yellow2, e.reading__reading_themes_vine_yellow3);
            case 3:
                bitmapDrawable = (BitmapDrawable) this.p.getResources().getDrawable(e.reading__reading_themes_vine_green);
                break;
            case 4:
                bitmapDrawable = (BitmapDrawable) this.p.getResources().getDrawable(e.reading__reading_themes_vine_grey);
                break;
            case 5:
                bitmapDrawable = (BitmapDrawable) this.p.getResources().getDrawable(e.reading__reading_themes_vine_paper);
                break;
            case 6:
                bitmapDrawable = (BitmapDrawable) this.p.getResources().getDrawable(e.reading__reading_themes_vine_dark);
                break;
            default:
                drawable = (BitmapDrawable) this.p.getResources().getDrawable(e.reading__reading_themes_vine_white);
                break;
        }
        drawable.setTileModeXY(TileMode.REPEAT, TileMode.REPEAT);
        return drawable;
    }

    public void r() {
        try {
            int i = i();
            int i2 = 0;
            while (i2 < this.q.length && a(this.p, (float) this.q[i2]) < i) {
                i2++;
            }
            UmengManager.get().onEvent("READING_FONT_SIZE_V1", ReaderUi.l(this.p).name() + "-" + i2);
        } catch (Throwable th) {
        }
    }

    public void d(ReadingTheme readingTheme) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.READING_THEME.name(), readingTheme.name());
    }

    public float s() {
        return i(Math.max(this.e, Math.min(ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_LINE_GAP.name(), 1.25f), this.f)));
    }

    public void c(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_LINE_GAP.name(), Math.max(this.e, Math.min(f, this.f)));
    }

    public float t() {
        return i(Math.max(this.g, Math.min(ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_PARA_SPACING.name(), 0.5f), this.h)));
    }

    public void d(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_PARA_SPACING.name(), Math.max(this.g, Math.min(f, this.h)));
    }

    private float i(float f) {
        return ((float) Math.round(f * 10.0f)) / 10.0f;
    }

    public float u() {
        return (float) Math.round(Math.max(this.i, Math.min(ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_FIRST_LINE_INDENT.name(), 2.0f), this.j)));
    }

    public void e(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_FIRST_LINE_INDENT.name(), Math.max(this.i, Math.min(f, this.j)));
    }

    public int v() {
        return Math.max(g(), Math.min(ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_INNER_PADDING_HORZ_FACTOR.name(), 10), h()));
    }

    public void e(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_INNER_PADDING_HORZ_FACTOR.name(), Math.max(g(), Math.min(i, h())));
    }

    public int w() {
        return (v() * UTools.f(this.p, (float) this.o)) / 10;
    }

    public int x() {
        return Math.max(g(), Math.min(ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_INNER_PADDING_VERT_FACTOR.name(), 10), h()));
    }

    public void f(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_INNER_PADDING_VERT_FACTOR.name(), Math.max(g(), Math.min(i, h())));
    }

    public int y() {
        return (x() * UTools.g(this.p, (float) this.a)) / 10;
    }

    public int z() {
        return (x() * UTools.g(this.p, (float) this.b)) / 10;
    }

    public int A() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_BACKGROUND_COLOR.name(), -1);
    }

    public void g(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_BACKGROUND_COLOR.name(), i);
    }

    public int B() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_BACKGROUND_ORIGINAL_COLOR.name(), -1);
    }

    public void h(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_BACKGROUND_ORIGINAL_COLOR.name(), i);
    }

    public float C() {
        return ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_BACKGROUND_SATURATION.name(), 0.5f);
    }

    public void f(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_BACKGROUND_SATURATION.name(), f);
    }

    public int D() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_TEXT_COLOR.name(), -16777216);
    }

    public void i(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_TEXT_COLOR.name(), i);
    }

    public int E() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_TEXT_ORIGINAL_COLOR.name(), -16777216);
    }

    public void j(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_TEXT_ORIGINAL_COLOR.name(), i);
    }

    public float F() {
        return ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_TEXT_SATURATION.name(), 0.5f);
    }

    public void g(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_TEXT_SATURATION.name(), f);
    }

    public boolean G() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.SHOW_SYSTEM_BAR.name(), false);
    }

    public void b(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.SHOW_SYSTEM_BAR.name(), z);
    }

    public void c(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.LONG_CLICK_TO_MARK.name(), z);
    }

    public boolean H() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.LONG_CLICK_TO_MARK.name(), false);
    }

    public boolean I() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.SHOW_TOP_STATUS_BAR.name(), true);
    }

    public void d(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.SHOW_TOP_STATUS_BAR.name(), z);
    }

    public boolean J() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.SHOW_BOTTOM_STATUS_BAR.name(), true);
    }

    public void e(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.SHOW_BOTTOM_STATUS_BAR.name(), z);
    }

    public boolean K() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.TURN_PAGE_BY_VOL_KEYS.name(), true);
    }

    public void f(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.TURN_PAGE_BY_VOL_KEYS.name(), z);
    }

    public boolean L() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.LEFT_HAND_MODE.name(), false);
    }

    public void g(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.LEFT_HAND_MODE.name(), z);
    }

    public PageAnimationMode M() {
        CharSequence prefString = ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.PAGE_ANIMATION_MODE.name(), PageAnimationMode.OVERLAP.name());
        try {
            return PageAnimationMode.valueOf(prefString);
        } catch (Throwable th) {
            if (TextUtils.equals(prefString, "NONE")) {
                return PageAnimationMode.NONE;
            }
            if (TextUtils.equals(prefString, "SLIDE_OUT")) {
                return PageAnimationMode.OVERLAP;
            }
            if (TextUtils.equals(prefString, "FADE_OUT")) {
                return PageAnimationMode.FADE_IN;
            }
            if (TextUtils.equals(prefString, "TRANSLATION")) {
                return PageAnimationMode.HSCROLL;
            }
            if (TextUtils.equals(prefString, "SIMULATION")) {
                return PageAnimationMode.THREE_DIMEN;
            }
            return PageAnimationMode.OVERLAP;
        }
    }

    public void a(PageAnimationMode pageAnimationMode) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.PAGE_ANIMATION_MODE.name(), pageAnimationMode.name());
    }

    public AnnotationStyle N() {
        return AnnotationStyle.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.ANNOTATION_STYLE.name(), AnnotationStyle.PAPERTAPE.name()));
    }

    public void a(AnnotationStyle annotationStyle) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.ANNOTATION_STYLE.name(), annotationStyle.name());
    }

    public SlideShowEffect O() {
        try {
            return SlideShowEffect.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.SLIDE_SHOW_EFFECT.name(), SlideShowEffect.SIMPLE.name()));
        } catch (Exception e) {
            e.printStackTrace();
            return SlideShowEffect.SIMPLE;
        }
    }

    public void a(SlideShowEffect slideShowEffect) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.SLIDE_SHOW_EFFECT.name(), slideShowEffect.name());
    }

    public boolean P() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.CHS_TO_CHT.name(), false);
    }

    public void h(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.CHS_TO_CHT.name(), z);
    }

    public boolean Q() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.READING_AUDIO_SYNC.name(), true);
    }

    public void i(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.READING_AUDIO_SYNC.name(), z);
    }

    public float R() {
        return ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.TTS_SPEED.name(), 1.25f);
    }

    public void h(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.TTS_SPEED.name(), f);
    }

    public String S() {
        return ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.TTS_SPEAKER.name(), "");
    }

    public void a(String str) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.TTS_SPEAKER.name(), str);
    }

    public int T() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.AUTO_PAGE_DOWN_SPEED.name(), Calendar.MILLISECOND_OF_SECOND);
    }

    public void k(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.AUTO_PAGE_DOWN_SPEED.name(), i);
    }

    public String U() {
        return ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.CUSTOM_FONT_ZH.name(), "FONT_URI_DEFAULT");
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.CUSTOM_FONT_ZH.name(), str);
        }
    }

    public String V() {
        return ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.CUSTOM_FONT_EN.name(), "FONT_URI_DEFAULT");
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.CUSTOM_FONT_EN.name(), str);
        }
    }

    public String W() {
        return ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.DK_CUSTOM_FONT_ZH.name(), "FONT_URI_DEFAULT");
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.DK_CUSTOM_FONT_ZH.name(), str);
        }
    }

    public String X() {
        return ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.DK_CUSTOM_FONT_EN.name(), "FONT_URI_DEFAULT");
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.DK_CUSTOM_FONT_EN.name(), str);
        }
    }

    public void Y() {
        ReaderEnv.get().commitPrefs();
    }

    private void Z() {
        int prefInt = ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.PREFS_VERSION.name(), 0);
        if (prefInt < 6) {
            ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.PREFS_VERSION.name(), 6);
            Y();
            if (prefInt >= 1) {
                if (prefInt < 5) {
                    if (q() == ReadingTheme.THEME5) {
                        d(ReadingTheme.THEME1);
                    }
                    Y();
                }
                if (prefInt < 6) {
                    if (q() == ReadingTheme.THEME11) {
                        d(ReadingTheme.THEME10);
                    }
                    Y();
                }
            } else if (ReaderEnv.get().getLastVersionCode() != 0) {
                Y();
            }
        }
    }

    private int a(Context context, float f) {
        return (UTools.getScaledPagingTouchSlop(context, f) / 2) * 2;
    }
}
