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
import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.b.a;
import com.duokan.reader.ui.general.ia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class da {
    private final Activity a;
    private final int b = DkPublic.getActivityRequestCode();
    private final int c = DkPublic.getActivityRequestCode();
    private final int d = DkPublic.getActivityRequestCode();
    private final String e = (ReaderEnv.get().getTempDirectory().getAbsolutePath() + "/avatar/mi_user_avatar_camara_temp.jpg");
    private dh f;
    private String g;

    public da(Activity activity) {
        this.a = activity;
    }

    public void a(dh dhVar) {
        c(new db(this, dhVar));
    }

    private void c(dh dhVar) {
        this.f = dhVar;
        this.g = ReaderEnv.get().getTempDirectory().getAbsolutePath() + "/avatar/mi_user_avatar_crop_temp" + System.currentTimeMillis() + ".jpg";
        ia iaVar = new ia(this.a);
        iaVar.a(j.personal__miaccount_profile_settings_view__change_avatar);
        iaVar.b(j.personal__miaccount_profile_settings_view__take_photo);
        iaVar.b(j.personal__miaccount_profile_settings_view__pick_photo);
        iaVar.a(new dc(this));
        iaVar.open(new dd(this));
    }

    public void a(int i, int i2, Intent intent) {
        if (i == this.b) {
            if (i2 != -1) {
                this.f.a("");
                return;
            }
            File file = new File(this.e);
            if (file.isFile()) {
                a(Uri.fromFile(file));
            } else {
                a(intent.getData());
            }
        } else if (i == this.c) {
            if (i2 != -1) {
                this.f.a("");
            } else {
                a(intent.getData());
            }
        } else if (i != this.d) {
        } else {
            if (i2 != -1) {
                this.f.a("");
            } else if (this.f.a()) {
                b(this.f);
            }
        }
    }

    public void b(dh dhVar) {
        this.f = dhVar;
        if (TextUtils.isEmpty(this.g)) {
            this.f.a("");
            return;
        }
        a a = e.a(DkApp.get().getApplicationContext());
        a.a(a.i(), "passportapi", null, this.a, new de(this));
    }

    private void a(String str) {
        new df(this, new File(this.g), str).open();
    }

    private void a() {
        new File(this.e).getParentFile().mkdirs();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", Uri.fromFile(new File(this.e)));
        if (DkPublic.isIntentAvailable(this.a.getBaseContext(), intent)) {
            this.a.startActivityForResult(intent, this.b);
        } else {
            this.f.a(this.a.getString(j.general__unsupported_intent));
        }
    }

    private void b() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        if (DkPublic.isIntentAvailable(this.a.getBaseContext(), intent)) {
            this.a.startActivityForResult(Intent.createChooser(intent, this.a.getString(j.personal__miaccount_profile_settings_view__choose_one_photo)), this.c);
        } else {
            this.f.a(this.a.getString(j.general__unsupported_intent));
        }
    }

    private void a(Uri uri) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        if (uri == null) {
            this.f.a(this.a.getString(j.personal__miaccount_profile_settings_view__cannot_access_photo));
            return;
        }
        String str;
        int i;
        String path;
        File file = new File(this.g);
        file.getParentFile().mkdirs();
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 720);
        intent.putExtra("outputY", 720);
        intent.putExtra("output", Uri.fromFile(file));
        intent.putExtra("outputFormat", "JPEG");
        List queryIntentActivities = this.a.getPackageManager().queryIntentActivities(intent, 65536);
        if (!queryIntentActivities.isEmpty()) {
            str = ((ResolveInfo) queryIntentActivities.get(0)).activityInfo.packageName;
            String str2 = Build.MODEL;
            String str3 = Build.PRODUCT;
            if (!(str.contains("motorola") || str.contains("digitalaria") || str2.equalsIgnoreCase("Galaxy Nexus") || str2.equalsIgnoreCase("GT-P7510"))) {
                this.a.startActivityForResult(intent, this.d);
                i = 1;
                if (i == 0) {
                    try {
                        str = "";
                        if (uri.getScheme().equals("content")) {
                            path = new File(new URI(uri.toString())).getPath();
                            cursor = null;
                        } else {
                            cursor = this.a.getContentResolver().query(uri, null, null, null, null);
                            try {
                                cursor.moveToFirst();
                                path = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                            } catch (IOException e) {
                                try {
                                    a(this.d, 0, null);
                                    if (cursor != null) {
                                        cursor.close();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    cursor2 = cursor;
                                    th = th2;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            } catch (OutOfMemoryError e2) {
                                cursor2 = cursor;
                                try {
                                    a(this.d, 0, null);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            } catch (URISyntaxException e3) {
                                cursor2 = cursor;
                                a(this.d, 0, null);
                                if (cursor2 != null) {
                                    cursor2.close();
                                    return;
                                }
                                return;
                            }
                        }
                        a(this.a, path, file, 720);
                        a(this.d, -1, null);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (IOException e4) {
                        cursor = null;
                        a(this.d, 0, null);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    } catch (OutOfMemoryError e5) {
                        a(this.d, 0, null);
                        if (cursor2 != null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    } catch (URISyntaxException e6) {
                        a(this.d, 0, null);
                        if (cursor2 != null) {
                            cursor2.close();
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
                cursor = null;
            } else {
                cursor = this.a.getContentResolver().query(uri, null, null, null, null);
                cursor.moveToFirst();
                path = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            }
            a(this.a, path, file, 720);
            a(this.d, -1, null);
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private boolean a(Context context, String str, File file, int i) {
        Rect rect;
        Bitmap a = com.duokan.reader.common.bitmap.a.a(context, str, i, i);
        Bitmap c = com.duokan.reader.common.bitmap.a.c(i, i, Config.ARGB_8888);
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
