package com.example.kotlinplayground.coupon

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    val id : Long? = null

    var couponUUId : String = ""

    var points : Long = 0

    var grade : String = ""


}