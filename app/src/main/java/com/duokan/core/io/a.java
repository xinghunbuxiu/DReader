package com.duokan.core.io;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class a {
    public static FileInputStream a(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (Throwable th) {
            return null;
        }
    }

    public static BufferedReader a(File file, String str) {
        Closeable a = a(file);
        if (a == null) {
            return null;
        }
        try {
            return new BufferedReader(new InputStreamReader(a, str));
        } catch (Throwable th) {
            d.a(a);
            return null;
        }
    }

    public static File a(String str, String str2, File file) {
        File file2;
        do {
            try {
                file2 = new File(file, a(str, str2));
            } catch (Throwable e) {
                throw new OutputException(e);
            }
        } while (!file2.createNewFile());
        return file2;
    }

    public static File b(String str, String str2, File file) {
        try {
            return a(str, str2, file);
        } catch (Throwable th) {
            return null;
        }
    }

    public static File b(File file) {
        return b("", ".tmp!", file);
    }

    public static File c(String str, String str2, File file) {
        File file2;
        do {
            file2 = new File(file, a(str, str2));
            if (file2.mkdir()) {
                break;
            }
        } while (file2.exists());
        return file2.exists() ? file2 : null;
    }

    public static File c(File file) {
        return c("", ".tmp!", file);
    }

    public static boolean a(File file, File file2) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3;
        boolean z;
        Throwable th;
        RandomAccessFile randomAccessFile4;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                randomAccessFile4 = new RandomAccessFile(file2, "rws");
            } catch (Throwable th2) {
                randomAccessFile4 = null;
                th = th2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th3) {
                        throw th;
                    }
                }
                if (randomAccessFile4 != null) {
                    randomAccessFile4.close();
                }
                throw th;
            }
            try {
                ReadableByteChannel channel = randomAccessFile.getChannel();
                FileChannel channel2 = randomAccessFile4.getChannel();
                long size = channel.size();
                long j = 0;
                channel.position(0);
                channel2.position(0);
                while (j < size) {
                    long transferFrom = channel2.transferFrom(channel, j, size - j);
                    if (transferFrom <= 0) {
                        break;
                    }
                    j += transferFrom;
                }
                if (j == size) {
                    channel2.truncate(j);
                    channel2.force(true);
                    z = true;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th4) {
                        }
                    }
                    if (randomAccessFile4 != null) {
                        randomAccessFile4.close();
                    }
                } else {
                    z = false;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th5) {
                        }
                    }
                    if (randomAccessFile4 != null) {
                        randomAccessFile4.close();
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (randomAccessFile4 != null) {
                    randomAccessFile4.close();
                }
                throw th;
            }
        } catch (Throwable th7) {
            randomAccessFile4 = null;
            randomAccessFile = null;
            th = th7;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            if (randomAccessFile4 != null) {
                randomAccessFile4.close();
            }
            throw th;
        }
        return z;
    }

    public static void a(Bitmap bitmap, CompressFormat compressFormat, int i, File file) {
        FileOutputStream fileOutputStream;
        Throwable th;
        File file2 = null;
        try {
            File a = a(file.getName(), ".tmp!", file.getParentFile());
            try {
                fileOutputStream = new FileOutputStream(a);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                file2 = a;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                    }
                }
                file2.delete();
                throw th;
            }
            try {
                bitmap.compress(compressFormat, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
                if (a.renameTo(file)) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    if (a != null && a.exists()) {
                        a.delete();
                        return;
                    }
                    return;
                }
                throw new FileAlreadyExistsException(String.format("the file(%s) already exists", new Object[]{file.getAbsolutePath()}));
            } catch (Throwable th3) {
                th = th3;
                file2 = a;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                file2.delete();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
            throw th;
        }
    }

    public static void a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        Throwable th;
        File file2 = null;
        try {
            File a = a(file.getName(), ".tmp!", file.getParentFile());
            try {
                fileOutputStream = new FileOutputStream(a);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 1024);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.getFD().sync();
                    if (a.renameTo(file)) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e) {
                            }
                        }
                        if (a != null && a.exists()) {
                            a.delete();
                            return;
                        }
                        return;
                    }
                    throw new FileAlreadyExistsException(String.format("the file(%s) already exists", new Object[]{file.getAbsolutePath()}));
                } catch (Throwable th2) {
                    th = th2;
                    file2 = a;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                file2 = a;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2) {
                    }
                }
                file2.delete();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
            throw th;
        }
    }

    public static boolean b(Bitmap bitmap, CompressFormat compressFormat, int i, File file) {
        try {
            a(bitmap, compressFormat, i, file);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean b(InputStream inputStream, File file) {
        try {
            a(inputStream, file);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean d(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        File c;
        if (file.isDirectory()) {
            c = c(file.getParentFile());
        } else {
            c = b(file.getParentFile());
        }
        if (c != null && file.renameTo(c)) {
            return e(c);
        }
        if (c != null) {
            c.delete();
        }
        return e(file);
    }

    public static boolean e(File file) {
        int i = 0;
        int i2 = 1;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        while (i < listFiles.length) {
            i2 &= e(listFiles[i]);
            i++;
        }
        return i2 & file.delete();
    }

    public static List a(File file, FileFilter... fileFilterArr) {
        Object[] listFiles = file.listFiles(new b(fileFilterArr));
        if (listFiles == null) {
            listFiles = new File[0];
        }
        return Arrays.asList(listFiles);
    }

    public static List b(File file, FileFilter... fileFilterArr) {
        Object[] listFiles = file.listFiles(new c(fileFilterArr));
        if (listFiles == null) {
            listFiles = new File[0];
        }
        return Arrays.asList(listFiles);
    }

    public static Collection a(Context context) {
        Collection linkedList = new LinkedList();
        linkedList.add(Environment.getExternalStorageDirectory());
        linkedList.addAll(c(context));
        if (VERSION.SDK_INT < 19) {
            linkedList.addAll(a());
        }
        return a(linkedList);
    }

    public static Collection b(Context context) {
        Collection linkedList = new LinkedList();
        linkedList.add(Environment.getExternalStorageDirectory());
        linkedList.addAll(d(context));
        if (VERSION.SDK_INT < 19) {
            linkedList.addAll(a());
        }
        return a(linkedList);
    }

    private static Collection a(Collection collection) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (File file : collection) {
            try {
                long blockSizeLong;
                long blockCountLong;
                StatFs statFs = new StatFs(file.getAbsolutePath());
                if (VERSION.SDK_INT >= 18) {
                    blockSizeLong = statFs.getBlockSizeLong();
                    blockCountLong = statFs.getBlockCountLong();
                } else {
                    blockSizeLong = (long) statFs.getBlockSize();
                    blockCountLong = (long) statFs.getBlockCount();
                }
                String str = blockSizeLong + "*" + blockCountLong;
                if (!linkedHashMap.containsKey(str)) {
                    linkedHashMap.put(str, file);
                }
            } catch (Throwable th) {
            }
        }
        return linkedHashMap.values();
    }

    private static Collection a() {
        Collection linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(new File("/storage"));
        linkedList2.add(new File("/mnt"));
        while (!linkedList2.isEmpty()) {
            File file = (File) linkedList2.pop();
            if (file.canWrite() && file.canRead() && file.getTotalSpace() > 0) {
                linkedList.add(file);
            } else {
                linkedList2.addAll(b(file, new FileFilter[0]));
            }
        }
        return linkedList;
    }

    private static Collection c(Context context) {
        Collection linkedList = new LinkedList();
        for (File file : e(context)) {
            long totalSpace = file.getTotalSpace();
            Object obj = file;
            File file2 = file2.getParentFile();
            while (file2 != null && file2.canRead() && file2.getTotalSpace() == totalSpace) {
                File file3 = file2;
                file2 = file2.getParentFile();
            }
            linkedList.add(obj);
        }
        return linkedList;
    }

    private static Collection d(Context context) {
        Collection linkedList = new LinkedList();
        linkedList.addAll(e(context));
        return linkedList;
    }

    private static List e(Context context) {
        int i = 0;
        Object linkedList = new LinkedList();
        File[] externalFilesDirs = VERSION.SDK_INT >= 19 ? context.getExternalFilesDirs(null) : new File[]{context.getExternalFilesDir(null)};
        if (externalFilesDirs != null) {
            int length = externalFilesDirs.length;
            while (i < length) {
                Object obj = externalFilesDirs[i];
                if (obj != null) {
                    linkedList.add(obj);
                }
                i++;
            }
        }
        return linkedList;
    }

    private static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "" + Process.myPid();
        }
        UUID randomUUID = UUID.randomUUID();
        return String.format("%s.%d.%d%s", new Object[]{str, Long.valueOf(randomUUID.getMostSignificantBits()), Long.valueOf(randomUUID.getLeastSignificantBits()), str2});
    }
}
