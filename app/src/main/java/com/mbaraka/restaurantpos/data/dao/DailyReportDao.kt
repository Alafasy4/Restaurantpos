package com.mbaraka.restaurantpos.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mbaraka.restaurantpos.data.entity.DailyReport

@Dao
interface DailyReportDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReport(
        report: DailyReport
    )

    @Update
    suspend fun updateReport(
        report: DailyReport
    )

    @Query("""
        SELECT *
        FROM daily_reports
        WHERE report_date = :date
        LIMIT 1
    """)
    suspend fun getReportByDate(
        date: String
    ): DailyReport?

    @Query("""
        SELECT *
        FROM daily_reports
        ORDER BY report_date DESC
    """)
    fun getAllReports(): LiveData<List<DailyReport>>

    @Query("""
        SELECT *
        FROM daily_reports
        ORDER BY report_date DESC
        LIMIT 1
    """)
    fun getLatestReport(): LiveData<DailyReport?>

    @Query("""
        DELETE FROM daily_reports
    """)
    suspend fun deleteAllReports()

}
