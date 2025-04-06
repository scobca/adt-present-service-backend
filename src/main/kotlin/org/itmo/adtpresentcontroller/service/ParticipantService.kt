package org.itmo.adtpresentcontroller.service

import jakarta.transaction.Transactional
import org.itmo.adtpresentcontroller.dto.participants.CreateParticipantDto
import org.itmo.adtpresentcontroller.dto.participants.UpdateParticipantDto
import org.itmo.adtpresentcontroller.entities.Participant
import org.itmo.adtpresentcontroller.mapper.ParticipantMapper
import org.itmo.adtpresentcontroller.repositories.EventsRepository
import org.itmo.adtpresentcontroller.repositories.ParticipantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class ParticipantService(
    private val participantRepo: ParticipantRepository,
    private val eventsRepo: EventsRepository,
    @Qualifier("participantMapperImpl") private val mapper: ParticipantMapper,
) {
//    @Autowired
//    private lateinit var messagingTemplate: SimpMessagingTemplate

    fun getAll(): List<Participant> = participantRepo.findAll()
    fun findById(id: Long): Participant = participantRepo.findById(id).orElse(null)

    @Transactional
    fun createParticipant(data: CreateParticipantDto) {
        participantRepo.save<Participant>(mapper.dtoToParticipant(data, eventsRepo))
    }

    @Transactional
    fun createPullOfParticipants(data: List<CreateParticipantDto>) {
        data.forEach { createParticipant(it) }
    }

    @Transactional
    fun updateParticipant(data: UpdateParticipantDto) {
        val participant = this.findById(data.id)

        data.name?.let { participant::name.set(it) }
        data.age?.let { participant::age.set(it) }
        data.competence?.let { participant::competence.set(it) }
        data.presence?.let { participant::presence.set(it) }
        data.count?.let { participant::count.set(it) }

//        messagingTemplate.convertAndSend("/topic/searchResults", "updated")
    }
}