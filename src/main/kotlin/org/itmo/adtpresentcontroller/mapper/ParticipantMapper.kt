package org.itmo.adtpresentcontroller.mapper

import org.itmo.adtpresentcontroller.dto.participants.CreateParticipantDto
import org.itmo.adtpresentcontroller.entities.Participant
import org.itmo.adtpresentcontroller.repositories.EventsRepository
import org.mapstruct.AfterMapping
import org.mapstruct.Context
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget

@Mapper(componentModel = "spring", uses = [EventsRepository::class])
abstract class ParticipantMapper {
    abstract fun participantToDto(participant: Participant): CreateParticipantDto

    @Mapping(target = "event", ignore = true)
    abstract fun dtoToParticipant(dto: CreateParticipantDto, @Context eventsRepo: EventsRepository): Participant

    @AfterMapping
    fun afterMapping(
        dto: CreateParticipantDto,
        @MappingTarget participant: Participant,
        @Context eventsRepo: EventsRepository
    ) {
        participant.event = eventsRepo.findById(dto.eventId).orElseThrow()
    }
}