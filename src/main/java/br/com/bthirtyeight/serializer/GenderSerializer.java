package br.com.bthirtyeight.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

//classe para personalizar a seriliação
public class GenderSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String gender, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        String formatedGender = "Male".equals(gender) ? "M" : "F";
        jsonGenerator.writeString(formatedGender);//vai defenir a tag correspondente com essa formatação
    }
}
