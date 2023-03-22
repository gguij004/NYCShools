package com.example.nycshools.datasource.remote.api

import com.example.nycshools.datasource.remote.model.SchoolModel
import com.example.nycshools.shared.UIState
import io.mockk.*
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Unit testing for schoolRepositoryImpl
 */
class SchoolRepositoryImplTest {

    /**
     * Initialize MockK
     */
    private val mockServiceApi: SchoolsAPI = mockk(relaxed = true, relaxUnitFun = true)

    private lateinit var testUnitObject: SchoolsRepository


    @Before
    fun setUp() {
        testUnitObject = SchoolRepositoryImpl(mockServiceApi)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    /**
     * Test get all schools
     */
    @Test
    fun `get all schools response is success and a full list is provided returns success state`() =
        runTest {
            /**
             * ASSIGNMENT
             */
            coEvery {
                mockServiceApi.getSchools()
            } returns mockk() {
                every { isSuccessful } returns true
                every { body() } returns listOf(mockk(), mockk(), mockk())

            }
            val states = mutableListOf<UIState<List<SchoolModel>>>()

            /**
             * ACTION
             */
            testUnitObject.getALlSchools().collect {
                states.add(it)

            }
            /**
             * Assertion
             */
            // Expected is size of 2 (Loading then success )
            Assert.assertEquals(2, states.size)
            // Check for loading
            val loading = (states[0] as UIState.LOADING)
            Assert.assertEquals(1, loading)
            // check for success
            val success = (states[1] as UIState.SUCCESS).response
            Assert.assertEquals(1, success.size)
        }
}