package com.duokan.reader.domain.bookshelf;

import android.graphics.Color;
import com.duokan.p023b.C0243e;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;

public class eb {
    /* renamed from: c */
    private static eb f3077c = null;
    /* renamed from: a */
    public int[] f3078a = new int[]{Color.rgb(237, 108, 0), Color.rgb(116, 184, 9), Color.rgb(38, 128, 211), Color.rgb(150, 65, 210)};
    /* renamed from: b */
    private final String f3079b = "comment_color";
    /* renamed from: d */
    private int f3080d = 0;
    /* renamed from: e */
    private int[] f3081e = new int[]{C0243e.reading__shared__note_icon_orange, C0243e.reading__shared__note_icon_green, C0243e.reading__shared__note_icon_blue, C0243e.reading__shared__note_icon_purple};

    private eb() {
        int i = 0;
        int prefInt = ReaderEnv.get().getPrefInt(PrivatePref.READING, "comment_color", this.f3078a[0]);
        while (i < this.f3078a.length) {
            if (prefInt == this.f3078a[i]) {
                this.f3080d = i;
                return;
            }
            i++;
        }
    }

    /* renamed from: a */
    public static synchronized eb m4386a() {
        eb ebVar;
        synchronized (eb.class) {
            if (f3077c == null) {
                f3077c = new eb();
            }
            ebVar = f3077c;
        }
        return ebVar;
    }

    /* renamed from: a */
    public void m4388a(int i) {
        if (i < 0 || i >= this.f3078a.length) {
            i = 0;
        }
        this.f3080d = i;
        m4387c();
    }

    /* renamed from: b */
    public int m4389b() {
        return this.f3078a[this.f3080d];
    }

    /* renamed from: b */
    public int m4390b(int i) {
        return this.f3081e[m4391c(i)];
    }

    /* renamed from: c */
    public int m4391c(int i) {
        for (int i2 = 0; i2 < this.f3078a.length; i2++) {
            if (i == this.f3078a[i2]) {
                return i2;
            }
        }
        return 0;
    }

    /* renamed from: d */
    public int m4392d(int i) {
        for (int i2 : this.f3078a) {
            if (i == i2) {
                return i;
            }
        }
        return this.f3078a[0];
    }

    /* renamed from: c */
    private void m4387c() {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, "comment_color", this.f3078a[this.f3080d]);
        ReaderEnv.get().commitPrefs();
    }
}
