package com.barber.shop.api.representation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record SaveClientRequest(

        @NotNull
        @JsonProperty("name")
        String name,
        @NotNull
        @JsonProperty("name")
        String phone,
        @NotNull
        @JsonProperty("name")
        String email

){}


