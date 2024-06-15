package CreateTable

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.javatime.datetime
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime


class Station(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Station>(Stations)

    var station by Stations.station
}

object Stations : IntIdTable() {
    val station = varchar("station", 50)
}

class Order(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Order>(Orders)

    var user by Orders.userId
    var fromStation by Station referencedOn Orders.fromStationId
    var toStation by Station referencedOn Orders.toStationId
    var status by Orders.status
    var created by Orders.created
}

object Orders : IntIdTable() {
    val userId = integer("user_id")
    val fromStationId = reference("from_station_id", Stations)
    val toStationId = reference("to_station_id", Stations)
    val status = integer("status")
    val created = datetime("created").clientDefault { LocalDateTime.now() }
}

fun initDatabase() {
    Database.connect(
        "jdbc:postgresql://localhost:2749/ticketd?user=ticket&password=password",
        driver = "org.postgresql.Driver"
    )

    transaction {
        SchemaUtils.create(Stations, Orders)

        Stations.insert { it[station] = "Almaty" }
        Stations.insert { it[station] = "Astana" }
        Stations.insert { it[station] = "Moskow" }
        Stations.insert { it[station] = "Pekin" }
    }
}


