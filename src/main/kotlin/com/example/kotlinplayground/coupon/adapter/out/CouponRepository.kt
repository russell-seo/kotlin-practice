package com.example.kotlinplayground.coupon.adapter.out

import com.example.kotlinplayground.coupon.Coupon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CouponRepository : JpaRepository<Coupon, Long> {
}