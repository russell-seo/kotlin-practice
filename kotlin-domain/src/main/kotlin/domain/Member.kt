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

    val name : String,

    var password : String,


    val email : String,


){
    companion object {
        fun create (password : String, name : String, email: String): Member {
            return Member(
                password = password,
                name = name,
                email = email,

            )
        }
    }
}

