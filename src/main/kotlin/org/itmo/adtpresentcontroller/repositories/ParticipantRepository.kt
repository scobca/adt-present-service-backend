package org.itmo.adtpresentcontroller.repositories

import org.itmo.adtpresentcontroller.entities.Participant
import org.springframework.data.jpa.repository.JpaRepository

interface ParticipantRepository : JpaRepository<Participant, Long>