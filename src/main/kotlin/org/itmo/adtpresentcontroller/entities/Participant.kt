package org.itmo.adtpresentcontroller.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "participants")
class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var name: String = ""

    @Column(nullable = false)
    var competence: String = ""

    @Column(nullable = false)
    var age: String = ""

    @Column(nullable = false)
    var presence: Boolean = false

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    var event: Events? = null

    @Column(nullable = true)
    var count: Long? = null
}