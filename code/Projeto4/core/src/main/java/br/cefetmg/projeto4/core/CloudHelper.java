package br.cefetmg.projeto4.core;

import java.util.HashMap;
import java.util.Map;

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.Acl.User;

public final class CloudHelper {
    private CloudHelper() {}
    
    private static final String BUCKET_NAME = "projeto_4";
    public static final String DEFAULT_FOTO = "fotos/avatar.png";
    private static final String PATH_PREFIX = "https://storage.googleapis.com/projeto_4/";
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
        STORAGE = StorageOptions.newBuilder().build().getService();
    }

    public static String inserir(byte[] fileBytes, String fileName) {
        if (!fileName.startsWith(SUBFOLDER))
                fileName = SUBFOLDER + fileName;

        String fileSuffix = FileHelper.getSuffix(fileName);
        String contentType = CONTENT_TYPES.getOrDefault(fileSuffix, "image/*");
    
        BlobId blobId = BlobId.of(BUCKET_NAME, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(contentType).build();
        
        Blob blob = STORAGE.create(blobInfo, fileBytes);
        blob.createAcl(Acl.of(User.ofAllUsers(), Role.READER));

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