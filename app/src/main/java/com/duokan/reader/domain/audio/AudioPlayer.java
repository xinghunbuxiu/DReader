package com.duokan.reader.domain.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.os.Binder;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.reader.domain.document.C0930b;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.bb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class AudioPlayer extends Binder implements ai {
    /* renamed from: i */
    private static final aj<AudioPlayer> f2593i = new aj();
    /* renamed from: a */
    private final AudioManager f2594a;
    /* renamed from: b */
    private MediaPlayer f2595b = null;
    /* renamed from: c */
    private String f2596c;
    /* renamed from: d */
    private final String f2597d;
    /* renamed from: e */
    private C0930b f2598e;
    /* renamed from: f */
    private C0930b f2599f;
    /* renamed from: g */
    private int f2600g = -1;
    /* renamed from: h */
    private Map<Integer, C0930b[]> f2601h;
    /* renamed from: j */
    private PlayerStatus f2602j = PlayerStatus.IDLE;
    /* renamed from: k */
    private LinkedList<C0774e> f2603k;
    /* renamed from: l */
    private final OnAudioFocusChangeListener f2604l = new C0770a(this);
    /* renamed from: m */
    private C0775f f2605m;
    /* renamed from: n */
    private long f2606n = -1;

    public enum PlayerStatus {
        IDLE,
        PREPARING,
        PLAYING,
        PAUSE
    }

    public AudioPlayer(Context context) {
        this.f2594a = (AudioManager) context.getSystemService("audio");
        this.f2596c = "";
        this.f2605m = new C0775f(this);
        this.f2601h = new HashMap();
        this.f2603k = new LinkedList();
        this.f2597d = "http://127.0.0.1:9090/";
    }

    /* renamed from: a */
    public static void m3618a(Context context) {
        f2593i.m709a(new AudioPlayer(context));
    }

    /* renamed from: a */
    public static AudioPlayer m3613a() {
        return (AudioPlayer) f2593i.m707a();
    }

    /* renamed from: a */
    public void m3639a(C0930b[] c0930bArr, Integer num, long j) {
        if (c0930bArr != null && c0930bArr.length > 0) {
            if (this.f2606n != j) {
                this.f2601h.clear();
                this.f2606n = j;
            }
            if (!this.f2601h.containsKey(num)) {
                C0776g.m3650c().m3652a(c0930bArr, j);
                this.f2601h.put(num, c0930bArr);
            }
        }
    }

    /* renamed from: a */
    public void m3637a(C0774e c0774e) {
        synchronized (this) {
            this.f2603k.add(c0774e);
        }
    }

    /* renamed from: b */
    public void m3640b(C0774e c0774e) {
        synchronized (this) {
            Iterator it = this.f2603k.iterator();
            while (it.hasNext()) {
                if (((C0774e) it.next()) == c0774e) {
                    this.f2603k.remove(c0774e);
                    break;
                }
            }
        }
    }

    /* renamed from: a */
    public void m3638a(ay ayVar, Integer[] numArr) {
        if (numArr != null && ayVar != null && !ayVar.m5817f()) {
            C0930b c0930b;
            int i;
            int length = numArr.length;
            int i2 = 0;
            C0930b c0930b2 = null;
            int i3 = -1;
            while (i2 < length) {
                Integer num = numArr[i2];
                C0930b[] c0930bArr = (C0930b[]) this.f2601h.get(num);
                if (c0930bArr == null) {
                    c0930b = c0930b2;
                    i = i3;
                } else if (c0930bArr.length == 0) {
                    c0930b = c0930b2;
                    i = i3;
                } else {
                    for (int i4 = 0; i4 < c0930bArr.length; i4++) {
                        if (c0930bArr[i4].mo1443a().m5814b(ayVar)) {
                            c0930b = c0930bArr[i4];
                            i = num.intValue();
                            break;
                        }
                    }
                    c0930b = c0930b2;
                    i = i3;
                    if (c0930b != null) {
                        break;
                    }
                }
                i2++;
                i3 = i;
                c0930b2 = c0930b;
            }
            c0930b = c0930b2;
            i = i3;
            if (c0930b == null) {
                if (this.f2595b != null) {
                    this.f2595b.stop();
                }
                this.f2598e = null;
                this.f2596c = "";
                this.f2599f = null;
                this.f2600g = -1;
                m3619a(PlayerStatus.IDLE);
            } else if (this.f2594a.requestAudioFocus(this.f2604l, 3, 1) == 1) {
                m3623a(c0930b);
                this.f2600g = i;
            }
        }
    }

    /* renamed from: b */
    public boolean m3641b() {
        return this.f2602j == PlayerStatus.PREPARING || this.f2602j == PlayerStatus.PLAYING;
    }

    /* renamed from: c */
    public void m3642c() {
        this.f2594a.abandonAudioFocus(this.f2604l);
        m3634g();
    }

    /* renamed from: d */
    public void m3643d() {
        if (this.f2594a.requestAudioFocus(this.f2604l, 3, 1) == 1) {
            m3635h();
        }
    }

    /* renamed from: e */
    public bb m3644e() {
        if (this.f2598e == null || this.f2595b == null || (this.f2602j != PlayerStatus.PAUSE && !m3641b())) {
            return null;
        }
        return this.f2598e.mo1443a();
    }

    /* renamed from: f */
    public void m3645f() {
        this.f2594a.abandonAudioFocus(this.f2604l);
        if (this.f2595b != null) {
            this.f2595b.stop();
            this.f2595b.release();
            this.f2595b = null;
        }
        this.f2606n = -1;
        this.f2598e = null;
        this.f2596c = "";
        this.f2601h.clear();
        this.f2600g = -1;
        this.f2599f = null;
        m3619a(PlayerStatus.IDLE);
        this.f2603k.clear();
        C0776g.m3650c().m3653b();
    }

    /* renamed from: g */
    private void m3634g() {
        if (m3641b()) {
            m3619a(PlayerStatus.PAUSE);
            this.f2595b.pause();
        }
    }

    /* renamed from: h */
    private void m3635h() {
        if (this.f2602j == PlayerStatus.PAUSE && this.f2595b != null) {
            this.f2595b.start();
            m3619a(PlayerStatus.PLAYING);
        }
    }

    /* renamed from: a */
    private void m3623a(C0930b c0930b) {
        if (this.f2595b == null) {
            this.f2595b = new MediaPlayer();
        }
        this.f2599f = c0930b;
        C0776g.m3650c().m3651a();
        if (this.f2596c.equals(c0930b.mo1446d())) {
            if (this.f2602j == PlayerStatus.PLAYING) {
                this.f2595b.seekTo(Math.round(c0930b.mo1444b() * 1000.0f));
                return;
            } else if (this.f2602j == PlayerStatus.PAUSE) {
                m3619a(PlayerStatus.PLAYING);
                this.f2595b.start();
                this.f2595b.seekTo(Math.round(c0930b.mo1444b() * 1000.0f));
                return;
            }
        }
        this.f2595b.reset();
        m3619a(PlayerStatus.PREPARING);
        this.f2596c = c0930b.mo1446d();
        this.f2595b.setAudioStreamType(3);
        this.f2595b.setOnSeekCompleteListener(new C0771b(this));
        this.f2595b.setOnCompletionListener(new C0772c(this));
        try {
            this.f2595b.setDataSource(m3616a(c0930b.mo1446d()));
            this.f2595b.setOnPreparedListener(new C0773d(this, c0930b));
            this.f2595b.prepareAsync();
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private String m3616a(String str) {
        return this.f2597d + str;
    }

    /* renamed from: a */
    private void m3619a(PlayerStatus playerStatus) {
        if (playerStatus != this.f2602j) {
            this.f2602j = playerStatus;
            m3628b(this.f2602j);
            if (m3641b()) {
                this.f2605m.sendEmptyMessage(0);
            } else {
                this.f2605m.removeMessages(0);
            }
        }
    }

    /* renamed from: i */
    private void m3636i() {
        C0930b b = m3627b(this.f2598e);
        m3619a(PlayerStatus.IDLE);
        if (b != null) {
            m3623a(b);
        } else {
            m3617a(this.f2600g);
        }
    }

    /* renamed from: a */
    private void m3617a(int i) {
        synchronized (this) {
            Iterator it = this.f2603k.iterator();
            while (it.hasNext()) {
                ((C0774e) it.next()).mo2275a(i);
            }
        }
    }

    /* renamed from: b */
    private void m3628b(PlayerStatus playerStatus) {
        synchronized (this) {
            Iterator it = this.f2603k.iterator();
            while (it.hasNext()) {
                ((C0774e) it.next()).mo2276a(playerStatus);
            }
        }
    }

    /* renamed from: a */
    private void m3624a(bb bbVar) {
        synchronized (this) {
            Iterator it = this.f2603k.iterator();
            while (it.hasNext()) {
                ((C0774e) it.next()).mo2277a(bbVar);
            }
        }
    }

    /* renamed from: b */
    private C0930b m3626b(int i) {
        for (C0930b[] c0930bArr : this.f2601h.values()) {
            for (C0930b c0930b : (C0930b[]) r3.next()) {
                if (m3625a(c0930b, i, this.f2596c)) {
                    return c0930b;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m3625a(C0930b c0930b, int i, String str) {
        float f = ((float) i) / 1000.0f;
        if ((this.f2599f == null || !c0930b.mo1443a().mo1188a(this.f2599f.mo1443a())) && c0930b.mo1446d().equals(str) && f >= c0930b.mo1444b() && f <= c0930b.mo1445c()) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private C0930b m3627b(C0930b c0930b) {
        if (c0930b == null || this.f2600g < 0) {
            return null;
        }
        C0930b[] c0930bArr = (C0930b[]) this.f2601h.get(Integer.valueOf(this.f2600g));
        if (c0930bArr == null) {
            return null;
        }
        for (C0930b c0930b2 : c0930bArr) {
            if (c0930b2.mo1443a().mo1190c(c0930b.mo1443a())) {
                return c0930b2;
            }
        }
        return null;
    }
}
