package com.cestbonteam.common.http.fastjson;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.victoralbertos.jolyglot.JolyglotGenerics;
import io.victoralbertos.jolyglot.Types;

/**
 * Created by LJW on 2017/5/18.
 */

public class FastjsonSpeaker implements JolyglotGenerics {


    @Override
    public String toJson(Object src, Type typeOfSrc) {
        return JSONObject.toJSONString(src);
    }

    @Override
    public <T> T fromJson(String json, Type type) throws RuntimeException {
        return JSONObject.parseObject(json, type);
    }

    @Override
    public <T> T fromJson(File file, Type typeOfT) throws RuntimeException {

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            T object = JSONObject.parseObject(reader.toString(), typeOfT);
            reader.close();
            return object;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException i) {
                }
            }
        }
    }

    @Override
    public GenericArrayType arrayOf(Type componentType) {
        return Types.arrayOf(componentType);
    }

    @Override
    public ParameterizedType newParameterizedType(Type rawType, Type... typeArguments) {
        return Types.newParameterizedType(rawType, typeArguments);
    }

    @Override
    public String toJson(Object src) {
        return JSONObject.toJSONString(src);
    }

    @Override
    public <T> T fromJson(String json, Class<T> classOfT) throws RuntimeException {
        return JSONObject.parseObject(json, classOfT);
    }

    @Override
    public <T> T fromJson(File file, Class<T> classOfT) throws RuntimeException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            T object = JSONObject.parseObject(reader.toString(), classOfT);
            reader.close();
            return object;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException i) {
                }
            }
        }
    }
}
