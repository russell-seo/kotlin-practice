package com.example.kotlinplayground.join.domain

import javax.persistence.*

@Entity
class MemberRole(
        @Id
        @GeneratedValue
        @Column(name = "role_id")
        val Id : Long = 0,

        val roleName : String = "",

) {


}