package com.github.falydoor.limesurveyrc.dto.json;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * The type Local date time deserializer.
 */
public class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {
    
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public LocalDateTimeDeserializer(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}
	
	public LocalDateTimeDeserializer() {
		
	}
	
	@Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return LocalDateTime.parse(jsonElement.getAsString().substring(0, 19), formatter);
    }

	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}
	
	
	
}
