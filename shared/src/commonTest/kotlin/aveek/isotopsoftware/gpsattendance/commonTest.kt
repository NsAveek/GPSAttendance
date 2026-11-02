package aveek.isotopsoftware.gpsattendance

import aveek.isotopsoftware.gpsattendance.util.Result
import aveek.isotopsoftware.gpsattendance.util.map
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ResultTest {

    @Test
    fun mapTransformsSuccessValue() {
        val result: Result<Int> = Result.Success(2)
        val mapped = result.map { it * 10 }
        assertIs<Result.Success<Int>>(mapped)
        assertEquals(20, mapped.value)
    }

    @Test
    fun mapKeepsError() {
        val error = IllegalStateException("boom")
        val mapped = (Result.Error(error) as Result<Int>).map { it * 10 }
        assertIs<Result.Error>(mapped)
        assertEquals(error, mapped.throwable)
    }
}
