package com.duokan.reader.ui.personal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.sys.p025a.C0341a;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.p036b.C0542e;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.ui.general.hp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class ct {
    /* renamed from: a */
    private final Activity f8423a;
    /* renamed from: b */
    private final int f8424b = DkPublic.getActivityRequestCode();
    /* renamed from: c */
    private final int f8425c = DkPublic.getActivityRequestCode();
    /* renamed from: d */
    private final int f8426d = DkPublic.getActivityRequestCode();
    /* renamed from: e */
    private final String f8427e = (ReaderEnv.get().getTempDirectory().getAbsolutePath() + "/avatar/mi_user_avatar_camara_temp.jpg");
    /* renamed from: f */
    private db f8428f;
    /* renamed from: g */
    private String f8429g;

    public ct(Activity activity) {
        this.f8423a = activity;
    }

    /* renamed from: a */
    public void m11640a(db dbVar) {
        m11634c(new cu(this, dbVar));
    }

    /* renamed from: c */
    private void m11634c(db dbVar) {
        this.f8428f = dbVar;
        this.f8429g = ReaderEnv.get().getTempDirectory().getAbsolutePath() + "/avatar/mi_user_avatar_crop_temp" + System.currentTimeMillis() + ".jpg";
        hp hpVar = new hp(this.f8423a);
        hpVar.m9765a(C0258j.personal__miaccount_profile_settings_view__change_avatar);
        hpVar.m9769b(C0258j.personal__miaccount_profile_settings_view__take_photo);
        hpVar.m9769b(C0258j.personal__miaccount_profile_settings_view__pick_photo);
        hpVar.m9767a(new cv(this));
        hpVar.open(new cw(this));
    }

    /* renamed from: a */
    public void m11639a(int i, int i2, Intent intent) {
        if (i == this.f8424b) {
            if (i2 != -1) {
                this.f8428f.mo1895a("");
                return;
            }
            File file = new File(this.f8427e);
            if (file.isFile()) {
                m11627a(FileProvider.getUriForFile(this.f8423a.getApplicationContext(), "com.duokan.reader.provider", file));
            } else {
                m11627a(intent.getData());
            }
        } else if (i == this.f8425c) {
            if (i2 != -1) {
                this.f8428f.mo1895a("");
            } else {
                m11627a(intent.getData());
            }
        } else if (i != this.f8426d) {
        } else {
            if (i2 != -1) {
                this.f8428f.mo1895a("");
            } else if (this.f8428f.mo1896a()) {
                m11641b(this.f8428f);
            }
        }
    }

    /* renamed from: b */
    public void m11641b(db dbVar) {
        this.f8428f = dbVar;
        if (TextUtils.isEmpty(this.f8429g)) {
            this.f8428f.mo1895a("");
            return;
        }
        C0538a a = C0542e.m2411a(DkApp.get().getApplicationContext());
        a.m2391a(a.m2409i(), "passportapi", null, this.f8423a, new cx(this));
    }

    /* renamed from: a */
    private void m11629a(String str) {
        new cy(this, C0643q.f2173a, new File(this.f8429g), str).open();
    }

    /* renamed from: a */
    private void m11626a() {
        if (this.f8423a instanceof BaseActivity) {
            C0341a.m822a((BaseActivity) this.f8423a).m824a(new da(this));
        }
    }

    /* renamed from: b */
    private void m11631b() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        if (DkPublic.isIntentAvailable(this.f8423a.getBaseContext(), intent)) {
            this.f8423a.startActivityForResult(Intent.createChooser(intent, this.f8423a.getString(C0258j.personal__miaccount_profile_settings_view__choose_one_photo)), this.f8425c);
        } else {
            this.f8428f.mo1895a(this.f8423a.getString(C0258j.general__unsupported_intent));
        }
    }

    /* renamed from: a */
    private void m11627a(Uri uri) {
        Throwable th;
        Cursor cursor = null;
        if (uri == null) {
            this.f8428f.mo1895a(this.f8423a.getString(C0258j.personal__miaccount_profile_settings_view__cannot_access_photo));
            return;
        }
        String str;
        int i;
        String path;
        Cursor cursor2;
        File file = new File(this.f8429g);
        file.getParentFile().mkdirs();
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 720);
        intent.putExtra("outputY", 720);
        intent.addFlags(1);
        intent.putExtra("output", m11625a(file));
        intent.putExtra("outputFormat", "JPEG");
        List<ResolveInfo> queryIntentActivities = this.f8423a.getPackageManager().queryIntentActivities(intent, 65536);
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            this.f8423a.grantUriPermission(resolveInfo.activityInfo.packageName, m11625a(file), 3);
        }
        if (!queryIntentActivities.isEmpty()) {
            str = ((ResolveInfo) queryIntentActivities.get(0)).activityInfo.packageName;
            String str2 = Build.MODEL;
            String str3 = Build.PRODUCT;
            if (!(str.contains("motorola") || str.contains("digitalaria") || str2.equalsIgnoreCase("Galaxy Nexus") || str2.equalsIgnoreCase("GT-P7510"))) {
                this.f8423a.startActivityForResult(intent, this.f8426d);
                i = 1;
                if (i == 0) {
                    try {
                        str = "";
                        if (uri.getScheme().equals("content")) {
                            path = new File(new URI(uri.toString())).getPath();
                            cursor2 = null;
                        } else {
                            cursor2 = this.f8423a.getContentResolver().query(uri, null, null, null, null);
                            try {
                                cursor2.moveToFirst();
                                path = cursor2.getString(cursor2.getColumnIndexOrThrow("_data"));
                            } catch (IOException e) {
                                try {
                                    m11639a(this.f8426d, 0, null);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    cursor = cursor2;
                                    th = th2;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            } catch (OutOfMemoryError e2) {
                                cursor = cursor2;
                                try {
                                    m11639a(this.f8426d, 0, null);
                                    if (cursor != null) {
                                        cursor.close();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            } catch (URISyntaxException e3) {
                                cursor = cursor2;
                                m11639a(this.f8426d, 0, null);
                                if (cursor != null) {
                                    cursor.close();
                                    return;
                                }
                                return;
                            }
                        }
                        m11630a(this.f8423a, path, file, 720);
                        m11639a(this.f8426d, -1, null);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                    } catch (IOException e4) {
                        cursor2 = null;
                        m11639a(this.f8426d, 0, null);
                        if (cursor2 != null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    } catch (OutOfMemoryError e5) {
                        m11639a(this.f8426d, 0, null);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    } catch (URISyntaxException e6) {
                        m11639a(this.f8426d, 0, null);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
            }
        }
        i = 0;
        if (i == 0) {
            str = "";
            if (uri.getScheme().equals("content")) {
                path = new File(new URI(uri.toString())).getPath();
                cursor2 = null;
            } else {
                cursor2 = this.f8423a.getContentResolver().query(uri, null, null, null, null);
                cursor2.moveToFirst();
                path = cursor2.getString(cursor2.getColumnIndexOrThrow("_data"));
            }
            m11630a(this.f8423a, path, file, 720);
            m11639a(this.f8426d, -1, null);
            if (cursor2 != null) {
                cursor2.close();
            }
        }
    }

    /* renamed from: a */
    private Uri m11625a(File file) {
        return FileProvider.getUriForFile(this.f8423a, "com.duokan.reader.provider", file);
    }

    /* renamed from: a */
    private boolean m11630a(Context context, String str, File file, int i) {
        Rect rect;
        Bitmap a = C0544a.m2435a(context, str, i, i);
        Bitmap c = C0544a.m2447c(i, i, Config.ARGB_8888);
        Canvas canvas = new Canvas(c);
        int width = a.getWidth();
        int height = a.getHeight();
        Paint paint = new Paint();
        if (width > height) {
            rect = new Rect((width - height) / 2, 0, (width + height) / 2, height);
        } else {
            rect = new Rect(0, (height - width) / 2, width, (height + width) / 2);
        }
        canvas.drawBitmap(a, rect, new Rect(0, 0, i, i), paint);
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream fileOutputStream = new FileOutputStream(file);
        boolean compress = c.compress(CompressFormat.PNG, 0, fileOutputStream);
        fileOutputStream.close();
        return compress;
    }
}
