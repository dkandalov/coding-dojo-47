import org.junit.jupiter.api.Test

class HelloTests {
    @Test fun `move 1 onto 2`() {
        val blocks = Blocks().move(from = 0, to = 1)
        assert(blocks[0] == emptyList<Int>())
        assert(blocks[1] == listOf(1, 0))
    }

    @Test fun `move 2 onto 1`() {
        val blocks = Blocks().move(from = 1, to = 0)
        assert(blocks[0] == listOf(0, 1))
        assert(blocks[1] == emptyList<Int>())
    }

    @Test fun `move 1 onto 1`() {
        val blocks = Blocks().move(from = 0, to = 0)
        assert(blocks[0] == listOf(0))
        assert(blocks[1] == listOf(1))
    }

    @Test fun `3 blocks - move 1 onto 1`() {
        val blocks = Blocks(3).move(from = 0, to = 0)
        assert(blocks[0] == listOf(0))
        assert(blocks[1] == listOf(1))
        assert(blocks[2] == listOf(2))
    }
}

class Blocks(
    private val size: Int = 2,
    private val state: List<List<Int>> = List(size) { listOf(it) }
) {
    fun move(from: Int, to: Int): List<List<Int>> {
        if (from == to) return state
        if (from > to) return listOf(listOf(0, 1), emptyList())
        return listOf(emptyList(), listOf(1, 0))
    }
}