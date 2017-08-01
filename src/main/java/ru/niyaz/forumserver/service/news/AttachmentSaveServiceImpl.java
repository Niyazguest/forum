package ru.niyaz.forumserver.service.news;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.niyaz.forumserver.enums.news.AttachmentType;

import javax.naming.InitialContext;
import java.io.*;
import java.net.URI;


/**
 * Created by Нияз on 05.02.2017.
 */

@Service
public class AttachmentSaveServiceImpl implements AttachmentSaveService {

    private String cacheDir;

    @Value("${cache.images_cache_dir}")
    private String imagesCacheDir;

    @Autowired
    public AttachmentSaveServiceImpl(InitialContext ic) {
        try {
            this.cacheDir = (String) ic.lookup("java:/comp/env/cacheDir");
        } catch (Exception ex) {

        }
    }

    public File save(String url, AttachmentType attachmentType) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            URIBuilder uriBuilder = new URIBuilder(url);

            URI uri = uriBuilder.build();

            HttpGet httpGet = new HttpGet(uri);
            HttpResponse response = httpClient.execute(httpGet);

            switch (response.getStatusLine().getStatusCode()) {
                case 200:
                    String dir;
                    switch (attachmentType) {
                        case PHOTO:
                            dir = cacheDir + imagesCacheDir;
                            break;
                        default:
                            return null;
                    }

                    String[] str = url.split("/");
                    String fileName = str[str.length - 1];
                    File file = new File(dir, fileName);

                    try (InputStream is = response.getEntity().getContent(); FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                        IOUtils.copy(is, fileOutputStream);
                        return file;
                    } finally {
                        httpGet.releaseConnection();
                    }
                default:
                    return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }
}
