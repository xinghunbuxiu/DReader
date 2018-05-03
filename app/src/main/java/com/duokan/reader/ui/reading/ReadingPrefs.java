package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0243e;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.UmengManager;
import com.duokan.reader.ui.general.ReaderUi;

class ReadingPrefs {
    /* renamed from: a */
    public final int f9127a;
    /* renamed from: b */
    public final int f9128b;
    /* renamed from: c */
    public final int f9129c;
    /* renamed from: d */
    public final int f9130d;
    /* renamed from: e */
    public final float f9131e;
    /* renamed from: f */
    public final float f9132f;
    /* renamed from: g */
    public final float f9133g;
    /* renamed from: h */
    public final float f9134h;
    /* renamed from: i */
    public final float f9135i;
    /* renamed from: j */
    public final float f9136j;
    /* renamed from: k */
    private final int f9137k;
    /* renamed from: l */
    private final int f9138l;
    /* renamed from: m */
    private final int f9139m;
    /* renamed from: n */
    private final int f9140n;
    /* renamed from: o */
    private final int f9141o;
    /* renamed from: p */
    private final Context f9142p;
    /* renamed from: q */
    private final int[] f9143q;

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
        AUTO_PAGE_DOWN_SPEED,
        CUSTOM_FONT_ZH,
        CUSTOM_FONT_EN,
        DK_CUSTOM_FONT_ZH,
        DK_CUSTOM_FONT_EN
    }

    protected ReadingPrefs(Context context) {
        this.f9142p = context;
        switch (wb.f11098a[ReaderUi.m10169l(this.f9142p).ordinal()]) {
            case 1:
                this.f9131e = 1.0f;
                this.f9132f = 3.0f;
                this.f9133g = 0.0f;
                this.f9134h = 3.0f;
                this.f9135i = 0.0f;
                this.f9136j = 4.0f;
                this.f9141o = 44;
                this.f9139m = 20;
                this.f9140n = 70;
                this.f9127a = 100;
                this.f9128b = 70;
                this.f9143q = new int[]{12, 14, 16, 18, 20, 21, 22, 23, 24, 25, 26, 28, 30, 32, 34, 36, 38};
                break;
            case 2:
                this.f9131e = 1.0f;
                this.f9132f = 3.0f;
                this.f9133g = 0.0f;
                this.f9134h = 3.0f;
                this.f9135i = 0.0f;
                this.f9136j = 4.0f;
                this.f9141o = 54;
                this.f9139m = 30;
                this.f9140n = 80;
                this.f9127a = 110;
                this.f9128b = 74;
                this.f9143q = new int[]{14, 16, 18, 20, 22, 23, 24, 25, 26, 27, 28, 30, 32, 34, 36, 38, 40};
                break;
            case 3:
                this.f9131e = 1.0f;
                this.f9132f = 2.2f;
                this.f9133g = 0.0f;
                this.f9134h = 2.0f;
                this.f9135i = 0.0f;
                this.f9136j = 4.0f;
                this.f9141o = 20;
                this.f9139m = 14;
                this.f9140n = 28;
                this.f9127a = 50;
                this.f9128b = 38;
                this.f9143q = new int[]{10, 12, 14, 16, 18, 19, 20, 21, 22, 23, 24, 26, 28, 30, 32, 34, 36};
                break;
            case 4:
                this.f9131e = 1.0f;
                this.f9132f = 2.2f;
                this.f9133g = 0.0f;
                this.f9134h = 2.0f;
                this.f9135i = 0.0f;
                this.f9136j = 4.0f;
                this.f9141o = 24;
                this.f9139m = 18;
                this.f9140n = 32;
                this.f9127a = 60;
                this.f9128b = 38;
                this.f9143q = new int[]{10, 12, 14, 16, 18, 19, 20, 21, 22, 23, 24, 26, 28, 30, 32, 34, 36};
                break;
            default:
                this.f9131e = 1.0f;
                this.f9132f = 2.2f;
                this.f9133g = 0.0f;
                this.f9134h = 2.0f;
                this.f9135i = 0.0f;
                this.f9136j = 4.0f;
                this.f9141o = 30;
                this.f9139m = 24;
                this.f9140n = 38;
                this.f9127a = 66;
                this.f9128b = 42;
                this.f9143q = new int[]{10, 12, 14, 16, 18, 19, 20, 21, 22, 23, 24, 26, 28, 30, 32, 34, 36};
                break;
        }
        this.f9130d = 1;
        this.f9129c = 1;
        this.f9137k = 0;
        this.f9138l = 20;
        m12436Y();
    }

    /* renamed from: a */
    public ReadingOrientation m12465a() {
        try {
            return ReadingOrientation.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.READING_ORIENTATION.name(), ReadingOrientation.PORTRAIT.name()));
        } catch (Exception e) {
            e.printStackTrace();
            return ReadingOrientation.PORTRAIT;
        }
    }

    /* renamed from: a */
    public void m12470a(ReadingOrientation readingOrientation) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.READING_ORIENTATION.name(), readingOrientation.name());
    }

    /* renamed from: b */
    public int m12476b() {
        return m12437a(this.f9142p, 14.0f);
    }

    /* renamed from: c */
    public int m12483c() {
        return m12437a(this.f9142p, 24.0f);
    }

    /* renamed from: d */
    public int m12489d() {
        return m12437a(this.f9142p, (float) this.f9143q[0]);
    }

    /* renamed from: e */
    public int m12495e() {
        return m12437a(this.f9142p, (float) this.f9143q[this.f9143q.length - 1]);
    }

    /* renamed from: f */
    public int m12499f() {
        return m12437a(this.f9142p, (float) this.f9143q[4]);
    }

    /* renamed from: g */
    public int m12503g() {
        return this.f9137k;
    }

    /* renamed from: h */
    public int m12507h() {
        return this.f9138l;
    }

    /* renamed from: a */
    public int m12464a(int i) {
        int i2 = i;
        for (int i3 = 0; i3 < this.f9143q.length && i2 <= i; i3++) {
            i2 = m12437a(this.f9142p, (float) this.f9143q[i3]);
        }
        return i2;
    }

    /* renamed from: b */
    public int m12477b(int i) {
        int i2 = i;
        for (int length = this.f9143q.length - 1; length >= 0 && i2 >= i; length--) {
            i2 = m12437a(this.f9142p, (float) this.f9143q[length]);
        }
        return i2;
    }

    /* renamed from: i */
    public int m12511i() {
        return Math.max(m12489d(), Math.min(ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.FONT_SIZE.name(), m12499f()), m12495e()));
    }

    /* renamed from: c */
    public void m12486c(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.FONT_SIZE.name(), Math.max(m12489d(), Math.min(i, m12495e())));
    }

    /* renamed from: j */
    public TypesettingStyle m12514j() {
        try {
            return TypesettingStyle.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.TYPESETTING_STYLE.name(), TypesettingStyle.NORMAL.name()));
        } catch (Exception e) {
            e.printStackTrace();
            return TypesettingStyle.NORMAL;
        }
    }

    /* renamed from: a */
    public void m12472a(TypesettingStyle typesettingStyle) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.TYPESETTING_STYLE.name(), typesettingStyle.name());
    }

    /* renamed from: k */
    public BrightnessMode m12516k() {
        try {
            return BrightnessMode.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS_MODE.name(), BrightnessMode.SYSTEM.name()));
        } catch (Exception e) {
            e.printStackTrace();
            return BrightnessMode.MANUAL;
        }
    }

    /* renamed from: a */
    public void m12467a(BrightnessMode brightnessMode) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS_MODE.name(), brightnessMode.name());
    }

    /* renamed from: l */
    public float m12518l() {
        return Math.max(0.02f, Math.min(ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS.name(), 0.6f), 1.0f));
    }

    /* renamed from: a */
    public void m12466a(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS.name(), Math.max(0.02f, Math.min(f, 1.0f)));
    }

    /* renamed from: m */
    public int m12519m() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.SCREEN_TIMEOUT.name(), 300000);
    }

    /* renamed from: d */
    public void m12491d(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.SCREEN_TIMEOUT.name(), i);
    }

    /* renamed from: n */
    public BrightnessMode m12520n() {
        try {
            return BrightnessMode.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS_MODE_IN_NIGHT.name(), BrightnessMode.SYSTEM.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return BrightnessMode.MANUAL;
        }
    }

    /* renamed from: b */
    public void m12480b(BrightnessMode brightnessMode) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS_MODE_IN_NIGHT.name(), brightnessMode.name());
    }

    /* renamed from: o */
    public float m12521o() {
        return Math.max(0.02f, Math.min(ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS_IN_NIGHT.name(), 0.1f), 1.0f));
    }

    /* renamed from: b */
    public void m12479b(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.SCREEN_BRIGHTNESS_IN_NIGHT.name(), Math.max(0.02f, Math.min(f, 1.0f)));
    }

    /* renamed from: p */
    public boolean m12522p() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.EYES_SAVING_MODE.name(), false);
    }

    /* renamed from: a */
    public void m12474a(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.EYES_SAVING_MODE.name(), z);
    }

    /* renamed from: q */
    public ReadingTheme m12523q() {
        try {
            return ReadingTheme.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.READING_THEME.name(), ReadingTheme.THEME14.name()));
        } catch (Exception e) {
            e.printStackTrace();
            return ReadingTheme.THEME1;
        }
    }

    /* renamed from: a */
    public boolean m12475a(ReadingTheme readingTheme) {
        switch (wb.f11099b[readingTheme.ordinal()]) {
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

    /* renamed from: b */
    public int m12478b(ReadingTheme readingTheme) {
        switch (wb.f11099b[readingTheme.ordinal()]) {
            case 1:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color13);
            case 2:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color14);
            case 3:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color15);
            case 4:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color16);
            case 5:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color17);
            case 7:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_night);
            case 8:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color2);
            case 9:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color3);
            case 10:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color4);
            case 11:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color5);
            case 12:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color6);
            case 13:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color7);
            case 14:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color8);
            case 15:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color9);
            case 16:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color10);
            case 17:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color11);
            case 18:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color12);
            case 19:
                return Color.rgb(51, 51, 51);
            case 20:
                return m12440A();
            default:
                return this.f9142p.getResources().getColor(C0241c.reading__shared__theme_color1);
        }
    }

    /* renamed from: c */
    public Drawable m12484c(ReadingTheme readingTheme) {
        Drawable drawable;
        BitmapDrawable drawable2;
        switch (wb.f11099b[readingTheme.ordinal()]) {
            case 1:
                drawable2 = (BitmapDrawable) this.f9142p.getResources().getDrawable(C0243e.reading__reading_themes_vine_white);
                break;
            case 2:
                return new wc(this, C0243e.reading__reading_themes_vine_yellow1, C0243e.reading__reading_themes_vine_yellow2, C0243e.reading__reading_themes_vine_yellow3);
            case 3:
                drawable2 = (BitmapDrawable) this.f9142p.getResources().getDrawable(C0243e.reading__reading_themes_vine_green);
                break;
            case 4:
                drawable2 = (BitmapDrawable) this.f9142p.getResources().getDrawable(C0243e.reading__reading_themes_vine_grey);
                break;
            case 5:
                drawable2 = (BitmapDrawable) this.f9142p.getResources().getDrawable(C0243e.reading__reading_themes_vine_paper);
                break;
            case 6:
                drawable2 = (BitmapDrawable) this.f9142p.getResources().getDrawable(C0243e.reading__reading_themes_vine_dark);
                break;
            default:
                drawable2 = (BitmapDrawable) this.f9142p.getResources().getDrawable(C0243e.reading__reading_themes_vine_white);
                break;
        }
        drawable2.setTileModeXY(TileMode.REPEAT, TileMode.REPEAT);
        return drawable2;
    }

    /* renamed from: r */
    public void m12524r() {
        try {
            int i = m12511i();
            int i2 = 0;
            while (i2 < this.f9143q.length && m12437a(this.f9142p, (float) this.f9143q[i2]) < i) {
                i2++;
            }
            UmengManager.get().onEvent("READING_FONT_SIZE_V1", ReaderUi.m10169l(this.f9142p).name() + "-" + i2);
        } catch (Throwable th) {
        }
    }

    /* renamed from: d */
    public void m12492d(ReadingTheme readingTheme) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.READING_THEME.name(), readingTheme.name());
    }

    /* renamed from: s */
    public float m12525s() {
        return m12439i(Math.max(this.f9131e, Math.min(ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_LINE_GAP.name(), 1.25f), this.f9132f)));
    }

    /* renamed from: c */
    public void m12485c(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_LINE_GAP.name(), Math.max(this.f9131e, Math.min(f, this.f9132f)));
    }

    /* renamed from: t */
    public float m12526t() {
        return m12439i(Math.max(this.f9133g, Math.min(ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_PARA_SPACING.name(), 0.5f), this.f9134h)));
    }

    /* renamed from: d */
    public void m12490d(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_PARA_SPACING.name(), Math.max(this.f9133g, Math.min(f, this.f9134h)));
    }

    /* renamed from: i */
    private float m12439i(float f) {
        return ((float) Math.round(f * 10.0f)) / 10.0f;
    }

    /* renamed from: u */
    public float m12527u() {
        return (float) Math.round(Math.max(this.f9135i, Math.min(ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_FIRST_LINE_INDENT.name(), 2.0f), this.f9136j)));
    }

    /* renamed from: e */
    public void m12496e(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_FIRST_LINE_INDENT.name(), Math.max(this.f9135i, Math.min(f, this.f9136j)));
    }

    /* renamed from: v */
    public int m12528v() {
        return Math.max(m12503g(), Math.min(ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_INNER_PADDING_HORZ_FACTOR.name(), 10), m12507h()));
    }

    /* renamed from: e */
    public void m12497e(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_INNER_PADDING_HORZ_FACTOR.name(), Math.max(m12503g(), Math.min(i, m12507h())));
    }

    /* renamed from: w */
    public int m12529w() {
        return (m12528v() * AnimUtils.m1960f(this.f9142p, (float) this.f9141o)) / 10;
    }

    /* renamed from: x */
    public int m12530x() {
        return Math.max(m12503g(), Math.min(ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_INNER_PADDING_VERT_FACTOR.name(), 10), m12507h()));
    }

    /* renamed from: f */
    public void m12501f(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_INNER_PADDING_VERT_FACTOR.name(), Math.max(m12503g(), Math.min(i, m12507h())));
    }

    /* renamed from: y */
    public int m12531y() {
        return (m12530x() * AnimUtils.m1963g(this.f9142p, (float) this.f9127a)) / 10;
    }

    /* renamed from: z */
    public int m12532z() {
        return (m12530x() * AnimUtils.m1963g(this.f9142p, (float) this.f9128b)) / 10;
    }

    /* renamed from: A */
    public int m12440A() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_BACKGROUND_COLOR.name(), -1);
    }

    /* renamed from: g */
    public void m12505g(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_BACKGROUND_COLOR.name(), i);
    }

    /* renamed from: B */
    public int m12441B() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_BACKGROUND_ORIGINAL_COLOR.name(), -1);
    }

    /* renamed from: h */
    public void m12509h(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_BACKGROUND_ORIGINAL_COLOR.name(), i);
    }

    /* renamed from: C */
    public float m12442C() {
        return ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_BACKGROUND_SATURATION.name(), 0.5f);
    }

    /* renamed from: f */
    public void m12500f(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_BACKGROUND_SATURATION.name(), f);
    }

    /* renamed from: D */
    public int m12443D() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_TEXT_COLOR.name(), -16777216);
    }

    /* renamed from: i */
    public void m12512i(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_TEXT_COLOR.name(), i);
    }

    /* renamed from: E */
    public int m12444E() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_TEXT_ORIGINAL_COLOR.name(), -16777216);
    }

    /* renamed from: j */
    public void m12515j(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_TEXT_ORIGINAL_COLOR.name(), i);
    }

    /* renamed from: F */
    public float m12445F() {
        return ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_TEXT_SATURATION.name(), 0.5f);
    }

    /* renamed from: g */
    public void m12504g(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.CUSTOM_PAGE_TEXT_SATURATION.name(), f);
    }

    /* renamed from: G */
    public boolean m12446G() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.SHOW_SYSTEM_BAR.name(), false);
    }

    /* renamed from: b */
    public void m12482b(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.SHOW_SYSTEM_BAR.name(), z);
    }

    /* renamed from: c */
    public void m12488c(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.LONG_CLICK_TO_MARK.name(), z);
    }

    /* renamed from: H */
    public boolean m12447H() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.LONG_CLICK_TO_MARK.name(), false);
    }

    /* renamed from: I */
    public boolean m12448I() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.SHOW_TOP_STATUS_BAR.name(), true);
    }

    /* renamed from: d */
    public void m12494d(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.SHOW_TOP_STATUS_BAR.name(), z);
    }

    /* renamed from: J */
    public boolean m12449J() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.SHOW_BOTTOM_STATUS_BAR.name(), true);
    }

    /* renamed from: e */
    public void m12498e(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.SHOW_BOTTOM_STATUS_BAR.name(), z);
    }

    /* renamed from: K */
    public boolean m12450K() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.TURN_PAGE_BY_VOL_KEYS.name(), true);
    }

    /* renamed from: f */
    public void m12502f(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.TURN_PAGE_BY_VOL_KEYS.name(), z);
    }

    /* renamed from: L */
    public boolean m12451L() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.LEFT_HAND_MODE.name(), false);
    }

    /* renamed from: g */
    public void m12506g(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.LEFT_HAND_MODE.name(), z);
    }

    /* renamed from: M */
    public PageAnimationMode m12452M() {
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

    /* renamed from: a */
    public void m12469a(PageAnimationMode pageAnimationMode) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.PAGE_ANIMATION_MODE.name(), pageAnimationMode.name());
    }

    /* renamed from: N */
    public AnnotationStyle m12453N() {
        return AnnotationStyle.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.ANNOTATION_STYLE.name(), AnnotationStyle.PAPERTAPE.name()));
    }

    /* renamed from: a */
    public void m12468a(AnnotationStyle annotationStyle) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.ANNOTATION_STYLE.name(), annotationStyle.name());
    }

    /* renamed from: O */
    public SlideShowEffect m12454O() {
        try {
            return SlideShowEffect.valueOf(ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.SLIDE_SHOW_EFFECT.name(), SlideShowEffect.SIMPLE.name()));
        } catch (Exception e) {
            e.printStackTrace();
            return SlideShowEffect.SIMPLE;
        }
    }

    /* renamed from: a */
    public void m12471a(SlideShowEffect slideShowEffect) {
        ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.SLIDE_SHOW_EFFECT.name(), slideShowEffect.name());
    }

    /* renamed from: P */
    public boolean m12455P() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.CHS_TO_CHT.name(), false);
    }

    /* renamed from: h */
    public void m12510h(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.CHS_TO_CHT.name(), z);
    }

    /* renamed from: Q */
    public boolean m12456Q() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.READING, PrefKeys.READING_AUDIO_SYNC.name(), true);
    }

    /* renamed from: i */
    public void m12513i(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, PrefKeys.READING_AUDIO_SYNC.name(), z);
    }

    /* renamed from: R */
    public float m12457R() {
        return ReaderEnv.get().getPrefFloat(PrivatePref.READING, PrefKeys.TTS_SPEED.name(), 1.15f);
    }

    /* renamed from: h */
    public void m12508h(float f) {
        ReaderEnv.get().setPrefFloat(PrivatePref.READING, PrefKeys.TTS_SPEED.name(), f);
    }

    /* renamed from: S */
    public int m12458S() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.AUTO_PAGE_DOWN_SPEED.name(), 1000);
    }

    /* renamed from: k */
    public void m12517k(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.AUTO_PAGE_DOWN_SPEED.name(), i);
    }

    /* renamed from: T */
    public String m12459T() {
        return ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.CUSTOM_FONT_ZH.name(), "FONT_URI_DEFAULT");
    }

    /* renamed from: a */
    public void m12473a(String str) {
        if (!TextUtils.isEmpty(str)) {
            ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.CUSTOM_FONT_ZH.name(), str);
        }
    }

    /* renamed from: U */
    public String m12460U() {
        return ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.CUSTOM_FONT_EN.name(), "FONT_URI_DEFAULT");
    }

    /* renamed from: b */
    public void m12481b(String str) {
        if (!TextUtils.isEmpty(str)) {
            ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.CUSTOM_FONT_EN.name(), str);
        }
    }

    /* renamed from: V */
    public String m12461V() {
        return ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.DK_CUSTOM_FONT_ZH.name(), "FONT_URI_DEFAULT");
    }

    /* renamed from: c */
    public void m12487c(String str) {
        if (!TextUtils.isEmpty(str)) {
            ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.DK_CUSTOM_FONT_ZH.name(), str);
        }
    }

    /* renamed from: W */
    public String m12462W() {
        return ReaderEnv.get().getPrefString(PrivatePref.READING, PrefKeys.DK_CUSTOM_FONT_EN.name(), "FONT_URI_DEFAULT");
    }

    /* renamed from: d */
    public void m12493d(String str) {
        if (!TextUtils.isEmpty(str)) {
            ReaderEnv.get().setPrefString(PrivatePref.READING, PrefKeys.DK_CUSTOM_FONT_EN.name(), str);
        }
    }

    /* renamed from: X */
    public void m12463X() {
        ReaderEnv.get().commitPrefs();
    }

    /* renamed from: Y */
    private void m12436Y() {
        int prefInt = ReaderEnv.get().getPrefInt(PrivatePref.READING, PrefKeys.PREFS_VERSION.name(), 0);
        if (prefInt < 6) {
            ReaderEnv.get().setPrefInt(PrivatePref.READING, PrefKeys.PREFS_VERSION.name(), 6);
            m12463X();
            if (prefInt >= 1) {
                if (prefInt < 5) {
                    if (m12523q() == ReadingTheme.THEME5) {
                        m12492d(ReadingTheme.THEME1);
                    }
                    m12463X();
                }
                if (prefInt < 6) {
                    if (m12523q() == ReadingTheme.THEME11) {
                        m12492d(ReadingTheme.THEME10);
                    }
                    m12463X();
                }
            } else if (ReaderEnv.get().getLastVersionCode() != 0) {
                m12463X();
            }
        }
    }

    /* renamed from: a */
    private int m12437a(Context context, float f) {
        return (AnimUtils.spToPixels(context, f) / 2) * 2;
    }
}
