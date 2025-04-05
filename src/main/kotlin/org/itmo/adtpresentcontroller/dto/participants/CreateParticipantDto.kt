package org.itmo.adtpresentcontroller.dto.participants

data class CreateParticipantDto(
    val name: String,
    val competence: String,
    val age: String,
    val presence: Boolean,
    val eventId: Long,
)
