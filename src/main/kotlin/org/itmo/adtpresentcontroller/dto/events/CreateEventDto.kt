package org.itmo.adtpresentcontroller.dto.events

import java.sql.Timestamp

data class CreateEventDto(
    val name: String,
    val data: Timestamp,
    val description: String,
    val classroom: Long
)
