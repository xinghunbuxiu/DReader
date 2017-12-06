package com.duokan.reader;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.duokan.core.app.IActivityLife;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.c;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.StackTracesInfo;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.FrameScrollView;
import com.duokan.core.ui.UTools;
import com.duokan.d.DownloadUtil;
import com.duokan.d.d;
import com.duokan.d.i;
import com.duokan.reader.domain.umeng.MobclickAgentImpl;
import com.duokan.reader.domain.umeng.UmengAgent;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.deprecatedDkTextView;
import com.duokan.reader.ui.general.jq;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.State;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class UmengManager implements IActivityLife {
    static final /* synthetic */ boolean a = (!UmengManager.class.desiredAssertionStatus());
    private static UmengManager b = null;
    private final boolean c;
    private final DkApp d;
    private final LinkedList e = new LinkedList();
    private boolean f;
    private UmengAgent g = null;
    private jq h = null;

    private UmengManager(DkApp dkApp, boolean z, boolean z2) {
        this.d = dkApp;
        this.f = z;
        this.c = z2;
        this.d.addActivityLifecycleMonitor(this);
        initMobclickAgent();
        if (!this.c) {
            WebLog.c().a(new c(this) {
                final /* synthetic */ UmengManager a;

                {
                    this.a = r1;
                }

                public void onAnr() {
                    try {
                        State state = TaskHandler.getThread().getState();
                        if (state != State.NEW && state != State.RUNNABLE && state != State.TERMINATED) {
                            Writer stringWriter = new StringWriter();
                            PrintWriter printWriter = new PrintWriter(stringWriter);
                            for (Entry entry : StackTracesInfo.b()) {
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
            });
        }
    }

    public void setEnabled(boolean z) {
        if (this.f != z) {
            this.f = z;
            loadMobclickAgent();
        }
    }

    public void sendDelayedEvents() {
        runWhenLoaded(new Runnable(this) {
            final /* synthetic */ UmengManager a;

            {
                this.a = r1;
            }

            public void run() {
            }
        });
    }

    public static UmengManager get() {
        if (a || b != null) {
            return b;
        }
        throw new AssertionError();
    }

    public static void startup(DkApp dkApp, boolean z, boolean z2) {
        if (!a && b != null) {
            throw new AssertionError();
        } else if (b == null) {
            b = new UmengManager(dkApp, z, z2);
        }
    }

    public void checkUpdateAuto(final Context context) {
        if (this.f && f.b().d()) {
            d dVar = new d(context);
            dVar.a(new i(this) {
                final /* synthetic */ UmengManager b;

                public void onUpdate(String str, String str2, boolean z) {
                    this.b.showUpdateDialog(context, str, str2, z);
                }

                public void onNoUpdate() {
                }
            });
            dVar.a();
        }
    }

    public void checkUpdateManual(final Context context) {
        if (!this.f) {
            return;
        }
        if (f.b().e()) {
            if (this.h == null) {
                this.h = new jq(context);
            }
            this.h.a(context.getResources().getString(com.duokan.b.i.general__shared__connect_to_server));
            this.h.show();
            d dVar = new d(context);
            dVar.a(new i(this) {
                final /* synthetic */ UmengManager b;

                public void onUpdate(String str, String str2, boolean z) {
                    this.b.h.dismiss();
                    this.b.showUpdateDialog(context, str, str2, z);
                }

                public void onNoUpdate() {
                    this.b.h.cancel();
                    be.a(context, com.duokan.b.i.general__update__is_latest, 0).show();
                }
            });
            dVar.a();
            return;
        }
        be.a(context, context.getString(com.duokan.b.i.report_no_network_error), 0).show();
    }

    public void detectUpdate(Context context, final Runnable runnable) {
        if (this.f && f.b().e()) {
            new d(context, new i(this) {
                final /* synthetic */ UmengManager b;

                public void onUpdate(String str, String str2, boolean z) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }

                public void onNoUpdate() {
                }
            }).a();
        }
    }

    private void showUpdateDialog(final Context context, final String str, String str2, boolean z) {
        boolean z2;
        boolean z3 = true;
        ap anonymousClass6 = new ap(this, context) {
            final /* synthetic */ UmengManager c;

            protected void onOk() {
                super.onOk();
                be.a(context, com.duokan.b.i.general__update__start_update, 0).show();
                if (str != null && str.length() > 0) {
                    DownloadUtil.downloadAPK(context).downloadAPK(str, this.c.d.getString(com.duokan.b.i.general__update__downloading_dkreadker_apk));
                }
            }

            protected void onNo() {
                super.onNo();
            }
        };
        View inflate = LayoutInflater.from(context).inflate(g.general__auto_update_content_view, null);
        BoxView boxView = (BoxView) inflate.findViewById(com.duokan.b.f.general__auto_update_content__boxview);
        int i = context.getResources().getDisplayMetrics().heightPixels;
        boxView.setMaxHeight(i / 2);
        boxView.setMinimumHeight(i / 7);
        ((FrameScrollView) inflate.findViewById(com.duokan.b.f.general__auto_update_content__scrollview)).setMaxOverScrollHeight(UTools.getMinimumHeight(context));
        ((deprecatedDkTextView) inflate.findViewById(com.duokan.b.f.general__auto_update_content__text)).setText(str2);
        anonymousClass6.setPrompt(com.duokan.b.i.general__update__title);
        anonymousClass6.setExtraContentView(inflate);
        anonymousClass6.setOkLabel(com.duokan.b.i.general__update__update_now);
        if (!z) {
            anonymousClass6.setNoLabel(com.duokan.b.i.general__update__update_later);
        }
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        anonymousClass6.setCancelOnBack(z2);
        if (z) {
            z3 = false;
        }
        anonymousClass6.setCancelOnTouchOutside(z3);
        anonymousClass6.show();
    }

    public void onEvent(final String str) {
        runWhenLoaded(new Runnable(this) {
            final /* synthetic */ UmengManager b;

            public void run() {
                this.b.g.onEvent(this.b.d, str);
            }
        });
    }

    public void onEvent(final String str, final String str2) {
        runWhenLoaded(new Runnable(this) {
            final /* synthetic */ UmengManager c;

            public void run() {
                this.c.g.onEvent(this.c.d, str, str2);
            }
        });
    }

    public void onEvent(final String str, final HashMap hashMap) {
        runWhenLoaded(new Runnable(this) {
            final /* synthetic */ UmengManager c;

            public void run() {
                this.c.g.onEvent(this.c.d, str, hashMap);
            }
        });
    }

    public void reportError(final String str) {
        runWhenLoaded(new Runnable(this) {
            final /* synthetic */ UmengManager b;

            public void run() {
                this.b.g.reportError(this.b.d, str);
            }
        });
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(final Activity activity) {
        runWhenLoaded(new Runnable(this) {
            final /* synthetic */ UmengManager b;

            public void run() {
                this.b.g.onPause(activity);
            }
        });
    }

    public void onActivityResumed(final Activity activity) {
        runWhenLoaded(new Runnable(this) {
            final /* synthetic */ UmengManager b;

            public void run() {
                this.b.g.onResume(activity);
            }
        });
    }

    public void onActivityDestroyed(Activity activity) {
    }

    private synchronized void runWhenLoaded(Runnable runnable) {
        if (loadMobclickAgent()) {
            runnable.run();
        } else {
            this.e.add(runnable);
        }
    }

    private synchronized boolean loadMobclickAgent() {
        boolean z;
        if (this.g != null) {
            z = true;
        } else if (!initMobclickAgent() || this.e.isEmpty()) {
            z = false;
        } else {
            WebLog.c().c(LogLevel.INFO, "umeng", "send delayed events.");
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.e.clear();
            z = true;
        }
        return z;
    }

    @SuppressLint({"NewApi"})
    private synchronized boolean initMobclickAgent() {
        boolean z = false;
        synchronized (this) {
            if (this.f) {
                try {
                    this.g = new MobclickAgentImpl();
                    this.g.setDebugMode(this.c);
                    z = true;
                } catch (Throwable th) {
                }
            }
        }
        return z;
    }
}
