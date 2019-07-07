package com.quickbudget.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.quickbudget.domain.Transaction;

import java.io.IOException;

public class TransactionSerializer extends StdSerializer<Transaction> {
    public TransactionSerializer() {
        this(null);
    }

    public TransactionSerializer(Class<Transaction> t) {
        super(t);
    }

    @Override
    public void serialize(Transaction value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("name", value.getName());
        gen.writeStringField("payee", value.getPayee());
        gen.writeNumberField("inflow", value.getInflow());
        gen.writeNumberField("outflow", value.getOutflow());
        gen.writeStringField("payee", value.getPayee());
        gen.writeStringField("account", value.getAccount().getName());
        gen.writeNumberField("categories", value.getCategories().size());
        gen.writeEndObject();
    }
}
