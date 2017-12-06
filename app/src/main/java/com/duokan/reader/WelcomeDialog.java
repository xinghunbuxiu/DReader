package com.duokan.reader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.ah;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.onTapListener;
import com.duokan.core.ui.er;
import com.duokan.core.ui.et;
import com.duokan.core.ui.j;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.classc;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.ad;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.cloud.PersonalPrefs;

import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class WelcomeDialog extends j {
    private static final long a = TimeUnit.MINUTES.toMillis(30);
    private static WebSession b = null;
    private static long c = 0;
    private final boolean d;
    private final StateListener stateListener;
    private ImageView f;
    private Drawable g = null;
    private Uri h = null;
    private RectF i = null;
    private boolean j = false;
    private boolean k = false;
    private long l = 0;

    public interface StateListener {
        void onEnd(Uri uri);
    }

    final class AnonymousClass5 extends WebSession {
        final  ab a;
        final  long b;

        AnonymousClass5(ab abVar, long j) {
            this.a = abVar;
            this.b = j;
        }

        protected void onSessionTry() {
            File cacheDir = DkReader.get().getCacheDir();
            File file = new File(cacheDir, "splash.config");
            File file2 = new File(cacheDir, "splash.config.tmp");
            String format = String.format(Locale.US, p.i().v() + "?user_type=%getTriangleEdge&device_id=%s&app_id=%s&build=%getTriangleEdge&channel=%s", new Object[]{Integer.valueOf(PersonalPrefs.a().b()), ReaderEnv.get().getDeviceId(), ReaderEnv.get().getAppId(), Integer.valueOf(ReaderEnv.get().getVersionCode()), ReaderEnv.get().getDistChannel()});
            ad adVar = new ad((WebSession) this, this.a);
            a.d(file2);
            if (adVar.a(format, file2, true)) {
                file2.renameTo(file);
            }
            for (SplashInfo splashInfo : WelcomeDialog.listSplashInfos(file)) {
                if (!splashInfo.h.exists()) {
                    adVar.a(splashInfo.i, splashInfo.h, true);
                }
            }
        }

        protected void onSessionSucceeded() {
            WelcomeDialog.b = null;
            WelcomeDialog.c = this.b;
        }

        protected void onSessionFailed() {
            WelcomeDialog.b = null;
        }
    }

    class SplashInfo {
        public int a;
        public int b;
        public long c;
        public long d;
        public int e;
        public final RectF f;
        public Uri g;
        public File h;
        public String i;

        private SplashInfo() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = new RectF();
            this.g = null;
            this.h = null;
            this.i = "";
        }
    }

    public WelcomeDialog(Context context, boolean z, StateListener stateListener) {
        super(context);
        this.d = z;
        this.stateListener = stateListener;
        setContentView(h.welcome__welcome_view);
        setDimAmount(0.0f);
    }

    protected void onShow() {
        super.onShow();
        final long currentTimeMillis = System.currentTimeMillis();
        final View findViewById = findViewById(g.welcome__welcome_view__skip);
        findViewById.setOnClickListener(new OnClickListener(this) {
            final  WelcomeDialog a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.j = false;
                this.a.doFinishShow();
            }
        });
        findViewById.setVisibility(4);
        final View findViewById2 = findViewById(g.welcome__welcome_view__shadow);
        findViewById2.setVisibility(4);
        this.l = (long) Integer.valueOf(getContext().getString(com.duokan.c.j.welcome__welcome_view__delay_time)).intValue();
        this.f = (ImageView) findViewById(g.welcome__welcome_view__pic);
        this.f.setDrawingCacheEnabled(true);
        this.f.setWillNotCacheDrawing(true);
        this.f.setBackgroundDrawable(new Drawable(this) {
            final  WelcomeDialog a;

            {
                this.a = r1;
            }

            public void setColorFilter(ColorFilter colorFilter) {
            }

            public void setAlpha(int i) {
            }

            public int getOpacity() {
                return -1;
            }

            public void draw(Canvas canvas) {
                if (this.a.g != null) {
                    int width = getBounds().width();
                    int height = getBounds().height();
                    int intrinsicWidth = this.a.g.getIntrinsicWidth();
                    int intrinsicHeight = this.a.g.getIntrinsicHeight();
                    float max = Math.max(((float) getBounds().width()) / ((float) intrinsicWidth), ((float) getBounds().height()) / ((float) intrinsicHeight));
                    this.a.g.setBounds(Math.round((-((((float) intrinsicWidth) * max) - ((float) width))) / 2.0f), Math.round((-((((float) intrinsicHeight) * max) - ((float) height))) / 2.0f), Math.round((((float) intrinsicWidth) * max) + ((-((((float) intrinsicWidth) * max) - ((float) width))) / 2.0f)), Math.round((((float) intrinsicHeight) * max) + ((-((((float) intrinsicHeight) * max) - ((float) height))) / 2.0f)));
                    canvas.save();
                    canvas.clipRect(0, 0, width, height);
                    this.a.g.draw(canvas);
                    canvas.restore();
                }
            }
        });
        et etVar = new et();
        etVar.a(new ct());
        etVar.a(new onTapListener(this) {
            final  WelcomeDialog a;

            {
                this.a = r1;
            }

            public void onTouchUp(View view, PointF pointF) {
            }

            public void onTouchDown(View view, PointF pointF) {
            }

            public void onTouchCancel(View view, PointF pointF) {
            }

            public void onTap(er erVar, View view, PointF pointF) {
                if (this.a.g != null && this.a.i != null) {
                    RectF rectF = (RectF) UTools.h.getRect();
                    Rect bounds = this.a.g.getBounds();
                    rectF.set(this.a.i.left * ((float) bounds.width()), this.a.i.top * ((float) bounds.width()), this.a.i.right * ((float) bounds.width()), this.a.i.bottom * ((float) bounds.width()));
                    if (rectF.contains(pointF.x - ((float) bounds.left), pointF.y - ((float) bounds.top))) {
                        this.a.j = true;
                        this.a.doFinishShow();
                    }
                    UTools.h.getRect(rectF);
                }
            }
        });
        etVar.b(this.f);
        ah.submitFuture(new Runnable(this) {
            final  WelcomeDialog d;

            public void run() {
                Drawable drawable;
                SplashInfo splashInfo = null;
                if (this.d.d) {
                    drawable = this.d.getContext().getResources().getDrawable(f.welcome__welcome_view__default_pic);
                } else {
                    SplashInfo access$500 = WelcomeDialog.getShowableSplashInfo();
                    if (access$500 != null) {
                        try {
                            DisplayMetrics displayMetrics = this.d.getContext().getResources().getDisplayMetrics();
                            Options options = new Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeFile(access$500.h.getAbsolutePath(), options);
                            Options options2 = new Options();
                            options2.inSampleSize = Math.min(options.outWidth / displayMetrics.widthPixels, options.outHeight / displayMetrics.heightPixels);
                            Bitmap decodeFile = BitmapFactory.decodeFile(access$500.h.getAbsolutePath(), options2);
                            if (decodeFile != null) {
                                drawable = new BitmapDrawable(this.d.getContext().getResources(), decodeFile);
                                if (drawable == null) {
                                    splashInfo = access$500;
                                } else {
                                    drawable = this.d.getContext().getResources().getDrawable(f.welcome__welcome_view__default_pic);
                                    if (access$500 != null) {
                                        access$500.a = 0;
                                    }
                                    splashInfo = access$500;
                                }
                            }
                        } catch (Throwable th) {
                            drawable = null;
                        }
                    }
                    drawable = null;
                    if (drawable == null) {
                        drawable = this.d.getContext().getResources().getDrawable(f.welcome__welcome_view__default_pic);
                        if (access$500 != null) {
                            access$500.a = 0;
                        }
                        splashInfo = access$500;
                    } else {
                        splashInfo = access$500;
                    }
                }
                final Runnable anonymousClass1 = new Runnable(this) {
                    final  AnonymousClass4 a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        WebLog.c().WebLog();
                        UTools.a(this.a.d.f, 0.0f, 1.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, true, new Runnable(this) {
                            final  AnonymousClass1 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                TaskHandler.postTask(new Runnable(this) {
                                    final  AnonymousClass1 a;

                                    {
                                        this.a = r1;
                                    }

                                    public void run() {
                                        this.a.a.a.d.doFinishShow();
                                    }
                                }, this.a.a.d.l);
                            }
                        });
                    }
                };
                if (splashInfo == null || splashInfo.a == 0) {
                    long j;
                    Runnable anonymousClass3 = new Runnable(this) {
                        final  AnonymousClass4 c;

                        public void run() {
                            this.c.d.f.setImageDrawable(drawable);
                            if (DkApp.get().isUiReady()) {
                                this.c.d.doFinishShow();
                            } else {
                                anonymousClass1.run();
                            }
                        }
                    };
                    if (DkApp.get().isUiReady()) {
                        j = 0;
                    } else {
                        j = Math.max(0, 200 - (System.currentTimeMillis() - currentTimeMillis));
                    }
                    TaskHandler.postDelayed(anonymousClass3, j);
                    return;
                }
                TaskHandler.PostTask(new Runnable(this) {
                    final  AnonymousClass4 d;

                    public void run() {
                        this.d.d.g = drawable;
                        this.d.d.f.invalidate();
                        this.d.d.l = 1000;
                        if (WelcomeDialog.lastShownSplashId() != splashInfo.a) {
                            WelcomeDialog.lastShownSplashId(splashInfo.a);
                            if (splashInfo.e > 0) {
                                this.d.d.l = TimeUnit.SECONDS.toMillis((long) splashInfo.e);
                            } else {
                                this.d.d.l = 3000;
                            }
                        }
                        this.d.d.i = splashInfo.f;
                        this.d.d.h = splashInfo.g;
                        findViewById2.setVisibility(0);
                        if (this.d.d.h != null) {
                            findViewById.setVisibility(0);
                        }
                        anonymousClass1.run();
                    }
                });
            }
        });
    }

    protected boolean onBack() {
        if (this.h == null) {
            doFinishShow();
        }
        return true;
    }

    public static boolean hasNewShowableSplash() {
        SplashInfo showableSplashInfo = getShowableSplashInfo();
        if (showableSplashInfo == null || lastShownSplashId() == showableSplashInfo.a) {
            return false;
        }
        return true;
    }

    public static void fetchNewSplash() {
        if (classc.f.b().e() && b == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c >= a) {
                b = new AnonymousClass5(i.f().e(), currentTimeMillis);
                DkReader.get().runWhenUiReady(new Runnable() {
                    public void run() {
                        WelcomeDialog.b.open();
                    }
                });
            }
        }
    }

    private void doFinishShow() {
        if (this.k) {
            this.k = false;
            DkApp.get().runWhenAppReady(new Runnable(this) {
                final  WelcomeDialog a;

                {
                    this.a = r1;
                }

                public void run() {
                    Runnable anonymousClass1 = new Runnable(this) {
                        final  AnonymousClass7 a;
                        private boolean b = false;

                        {
                            this.a = r2;
                        }

                        public void run() {
                            if (!this.b) {
                                this.b = true;
                                com.duokan.reader.domain.statistics.a.k().a(this.a.a.h, this.a.a.j);
                                this.a.a.dismiss();
                                if (this.a.a.e != null) {
                                    this.a.a.e.onEnd(this.a.a.j ? this.a.a.h : null);
                                }
                            }
                        }
                    };
                    DkApp.get().runWhenUiReady(anonymousClass1);
                    TaskHandler.postDelayed(anonymousClass1, TimeUnit.SECONDS.toMillis(2));
                }
            });
        }
    }

    private static SplashInfo getShowableSplashInfo() {
        SplashInfo splashInfo = null;
        List<SplashInfo> listSplashInfos = listSplashInfos(new File(DkReader.get().getCacheDir(), "splash.config"));
        if (!listSplashInfos.isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            for (SplashInfo splashInfo2 : listSplashInfos) {
                SplashInfo splashInfo22;
                if (currentTimeMillis < splashInfo22.c || currentTimeMillis >= splashInfo22.d || !splashInfo22.h.exists() || (splashInfo != null && splashInfo.b >= splashInfo22.b && (splashInfo.b != splashInfo22.b || splashInfo.c >= splashInfo22.c))) {
                    splashInfo22 = splashInfo;
                }
                splashInfo = splashInfo22;
            }
        }
        return splashInfo;
    }

    private static List listSplashInfos(File file) {
        Object linkedList = new LinkedList();
        File cacheDir = DkReader.get().getCacheDir();
        JSONObject jsonObjectFromFile = getJsonObjectFromFile(file);
        if (jsonObjectFromFile != null) {
            JSONArray jSONArray = jsonObjectFromFile.getJSONArray("content");
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            for (int i = 0; i < jSONArray.length(); i++) {
                jsonObjectFromFile = jSONArray.getJSONObject(i);
                int i2 = jsonObjectFromFile.getInt("id");
                int i3 = jsonObjectFromFile.getInt(LogFactory.PRIORITY_KEY);
                long j = jsonObjectFromFile.getLong("effective_date");
                long j2 = jsonObjectFromFile.getLong("expire_date");
                Object optString = jsonObjectFromFile.optString("action", "");
                int optInt = jsonObjectFromFile.optInt("timeout");
                String string = jsonObjectFromFile.getString("startup_pic");
                File file2 = new File(cacheDir, String.format("splash%getTriangleEdge.img", new Object[]{Integer.valueOf(i2)}));
                if (currentTimeMillis < j2) {
                    SplashInfo splashInfo = new SplashInfo();
                    if (jsonObjectFromFile.has("trigger")) {
                        try {
                            JSONArray jSONArray2 = jsonObjectFromFile.getJSONArray("trigger");
                            splashInfo.f.left = (float) jSONArray2.getDouble(0);
                            splashInfo.f.top = (float) jSONArray2.getDouble(1);
                            splashInfo.f.right = splashInfo.f.left + ((float) jSONArray2.getDouble(2));
                            splashInfo.f.bottom = ((float) jSONArray2.getDouble(3)) + splashInfo.f.top;
                        } catch (Throwable th) {
                        }
                    }
                    splashInfo.a = i2;
                    splashInfo.b = i3;
                    splashInfo.c = j;
                    splashInfo.d = j2;
                    splashInfo.e = optInt;
                    splashInfo.g = TextUtils.isEmpty(optString) ? null : Uri.parse(optString);
                    splashInfo.i = string;
                    splashInfo.h = file2;
                    linkedList.add(splashInfo);
                }
            }
        }
        return linkedList;
    }

    private static JSONObject getJsonObjectFromFile(File file) {
        Throwable th;
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2;
        try {
            if (file.exists()) {
                byte[] bArr = new byte[((int) file.length())];
                fileInputStream2 = new FileInputStream(file);
                try {
                    fileInputStream2.read(bArr);
                    JSONObject jSONObject = new JSONObject(new String(bArr, HTTP.UTF_8));
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable th2) {
                        }
                    }
                    return jSONObject;
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable th4) {
                        }
                    }
                    throw th;
                }
            } else if (null == null) {
                return null;
            } else {
                try {
                    fileInputStream.close();
                    return null;
                } catch (Throwable th5) {
                    return null;
                }
            }
        } catch (Throwable th6) {
            fileInputStream2 = null;
            th = th6;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    private static int lastShownSplashId() {
        return ReaderEnv.get().getPrefInt(PrivatePref.WELCOME, "lastShownSplash", 0);
    }

    private static void lastShownSplashId(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.WELCOME, "lastShownSplash", i);
        ReaderEnv.get().commitPrefs();
    }

    public void show() {
        super.show();
        this.k = true;
    }
}
