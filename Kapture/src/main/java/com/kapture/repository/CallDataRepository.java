package com.kapture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kapture.entity.CallData;

@Repository
public interface CallDataRepository extends JpaRepository<CallData, Integer>{

    @Query(value = "Select Hour(c.start_time) as start,Count(c) as volume From CallData c Group by Hour(c.start_time) Order by volume Desc")
    List<Object[]> findHighestCallVolumeByHour();
    
    @Query(value = "Select Hour(c.start_time) as start,Sum(c.duration) as dur From CallData c Group by Hour(c.start_time) Order by dur Desc")
    List<Object[]> findLongestCallbyHour();
    
    @Query(value = "Select DayName(c.start_time) as start,Count(c) as volume From CallData c Group by DayName(c.start_time) Order by volume Desc")
    List<Object[]> findHighestCallVolumebyDay();
    
    @Query(value = "Select DayName(c.start_time) as start,Sum(c.duration) as dur From CallData c Group by DayName(c.start_time) Order by dur Desc")
    List<Object[]> findLongestCallbyDay();
    
}
