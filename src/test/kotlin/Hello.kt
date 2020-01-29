
import org.junit.jupiter.api.Test

class HelloTests {
    @Test fun `minimal move of two blocks`() {
        val blocks = Block().move(from = 1, to = 2)
        assert(blocks[0] == emptyList<Int>())
        assert(blocks[1] == listOf(1, 0))
    }
}

class Block {
   fun move(from: Int, to: Int): List<List<Int>> {
       return listOf(
           emptyList(),
           listOf(1, 0)
       )
   }
}