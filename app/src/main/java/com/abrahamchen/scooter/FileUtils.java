package com.abrahamchen.scooter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.TypedValue;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by AbrahamChen on 16/4/28.
 */
public class FileUtils {

    public static String APP_NAME = "Scooter";

    public static final String storagePath = Environment.getExternalStorageDirectory()
                                + "/" + Environment.DIRECTORY_DCIM
                                + "/" + APP_NAME;

    public static final SimpleDateFormat imageDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSSS", Locale.US);


    public static File scaleSizeForUploadPhoto(Bitmap img, Uri uri) {
        try {

            int limitedSize = 1280;
            if (img.getHeight() > img.getWidth()) {
                int pixelsHeight = limitedSize;
                int pixelsWidth = (int) ((float) img.getWidth() / (float) img.getHeight() * pixelsHeight);
                img = Bitmap.createScaledBitmap(img, pixelsWidth, pixelsHeight, false);
            } else {
                int pixelsWidth = limitedSize;
                int pixelsHeight = (int) ((float) img.getHeight() / (float) img.getWidth() * pixelsWidth);
                img = Bitmap.createScaledBitmap(img, pixelsWidth, pixelsHeight, false);
            }

            // 開啟檔案
            File file = new File(uri.getPath());

            // 開啟檔案串流
            FileOutputStream out = new FileOutputStream(file);

            // 將 Bitmap壓縮成指定格式的圖片並寫入檔案串流
            img.compress(Bitmap.CompressFormat.JPEG, 80, out);

            //NativeUtil.compressBitmap(img, 90, file.getAbsolutePath(), true);
            // 刷新並關閉檔案串流
            out.flush();
            out.close();

            return file;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public static Uri getTakePhotoUri(String username) {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
        pathBuilder.append('/');
        pathBuilder.append(APP_NAME);
        pathBuilder.append('/');
        pathBuilder.append(username + "-" + imageDateFormat.format(new Date()) + ".jpeg");
        Uri uri = Uri.parse("file://" + pathBuilder.toString());
//		File file = new File(uri.toString());
//		if(file.getParentFile().isDirectory())
//		file.getParentFile().mkdirs();
        File storagePath = new File(FileUtils.storagePath);
        if (!storagePath.isDirectory()) {
            storagePath.mkdir();
        }
        return uri;
    }

    public static String getTakeAudioUri(String username) {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        pathBuilder.append('/');
        pathBuilder.append(username + "-" + imageDateFormat.format(new Date()) + ".3gpp");
//		Uri uri = Uri.parse("file://" + pathBuilder.toString());
//		File file = new File(uri.toString());
//		file.getParentFile().mkdirs();
        File storagePath = new File(FileUtils.storagePath);
        if (!storagePath.isDirectory()) {
            storagePath.mkdir();
        }
        return pathBuilder.toString();
    }

    public static Bitmap scaleBitmap(Context context, Bitmap imgMsg, int scaleSize) {
        final float scale = context.getResources().getDisplayMetrics().density;
        if (imgMsg.getHeight() > imgMsg.getWidth()) {
            int pixelsHeight = (int) (scaleSize * scale + 0.5f);
            int pixelsWidth = (int) ((float) imgMsg.getWidth() / (float) imgMsg.getHeight() * pixelsHeight);
            imgMsg = Bitmap.createScaledBitmap(imgMsg, pixelsWidth, pixelsHeight, false);
        } else {
            int pixelsWidth = (int) (scaleSize * scale + 0.5f);
            int pixelsHeight = (int) ((float) imgMsg.getHeight() / (float) imgMsg.getWidth() * pixelsWidth);
            imgMsg = Bitmap.createScaledBitmap(imgMsg, pixelsWidth, pixelsHeight, false);
        }
        return imgMsg;
    }

    public static int pxToDp(Context context, int px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        int dp = (int) (px * scale + 0.5f);
        return dp;
    }

    public static int dpToPx(Context context, int dp) {
        Resources r = context.getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                r.getDisplayMetrics()
        );
//		final float scale = context.getResources().getDisplayMetrics().density;
//		int px = (int) ((dp - 0.5f)/ scale );
        return px;
    }

    @NonNull
    public static String bitmapToBase64(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 70, baos); //bm is the bitmap object
        return Base64.encodeToString(baos.toByteArray(), Base64.NO_WRAP);
    }


    public static byte[] getFileBytes(File file) throws IOException {
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            int bytes = (int) file.length();
            byte[] buffer = new byte[bytes];
            int readBytes = bis.read(buffer);
            if (readBytes != buffer.length) {
                throw new IOException("Entire file not read");
            }
            return buffer;
        } finally {
            if (bis != null) {
                bis.close();
            }
        }

    }

}
