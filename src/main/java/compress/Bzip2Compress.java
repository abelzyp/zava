package compress;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * bzip2比传统的gzip的压缩效率更高，但是它的压缩速度较慢
 * jdk中没有对bzip2实现，但是在commons-compress中进行了实现，需要maven引入
 *
 * @author zhangyupeng
 * @date 2019-05-08
 */
public class Bzip2Compress {

    public static byte[] compress(byte[] srcBytes) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BZip2CompressorOutputStream bcos = new BZip2CompressorOutputStream(out);
        bcos.write(srcBytes);
        bcos.close();
        return out.toByteArray();
    }

    public static byte[] uncompress(byte[] bytes) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            BZip2CompressorInputStream unBzip = new BZip2CompressorInputStream(
                    in);
            byte[] buffer = new byte[2048];
            int n;
            while ((n = unBzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }
}