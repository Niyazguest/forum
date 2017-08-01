package ru.niyaz.forumserver.service.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.niyaz.forumserver.model.news.NewsObject;

import javax.naming.InitialContext;
import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Нияз on 02.02.2017.
 */

@Service
public class VkApiServiceImpl implements VkApiService {

    private final String methodPrefix = "https://api.vk.com/method/";

    @Value("${vk.api_version}")
    private String vkApiVersion;

    private InitialContext initialContext;

    private String vkGroupName;
    private String vkClientId;
    private String vkClientSecret;

    public VkApiServiceImpl(InitialContext ic) {
        this.initialContext = ic;
        try {
            this.vkGroupName = (String) initialContext.lookup("java:/comp/env/vkGroupName");
            this.vkClientId = (String) initialContext.lookup("java:/comp/env/vkClientId");
            this.vkClientSecret = (String) initialContext.lookup("java:/comp/env/vkClientSecret");
        } catch (Exception ex) {

        }
    }

    @Override
    public List<NewsObject> getNews(Instant from, Instant to) throws Exception {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("domain", vkGroupName);
            params.put("offset", "0");
            params.put("count", "5");
            JSONObject jsonObject = sendQuery("wall.get", params);

            List<NewsObject> news = new ArrayList<>();

            Object o = jsonObject.get("response");
            if (o instanceof JSONObject) {
                JSONArray items = ((JSONObject) o).getJSONArray("items");
                if (items != null) {
                    ObjectMapper mapper = new ObjectMapper();
                    int i;
                    for (i = 0; i < items.length(); i++) {
                        try {
                            NewsObject newsObject = mapper.readValue(items.get(i).toString(), NewsObject.class);
                            news.add(newsObject);
                        } catch (Exception ex) {
                            continue;
                        }
                    }
                } else {
                    throw new Exception();
                }
            } else {
                throw new Exception();
            }

            return news;
        } catch (Exception ex) {
            throw ex;
        }
    }

    protected JSONObject sendQuery(String method, Map<String, String> params) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder(this.methodPrefix + method);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            uriBuilder.setParameter(entry.getKey(), entry.getValue());
        }
        uriBuilder.setParameter("v", vkApiVersion);

        URI uri = uriBuilder.build();

        HttpGet httpGet = new HttpGet(uri);
        HttpResponse response = httpClient.execute(httpGet);
        try (InputStream is = response.getEntity().getContent()) {
            StringWriter stringWriter = new StringWriter();
            Reader reader = new InputStreamReader(is);
            IOUtils.copy(reader, stringWriter);
            JSONObject object = new JSONObject(new String(stringWriter.toString().getBytes(), StandardCharsets.UTF_8));
            return object;
        } finally {
            httpGet.releaseConnection();
        }
    }
}
