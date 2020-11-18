package com.jw.myproject.pattern.delegate.simple;

import java.util.HashMap;
import java.util.Map;

public class Leader {

    Map<String, IEmployee> delegate = new HashMap<>();

    public Leader() {
        delegate.put("架构", new EmployeeA());
        delegate.put("加密", new EmployeeB());
    }

    public void doing(String commond) {
        delegate.get(commond).doing(commond);
    }
}
