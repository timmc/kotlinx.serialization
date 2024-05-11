package kotlinx.serialization.cbor

import kotlinx.serialization.assertFailsWithMessage
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.HexConverter
import kotlinx.serialization.DuplicateMapKeyException
import kotlin.test.Test
import kotlin.test.assertEquals

class CborStrictModeTest {

    /** Duplicate keys are rejected. */
    @Test
    fun testDuplicateKeys() {
        val duplicateKeys = HexConverter.parseHexBinary("A2617805617806")
        assertFailsWithMessage<DuplicateMapKeyException>("Duplicate keys not allowed in maps") {
            Cbor.decodeFromByteArray<Map<String, Long>>(duplicateKeys)
        }
    }
}
