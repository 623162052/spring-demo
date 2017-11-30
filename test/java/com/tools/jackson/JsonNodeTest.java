package com.tools.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;

public class JsonNodeTest {

    private static final Log LOGGER = LogFactory.getLog(JsonNodeTest.class);
    private TypeReference typeReference = new TypeReference<HashMap<String, String>>() {};
    private ObjectMapper objectMapper;

    @Before
    public void initJackson() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        SerializationConfig serialConfig = objectMapper.getSerializationConfig();
    }


    /**
     * JSON to JsonNode Tree
     *
     * @throws Exception
     */
    @Test
    public void testObjectToJson() throws Exception {
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator generator = jsonFactory.createGenerator(new FileOutputStream("tree.json"));

        JsonNodeFactory factory = new JsonNodeFactory(false);
        // 生成一个根节点
        ObjectNode rootNode = factory.objectNode();
        // 添加普通属性
        rootNode.put("name", "alex");
        rootNode.put("age", 11);

        // 可以生成一个对象节点，然后把这个节点加入为根节点的子节点
        ObjectNode address = factory.objectNode();
        address.put("homeAddress", "New York");
        address.put("workAddress", "Tokyo");
        rootNode.set("address", address);

        // 同样可以生成一个Array节点， 然后把这个Array节点加入为根节点的子节点
        ArrayNode friends = factory.arrayNode();
        ObjectNode friend1 = factory.objectNode();
        friend1.put("name", "weiying");

        ObjectNode friend2 = factory.objectNode();
        friend2.put("name", "caifang");

        friends.add(friend1).add(friend2);
        rootNode.set("friends", friends);

        objectMapper.writeTree(generator, rootNode);

    }


    /**
     * JsonNode 遍历 JSON
     * @throws Exception
     */
    @Test
    public void testTraverseJson() throws Exception {
        JsonNode rootNode = objectMapper.readTree(new File("tree.json"));
        traverse(rootNode);
    }

    /**
     * 遍历
     * @param rootNode
     */
    private void traverse(JsonNode rootNode){
        if (rootNode.getNodeType().equals(JsonNodeType.OBJECT)) {
            Iterator<String> fieldNames = rootNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                JsonNode node = rootNode.get(fieldName);
                LOGGER.info(fieldName);
                traverse(node);
            }
        } else if (rootNode.getNodeType().equals(JsonNodeType.ARRAY)) {
            ArrayNode array = (ArrayNode) rootNode;
            Iterator<JsonNode> iter = array.iterator();
            iter.forEachRemaining(x -> traverse(x));
        } else {
            LOGGER.info(rootNode);
        }
    }


}
