package org.itmo.adtpresentcontroller.mapper

import org.itmo.adtpresentcontroller.dto.events.CreateEventDto
import org.itmo.adtpresentcontroller.entities.Events
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface EventsMapper {
    fun eventToDto(event: Events): CreateEventDto
    fun dtoToEvent(dto: CreateEventDto): Events
}