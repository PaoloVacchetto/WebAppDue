package com.example.server.ticketing.tickets

import com.example.server.DuplicateException
import com.example.server.NotFoundException
import com.example.server.NotValidException
import com.example.server.products.ProductService
import com.example.server.profiles.ProfileService
import com.example.server.ticketing.messages.Message
import io.micrometer.observation.annotation.Observed
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service


@Service
@Observed
@Transactional
class TicketServiceImpl (
    private val ticketRepository: TicketRepository,
    private val profileService: ProfileService,
    private val productService: ProductService)
    :TicketService {
    override fun getAll(): List<Ticket> {
        return ticketRepository.findAll()
    }

    override fun getById(ticketId: Long): Ticket {
        val t = ticketRepository.findByIdOrNull(ticketId)
        return t ?: throw NotFoundException("Ticket not found")
    }

    override fun createTicket(ticketDTO: TicketDTO): Ticket {
        if (ticketDTO.id != null && ticketRepository.findByIdOrNull(ticketDTO.id) != null ) throw DuplicateException("Ticket already exists")
        if (ticketDTO.statuses.size != 1 && ticketDTO.statuses.first() != States.OPEN) throw NotValidException("Ticket status is invalid")
        val customer = profileService.getProfileByEmailP(ticketDTO.customer.email)
        val technician = ticketDTO.technician?.email?.let {profileService.getProfileByEmailP(it)}
        val product = productService.getByIdProduct(ticketDTO.product.productId)

        val messages = mutableSetOf<Message>()

        return ticketRepository.save(
            Ticket(
                product = product,
                customer = customer,
                technician = technician,
                statuses = ticketDTO.statuses,
                description = ticketDTO.description,
                priority = ticketDTO.priority,
                messages = messages
            )

        )
    }

    override fun editTicket(ticketId: Long, ticketDTO: TicketDTO): Ticket {
        val ticket = getById(ticketId)
        val customer = profileService.getProfileByEmailP(ticketDTO.customer.email)
        val technician = ticketDTO.technician?.email?.let {profileService.getProfileByEmailP(it)}
        val product = productService.getByIdProduct(ticketDTO.product.productId)

        return ticketRepository.save(
            Ticket(
                id = ticket.id,
                product = product,
                customer = customer,
                technician = technician,
                statuses = ticketDTO.statuses,
                description = ticketDTO.description,
                priority = ticketDTO.priority,
                messages = ticket.messages
            )
        )
    }

    override fun deleteTicket(ticketId: Long, ticket: TicketDTO): Ticket {
        val ticket = getById(ticketId)
        ticketRepository.deleteById(ticketId)
        return ticket
    }

    override fun updateStatus(ticketId: Long, state: States): Ticket {
        val ticket = getById(ticketId)
        when (ticket.statuses.last()) {
            States.OPEN -> {
                if (state != States.RESOLVED && state != States.CLOSED && state != States.IN_PROGRESS) throw NotValidException(
                    "Invalid status"
                )
            }

            States.CLOSED -> {
                if (state != States.RESOLVED) throw NotValidException("Invalid status")
            }

            States.IN_PROGRESS -> {
                if (state != States.OPEN && state != States.CLOSED && state != States.RESOLVED) throw NotValidException(
                    "Invalid status"
                )
            }

            States.REOPEN -> {
                if (state != States.IN_PROGRESS && state != States.RESOLVED) throw NotValidException("Invalid status")
            }

            States.RESOLVED -> {
                if (state != States.REOPEN && state != States.CLOSED) throw NotValidException("Invalid status")
            }
        }
        ticket.statuses.add(state)
        return ticketRepository.save(
            ticket
        )
    }


}