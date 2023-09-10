package com.example.demo1;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static List<Company> companies = new ArrayList<>();

    static {
        Company company = new Company();
        company.setName("Google");
        Company company1 = new Company();
        company1.setName("Youtube");
        companies.add(company);
        companies.add(company1);
    }
    public void add(Company company) {
        companies.add(company);
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
