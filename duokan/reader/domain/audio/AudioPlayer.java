package com.duokan.reader.domain.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.os.Binder;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.b;
import com.duokan.reader.domain.document.bb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class AudioPlayer extends Binder implements ah {
    private static final ai i = new ai();
    private final AudioManager a;
    private MediaPlayer b = null;
    private String c;
    private final String d;
    private b e;
    private b f;
    private int g = -1;
    private Map h;
    private PlayerStatus j = PlayerStatus.IDLE;
    private LinkedList k;
    private final OnAudioFocusChangeListener l = new a(this);
    private f m;
    private long n = -1;

    public enum PlayerStatus {
        IDLE,
        PREPARING,
        PLAYING,
        PAUSE
    }

    public AudioPlayer(Context context) {
        this.a = (AudioManager) context.getSystemService("audio");
        this.c = "";
        this.m = new f(this);
        this.h = new HashMap();
        this.k = new LinkedList();
        this.d = "http://127.0.0.1:9090/";
    }

    public static void a(Context context) {
        i.a(new AudioPlayer(context));
    }

    public static AudioPlayer a() {
        return (AudioPlayer) i.a();
    }

    public void a(b[] bVarArr, Integer num, long j) {
        if (bVarArr != null && bVarArr.length > 0) {
            if (this.n != j) {
                this.h.clear();
                this.n = j;
            }
            if (!this.h.containsKey(num)) {
                g.c().a(bVarArr, j);
                this.h.put(num, bVarArr);
            }
        }
    }

    public void a(e eVar) {
        synchronized (this) {
            this.k.add(eVar);
        }
    }

    public void b(e eVar) {
        synchronized (this) {
            Iterator it = this.k.iterator();
            while (it.hasNext()) {
                if (((e) it.next()) == eVar) {
                    this.k.remove(eVar);
                    break;
                }
            }
        }
    }

    public void a(ay ayVar, Integer[] numArr) {
        if (numArr != null && ayVar != null && !ayVar.f()) {
            b bVar;
            int i;
            int length = numArr.length;
            int i2 = 0;
            b bVar2 = null;
            int i3 = -1;
            while (i2 < length) {
                Integer num = numArr[i2];
                b[] bVarArr = (b[]) this.h.get(num);
                if (bVarArr == null) {
                    bVar = bVar2;
                    i = i3;
                } else if (bVarArr.length == 0) {
                    bVar = bVar2;
                    i = i3;
                } else {
                    for (int i4 = 0; i4 < bVarArr.length; i4++) {
                        if (bVarArr[i4].a().b(ayVar)) {
                            bVar = bVarArr[i4];
                            i = num.intValue();
                            break;
                        }
                    }
                    bVar = bVar2;
                    i = i3;
                    if (bVar != null) {
                        break;
                    }
                }
                i2++;
                i3 = i;
                bVar2 = bVar;
            }
            bVar = bVar2;
            i = i3;
            if (bVar == null) {
                if (this.b != null) {
                    this.b.stop();
                }
                this.e = null;
                this.c = "";
                this.f = null;
                this.g = -1;
                a(PlayerStatus.IDLE);
            } else if (this.a.requestAudioFocus(this.l, 3, 1) == 1) {
                a(bVar);
                this.g = i;
            }
        }
    }

    public boolean b() {
        return this.j == PlayerStatus.PREPARING || this.j == PlayerStatus.PLAYING;
    }

    public void c() {
        this.a.abandonAudioFocus(this.l);
        g();
    }

    public void d() {
        if (this.a.requestAudioFocus(this.l, 3, 1) == 1) {
            h();
        }
    }

    public bb e() {
        if (this.e == null || this.b == null || (this.j != PlayerStatus.PAUSE && !b())) {
            return null;
        }
        return this.e.a();
    }

    public void f() {
        this.a.abandonAudioFocus(this.l);
        if (this.b != null) {
            this.b.stop();
            this.b.release();
            this.b = null;
        }
        this.n = -1;
        this.e = null;
        this.c = "";
        this.h.clear();
        this.g = -1;
        this.f = null;
        a(PlayerStatus.IDLE);
        this.k.clear();
        g.c().b();
    }

    private void g() {
        if (b()) {
            a(PlayerStatus.PAUSE);
            this.b.pause();
        }
    }

    private void h() {
        if (this.j == PlayerStatus.PAUSE && this.b != null) {
            this.b.start();
            a(PlayerStatus.PLAYING);
        }
    }

    private void a(b bVar) {
        if (this.b == null) {
            this.b = new MediaPlayer();
        }
        this.f = bVar;
        g.c().a();
        if (this.c.equals(bVar.d())) {
            if (this.j == PlayerStatus.PLAYING) {
                this.b.seekTo(Math.round(bVar.b() * 1000.0f));
                return;
            } else if (this.j == PlayerStatus.PAUSE) {
                a(PlayerStatus.PLAYING);
                this.b.start();
                this.b.seekTo(Math.round(bVar.b() * 1000.0f));
                return;
            }
        }
        this.b.reset();
        a(PlayerStatus.PREPARING);
        this.c = bVar.d();
        this.b.setAudioStreamType(3);
        this.b.setOnSeekCompleteListener(new b(this));
        this.b.setOnCompletionListener(new c(this));
        try {
            this.b.setDataSource(a(bVar.d()));
            this.b.setOnPreparedListener(new d(this, bVar));
            this.b.prepareAsync();
        } catch (Exception e) {
        }
    }

    private String a(String str) {
        return this.d + str;
    }

    private void a(PlayerStatus playerStatus) {
        if (playerStatus != this.j) {
            this.j = playerStatus;
            b(this.j);
            if (b()) {
                this.m.sendEmptyMessage(0);
            } else {
                this.m.removeMessages(0);
            }
        }
    }

    private void i() {
        b b = b(this.e);
        a(PlayerStatus.IDLE);
        if (b != null) {
            a(b);
        } else {
            a(this.g);
        }
    }

    private void a(int i) {
        synchronized (this) {
            Iterator it = this.k.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(i);
            }
        }
    }

    private void b(PlayerStatus playerStatus) {
        synchronized (this) {
            Iterator it = this.k.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(playerStatus);
            }
        }
    }

    private void a(bb bbVar) {
        synchronized (this) {
            Iterator it = this.k.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(bbVar);
            }
        }
    }

    private b b(int i) {
        for (b[] bVarArr : this.h.values()) {
            for (b bVar : (b[]) r3.next()) {
                if (a(bVar, i, this.c)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private boolean a(b bVar, int i, String str) {
        float f = ((float) i) / 1000.0f;
        if ((this.f == null || !bVar.a().a(this.f.a())) && bVar.d().equals(str) && f >= bVar.b() && f <= bVar.c()) {
            return true;
        }
        return false;
    }

    private b b(b bVar) {
        if (bVar == null || this.g < 0) {
            return null;
        }
        b[] bVarArr = (b[]) this.h.get(Integer.valueOf(this.g));
        if (bVarArr == null) {
            return null;
        }
        for (b bVar2 : bVarArr) {
            if (bVar2.a().c(bVar.a())) {
                return bVar2;
            }
        }
        return null;
    }
}
