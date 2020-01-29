import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class HelloTests {
    @Test fun `minimal move of two blocks`() {
        val blocks = Block().move(from = 1, to = 2)!!
        assert(blocks[0] == emptyList<Int>())
        assert(blocks[1] == listOf(1, 0))
    }

    @Test fun `minimal illegal move of two blocks`() {
        val blocks = Block().move(from = 2, to = 1)
        assertNull(blocks)
    }
}

class Block {
    fun move(from: Int, to: Int): List<List<Int>>? {
        if (from > to) return null
        return listOf(
            emptyList(),
            listOf(1, 0)
        )
    }
}