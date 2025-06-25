package com.dalazu.bteb.api;

import com.dalazu.bteb.model.Result;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResultDeserializer implements JsonDeserializer<Result> {

    @Override
    public Result deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        Result result = new Result();

        result.setRoll(jsonObject.get("roll").getAsString());
        result.setYear(jsonObject.get("year").getAsInt());
        result.setSemester(jsonObject.get("semester").getAsInt());
        result.setStatus(jsonObject.get("status").getAsString());

        JsonElement resultElement = jsonObject.get("result");
        if (resultElement.isJsonArray()) {
            List<String> resultList = new ArrayList<>();
            for (JsonElement element : resultElement.getAsJsonArray()) {
                resultList.add(element.getAsString());
            }
            result.setResult(resultList);
        } else if (resultElement.isJsonPrimitive()) {
            List<String> resultList = new ArrayList<>();
            resultList.add(resultElement.getAsString());
            result.setResult(resultList);
        }

        return result;
    }
}