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
import com.duokan.common.FileTypeRecognizer;
import com.duokan.common.FileTypeRecognizer.FileType;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.FileUtil;
import com.duokan.core.p027b.C0324a;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.sys.IdleHandlerListener;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ah;
import com.duokan.core.ui.cv;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0253e;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv.BookShelfType;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0630c;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.common.webservices.duokan.C0650x;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.common.webservices.duokan.DkCloudMessageInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreBookDetailInfo;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.bookshelf.is;
import com.duokan.reader.domain.bookshelf.kh;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.av;
import com.duokan.reader.domain.cloud.push.C0857b;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage.ActionType;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.domain.statistics.dailystats.C1167a;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.C1176a;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.C0437t;
import com.duokan.reader.ui.C0457r;
import com.duokan.reader.ui.C1235a;
import com.duokan.reader.ui.C1315f;
import com.duokan.reader.ui.C1367p;
import com.duokan.reader.ui.account.ShareEntranceController;
import com.duokan.reader.ui.account.ab;
import com.duokan.reader.ui.account.ae;
import com.duokan.reader.ui.account.bl;
import com.duokan.reader.ui.bookshelf.eq;
import com.duokan.reader.ui.bookshelf.he;
import com.duokan.reader.ui.bookshelf.hi;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.cm;
import com.duokan.reader.ui.general.ja;
import com.duokan.reader.ui.general.web.StorePageController;
import com.duokan.reader.ui.general.web.lp;
import com.duokan.reader.ui.reading.qr;
import com.duokan.reader.ui.reading.su;
import com.duokan.reader.ui.store.C1502o;
import com.duokan.reader.ui.store.al;
import com.duokan.reader.ui.store.bv;
import com.duokan.reader.ui.surfing.C1522i;
import com.duokan.reader.ui.welcome.DkTipManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;

class ReaderController extends ActivatedController implements ReaderFeature, SystemUiConditioner {
    /* renamed from: a */
    private static boolean f1422a = true;
    /* renamed from: b */
    private final C1235a f1423b;
    /* renamed from: c */
    private final C1315f f1424c;
    /* renamed from: d */
    private final LinkedList<Runnable> f1425d;
    /* renamed from: e */
    private final LinkedList<SystemUiConditioner> f1426e;
    /* renamed from: f */
    private Runnable f1427f;
    /* renamed from: g */
    private Runnable f1428g;
    /* renamed from: h */
    private Toast f1429h;
    /* renamed from: i */
    private boolean f1430i;
    /* renamed from: j */
    private boolean f1431j;
    /* renamed from: k */
    private NightLayer f1432k;
    /* renamed from: l */
    private boolean f1433l;
    /* renamed from: m */
    private ActivatedController f1434m;
    /* renamed from: n */
    private long f1435n;
    /* renamed from: o */
    private long f1436o;
    /* renamed from: p */
    private final boolean f1437p;
    /* renamed from: q */
    private C1367p f1438q;
    /* renamed from: r */
    private qr f1439r;
    /* renamed from: s */
    private final C0457r f1440s;

    interface Switcher {
        void doSwitch(Runnable runnable);
    }

    /* renamed from: com.duokan.reader.ReaderController$1 */
    class C04581 implements C0457r {
        /* renamed from: a */
        final /* synthetic */ ReaderController f1530a;

        C04581(ReaderController readerController) {
            this.f1530a = readerController;
        }

        public int getPageHeaderHeight() {
            return this.f1530a.getResources().getDimensionPixelSize(C0253e.general__shared__page_header_height) + getPageHeaderPaddingTop();
        }

        public int getPageHeaderPaddingTop() {
            return this.f1530a.f1423b.getStatusBarHeight();
        }

        public int getHeaderPaddingTop() {
            return this.f1530a.f1423b.getStatusBarHeight();
        }

        public int getPagePaddingBottom() {
            return 0;
        }
    }

    class HomeSwitcher implements Switcher {
        /* renamed from: a */
        final /* synthetic */ ReaderController f1575a;

        private HomeSwitcher(ReaderController readerController) {
            this.f1575a = readerController;
        }

        public void doSwitch(final Runnable runnable) {
            if (this.f1575a.f1439r == null) {
                this.f1575a.activate(this.f1575a.f1438q);
                UThread.post(runnable);
                return;
            }
            this.f1575a.f1439r.m12837b(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ HomeSwitcher f1574b;

                /* renamed from: com.duokan.reader.ReaderController$HomeSwitcher$1$1 */
                class C04701 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C04711 f1572a;

                    C04701(C04711 c04711) {
                        this.f1572a = c04711;
                    }

                    public void run() {
                        this.f1572a.f1574b.f1575a.deactivate(this.f1572a.f1574b.f1575a.f1439r);
                        this.f1572a.f1574b.f1575a.f1439r.m12851p();
                        this.f1572a.f1574b.f1575a.f1424c.m9916a(this.f1572a.f1574b.f1575a.f1439r.getContentView(), false);
                        this.f1572a.f1574b.f1575a.f1424c.removeView(this.f1572a.f1574b.f1575a.f1439r.getContentView());
                        this.f1572a.f1574b.f1575a.removeSubController(this.f1572a.f1574b.f1575a.f1439r);
                        this.f1572a.f1574b.f1575a.f1439r = null;
                        UThread.post(runnable);
                    }
                }

                public void run() {
                    boolean z = ReaderEnv.get().forHd() || this.f1574b.f1575a.getActivity().getRequestedOrientation() == 1;
                    this.f1574b.f1575a.f1438q.getContentView().setVisibility(0);
                    this.f1574b.f1575a.activate(this.f1574b.f1575a.f1438q);
                    this.f1574b.f1575a.f1424c.m9916a(this.f1574b.f1575a.f1438q.getContentView(), false);
                    this.f1574b.f1575a.f1424c.m9916a(this.f1574b.f1575a.f1439r.getContentView(), true);
                    this.f1574b.f1575a.f1439r.getContentView().setVisibility(8);
                    Runnable c04701 = new C04701(this);
                    if (z) {
                        this.f1574b.f1575a.startReadingOutAnim(c04701);
                    } else {
                        c04701.run();
                    }
                }
            });
        }
    }

    class NightLayer extends cv {
        /* renamed from: a */
        final /* synthetic */ ReaderController f1577a;

        /* renamed from: com.duokan.reader.ReaderController$NightLayer$1 */
        class C04721 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ NightLayer f1576a;

            C04721(NightLayer nightLayer) {
                this.f1576a = nightLayer;
            }

            public void run() {
                this.f1576a.dismiss();
            }
        }

        public NightLayer(ReaderController readerController, Context context) {
            this.f1577a = readerController;
            super(context, true);
            View view = new View(context);
            view.setBackgroundColor(Color.argb(Math.round(158.1f), 0, 0, 0));
            setContentView(view);
        }

        public void showSmoothly() {
            show();
            AnimUtils.startAlphaAnimation(getContentView(), 0.0f, 1.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, false, null);
        }

        public void dismissSmoothly() {
            AnimUtils.startAlphaAnimation(getContentView(), 1.0f, 0.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, true, new C04721(this));
        }
    }

    class NullSwitcher implements Switcher {
        /* renamed from: a */
        final /* synthetic */ ReaderController f1578a;

        private NullSwitcher(ReaderController readerController) {
            this.f1578a = readerController;
        }

        public void doSwitch(Runnable runnable) {
            UThread.post(runnable);
        }
    }

    class ReadingSwitcher implements Switcher {
        /* renamed from: a */
        final /* synthetic */ ReaderController f1590a;
        /* renamed from: b */
        private final C0800c f1591b;
        /* renamed from: c */
        private final C0896a f1592c;

        public ReadingSwitcher(ReaderController readerController, C0800c c0800c, C0896a c0896a) {
            this.f1590a = readerController;
            this.f1591b = c0800c;
            this.f1592c = c0896a;
        }

        public void doSwitch(final Runnable runnable) {
            boolean z = true;
            if (this.f1590a.f1439r == null) {
                this.f1590a.f1439r = BookOpener.with(this.f1590a.getContext()).open(this.f1591b, this.f1592c, new ErrorHandler(this) {
                    /* renamed from: b */
                    final /* synthetic */ ReadingSwitcher f1584b;

                    public void onError(String str) {
                        this.f1584b.f1590a.prompt(str);
                        UThread.post(runnable);
                    }
                });
                if (this.f1590a.f1439r != null) {
                    this.f1590a.addSubController(this.f1590a.f1439r);
                    this.f1590a.f1424c.addView(this.f1590a.f1439r.getContentView(), 1);
                    if (this.f1590a.f1438q != null) {
                        if (!(ReaderEnv.get().forHd() || this.f1590a.getActivity().getRequestedOrientation() == 1) || this.f1590a.f1438q.getContentView().isLayoutRequested()) {
                            z = false;
                        }
                        this.f1590a.f1424c.m9916a(this.f1590a.f1438q.getContentView(), z);
                        this.f1590a.f1438q.getContentView().setVisibility(8);
                    } else {
                        z = false;
                    }
                    this.f1590a.activate(this.f1590a.f1439r);
                    AnimUtils.m1921a(this.f1590a.f1439r.getContentView(), new Runnable(this) {
                        /* renamed from: c */
                        final /* synthetic */ ReadingSwitcher f1589c;

                        /* renamed from: com.duokan.reader.ReaderController$ReadingSwitcher$4$1 */
                        class C04771 implements Runnable {
                            /* renamed from: a */
                            final /* synthetic */ C04784 f1586a;

                            /* renamed from: com.duokan.reader.ReaderController$ReadingSwitcher$4$1$1 */
                            class C04761 implements Runnable {
                                /* renamed from: a */
                                final /* synthetic */ C04771 f1585a;

                                C04761(C04771 c04771) {
                                    this.f1585a = c04771;
                                }

                                public void run() {
                                    if (ReaderEnv.get().getBookShelfType() == BookShelfType.Simple && (this.f1585a.f1586a.f1589c.f1590a.f1438q instanceof C1522i)) {
                                        ((C1522i) this.f1585a.f1586a.f1589c.f1590a.f1438q).m15521a(this.f1585a.f1586a.f1589c.f1591b);
                                    }
                                }
                            }

                            C04771(C04784 c04784) {
                                this.f1586a = c04784;
                            }

                            public void run() {
                                ai.m3980a().m3909b(this.f1586a.f1589c.f1591b);
                                if (this.f1586a.f1589c.f1590a.f1438q != null) {
                                    this.f1586a.f1589c.f1590a.deactivate(this.f1586a.f1589c.f1590a.f1438q);
                                    this.f1586a.f1589c.f1590a.f1438q.runAfterActive(new C04761(this));
                                }
                                UThread.post(runnable);
                            }
                        }

                        public void run() {
                            Runnable c04771 = new C04771(this);
                            this.f1589c.f1590a.f1439r.getContentView().setVisibility(0);
                            if (!z || this.f1589c.f1590a.f1438q == null) {
                                c04771.run();
                            } else {
                                this.f1589c.f1590a.startReadingInAnim(c04771);
                            }
                        }
                    });
                }
            } else if (this.f1590a.f1439r.m12849n().m4156I().equals(this.f1591b.m4156I())) {
                this.f1590a.f1439r.m11283a(null);
                if (this.f1592c != null) {
                    this.f1590a.f1439r.m12850o().mo1984a(this.f1592c);
                    UIdleHandler.addIdleHandler(new IdleHandlerListener(this) {
                        /* renamed from: b */
                        final /* synthetic */ ReadingSwitcher f1580b;

                        public boolean idleRun() {
                            UThread.post(runnable);
                            return false;
                        }
                    });
                    return;
                }
                UThread.post(runnable);
            } else {
                new HomeSwitcher().doSwitch(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ ReadingSwitcher f1582b;

                    public void run() {
                        this.f1582b.doSwitch(runnable);
                    }
                });
            }
        }
    }

    public ReaderController(final IFeature mFeature, final C0800c c0800c) {
        this(mFeature, false);
        this.f1424c.setBackgroundColor(-1);
        DkApp.get().runWhenAppReady(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ ReaderController f1544c;

            public void run() {
                this.f1544c.f1424c.setBackgroundColor(-16777216);
                this.f1544c.f1438q = this.f1544c.sceneForBook(mFeature, c0800c);
                if (this.f1544c.f1438q instanceof qr) {
                    this.f1544c.f1439r = (qr) this.f1544c.f1438q;
                    this.f1544c.f1438q.m11279a(1);
                }
                this.f1544c.setupFirstScene();
            }
        });
    }

    public ReaderController(IFeature mFeature, Uri uri) {
        this(mFeature, false);
        this.f1438q = new lp(mFeature, uri);
        this.f1438q.m11279a(1);
        this.f1433l = true;
        setupFirstScene();
    }

    public ReaderController(IFeature mFeature) {
        this(mFeature, true);
    }

    private ReaderController(IFeature mFeature, boolean z) {
        super(mFeature);
        this.f1425d = new LinkedList();
        this.f1426e = new LinkedList();
        this.f1427f = null;
        this.f1428g = null;
        this.f1429h = null;
        this.f1430i = false;
        this.f1431j = false;
        this.f1432k = null;
        this.f1433l = false;
        this.f1434m = null;
        this.f1435n = -1;
        this.f1436o = 0;
        this.f1438q = null;
        this.f1439r = null;
        this.f1440s = new C04581(this);
        this.f1437p = f1422a;
        f1422a = false;
        getContext().registerGlobalFeature(this);
        this.f1423b = new C1235a(getActivity());
        this.f1424c = new C1315f(getContext());
        this.f1423b.setContentView(this.f1424c);
        this.f1423b.setBackgroundColor(-16777216);
        setContentView(this.f1423b);
        getContext().addFeatureListener(new DkTipManager(getContext(), this.f1424c));
        if (z) {
            this.f1438q = new C1522i(getContext(), this.f1437p);
            setupFirstScene();
        }
    }

    public void navigate(final Intent intent) {
        runAfterActive(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ ReaderController f1547b;

            /* renamed from: com.duokan.reader.ReaderController$3$1 */
            class C04611 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C04623 f1545a;

                C04611(C04623 c04623) {
                    this.f1545a = c04623;
                }

                public void run() {
                    this.f1545a.f1547b.handleIntent(intent);
                }
            }

            public void run() {
                this.f1547b.pendSwitch(new NullSwitcher(), new C04611(this));
            }
        });
    }

    public void chooseStatusBarStyle(af<Boolean> afVar) {
        afVar.mo975a(Boolean.valueOf(true));
    }

    public void chooseNavigationBarMode(af<SystemUiMode> afVar) {
        if (getActivity().hasWindowFocus()) {
            afVar.mo975a(SystemUiMode.DOCK);
        }
    }

    public void chooseNavigationBarColor(af<Integer> afVar) {
        if (ReaderEnv.get().onMiui()) {
            afVar.mo975a(Integer.valueOf(-1));
        }
    }

    public C0457r getTheme() {
        return this.f1440s;
    }

    public boolean pushPage(ActivatedController c0303e) {
        ActivatedController activeScene = activeScene();
        activate(activeScene);
        return activeScene.pushPage(c0303e);
    }

    public boolean pushPageSmoothly(ActivatedController c0303e, Runnable runnable) {
        ActivatedController activeScene = activeScene();
        activate(activeScene);
        return activeScene.pushPageSmoothly(c0303e, runnable);
    }

    public boolean pushHalfPage(ActivatedController c0303e) {
        ActivatedController activeScene = activeScene();
        activate(activeScene);
        return activeScene.m11281a(c0303e);
    }

    public boolean pushHalfPageSmoothly(ActivatedController c0303e, Runnable runnable) {
        ActivatedController activeScene = activeScene();
        activate(activeScene);
        return activeScene.m11282a(c0303e, runnable);
    }

    public boolean pushFloatingPage(ActivatedController c0303e) {
        ActivatedController activeScene = activeScene();
        activate(activeScene);
        return activeScene.m11284b(c0303e);
    }

    public boolean pushFloatingPageSmoothly(ActivatedController c0303e, Runnable runnable) {
        ActivatedController activeScene = activeScene();
        activate(activeScene);
        return activeScene.m11285b(c0303e, runnable);
    }

    public boolean showPopup(ActivatedController c0303e) {
        ActivatedController activeScene = activeScene();
        activate(activeScene);
        return activeScene.showPopup(c0303e);
    }

    public boolean showPopup(ActivatedController c0303e, int i, int i2) {
        ActivatedController activeScene = activeScene();
        activate(activeScene);
        return activeScene.showPopup(c0303e, i, i2);
    }

    public boolean showPopupSmoothly(ActivatedController c0303e, Runnable runnable) {
        ActivatedController activeScene = activeScene();
        activate(activeScene);
        return activeScene.showPopupSmoothly(c0303e, runnable);
    }

    public boolean navigateSmoothly(String str) {
        return navigate(str, null, true, null);
    }

    public boolean navigateSmoothly(String str, Runnable runnable) {
        return navigate(str, null, true, runnable);
    }

    public boolean navigate(String str, Object obj, final boolean z, final Runnable runnable) {
        final String toLowerCase = str.toLowerCase(Locale.US);
        WebLog c = WebLog.init();
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
                /* renamed from: d */
                final /* synthetic */ ReaderController f1551d;

                public void run() {
                    C0437t c0437t = (C0437t) this.f1551d.getContext().queryFeature(C0437t.class);
                    ActivatedController storePageController = new StorePageController(this.f1551d.getContext());
                    storePageController.loadUrl(toLowerCase);
                    if (z) {
                        c0437t.pushPageSmoothly(storePageController, runnable);
                        return;
                    }
                    c0437t.pushPage(storePageController);
                    UThread.post(runnable);
                }
            });
            return true;
        }
        Uri parse = Uri.parse(toLowerCase);
        if (!TextUtils.equals(parse.getScheme(), "duokan-reader") || toLowerCase.length() <= "duokan-reader://".length()) {
            return false;
        }
        toLowerCase = toLowerCase.substring("duokan-reader://".length());
        C1367p activeScene = activeScene();
        if (activeScene != null) {
            activeScene.m11288h();
        }
        Object lastPathSegment = parse.getLastPathSegment();
        if (!TextUtils.equals(parse.getHost(), "reading") || TextUtils.isEmpty(lastPathSegment)) {
            if (z) {
                final Object obj2 = obj;
                final boolean z2 = z;
                final Runnable runnable2 = runnable;
                goHome(new Runnable(this) {
                    /* renamed from: e */
                    final /* synthetic */ ReaderController f1556e;

                    public void run() {
                        this.f1556e.f1438q.navigate(toLowerCase, obj2, z2, runnable2);
                    }
                });
            } else {
                this.f1438q.navigate(toLowerCase, obj, z, runnable);
                goHome(null);
            }
        } else if (TextUtils.equals(lastPathSegment, "recently") && !TextUtils.isEmpty(ReaderEnv.get().getReadingBookUuid())) {
            r0 = ai.m3980a().m3906b(ReaderEnv.get().getReadingBookUuid());
            if (r0 != null) {
                openBook(r0);
            }
        } else if (!TextUtils.isEmpty(lastPathSegment)) {
            r0 = ai.m3980a().m3906b((String) lastPathSegment);
            if (r0 != null) {
                if (r0.m4247s() != BookPackageType.EPUB_OPF && r0.m4242o() != BookType.SERIAL && !r0.m4167T()) {
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
                if (this.f1432k == null) {
                    this.f1432k = new NightLayer(this, getContext());
                    if (z2) {
                        this.f1432k.showSmoothly();
                    } else {
                        this.f1432k.show();
                    }
                }
            } else if (this.f1432k != null) {
                if (z2) {
                    this.f1432k.dismissSmoothly();
                } else {
                    this.f1432k.dismiss();
                }
                this.f1432k = null;
            }
            ReaderEnv.get().setPrefBoolean(PrivatePref.GLOBAL, "night_mode", z);
            ReaderEnv.get().commitPrefs();
        }
    }

    public boolean inNightMode() {
        return this.f1432k != null;
    }

    public void switchEyesSavingMode(boolean z) {
        this.f1431j = z;
        if (this.f1431j) {
            cv.setRgbDensity(1.0f, 0.98f, 0.9f);
            this.f1424c.m9915a(1.0f, 0.98f, 0.9f);
            return;
        }
        cv.setRgbDensity(1.0f, 1.0f, 1.0f);
        this.f1424c.m9915a(1.0f, 1.0f, 1.0f);
    }

    public float[] getEyesSavingModeDensity() {
        if (this.f1431j) {
            return new float[]{1.0f, 0.98f, 0.9f};
        }
        return new float[]{1.0f, 1.0f, 1.0f};
    }

    public Drawable getHeaderBackground() {
        return new ColorDrawable(getResources().getColor(C0252d.general__shared__page_header_background));
    }

    public C0800c getReadingBook() {
        return this.f1439r != null ? this.f1439r.m12849n() : null;
    }

    public su getReadingFeature() {
        return this.f1439r != null ? this.f1439r.m12850o() : null;
    }

    public void addSystemUiConditioner(SystemUiConditioner systemUiConditioner) {
        this.f1426e.addFirst(systemUiConditioner);
        updateSystemUi(false);
    }

    public void removeSystemUiConditioner(SystemUiConditioner systemUiConditioner) {
        this.f1426e.remove(systemUiConditioner);
        updateSystemUi(false);
    }

    public void updateSystemUi(boolean z) {
        if (!z) {
            pendSystemUiUpdate();
        } else if (this.f1428g != null) {
            this.f1428g.run();
        } else {
            applySystemUi();
        }
    }

    public void prompt(String str) {
        prompt(str, 0);
    }

    public void prompt(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f1429h == null) {
                this.f1429h = be.m10287a(getContext(), (CharSequence) str, i);
            }
            this.f1429h.setText(str);
            this.f1429h.show();
        }
    }

    public void openBook(C0800c c0800c) {
        openBook(c0800c, null, null);
    }

    public void openBook(final C0800c c0800c, C0896a c0896a, Runnable runnable) {
        if (c0800c != null) {
            if (c0800c.m4247s() == BookPackageType.EPUB_OPF) {
                switchToReading(c0800c, c0896a, runnable);
            } else if (c0800c.m4242o() == BookType.SERIAL) {
                switchToReading(c0800c, c0896a, runnable);
            } else if (c0800c.m4171X()) {
                if (c0800c.m4170W()) {
                    c0800c.ac();
                } else {
                    com.duokan.reader.ui.bookshelf.be.m9188a(getContext(), c0800c.m4151D(), new cm(this) {
                        /* renamed from: b */
                        final /* synthetic */ ReaderController f1558b;

                        public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
                            if (z) {
                                c0800c.m4208b(flowChargingTransferChoice.wifiOnly());
                            }
                        }
                    });
                }
            } else if (c0800c.m4167T()) {
                switchToReading(c0800c, c0896a, runnable);
            } else if (c0800c.ak()) {
                if (c0800c.m4233i() != BookState.CLOUD_ONLY) {
                    ai.m3980a().m3919c(Arrays.asList(new C0800c[]{c0800c}));
                    be.m10286a(getContext(), C0258j.bookshelf__file_not_exist_and_download_again, 1).show();
                    return;
                }
                downloadBooks(c0800c);
            } else if (!c0800c.ao()) {
                new eq(getContext()).m9561a(c0800c);
            } else if (c0800c.m4233i() != BookState.CLOUD_ONLY) {
                ai.m3980a().m3919c(Arrays.asList(new C0800c[]{c0800c}));
                be.m10286a(getContext(), C0258j.bookshelf__file_not_exist_and_download_again, 1).show();
            } else {
                downloadBooks(c0800c);
            }
        }
    }

    public void openBook(String str, final C0896a c0896a) {
        C0800c b = ai.m3980a().m3906b(str);
        if (b != null) {
            openBook(b, c0896a, null);
            return;
        }
        String a = new C0650x(str).m3046a();
        final ja jaVar = new ja(getContext());
        jaVar.show();
        if (a.length() >= 32) {
            C1176a.m8695a().m8703a(a, false, new C0466h(this) {
                /* renamed from: c */
                final /* synthetic */ ReaderController f1561c;

                public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
                    jaVar.dismiss();
                    this.f1561c.openBook(ai.m3980a().m3875a(dkStoreItem), c0896a, null);
                }

                public void onFetchBookDetailError(String str) {
                    jaVar.dismiss();
                    ((ReaderFeature) this.f1561c.getContext().queryFeature(ReaderFeature.class)).prompt(this.f1561c.getString(C0258j.general__shared__network_error));
                }
            });
        } else {
            C1176a.m8695a().m8705b(a, true, new C0466h(this) {
                /* renamed from: c */
                final /* synthetic */ ReaderController f1564c;

                public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
                    jaVar.dismiss();
                    this.f1564c.openBook(ai.m3980a().m3874a((DkStoreFictionDetail) dkStoreItem), c0896a, null);
                }

                public void onFetchBookDetailError(String str) {
                    jaVar.dismiss();
                    ((ReaderFeature) this.f1564c.getContext().queryFeature(ReaderFeature.class)).prompt(this.f1564c.getString(C0258j.general__shared__network_error));
                }
            });
        }
    }

    public void shareBooks(ActivatedController c0303e, C0800c... c0800cArr) {
        if (c0303e != null && c0800cArr != null) {
            if (this.f1434m != null) {
                c0303e.deactivate(this.f1434m);
                c0303e.removeSubController(this.f1434m);
            }
            if (c0800cArr.length != 1 || c0800cArr[0].ak()) {
                String ay;
                String string;
                if (c0800cArr.length == 1) {
                    ay = c0800cArr[0].ay();
                } else {
                    ay = String.format(getString(C0258j.share__book_to_weixin_multi_title), new Object[]{Integer.valueOf(c0800cArr.length)});
                }
                if (c0800cArr.length == 1) {
                    string = getString(C0258j.share__book_to_weixin_single);
                } else {
                    string = getString(C0258j.share__book_to_weixin_multi);
                }
                String str = "";
                final List arrayList = new ArrayList();
                final List arrayList2 = new ArrayList();
                String str2 = string;
                int i = 0;
                while (i < c0800cArr.length) {
                    C0800c c0800c = c0800cArr[i];
                    if (i == 0) {
                        str = c0800c.m4228g();
                    }
                    arrayList.add(c0800c.m4156I());
                    arrayList2.add(c0800c.m4155H().f3455c);
                    if (c0800cArr.length > 1) {
                        if (i < 5) {
                            str2 = str2 + String.format(getString(C0258j.general__shared__book_title_marks), new Object[]{c0800c.ay()});
                            if (i < c0800cArr.length - 1 && i < 4) {
                                str2 = str2 + "、";
                            }
                        } else if (i == 5) {
                            str2 = str2 + "...";
                        }
                    }
                    i++;
                }
                final ActivatedController c0303e2 = c0303e;
                new ab(getContext(), false, new ae(this) {
                    /* renamed from: g */
                    final /* synthetic */ ReaderController f1571g;

                    public void onChoiced(String str) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f1571g.f1434m = new bl(this.f1571g.getContext(), true, str, "", ay, str2, str, (String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0]), null);
                            c0303e2.addSubController(this.f1571g.f1434m);
                            c0303e2.activate(this.f1571g.f1434m);
                        }
                    }
                }).show();
                return;
            }
            C0800c c0800c2 = c0800cArr[0];
            this.f1434m = new ShareEntranceController(getContext(), c0800c2.m4248t().f2708f, c0800c2, null);
            c0303e.addSubController(this.f1434m);
            c0303e.activate(this.f1434m);
        }
    }

    public void downloadBooks(final C0800c... c0800cArr) {
        WebSession anonymousClass10 = new WebSession(this, C0630c.f2119a) {
            /* renamed from: b */
            final /* synthetic */ ReaderController f1505b;
            /* renamed from: c */
            private ja f1506c = null;
            /* renamed from: d */
            private boolean f1507d = false;
            /* renamed from: e */
            private LinkedList<AnonymousClass1DownloadInfo> f1508e = new LinkedList();
            /* renamed from: f */
            private long f1509f = 0;
            /* renamed from: g */
            private boolean f1510g = false;

            /* renamed from: com.duokan.reader.ReaderController$10$1 */
            class C04511 implements OnCancelListener {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass10 f1500a;

                C04511(AnonymousClass10 anonymousClass10) {
                    this.f1500a = anonymousClass10;
                }

                public void onCancel(C0301c c0301c) {
                    this.f1500a.f1510g = true;
                    this.f1500a.close();
                    this.f1500a.f1506c.dismiss();
                }
            }

            /* renamed from: com.duokan.reader.ReaderController$10$2 */
            class C04532 implements cm {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass10 f1503a;

                C04532(AnonymousClass10 anonymousClass10) {
                    this.f1503a = anonymousClass10;
                }

                public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
                    if (z) {
                        Iterator it = this.f1503a.f1508e.iterator();
                        while (it.hasNext()) {
                            AnonymousClass1DownloadInfo anonymousClass1DownloadInfo = (AnonymousClass1DownloadInfo) it.next();
                            final C0800c c0800c = anonymousClass1DownloadInfo.f1531a;
                            if (c0800c != null) {
                                if (c0800c.m4173Z()) {
                                    c0800c.m4208b(flowChargingTransferChoice.wifiOnly());
                                } else if (c0800c.mo1037j()) {
                                    C1167a.m8671d().m8686c(c0800c.m4156I(), c0800c.m4155H().f3455c);
                                    c0800c.m4208b(flowChargingTransferChoice.wifiOnly());
                                } else if (c0800c.mo1038k()) {
                                    List bp;
                                    if (c0800c.m4239l()) {
                                        bp = ((kh) c0800c).bp();
                                    } else {
                                        bp = ((fp) c0800c).bp();
                                    }
                                    c0800c.m4198a(c0800c.m4225f(), "dkcloud:///fiction/" + c0800c.m4156I() + "#" + C0652z.m3048a((String[]) bp.toArray(new String[0])), "", "", false, new af(Boolean.valueOf(false)));
                                } else if (c0800c.ak()) {
                                    DkCloudPurchasedBook a = DkUserPurchasedBooksManager.m5029a().m5052a(c0800c.m4156I());
                                    if (a == null) {
                                        DkStoreBookDetail dkStoreBookDetail = anonymousClass1DownloadInfo.f1532b;
                                        if (dkStoreBookDetail != null) {
                                            if (av.m5316a().m5334b().f3740a > System.currentTimeMillis()) {
                                                c0800c.m4198a(c0800c.m4225f(), dkStoreBookDetail.getEpubUri(), dkStoreBookDetail.getRevision(), dkStoreBookDetail.getEpubMd5(), false, flowChargingTransferChoice.wifiOnly());
                                            } else {
                                                ai.m3980a().m3886a(c0800c, true);
                                                ai.m3980a().m3871a(dkStoreBookDetail, flowChargingTransferChoice.wifiOnly());
                                            }
                                        }
                                    } else if (!C1502o.m15410a().m15434a(c0800c.m4156I())) {
                                        C1502o.m15410a().m15435b(c0800c.m4156I());
                                        C1502o.m15410a().m15431a(a.getBookUuid(), anonymousClass1DownloadInfo.f1532b, new al(this) {
                                            /* renamed from: b */
                                            final /* synthetic */ C04532 f1502b;

                                            public void onDownloadCloudBookStarted() {
                                                C1502o.m15410a().m15436c(c0800c.m4156I());
                                            }

                                            public void onDownloadCloudBookError(String str) {
                                                C1502o.m15410a().m15436c(c0800c.m4156I());
                                                if (!TextUtils.isEmpty(str)) {
                                                    be.m10287a(this.f1502b.f1503a.f1505b.getContext(), (CharSequence) str, 1).show();
                                                }
                                            }

                                            public void onDownloadCloudBookCanceled() {
                                                C1502o.m15410a().m15436c(c0800c.m4156I());
                                            }
                                        }, flowChargingTransferChoice);
                                    }
                                } else if (c0800c.ao()) {
                                    is a2 = it.m4692a().m4713a(c0800c.ar());
                                    if (a2 != null) {
                                        ai.m3980a().m3867a(c0800c, a2, flowChargingTransferChoice.wifiOnly());
                                    }
                                }
                            }
                        }
                    }
                }
            }

            protected void onSessionOpen() {
                this.f1507d = C0559f.m2476b().m2485d();
                this.f1506c = new ja(this.f1505b.getContext());
                this.f1506c.open(new C04511(this));
            }

            protected void onSessionTry() {
                for (C0800c c0800c : c0800cArr) {
                    if (c0800c.m4168U()) {
                        AnonymousClass1DownloadInfo anonymousClass1DownloadInfo = new Object(this.f1505b) {
                            /* renamed from: a */
                            public C0800c f1531a = null;
                            /* renamed from: b */
                            public DkStoreBookDetail f1532b = null;
                            /* renamed from: c */
                            final /* synthetic */ ReaderController f1533c;

                            {
                                this.f1533c = r2;
                            }
                        };
                        anonymousClass1DownloadInfo.f1531a = c0800c;
                        if (c0800c.mo1037j()) {
                            for (com.duokan.reader.domain.document.epub.av e : ((fp) c0800c).m4492f(this.f1507d)) {
                                this.f1509f += (long) e.mo1070e();
                            }
                            this.f1508e.add(anonymousClass1DownloadInfo);
                        } else if (c0800c.mo1038k()) {
                            this.f1508e.add(anonymousClass1DownloadInfo);
                        } else if (c0800c.ak()) {
                            C0621a a = new C0647u(this, null).m3033a(c0800c.m4156I(), false);
                            this.f1509f += ((DkStoreBookDetailInfo) a.f2058a).mEpubSize;
                            anonymousClass1DownloadInfo.f1532b = new DkStoreBookDetail((DkStoreBookDetailInfo) a.f2058a);
                            this.f1508e.add(anonymousClass1DownloadInfo);
                        } else if (c0800c.ao()) {
                            this.f1509f += c0800c.am().m4680a().m8160j();
                            this.f1508e.add(anonymousClass1DownloadInfo);
                        }
                    }
                }
            }

            protected void onSessionSucceeded() {
                this.f1506c.dismiss();
                if (!this.f1510g && this.f1508e.size() >= 1) {
                    com.duokan.reader.ui.bookshelf.be.m9188a(this.f1505b.getActivity(), this.f1509f, new C04532(this));
                }
            }

            protected void onSessionFailed() {
                this.f1506c.dismiss();
                ((ReaderFeature) this.f1505b.getContext().queryFeature(ReaderFeature.class)).prompt(this.f1505b.getString(C0258j.general__shared__network_error));
            }
        };
        if (C0559f.m2476b().m2486e()) {
            anonymousClass10.open();
        } else {
            be.m10287a(getContext(), getString(C0258j.general__shared__network_error), 0).show();
        }
    }

    public void goHome(Runnable runnable) {
        if (this.f1438q instanceof C1522i) {
            switchToHome(runnable);
        } else if (this.f1438q instanceof qr) {
            pendSwitch(new Switcher(this) {
                /* renamed from: a */
                final /* synthetic */ ReaderController f1514a;

                {
                    this.f1514a = r1;
                }

                public void doSwitch(Runnable runnable) {
                    final qr qrVar = (qr) this.f1514a.f1438q;
                    qrVar.m12837b(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ AnonymousClass11 f1513b;

                        /* renamed from: com.duokan.reader.ReaderController$11$1$1 */
                        class C04541 implements IdleHandlerListener {
                            /* renamed from: a */
                            final /* synthetic */ C04551 f1511a;

                            C04541(C04551 c04551) {
                                this.f1511a = c04551;
                            }

                            public boolean idleRun() {
                                qrVar.m12851p();
                                return false;
                            }
                        }

                        public void run() {
                            if (!this.f1513b.f1514a.f1433l) {
                                Intent intent = new Intent();
                                intent.setAction("com.duokan.reader.actions.SHOW_BOOKSHELF");
                                intent.setComponent(new ComponentName(DkApp.get(), DkApp.get().getReaderActivityClass()));
                                this.f1513b.f1514a.getContext().startActivity(intent);
                            }
                            DkApp.get().getTopActivity().finish();
                            UThread.addIdleHandlerListener(new C04541(this));
                        }
                    });
                }
            }, null);
        } else {
            DkApp.get().getTopActivity().finish();
        }
    }

    public void showBookHomePage(IFeature mFeature, String str, String str2, boolean z, String str3) {
        bv.m15356a(mFeature, str, str2, str3, z);
    }

    public void showMenuFromBottom(final hi hiVar) {
        showPopup(hiVar);
        AnimUtils.startTranslateAnimation(hiVar.m9791a(), 0.0f, 0.0f, 1.0f, 0.0f, HttpStatus.SC_OK, true, new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ ReaderController f1516b;

            public void run() {
                hiVar.m9792a(true);
            }
        });
        AnimUtils.startAlphaAnimation(hiVar.m9793b(), 0.0f, 1.0f, HttpStatus.SC_OK, true, null);
    }

    public void showMenuFromTop(final he heVar) {
        showPopup(heVar);
        AnimUtils.startTranslateAnimation(heVar.m9488a(), 0.0f, 0.0f, -1.0f, 0.0f, HttpStatus.SC_OK, true, new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ ReaderController f1518b;

            public void run() {
                heVar.m9492a(true);
            }
        });
        AnimUtils.startAlphaAnimation(heVar.m9493b(), 0.0f, 1.0f, (int) HttpStatus.SC_OK, true, null);
    }

    public long getTotalActiveTime() {
        if (this.f1435n <= 0) {
            return this.f1436o;
        }
        return (this.f1436o + System.currentTimeMillis()) - this.f1435n;
    }

    public int getPageCount() {
        if (this.f1439r != null && this.f1439r.isActive()) {
            return this.f1439r.m11287g();
        }
        if (this.f1438q == null || !this.f1438q.isActive()) {
            return 0;
        }
        return this.f1438q.m11287g();
    }

    public void setQuitOnBack(boolean z) {
        this.f1433l = z;
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
        int s = PersonalPrefs.m5175a().m5243s();
        if (s - ReaderEnv.get().getLastUseDay() == 1) {
            ReaderEnv.get().setUseDays(ReaderEnv.get().getUseDays() + 1);
        } else if (s - ReaderEnv.get().getLastUseDay() != 0) {
            ReaderEnv.get().setUseDays(1);
        }
        ReaderEnv.get().setLastUseDay(s);
        this.f1435n = System.currentTimeMillis();
        if (z) {
            C1163a.m8627k().m8642a("main", 2);
            ReaderEnv.get().setAppActivated();
            switchNightMode(ReaderEnv.get().getPrefBoolean(PrivatePref.GLOBAL, "night_mode", false), false);
            monitorSystemUiVisibilityChange();
        }
    }

    protected void onDeactive() {
        super.onDeactive();
        this.f1436o += System.currentTimeMillis() - this.f1435n;
        this.f1435n = -1;
        UmengManager.get().sendDelayedEvents();
    }

    @SuppressLint({"NewApi"})
    private void monitorSystemUiVisibilityChange() {
        if (VERSION.SDK_INT >= 14) {
            getActivity().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener(this) {
                /* renamed from: a */
                final /* synthetic */ ReaderController f1519a;

                {
                    this.f1519a = r1;
                }

                @SuppressLint({"NewApi"})
                public void onSystemUiVisibilityChange(int i) {
                    this.f1519a.updateSystemUi(false);
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
        if (this.f1433l || this.f1430i) {
            return false;
        }
        this.f1430i = true;
        prompt(getString(C0258j.exit_prompt));
        runLater(new Runnable(this) {
            /* renamed from: a */
            final /* synthetic */ ReaderController f1520a;

            {
                this.f1520a = r1;
            }

            public void run() {
                this.f1520a.f1430i = false;
            }
        }, 2000);
        return true;
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (c0303e != null && c0303e == this.f1439r) {
            goHome(null);
            return true;
        } else if (c0303e == null || c0303e != this.f1438q || !this.f1433l) {
            return super.onRequestDetach(c0303e);
        } else {
            getActivity().finish();
            return true;
        }
    }

    protected void onWindowFocusChanged(boolean z) {
        updateSystemUi(true);
    }

    private void setupFirstScene() {
        WebLog.init().w(this.f1438q != null);
        this.f1424c.addView(this.f1438q.getContentView(), 0);
        addSubController(this.f1438q);
        activate(this.f1438q);
        if (this.f1438q instanceof C1522i) {
            DkApp.get().runWhenAppReady(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ ReaderController f1521a;

                {
                    this.f1521a = r1;
                }

                public void run() {
                    this.f1521a.handleIntent(this.f1521a.getActivity().getIntent());
                }
            });
        }
    }

    private void pendSystemUiUpdate() {
        if (this.f1428g == null) {
            this.f1428g = new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ ReaderController f1522a;

                {
                    this.f1522a = r1;
                }

                public void run() {
                    if (this.f1522a.f1428g == this) {
                        this.f1522a.applySystemUi();
                        this.f1522a.f1428g = null;
                    }
                }
            };
            UIdleHandler.addIdleHandler(new IdleHandlerListener(this) {
                /* renamed from: a */
                final /* synthetic */ ReaderController f1523a;

                {
                    this.f1523a = r1;
                }

                public boolean idleRun() {
                    if (this.f1523a.f1428g != null) {
                        this.f1523a.f1428g.run();
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
        Iterator it = this.f1426e.iterator();
        while (it.hasNext()) {
            SystemUiConditioner systemUiConditioner = (SystemUiConditioner) it.next();
            if (!afVar.m861b()) {
                systemUiConditioner.chooseStatusBarStyle(afVar);
            }
            if (!afVar2.m861b()) {
                systemUiConditioner.chooseNavigationBarMode(afVar2);
            }
            if (!afVar3.m861b()) {
                systemUiConditioner.chooseNavigationBarColor(afVar3);
            }
        }
        if (afVar.m861b()) {
            this.f1423b.setStatusBarStyle(((Boolean) afVar.m858a()).booleanValue());
        }
        if (afVar2.m861b()) {
            this.f1423b.setNavigationBarMode((SystemUiMode) afVar2.m858a());
        }
        if (afVar3.m861b()) {
            this.f1423b.setNavigationBarColor(((Integer) afVar3.m858a()).intValue());
        }
    }

    private final void handleIntent(Intent intent) {
        WebLog.init().w(DkApp.get().isReady());
        CharSequence action = intent.getAction();
        final Uri data = intent.getData();
        C0800c a;
        if (!TextUtils.equals(action, "android.intent.action.MAIN")) {
            DkApp.get().setIsActivateFromLauncher(false);
            if (TextUtils.equals(action, "com.duokan.reader.actions.SHOW_BOOKSHELF")) {
                String str;
                if (intent.hasExtra("bookUuid")) {
                    str = "duokan-reader://bookshelf/#bookuuid_" + intent.getStringExtra("bookUuid");
                } else {
                    str = "duokan-reader://bookshelf";
                }
                WebLog.init().a(LogLevel.EVENT, "nav", "handle an intent(action: %s, uri: %s)", action, str);
                navigate(str, null, false, null);
            } else if (TextUtils.equals(action, "com.duokan.reader.actions.SHOW_RUNNING_DOWNLOAD_TASKS")) {
                WebLog.init().a(LogLevel.EVENT, "nav", "handle an intent(action: %s)", action);
            } else if (TextUtils.equals(action, "com.duokan.reader.actions.SHOW_PROMPT")) {
                String stringExtra = intent.getStringExtra("push_message_target");
                if (TextUtils.isEmpty(stringExtra)) {
                    WebLog.init().a(LogLevel.EVENT, "nav", "handle an intent(action: %s, msgId: null)", action);
                    navigate("duokan-reader://personal/message/notification", null, false, null);
                    return;
                }
                DkCloudPushMessage dkCloudPushMessage;
                WebLog.init().a(LogLevel.EVENT, "nav", "handle an intent(action: %s, msgId: %s)", action, stringExtra);
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
                    dkCloudPushMessage = C0857b.m5649a().m5677a(stringExtra);
                }
                if (dkCloudPushMessage == null) {
                    WebLog.init().a(LogLevel.ERROR, "push", "push message not found, msgId: %s", stringExtra);
                    navigate("duokan-reader://personal/message/notification", null, false, null);
                } else if ((dkCloudPushMessage.getEndTime() == 0 || dkCloudPushMessage.getEndTime() > System.currentTimeMillis()) && !TextUtils.isEmpty(dkCloudPushMessage.getActionParamString())) {
                    C0857b.m5649a().m5688b(dkCloudPushMessage.getCloudId());
                    if (dkCloudPushMessage.getMessageType() == ActionType.URL) {
                        navigate(dkCloudPushMessage.getActionUrl(), null, false, null);
                    } else {
                        navigate("duokan-reader://store/action/message", dkCloudPushMessage, false, null);
                    }
                } else {
                    navigate("duokan-reader://personal/message/notification", null, false, null);
                }
            } else if (TextUtils.equals(action, "com.duokan.reader.actions.OPEN_REPLY_MESSAGES")) {
                WebLog.init().a(LogLevel.EVENT, "nav", "handle an intent(action: %s)", action);
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
                WebLog.init().a(LogLevel.EVENT, "nav", "handle an intent(action: %s, store: %d)", action, Integer.valueOf(i));
                switch (i) {
                    case 1:
                        navigate("duokan-reader://store", null, false, null);
                        return;
                    default:
                        navigate("duokan-reader://store", null, false, null);
                        return;
                }
            } else if (TextUtils.equals(action, "com.duokan.reader.actions.SHOW_FEEDBACK")) {
                WebLog.init().a(LogLevel.EVENT, "nav", "handle an intent(action: %s)", action);
                navigate("duokan-reader://personal/feedback", null, false, null);
            } else if ((TextUtils.equals(action, "android.intent.action.VIEW") || TextUtils.isEmpty(action)) && data != null) {
                String path = data.getPath();
                String scheme = data.getScheme();
                Map parseUri = DkRouter.parseUri(data);
                WebLog.init().a(LogLevel.EVENT, "nav", "handle an intent(action: %s, uri: %s)", action, data);
                if (!TextUtils.isEmpty((CharSequence) parseUri.get(ClientCookie.PATH_ATTR))) {
                    if (TextUtils.equals((CharSequence) parseUri.get("miback"), "true")) {
                        this.f1438q.m11279a(1);
                        this.f1433l = true;
                    }
                    if (TextUtils.isEmpty((CharSequence) parseUri.get("simple-web"))) {
                        navigate((String) parseUri.get(ClientCookie.PATH_ATTR), parseUri.get("miref"), false, null);
                    }
                } else if ("duokan-reader".equalsIgnoreCase(scheme)) {
                    navigate(data.toString(), null, false, null);
                } else if (FileType.UNSUPPORTED == FileTypeRecognizer.m567a(path)) {
                    be.m10286a(getContext(), C0258j.general__shared__unkown_book_format, 1).show();
                } else if (C0324a.m735a(data.toString(), "content", new String[0])) {
                    final ja jaVar = new ja(getContext());
                    jaVar.show();
                    ah.m871b(new Runnable(this) {
                        /* renamed from: a */
                        boolean f1526a = false;
                        /* renamed from: d */
                        final /* synthetic */ ReaderController f1529d;

                        public void run() {
                            try {
                                File file = new File(ReaderEnv.get().getLocalBookDirectory(), data.getLastPathSegment());
                                FileUtil.writeFiles(this.f1529d.getContext().getContentResolver().openInputStream(data), file);
                                final C0800c a = ai.m3980a().m3876a(file);
                                UThread.runOnThread(new Runnable(this) {
                                    /* renamed from: b */
                                    final /* synthetic */ AnonymousClass19 f1525b;

                                    /* JADX WARNING: inconsistent code. */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public void run() {
                                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x003b in list [B:10:0x0034]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                                        /*
                                        r4 = this;
                                        r3 = 0;
                                        r0 = r0;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        if (r0 == 0) goto L_0x0013;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                    L_0x0005:
                                        r0 = r4.f1525b;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        r0 = r0.f1529d;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        r1 = r0;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        r0.openBook(r1);	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        r0 = r4.f1525b;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        r1 = 1;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                        r0.f1526a = r1;	 Catch:{ Throwable -> 0x003c, all -> 0x0066 }
                                    L_0x0013:
                                        r0 = r4.f1525b;
                                        r0 = r0.f1526a;
                                        if (r0 != 0) goto L_0x002a;
                                    L_0x0019:
                                        r0 = r4.f1525b;
                                        r0 = r0.f1529d;
                                        r0 = r0.getContext();
                                        r1 = com.duokan.p024c.C0258j.bookshelf__shared__file_not_exist;
                                        r0 = com.duokan.reader.ui.general.be.m10286a(r0, r1, r3);
                                        r0.show();
                                    L_0x002a:
                                        r0 = r4.f1525b;
                                        r0 = r0;
                                        r0 = r0.isShowing();
                                        if (r0 == 0) goto L_0x003b;
                                    L_0x0034:
                                        r0 = r4.f1525b;
                                        r0 = r0;
                                        r0.dismiss();
                                    L_0x003b:
                                        return;
                                    L_0x003c:
                                        r0 = move-exception;
                                        r0 = r4.f1525b;
                                        r0 = r0.f1526a;
                                        if (r0 != 0) goto L_0x0054;
                                    L_0x0043:
                                        r0 = r4.f1525b;
                                        r0 = r0.f1529d;
                                        r0 = r0.getContext();
                                        r1 = com.duokan.p024c.C0258j.bookshelf__shared__file_not_exist;
                                        r0 = com.duokan.reader.ui.general.be.m10286a(r0, r1, r3);
                                        r0.show();
                                    L_0x0054:
                                        r0 = r4.f1525b;
                                        r0 = r0;
                                        r0 = r0.isShowing();
                                        if (r0 == 0) goto L_0x003b;
                                    L_0x005e:
                                        r0 = r4.f1525b;
                                        r0 = r0;
                                        r0.dismiss();
                                        goto L_0x003b;
                                    L_0x0066:
                                        r0 = move-exception;
                                        r1 = r4.f1525b;
                                        r1 = r1.f1526a;
                                        if (r1 != 0) goto L_0x007e;
                                    L_0x006d:
                                        r1 = r4.f1525b;
                                        r1 = r1.f1529d;
                                        r1 = r1.getContext();
                                        r2 = com.duokan.p024c.C0258j.bookshelf__shared__file_not_exist;
                                        r1 = com.duokan.reader.ui.general.be.m10286a(r1, r2, r3);
                                        r1.show();
                                    L_0x007e:
                                        r1 = r4.f1525b;
                                        r1 = r0;
                                        r1 = r1.isShowing();
                                        if (r1 == 0) goto L_0x008f;
                                    L_0x0088:
                                        r1 = r4.f1525b;
                                        r1 = r0;
                                        r1.dismiss();
                                    L_0x008f:
                                        throw r0;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.ReaderController.19.1.run():void");
                                    }
                                });
                            } catch (Throwable th) {
                                if (jaVar.isShowing()) {
                                    jaVar.dismiss();
                                }
                            }
                        }
                    });
                } else {
                    a = ai.m3980a().m3876a(new File(path));
                    if (a != null) {
                        openBook(a);
                    }
                }
            }
        } else if (ReaderEnv.get().getKeepReading() && !TextUtils.isEmpty(ReaderEnv.get().getReadingBookUuid())) {
            WebLog.init().c(LogLevel.EVENT, "nav", "keep reading");
            a = ai.m3980a().m3906b(ReaderEnv.get().getReadingBookUuid());
            if (a != null) {
                openBook(a);
            }
        }
    }

    private final void switchToReading(C0800c c0800c, C0896a c0896a, Runnable runnable) {
        Switcher readingSwitcher = new ReadingSwitcher(this, c0800c, c0896a);
        if (c0800c.m4251w()) {
            C1163a.m8627k().m8651b(c0800c.m4156I());
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
            /* renamed from: b */
            final /* synthetic */ ReaderController f1535b;

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                this.f1535b.runLater(runnable);
            }
        });
        this.f1438q.getContentView().startAnimation(animationSet);
        this.f1439r.getContentView().startAnimation(scaleAnimation);
    }

    private final void startReadingOutAnim(final Runnable runnable) {
        Animation alphaAnimation = new AlphaAnimation(0.75f, 1.0f);
        Animation scaleAnimation = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, 0.5f, 1, 0.5f);
        Animation animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        alphaAnimation.setAnimationListener(new AnimationListener(this) {
            /* renamed from: b */
            final /* synthetic */ ReaderController f1537b;

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                this.f1537b.runLater(runnable);
            }
        });
        animationSet.setDuration(500);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
        scaleAnimation = new AnimationSet(true);
        scaleAnimation.addAnimation(translateAnimation);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f1438q.getContentView().startAnimation(animationSet);
        this.f1439r.getContentView().startAnimation(scaleAnimation);
    }

    private final void pendSwitch(final Switcher switcher, final Runnable runnable) {
        WebLog.init().w(switcher != null);
        Runnable anonymousClass22 = new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ ReaderController f1541c;

            /* renamed from: com.duokan.reader.ReaderController$22$1 */
            class C04591 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass22 f1538a;

                C04591(AnonymousClass22 anonymousClass22) {
                    this.f1538a = anonymousClass22;
                }

                public void run() {
                    UThread.runOnThread(runnable);
                    this.f1538a.f1541c.f1427f = null;
                    if (this.f1538a.f1541c.f1425d.size() > 0) {
                        this.f1538a.f1541c.f1427f = (Runnable) this.f1538a.f1541c.f1425d.pollFirst();
                        UThread.post(this.f1538a.f1541c.f1427f);
                    }
                }
            }

            public void run() {
                switcher.doSwitch(new C04591(this));
            }
        };
        if (this.f1427f == null) {
            this.f1427f = anonymousClass22;
            DkApp.get().runWhenAppReady(this.f1427f);
            return;
        }
        this.f1425d.add(anonymousClass22);
    }

    private C1367p sceneForBook(IFeature mFeature, C0800c c0800c) {
        if (c0800c == null) {
            return new C1522i(getContext(), true);
        }
        C1367p open = BookOpener.with(mFeature).open(c0800c, null, null);
        if (open == null) {
            return new C1522i(getContext(), true);
        }
        return open;
    }

    public final C1367p activeScene() {
        if (this.f1439r != null) {
            return this.f1439r;
        }
        if (this.f1438q != null) {
            return this.f1438q;
        }
        return null;
    }

    private final BaseActivity getDkActivity() {
        return (BaseActivity) getActivity();
    }
}
