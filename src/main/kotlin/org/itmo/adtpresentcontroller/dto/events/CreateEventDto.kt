package org.itmo.adtpresentcontroller.dto.events

import java.time.LocalDateTime

data class CreateEventDto(
    val name: String,
    val data: LocalDateTime,
    val description: String,
    val classroom: Long
)
