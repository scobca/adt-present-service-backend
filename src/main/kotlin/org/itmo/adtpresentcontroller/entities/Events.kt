package org.itmo.adtpresentcontroller.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "events")
class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var name: String = ""

    @Column(nullable = false)
    var description: String = ""

    @Column(nullable = false)
    var data: LocalDateTime? = null

    @Column(nullable = false)
    var classroom: Long = 0
}