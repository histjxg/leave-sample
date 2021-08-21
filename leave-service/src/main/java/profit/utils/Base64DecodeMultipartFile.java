package profit.utils;

import org.apache.commons.lang3.StringUtils;

import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;

/**
 * * base64转为multipartFile工具类
 * *
 */

public class Base64DecodeMultipartFile implements MultipartFile {

    private final byte[] imgContent;

    private final String header;

    public Base64DecodeMultipartFile(byte[] imgContent, String header) {
        this.imgContent = imgContent;
        this.header = header.split(";")[0];
    }

    @Override
    public String getName() {
        SecureRandom r = new SecureRandom();
        return System.currentTimeMillis() + r.nextDouble() + "." + header.split("/")[1];
    }


    @Override
    public String getOriginalFilename() {
        SecureRandom r = new SecureRandom();
        return System.currentTimeMillis() + r.nextInt(10000)  + "." + header.split("/")[1];
    }

    @Override
    public String getContentType() {
        return header.split(":")[1];
    }

    @Override
    public boolean isEmpty() {
        return imgContent == null || imgContent.length == 0;
    }

    @Override
    public long getSize() {
        return imgContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return imgContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(imgContent);
    }

    @Override
    public void transferTo(File dest) {
        try (OutputStream outputStream = new FileOutputStream(dest)) {
            outputStream.write(imgContent);
        } catch (Exception e) {
            LogUtils.error(e);
        }
    }

    /**
     * base64转multipartFile
     *
     * @param base64
     * @return
     */
    public static MultipartFile base64Convert(String base64) {

        if (StringUtils.isNotBlank(base64)) {
            String[] baseStrs = base64.split(",");
            if (baseStrs != null && baseStrs.length > 1) {
                BASE64Decoder decoder = new BASE64Decoder();
                byte[] b = new byte[0];
                try {
                    b = decoder.decodeBuffer(baseStrs[1]);
                } catch (IOException e) {
                    LogUtils.error(e);
                }
                for (int i = 0; i < b.length; ++i) {
                    if (b[i] < 0) {
                        b[i] += 256;
                    }
                }
                MultipartFile multipartFile = new Base64DecodeMultipartFile(b, baseStrs[0]);
                return multipartFile;
            }
        }

        return null;
    }

}