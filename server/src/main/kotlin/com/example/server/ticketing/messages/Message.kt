package com.example.server.ticketing.messages

import com.example.server.ticketing.tickets.Ticket
import jakarta.persistence.*
import java.sql.Timestamp


@Entity
@Table(name="messages")
class Message (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,
    @ManyToOne
    var ticket: Ticket,
    var fromCustomer : Boolean,
    @Temporal(TemporalType.TIMESTAMP)
    var timestamp: Timestamp,
    @Lob
    var attachment: ByteArray?,
    var content: String
)
