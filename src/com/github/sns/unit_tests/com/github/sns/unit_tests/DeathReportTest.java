//package com.github.sns.unit_tests;
//
//import edu.uah.cs.cs321.braden.DeathReport;
//import org.junit.jupiter.api.Test;
//
//import java.util.stream.IntStream;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * Test Class for com.github.sns.unit_tests.DeathReport Class
// *
// * @author Gavin Mullis
// */
//class DeathReportTest {
//    int[] years;
//    int[] ages;
//    CauseOfDeath predation;
//    CauseOfDeath starvation;
//    DeathReport deathReport;
//    DeathReport otherDeathReport;
//
//    /**
//     * Before each test, create two Death Reports, two ranges for integers, and two enumerations.
//     */
//    @org.junit.jupiter.api.BeforeEach
//    public void beforeEach() {
//        years = IntStream.rangeClosed(1, 100).toArray();
//        ages  = IntStream.rangeClosed(1, 100).toArray();
//        predation = CauseOfDeath.PREDATION;
//        starvation = CauseOfDeath.STARVATION;
//        deathReport = new DeathReport();
//        otherDeathReport = new DeathReport();
//    }
//
//    /**
//     * Tests getters and setters for year variable
//     */
//    void yearTest()
//    {
//        for(Integer i : years) {
//            deathReport.setYear(i);
//            assertEquals(deathReport.getYear(), i);
//        }
//    }
//
//    /**
//     * Tests getters and setters for age variable
//     */
//    void ageTest()
//    {
//        for(Integer i : ages) {
//            deathReport.setAge(i);
//            assertEquals(deathReport.getAge(), i);
//        }
//    }
//
//    /**
//     * Tests getters and setters for Cause of Death
//     */
//    void causeTest()
//    {
//        deathReport.setCause(predation);
//        assertEquals(predation, deathReport.getCause());
//
//        otherDeathReport.setCause(starvation);
//        assertEquals(starvation, otherDeathReport.getCause());
//    }
//
//    @org.junit.jupiter.api.Test
//    void getYear() {
//        yearTest();
//    }
//
//    @org.junit.jupiter.api.Test
//    void setYear() {
//        yearTest();
//    }
//
//    @org.junit.jupiter.api.Test
//    void getAge() {
//        ageTest();
//    }
//
//    @org.junit.jupiter.api.Test
//    void setAge() {
//        ageTest();
//    }
//
//    @org.junit.jupiter.api.Test
//    void getCause() {
//        causeTest();
//    }
//
//    @org.junit.jupiter.api.Test
//    void setCause() {
//        causeTest();
//    }
//}