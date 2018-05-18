package com.duokan.reader;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.duokan.core.app.IActivityLifecycleCallbacks;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.IOnAnr;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.aq;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.FrameScrollView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.p030d.DownloadUtil;
import com.duokan.p030d.C0402d;
import com.duokan.p030d.C0406h;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.umeng.MobclickAgentImpl;
import com.duokan.reader.domain.umeng.UmengAgent;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.deprecatedDkTextView;
import com.duokan.reader.ui.general.ja;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.State;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class UmengManager implements IActivityLifecycleCallbacks {
    /* renamed from: a */
    static final /* synthetic */ boolean f1660a = (!UmengManager.class.desiredAssertionStatus());
    /* renamed from: b */
    private static UmengManager f1661b = null;
    /* renamed from: c */
    private final boolean f1662c;
    /* renamed from: d */
    private final DkApp f1663d;
    /* renamed from: e */
    private final LinkedList<Runnable> f1664e = new LinkedList();
    /* renamed from: f */
    private boolean f1665f;
    /* renamed from: g */
    private UmengAgent f1666g = null;
    /* renamed from: h */
    private ja f1667h = null;

    /* renamed from: com.duokan.reader.UmengManager$1 */
    class C04851 implements IOnAnr {
        /* renamed from: a */
        final /* synthetic */ UmengManager f1641a;

        C04851(UmengManager umengManager) {
            this.f1641a = umengManager;
        }

        public void onAnr() {
            try {
                State state = UThread.getCurrentThread().getState();
                if (state != State.NEW && state != State.RUNNABLE && state != State.TERMINATED) {
                    Writer stringWriter = new StringWriter();
                    PrintWriter printWriter = new PrintWriter(stringWriter);
                    for (Entry entry : aq.m883b()) {
                        Object obj;
                        Thread thread = (Thread) entry.getKey();
                        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry.getValue();
                        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                            if (stackTraceElement.toString().contains("duokan")) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj != null) {
                            printWriter.println(thread.toString());
                            for (StackTraceElement stackTraceElement2 : stackTraceElementArr) {
                                printWriter.print("\t");
                                printWriter.println(stackTraceElement2.toString());
                            }
                        }
                    }
                    printWriter.flush();
                    printWriter.close();
                    UmengManager.get().onEvent("M_ANR_V1");
                    UmengManager.get().reportError(stringWriter.toString());
                }
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: com.duokan.reader.UmengManager$2 */
    class C04862 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ UmengManager f1642a;

        C04862(UmengManager umengManager) {
            this.f1642a = umengManager;
        }

        public void run() {
        }
    }

    private UmengManager(DkApp dkApp, boolean z, boolean z2) {
        this.f1663d = dkApp;
        this.f1665f = z;
        this.f1662c = z2;
        this.f1663d.addActivityLifecycleMonitor(this);
        initMobclickAgent();
        if (!this.f1662c) {
            WebLog.init().setOnAnrListener(new C04851(this));
        }
    }

    public void setEnabled(boolean z) {
        if (this.f1665f != z) {
            this.f1665f = z;
            loadMobclickAgent();
        }
    }

    public void sendDelayedEvents() {
        runWhenLoaded(new C04862(this));
    }

    public static UmengManager get() {
        if (f1660a || f1661b != null) {
            return f1661b;
        }
        throw new AssertionError();
    }

    public static void startup(DkApp dkApp, boolean z, boolean z2) {
        if (!f1660a && f1661b != null) {
            throw new AssertionError();
        } else if (f1661b == null) {
            f1661b = new UmengManager(dkApp, z, z2);
        }
    }

    public void checkUpdateAuto(final Context context) {
        if (this.f1665f && C0559f.m2476b().m2485d()) {
            C0402d c0402d = new C0402d(context);
            c0402d.m2185a(new C0406h(this) {
                /* renamed from: b */
                final /* synthetic */ UmengManager f1644b;

                public void onUpdate(String str, String str2, boolean z) {
                    this.f1644b.showUpdateDialog(context, str, str2, z);
                }

                public void onNoUpdate() {
                }
            });
            c0402d.m2184a();
        }
    }

    public void checkUpdateManual(final Context context) {
        if (!this.f1665f) {
            return;
        }
        if (C0559f.m2476b().m2486e()) {
            if (this.f1667h == null) {
                this.f1667h = new ja(context);
            }
            this.f1667h.m10843a(context.getResources().getString(C0247i.general__shared__connect_to_server));
            this.f1667h.show();
            C0402d c0402d = new C0402d(context);
            c0402d.m2185a(new C0406h(this) {
                /* renamed from: b */
                final /* synthetic */ UmengManager f1646b;

                public void onUpdate(String str, String str2, boolean z) {
                    this.f1646b.f1667h.dismiss();
                    this.f1646b.showUpdateDialog(context, str, str2, z);
                }

                public void onNoUpdate() {
                    this.f1646b.f1667h.cancel();
                    be.m10286a(context, C0247i.general__update__is_latest, 0).show();
                }
            });
            c0402d.m2184a();
            return;
        }
        be.m10287a(context, context.getString(C0247i.report_no_network_error), 0).show();
    }

    public void detectUpdate(Context context, final Runnable runnable) {
        if (this.f1665f && C0559f.m2476b().m2486e()) {
            new C0402d(context, new C0406h(this) {
                /* renamed from: b */
                final /* synthetic */ UmengManager f1648b;

                public void onUpdate(String str, String str2, boolean z) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }

                public void onNoUpdate() {
                }
            }).m2184a();
        }
    }

    private void showUpdateDialog(final Context context, final String str, String str2, boolean z) {
        boolean z2;
        boolean z3 = true;
        ap c04906 = new ap(this, context) {
            /* renamed from: c */
            final /* synthetic */ UmengManager f1651c;

            protected void onOk() {
                super.onOk();
                be.m10286a(context, C0247i.general__update__start_update, 0).show();
                if (str != null && str.length() > 0) {
                    DownloadUtil.init(context).downloadAPK(str, this.f1651c.f1663d.getString(C0247i.general__update__downloading_dkreadker_apk));
                }
            }

            protected void onNo() {
                super.onNo();
            }
        };
        View inflate = LayoutInflater.from(context).inflate(C0245g.general__auto_update_content_view, null);
        BoxView boxView = (BoxView) inflate.findViewById(C0244f.general__auto_update_content__boxview);
        int i = context.getResources().getDisplayMetrics().heightPixels;
        boxView.setMaxHeight(i / 2);
        boxView.setMinimumHeight(i / 7);
        ((FrameScrollView) inflate.findViewById(C0244f.general__auto_update_content__scrollview)).setMaxOverScrollHeight(AnimUtils.getMaxOverScrollHeight(context));
        ((deprecatedDkTextView) inflate.findViewById(C0244f.general__auto_update_content__text)).setText(str2);
        c04906.setPrompt(C0247i.general__update__title);
        c04906.setExtraContentView(inflate);
        c04906.setOkLabelResid(C0247i.general__update__update_now);
        if (!z) {
            c04906.setNoLabel(C0247i.general__update__update_later);
        }
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        c04906.setCancelOnBack(z2);
        if (z) {
            z3 = false;
        }
        c04906.setCancelOnTouchOutside(z3);
        c04906.show();
    }

    public void onEvent(final String str) {
        runWhenLoaded(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ UmengManager f1653b;

            public void run() {
                this.f1653b.f1666g.onEvent(this.f1653b.f1663d, str);
            }
        });
    }

    public void onEvent(final String str, final String str2) {
        runWhenLoaded(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ UmengManager f1656c;

            public void run() {
                this.f1656c.f1666g.onEvent(this.f1656c.f1663d, str, str2);
            }
        });
    }

    public void onEvent(final String str, final HashMap<String, String> hashMap) {
        runWhenLoaded(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ UmengManager f1659c;

            public void run() {
                this.f1659c.f1666g.onEvent(this.f1659c.f1663d, str, hashMap);
            }
        });
    }

    public void reportError(final String str) {
        runWhenLoaded(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ UmengManager f1636b;

            public void run() {
                this.f1636b.f1666g.reportError(this.f1636b.f1663d, str);
            }
        });
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(final Activity activity) {
        runWhenLoaded(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ UmengManager f1638b;

            public void run() {
                this.f1638b.f1666g.onPause(activity);
            }
        });
    }

    public void onActivityResumed(final Activity activity) {
        runWhenLoaded(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ UmengManager f1640b;

            public void run() {
                this.f1640b.f1666g.onResume(activity);
            }
        });
    }

    public void onActivityDestroyed(Activity activity) {
    }

    private synchronized void runWhenLoaded(Runnable runnable) {
        if (loadMobclickAgent()) {
            runnable.run();
        } else {
            this.f1664e.add(runnable);
        }
    }

    private synchronized boolean loadMobclickAgent() {
        boolean z;
        if (this.f1666g != null) {
            z = true;
        } else if (!initMobclickAgent() || this.f1664e.isEmpty()) {
            z = false;
        } else {
            WebLog.init().c(LogLevel.INFO, "umeng", "send delayed events.");
            Iterator it = this.f1664e.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.f1664e.clear();
            z = true;
        }
        return z;
    }

    @SuppressLint({"NewApi"})
    private synchronized boolean initMobclickAgent() {
        boolean z = false;
        synchronized (this) {
            if (this.f1665f) {
                try {
                    this.f1666g = new MobclickAgentImpl();
                    this.f1666g.setDebugMode(this.f1662c);
                    z = true;
                } catch (Throwable th) {
                }
            }
        }
        return z;
    }
}
