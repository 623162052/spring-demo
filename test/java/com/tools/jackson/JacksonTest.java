package com.tools.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.redisson.AppTestConfiguration;
import com.tools.jackson.jsonproperty.MobilePhone;
import com.tools.jackson.jsonunwrapped.Place;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Jackson TestCase
 */
public class JacksonTest {

    private static final Log LOGGER = LogFactory.getLog(AppTestConfiguration.class);
    private TypeReference typeReference = new TypeReference<HashMap<String, String>>() {};
    private ObjectMapper objectMapper;

    @Before
    public void initJackson(){
        objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        SerializationConfig serialConfig = objectMapper.getSerializationConfig();
    }


    /**
     * JSON to Map
     * @throws Exception
     */
    @Test
    public void testJsonToMap2() throws Exception {
        String jsonString = "{\n" +
                "            \"pc-dialog\": \"1.0.15\",\n" +
                "            \"pc-list\": \"1.2.3\",\n" +
                "            \"pc-date\": \"1.1.5\",\n" +
                "            \"pc-selectTree\": \"1.0.20\",\n" +
                "            \"pc-loading\": \"1.1.0\",\n" +
                "            \"pc-groupSearchForm\": \"1.1.9\",\n" +
                "            \"pc-checkboxes\": \"1.1.6\",\n" +
                "            \"pc-voice\": \"1.1.6\",\n" +
                "            \"pc-simpleTree\": \"0.0.5\",\n" +
                "            \"pc-radios\": \"1.1.3\",\n" +
                "            \"pc-selectList\": \"1.0.1\",\n" +
                "            \"pc-tab\": \"1.1.0\",\n" +
                "            \"pc-process\": \"1.1.1\",\n" +
                "            \"pc-timer\": \"1.0.1\",\n" +
                "            \"pc-detailPanel\": \"1.1.7\",\n" +
                "            \"pc-validator\": \"1.0.12\",\n" +
                "            \"pc-satisfyStar\": \"1.1.1\",\n" +
                "            \"pc-buttonGroup\": \"1.1.2\",\n" +
                "            \"pc-counter\": \"1.1.2\",\n" +
                "            \"pc-select\": \"1.0.18\",\n" +
                "            \"pc-upload\": \"1.1.1\",\n" +
                "            \"pc-editor\": \"1.1.0\"\n" +
                "        }";


        Map<String, String> componentMap = objectMapper.readValue(jsonString, typeReference);
        LOGGER.info("componentMap: " + componentMap);
    }


    /**
     * Object To JSON
     * @throws Exception
     */
    @Test
    public void testObjectToJson() throws Exception {
        Person person = new Person();
        person.setName("alex");
        person.setAge(18);
        person.setGender('1');
        person.setInfo(null);

        // 美化输出
        String personJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        LOGGER.info(" \npersonJson: " + personJson);

    }


    /**
     * List To JSON
     * @throws Exception
     */
    @Test
    public void testListToJson() throws Exception {
        List<Person> personList = new ArrayList<>();
        Person alex = new Person();
        alex.setName("alex");
        alex.setAge(18);
        alex.setGender('1');
        alex.setInfo(null);
        personList.add(alex);

        Person damowang = new Person();
        damowang.setName("alex");
        damowang.setAge(18);
        damowang.setGender('1');
        damowang.setInfo(null);
        personList.add(damowang);

        // 美化输出
        String personListJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(personList);
        LOGGER.info(" \npersonListJson: " + personListJson);
    }

    /**
     * test JsonProperty
     * test JsonAnyGetter JsonAnySetter
     * @throws Exception
     */
    @Test
    public void testJsonProperty() throws Exception {
        TypeReference typeReference = new TypeReference<MobilePhone>() {};

        String jsonString = "{" +
                "\"phone_brand\": \"sony\"," +
                "\"operationSystem\": \"android\"," +
                "\"activeDate\": \"2015-01-04 11:11:12\"," +
                "\"phone_version\": \"7.1\"," +
                "\"ext1\": \"val1\"," +
                "\"ext2\": \"val2\"" +
                "}";
        MobilePhone mobilePhone = objectMapper.readValue(jsonString, typeReference);
        LOGGER.info("mobilePhone: " + mobilePhone);
    }

    /**
     * test JsonUnwrapped
     * @throws Exception
     */
    @Test
    public void testJsonUnwrapped() throws Exception {
        TypeReference typeReference = new TypeReference<Place>() {};
        String jsonString = "{" +
                "\"placeNumber\": 10001," +
                "\"placeName\": \"冬青街\"," +
                "\"longitude\": 11.333," +
                "\"latitude\": 12.3232," +
                "\"remark\": \"这是备注\"" +
                "}";
        Place place = objectMapper.readValue(jsonString, typeReference);
        LOGGER.info("place: " + place);
    }




}
