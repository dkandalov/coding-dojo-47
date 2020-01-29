import org.junit.jupiter.api.Test

class HelloTests {
    @Test fun `2 blocks - move 1 onto 2`() {
        val blocks = Blocks().move(from = 0, to = 1)
        assert(blocks[0] == emptyList<Int>())
        assert(blocks[1] == listOf(1, 0))
        assert(blocks.size == 2)
    }

    @Test fun `2 blocks - move 2 onto 1`() {
        val blocks = Blocks().move(from = 1, to = 0)
        assert(blocks[0] == listOf(0, 1))
        assert(blocks[1] == emptyList<Int>())
        assert(blocks.size == 2)
    }

    @Test fun `2 blocks - move 1 onto 1`() {
        val blocks = Blocks().move(from = 0, to = 0)
        assert(blocks[0] == listOf(0))
        assert(blocks[1] == listOf(1))
        assert(blocks.size == 2)
    }

    @Test fun `3 blocks - move 1 onto 1`() {
        val blocks = Blocks(3).move(from = 0, to = 0)
        assert(blocks[0] == listOf(0))
        assert(blocks[1] == listOf(1))
        assert(blocks[2] == listOf(2))
        assert(blocks.size == 3)
    }

    @Test fun `3 blocks - move 1 onto 2`() {
        val blocks = Blocks(3).move(from = 0, to = 1)
        assert(blocks[0] == emptyList<Int>())
        assert(blocks[1] == listOf(1, 0))
        assert(blocks[2] == listOf(2))
        assert(blocks.size == 3)
    }
}

class Blocks(
    private val size: Int = 2,
    private val state: List<List<Int>> = List(size) { listOf(it) }
) {
    fun move(from: Int, to: Int): List<List<Int>> {
        if (from == to) return state
        if (from > to) return listOf(listOf(0, 1), emptyList())

        return state.map { stack ->
            if (stack.contains(from)) stack - from
            else if (stack.contains(to)) stack + from
            else stack
        }
    }
}