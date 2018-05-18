package com.duokan.reader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.io.FileUtil;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.BaseDialog;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;
import com.duokan.core.ui.et;
import com.duokan.p024c.C0254f;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.ac;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.statistics.C1163a;

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

public class WelcomeDialog extends BaseDialog {

    private static final long MILLIS = TimeUnit.MINUTES.toMillis(30);

    private static WebSession webSession = null;

    private static long f1704c = 0;

    private final boolean f1705d;

    private final StateListener stateListener;

    private ImageView welcome_view__pic;

    private Drawable welcome_view_bg = null;

    private Uri uri = null;

    private RectF rectF = null;

    private boolean f1711j = false;

    private boolean f1712k = false;

    private long welcome_view_delay_time = 0;

    public interface StateListener {
        void onEnd(Uri uri);
    }


    class C04973 implements cu {

        final WelcomeDialog f1672a;

        C04973(WelcomeDialog welcomeDialog) {
            this.f1672a = welcomeDialog;
        }

        public void onTouchUp(View view, PointF pointF) {
        }

        public void onTouchDown(View view, PointF pointF) {
        }

        public void onTouchCancel(View view, PointF pointF) {
        }

        public void onTap(er erVar, View view, PointF pointF) {
            if (this.f1672a.welcome_view_bg != null && this.f1672a.rectF != null) {
                RectF rectF = (RectF) AnimUtils.f1199h.addAnimation();
                Rect bounds = this.f1672a.welcome_view_bg.getBounds();
                rectF.set(this.f1672a.rectF.left * ((float) bounds.width()), this.f1672a.rectF.top * ((float) bounds.width()), this.f1672a.rectF.right * ((float) bounds.width()), this.f1672a.rectF.bottom * ((float) bounds.width()));
                if (rectF.contains(pointF.x - ((float) bounds.left), pointF.y - ((float) bounds.top))) {
                    f1711j = true;
                    doFinishShow();
                }
                AnimUtils.f1199h.clearAnimation(rectF);
            }
        }
    }


    final class C05045 extends WebSession {

        final al f1688a;

        final long f1689b;

        C05045(al alVar, long j) {
            this.f1688a = alVar;
            this.f1689b = j;
        }

        protected void onSessionTry() {
            File cacheDir = DkReader.get().getCacheDir();
            File file = new File(cacheDir, "splash.config");
            File file2 = new File(cacheDir, "splash.config.tmp");
            String format = String.format(Locale.US, C0641o.m2934i().m2995v() + "?user_type=%d&device_id=%s&app_id=%s&build=%d&channel=%s", new Object[]{Integer.valueOf(PersonalPrefs.m5175a().m5210b()), ReaderEnv.get().getDeviceId(), ReaderEnv.get().getAppId(), Integer.valueOf(ReaderEnv.get().getVersionCode()), ReaderEnv.get().getDistChannel()});
            ac acVar = new ac((WebSession) this, this.f1688a);
            FileUtil.deleteFile(file2);
            if (acVar.m549a(format, file2, true)) {
                file2.renameTo(file);
            }
            for (SplashInfo splashInfo : WelcomeDialog.listSplashInfos(file)) {
                if (!splashInfo.file.exists()) {
                    acVar.m549a(splashInfo.string, splashInfo.file, true);
                }
            }
        }

        protected void onSessionSucceeded() {
            WelcomeDialog.webSession = null;
            WelcomeDialog.f1704c = this.f1689b;
        }

        protected void onSessionFailed() {
            WelcomeDialog.webSession = null;
        }
    }


    final class C05056 implements Runnable {
        C05056() {
        }

        public void run() {
            WelcomeDialog.webSession.open();
        }
    }


    class C05077 implements Runnable {

        final WelcomeDialog f1692a;


        class C05061 implements Runnable {

            final C05077 f1690a;

            private boolean f1691b = false;

            C05061(C05077 c05077) {
                this.f1690a = c05077;
            }

            public void run() {
                if (!this.f1691b) {
                    this.f1691b = true;
                    C1163a.m8627k().m8634a(this.f1690a.f1692a.uri, this.f1690a.f1692a.f1711j);
                    this.f1690a.f1692a.dismiss();
                    if (this.f1690a.f1692a.stateListener != null) {
                        this.f1690a.f1692a.stateListener.onEnd(this.f1690a.f1692a.f1711j ? this.f1690a.f1692a.uri : null);
                    }
                }
            }
        }

        C05077(WelcomeDialog welcomeDialog) {
            this.f1692a = welcomeDialog;
        }

        public void run() {
            Runnable runnable = new C05061(this);
            DkApp.get().runWhenUiReady(runnable);
            UThread.postDelayed(runnable, TimeUnit.SECONDS.toMillis(2));
        }
    }

    class SplashInfo {

        public int f1693a;

        public int f1694b;

        public long f1695c;

        public long f1696d;

        public int f1697e;

        public final RectF rectF1;

        public Uri uri1;

        public File file;

        public String string;

        private SplashInfo() {
            this.f1693a = 0;
            this.f1694b = 0;
            this.f1695c = 0;
            this.f1696d = 0;
            this.f1697e = 0;
            this.rectF1 = new RectF();
            this.uri1 = null;
            this.file = null;
            this.string = "";
        }
    }

    public WelcomeDialog(Context context, boolean z, StateListener stateListener) {
        super(context);
        this.f1705d = z;
        this.stateListener = stateListener;
        setContentView(R.id.welcome__welcome_view);
        setDimAmount(0.0f);
    }

    protected void onShow() {
        super.onShow();
        final long currentTimeMillis = System.currentTimeMillis();
        final View findViewById = findViewById(R.id.welcome__welcome_view__skip);
        findViewById.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                f1711j = false;
                doFinishShow();
            }
        });
        findViewById.setVisibility(View.INVISIBLE);
        final View findViewById2 = findViewById(R.id.welcome__welcome_view__shadow);
        findViewById2.setVisibility(View.INVISIBLE);
        this.welcome_view_delay_time = Integer.valueOf(getContext().getString(R.id.welcome__welcome_view__delay_time)).intValue();
        this.welcome_view__pic = (ImageView) findViewById(R.id.welcome__welcome_view__pic);
        this.welcome_view__pic.setDrawingCacheEnabled(true);
        this.welcome_view__pic.setWillNotCacheDrawing(true);
        this.welcome_view__pic.setBackgroundDrawable(new Drawable() {
            @Override
            public void draw(@NonNull Canvas canvas) {
                if (welcome_view_bg != null) {
                    int width = getBounds().width();
                    int height = getBounds().height();
                    int intrinsicWidth = welcome_view_bg.getIntrinsicWidth();
                    int intrinsicHeight = welcome_view_bg.getIntrinsicHeight();
                    float max = Math.max(((float) getBounds().width()) / ((float) intrinsicWidth), ((float) getBounds().height()) / ((float) intrinsicHeight));
                    welcome_view_bg.setBounds(Math.round((-((((float) intrinsicWidth) * max) - ((float) width))) / 2.0f), Math.round((-((((float) intrinsicHeight) * max) - ((float) height))) / 2.0f), Math.round((((float) intrinsicWidth) * max) + ((-((((float) intrinsicWidth) * max) - ((float) width))) / 2.0f)), Math.round((((float) intrinsicHeight) * max) + ((-((((float) intrinsicHeight) * max) - ((float) height))) / 2.0f)));
                    canvas.save();
                    canvas.clipRect(0, 0, width, height);
                    welcome_view_bg.draw(canvas);
                    canvas.restore();
                }
            }

            @Override
            public void setAlpha(int alpha) {

            }

            @Override
            public void setColorFilter(@Nullable ColorFilter colorFilter) {

            }

            @Override
            public int getOpacity() {
                return PixelFormat.OPAQUE;
            }
        });
        et etVar = new et();
        etVar.m2041a(new ct());
        etVar.m2042a(new C04973(this));
        etVar.m2046b(this.welcome_view__pic);
        ah.m871b(new Runnable(this) {

            class C05001 implements Runnable {

                final C05034 f1675a;


                class C04991 implements Runnable {

                    final C05001 f1674a;


                    class C04981 implements Runnable {

                        final C04991 f1673a;

                        C04981(C04991 c04991) {
                            this.f1673a = c04991;
                        }

                        public void run() {
                            this.f1673a.f1674a.f1675a.f1687d.doFinishShow();
                        }
                    }

                    C04991(C05001 c05001) {
                        this.f1674a = c05001;
                    }

                    public void run() {
                        UThread.postDelayed(new C04981(this), this.f1674a.f1675a.f1687d.f1713l);
                    }
                }

                C05001(C05034 c05034) {
                    this.f1675a = c05034;
                }

                public void run() {
                    WebLog.init().w();
                    AnimUtils.startAlphaAnimation(this.f1675a.f1687d.f1707f, 0.0f, 1.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, true, new C04991(this));
                }
            }

            public void run() {
                Drawable drawable;
                SplashInfo splashInfo;
                int i = 0;
                if (this.f1687d.f1705d) {
                    drawable = this.f1687d.getContext().getResources().getDrawable(C0254f.welcome__welcome_view__default_pic);
                    splashInfo = null;
                } else {
                    Drawable bitmapDrawable;
                    splashInfo = getShowableSplashInfo();
                    if (splashInfo != null) {
                        try {
                            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
                            Options options = new Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeFile(splashInfo.file.getAbsolutePath(), options);
                            Options options2 = new Options();
                            options2.inSampleSize = Math.min(options.outWidth / displayMetrics.widthPixels, options.outHeight / displayMetrics.heightPixels);
                            Bitmap decodeFile = BitmapFactory.decodeFile(splashInfo.file.getAbsolutePath(), options2);
                            if (decodeFile != null) {
                                bitmapDrawable = new BitmapDrawable(this.f1687d.getContext().getResources(), decodeFile);
                                drawable = bitmapDrawable;
                                if (drawable == null) {
                                    i = (this.f1687d.getContext().getResources().getDrawable(C0254f.general__shared__welcome_logo).getIntrinsicHeight() * 3) / 2;
                                } else {
                                    drawable = this.f1687d.getContext().getResources().getDrawable(C0254f.welcome__welcome_view__default_pic);
                                    if (splashInfo != null) {
                                        splashInfo.f1693a = 0;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            drawable = null;
                        }
                    }
                    bitmapDrawable = null;
                    drawable = bitmapDrawable;
                    if (drawable == null) {
                        drawable = this.f1687d.getContext().getResources().getDrawable(C0254f.welcome__welcome_view__default_pic);
                        if (splashInfo != null) {
                            splashInfo.f1693a = 0;
                        }
                    } else {
                        i = (this.f1687d.getContext().getResources().getDrawable(C0254f.general__shared__welcome_logo).getIntrinsicHeight() * 3) / 2;
                    }
                }
                final Runnable c05001 = new C05001(this);
                if (splashInfo == null || splashInfo.f1693a == 0) {
                    long j;
                    Runnable c05023 = new Runnable(this) {

                        final C05034 f1683c;

                        public void run() {
                            this.f1683c.f1687d.f1707f.setImageDrawable(drawable);
                            if (DkApp.get().isUiReady()) {
                                this.f1683c.f1687d.doFinishShow();
                            } else {
                                c05001.run();
                            }
                        }
                    };
                    if (DkApp.get().isUiReady()) {
                        j = 0;
                    } else {
                        j = Math.max(0, 200 - (System.currentTimeMillis() - currentTimeMillis));
                    }
                    UThread.postDelayed(c05023, j);
                    return;
                }
                UThread.post(new Runnable(this) {

                    final C05034 f1680e;

                    public void run() {
                        this.f1680e.f1687d.f1708g = drawable;
                        this.f1680e.f1687d.f1707f.setTranslationY((float) (-i));
                        this.f1680e.f1687d.f1707f.invalidate();
                        this.f1680e.f1687d.f1713l = 1000;
                        if (WelcomeDialog.lastShownSplashId() != splashInfo.f1693a) {
                            WelcomeDialog.lastShownSplashId(splashInfo.f1693a);
                            if (splashInfo.f1697e > 0) {
                                this.f1680e.f1687d.f1713l = TimeUnit.SECONDS.toMillis((long) splashInfo.f1697e);
                            } else {
                                this.f1680e.f1687d.f1713l = 3000;
                            }
                        }
                        this.f1680e.f1687d.f1710i = splashInfo.rectF1;
                        this.f1680e.f1687d.f1709h = splashInfo.uri1;
                        findViewById2.setVisibility(0);
                        if (this.f1680e.f1687d.f1709h != null) {
                            findViewById.setVisibility(0);
                        }
                        c05001.run();
                    }
                });
            }
        });
    }

    protected boolean onBack() {
        if (this.uri == null) {
            doFinishShow();
        }
        return true;
    }

    public static boolean hasShowableSplash() {
        return getShowableSplashInfo() != null;
    }

    public static boolean hasNewShowableSplash() {
        SplashInfo showableSplashInfo = getShowableSplashInfo();
        if (showableSplashInfo == null || lastShownSplashId() == showableSplashInfo.f1693a) {
            return false;
        }
        return true;
    }

    public static void fetchNewSplash() {
        if (C0559f.m2476b().m2486e() && webSession == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f1704c >= MILLIS) {
                webSession = new C05045(C0709k.m3476a().m3511f(), currentTimeMillis);
                DkReader.get().runWhenUiReady(new C05056());
            }
        }
    }

    private void doFinishShow() {
        if (this.f1712k) {
            this.f1712k = false;
            DkApp.get().runWhenAppReady(new C05077(this));
        }
    }

    private static SplashInfo getShowableSplashInfo() {
        SplashInfo splashInfo = null;
        List<SplashInfo> listSplashInfos = listSplashInfos(new File(DkReader.get().getCacheDir(), "splash.config"));
        if (!listSplashInfos.isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            for (SplashInfo splashInfo2 : listSplashInfos) {
                SplashInfo splashInfo22;
                if (currentTimeMillis < splashInfo22.f1695c ||
                        currentTimeMillis >= splashInfo22.f1696d ||
                        !splashInfo22.file.exists() ||
                        (splashInfo != null && splashInfo.f1694b >= splashInfo22.f1694b && (splashInfo.f1694b != splashInfo22.f1694b ||
                                splashInfo.f1695c >= splashInfo22.f1695c))) {
                    splashInfo22 = splashInfo;
                }
                splashInfo = splashInfo22;
            }
        }
        return splashInfo;
    }

    private static List<SplashInfo> listSplashInfos(File file) {
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
                File file2 = new File(cacheDir, String.format("splash%d.img", new Object[]{Integer.valueOf(i2)}));
                if (currentTimeMillis < j2) {
                    SplashInfo splashInfo = new SplashInfo();
                    if (jsonObjectFromFile.has("trigger")) {
                        try {
                            JSONArray jSONArray2 = jsonObjectFromFile.getJSONArray("trigger");
                            splashInfo.rectF1.left = (float) jSONArray2.getDouble(0);
                            splashInfo.rectF1.top = (float) jSONArray2.getDouble(1);
                            splashInfo.rectF1.right = splashInfo.rectF1.left + ((float) jSONArray2.getDouble(2));
                            splashInfo.rectF1.bottom = ((float) jSONArray2.getDouble(3)) + splashInfo.rectF1.top;
                        } catch (Throwable th) {
                        }
                    }
                    splashInfo.f1693a = i2;
                    splashInfo.f1694b = i3;
                    splashInfo.f1695c = j;
                    splashInfo.f1696d = j2;
                    splashInfo.f1697e = optInt;
                    splashInfo.uri1 = TextUtils.isEmpty(optString) ? null : Uri.parse(optString);
                    splashInfo.string = string;
                    splashInfo.file = file2;
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
        this.f1712k = true;
    }
}
