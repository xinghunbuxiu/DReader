package com.duokan.reader;

import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.sys.ah;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;

import org.apache.http.HttpHost;
import org.apache.http.cookie.ClientCookie;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DkRouter {
    private BaseActivity a;
    private ReaderController b;

    private DkRouter(BaseActivity baseActivityVar) {
        this.a = baseActivityVar;
    }

    public DkRouter(ReaderController readerController) {
        this.b = readerController;
    }

    public static DkRouter from(ReaderController readerController) {
        return new DkRouter(readerController);
    }

    public static DkRouter from(BaseActivity baseActivityVar) {
        return new DkRouter(baseActivityVar);
    }

    public boolean route(String str) {
        if (this.b.getActivity() instanceof DkMainActivity) {
            return false;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(DkApp.get(), DkReader.get().getMainActivityClass()));
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.b.getActivity().startActivity(intent);
        this.b.getActivity().finish();
        return true;
    }

    public boolean route(Intent intent) {
        if (this.a == null || intent == null) {
            return false;
        }
        CharSequence action = intent.getAction();
        final Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        final Map parseUri = parseUri(data);
        final boolean z = a.a(data.toString(), "file", "content") && TextUtils.equals(intent.getAction(), "android.intent.action.VIEW");
        if (parseUri.containsKey("book") || z) {
            final Intent intent2 = intent;
            ah.b(new Runnable(this) {
                final /* synthetic */ DkRouter e;

                public void run() {
                    String str;
                    ai a;
                    final c a2;
                    Throwable th;
                    Cursor cursor = null;
                    final boolean booleanExtra = intent2.getBooleanExtra("miback", false);
                    if (z) {
                        Cursor cursor2;
                        try {
                            if (VERSION.SDK_INT < 24 || !ReaderEnv.get().onMiui()) {
                                cursor2 = null;
                            } else {
                                cursor2 = DkApp.get().getContentResolver().query(data, new String[]{"_data"}, null, null, null);
                                if (cursor2 != null) {
                                    try {
                                        if (cursor2.moveToFirst()) {
                                            cursor = cursor2.getString(cursor2.getColumnIndex("_data"));
                                        }
                                    } catch (Throwable th2) {
                                        cursor = cursor2;
                                        th = th2;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            if (cursor2 != null) {
                                cursor2.close();
                                str = cursor;
                            } else {
                                Object obj = cursor;
                            }
                        } catch (Throwable th3) {
                        }
                        a = ai.a();
                        if (TextUtils.isEmpty(str)) {
                            str = data.getPath();
                        }
                        a2 = a.a(new File(str));
                        DkApp.get().runWhenAppReady(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 c;

                            public void run() {
                                if (a2 != null) {
                                    ActivatedController from = DkReaderController.from(this.c.e.a, a2);
                                    from.setQuitOnBack(booleanExtra);
                                    this.c.e.a.setContentController(from);
                                }
                            }
                        });
                    } else {
                        DkApp.get().runWhenAppReady(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 b;

                            public void run() {
                                ActivatedController from = DkReaderController.from(this.b.e.a, (String) parseUri.get("book"));
                                if (from != null) {
                                    from.setQuitOnBack(booleanExtra);
                                }
                                this.b.e.a.setContentController(from);
                            }
                        });
                    }
                    DkApp.get().runWhenAppReady(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            if (this.a.e.a.getContentController() == null) {
                                this.a.e.goToReaderActivity();
                            }
                        }
                    });
                }
            });
            return true;
        } else if ((!TextUtils.equals(action, "android.intent.action.VIEW") && !TextUtils.isEmpty(action)) || TextUtils.isEmpty((CharSequence) parseUri.get("simple-web"))) {
            return false;
        } else {
            this.a.setContentController(DkReaderController.from(this.a, Uri.parse((String) parseUri.get("simple-web"))));
            return true;
        }
    }

    private void goToReaderActivity() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(DkApp.get(), DkApp.get().getReaderActivityClass()));
        intent.setFlags(0);
        this.a.startActivity(intent);
        this.a.finish();
    }

    public static Map parseUri(Uri uri) {
        CharSequence scheme = uri.getScheme();
        CharSequence path = uri.getPath();
        Map hashMap = new HashMap();
        try {
            if (!TextUtils.isEmpty(scheme) && (TextUtils.equals(scheme, HttpHost.DEFAULT_SCHEME_NAME) || TextUtils.equals(scheme, "https") || TextUtils.equals(scheme, "duokan-reader"))) {
                String queryParameter = uri.getQueryParameter("miref");
                String queryParameter2 = uri.getQueryParameter("miback");
                hashMap.put("miref", queryParameter);
                hashMap.put("miback", queryParameter2);
                if (TextUtils.equals(scheme, "duokan-reader")) {
                    hashMap.put(ClientCookie.PATH_ATTR, uri.toString());
                    CharSequence lastPathSegment = uri.getLastPathSegment();
                    if (Boolean.valueOf(queryParameter2).booleanValue() && TextUtils.equals(uri.getHost(), "reading") && !TextUtils.isEmpty(lastPathSegment)) {
                        if (lastPathSegment.equals("recently")) {
                            hashMap.put("book", "");
                            return hashMap;
                        } else if (TextUtils.isEmpty(lastPathSegment)) {
                            return hashMap;
                        } else {
                            hashMap.put("book", lastPathSegment);
                            return hashMap;
                        }
                    } else if (!TextUtils.equals(uri.getHost(), HttpHost.DEFAULT_SCHEME_NAME) && !TextUtils.equals(uri.getHost(), "https")) {
                        return hashMap;
                    } else {
                        queryParameter = uri.toString().replaceFirst(String.format("duokan-reader://%s/", new Object[]{uri.getHost()}), uri.getHost() + "://");
                        hashMap.put(ClientCookie.PATH_ATTR, queryParameter);
                        if (!Boolean.valueOf(queryParameter2).booleanValue()) {
                            return hashMap;
                        }
                        hashMap.put("simple-web", queryParameter);
                        return hashMap;
                    }
                }
                Matcher matcher = Pattern.compile("/m/book/([0-9a-zA-Z]+)").matcher(path);
                String str;
                p i;
                String group;
                if (matcher.find()) {
                    hashMap.put(ClientCookie.PATH_ATTR, "duokan-reader://store/book/" + matcher.group(1));
                    if (!Boolean.valueOf(queryParameter2).booleanValue()) {
                        return hashMap;
                    }
                    str = "simple-web";
                    i = p.i();
                    String str2 = "0";
                    group = matcher.group(1);
                    if (TextUtils.isEmpty(queryParameter)) {
                        queryParameter = "external";
                    }
                    hashMap.put(str, i.a(str2, 1, group, queryParameter));
                    return hashMap;
                }
                matcher = Pattern.compile("/m/special/([0-9a-zA-Z]+)").matcher(path);
                if (matcher.find()) {
                    hashMap.put(ClientCookie.PATH_ATTR, "duokan-reader://store/list/" + matcher.group(1));
                    if (!Boolean.valueOf(queryParameter2).booleanValue()) {
                        return hashMap;
                    }
                    str = "simple-web";
                    i = p.i();
                    group = matcher.group(1);
                    if (TextUtils.isEmpty(queryParameter)) {
                        queryParameter = "external";
                    }
                    hashMap.put(str, i.c(group, queryParameter));
                    return hashMap;
                } else if (Pattern.compile("/m/u/coupon").matcher(path).find()) {
                    hashMap.put(ClientCookie.PATH_ATTR, "duokan-reader://personal/coupons");
                    return hashMap;
                } else {
                    Matcher matcher2 = Pattern.compile("/search/(.*)[/?]*").matcher(path);
                    if (matcher2.find()) {
                        hashMap.put(ClientCookie.PATH_ATTR, "duokan-reader://store/search?key=" + matcher2.group(1));
                        return hashMap;
                    }
                    hashMap.put(ClientCookie.PATH_ATTR, uri.toString());
                    if (!Boolean.valueOf(queryParameter2).booleanValue()) {
                        return hashMap;
                    }
                    hashMap.put("simple-web", uri.toString());
                    return hashMap;
                }
            }
        } catch (Throwable th) {
        }
        return new HashMap();
    }
}
