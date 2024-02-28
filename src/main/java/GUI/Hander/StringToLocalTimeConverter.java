package GUI.Hander;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khang
 */
public class StringToLocalTimeConverter {
     public static LocalTime stringToLocalTime(String timeString) {
        // Định dạng cho chuỗi thời gian
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Chuyển đổi chuỗi thành LocalTime
        return LocalTime.parse(timeString, formatter);
    }

     public static void main(String[] args) {
        String timeString = "10:15:30";

        // Chuyển đổi chuỗi thành LocalTime với định dạng "HH:mm:ss"
        LocalTime localTime = stringToLocalTime(timeString);

        System.out.println("LocalTime: " + localTime);
    }
}
