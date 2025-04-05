package org.itmo.adtpresentcontroller.controllers

import jakarta.transaction.Transactional
import org.itmo.adtpresentcontroller.dto.participants.CreateParticipantDto
import org.itmo.adtpresentcontroller.dto.participants.UpdateParticipantDto
import org.itmo.adtpresentcontroller.service.ParticipantService
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/participant")
class ParticipantController(private val participantService: ParticipantService) {
    @PostMapping("/create")
    @Transactional
    fun createParticipant(@RequestBody data: CreateParticipantDto) = participantService.createParticipant(data)

    @PatchMapping("/update")
    @Transactional
    fun updateParticipant(@RequestBody data: UpdateParticipantDto) = participantService.updateParticipant(data)
}