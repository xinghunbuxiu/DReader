package com.duokan.reader.ui.reading;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ag;
import com.duokan.core.ui.UTools;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.i;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.tts.TtsEngine;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.hd;

import java.util.Arrays;
import java.util.LinkedList;

public class adm extends hd implements SystemUiConditioner {
    private final sh a = ((sh) getContext().queryFeature(sh.class));
    private final n b = this.a.getDocument();
    private final FrameLayout c = new ads(this, getContext());
    private final aed d = new aed(this);
    private final aeh e = new aeh();
    private final FrameLayout f;
    private TtsEngine g = null;
    private TtsEngine h = null;
    private TtsEngine i = null;
    private aej j = null;
    private aek k = null;
    private ActivatedController l = null;
    private aeg m = null;
    private Runnable n = null;
    private aec o;
    private ServiceConnection p = new adn(this);
    private aeu q;

    public adm(IFeature featrue) {
        super(featrue);
        this.c.setWillNotDraw(false);
        this.c.setVisibility(4);
        View imageView = new ImageView(getContext());
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setImageResource(f.reading__shared__tts_show_menu);
        imageView.setContentDescription(getResources().getString(j.reading__tts_menu_view__open));
        imageView.setBackgroundResource(f.general__shared__button_circular_48dip);
        this.f = new FrameLayout(getContext());
        this.f.setPadding(0, 0, UTools.closeAnimation(getContext(), 15.0f), UTools.closeAnimation(getContext(), 30.0f));
        this.f.setOnClickListener(new adt(this));
        this.f.addView(imageView, new LayoutParams(-2, -2));
        this.c.addView(this.f, new LayoutParams(-2, -2, 85));
        setContentView(this.c);
        this.a.a(this.e);
        this.a.a(this.d);
    }

    public boolean a() {
        UmengManager.get().onEvent("TTS_PLAY_V1");
        if (this.a.f()) {
            ak Z = this.a.Z();
            if (!Z.b() || !j()) {
                return false;
            }
            bb r = this.a.r();
            return a((d) (r.f() ? Z.g() : r.g()));
        }
        ap apVar = new ap(getContext());
        apVar.setTitle(j.reading__shared__tts_not_allowed_title);
        apVar.setPrompt(j.reading__shared__tts_not_allowed_prompt);
        apVar.setOkLabel(j.general__shared__iknow);
        apVar.show();
        return false;
    }

    private boolean a(d dVar) {
        a.c().b(this.g != null);
        if (this.g == null) {
            return false;
        }
        this.g.setSpeed(this.a.ae().R());
        this.g.setSpeaker(this.a.ae().S());
        if (this.j != null) {
            this.j.d = true;
            this.j = null;
            this.g.stopSpeaking();
        }
        this.j = new aej();
        this.j.a = dVar;
        this.c.setVisibility(0);
        b(this.j, new adu(this));
        if (this.q == null) {
            getActivity().bindService(new Intent(getContext(), TtsNotificationService.class), this.p, 1);
        } else {
            this.q.a();
        }
        this.a.a(64, 12);
        if (this.k != null) {
            this.k.e();
        }
        return true;
    }

    public void b() {
        a(false);
        if (this.q != null) {
            getActivity().unbindService(this.p);
            this.q = null;
        }
    }

    private void a(boolean z) {
        if (this.j != null) {
            if (this.k != null) {
                if (z) {
                    this.k.d();
                } else {
                    this.k.c();
                }
            }
            this.g.stopSpeaking();
            this.j.d = true;
            this.j = null;
            this.c.setVisibility(4);
            this.a.setActiveColorText(null);
            if (this.l != null) {
                this.l.requestDetach();
            }
        }
    }

    private void b(d dVar) {
        a(true);
        a(dVar);
    }

    public void c() {
        i();
        h();
    }

    private void h() {
        if (this.j != null && this.j.e) {
            this.j.e = false;
            if (this.k != null) {
                this.k.e();
            }
            if (this.g.isSpeaking()) {
                this.g.resumeSpeaking();
            }
            if (this.q != null) {
                this.q.c();
            }
        }
    }

    public void d() {
        if (this.j != null && !this.j.e) {
            this.g.pauseSpeaking();
            this.j.e = true;
            if (this.k != null) {
                this.k.d();
            }
            if (this.q != null) {
                this.q.b();
            }
        }
    }

    public boolean e() {
        return this.j != null;
    }

    public boolean f() {
        return (this.j == null || this.j.e) ? false : true;
    }

    public void a(float f) {
        this.a.ae().h(f);
        this.a.ae().Y();
        a.c().b(this.g != null);
        if (this.g != null) {
            this.g.setSpeed(f);
        }
    }

    public void a(int i) {
        if (this.k != null) {
            this.k.c();
        }
        if (i < Integer.MAX_VALUE && e()) {
            aek com_duokan_reader_ui_reading_aek = new aek(this, i);
            com_duokan_reader_ui_reading_aek.b();
            if (f()) {
                com_duokan_reader_ui_reading_aek.d();
            }
        }
    }

    public int g() {
        if (!e()) {
            return 0;
        }
        if (this.k == null) {
            return Integer.MAX_VALUE;
        }
        return this.k.a();
    }

    public void a(String str) {
        this.a.ae().a(str);
        this.a.ae().Y();
        a.c().b(this.g != null);
        if (this.g != null) {
            this.g.setSpeaker(str);
        }
    }

    public void a(Runnable runnable) {
        this.n = runnable;
        a.c().b(this.g != null);
        if (this.g != null) {
            this.g.showSpeakers(getActivity(), 1);
        }
    }

    protected void a(int i, int i2) {
        if ((i & 64) == 64 && (i2 & 64) != 64) {
            b();
        }
    }

    protected boolean onBack() {
        if (super.onBack()) {
            return true;
        }
        if (!this.a.bb()) {
            return false;
        }
        b();
        return true;
    }

    protected boolean onRequestDetach(ActivatedController activatedControllerVar) {
        if (!activatedControllerVar.contains(this.l)) {
            return super.onRequestDetach(activatedControllerVar);
        }
        if (this.l.getContentView().getAnimation() == null) {
            UTools.showAnimation(this.l.getContentView(), new adv(this));
            this.f.setVisibility(0);
            UTools.closeAnimation(this.f, null);
        }
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && this.n != null) {
            TaskHandler.PostTask(this.n);
            this.n = null;
        }
    }

    protected void onActivityDestroyed() {
        super.onActivityDestroyed();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).addSystemUiConditioner(this);
    }

    protected void onDeactive() {
        super.onDeactive();
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).removeSystemUiConditioner(this);
    }

    public void chooseStatusBarStyle(af afVar) {
    }

    public void chooseNavigationBarMode(af afVar) {
    }

    public void chooseNavigationBarColor(af afVar) {
        if (isActive() && this.l != null) {
            afVar.a(Integer.valueOf(-16777216));
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.o = new aec();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        getActivity().registerReceiver(this.o, intentFilter);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        b();
        getActivity().unregisterReceiver(this.o);
    }

    private void a(Canvas canvas) {
        if (this.m != null) {
            as aa = this.a.aa();
            if (aa.G()) {
                Rect rect = (Rect) UTools.g.getRect();
                if (aa instanceof i) {
                    i iVar = (i) aa;
                    if (iVar.d().contains(this.m.c.x, this.m.c.y)) {
                        aa = iVar.b();
                    } else {
                        aa = iVar.c();
                    }
                }
                int b = UTools.closeAnimation(getContext(), 3.0f);
                rect.left = aa.getBounds().left;
                rect.top = this.m.c.y - (b / 2);
                rect.right = aa.getBounds().right;
                rect.bottom = rect.top + b;
                Paint paint = (Paint) UTools.b.getRect();
                paint.setColor(getResources().getColor(com.duokan.c.d.general__shared__00000066));
                canvas.drawRect(rect, paint);
                UTools.b.getRect(paint);
                UTools.g.getRect(rect);
            }
        }
    }

    private void a(aej com_duokan_reader_ui_reading_aej, ag agVar) {
        Document_a aVar = com_duokan_reader_ui_reading_aej.a;
        if (aVar == null) {
            TaskHandler.PostTask(new adw(this, agVar, com_duokan_reader_ui_reading_aej));
            return;
        }
        ak akVar;
        if (com_duokan_reader_ui_reading_aej.a instanceof ak) {
            akVar = (ak) com_duokan_reader_ui_reading_aej.a;
        } else {
            akVar = this.b.a(com_duokan_reader_ui_reading_aej.a);
        }
        this.a.a(akVar, true, new adx(this, com_duokan_reader_ui_reading_aej, agVar, aVar));
    }

    private void a(aej com_duokan_reader_ui_reading_aej) {
        if (!com_duokan_reader_ui_reading_aej.b.isEmpty()) {
            ael a;
            if (com_duokan_reader_ui_reading_aej.c != null) {
                a = a(com_duokan_reader_ui_reading_aej.c, (ael) com_duokan_reader_ui_reading_aej.b.getFirst());
                com_duokan_reader_ui_reading_aej.b.removeFirst();
                com_duokan_reader_ui_reading_aej.b.addFirst(a);
                com_duokan_reader_ui_reading_aej.c = null;
            }
            a = (ael) com_duokan_reader_ui_reading_aej.b.getLast();
            if (com_duokan_reader_ui_reading_aej.a != null && a(a)) {
                com_duokan_reader_ui_reading_aej.c = a;
                com_duokan_reader_ui_reading_aej.b.removeLast();
            }
        }
    }

    private void b(aej com_duokan_reader_ui_reading_aej, ag agVar) {
        if (com_duokan_reader_ui_reading_aej.d) {
            TaskHandler.PostTask(new adz(this, agVar, com_duokan_reader_ui_reading_aej));
            return;
        }
        i();
        if (!com_duokan_reader_ui_reading_aej.b.isEmpty()) {
            ael com_duokan_reader_ui_reading_ael = (ael) com_duokan_reader_ui_reading_aej.b.getFirst();
            UmengManager.get().onEvent("TTS_READ_SENTENCE_V1", this.g == this.h ? "NEW" : "OLD");
            this.g.startSpeaking(com_duokan_reader_ui_reading_ael.a, new aea(this, com_duokan_reader_ui_reading_ael, com_duokan_reader_ui_reading_aej, agVar));
        } else if (com_duokan_reader_ui_reading_aej.a == null) {
            a.c().c(LogLevel.ERROR, "tts", "no content");
            TaskHandler.PostTask(new ado(this, agVar, com_duokan_reader_ui_reading_aej));
        } else {
            a(com_duokan_reader_ui_reading_aej, new adp(this, agVar));
        }
    }

    private void i() {
        AudioManager audioManager = (AudioManager) DkApp.get().getSystemService("audio");
        audioManager.requestAudioFocus(new adq(this, audioManager), 3, 1);
    }

    private ael[] a(as... asVarArr) {
        LinkedList linkedList = new LinkedList();
        for (as a : asVarArr) {
            ael[] a2 = a(a);
            if (!linkedList.isEmpty() && a2.length > 0) {
                ael com_duokan_reader_ui_reading_ael = (ael) linkedList.getLast();
                if (a(com_duokan_reader_ui_reading_ael)) {
                    com_duokan_reader_ui_reading_ael = a(com_duokan_reader_ui_reading_ael, a2[0]);
                    linkedList.removeLast();
                    linkedList.add(com_duokan_reader_ui_reading_ael);
                    for (int i = 1; i < a2.length; i++) {
                        linkedList.add(a2[i]);
                    }
                }
            }
            linkedList.addAll(Arrays.asList(a2));
        }
        return (ael[]) linkedList.toArray(new ael[0]);
    }

    private ael[] a(as asVar) {
        LinkedList linkedList = new LinkedList();
        ak l = asVar.l();
        String charSequence = asVar.o().toString();
        d[] n = asVar.n();
        if (charSequence.isEmpty()) {
            ael com_duokan_reader_ui_reading_ael = new ael();
            com_duokan_reader_ui_reading_ael.a = "";
            com_duokan_reader_ui_reading_ael.b = this.b.a((d) l.h(), (d) l.h());
            linkedList.add(com_duokan_reader_ui_reading_ael);
        } else {
            ael com_duokan_reader_ui_reading_ael2;
            String[] b = b(charSequence);
            int i = 0;
            for (int i2 = 0; i2 < b.length - 1; i2++) {
                com_duokan_reader_ui_reading_ael2 = new ael();
                com_duokan_reader_ui_reading_ael2.a = b[i2];
                com_duokan_reader_ui_reading_ael2.b = this.b.a(n[i], n[com_duokan_reader_ui_reading_ael2.a.length() + i]);
                linkedList.add(com_duokan_reader_ui_reading_ael2);
                i += com_duokan_reader_ui_reading_ael2.a.length();
            }
            com_duokan_reader_ui_reading_ael2 = new ael();
            com_duokan_reader_ui_reading_ael2.a = b[b.length - 1];
            com_duokan_reader_ui_reading_ael2.b = this.b.a(n[i], (d) l.h());
            linkedList.add(com_duokan_reader_ui_reading_ael2);
        }
        return (ael[]) linkedList.toArray(new ael[0]);
    }

    private ael a(ael com_duokan_reader_ui_reading_ael, ael com_duokan_reader_ui_reading_ael2) {
        ael com_duokan_reader_ui_reading_ael3 = new ael();
        com_duokan_reader_ui_reading_ael3.a = com_duokan_reader_ui_reading_ael.a + com_duokan_reader_ui_reading_ael2.a;
        com_duokan_reader_ui_reading_ael3.b = this.b.a((d) com_duokan_reader_ui_reading_ael.b.g(), (d) com_duokan_reader_ui_reading_ael2.b.h());
        com_duokan_reader_ui_reading_ael3.c = com_duokan_reader_ui_reading_ael.a.length();
        return com_duokan_reader_ui_reading_ael3;
    }

    private static boolean a(ael com_duokan_reader_ui_reading_ael) {
        if (!com_duokan_reader_ui_reading_ael.a.isEmpty()) {
            char charAt = com_duokan_reader_ui_reading_ael.a.charAt(com_duokan_reader_ui_reading_ael.a.length() - 1);
            if (!(DkUtils.isPunctuation(charAt) || DkUtils.isLineBreak(charAt))) {
                return true;
            }
        }
        return false;
    }

    private static String[] b(String str) {
        LinkedList linkedList = new LinkedList();
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (".?!:。？！:…\r\n".indexOf(charAt) >= 0 || i == str.length() - 1) {
                char charAt2;
                if (charAt == '.' && i > 0 && i < str.length() - 1) {
                    charAt = str.charAt(i - 1);
                    charAt2 = str.charAt(i + 1);
                    if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
                        i++;
                    }
                }
                int i3 = i + 1;
                i = 0;
                while (i3 < str.length()) {
                    charAt2 = str.charAt(i3);
                    if (!DkUtils.isLineBreak(charAt2)) {
                        if (!DkUtils.isPunctuation(charAt2) || r0 != 0) {
                            break;
                        } else if ("(<‘“《（【".indexOf(charAt2) >= 0) {
                            break;
                        }
                    } else {
                        i = 1;
                    }
                    i3++;
                }
                linkedList.add(str.substring(i2, i3));
                i = i3;
                i2 = i3;
            } else {
                i++;
            }
        }
        if (linkedList.size() > 0) {
            return (String[]) linkedList.toArray(new String[0]);
        }
        return new String[]{""};
    }

    private boolean j() {
        if (this.h == null) {
            try {
                this.h = (TtsEngine) ReaderEnv.get().loadExtendClass("com.duokan.reader.domain.tts.TtsEngineImpl").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{ManagedApp.get()});
                a.c().b(this.h != null);
            } catch (Throwable th) {
                a.c().a(LogLevel.ERROR, "tts", "an exception occurs while preparing the new tts engine", th);
            }
        }
        if (this.i == null) {
            try {
                boolean z;
                this.i = (TtsEngine) ReaderEnv.get().loadExtendCompatClass("com.duokan.reader.domain.tts.TtsEngineImpl").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{ManagedApp.get()});
                a c = a.c();
                if (this.i != null) {
                    z = true;
                } else {
                    z = false;
                }
                c.b(z);
            } catch (Throwable th2) {
                a.c().a(LogLevel.ERROR, "tts", "an exception occurs while preparing the old tts engine", th2);
            }
        }
        if (this.h != null && this.h.checkServiceInstalled()) {
            this.g = this.h;
            a.c().c(LogLevel.EVENT, "tts", "use the new tts engine");
            return true;
        } else if (this.i != null && this.i.checkServiceInstalled()) {
            this.g = this.i;
            a.c().c(LogLevel.EVENT, "tts", "use the old tts engine");
            return true;
        } else if (this.h == null) {
            a.c().c(LogLevel.ERROR, "tts", "no usable tts engine");
            return false;
        } else {
            a.c().c(LogLevel.EVENT, "tts", "try to use the new tts engine, but need to download iflytek first...");
            ap apVar = new ap(getContext());
            apVar.setTitle(j.reading__shared__iflytek_download_title);
            apVar.setPrompt(j.reading__shared__iflytek_download_prompt);
            apVar.setOkLabel(j.plugins__shared__download);
            apVar.setCancelLabel(j.plugins__shared__postpone);
            apVar.open(new adr(this));
            return false;
        }
    }
}
