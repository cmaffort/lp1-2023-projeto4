package br.cefetmg.projeto4.javaweb;

import java.io.*;
import java.util.zip.*;

public class CompressionHelper {
    public static byte[] compressFile(File inputFile) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(inputFile);
             DeflaterOutputStream dos = new DeflaterOutputStream(baos)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                dos.write(buffer, 0, length);
            }

            dos.finish();
            dos.flush(); 

            return baos.toByteArray();
        }
    }

    public static byte[] decompressFile(byte[] compressedData) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(compressedData);
             InflaterInputStream iis = new InflaterInputStream(bais);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = iis.read(buffer)) >= 0) {
                baos.write(buffer, 0, length);
            }

            baos.flush(); 

            return baos.toByteArray();
        }
    }
}