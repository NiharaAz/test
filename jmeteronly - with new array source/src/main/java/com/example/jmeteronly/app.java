package com.example.jmeteronly;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
public class app implements CommandLineRunner {
    @Autowired
    DemoApplication demo;

    public app() {
    }

    public static void main(String[] args) {
        SpringApplication.run(app.class);
    }

    public void run(String... args) throws Exception {
        System.out.println("whats the input");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (Objects.equals(input, "p")) {
            this.demo.send_Queue_paxingestion();

            Thread.sleep(500);
           this.demo.SQL_GET_paxingestion();
        } else if (Objects.equals(input, "t")) {
             demo.send_Queue_TPT_ingestion();
            Thread.sleep(500);
           demo.SQL_GET_transportIngestion();
        } else if (Objects.equals(input, "race")){
            this.demo.send_Queue_raceCondition();
            Thread.sleep(500);
            this.demo.SQL_RACE_CONDITION();
        }
        else{
            System.out.println("not pax");
        }

    }
}
