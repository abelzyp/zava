package compress;

import org.anarres.lzo.LzoAlgorithm;
import org.anarres.lzo.LzoCompressor;
import org.anarres.lzo.LzoDecompressor;
import org.anarres.lzo.LzoInputStream;
import org.anarres.lzo.LzoLibrary;
import org.anarres.lzo.LzoOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * LZO是致力于解压速度的一种数据压缩算法，
 * LZO是Lempel-Ziv-Oberhumer的缩写，这个算法是无损算法
 *
 * @author zhangyupeng
 * @date 2019-05-08
 */
public class LzoCompress {

    public static byte[] compress(byte[] srcBytes) throws IOException {
        LzoCompressor compressor = LzoLibrary.getInstance().newCompressor(LzoAlgorithm.LZO1X, null);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        LzoOutputStream cs = new LzoOutputStream(os, compressor);
        cs.write(srcBytes);
        cs.close();

        return os.toByteArray();
    }

    public static byte[] uncompress(byte[] bytes) throws IOException {
        LzoDecompressor decompressor = LzoLibrary.getInstance().newDecompressor(LzoAlgorithm.LZO1X, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        LzoInputStream us = new LzoInputStream(is, decompressor);
        int count;
        byte[] buffer = new byte[2048];
        while ((count = us.read(buffer)) != -1) {
            baos.write(buffer, 0, count);
        }
        return baos.toByteArray();
    }
}