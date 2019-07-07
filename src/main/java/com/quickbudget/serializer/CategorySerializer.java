package com.quickbudget.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.quickbudget.domain.Category;

import java.io.IOException;

public class CategorySerializer extends StdSerializer<Category> {
    public CategorySerializer() {
        this(null);
    }

    public CategorySerializer(Class<Category> t) {
        super(t);
    }

    @Override
    public void serialize(Category value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("name", value.getName());
        gen.writeEndObject();
    }
}
