package domain

import auth.Role
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

    val memberRole : String

){
    companion object {
        fun create (userId : String, password : String, name : String, email: String, phone: String, role : String): Member {
            return Member(
                userId = userId,
                password = password,
                name = name,
                email = email,
                phone = phone,
                memberRole = Role.USER.getDesc()
            )
        }
    }
}

