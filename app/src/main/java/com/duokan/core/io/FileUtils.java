package com.duokan.core.io;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class FileUtils {
    public static FileInputStream getTempInputStream(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (Throwable th) {
            return null;
        }
    }
    public static byte[] toBytes(InputStream in) {
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        try {
            read(in, out);
            byte buffer[] = out.toByteArray();
            return buffer;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(out);
        }
        return null;
    }

    public static void read(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read <= 0) {
                outputStream.flush();
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static BufferedReader getBifferedReader(File file, String charsetName) {
        FileInputStream inputStream = getTempInputStream(file);
        if (inputStream == null) {
            return null;
        }
        try {
            return new BufferedReader(new InputStreamReader(inputStream, charsetName));
        } catch (Throwable th) {
            close(inputStream);
            return null;
        }
    }

    public static File realFile(String str, String str2, File file) throws IOException {
        File newFile = new File(file, getSign(str, str2));
        if (!newFile.exists()) // 如果不存在，创建此文件
            newFile.createNewFile();
        return newFile;
    }

    public static File getRealFile(String str, String str2, File file) {
        try {
            return realFile(str, str2, file);
        } catch (Throwable th) {
            return null;
        }
    }

    public static File getRealFile(File file) {
        return getRealFile("", ".tmp!", file);
    }

    public static File createFile(String str, String str2, File file) {
        File file2;
        do {
            file2 = new File(file, getSign(str, str2));
            if (file2.mkdir()) {
                break;
            }
        } while (file2.exists());
        return file2.exists() ? file2 : null;
    }

    public static File createTempFile(File file) {
        return createFile("", ".tmp!", file);
    }

//    public static boolean getBifferedReader(File file, File file2) {
//        RandomAccessFile randomAccessFile;
//        RandomAccessFile randomAccessFile2;
//        RandomAccessFile randomAccessFile3;
//        boolean z;
//        Throwable th;
//        RandomAccessFile randomAccessFile4;
//        try {
//            randomAccessFile = new RandomAccessFile(file, "r");
//            try {
//                randomAccessFile4 = new RandomAccessFile(file2, "rws");
//            } catch (Throwable th2) {
//                randomAccessFile4 = null;
//                th = th2;
//                if (randomAccessFile != null) {
//                    try {
//                        randomAccessFile.close();
//                    } catch (Throwable th3) {
//                        throw th;
//                    }
//                }
//                if (randomAccessFile4 != null) {
//                    randomAccessFile4.close();
//                }
//                throw th;
//            }
//            try {
//                ReadableByteChannel channel = randomAccessFile.getChannel();
//                FileChannel channel2 = randomAccessFile4.getChannel();
//                long size = channel.size();
//                long j = 0;
//                channel.position(0);
//                channel2.position(0);
//                while (j < size) {
//                    long transferFrom = channel2.transferFrom(channel, j, size - j);
//                    if (transferFrom <= 0) {
//                        break;
//                    }
//                    j += transferFrom;
//                }
//                if (j == size) {
//                    channel2.truncate(j);
//                    channel2.force(true);
//                    z = true;
//                    if (randomAccessFile != null) {
//                        try {
//                            randomAccessFile.close();
//                        } catch (Throwable th4) {
//                        }
//                    }
//                    if (randomAccessFile4 != null) {
//                        randomAccessFile4.close();
//                    }
//                } else {
//                    z = false;
//                    if (randomAccessFile != null) {
//                        try {
//                            randomAccessFile.close();
//                        } catch (Throwable th5) {
//                        }
//                    }
//                    if (randomAccessFile4 != null) {
//                        randomAccessFile4.close();
//                    }
//                }
//            } catch (Throwable th6) {
//                th = th6;
//                if (randomAccessFile != null) {
//                    randomAccessFile.close();
//                }
//                if (randomAccessFile4 != null) {
//                    randomAccessFile4.close();
//                }
//                throw th;
//            }
//        } catch (Throwable th7) {
//            randomAccessFile4 = null;
//            randomAccessFile = null;
//            th = th7;
//            if (randomAccessFile != null) {
//                randomAccessFile.close();
//            }
//            if (randomAccessFile4 != null) {
//                randomAccessFile4.close();
//            }
//            throw th;
//        }
//        return z;
//   }

    public static void writeBitmap(Bitmap bitmap, CompressFormat compressFormat, int quality, File file) {
        File a = null;
        FileOutputStream fileOutputStream = null;
        try {
            a = realFile(file.getName(), ".tmp!", file.getParentFile());
            fileOutputStream = new FileOutputStream(a);
            bitmap.compress(compressFormat, quality, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            if (a.renameTo(file)) {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (a != null && a.exists()) {
                    a.delete();
                    return;
                }
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void a(InputStream inputStream, File file) {

        File file2 = null;
        FileOutputStream fileOutputStream = null;
        try {
            file2 = realFile(file.getName(), ".tmp!", file.getParentFile());
            fileOutputStream = new FileOutputStream(file2);
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
            if (file2.renameTo(file)) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                    }
                }
                if (file2 != null && file2.exists()) {
                    file2.delete();
                    return;
                }
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean saveImage(Bitmap bitmap, CompressFormat compressFormat, int quality, File file) {
        try {
            writeBitmap(bitmap, compressFormat, quality, file);
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

    public static boolean deleteFile(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        File file1;
        if (file.isDirectory()) {
            file1 = createTempFile(file.getParentFile());
        } else {
            file1 = getRealFile(file.getParentFile());
        }
        if (file1 != null && file.renameTo(file1)) {
            return deleteFiles(file1);
        }
        if (file1 != null) {
            file1.delete();
        }
        return deleteFiles(file);
    }

    public static boolean deleteFiles(File file) {
        int i = 0;
        boolean end = false;
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
            end &= deleteFiles(listFiles[i]);
            i++;
        }
        return end & file.delete();
    }

    public static List DirFileFilter(File file, FileFilter... fileFilter) {
        File[] listFiles = file.listFiles(new MyDirFileFilter(fileFilter));
        if (listFiles == null) {
            listFiles = new File[0];
        }
        return Arrays.asList(listFiles);
    }

    // 过滤 不是根目录的文件夹
    static final class MyDirFileFilter implements FileFilter {
        final FileFilter[] filters;

        MyDirFileFilter(FileFilter[] fileFilterArr) {
            this.filters = fileFilterArr;
        }

        public boolean accept(File file) {
            if (file.isDirectory()) {
                return false;
            }
            for (FileFilter accept : this.filters) {
                if (!accept.accept(file)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static List DirFilter(File file, FileFilter... fileFilterArr) {
        File[] listFiles = file.listFiles(new MyFileFilter(fileFilterArr));
        if (listFiles == null) {
            listFiles = new File[0];
        }
        return Arrays.asList(listFiles);
    }

    static final class MyFileFilter implements FileFilter {
        final FileFilter[] fileFilter;

        MyFileFilter(FileFilter[] fileFilter) {
            this.fileFilter = fileFilter;
        }

        public boolean accept(File file) {
            if (!file.isDirectory()) {
                return false;
            }
            for (FileFilter accept : this.fileFilter) {
                if (!accept.accept(file)) {
                    return false;
                }
            }
            return true;
        }

    }

    public static Collection a(Context context) {
        Collection linkedList = new LinkedList();
        linkedList.add(Environment.getExternalStorageDirectory());
        linkedList.addAll(c(context));
        if (VERSION.SDK_INT < 19) {
            linkedList.addAll(getSDInfo());
        }
        return getFreeDiskSpace(linkedList);
    }

    public static Collection getFreeDiskSpace(Context context) {
        Collection linkedList = new LinkedList();
        linkedList.add(Environment.getExternalStorageDirectory());
        linkedList.addAll(d(context));
        if (VERSION.SDK_INT < 19) {
            linkedList.addAll(getSDInfo());
        }
        return getFreeDiskSpace(linkedList);
    }

    private static Collection getFreeDiskSpace(Collection<File> collection) {
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

    private static Collection getSDInfo() {
        Collection linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(new File("/storage"));
        linkedList2.add(new File("/mnt"));
        while (!linkedList2.isEmpty()) {
            File file = (File) linkedList2.pop();
            if (file.canWrite() && file.canRead() && file.getTotalSpace() > 0) {
                linkedList.add(file);
            } else {
                linkedList2.addAll(DirFilter(file, new FileFilter[0]));
            }
        }
        return linkedList;
    }

    private static Collection c(Context context) {
        Collection linkedList = new LinkedList();
        for (File file : getFilesDirs(context)) {
            long totalSpace = file.getTotalSpace();
            File file1 = file;
            File file2 = file.getParentFile();
            while (file2 != null && file2.canRead() && file2.getTotalSpace() == totalSpace) {
                file2 = file2.getParentFile();
            }
            linkedList.add(file1);
        }
        return linkedList;
    }

    private static Collection d(Context context) {
        Collection linkedList = new LinkedList();
        linkedList.addAll(getFilesDirs(context));
        return linkedList;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private static List<File> getFilesDirs(Context context) {
        int i = 0;
        LinkedList<File> linkedList = new LinkedList();
        File[] externalFilesDirs = VERSION.SDK_INT >= 19 ? context.getExternalFilesDirs(null) : new File[]{context.getExternalFilesDir(null)};
        if (externalFilesDirs != null) {
            int length = externalFilesDirs.length;
            while (i < length) {
                File obj = externalFilesDirs[i];
                if (obj != null) {
                    linkedList.add(obj);
                }
                i++;
            }
        }
        return linkedList;
    }

    private static String getSign(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "" + Process.myPid();
        }
        UUID randomUUID = UUID.randomUUID();
        return String.format("%s.%getScaledTouchSlop.%getScaledTouchSlop%s", new Object[]{str, Long.valueOf(randomUUID.getMostSignificantBits()), Long.valueOf(randomUUID.getLeastSignificantBits()), str2});
    }
}
