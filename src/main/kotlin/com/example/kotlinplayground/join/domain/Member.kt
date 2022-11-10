package com.example.kotlinplayground.join.domain

import com.example.kotlinplayground.auth.Role
import com.example.kotlinplayground.coupon.Coupon
import javax.persistence.*

@Entity
@Table(name = "`MEMBERS`")
class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    var id : Long? = null,

    val userId : String,

    var password : String,

    val name : String,

    val email : String,

    val phone : String,

    val memberRole : String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id")
    val coupon: Coupon?

){
    companion object {
        fun create (userId : String, password : String, name : String, email: String, phone: String, role : String): Member {
            return Member(
                    userId = userId,
                    password = password,
                    name = name,
                    email = email,
                    phone = phone,
                    memberRole = Role.USER.getDesc(),
                    coupon = null

            )
        }
    }
}

//fun mapToMember(dto : JoinDto) : Member = Member(
//    id = null,
//    userId = dto.userId,
//    password = dto.password,
//    name = dto.name,
//    email = dto.email,
//    phone = dto.phone,
//    memberRole = Role.USER.getDesc()
//)
