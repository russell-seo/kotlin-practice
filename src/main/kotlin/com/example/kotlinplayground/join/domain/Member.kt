package com.example.kotlinplayground.join.domain

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import javax.persistence.*

@Entity
class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    var id : Long?,

    var name : String,

    var email : String,

    var phone : String


)

fun mapToMember(dto : JoinDto) : Member = Member(
    id = null,
    name = dto.name,
    email = dto.email,
    phone = dto.phone,
)
