package com.duokan.core.sys;

import android.net.Uri;
import android.text.TextUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class o {
    static final /* synthetic */ boolean a = (!o.class.desiredAssertionStatus());

    public static boolean a(String str, String str2) {
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        boolean z = false;
        File file = new File(Uri.parse(str).getPath());
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    Object a = a((InputStream) fileInputStream, "md5");
                    if (!TextUtils.isEmpty(a) && str2.equalsIgnoreCase(a)) {
                        z = true;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e22 = e3;
                    try {
                        e22.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e222) {
                                e222.printStackTrace();
                            }
                        }
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2222) {
                                e2222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e2222 = e4;
                fileInputStream = null;
                e2222.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        return z;
    }

    public static String a(InputStream inputStream, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return a(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(File file, String str) {
        Throwable th;
        if (file == null) {
            return "";
        }
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                String a = a((InputStream) fileInputStream2, str);
                if (fileInputStream2 == null) {
                    return a;
                }
                try {
                    fileInputStream2.close();
                    return a;
                } catch (Throwable th2) {
                    return a;
                }
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
        } catch (Throwable th5) {
            Throwable th6 = th5;
            fileInputStream2 = null;
            th = th6;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    public static String b(String str, String str2) {
        return a(str, "utf-8", str2);
    }

    public static String a(String str, String str2, String str3) {
        try {
            return a(new ByteArrayInputStream(str.getBytes(str2)), str3);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (a || bArr != null) {
            StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
            for (int i = 0; i < bArr.length; i++) {
                stringBuilder.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
            }
            return stringBuilder.toString();
        }
        throw new AssertionError();
    }

    public static byte[] a(String str) {
        if (a || str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).intValue();
            }
            return bArr;
        }
        throw new AssertionError();
    }
}
