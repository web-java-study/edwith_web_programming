package com.example.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationViewController {
//    @GetMapping("/")
//    public String main() {
//        return "mainpage";
//    }

    @GetMapping("detail")
    public String detail() {
        return "detail";
    }

    @GetMapping("login")
    public String login() {
        return "bookinglogin";
    }

    @GetMapping("mypage")
    public String myPage() {
        return "myreservation";
    }

    @GetMapping("reserve")
    public String reserve() {
        return "reserve";
    }

    @GetMapping("review")
    public String review() {
        return "review";
    }

    @GetMapping("review-write")
    public String reviewWrite() {
        return "reviewWrite";
    }
}
