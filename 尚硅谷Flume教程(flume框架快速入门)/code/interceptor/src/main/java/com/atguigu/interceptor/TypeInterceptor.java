package com.atguigu.interceptor;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TypeInterceptor implements Interceptor {

    private List<Event> addHeaderEvents;

    @Override
    public void initialize() {
        addHeaderEvents = new ArrayList<>();
    }

    @Override
    public Event intercept(Event event) {

        Map<String, String> headers = event.getHeaders();

        String body = new String(event.getBody());

        if (body.contains("hello")) {
            headers.put("type", "atguigu");
        } else {
            headers.put("type", "bigdata");
        }


        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {

        addHeaderEvents.clear();

        for (Event event : list) {
            addHeaderEvents.add(intercept(event));
        }


        return addHeaderEvents;
    }

    @Override
    public void close() {

    }


    public static class Builder implements Interceptor.Builder{

        @Override
        public Interceptor build() {
            return new TypeInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
