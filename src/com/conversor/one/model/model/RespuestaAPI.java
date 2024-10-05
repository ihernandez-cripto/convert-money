package com.conversor.one.model.model;

public record RespuestaAPI(String result, String documentation, String term_of_use, long time_last_update_unix,String time_last_update_utc, long time_next_update_unix, String time_next_update_utc, String  base_code, String target_code, Double conversion_rate, Double conversion_result  ) {
}
