package com.duokan.reader;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.io.IOUtils;
import com.duokan.core.sys.C0373z;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ag;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.io.Serializable;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class DkPublic {
    /* renamed from: a */
    static final /* synthetic */ boolean f1407a;
    /* renamed from: b */
    private static int f1408b = HttpStatus.SC_SWITCHING_PROTOCOLS;
    /* renamed from: c */
    private static Object f1409c = new Object();

    /* renamed from: com.duokan.reader.DkPublic$1 */
    final class C04271 extends WebSession {
        /* renamed from: a */
        C0621a<String> f1403a = new C0621a();
        /* renamed from: b */
        final /* synthetic */ String f1404b;
        /* renamed from: c */
        final /* synthetic */ ag f1405c;
        /* renamed from: d */
        final /* synthetic */ Runnable f1406d;

        C04271(C0657i c0657i, String str, ag agVar, Runnable runnable) {
            this.f1404b = str;
            this.f1405c = agVar;
            this.f1406d = runnable;
            super(c0657i);
        }

        protected void onSessionTry() {
            this.f1403a = new C0640n(this, null).m2924g(this.f1404b);
        }

        protected void onSessionSucceeded() {
            if (this.f1403a.b == 0) {
                this.f1405c.run(this.f1403a.f2058a);
            } else if (this.f1406d != null) {
                this.f1406d.run();
            }
        }

        protected void onSessionFailed() {
            if (this.f1406d != null) {
                this.f1406d.run();
            }
        }
    }

    static {
        boolean z;
        if (DkPublic.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f1407a = z;
    }

    public static boolean zipFile(File file, File file2) {
        Closeable closeable = null;
        boolean z = false;
        Closeable zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
            try {
                z = zip(file, zipOutputStream);
                IOUtils.close(zipOutputStream);
            } catch (Throwable th) {
                closeable = zipOutputStream;
                IOUtils.close(closeable);
                return z;
            }
        } catch (Throwable th2) {
            IOUtils.close(closeable);
            return z;
        }
        return z;
    }

    public static boolean zip(File file, ZipOutputStream zipOutputStream) {
        Throwable th;
        if (file == null) {
            return false;
        }
        if (file.isFile()) {
            Closeable closeable = null;
            Closeable bufferedInputStream;
            try {
                byte[] bArr = new byte[1024];
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    } catch (Throwable th2) {
                        closeable = bufferedInputStream;
                        th = th2;
                    }
                }
                IOUtils.close(bufferedInputStream);
                try {
                    zipOutputStream.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            } catch (Throwable th3) {
                th = th3;
                IOUtils.close(closeable);
                try {
                    zipOutputStream.closeEntry();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        }
        File[] listFiles = file.listFiles();
        for (File zip : listFiles) {
            if (!zip(zip, zipOutputStream)) {
                return false;
            }
        }
        return true;
    }

    public static boolean unzipRawResource(Context context, int i, File file) {
        if (!f1407a && context == null) {
            throw new AssertionError();
        } else if (f1407a || file != null) {
            boolean unzip;
            InputStream inputStream = null;
            try {
                inputStream = context.getResources().openRawResource(i);
                ZipInputStream zipInputStream = new ZipInputStream(inputStream);
                unzip = unzip(zipInputStream, file);
                zipInputStream.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                unzip = false;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e32) {
                        e32.printStackTrace();
                    }
                }
            }
            return unzip;
        } else {
            throw new AssertionError();
        }
    }

    public static boolean unzipAsset(Context context, String[] strArr, File file) {
        int length;
        InputStream inputStream;
        int i = 0;
        if (!f1407a && context == null) {
            throw new AssertionError();
        } else if (!f1407a && (strArr == null || strArr.length <= 0)) {
            throw new AssertionError();
        } else if (f1407a || file != null) {
            AssetManager assets = context.getAssets();
            InputStream[] inputStreamArr = new InputStream[strArr.length];
            int i2 = 0;
            while (i2 < inputStreamArr.length) {
                try {
                    inputStreamArr[i2] = assets.open(strArr[i2]);
                    i2++;
                } catch (Exception e) {
                    e.printStackTrace();
                    for (InputStream inputStream2 : inputStreamArr) {
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    length = inputStreamArr.length;
                    while (i < length) {
                        inputStream2 = inputStreamArr[i];
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e22) {
                                e22.printStackTrace();
                            }
                        }
                        i++;
                    }
                }
            }
            ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(Arrays.asList(inputStreamArr))));
            boolean unzip = unzip(zipInputStream, file);
            zipInputStream.close();
            length = inputStreamArr.length;
            while (i < length) {
                inputStream2 = inputStreamArr[i];
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e222) {
                        e222.printStackTrace();
                    }
                }
                i++;
            }
            return unzip;
        } else {
            throw new AssertionError();
        }
    }

    public static boolean unzipAsset(Context context, String str, File file) {
        if (!f1407a && context == null) {
            throw new AssertionError();
        } else if (f1407a || file != null) {
            boolean unzip;
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                ZipInputStream zipInputStream = new ZipInputStream(inputStream);
                unzip = unzip(zipInputStream, file);
                zipInputStream.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                unzip = false;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e32) {
                        e32.printStackTrace();
                    }
                }
            }
            return unzip;
        } else {
            throw new AssertionError();
        }
    }

    public static boolean unzip(File file, File file2) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
            boolean unzip = unzip(zipInputStream, file2);
            zipInputStream.close();
            return unzip;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } catch (Error e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean unzip(java.util.zip.ZipInputStream r8, java.io.File r9) {
        /*
        r1 = 0;
        r0 = f1407a;
        if (r0 != 0) goto L_0x000d;
    L_0x0005:
        if (r8 != 0) goto L_0x000d;
    L_0x0007:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x000d:
        r0 = f1407a;
        if (r0 != 0) goto L_0x0019;
    L_0x0011:
        if (r9 != 0) goto L_0x0019;
    L_0x0013:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0019:
        r4 = new java.util.LinkedList;
        r4.<init>();
        r0 = r9.exists();
        if (r0 != 0) goto L_0x002a;
    L_0x0024:
        r9.mkdirs();
        r4.add(r9);
    L_0x002a:
        r0 = r8.getNextEntry();	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
    L_0x002e:
        if (r0 == 0) goto L_0x00e8;
    L_0x0030:
        r2 = r0.getName();	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        r3 = r0.isDirectory();	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        if (r3 == 0) goto L_0x0050;
    L_0x003a:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        r0.<init>(r9, r2);	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        r2 = r0.exists();	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        if (r2 != 0) goto L_0x004b;
    L_0x0045:
        r0.mkdirs();	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        r4.add(r0);	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
    L_0x004b:
        r0 = r8.getNextEntry();	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        goto L_0x002e;
    L_0x0050:
        r5 = new java.io.File;	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        r5.<init>(r9, r2);	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        r4.add(r5);	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        r2 = splitDirctoryPart(r2);	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        if (r2 == 0) goto L_0x006c;
    L_0x005e:
        r3 = new java.io.File;	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        r3.<init>(r9, r2);	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        r2 = r3.exists();	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        if (r2 != 0) goto L_0x006c;
    L_0x0069:
        r3.mkdirs();	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
    L_0x006c:
        r2 = r5.exists();	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        if (r2 == 0) goto L_0x007e;
    L_0x0072:
        r2 = r5.length();	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        r6 = r0.getSize();	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x004b;
    L_0x007e:
        r3 = 0;
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ all -> 0x00ea }
        r2 = new java.io.FileOutputStream;	 Catch:{ all -> 0x00ea }
        r2.<init>(r5);	 Catch:{ all -> 0x00ea }
    L_0x0088:
        r3 = r8.read(r0);	 Catch:{ all -> 0x0093 }
        if (r3 <= 0) goto L_0x00b2;
    L_0x008e:
        r5 = 0;
        r2.write(r0, r5, r3);	 Catch:{ all -> 0x0093 }
        goto L_0x0088;
    L_0x0093:
        r0 = move-exception;
    L_0x0094:
        if (r2 == 0) goto L_0x0099;
    L_0x0096:
        r2.close();	 Catch:{ Exception -> 0x00df, Error -> 0x00c7 }
    L_0x0099:
        throw r0;	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
    L_0x009a:
        r0 = move-exception;
        r0.printStackTrace();
        r2 = r4.iterator();
    L_0x00a2:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x00e4;
    L_0x00a8:
        r0 = r2.next();
        r0 = (java.io.File) r0;
        rm(r0);
        goto L_0x00a2;
    L_0x00b2:
        r2.flush();	 Catch:{ all -> 0x0093 }
        r0 = r2.getFD();	 Catch:{ all -> 0x0093 }
        r0.sync();	 Catch:{ all -> 0x0093 }
        if (r2 == 0) goto L_0x004b;
    L_0x00be:
        r2.close();	 Catch:{ Exception -> 0x00c2, Error -> 0x00c7 }
        goto L_0x004b;
    L_0x00c2:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        goto L_0x004b;
    L_0x00c7:
        r0 = move-exception;
        r0.printStackTrace();
        r2 = r4.iterator();
    L_0x00cf:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x00e6;
    L_0x00d5:
        r0 = r2.next();
        r0 = (java.io.File) r0;
        rm(r0);
        goto L_0x00cf;
    L_0x00df:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ Exception -> 0x009a, Error -> 0x00c7 }
        goto L_0x0099;
    L_0x00e4:
        r0 = r1;
    L_0x00e5:
        return r0;
    L_0x00e6:
        r0 = r1;
        goto L_0x00e5;
    L_0x00e8:
        r0 = 1;
        goto L_0x00e5;
    L_0x00ea:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0094;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.DkPublic.unzip(java.util.zip.ZipInputStream, java.io.File):boolean");
    }

    public static boolean getBookListFromStorage(File file, Map<String, Integer> map) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(readFile(new File(file + "/BookInfos", "meta_file.json")));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("channel");
                String string2 = jSONObject.getString("book_id");
                boolean z = true;
                switch (string.hashCode()) {
                    case -862855404:
                        if (string.equals("fiction")) {
                            z = false;
                            break;
                        }
                        break;
                    case 3029737:
                        if (string.equals("book")) {
                            z = true;
                            break;
                        }
                        break;
                    case 94843483:
                        if (string.equals("comic")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        map.put(string2, Integer.valueOf(1));
                        break;
                    case true:
                        map.put(string2, Integer.valueOf(2));
                        break;
                    default:
                        map.put(string2, Integer.valueOf(0));
                        break;
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String readFile(File file) {
        String str;
        Throwable th;
        Throwable th2;
        String str2 = "";
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            str = str2;
            while (true) {
                try {
                    str2 = bufferedReader.readLine();
                    if (str2 == null) {
                        break;
                    }
                    str = str + str2;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable th4) {
                }
            }
        } catch (Throwable th5) {
            th2 = th5;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th2;
        }
        return str;
    }

    public static boolean addFavorite(Context context, Intent intent, String str, Drawable drawable) {
        Parcelable c = C0544a.m2447c(90, 90, Config.ARGB_8888);
        c.eraseColor(Color.argb(HttpStatus.SC_OK, 255, 0, 0));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", true);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON", c);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        context.getApplicationContext().sendBroadcast(intent2);
        return true;
    }

    public static boolean addFavorite(Context context, Intent intent, String str, int i) {
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", true);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, i));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        context.getApplicationContext().sendBroadcast(intent2);
        return true;
    }

    public static af<Boolean> hasFavorite(Context context, String str) {
        Throwable th;
        Object authorityOfPermission = authorityOfPermission(context, "com.android.launcher.permission.READ_SETTINGS");
        if (TextUtils.isEmpty(authorityOfPermission)) {
            return new af();
        }
        String str2 = "content://" + authorityOfPermission + "/favorites?notify=true";
        ContentResolver contentResolver = context.getContentResolver();
        Cursor query;
        try {
            af<Boolean> afVar;
            if (C0373z.m1052a()) {
                query = contentResolver.query(Uri.parse(str2), new String[]{"title", "container"}, "title=?", new String[]{str}, null);
                while (query != null) {
                    try {
                        if (query.moveToNext()) {
                            if (query.getInt(1) < 0) {
                                afVar = new af(Boolean.valueOf(true));
                                if (query == null) {
                                    return afVar;
                                }
                                query.close();
                                return afVar;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                afVar = new af(Boolean.valueOf(false));
                if (query == null) {
                    return afVar;
                }
                query.close();
                return afVar;
            }
            query = contentResolver.query(Uri.parse(str2), new String[]{"title"}, "title=?", new String[]{str}, null);
            boolean z = query != null && query.moveToNext();
            afVar = new af(Boolean.valueOf(z));
            if (query == null) {
                return afVar;
            }
            query.close();
            return afVar;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private static String authorityOfPermission(Context context, String str) {
        if (str == null) {
            return null;
        }
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(8);
        if (installedPackages == null) {
            return null;
        }
        for (PackageInfo packageInfo : installedPackages) {
            if (packageInfo.providers != null) {
                for (ProviderInfo providerInfo : packageInfo.providers) {
                    if (str.equals(providerInfo.readPermission)) {
                        return providerInfo.authority;
                    }
                    if (str.equals(providerInfo.writePermission)) {
                        return providerInfo.authority;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private static String splitDirctoryPart(String str) {
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        return lastIndexOf == -1 ? null : str.substring(0, lastIndexOf);
    }

    public static void extractRawResource(Context context, OutputStream outputStream, int i) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().openRawResource(i);
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
    }

    public static boolean extractAsset(Context context, OutputStream outputStream, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th) {
                }
            }
            return true;
        } catch (Throwable th2) {
        }
    }

    public static void rm(File file) {
        if (!f1407a && file == null) {
            throw new AssertionError();
        } else if (file != null) {
            try {
                if (file.isDirectory()) {
                    for (String str : file.list()) {
                        if (!(str.equals(".") || str.equals(".."))) {
                            rm(new File(file, str));
                        }
                    }
                }
                file.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean chmod(String str, String str2) {
        try {
            Runtime.getRuntime().exec("chmod " + str2 + " " + str).waitFor();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static Rect ceil(RectF rectF) {
        return new Rect((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
    }

    public static String formatBytes(long j) {
        float f = ((float) j) / 1024.0f;
        if (Float.compare(f, 1024.0f) < 0) {
            return String.format("%.1f KB", new Object[]{Float.valueOf(f)});
        }
        if (Float.compare(f / 1024.0f, 1024.0f) < 0) {
            return String.format("%.1f MB", new Object[]{Float.valueOf(f / 1024.0f)});
        }
        return String.format("%.1f GB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
    }

    public static Object getMetaData(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDkDistChannel(Context context) {
        return (String) getMetaData(context, "DK_DIST_CHANNEL");
    }

    public static String getChannelName(Context context) {
        return (String) getMetaData(context, "UMENG_CHANNEL");
    }

    public static boolean isDuokanChannel(Context context) {
        return "Duokan".equals(getChannelName(context));
    }

    public static boolean isMiui() {
        return Build.MANUFACTURER.contains("Xiaomi");
    }

    public static boolean isXiaomiId(String str) {
        return Pattern.matches("^[0-9]+$", str);
    }

    public static boolean isXiaomiGuestId(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (1000000000000L > parseLong || parseLong >= 10000000000000L) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            String str = null;
            String str2 = null;
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    String str3;
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (inetAddress.isLoopbackAddress()) {
                        str3 = str;
                        str = str2;
                    } else {
                        if (inetAddress instanceof Inet4Address) {
                            str2 = inetAddress.getHostAddress().toString();
                            str3 = str;
                            str = str2;
                        } else if (inetAddress instanceof Inet6Address) {
                            str3 = inetAddress.getHostAddress().toString();
                            str = str2;
                        } else {
                            str3 = str;
                            str = str2;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            return str;
                        }
                    }
                    str2 = str;
                    str = str3;
                }
            }
            return str;
        } catch (SocketException e) {
            return null;
        }
    }

    public static boolean isIntentAvailable(Context context, String str) {
        return context.getPackageManager().queryIntentActivities(new Intent(str), 65536).size() > 0;
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static int getActivityRequestCode() {
        int i;
        synchronized (f1409c) {
            i = f1408b;
            f1408b = i + 1;
        }
        return i;
    }

    public static <T extends Serializable> String serializeToJsonText(T t) {
        if (t == null) {
            return new JSONObject().toString();
        }
        return new Gson().toJson((Object) t).toString();
    }

    public static <T extends Serializable> T deserializeFromJsonText(String str, Class<T> cls) {
        return deserializeFromJsonText(str, null, cls);
    }

    public static <T extends Serializable> T deserializeFromJsonText(String str, T t, Class<T> cls) {
        if (TextUtils.isEmpty(str)) {
            return t;
        }
        try {
            return (Serializable) new Gson().fromJson(str, (Class) cls);
        } catch (Exception e) {
            return t;
        }
    }

    public static boolean isEmpty(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    public static <T extends Serializable> JSONObject serializeToJson(T t) {
        if (t == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(new Gson().toJson((Object) t).toString());
        } catch (JSONException e) {
            return new JSONObject();
        }
    }

    public static <T extends Serializable> T deserializeFromJson(JSONObject jSONObject, Class<T> cls) {
        return deserializeFromJson(jSONObject, null, cls);
    }

    public static <T extends Serializable> T deserializeFromJson(JSONObject jSONObject, T t, Class<T> cls) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return t;
        }
        try {
            return (Serializable) new Gson().fromJson(jSONObject.toString(), (Class) cls);
        } catch (Exception e) {
            return t;
        }
    }

    public static String[] genCsrfCode() {
        String[] split = (ReaderEnv.get().getDeviceId() + '&' + ((int) (System.currentTimeMillis() / 1000))).split("");
        int i = 0;
        for (int i2 = 1; i2 < split.length; i2++) {
            i = generate(i, split[i2]);
        }
        return new String[]{"_t", String.valueOf(r4), "_c", String.valueOf(i)};
    }

    public static boolean isVersionLessorThen(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (str.equalsIgnoreCase(str2)) {
            return false;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length <= split2.length ? split.length : split2.length;
        int i = 0;
        while (i < length) {
            if (Integer.parseInt(split[i]) != Integer.parseInt(split2[i])) {
                return Integer.parseInt(split[i]) < Integer.parseInt(split2[i]);
            } else {
                i++;
            }
        }
        return false;
    }

    public static boolean isSDCardBusy() {
        return !Environment.getExternalStorageState().equals("mounted");
    }

    private static int generate(int i, String str) {
        return ((i * 131) + str.getBytes()[0]) % 65536;
    }

    public static boolean isLandscape(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels < displayMetrics.widthPixels;
    }

    public static void exchangeNewIdThenDo(String str, String str2, ag<String> agVar, Runnable runnable) {
        C0328a.m757c().m764b(agVar != null);
        if (TextUtils.isEmpty(str2)) {
            new C04271(C0643q.f2173a, str, agVar, runnable).open();
        } else {
            agVar.run(str2);
        }
    }
}
