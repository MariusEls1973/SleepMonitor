package com.sleepmonitor.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(tableName = "sleep_sessions")
data class SleepSession(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val startTime: Long,
    val endTime: Long? = null,
    val qualityScore: Float = 0f,
    val totalSleepMinutes: Int = 0,
    val deepMinutes: Int = 0,
    val lightMinutes: Int = 0,
    val awakeMinutes: Int = 0,
    val snoreMinutes: Int = 0,
    val movementIndex: Float = 0f,
    val notes: String = "",
    val isComplete: Boolean = false
)

@Entity(tableName = "sleep_epochs", indices = [Index("sessionId")])
data class SleepEpoch(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val sessionId: Long,
    val timestamp: Long,
    val stage: SleepStage,
    val rms: Float,
    val zcr: Float,
    val snoreScore: Float,
    val movement: Float,
    val isSnoring: Boolean = false
)

enum class SleepStage {
    AWAKE, LIGHT, DEEP
}
