package com.duokan.reader.ui.reading;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ag;
import com.duokan.core.ui.dv;
import com.duokan.kernel.DkUtils;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.SystemUiMode;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0563j;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0941i;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.tts.TtsEngineIflytek;
import com.duokan.reader.domain.tts.TtsManager;
import com.duokan.reader.domain.tts.TtsManager.OnCurrentSpeakerChangeListener;
import com.duokan.reader.domain.tts.TtsManager.OnUserIdChangeListener;
import com.duokan.reader.domain.tts.TtsManager.TtsSpeaker;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.gs;
import java.util.Arrays;
import java.util.LinkedList;

public class adz extends gs implements SystemUiConditioner, C0563j, OnCurrentSpeakerChangeListener, OnUserIdChangeListener {
    /* renamed from: a */
    private final su f9541a = ((su) getContext().queryFeature(su.class));
    /* renamed from: b */
    private final C0903n f9542b = this.f9541a.getDocument();
    /* renamed from: c */
    private final FrameLayout f9543c = new ael(this, getContext());
    /* renamed from: d */
    private final aeu f9544d = new aeu(this);
    /* renamed from: e */
    private final aey f9545e = new aey();
    /* renamed from: f */
    private final FrameLayout f9546f;
    /* renamed from: g */
    private final TtsManager f9547g = TtsManager.get();
    /* renamed from: h */
    private TtsEngineIflytek f9548h = null;
    /* renamed from: i */
    private afa f9549i = null;
    /* renamed from: j */
    private afb f9550j = null;
    /* renamed from: k */
    private ActivatedController f9551k = null;
    /* renamed from: l */
    private aex f9552l = null;
    /* renamed from: m */
    private Runnable f9553m = null;
    /* renamed from: n */
    private aet f9554n;
    /* renamed from: o */
    private ServiceConnection f9555o = new aea(this);
    /* renamed from: p */
    private afl f9556p;
    /* renamed from: q */
    private afc f9557q = null;
    /* renamed from: r */
    private boolean f9558r;
    /* renamed from: s */
    private ap f9559s;

    public adz(IFeature mFeature) {
        super(mFeature);
        this.f9543c.setWillNotDraw(false);
        this.f9543c.setVisibility(4);
        View imageView = new ImageView(getContext());
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setImageResource(C0254f.reading__shared__tts_show_menu);
        imageView.setContentDescription(getResources().getString(C0258j.reading__tts_menu_view__open));
        imageView.setBackgroundResource(C0254f.general__shared__button_circular_48dip);
        this.f9546f = new FrameLayout(getContext());
        this.f9546f.setPadding(0, 0, dv.m1932b(getContext(), 15.0f), dv.m1932b(getContext(), 30.0f));
        this.f9546f.setOnClickListener(new aem(this));
        this.f9546f.addView(imageView, new LayoutParams(-2, -2));
        this.f9543c.addView(this.f9546f, new LayoutParams(-2, -2, 85));
        setContentView(this.f9543c);
        this.f9541a.mo2021a(this.f9545e);
        this.f9541a.mo2021a(this.f9544d);
    }

    /* renamed from: a */
    private void m13409a(Runnable runnable) {
        if (!this.f9547g.getCurrentSpeaker().isCloud() || this.f9558r || C0559f.m2476b().m2485d() || !C0559f.m2476b().m2486e()) {
            runnable.run();
            return;
        }
        if (this.f9559s != null && this.f9559s.isShowing()) {
            this.f9559s.dismiss();
        }
        this.f9559s = new ap(getContext());
        this.f9559s.setPrompt(C0258j.reading__tts_view__use_data);
        this.f9559s.setOkLabelResid(C0258j.general__shared__continue);
        this.f9559s.setNoLabel(C0258j.reading__tts_view__change_speaker);
        this.f9559s.open(new aen(this, runnable));
    }

    /* renamed from: a */
    public void m13442a() {
        ak Z = this.f9541a.mo2009Z();
        if (Z.m5777b() && m13437j() != null) {
            bb r = this.f9541a.mo2170r();
            m13402a((C0897d) (r.m5817f() ? Z.mo1198g() : r.mo1198g()));
        }
    }

    /* renamed from: a */
    private void m13402a(C0897d c0897d) {
        m13409a(new aeo(this, c0897d));
    }

    /* renamed from: b */
    private boolean m13427b(C0897d c0897d) {
        if (this.f9548h == null) {
            return false;
        }
        if (this.f9547g.getCurrentSpeaker().isEmpty()) {
            this.f9547g.setCurrentSpeaker((TtsSpeaker) this.f9547g.getSpeakerList().getFirst());
            return false;
        }
        this.f9548h.setSpeaker(this.f9547g.getCurrentSpeaker());
        this.f9548h.setSpeed(m13451g());
        if (this.f9549i != null) {
            this.f9549i.f9615d = true;
            this.f9549i = null;
            this.f9548h.stopSpeaking();
        }
        this.f9549i = new afa();
        this.f9549i.f9612a = c0897d;
        this.f9543c.setVisibility(0);
        m13425b(this.f9549i, new aep(this));
        if (this.f9556p == null) {
            getActivity().bindService(new Intent(getContext(), TtsNotificationService.class), this.f9555o, 1);
        } else {
            this.f9556p.m13496a();
        }
        this.f9541a.mo2040a(64, 12);
        if (this.f9550j == null) {
            return true;
        }
        this.f9550j.m13491e();
        return true;
    }

    /* renamed from: b */
    public void m13446b() {
        m13411a(false, false);
        if (this.f9559s != null) {
            this.f9559s.dismiss();
        }
        if (this.f9556p != null) {
            getActivity().unbindService(this.f9555o);
            this.f9556p = null;
        }
    }

    /* renamed from: a */
    private void m13411a(boolean z, boolean z2) {
        if (this.f9549i != null) {
            if (this.f9550j != null) {
                if (z) {
                    this.f9550j.m13490d();
                } else {
                    this.f9550j.m13489c();
                }
            }
            this.f9548h.stopSpeaking();
            this.f9549i.f9615d = true;
            this.f9549i = null;
            this.f9543c.setVisibility(4);
            this.f9541a.setActiveColorText(null);
            if (this.f9551k != null && !z2) {
                this.f9551k.requestDetach();
            }
        }
    }

    /* renamed from: c */
    private void m13429c(C0897d c0897d) {
        m13411a(true, false);
        m13437j();
        m13427b(c0897d);
    }

    /* renamed from: c */
    public void m13447c() {
        m13409a(new aeq(this));
    }

    /* renamed from: i */
    private void m13436i() {
        if (this.f9549i != null && this.f9549i.f9616e) {
            this.f9549i.f9616e = false;
            if (this.f9550j != null) {
                this.f9550j.m13491e();
            }
            if (this.f9548h.isSpeaking()) {
                this.f9548h.resumeSpeaking();
            }
            if (this.f9556p != null) {
                this.f9556p.m13498c();
            }
        }
    }

    /* renamed from: d */
    public void m13448d() {
        if (this.f9549i != null && !this.f9549i.f9616e) {
            this.f9548h.pauseSpeaking();
            this.f9549i.f9616e = true;
            if (this.f9550j != null) {
                this.f9550j.m13490d();
            }
            if (this.f9556p != null) {
                this.f9556p.m13497b();
            }
        }
    }

    /* renamed from: e */
    public boolean m13449e() {
        return this.f9549i != null;
    }

    /* renamed from: f */
    public boolean m13450f() {
        return this.f9549i != null && this.f9549i.f9616e;
    }

    /* renamed from: g */
    public float m13451g() {
        return this.f9541a.ae().m12457R();
    }

    /* renamed from: a */
    public void m13443a(float f) {
        this.f9541a.ae().m12508h(f);
        this.f9541a.ae().m12463X();
        if (this.f9548h != null) {
            m13410a(true);
        }
    }

    /* renamed from: a */
    public void m13444a(int i) {
        if (this.f9550j != null) {
            this.f9550j.m13489c();
        }
        if (i < Integer.MAX_VALUE && m13449e()) {
            afb afb = new afb(this, i);
            afb.m13488b();
            if (m13450f()) {
                afb.m13490d();
            }
        }
    }

    /* renamed from: h */
    public int m13452h() {
        if (!m13449e()) {
            return 0;
        }
        if (this.f9550j == null) {
            return Integer.MAX_VALUE;
        }
        return this.f9550j.m13487a();
    }

    /* renamed from: a */
    protected void m13445a(int i, int i2) {
        if ((i & 64) == 64 && (i2 & 64) != 64) {
            m13446b();
        }
    }

    protected boolean onBack() {
        if (super.onBack()) {
            return true;
        }
        if (this.f9551k != null && getSubControllers().contains(this.f9551k)) {
            this.f9551k.requestDetach();
            return true;
        } else if (!this.f9541a.bb()) {
            return false;
        } else {
            m13446b();
            return true;
        }
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (this.f9551k != c0303e) {
            return super.onRequestDetach(c0303e);
        }
        if (this.f9551k.getContentView().getAnimation() == null) {
            dv.hideAnimation(this.f9551k.getContentView(), new aer(this));
            this.f9546f.setVisibility(0);
            dv.showAnimation(this.f9546f, null);
        }
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && this.f9553m != null) {
            UThread.post(this.f9553m);
            this.f9553m = null;
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

    public void chooseStatusBarStyle(af<Boolean> afVar) {
    }

    public void chooseNavigationBarMode(af<SystemUiMode> afVar) {
    }

    public void chooseNavigationBarColor(af<Integer> afVar) {
        if (isActive() && this.f9551k != null) {
            afVar.mo975a(Integer.valueOf(-16777216));
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.f9554n = new aet();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        this.f9547g.addCurrentSpeakerChangeListener(this);
        this.f9547g.addOnUserIdChangeListener(this);
        C0559f.m2476b().m2481a((C0563j) this);
        getActivity().registerReceiver(this.f9554n, intentFilter);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        m13446b();
        getActivity().unregisterReceiver(this.f9554n);
        this.f9547g.removeOnCurrentSpeakerChangeListener(this);
        this.f9547g.removeOnUserIdChangeListener(this);
        C0559f.m2476b().m2483b((C0563j) this);
    }

    public void onCurrentSpeakerChange() {
        m13410a(false);
    }

    public void onUserIdChange(String str) {
        if (this.f9548h != null) {
            this.f9548h.startEngine();
        }
        if (m13449e()) {
            m13410a(false);
        }
    }

    /* renamed from: j */
    private TtsEngineIflytek m13437j() {
        if (this.f9548h != null) {
            return this.f9548h;
        }
        try {
            this.f9548h = new TtsEngineIflytek(ManagedApp.get());
        } catch (Throwable th) {
            C0328a.m757c().m748a(LogLevel.ERROR, "tts", "an exception occurs while preparing the iflytek tts engine", th);
        }
        if (this.f9548h != null) {
            C0328a.m757c().m752c(LogLevel.EVENT, "tts", "use the iflytek tts engine");
        } else {
            C0328a.m757c().m752c(LogLevel.ERROR, "tts", "no usable tts engine");
            be.m10286a(getContext(), C0258j.general__shared__tts_init_failed, 0).show();
        }
        return this.f9548h;
    }

    /* renamed from: a */
    private void m13410a(boolean z) {
        m13411a(true, z);
        if (m13437j() != null) {
            try {
                m13402a((C0897d) this.f9557q.f9622b.mo1198g());
            } catch (Throwable th) {
                m13442a();
            }
        }
    }

    /* renamed from: a */
    private void m13401a(Canvas canvas) {
        if (this.f9552l != null) {
            as aa = this.f9541a.aa();
            if (aa.mo1284G()) {
                Rect rect = (Rect) dv.f1198g.addAnimation();
                if (aa instanceof C0941i) {
                    C0941i c0941i = (C0941i) aa;
                    if (c0941i.mo1435d().contains(this.f9552l.f9606c.x, this.f9552l.f9606c.y)) {
                        aa = c0941i.mo1305b();
                    } else {
                        aa = c0941i.mo1434c();
                    }
                }
                int b = dv.m1932b(getContext(), 3.0f);
                rect.left = aa.getBounds().left;
                rect.top = this.f9552l.f9606c.y - (b / 2);
                rect.right = aa.getBounds().right;
                rect.bottom = rect.top + b;
                Paint paint = (Paint) dv.f1193b.addAnimation();
                paint.setColor(getResources().getColor(C0252d.general__shared__00000066));
                canvas.drawRect(rect, paint);
                dv.f1193b.clearAnimation(paint);
                dv.f1198g.clearAnimation(rect);
            }
        }
    }

    /* renamed from: a */
    private void m13408a(afa afa, ag<afa> agVar) {
        C0896a c0896a = afa.f9612a;
        if (c0896a == null) {
            UThread.post(new aes(this, agVar, afa));
            return;
        }
        ak akVar;
        if (afa.f9612a instanceof ak) {
            akVar = (ak) afa.f9612a;
        } else {
            akVar = this.f9542b.m5896a(afa.f9612a);
        }
        this.f9541a.mo2022a(akVar, true, new aeb(this, afa, agVar, c0896a));
    }

    /* renamed from: a */
    private void m13406a(afa afa) {
        if (!afa.f9613b.isEmpty()) {
            afc a;
            if (afa.f9614c != null) {
                a = m13398a(afa.f9614c, (afc) afa.f9613b.getFirst());
                afa.f9613b.removeFirst();
                afa.f9613b.addFirst(a);
                afa.f9614c = null;
            }
            a = (afc) afa.f9613b.getLast();
            if (afa.f9612a != null && m13415a(a)) {
                afa.f9614c = a;
                afa.f9613b.removeLast();
            }
        }
    }

    /* renamed from: b */
    private afc m13422b(afa afa) {
        afc afc = new afc();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < afa.f9613b.size(); i++) {
            afc afc2 = (afc) afa.f9613b.get(i);
            stringBuffer.append(afc2.f9621a);
            if (i == 0) {
                afc.f9622b = afc2.f9622b;
            }
        }
        afc.f9621a = stringBuffer.toString();
        return afc;
    }

    /* renamed from: a */
    private void m13407a(afa afa, int i) {
        afc afc;
        int i2 = 0;
        for (int size = afa.f9613b.size() - 1; size >= 0; size--) {
            afc = (afc) afa.f9613b.get(size);
            i2 += afc.f9621a.length();
            if (i2 >= i) {
                break;
            }
        }
        afc = null;
        if (afc != null && this.f9557q != afc) {
            this.f9541a.setActiveColorText(afc.f9622b);
            this.f9557q = afc;
        }
    }

    /* renamed from: b */
    private void m13425b(afa afa, ag<afa> agVar) {
        if (afa.f9615d) {
            UThread.post(new aed(this, agVar, afa));
            return;
        }
        m13440k();
        if (!afa.f9613b.isEmpty()) {
            afc b = m13422b(afa);
            if (TextUtils.isEmpty(b.f9621a)) {
                afa.f9613b.clear();
                m13425b(afa, (ag) agVar);
                return;
            }
            this.f9548h.startSpeaking(b.f9621a, new aee(this, b, afa, agVar));
        } else if (afa.f9612a == null) {
            C0328a.m757c().m752c(LogLevel.ERROR, "tts", "no content");
            UThread.post(new aej(this, agVar, afa));
        } else {
            m13408a(afa, new aek(this, agVar));
        }
    }

    /* renamed from: k */
    private void m13440k() {
        ((AudioManager) DkApp.get().getSystemService("audio")).requestAudioFocus(null, 3, 1);
    }

    /* renamed from: b */
    private boolean m13426b(int i) {
        return i == TtsEngineIflytek.ERROR_NETWORK_CONNECTION_ERROR || i == TtsEngineIflytek.ERROR_NETWORK_SOCKET_ERROR || i == TtsEngineIflytek.ERROR_NETWORK_SEND_ERROR || i == TtsEngineIflytek.ERROR_NETWORK_RECEIVE_ERROR || i == TtsEngineIflytek.ERROR_NETWORK_ERROR || i == TtsEngineIflytek.ERROR_NETWORK_CONNECTION_ERROR_ANDROID || i == TtsEngineIflytek.ERROR_NETWORK_HTTP_ERROR;
    }

    /* renamed from: a */
    private afc[] m13419a(as... asVarArr) {
        LinkedList linkedList = new LinkedList();
        for (as a : asVarArr) {
            afc[] a2 = m13416a(a);
            if (!linkedList.isEmpty() && a2.length > 0) {
                afc afc = (afc) linkedList.getLast();
                if (m13415a(afc)) {
                    afc = m13398a(afc, a2[0]);
                    linkedList.removeLast();
                    linkedList.add(afc);
                    for (int i = 1; i < a2.length; i++) {
                        linkedList.add(a2[i]);
                    }
                }
            }
            linkedList.addAll(Arrays.asList(a2));
        }
        return (afc[]) linkedList.toArray(new afc[0]);
    }

    /* renamed from: a */
    private afc[] m13416a(as asVar) {
        LinkedList linkedList = new LinkedList();
        ak l = asVar.mo1332l();
        String charSequence = asVar.mo1338o().toString();
        C0897d[] n = asVar.mo1336n();
        if (charSequence.isEmpty()) {
            afc afc = new afc();
            afc.f9621a = "";
            afc.f9622b = this.f9542b.mo1216a((C0897d) l.mo1199h(), (C0897d) l.mo1199h());
            linkedList.add(afc);
        } else {
            afc afc2;
            String[] a = m13420a(charSequence);
            int i = 0;
            for (int i2 = 0; i2 < a.length - 1; i2++) {
                afc2 = new afc();
                afc2.f9621a = a[i2];
                afc2.f9622b = this.f9542b.mo1216a(n[i], n[afc2.f9621a.length() + i]);
                linkedList.add(afc2);
                i += afc2.f9621a.length();
            }
            afc2 = new afc();
            afc2.f9621a = a[a.length - 1];
            afc2.f9622b = this.f9542b.mo1216a(n[i], (C0897d) l.mo1199h());
            linkedList.add(afc2);
        }
        return (afc[]) linkedList.toArray(new afc[0]);
    }

    /* renamed from: a */
    private afc m13398a(afc afc, afc afc2) {
        afc afc3 = new afc();
        afc3.f9621a = afc.f9621a + afc2.f9621a;
        afc3.f9622b = this.f9542b.mo1216a((C0897d) afc.f9622b.mo1198g(), (C0897d) afc2.f9622b.mo1199h());
        afc3.f9623c = afc.f9621a.length();
        return afc3;
    }

    /* renamed from: a */
    private static boolean m13415a(afc afc) {
        if (!afc.f9621a.isEmpty()) {
            char charAt = afc.f9621a.charAt(afc.f9621a.length() - 1);
            if (!(DkUtils.isPunctuation(charAt) || DkUtils.isLineBreak(charAt))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static String[] m13420a(String str) {
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

    public void onConnectivityChanged(C0559f c0559f) {
        if (this.f9547g.getCurrentSpeaker().isCloud() && m13449e() && !m13450f() && c0559f.m2484c() && !this.f9558r) {
            m13448d();
            m13447c();
        }
    }
}
