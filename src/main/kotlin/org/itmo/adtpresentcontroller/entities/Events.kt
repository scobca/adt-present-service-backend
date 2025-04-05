package org.itmo.adtpresentcontroller.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

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

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var participants: MutableList<Participant> = mutableListOf()
}