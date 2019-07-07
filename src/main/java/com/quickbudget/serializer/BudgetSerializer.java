package com.quickbudget.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.quickbudget.domain.Budget;

import java.io.IOException;

public class BudgetSerializer extends StdSerializer<Budget> {
    public BudgetSerializer() {
        this(null);
    }

    public BudgetSerializer(Class<Budget> t) {
        super(t);
    }

    @Override
    public void serialize(Budget value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("name", value.getName());
        gen.writeNumberField("accounts", value.getAccounts().size());
        gen.writeEndObject();
    }
}
