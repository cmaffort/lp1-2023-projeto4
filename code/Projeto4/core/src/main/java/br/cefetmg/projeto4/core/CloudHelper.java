package br.cefetmg.projeto4.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.Lists;

public final class CloudHelper {
    private CloudHelper() {}
    
    private static final String BUCKET_NAME = "projeto4";
    private static final String JSON_PATH = "cred.json"; 
    public static final String DEFAULT_FOTO = "fotos/avatar.png";
    private static final String PATH_PREFIX = "https://storage.cloud.google.com/projeto4/";
    public static final String SUBFOLDER = "fotos/";
    private static final Storage STORAGE;
    private static final Map<String, String> CONTENT_TYPES;

    static {
        Map<String, String> contentTypes = new HashMap<>();

        contentTypes.put("jpg", "image/jpeg");
        contentTypes.put("jpeg", "image/jpeg");
        contentTypes.put("png", "image/png");
        contentTypes.put("gif", "image/gif");

        CONTENT_TYPES = Map.copyOf(contentTypes);

        try (InputStream jsonInputStream = CloudHelper.class.getClassLoader().getResourceAsStream(JSON_PATH)) {
            if (jsonInputStream == null) 
                throw new FileNotFoundException("File not found: " + JSON_PATH);

            GoogleCredentials credentials = GoogleCredentials.fromStream(jsonInputStream)
                    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));

            STORAGE = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static String inserir(byte[] fileBytes, String fileName) {
        if (!fileName.startsWith(SUBFOLDER))
                fileName = SUBFOLDER + fileName;

        String fileSuffix = FileHelper.getSuffix(fileName);
        String contentType = CONTENT_TYPES.getOrDefault(fileSuffix, "image/*");
    
        BlobId blobId = BlobId.of(BUCKET_NAME, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(contentType).build();
        STORAGE.create(blobInfo, fileBytes);

        return PATH_PREFIX + fileName;        
    }

    public static String deletar(String foto) {
        try {
            String fileName = StringHelper.removePrefix(foto, PATH_PREFIX);

            if (!fileName.startsWith(SUBFOLDER))
                fileName = SUBFOLDER + fileName;
            if (fileName.equals(DEFAULT_FOTO))
                throw new IllegalArgumentException("Cannot delete default avatar");

            BlobId blobId = BlobId.of(BUCKET_NAME, fileName);

            if (STORAGE.delete(blobId)) 
                return PATH_PREFIX + DEFAULT_FOTO;
            else 
                return foto;
        } catch (StorageException e) {
            System.err.println("Exception whilst deletion: " + e.getMessage());
            e.printStackTrace();

            return foto;
        }
    }
}