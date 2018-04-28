package com.duokan.reader;

import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;

import com.duokan.core.app.BaseActivity;
import com.duokan.core.p027b.C0324a;
import com.duokan.core.sys.ah;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;

import org.apache.http.HttpHost;
import org.apache.http.cookie.ClientCookie;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DkRouter {
    /* renamed from: a */
    private BaseActivity f1452a;
    /* renamed from: b */
    private ReaderController readerController;

    private DkRouter(BaseActivity mActivity) {
        this.f1452a = mActivity;
    }

    public DkRouter(ReaderController readerController) {
        this.readerController = readerController;
    }

    public static DkRouter from(ReaderController readerController) {
        return new DkRouter(readerController);
    }

    public static DkRouter from(BaseActivity mActivity) {
        return new DkRouter(mActivity);
    }

    public boolean route(String str) {
        if (this.readerController.getActivity() instanceof DkMainActivity) {
            return false;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(DkApp.get(), DkReader.get().getMainActivityClass()));
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.readerController.getActivity().startActivity(intent);
        this.readerController.getActivity().finish();
        return true;
    }

    public boolean route(Intent intent) {
        if (this.f1452a == null || intent == null) {
            return false;
        }
        CharSequence action = intent.getAction();
        final Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        final Map parseUri = parseUri(data);
        final boolean z = C0324a.m735a(data.toString(), "file", "content") && TextUtils.equals(intent.getAction(), "android.intent.action.VIEW");
        if (parseUri.containsKey("book") || z) {
            final Intent intent2 = intent;
            ah.m871b(new Runnable() {

                class C04403 implements Runnable {


                    public void run() {
                        if (f1452a.getContentController() == null) {
                            goToReaderActivity();
                        }
                    }
                }

                public void run() {
                    String str = null;
                    ai a;
                    Cursor cursor = null;
                    final boolean booleanExtra = intent2.getBooleanExtra("miback", false);
                    if (z) {
                        try {
                            if (VERSION.SDK_INT < 24 || !ReaderEnv.get().onMiui()) {
                                cursor = null;
                            } else {
                                cursor = DkApp.get().getContentResolver().query(data, new String[]{"_data"}, null, null, null);
                                if (cursor != null) {
                                    if (cursor.moveToFirst()) {
                                        str = cursor.getString(cursor.getColumnIndex("_data"));
                                    }
                                }
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                        }

                        a = ai.m3980a();
                        if (TextUtils.isEmpty(str)) {
                            str = data.getPath();
                        }
                        final C0800c a2 = a.m3876a(new File(str));
                        DkApp.get().runWhenAppReady(new Runnable() {

                            public void run() {
                                if (a2 != null) {
                                    DkReaderController from = DkReaderController.from(f1452a, a2);
                                    from.setQuitOnBack(booleanExtra);
                                    f1452a.setContentController(from);
                                }
                            }
                        });
                    } else {
                        DkApp.get().runWhenAppReady(new Runnable() {

                            public void run() {
                                DkReaderController from = DkReaderController.from(f1452a, (String) parseUri.get("book"));
                                if (from != null) {
                                    from.setQuitOnBack(booleanExtra);
                                }
                                f1452a.setContentController(from);
                            }
                        });
                    }
                    DkApp.get().runWhenAppReady(new C04403());
                }
            });
            return true;
        } else if ((!TextUtils.equals(action, "android.intent.action.VIEW") && !TextUtils.isEmpty(action)) || TextUtils.isEmpty((CharSequence) parseUri.get("simple-web"))) {
            return false;
        } else {
            this.f1452a.setContentController(DkReaderController.from(this.f1452a, Uri.parse((String) parseUri.get("simple-web"))));
            return true;
        }
    }

    private void goToReaderActivity() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(DkApp.get(), DkApp.get().getReaderActivityClass()));
        intent.setFlags(0);
        this.f1452a.startActivity(intent);
        this.f1452a.finish();
    }

    public static Map<String, String> parseUri(Uri uri) {
        CharSequence scheme = uri.getScheme();
        CharSequence path = uri.getPath();
        Map<String, String> hashMap = new HashMap();
        try {
            if (!TextUtils.isEmpty(scheme) && (TextUtils.equals(scheme, HttpHost.DEFAULT_SCHEME_NAME) || TextUtils.equals(scheme, "https") || TextUtils.equals(scheme, "duokan-reader"))) {
                String queryParameter = uri.getQueryParameter("miref");
                String queryParameter2 = uri.getQueryParameter("miback");
                hashMap.put("miref", queryParameter);
                hashMap.put("miback", queryParameter2);
                if (TextUtils.equals(scheme, "duokan-reader")) {
                    hashMap.put(ClientCookie.PATH_ATTR, uri.toString());
                    String lastPathSegment = uri.getLastPathSegment();
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
                C0641o i;
                String group;
                if (matcher.find()) {
                    hashMap.put(ClientCookie.PATH_ATTR, "duokan-reader://store/book/" + matcher.group(1));
                    if (!Boolean.valueOf(queryParameter2).booleanValue()) {
                        return hashMap;
                    }
                    str = "simple-web";
                    i = C0641o.m2934i();
                    String str2 = "0";
                    group = matcher.group(1);
                    if (TextUtils.isEmpty(queryParameter)) {
                        queryParameter = "external";
                    }
                    hashMap.put(str, i.m2954a(str2, 1, group, queryParameter));
                    return hashMap;
                }
                matcher = Pattern.compile("/m/special/([0-9a-zA-Z]+)").matcher(path);
                if (matcher.find()) {
                    hashMap.put(ClientCookie.PATH_ATTR, "duokan-reader://store/list/" + matcher.group(1));
                    if (!Boolean.valueOf(queryParameter2).booleanValue()) {
                        return hashMap;
                    }
                    str = "simple-web";
                    i = C0641o.m2934i();
                    group = matcher.group(1);
                    if (TextUtils.isEmpty(queryParameter)) {
                        queryParameter = "external";
                    }
                    hashMap.put(str, i.m2966c(group, queryParameter));
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
