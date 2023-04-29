package com.goit.queries;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@ToString
@AllArgsConstructor
public class YoungestEldestWorkers {
    private String type;
    private String name;
    private LocalDate birthday;

}
