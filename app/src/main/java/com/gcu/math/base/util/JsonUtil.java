package com.gcu.math.base.util;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created by Martin on 2016/9/4.
 */
public class JsonUtil {

    /**
     * @param map
     * @return
     * @author bojiehuang@163.com map转换为json字符串
     */
    public String map2JsonString(Map<String, Object> map) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param json
     * @return
     * @author bojiehuang@613.com json字符串转为map
     */
    public static Map<String, Object> json2Map(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            @SuppressWarnings("unchecked") Map<String, Object> map = objectMapper.readValue(json, Map.class);
            return map;
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Deprecated
    public static String bean2Json(Object obj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw = new StringWriter();
        JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
        mapper.writeValue(gen, obj);
        gen.close();
        return sw.toString();
    }

    public static <T> T json2Bean(String jsonStr, Class<T> objClass) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, objClass);
    }
}

