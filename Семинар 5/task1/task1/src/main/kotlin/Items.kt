import kotlinx.serialization.Serializable

@Serializable
class Item(val name: String, val price: Int, var check: Boolean, var many: Int) {

}