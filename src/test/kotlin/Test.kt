import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File


class PackXORTest {
    private fun assertFileContent(expectedFile: String, actualFile: String): Boolean {
        val expected = File(expectedFile).readLines()
        val actual = File(actualFile).readLines()
        for (i in actual.indices) {
            if (expected[i] != actual[i]) return false
        }
        return expected.size == actual.size
    }

    @Test
    fun keyXOR() {
        assertEquals(134, keyXOR("86", ""))
        assertEquals(255, keyXOR("FF", ""))
        assertEquals(107, keyXOR("6B", ""))
        assertEquals(116, keyXOR("", "74"))
        assertEquals(187, keyXOR("", "BB"))
        assertEquals(172, keyXOR("", "AC"))
        assertEquals(0, keyXOR("34", "324"))
        assertEquals(0, keyXOR("", ""))

    }

    @Test
    fun packXOR() {
        packXOR(149, "out/1_1.txt", "outputnamе.txt")
        assertTrue(assertFileContent("input/1.txt", "outputname.txt"))
        File("outputname.txt").delete()

        packXOR(33, "out/2_1.txt", "outputname.txt")
        assertTrue(assertFileContent("input/2.txt", "outputname.txt"))
        File("outputname.txt").delete()

        packXOR(86, "out/3_1.txt", "outputname.txt")
        assertTrue(assertFileContent("input/3.txt", "outputname.txt"))
        File("outputname.txt").delete()
    }
}
