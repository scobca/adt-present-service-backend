package org.itmo.adtpresentcontroller.controllers

import org.itmo.adtpresentcontroller.dto.events.CreateEventDto
import org.itmo.adtpresentcontroller.service.EventsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/events")
class EventsController(private val eventsService: EventsService) {
    @GetMapping("/getAll")
    fun getAll() = eventsService.getAll()

    @GetMapping("/getById/{id}")
    fun getById(@PathVariable id: Long) = eventsService.getById(id)

    @PostMapping("/create")
    fun create(@RequestBody data: CreateEventDto) = eventsService.create(data)
}