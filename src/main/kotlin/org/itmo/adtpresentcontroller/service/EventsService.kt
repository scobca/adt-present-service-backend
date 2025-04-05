package org.itmo.adtpresentcontroller.service

import jakarta.transaction.Transactional
import org.itmo.adtpresentcontroller.dto.events.CreateEventDto
import org.itmo.adtpresentcontroller.entities.Events
import org.itmo.adtpresentcontroller.mapper.EventsMapper
import org.itmo.adtpresentcontroller.repositories.EventsRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class EventsService(
    private val eventsRepository: EventsRepository,
    @Qualifier("eventsMapperImpl") private val mapper: EventsMapper
) {
    fun getAll(): List<Events> = eventsRepository.findAll()
    fun getById(id: Long) = eventsRepository.findById(id)

    @Transactional
    fun create(data: CreateEventDto) {
        eventsRepository.save<Events>(mapper.dtoToEvent(data))
    }
}