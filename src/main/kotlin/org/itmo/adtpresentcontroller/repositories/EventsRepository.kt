package org.itmo.adtpresentcontroller.repositories

import org.itmo.adtpresentcontroller.entities.Events
import org.springframework.data.jpa.repository.JpaRepository

interface EventsRepository : JpaRepository<Events, Long>