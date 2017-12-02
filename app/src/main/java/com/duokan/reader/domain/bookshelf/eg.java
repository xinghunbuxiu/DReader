package com.duokan.reader.domain.bookshelf;

import android.graphics.Color;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;

public class eg {
    private static eg c = null;
    public int[] a = new int[]{Color.rgb(237, 108, 0), Color.rgb(116, 184, 9), Color.rgb(38, 128, 211), Color.rgb(150, 65, 210)};
    private final String b = "comment_color";
    private int d = 0;
    private int[] e = new int[]{e.reading__shared__note_icon_orange, e.reading__shared__note_icon_green, e.reading__shared__note_icon_blue, e.reading__shared__note_icon_purple};

    private eg() {
        int i = 0;
        int prefInt = ReaderEnv.get().getPrefInt(PrivatePref.READING, "comment_color", this.a[0]);
        while (i < this.a.length) {
            if (prefInt == this.a[i]) {
                this.d = i;
                return;
            }
            i++;
        }
    }

    public static synchronized eg a() {
        eg egVar;
        synchronized (eg.class) {
            if (c == null) {
                c = new eg();
            }
            egVar = c;
        }
        return egVar;
    }

    public void a(int i) {
        if (i < 0 || i >= this.a.length) {
            i = 0;
        }
        this.d = i;
        c();
    }

    public int b() {
        return this.a[this.d];
    }

    public int b(int i) {
        return this.e[c(i)];
    }

    public int c(int i) {
        for (int i2 = 0; i2 < this.a.length; i2++) {
            if (i == this.a[i2]) {
                return i2;
            }
        }
        return 0;
    }

    public int d(int i) {
        for (int i2 : this.a) {
            if (i == i2) {
                return i;
            }
        }
        return this.a[0];
    }

    private void c() {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, "comment_color", this.a[this.d]);
        ReaderEnv.get().commitPrefs();
    }
}
