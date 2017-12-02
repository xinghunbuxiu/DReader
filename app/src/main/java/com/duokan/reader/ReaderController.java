package com.duokan.reader;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.duokan.c.d;
import com.duokan.common.FileTypeRecognizer;
import com.duokan.common.FileTypeRecognizer.FileType;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.e;
import com.duokan.core.app.m;
import com.duokan.core.app.y;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ah;
import com.duokan.core.sys.s;
import com.duokan.core.sys.t;
import com.duokan.core.ui.cv;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.j;
import com.duokan.reader.ReaderEnv.BookShelfType;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkCloudMessageInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreBookDetailInfo;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.bookshelf.iy;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.domain.bookshelf.jv;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.bd;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage.ActionType;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.a;
import com.duokan.reader.ui.account.ShareEntranceController;
import com.duokan.reader.ui.account.ap;
import com.duokan.reader.ui.account.as;
import com.duokan.reader.ui.account.bv;
import com.duokan.reader.ui.bookshelf.ay;
import com.duokan.reader.ui.bookshelf.ej;
import com.duokan.reader.ui.bookshelf.gx;
import com.duokan.reader.ui.bookshelf.hb;
import com.duokan.reader.ui.f;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.cm;
import com.duokan.reader.ui.general.jq;
import com.duokan.reader.ui.general.web.StorePageController;
import com.duokan.reader.ui.general.web.kk;
import com.duokan.reader.ui.p;
import com.duokan.reader.ui.r;
import com.duokan.reader.ui.reading.qh;
import com.duokan.reader.ui.reading.sh;
import com.duokan.reader.ui.store.al;
import com.duokan.reader.ui.store.o;
import com.duokan.reader.ui.welcome.DkTipManager;

import org.apache.http.HttpStatus;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class ReaderController extends e implements ReaderFeature, SystemUiConditioner {
    private static boolean a = true;
    private final a b;
    private final f c;
    private final LinkedList d;
    private final LinkedList e;
    private Runnable f;
    private Runnable g;
    private Toast h;
    private boolean i;
    private boolean j;
    private NightLayer k;
    private boolean l;
    private e m;
    private long n;
    private long o;
    private j p;
    private final boolean q;
    private p r;
    private qh s;
    private final r t;

    interface Switcher {
        void doSwitch(Runnable runnable);
    }

    class HomeSwitcher implements Switcher {
        final /* synthetic */ ReaderController a;

        private HomeSwitcher(ReaderController readerController) {
            this.a = readerController;
        }

        public void doSwitch(final Runnable runnable) {
            if (this.a.s == null) {
                this.a.activate(this.a.r);
                t.b(runnable);
                return;
            }
            this.a.s.b(new Runnable(this) {
                final /* synthetic */ HomeSwitcher b;

                public void run() {
                    boolean z = ReaderEnv.get().forHd() || this.b.a.getActivity().getRequestedOrientation() == 1;
                    this.b.a.r.getContentView().setVisibility(0);
                    this.b.a.activate(this.b.a.r);
                    this.b.a.c.a(this.b.a.r.getContentView(), false);
                    this.b.a.c.a(this.b.a.s.getContentView(), true);
                    this.b.a.s.getContentView().setVisibility(8);
                    Runnable anonymousClass1 = new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            this.a.b.a.deactivate(this.a.b.a.s);
                            this.a.b.a.s.p();
                            this.a.b.a.c.a(this.a.b.a.s.getContentView(), false);
                            this.a.b.a.c.removeView(this.a.b.a.s.getContentView());
                            this.a.b.a.removeSubController(this.a.b.a.s);
                            this.a.b.a.s = null;
                            t.b(runnable);
                        }
                    };
                    if (z) {
                        this.b.a.startReadingOutAnim(anonymousClass1);
                    } else {
                        anonymousClass1.run();
                    }
                }
            });
        }
    }

    class NightLayer extends cv {
        final /* synthetic */ ReaderController a;

        public NightLayer(ReaderController readerController, Context context) {
            this.a = readerController;
            super(context, true);
            View view = new View(context);
            view.setBackgroundColor(Color.argb(Math.round(158.1f), 0, 0, 0));
            setContentView(view);
        }

        public void showSmoothly() {
            show();
            dv.a(getContentView(), 0.0f, 1.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, false, null);
        }

        public void dismissSmoothly() {
            dv.a(getContentView(), 1.0f, 0.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, true, new Runnable(this) {
                final /* synthetic */ NightLayer a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.dismiss();
                }
            });
        }
    }

    class NullSwitcher implements Switcher {
        final /* synthetic */ ReaderController a;

        private NullSwitcher(ReaderController readerController) {
            this.a = readerController;
        }

        public void doSwitch(Runnable runnable) {
            t.b(runnable);
        }
    }

    class ReadingSwitcher implements Switcher {
        final /* synthetic */ ReaderController a;
        private final c b;
        private final com.duokan.reader.domain.document.a c;

        public ReadingSwitcher(ReaderController readerController, c cVar, com.duokan.reader.domain.document.a aVar) {
            this.a = readerController;
            this.b = cVar;
            this.c = aVar;
        }

        public void doSwitch(final Runnable runnable) {
            boolean z = true;
            if (this.a.s == null) {
                this.a.s = BookOpener.with(this.a.getContext()).open(this.b, this.c, new ErrorHandler(this) {
                    final /* synthetic */ ReadingSwitcher b;

                    public void onError(String str) {
                        this.b.a.prompt(str);
                        t.b(runnable);
                    }
                });
                if (this.a.s != null) {
                    this.a.addSubController(this.a.s);
                    this.a.c.addView(this.a.s.getContentView(), 1);
                    if (this.a.r != null) {
                        if (!(ReaderEnv.get().forHd() || this.a.getActivity().getRequestedOrientation() == 1) || this.a.r.getContentView().isLayoutRequested()) {
                            z = false;
                        }
                        this.a.c.a(this.a.r.getContentView(), z);
                        this.a.r.getContentView().setVisibility(8);
                    } else {
                        z = false;
                    }
                    this.a.activate(this.a.s);
                    dv.a(this.a.s.getContentView(), new Runnable(this) {
                        final /* synthetic */ ReadingSwitcher c;

                        public void run() {
                            Runnable anonymousClass1 = new Runnable(this) {
                                final /* synthetic */ AnonymousClass4 a;

                                {
                                    this.a = r1;
                                }

                                public void run() {
                                    ai.a().b(this.a.c.b);
                                    if (this.a.c.a.r != null) {
                                        this.a.c.a.deactivate(this.a.c.a.r);
                                        this.a.c.a.r.runAfterActive(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass1 a;

                                            {
                                                this.a = r1;
                                            }

                                            public void run() {
                                                if (ReaderEnv.get().getBookShelfType() == BookShelfType.Simple && (this.a.a.c.a.r instanceof com.duokan.reader.ui.surfing.f)) {
                                                    ((com.duokan.reader.ui.surfing.f) this.a.a.c.a.r).a(this.a.a.c.b);
                                                }
                                            }
                                        });
                                    }
                                    t.b(runnable);
                                }
                            };
                            this.c.a.s.getContentView().setVisibility(0);
                            if (!z || this.c.a.r == null) {
                                anonymousClass1.run();
                            } else {
                                this.c.a.startReadingInAnim(anonymousClass1);
                            }
                        }
                    });
                }
            } else if (this.a.s.n().H().equals(this.b.H())) {
                this.a.s.a(null);
                if (this.c != null) {
                    this.a.s.o().a(this.c);
                    com.duokan.core.sys.j.a(new s(this) {
                        final /* synthetic */ ReadingSwitcher b;

                        public boolean idleRun() {
                            t.b(runnable);
                            return false;
                        }
                    });
                    return;
                }
                t.b(runnable);
            } else {
                new HomeSwitcher().doSwitch(new Runnable(this) {
                    final /* synthetic */ ReadingSwitcher b;

                    public void run() {
                        this.b.doSwitch(runnable);
                    }
                });
            }
        }
    }

    public ReaderController(final y yVar, final c cVar) {
        this(yVar, false);
        this.c.setBackgroundColor(-1);
        DkApp.get().runWhenAppReady(new Runnable(this) {
            final /* synthetic */ ReaderController c;

            public void run() {
                this.c.c.setBackgroundColor(-16777216);
                this.c.r = this.c.sceneForBook(yVar, cVar);
                if (this.c.r instanceof qh) {
                    this.c.s = (qh) this.c.r;
                    this.c.r.a(1);
                }
                this.c.setupFirstScene();
            }
        });
    }

    public ReaderController(y yVar, Uri uri) {
        this(yVar, false);
        this.r = new kk(yVar, uri);
        this.r.a(1);
        this.l = true;
        setupFirstScene();
    }

    public ReaderController(y yVar) {
        this(yVar, true);
    }

    private ReaderController(y yVar, boolean z) {
        super(yVar);
        this.d = new LinkedList();
        this.e = new LinkedList();
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = false;
        this.k = null;
        this.l = false;
        this.m = null;
        this.n = -1;
        this.o = 0;
        this.r = null;
        this.s = null;
        this.t = new r(this) {
            final /* synthetic */ ReaderController a;

            {
                this.a = r1;
            }

            public int getPageHeaderHeight() {
                if (getPageHeaderPaddingTop() == 0) {
                    return this.a.getResources().getDimensionPixelSize(com.duokan.c.e.general__shared__page_header_height) - dv.b(this.a.getContext(), 15.0f);
                }
                return this.a.getResources().getDimensionPixelSize(com.duokan.c.e.general__shared__page_header_height);
            }

            public int getPageHeaderPaddingTop() {
                return this.a.b.getStatusBarHeight();
            }

            public int getHeaderPaddingTop() {
                return this.a.b.getStatusBarHeight();
            }

            public int getPagePaddingBottom() {
                return 0;
            }
        };
        this.q = a;
        a = false;
        getContext().registerGlobalFeature(this);
        this.b = new a(getActivity());
        this.c = new f(getContext());
        this.b.setContentView(this.c);
        this.b.setBackgroundColor(-16777216);
        setContentView(this.b);
        getContext().a(new DkTipManager(getContext(), this.c));
        if (z) {
            this.r = new com.duokan.reader.ui.surfing.f(getContext(), this.q);
            setupFirstScene();
        }
    }

    public void navigate(final Intent intent) {
        runAfterActive(new Runnable(this) {
            final /* synthetic */ ReaderController b;

            public void run() {
                this.b.pendSwitch(new NullSwitcher(), new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        this.a.b.handleIntent(intent);
                    }
                });
            }
        });
    }

    public void chooseStatusBarStyle(af afVar) {
        afVar.a(Boolean.valueOf(true));
    }

    public void chooseNavigationBarMode(af afVar) {
        if (getActivity().hasWindowFocus()) {
            afVar.a(SystemUiMode.DOCK);
        }
    }

    public void chooseNavigationBarColor(af afVar) {
        if (ReaderEnv.get().onMiui()) {
            afVar.a(Integer.valueOf(-1));
        }
    }

    public r getTheme() {
        return this.t;
    }

    public boolean pushPage(e eVar) {
        e activeScene = activeScene();
        activate(activeScene);
        return activeScene.pushPage(eVar);
    }

    public boolean pushPageSmoothly(e eVar, Runnable runnable) {
        e activeScene = activeScene();
        activate(activeScene);
        return activeScene.pushPageSmoothly(eVar, runnable);
    }

    public boolean pushHalfPage(e eVar) {
        e activeScene = activeScene();
        activate(activeScene);
        return activeScene.a(eVar);
    }

    public boolean pushHalfPageSmoothly(e eVar, Runnable runnable) {
        e activeScene = activeScene();
        activate(activeScene);
        return activeScene.a(eVar, runnable);
    }

    public boolean pushFloatingPage(e eVar) {
        e activeScene = activeScene();
        activate(activeScene);
        return activeScene.b(eVar);
    }

    public boolean pushFloatingPageSmoothly(e eVar, Runnable runnable) {
        e activeScene = activeScene();
        activate(activeScene);
        return activeScene.b(eVar, runnable);
    }

    public boolean showPopup(e eVar) {
        e activeScene = activeScene();
        activate(activeScene);
        return activeScene.showPopup(eVar);
    }

    public boolean showPopup(e eVar, int i, int i2) {
        e activeScene = activeScene();
        activate(activeScene);
        return activeScene.showPopup(eVar, i, i2);
    }

    public boolean showPopupSmoothly(e eVar, Runnable runnable) {
        e activeScene = activeScene();
        activate(activeScene);
        return activeScene.showPopupSmoothly(eVar, runnable);
    }

    public boolean navigateSmoothly(String str) {
        return navigate(str, null, true, null);
    }

    public boolean navigateSmoothly(String str, Runnable runnable) {
        return navigate(str, null, true, runnable);
    }

    public boolean navigate(String str, Object obj, final boolean z, final Runnable runnable) {
        final String toLowerCase = str.toLowerCase(Locale.US);
        com.duokan.core.diagnostic.a c = com.duokan.core.diagnostic.a.c();
        LogLevel logLevel = LogLevel.EVENT;
        String str2 = "nav";
        String str3 = "navigate to %s(params: %s)";
        Object[] objArr = new Object[2];
        objArr[0] = toLowerCase;
        objArr[1] = obj == null ? "null" : obj.toString();
        c.a(logLevel, str2, str3, objArr);
        if (DkRouter.from(this).route(toLowerCase)) {
            return true;
        }
        if (toLowerCase.startsWith("http://") || toLowerCase.startsWith("https://")) {
            goHome(new Runnable(this) {
                final /* synthetic */ ReaderController d;

                public void run() {
                    com.duokan.reader.ui.t tVar = (com.duokan.reader.ui.t) this.d.getContext().queryFeature(com.duokan.reader.ui.t.class);
                    e storePageController = new StorePageController(this.d.getContext());
                    storePageController.loadUrl(toLowerCase);
                    if (z) {
                        tVar.pushPageSmoothly(storePageController, runnable);
                        return;
                    }
                    tVar.pushPage(storePageController);
                    t.b(runnable);
                }
            });
            return true;
        }
        Uri parse = Uri.parse(toLowerCase);
        if (!TextUtils.equals(parse.getScheme(), "duokan-reader") || toLowerCase.length() <= "duokan-reader://".length()) {
            return false;
        }
        toLowerCase = toLowerCase.substring("duokan-reader://".length());
        p activeScene = activeScene();
        if (activeScene != null) {
            activeScene.h();
        }
        Object lastPathSegment = parse.getLastPathSegment();
        if (!TextUtils.equals(parse.getHost(), "reading") || TextUtils.isEmpty(lastPathSegment)) {
            if (z) {
                final Object obj2 = obj;
                final boolean z2 = z;
                final Runnable runnable2 = runnable;
                goHome(new Runnable(this) {
                    final /* synthetic */ ReaderController e;

                    public void run() {
                        this.e.r.navigate(toLowerCase, obj2, z2, runnable2);
                    }
                });
            } else {
                this.r.navigate(toLowerCase, obj, z, runnable);
                goHome(null);
            }
        } else if (TextUtils.equals(lastPathSegment, "recently") && !TextUtils.isEmpty(ReaderEnv.get().getReadingBookUuid())) {
            r0 = ai.a().b(ReaderEnv.get().getReadingBookUuid());
            if (r0 != null) {
                openBook(r0);
            }
        } else if (!TextUtils.isEmpty(lastPathSegment)) {
            r0 = ai.a().b((String) lastPathSegment);
            if (r0 != null) {
                if (r0.s() != BookPackageType.EPUB_OPF && r0.o() != BookType.SERIAL && !r0.R()) {
                    return true;
                }
                openBook(r0);
            }
        }
        return true;
    }

    public int getScreenTimeout() {
        return getDkActivity().getScreenTimeout();
    }

    public void setScreenTimeout(int i) {
        getDkActivity().setScreenTimeout(i);
    }

    public BrightnessMode getScreenBrightnessMode() {
        return getDkActivity().getScreenBrightnessMode();
    }

    public void setScreenBrightnessMode(BrightnessMode brightnessMode) {
        getDkActivity().setScreenBrightnessMode(brightnessMode);
    }

    public float[] getScreenBrightnessRange() {
        return new float[]{0.02f, 1.0f};
    }

    public float getScreenBrightness() {
        return getDkActivity().getScreenBrightness();
    }

    public void setScreenBrightness(float f) {
        getDkActivity().setScreenBrightness(f);
    }

    public BrightnessMode getKeyboardBrightnessMode() {
        return getDkActivity().getKeyboardBrightnessMode();
    }

    public void setKeyboardBrightnessMode(BrightnessMode brightnessMode) {
        getDkActivity().setKeyboardBrightnessMode(brightnessMode);
    }

    public float getKeyboardBrightness() {
        return getDkActivity().getKeyboardBrightness();
    }

    public void setKeyboardBrightness(float f) {
        getDkActivity().setKeyboardBrightness(f);
    }

    public void switchNightMode(boolean z, boolean z2) {
        if (inNightMode() != z) {
            if (z) {
                if (this.k == null) {
                    this.k = new NightLayer(this, getContext());
                    if (z2) {
                        this.k.showSmoothly();
                    } else {
                        this.k.show();
                    }
                }
            } else if (this.k != null) {
                if (z2) {
                    this.k.dismissSmoothly();
                } else {
                    this.k.dismiss();
                }
                this.k = null;
            }
            ReaderEnv.get().setPrefBoolean(PrivatePref.GLOBAL, "night_mode", z);
            ReaderEnv.get().commitPrefs();
        }
    }

    public boolean inNightMode() {
        return this.k != null;
    }

    public void switchEyesSavingMode(boolean z) {
        this.j = z;
        if (this.j) {
            cv.setRgbDensity(1.0f, 0.98f, 0.9f);
            this.c.a(1.0f, 0.98f, 0.9f);
            return;
        }
        cv.setRgbDensity(1.0f, 1.0f, 1.0f);
        this.c.a(1.0f, 1.0f, 1.0f);
    }

    public float[] getEyesSavingModeDensity() {
        if (this.j) {
            return new float[]{1.0f, 0.98f, 0.9f};
        }
        return new float[]{1.0f, 1.0f, 1.0f};
    }

    public Drawable getHeaderBackground() {
        return new ColorDrawable(getResources().getColor(d.general__shared__page_header_background));
    }

    public c getReadingBook() {
        return this.s != null ? this.s.n() : null;
    }

    public sh getReadingFeature() {
        return this.s != null ? this.s.o() : null;
    }

    public void addSystemUiConditioner(SystemUiConditioner systemUiConditioner) {
        this.e.addFirst(systemUiConditioner);
        updateSystemUi(false);
    }

    public void removeSystemUiConditioner(SystemUiConditioner systemUiConditioner) {
        this.e.remove(systemUiConditioner);
        updateSystemUi(false);
    }

    public void updateSystemUi(boolean z) {
        if (!z) {
            pendSystemUiUpdate();
        } else if (this.g != null) {
            this.g.run();
        } else {
            applySystemUi();
        }
    }

    public void prompt(String str) {
        prompt(str, 0);
    }

    public void prompt(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (this.h == null) {
                this.h = be.a(getContext(), (CharSequence) str, i);
            }
            this.h.setText(str);
            this.h.show();
        }
    }

    public void openBook(c cVar) {
        openBook(cVar, null, null);
    }

    public void openBook(final c cVar, com.duokan.reader.domain.document.a aVar, Runnable runnable) {
        if (cVar != null) {
            if (cVar.s() == BookPackageType.EPUB_OPF) {
                switchToReading(cVar, aVar, runnable);
            } else if (cVar.o() == BookType.SERIAL) {
                switchToReading(cVar, aVar, runnable);
            } else if (cVar.V()) {
                if (cVar.U()) {
                    cVar.aa();
                } else {
                    ay.a(getContext(), cVar.C(), new cm(this) {
                        final /* synthetic */ ReaderController b;

                        public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
                            if (z) {
                                cVar.b(flowChargingTransferChoice.wifiOnly());
                            }
                        }
                    });
                }
            } else if (cVar.R()) {
                switchToReading(cVar, aVar, runnable);
            } else if (cVar.ai()) {
                if (cVar.i() != BookState.CLOUD_ONLY) {
                    ai.a().d(Arrays.asList(new c[]{cVar}));
                    be.a(getContext(), com.duokan.c.j.bookshelf__file_not_exist_and_download_again, 1).show();
                    return;
                }
                downloadBooks(cVar);
            } else if (!cVar.am()) {
                new ej(getContext()).a(cVar);
            } else if (cVar.i() != BookState.CLOUD_ONLY) {
                ai.a().d(Arrays.asList(new c[]{cVar}));
                be.a(getContext(), com.duokan.c.j.bookshelf__file_not_exist_and_download_again, 1).show();
            } else {
                downloadBooks(cVar);
            }
        }
    }

    public void openBook(String str, final com.duokan.reader.domain.document.a aVar) {
        c b = ai.a().b(str);
        if (b != null) {
            openBook(b, aVar, null);
            return;
        }
        String a = new com.duokan.reader.common.webservices.duokan.y(str).a();
        final jq jqVar = new jq(getContext());
        jqVar.show();
        if (a.length() >= 32) {
            com.duokan.reader.domain.store.a.a().a(a, false, new h(this) {
                final /* synthetic */ ReaderController c;

                public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
                    jqVar.dismiss();
                    this.c.openBook(ai.a().a(dkStoreItem), aVar, null);
                }

                public void onFetchBookDetailError(String str) {
                    jqVar.dismiss();
                    ((ReaderFeature) this.c.getContext().queryFeature(ReaderFeature.class)).prompt(this.c.getString(com.duokan.c.j.general__shared__network_error));
                }
            });
        } else {
            com.duokan.reader.domain.store.a.a().b(a, true, new h(this) {
                final /* synthetic */ ReaderController c;

                public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
                    jqVar.dismiss();
                    this.c.openBook(ai.a().a((DkStoreFictionDetail) dkStoreItem), aVar, null);
                }

                public void onFetchBookDetailError(String str) {
                    jqVar.dismiss();
                    ((ReaderFeature) this.c.getContext().queryFeature(ReaderFeature.class)).prompt(this.c.getString(com.duokan.c.j.general__shared__network_error));
                }
            });
        }
    }

    public void shareBooks(e eVar, c... cVarArr) {
        if (eVar != null && cVarArr != null) {
            if (this.m != null) {
                eVar.deactivate(this.m);
                eVar.removeSubController(this.m);
            }
            if (cVarArr.length != 1 || cVarArr[0].ai()) {
                String aw;
                String string;
                if (cVarArr.length == 1) {
                    aw = cVarArr[0].aw();
                } else {
                    aw = String.format(getString(com.duokan.c.j.share__book_to_weixin_multi_title), new Object[]{Integer.valueOf(cVarArr.length)});
                }
                if (cVarArr.length == 1) {
                    string = getString(com.duokan.c.j.share__book_to_weixin_single);
                } else {
                    string = getString(com.duokan.c.j.share__book_to_weixin_multi);
                }
                String str = "";
                final List arrayList = new ArrayList();
                final List arrayList2 = new ArrayList();
                String str2 = string;
                int i = 0;
                while (i < cVarArr.length) {
                    c cVar = cVarArr[i];
                    if (i == 0) {
                        str = cVar.g();
                    }
                    arrayList.add(cVar.H());
                    arrayList2.add(cVar.G().c);
                    if (cVarArr.length > 1) {
                        if (i < 5) {
                            str2 = str2 + String.format(getString(com.duokan.c.j.general__shared__book_title_marks), new Object[]{cVar.aw()});
                            if (i < cVarArr.length - 1 && i < 4) {
                                str2 = str2 + "、";
                            }
                        } else if (i == 5) {
                            str2 = str2 + "...";
                        }
                    }
                    i++;
                }
                final e eVar2 = eVar;
                new ap(getContext(), false, new as(this) {
                    final /* synthetic */ ReaderController g;

                    public void onChoiced(String str) {
                        if (!TextUtils.isEmpty(str)) {
                            this.g.m = new bv(this.g.getContext(), true, str, "", aw, str2, str, (String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0]), null);
                            eVar2.addSubController(this.g.m);
                            eVar2.activate(this.g.m);
                        }
                    }
                }).show();
                return;
            }
            c cVar2 = cVarArr[0];
            this.m = new ShareEntranceController(getContext(), cVar2.t().f, cVar2, null);
            eVar.addSubController(this.m);
            eVar.activate(this.m);
        }
    }

    public void downloadBooks(final c... cVarArr) {
        com.duokan.reader.common.webservices.duokan.c anonymousClass10 = new com.duokan.reader.common.webservices.duokan.c(this) {
            final /* synthetic */ ReaderController b;
            private jq c = null;
            private boolean d = false;
            private LinkedList e = new LinkedList();
            private long f = 0;
            private boolean g = false;

            protected void onSessionOpen() {
                this.d = com.duokan.reader.common.c.f.b().d();
                this.c = new jq(this.b.getContext());
                this.c.open(new com.duokan.core.app.d(this) {
                    final /* synthetic */ AnonymousClass10 a;

                    {
                        this.a = r1;
                    }

                    public void onCancel(com.duokan.core.app.c cVar) {
                        this.a.g = true;
                        this.a.close();
                        this.a.c.dismiss();
                    }
                });
            }

            protected void onSessionTry() {
                for (c cVar : cVarArr) {
                    if (cVar.S()) {
                        AnonymousClass1DownloadInfo anonymousClass1DownloadInfo = new Object(this.b) {
                            public c a = null;
                            public DkStoreBookDetail b = null;
                            final /* synthetic */ ReaderController c;

                            {
                                this.c = r2;
                            }
                        };
                        anonymousClass1DownloadInfo.a = cVar;
                        if (cVar.j()) {
                            for (av e : ((fv) cVar).e(this.d)) {
                                this.f += (long) e.e();
                            }
                            this.e.add(anonymousClass1DownloadInfo);
                        } else if (cVar.k()) {
                            this.e.add(anonymousClass1DownloadInfo);
                        } else if (cVar.ai()) {
                            b a = new v(this, null).a(cVar.H(), false);
                            this.f += ((DkStoreBookDetailInfo) a.a).mEpubSize;
                            anonymousClass1DownloadInfo.b = new DkStoreBookDetail((DkStoreBookDetailInfo) a.a);
                            this.e.add(anonymousClass1DownloadInfo);
                        } else if (cVar.am()) {
                            this.f += cVar.ak().a().j();
                            this.e.add(anonymousClass1DownloadInfo);
                        }
                    }
                }
            }

            protected void onSessionSucceeded() {
                this.c.dismiss();
                if (!this.g && this.e.size() >= 1) {
                    ay.a(this.b.getActivity(), this.f, new cm(this) {
                        final /* synthetic */ AnonymousClass10 a;

                        {
                            this.a = r1;
                        }

                        public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
                            if (z) {
                                Iterator it = this.a.e.iterator();
                                while (it.hasNext()) {
                                    AnonymousClass1DownloadInfo anonymousClass1DownloadInfo = (AnonymousClass1DownloadInfo) it.next();
                                    final c cVar = anonymousClass1DownloadInfo.a;
                                    if (cVar != null) {
                                        if (cVar.X()) {
                                            cVar.b(flowChargingTransferChoice.wifiOnly());
                                        } else if (cVar.j()) {
                                            com.duokan.reader.domain.statistics.dailystats.a.d().c(cVar.H(), cVar.G().c);
                                            cVar.b(flowChargingTransferChoice.wifiOnly());
                                        } else if (cVar.k()) {
                                            List bn;
                                            if (cVar.l()) {
                                                bn = ((jv) cVar).bn();
                                            } else {
                                                bn = ((fv) cVar).bn();
                                            }
                                            cVar.a(cVar.f(), "dkcloud:///fiction/" + cVar.H() + "#" + aa.a((String[]) bn.toArray(new String[0])), "", "", false, new af(Boolean.valueOf(false)));
                                        } else if (cVar.ai()) {
                                            DkCloudPurchasedBook a = DkUserPurchasedBooksManager.a().a(cVar.H());
                                            if (a == null) {
                                                DkStoreBookDetail dkStoreBookDetail = anonymousClass1DownloadInfo.b;
                                                if (dkStoreBookDetail != null) {
                                                    if (bd.a().b().a > System.currentTimeMillis()) {
                                                        cVar.a(cVar.f(), dkStoreBookDetail.getEpubUri(), dkStoreBookDetail.getRevision(), dkStoreBookDetail.getEpubMd5(), false, flowChargingTransferChoice.wifiOnly());
                                                    } else {
                                                        ai.a().a(cVar, true);
                                                        ai.a().a(dkStoreBookDetail, flowChargingTransferChoice.wifiOnly());
                                                    }
                                                }
                                            } else if (!o.a().a(cVar.H())) {
                                                o.a().b(cVar.H());
                                                o.a().a(a.getBookUuid(), anonymousClass1DownloadInfo.b, new al(this) {
                                                    final /* synthetic */ AnonymousClass2 b;

                                                    public void onDownloadCloudBookStarted() {
                                                        o.a().c(cVar.H());
                                                    }

                                                    public void onDownloadCloudBookError(String str) {
                                                        o.a().c(cVar.H());
                                                        if (!TextUtils.isEmpty(str)) {
                                                            be.a(this.b.a.b.getContext(), (CharSequence) str, 1).show();
                                                        }
                                                    }

                                                    public void onDownloadCloudBookCanceled() {
                                                        o.a().c(cVar.H());
                                                    }
                                                }, flowChargingTransferChoice);
                                            }
                                        } else if (cVar.am()) {
                                            iy a2 = iz.a().a(cVar.ap());
                                            if (a2 != null) {
                                                ai.a().a(cVar, a2, flowChargingTransferChoice.wifiOnly());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    });
                }
            }

            protected void onSessionFailed() {
                this.c.dismiss();
                ((ReaderFeature) this.b.getContext().queryFeature(ReaderFeature.class)).prompt(this.b.getString(com.duokan.c.j.general__shared__network_error));
            }
        };
        if (com.duokan.reader.common.c.f.b().e()) {
            anonymousClass10.open();
        } else {
            be.a(getContext(), getString(com.duokan.c.j.general__shared__network_error), 0).show();
        }
    }

    public void goHome(Runnable runnable) {
        if (this.r instanceof com.duokan.reader.ui.surfing.f) {
            switchToHome(runnable);
        } else if (this.r instanceof qh) {
            pendSwitch(new Switcher(this) {
                final /* synthetic */ ReaderController a;

                {
                    this.a = r1;
                }

                public void doSwitch(Runnable runnable) {
                    ((qh) this.a.r).b(new Runnable(this) {
                        final /* synthetic */ AnonymousClass11 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            if (!this.a.a.l) {
                                Intent intent = new Intent();
                                intent.setAction("com.duokan.reader.actions.SHOW_BOOKSHELF");
                                intent.setComponent(new ComponentName(DkApp.get(), DkApp.get().getReaderActivityClass()));
                                this.a.a.getContext().startActivity(intent);
                            }
                            DkApp.get().getTopActivity().finish();
                        }
                    });
                }
            }, null);
        } else {
            DkApp.get().getTopActivity().finish();
        }
    }

    public void showBookHomePage(y yVar, String str, String str2, boolean z, String str3) {
        com.duokan.reader.ui.store.bv.a(yVar, str, str2, str3, z);
    }

    public void showMenuFromBottom(final hb hbVar) {
        showPopup(hbVar);
        dv.a(hbVar.a(), 0.0f, 0.0f, 1.0f, 0.0f, HttpStatus.SC_OK, true, new Runnable(this) {
            final /* synthetic */ ReaderController b;

            public void run() {
                hbVar.a(true);
            }
        });
        dv.a(hbVar.b(), 0.0f, 1.0f, HttpStatus.SC_OK, true, null);
    }

    public void showMenuFromTop(final gx gxVar) {
        showPopup(gxVar);
        dv.a(gxVar.a(), 0.0f, 0.0f, -1.0f, 0.0f, HttpStatus.SC_OK, true, new Runnable(this) {
            final /* synthetic */ ReaderController b;

            public void run() {
                gxVar.a(true);
            }
        });
        dv.a(gxVar.b(), 0.0f, 1.0f, (int) HttpStatus.SC_OK, true, null);
    }

    public long getTotalActiveTime() {
        if (this.n <= 0) {
            return this.o;
        }
        return (this.o + System.currentTimeMillis()) - this.n;
    }

    public int getPageCount() {
        if (this.s != null && this.s.isActive()) {
            return this.s.g();
        }
        if (this.r == null || !this.r.isActive()) {
            return 0;
        }
        return this.r.g();
    }

    public void setQuitOnBack(boolean z) {
        this.l = z;
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        addSystemUiConditioner(this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        removeSystemUiConditioner(this);
        getContext().unregisterGlobalFeature(this);
        giveUpMonitoringSystemUiVisibilityChange();
    }

    @TargetApi(11)
    protected void onActive(boolean z) {
        int s = PersonalPrefs.a().s();
        if (s - ReaderEnv.get().getLastUseDay() == 1) {
            ReaderEnv.get().setUseDays(ReaderEnv.get().getUseDays() + 1);
        } else if (s - ReaderEnv.get().getLastUseDay() != 0) {
            ReaderEnv.get().setUseDays(1);
        }
        ReaderEnv.get().setLastUseDay(s);
        this.n = System.currentTimeMillis();
        if (z) {
            com.duokan.reader.domain.statistics.a.k().a("main", 2);
            ReaderEnv.get().setAppActivated();
            switchNightMode(ReaderEnv.get().getPrefBoolean(PrivatePref.GLOBAL, "night_mode", false), false);
            monitorSystemUiVisibilityChange();
        }
    }

    protected void onDeactive() {
        super.onDeactive();
        this.o += System.currentTimeMillis() - this.n;
        this.n = -1;
        UmengManager.get().sendDelayedEvents();
    }

    @SuppressLint({"NewApi"})
    private void monitorSystemUiVisibilityChange() {
        if (VERSION.SDK_INT >= 14) {
            getActivity().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener(this) {
                final /* synthetic */ ReaderController a;

                {
                    this.a = r1;
                }

                @SuppressLint({"NewApi"})
                public void onSystemUiVisibilityChange(int i) {
                    this.a.updateSystemUi(false);
                }
            });
        }
    }

    @SuppressLint({"NewApi"})
    private void giveUpMonitoringSystemUiVisibilityChange() {
        if (VERSION.SDK_INT >= 14) {
            getActivity().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
        }
    }

    protected boolean onBack() {
        if (this.l || this.i) {
            return false;
        }
        this.i = true;
        prompt(getString(com.duokan.c.j.exit_prompt));
        runLater(new Runnable(this) {
            final /* synthetic */ ReaderController a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.i = false;
            }
        }, 2000);
        return true;
    }

    protected boolean onRequestDetach(e eVar) {
        if (eVar != null && eVar == this.s) {
            goHome(null);
            return true;
        } else if (eVar == null || eVar != this.r || !this.l) {
            return super.onRequestDetach(eVar);
        } else {
            getActivity().finish();
            return true;
        }
    }

    protected void onWindowFocusChanged(boolean z) {
        updateSystemUi(true);
    }

    private void setupFirstScene() {
        com.duokan.core.diagnostic.a.c().b(this.r != null);
        this.c.addView(this.r.getContentView(), 0);
        addSubController(this.r);
        if ((this.r instanceof com.duokan.reader.ui.surfing.f) && ReaderEnv.get().isFreshInstall() && PersonalPrefs.a().g() == -1) {
            com.duokan.core.diagnostic.a.c().a("welcome_timer");
            this.p = new com.duokan.reader.ui.surfing.a(getContext(), new Runnable(this) {
                final /* synthetic */ ReaderController a;

                {
                    this.a = r1;
                }

                public void run() {
                    com.duokan.reader.domain.statistics.a.k().a(com.duokan.core.diagnostic.a.c().a("welcome_timer"));
                    this.a.p = null;
                    this.a.activate(this.a.r);
                    if (this.a.r instanceof com.duokan.reader.ui.surfing.f) {
                        DkApp.get().runWhenAppReady(new Runnable(this) {
                            final /* synthetic */ AnonymousClass16 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                this.a.a.handleIntent(this.a.a.getActivity().getIntent());
                            }
                        });
                    }
                }
            });
            this.p.show();
            return;
        }
        activate(this.r);
        if (this.r instanceof com.duokan.reader.ui.surfing.f) {
            DkApp.get().runWhenAppReady(new Runnable(this) {
                final /* synthetic */ ReaderController a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.handleIntent(this.a.getActivity().getIntent());
                }
            });
        }
    }

    private void pendSystemUiUpdate() {
        if (this.g == null) {
            this.g = new Runnable(this) {
                final /* synthetic */ ReaderController a;

                {
                    this.a = r1;
                }

                public void run() {
                    if (this.a.g == this) {
                        this.a.applySystemUi();
                        this.a.g = null;
                    }
                }
            };
            com.duokan.core.sys.j.a(new s(this) {
                final /* synthetic */ ReaderController a;

                {
                    this.a = r1;
                }

                public boolean idleRun() {
                    if (this.a.g != null) {
                        this.a.g.run();
                    }
                    return false;
                }
            });
        }
    }

    private void applySystemUi() {
        af afVar = new af();
        af afVar2 = new af();
        af afVar3 = new af();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            SystemUiConditioner systemUiConditioner = (SystemUiConditioner) it.next();
            if (!afVar.b()) {
                systemUiConditioner.chooseStatusBarStyle(afVar);
            }
            if (!afVar2.b()) {
                systemUiConditioner.chooseNavigationBarMode(afVar2);
            }
            if (!afVar3.b()) {
                systemUiConditioner.chooseNavigationBarColor(afVar3);
            }
        }
        if (afVar.b()) {
            this.b.setStatusBarStyle(((Boolean) afVar.a()).booleanValue());
        }
        if (afVar2.b()) {
            this.b.setNavigationBarMode((SystemUiMode) afVar2.a());
        }
        if (afVar3.b()) {
            this.b.setNavigationBarColor(((Integer) afVar3.a()).intValue());
        }
    }

    private final void handleIntent(Intent intent) {
        com.duokan.core.diagnostic.a.c().b(DkApp.get().isReady());
        CharSequence action = intent.getAction();
        final Uri data = intent.getData();
        c a;
        if (!TextUtils.equals(action, "android.intent.action.MAIN")) {
            DkApp.get().setIsActivateFromLauncher(false);
            if (TextUtils.equals(action, "com.duokan.reader.actions.SHOW_BOOKSHELF")) {
                String str;
                if (intent.hasExtra("bookUuid")) {
                    str = "duokan-reader://bookshelf/#bookuuid_" + intent.getStringExtra("bookUuid");
                } else {
                    str = "duokan-reader://bookshelf";
                }
                com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "nav", "handle an intent(action: %s, uri: %s)", action, str);
                navigate(str, null, false, null);
            } else if (TextUtils.equals(action, "com.duokan.reader.actions.SHOW_RUNNING_DOWNLOAD_TASKS")) {
                com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "nav", "handle an intent(action: %s)", action);
            } else if (TextUtils.equals(action, "com.duokan.reader.actions.SHOW_PROMPT")) {
                String stringExtra = intent.getStringExtra("push_message_target");
                if (TextUtils.isEmpty(stringExtra)) {
                    com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "nav", "handle an intent(action: %s, msgId: null)", action);
                    navigate("duokan-reader://personal/message/notification", null, false, null);
                    return;
                }
                DkCloudPushMessage dkCloudPushMessage;
                com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "nav", "handle an intent(action: %s, msgId: %s)", action, stringExtra);
                Object stringExtra2 = intent.getStringExtra("push_server_message_id");
                Object stringExtra3 = intent.getStringExtra("raw_push_message");
                if (TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra3)) {
                    dkCloudPushMessage = null;
                } else {
                    try {
                        dkCloudPushMessage = new DkCloudPushMessage(stringExtra2, true, DkCloudMessageInfo.fromJson(new JSONObject(stringExtra3)));
                    } catch (Throwable th) {
                        dkCloudPushMessage = null;
                    }
                }
                if (dkCloudPushMessage == null) {
                    dkCloudPushMessage = com.duokan.reader.domain.cloud.push.b.a().a(stringExtra);
                }
                if (dkCloudPushMessage == null) {
                    com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "push", "push message not found, msgId: %s", stringExtra);
                    navigate("duokan-reader://personal/message/notification", null, false, null);
                } else if ((dkCloudPushMessage.getEndTime() == 0 || dkCloudPushMessage.getEndTime() > System.currentTimeMillis()) && !TextUtils.isEmpty(dkCloudPushMessage.getActionParamString())) {
                    com.duokan.reader.domain.cloud.push.b.a().b(dkCloudPushMessage.getCloudId());
                    if (dkCloudPushMessage.getMessageType() == ActionType.URL) {
                        navigate(dkCloudPushMessage.getActionUrl(), null, false, null);
                    } else {
                        navigate("duokan-reader://store/action/message", dkCloudPushMessage, false, null);
                    }
                } else {
                    navigate("duokan-reader://personal/message/notification", null, false, null);
                }
            } else if (TextUtils.equals(action, "com.duokan.reader.actions.OPEN_REPLY_MESSAGES")) {
                com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "nav", "handle an intent(action: %s)", action);
                navigate("duokan-reader://personal/message/feed", null, false, null);
            } else if (TextUtils.equals(action, "com.duokan.reader.actions.SHOW_STORE")) {
                int i;
                Bundle extras = intent.getExtras();
                if (extras == null || !extras.containsKey("storeIndex")) {
                    i = 1;
                } else {
                    i = extras.getInt("storeIndex");
                    if (i < 0 || i > 1) {
                        i = 1;
                    }
                }
                com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "nav", "handle an intent(action: %s, store: %d)", action, Integer.valueOf(i));
                switch (i) {
                    case 1:
                        navigate("duokan-reader://store", null, false, null);
                        return;
                    default:
                        navigate("duokan-reader://store", null, false, null);
                        return;
                }
            } else if (TextUtils.equals(action, "com.duokan.reader.actions.SHOW_FEEDBACK")) {
                com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "nav", "handle an intent(action: %s)", action);
                navigate("duokan-reader://personal/feedback", null, false, null);
            } else if ((TextUtils.equals(action, "android.intent.action.VIEW") || TextUtils.isEmpty(action)) && data != null) {
                String path = data.getPath();
                String scheme = data.getScheme();
                Map parseUri = DkRouter.parseUri(data);
                com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "nav", "handle an intent(action: %s, uri: %s)", action, data);
                if (!TextUtils.isEmpty((CharSequence) parseUri.get(ClientCookie.PATH_ATTR))) {
                    if (TextUtils.equals((CharSequence) parseUri.get("miback"), "true")) {
                        this.r.a(1);
                        this.l = true;
                    }
                    if (TextUtils.isEmpty((CharSequence) parseUri.get("simple-web"))) {
                        navigate((String) parseUri.get(ClientCookie.PATH_ATTR), parseUri.get("miref"), false, null);
                    }
                } else if ("duokan-reader".equalsIgnoreCase(scheme)) {
                    navigate(data.toString(), null, false, null);
                } else if (FileType.UNSUPPORTED == FileTypeRecognizer.a(path)) {
                    be.a(getContext(), com.duokan.c.j.general__shared__unkown_book_format, 1).show();
                } else if (com.duokan.core.b.a.a(data.toString(), "content", new String[0])) {
                    final jq jqVar = new jq(getContext());
                    jqVar.show();
                    ah.b(new Runnable(this) {
                        boolean a = false;
                        final /* synthetic */ ReaderController d;

                        public void run() {
                            try {
                                File file = new File(ReaderEnv.get().getLocalBookDirectory(), data.getLastPathSegment());
                                com.duokan.core.io.a.a(this.d.getContext().getContentResolver().openInputStream(data), file);
                                final c a = ai.a().a(file);
                                t.a(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass20 b;

                                    public void run() {
                                        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:80)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                                        /*
                                        r4 = this;
                                        r3 = 0;
                                        r0 = r0;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        if (r0 == 0) goto L_0x0013;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                    L_0x0005:
                                        r0 = r4.b;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        r0 = r0.d;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        r1 = r0;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        r0.openBook(r1);	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        r0 = r4.b;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        r1 = 1;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        r0.a = r1;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                    L_0x0013:
                                        r0 = r4.b;
                                        r0 = r0.a;
                                        if (r0 != 0) goto L_0x002a;
                                    L_0x0019:
                                        r0 = r4.b;
                                        r0 = r0.d;
                                        r0 = r0.getContext();
                                        r1 = com.duokan.c.j.bookshelf__shared__file_not_exist;
                                        r0 = com.duokan.reader.ui.general.be.a(r0, r1, r3);
                                        r0.show();
                                    L_0x002a:
                                        r0 = r4.b;
                                        r0 = r0;
                                        r0 = r0.isShowing();
                                        if (r0 == 0) goto L_0x003b;
                                    L_0x0034:
                                        r0 = r4.b;
                                        r0 = r0;
                                        r0.dismiss();
                                    L_0x003b:
                                        return;
                                    L_0x003c:
                                        r0 = move-exception;
                                        r0 = r4.b;
                                        r0 = r0.a;
                                        if (r0 != 0) goto L_0x0054;
                                    L_0x0043:
                                        r0 = r4.b;
                                        r0 = r0.d;
                                        r0 = r0.getContext();
                                        r1 = com.duokan.c.j.bookshelf__shared__file_not_exist;
                                        r0 = com.duokan.reader.ui.general.be.a(r0, r1, r3);
                                        r0.show();
                                    L_0x0054:
                                        r0 = r4.b;
                                        r0 = r0;
                                        r0 = r0.isShowing();
                                        if (r0 == 0) goto L_0x003b;
                                    L_0x005e:
                                        r0 = r4.b;
                                        r0 = r0;
                                        r0.dismiss();
                                        goto L_0x003b;
                                    L_0x0066:
                                        r0 = move-exception;
                                        r1 = r4.b;
                                        r1 = r1.a;
                                        if (r1 != 0) goto L_0x007e;
                                    L_0x006d:
                                        r1 = r4.b;
                                        r1 = r1.d;
                                        r1 = r1.getContext();
                                        r2 = com.duokan.c.j.bookshelf__shared__file_not_exist;
                                        r1 = com.duokan.reader.ui.general.be.a(r1, r2, r3);
                                        r1.show();
                                    L_0x007e:
                                        r1 = r4.b;
                                        r1 = r0;
                                        r1 = r1.isShowing();
                                        if (r1 == 0) goto L_0x008f;
                                    L_0x0088:
                                        r1 = r4.b;
                                        r1 = r0;
                                        r1.dismiss();
                                    L_0x008f:
                                        throw r0;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.ReaderController.20.1.run():void");
                                    }
                                });
                            } catch (Throwable th) {
                                if (jqVar.isShowing()) {
                                    jqVar.dismiss();
                                }
                            }
                        }
                    });
                } else {
                    a = ai.a().a(new File(path));
                    if (a != null) {
                        openBook(a);
                    }
                }
            }
        } else if (ReaderEnv.get().getKeepReading() && !TextUtils.isEmpty(ReaderEnv.get().getReadingBookUuid())) {
            com.duokan.core.diagnostic.a.c().c(LogLevel.EVENT, "nav", "keep reading");
            a = ai.a().b(ReaderEnv.get().getReadingBookUuid());
            if (a != null) {
                openBook(a);
            }
        }
    }

    private final void switchToReading(c cVar, com.duokan.reader.domain.document.a aVar, Runnable runnable) {
        Switcher readingSwitcher = new ReadingSwitcher(this, cVar, aVar);
        if (cVar.w()) {
            com.duokan.reader.domain.statistics.a.k().c(cVar.H());
        }
        pendSwitch(readingSwitcher, runnable);
    }

    private final void switchToHome(Runnable runnable) {
        pendSwitch(new HomeSwitcher(), runnable);
    }

    private final void startReadingInAnim(final Runnable runnable) {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.75f);
        Animation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
        Animation animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(500);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        Animation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        scaleAnimation = new AnimationSet(true);
        scaleAnimation.addAnimation(translateAnimation);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ReaderController b;

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                this.b.runLater(runnable);
            }
        });
        this.r.getContentView().startAnimation(animationSet);
        this.s.getContentView().startAnimation(scaleAnimation);
    }

    private final void startReadingOutAnim(final Runnable runnable) {
        Animation alphaAnimation = new AlphaAnimation(0.75f, 1.0f);
        Animation scaleAnimation = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, 0.5f, 1, 0.5f);
        Animation animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        alphaAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ReaderController b;

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                this.b.runLater(runnable);
            }
        });
        animationSet.setDuration(500);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
        scaleAnimation = new AnimationSet(true);
        scaleAnimation.addAnimation(translateAnimation);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        this.r.getContentView().startAnimation(animationSet);
        this.s.getContentView().startAnimation(scaleAnimation);
    }

    private final void pendSwitch(final Switcher switcher, final Runnable runnable) {
        com.duokan.core.diagnostic.a.c().b(switcher != null);
        Runnable anonymousClass23 = new Runnable(this) {
            final /* synthetic */ ReaderController c;

            public void run() {
                switcher.doSwitch(new Runnable(this) {
                    final /* synthetic */ AnonymousClass23 a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        t.a(runnable);
                        this.a.c.f = null;
                        if (this.a.c.d.size() > 0) {
                            this.a.c.f = (Runnable) this.a.c.d.pollFirst();
                            t.b(this.a.c.f);
                        }
                    }
                });
            }
        };
        if (this.f == null) {
            this.f = anonymousClass23;
            DkApp.get().runWhenAppReady(this.f);
            return;
        }
        this.d.add(anonymousClass23);
    }

    private p sceneForBook(y yVar, c cVar) {
        if (cVar == null) {
            return new com.duokan.reader.ui.surfing.f(getContext(), true);
        }
        p open = BookOpener.with(yVar).open(cVar, null, null);
        if (open == null) {
            return new com.duokan.reader.ui.surfing.f(getContext(), true);
        }
        return open;
    }

    private final p activeScene() {
        if (this.s != null) {
            return this.s;
        }
        if (this.r != null) {
            return this.r;
        }
        return null;
    }

    private final m getDkActivity() {
        return (m) getActivity();
    }
}
