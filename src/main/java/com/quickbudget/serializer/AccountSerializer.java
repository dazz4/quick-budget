package com.quickbudget.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.quickbudget.domain.Account;

import java.io.IOException;

public class AccountSerializer extends StdSerializer<Account> {
    public AccountSerializer() {
        this(null);
    }

    public AccountSerializer(Class<Account> t) {
        super(t);
    }

    @Override
    public void serialize(Account value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("name", value.getName());
        gen.writeNumberField("balance", value.getBalance());
        gen.writeStringField("budget", value.getBudget().getName());
        gen.writeNumberField("transactions", value.getTransactions().size());
        gen.writeEndObject();
    }
}
