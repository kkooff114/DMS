package com.cestbonteam.common.http.fastjson;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by LJW on 15/10/20.
 */
public class FastJSONResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Type type;

    FastJSONResponseBodyConverter(Type type) {
        this.type = type;
    }


    @Override
    public T convert(ResponseBody value) throws IOException {
        String reader = value.string();
        try {
            return JSON.parseObject(reader, type);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
