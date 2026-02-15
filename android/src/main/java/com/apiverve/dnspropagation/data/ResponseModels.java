// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     DNSPropagationCheckerData data = Converter.fromJsonString(jsonString);

package com.apiverve.dnspropagation.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static DNSPropagationCheckerData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(DNSPropagationCheckerData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(DNSPropagationCheckerData.class);
        writer = mapper.writerFor(DNSPropagationCheckerData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// DNSPropagationCheckerData.java

package com.apiverve.dnspropagation.data;

import com.fasterxml.jackson.annotation.*;

public class DNSPropagationCheckerData {
    private String domain;
    private String recordType;
    private boolean propagationComplete;
    private long serversChecked;
    private long serversResponded;
    private long uniqueResponses;
    private Result[] results;

    @JsonProperty("domain")
    public String getDomain() { return domain; }
    @JsonProperty("domain")
    public void setDomain(String value) { this.domain = value; }

    @JsonProperty("recordType")
    public String getRecordType() { return recordType; }
    @JsonProperty("recordType")
    public void setRecordType(String value) { this.recordType = value; }

    @JsonProperty("propagationComplete")
    public boolean getPropagationComplete() { return propagationComplete; }
    @JsonProperty("propagationComplete")
    public void setPropagationComplete(boolean value) { this.propagationComplete = value; }

    @JsonProperty("serversChecked")
    public long getServersChecked() { return serversChecked; }
    @JsonProperty("serversChecked")
    public void setServersChecked(long value) { this.serversChecked = value; }

    @JsonProperty("serversResponded")
    public long getServersResponded() { return serversResponded; }
    @JsonProperty("serversResponded")
    public void setServersResponded(long value) { this.serversResponded = value; }

    @JsonProperty("uniqueResponses")
    public long getUniqueResponses() { return uniqueResponses; }
    @JsonProperty("uniqueResponses")
    public void setUniqueResponses(long value) { this.uniqueResponses = value; }

    @JsonProperty("results")
    public Result[] getResults() { return results; }
    @JsonProperty("results")
    public void setResults(Result[] value) { this.results = value; }
}

// Result.java

package com.apiverve.dnspropagation.data;

import com.fasterxml.jackson.annotation.*;

public class Result {
    private String server;
    private String location;
    private String ip;
    private boolean success;
    private Record[] records;
    private Object error;
    private long responseTime;

    @JsonProperty("server")
    public String getServer() { return server; }
    @JsonProperty("server")
    public void setServer(String value) { this.server = value; }

    @JsonProperty("location")
    public String getLocation() { return location; }
    @JsonProperty("location")
    public void setLocation(String value) { this.location = value; }

    @JsonProperty("ip")
    public String getIP() { return ip; }
    @JsonProperty("ip")
    public void setIP(String value) { this.ip = value; }

    @JsonProperty("success")
    public boolean getSuccess() { return success; }
    @JsonProperty("success")
    public void setSuccess(boolean value) { this.success = value; }

    @JsonProperty("records")
    public Record[] getRecords() { return records; }
    @JsonProperty("records")
    public void setRecords(Record[] value) { this.records = value; }

    @JsonProperty("error")
    public Object getError() { return error; }
    @JsonProperty("error")
    public void setError(Object value) { this.error = value; }

    @JsonProperty("responseTime")
    public long getResponseTime() { return responseTime; }
    @JsonProperty("responseTime")
    public void setResponseTime(long value) { this.responseTime = value; }
}

// Record.java

package com.apiverve.dnspropagation.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Record {
    THE_1422508046;

    @JsonValue
    public String toValue() {
        switch (this) {
            case THE_1422508046: return "142.250.80.46";
        }
        return null;
    }

    @JsonCreator
    public static Record forValue(String value) throws IOException {
        if (value.equals("142.250.80.46")) return THE_1422508046;
        throw new IOException("Cannot deserialize Record");
    }
}