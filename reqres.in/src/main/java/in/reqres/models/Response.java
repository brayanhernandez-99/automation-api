package in.reqres.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Response {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    ArrayList<User> users = new ArrayList<User>();
    Support support;
}
