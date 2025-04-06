package org.itmo.adtpresentcontroller.dto.participants

data class UpdateParticipantDto(
    val id: Long,
    val name: String?,
    val competence: String?,
    val age: String?,
    val presence: Boolean?,
    val count: Long?,
)