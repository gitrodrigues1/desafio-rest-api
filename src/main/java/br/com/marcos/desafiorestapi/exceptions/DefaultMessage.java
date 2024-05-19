package br.com.marcos.desafiorestapi.exceptions;

import java.time.LocalDateTime;

public record DefaultMessage(
            LocalDateTime timestamp,
            int status,
            String error

    ) {

}

