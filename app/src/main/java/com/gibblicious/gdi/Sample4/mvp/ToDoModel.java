package com.gibblicious.gdi.Sample4.mvp;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mgibble on 9/29/16.
 */
public class ToDoModel {

    private static final List<String> toDoList = Arrays.asList(
            "Go to Harris Teeter",
            "Wash the car",
            "Buy Grant a birthday present",
            "Pay AmEx bill",
            "Drop off library book",
            "Call mom",
            "change the sheets",
            "get a will",
            "replace the roof",
            "Plan fall break vacation",
            "prepare for intro to Android session 4",
            "simplify your life with fewer lists",
            "deposit check");

    public List<String> getTodoList() {
        return toDoList;
    }

}
