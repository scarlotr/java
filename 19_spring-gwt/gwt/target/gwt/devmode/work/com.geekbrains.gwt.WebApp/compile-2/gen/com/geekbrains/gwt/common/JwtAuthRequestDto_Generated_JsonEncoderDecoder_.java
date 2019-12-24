package com.geekbrains.gwt.common;

public class JwtAuthRequestDto_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<com.geekbrains.gwt.common.JwtAuthRequestDto> {
  
  public static final JwtAuthRequestDto_Generated_JsonEncoderDecoder_ INSTANCE = new JwtAuthRequestDto_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(com.geekbrains.gwt.common.JwtAuthRequestDto value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    com.geekbrains.gwt.common.JwtAuthRequestDto parseValue = (com.geekbrains.gwt.common.JwtAuthRequestDto)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getUsername()), rc, "username");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getPassword()), rc, "password");
    return rc;
  }
  
  public com.geekbrains.gwt.common.JwtAuthRequestDto decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    com.geekbrains.gwt.common.JwtAuthRequestDto rc = new com.geekbrains.gwt.common.JwtAuthRequestDto();
    rc.setUsername(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("username")), null));
    rc.setPassword(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("password")), null));
    return rc;
  }
  
}
