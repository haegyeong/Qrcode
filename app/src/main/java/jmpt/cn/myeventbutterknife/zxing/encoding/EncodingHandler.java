package jmpt.cn.myeventbutterknife.zxing.encoding;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.Hashtable;

/**
 * @author Ryan Tang
 * 
 */
public final class EncodingHandler {
	private static int COLOR = 0xff000000;

	private static int redProgress = 0;
	private static int greenProgress = 0;
	private static int blueProgress = 0;

	public static Bitmap createQRCode(Context context,String str, int widthAndHeight) throws WriterException {

		SharedPreferences spf = context.getSharedPreferences("color", context.MODE_PRIVATE);
		redProgress = spf.getInt("red", 0);
		greenProgress = spf.getInt("green", 0);
		blueProgress = spf.getInt("blue", 0);

		COLOR = Color.rgb(redProgress, greenProgress, blueProgress);


		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix matrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, widthAndHeight, widthAndHeight);
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		int[] pixels = new int[width * height];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

				if (matrix.get(x, y)) {
					pixels[y * width + x] = COLOR;
				}

			}
		}
		Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		return bitmap;
	}
}
