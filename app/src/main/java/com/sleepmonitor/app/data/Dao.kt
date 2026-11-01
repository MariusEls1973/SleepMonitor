package com.sleepmonitor.app.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepDao {
    @Insert
    suspend fun insertSession(session: SleepSession): Long

    @Update
    suspend fun updateSession(session: SleepSession)

    @Query("SELECT * FROM sleep_sessions WHERE isComplete = 1 ORDER BY startTime DESC")
    fun getAllCompletedSessions(): Flow<List<SleepSession>>

    @Query("SELECT * FROM sleep_sessions WHERE id = :id")
    suspend fun getSessionById(id: Long): SleepSession?

    @Query("SELECT * FROM sleep_sessions WHERE isComplete = 0 LIMIT 1")
    suspend fun getActiveSession(): SleepSession?

    @Query("SELECT * FROM sleep_sessions WHERE isComplete = 1 AND startTime >= :from AND startTime < :to ORDER BY startTime ASC")
    suspend fun getSessionsInRange(from: Long, to: Long): List<SleepSession>

    @Query("DELETE FROM sleep_sessions WHERE id = :id")
    suspend fun deleteSession(id: Long)

    @Insert
    suspend fun insertEpoch(epoch: SleepEpoch)

    @Insert
    suspend fun insertEpochs(epochs: List<SleepEpoch>)

    @Query("SELECT * FROM sleep_epochs WHERE sessionId = :sessionId ORDER BY timestamp ASC")
    fun getEpochsForSession(sessionId: Long): Flow<List<SleepEpoch>>

    @Query("SELECT * FROM sleep_epochs WHERE sessionId = :sessionId ORDER BY timestamp ASC")
    suspend fun getEpochsForSessionOnce(sessionId: Long): List<SleepEpoch>

    @Query("DELETE FROM sleep_epochs WHERE sessionId = :sessionId")
    suspend fun deleteEpochsForSession(sessionId: Long)
}
