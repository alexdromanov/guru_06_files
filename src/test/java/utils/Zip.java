package utils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class ZipFiles {

    public static void unZip(String path, String unzippath, String pas) throws ZipException {
        ZipFile zipFile = new ZipFile((path));
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(pas);
        }
        zipFile.extractAll(unzippath);
    }
}