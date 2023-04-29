package com.goit.queries;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class MaxProjectCountClient {

    private String name;
    private int projectCount;

    public MaxProjectCountClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }
}

