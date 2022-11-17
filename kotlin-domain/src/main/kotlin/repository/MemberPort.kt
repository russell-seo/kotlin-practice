package repository

import domain.Member

interface MemberPort {

    fun findById(id : Long) : Member?

    fun getById(id : Long) : Member

    fun findByEmail(email : String) : Member?

    fun getByEmail(email: String) : Member

    fun save(email: String, password : String, name:String)
}