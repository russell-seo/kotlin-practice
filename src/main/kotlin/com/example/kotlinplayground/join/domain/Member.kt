package com.example.kotlinplayground.join.domain

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import javax.persistence.*

@Entity
@Table(name = "`MEMBERS`")
class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id : Long? = null,

    val userId : String,

    val password : String,

    val name : String,

    val email : String,

    val phone : String


) {
    companion object {
        fun create (userId : String, password : String, name : String, email: String, phone: String): Member {
            return Member(
                userId = userId,
                password = password,
                name = name,
                email = email,
                phone = phone
            )
        }
    }
}

fun mapToMember(dto : JoinDto) : Member = Member(
    id = null,
    userId = dto.userId,
    password = dto.password,
    name = dto.name,
    email = dto.email,
    phone = dto.phone,
)
