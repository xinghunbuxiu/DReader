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
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


public class FileUtil {

    public static String getRealFileName(File file) {
        String fileName = getFileName(file);
        int lastIndexOf = fileName.lastIndexOf(46);
        return lastIndexOf < 0 ? fileName : fileName.substring(0, lastIndexOf);
    }


    public static String getFileName(File file) {
        if (file == null) {
            return "";
        }
        return file.getName();
    }


    public static FileInputStream openInputStream(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static BufferedReader getBufferedReader(File file, String charsetName) {
        FileInputStream fileInputStream = openInputStream(file);
        if (fileInputStream == null) {
            return null;
        }
        try {
            return new BufferedReader(new InputStreamReader(fileInputStream, charsetName));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            IOUtils.close(fileInputStream);
        }
        return null;
    }


    public static File findFile(String str, String str2, File parent) {
        File file2 = null;
        try {
            do {
                file2 = new File(parent, getSignFileName(str, str2));
            } while (!file2.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file2;
    }


    public static File getFile(String str, String str2, File file) {
        try {
            return findFile(str, str2, file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static File getTempFile(File file) {
        return getFile("", ".tmp!", file);
    }


    public static File createFile(String str, String str2, File file) {
        File file2;
        do {
            file2 = new File(file, getSignFileName(str, str2));
            if (file2.mkdir()) {
                break;
            }
        } while (file2.exists());
        return file2.exists() ? file2 : null;
    }


    public static File m791e(File file) {
        return createFile("", ".tmp!", file);
    }


    public static boolean doCopyFile(File srcFile, File destFile) {
        RandomAccessFile randomAccessFile = null;
        RandomAccessFile randomAccessFile2 = null;
        FileChannel input = null;
        FileChannel output = null;
        boolean end = false;
        try {
            randomAccessFile = new RandomAccessFile(srcFile, "r");
            randomAccessFile2 = new RandomAccessFile(destFile, "rws");
            input = randomAccessFile.getChannel();
            output = randomAccessFile2.getChannel();
            long size = input.size();
            long pos = 0;
            input.position(0);
            output.position(0);
            while (pos < size) {
                long transferFrom = output.transferFrom(input, pos, size - pos);
                if (transferFrom <= 0) {
                    break;
                }
                pos += transferFrom;
            }
            if (pos == size) {
                output.truncate(pos);
                output.force(true);
                end = true;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return end;
    }


    public static void writeBitmap(Bitmap bitmap, CompressFormat compressFormat, int quality, File file) {
        File a = null;
        FileOutputStream fileOutputStream = null;
        try {
            a = getFile(file.getName(), ".tmp!", file.getParentFile());
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


    public static void writeFiles(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        File files = findFile(file.getName(), ".tmp!", file.getParentFile());
        try {
            fileOutputStream = new FileOutputStream(files);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = 0;
                read = inputStream.read(bArr, 0, 1024);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.getFD().sync();
            if (files.renameTo(file)) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                    }
                }
                if (files != null && files.exists()) {
                    files.delete();
                    return;
                }
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


    public static boolean m785b(InputStream inputStream, File file) {
        try {
            writeFiles(inputStream, file);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean deleteFile(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        File file1;
        if (file.isDirectory()) {
            file1 = getTempFile(file.getParentFile());
        } else {
            file1 = getTempFile(file.getParentFile());
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


    public static List<File> getDirFiles(File file, FileFilter... fileFilterArr) {
        File[] listFiles = file.listFiles(new AcceptFileFilter(fileFilterArr));
        if (listFiles == null) {
            listFiles = new File[0];
        }
        return Arrays.asList(listFiles);
    }


    public static List<File> getMyFileFilter(File file, FileFilter... fileFilterArr) {
        File[] listFiles = file.listFiles(new MyFileFilter(fileFilterArr));
        if (listFiles == null) {
            listFiles = new File[0];
        }
        return Arrays.asList(listFiles);
    }


    public static Collection<File> getDiskFiles(Context context) {
        Collection linkedList = new LinkedList();
        linkedList.add(Environment.getExternalStorageDirectory());
        linkedList.addAll(getCanReadParentFile(context));
        if (VERSION.SDK_INT < 19) {
            linkedList.addAll(getStorageFiles());
        }
        return getFreeDiskSpace(linkedList);
    }


    public static Collection<File> getAllFile(Context context) {
        Collection linkedList = new LinkedList();
        linkedList.add(Environment.getExternalStorageDirectory());
        linkedList.addAll(getAllFiles(context));
        if (VERSION.SDK_INT < 19) {
            linkedList.addAll(getStorageFiles());
        }
        return getFreeDiskSpace(linkedList);
    }


    private static Collection<File> getFreeDiskSpace(Collection<File> collection) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (File file : collection) {

            long blockSizeLong;
            long blockCountLong;
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (VERSION.SDK_INT >= 18) {
                blockSizeLong = statFs.getBlockSizeLong();
                blockCountLong = statFs.getBlockCountLong();
            } else {
                blockSizeLong = statFs.getBlockSize();
                blockCountLong = statFs.getBlockCount();
            }
            String str = blockSizeLong + "*" + blockCountLong;
            if (!linkedHashMap.containsKey(str)) {
                linkedHashMap.put(str, file);
            }

        }
        return linkedHashMap.values();
    }


    private static Collection<File> getStorageFiles() {
        Collection linkedList = new LinkedList();
        LinkedList<File> linkedList2 = new LinkedList();
        linkedList2.add(new File("/storage"));
        linkedList2.add(new File("/mnt"));
        while (!linkedList2.isEmpty()) {
            File file = linkedList2.pop();
            if (file.canWrite() && file.canRead() && file.getTotalSpace() > 0) {
                linkedList.add(file);
            } else {
                linkedList2.addAll(getMyFileFilter(file, new FileFilter[0]));
            }
        }
        return linkedList;
    }


    private static Collection<File> getCanReadParentFile(Context context) {
        Collection linkedList = new LinkedList();
        for (File file : getFileList(context)) {
            long totalSpace = file.getTotalSpace();
            File file2 = file.getParentFile();
            while (file2 != null && file2.canRead() && file2.getTotalSpace() == totalSpace) {
                file2 = file2.getParentFile();
            }
            linkedList.add(file2);
        }
        return linkedList;
    }


    private static Collection<File> getAllFiles(Context context) {
        Collection linkedList = new LinkedList();
        linkedList.addAll(getFileList(context));
        return linkedList;
    }


    private static List<File> getFileList(Context context) {
        int i = 0;
        List<File> linkedList = new LinkedList();
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


    private static String getSignFileName(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "" + Process.myPid();
        }
        UUID randomUUID = UUID.randomUUID();
        return String.format("%s.%d.%d%s", new Object[]{str, Long.valueOf(randomUUID.getMostSignificantBits()), Long.valueOf(randomUUID.getLeastSignificantBits()), str2});
    }
}
